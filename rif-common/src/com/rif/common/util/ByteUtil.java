/**
 * 
 */
package com.rif.common.util;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author bruce.liu (mailto:jxta.liu@gmail.com)
 * 2011-7-26 下午11:19:31
 */
public class ByteUtil {
	public static byte[] getBytes(InputStream is) throws IOException  {
		byte[] data = new byte[0];

		List<byte[]> list = new ArrayList<byte[]>();
		byte[] buffer = new byte[1024 * 1000];
		int read = -1;
		int size = 0;

		while ((read = is.read(buffer)) != -1) {
			if (read > 0) {
				byte[] tmp = new byte[read];
				System.arraycopy(buffer, 0, tmp, 0, read);
				list.add(tmp);
				size += tmp.length;
			}
		}

		if (size > 0) {
			ByteArrayOutputStream bos = null;
			try {
				bos = new ByteArrayOutputStream(size);
				for (Iterator<byte[]> itr = list.iterator(); itr.hasNext();) {
					byte[] chunk = itr.next();
					bos.write(chunk);
				}
				data = bos.toByteArray();
			} finally {
				if (bos != null) {
					bos.close();
				}
			}
		}
		return data;
	}
}
