/**
 * 
 */
package com.rif.common.serializer.impl;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;

import com.rif.common.naming.AbstractNamingObject;
import com.rif.common.serializer.IDataSerializer;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.converters.basic.DateConverter;
import com.thoughtworks.xstream.io.xml.DomDriver;

/**
 * @author bruce.liu (mailto:jxta.liu@gmail.com)
 * 2011-7-16 上午06:37:11
 */
public class XmlDataSerializerImpl extends AbstractNamingObject implements IDataSerializer {
	private XStream xstream = null;
	private Object lock = new Object();
	
	public XmlDataSerializerImpl(){
		this.setName("xml");
	}
	
	public XmlDataSerializerImpl(String name){
		this.setName(name);
	}
	
	private void init(){
		if(null == xstream){
			synchronized (lock) {
				xstream = new XStream(new DomDriver());
				xstream.registerConverter(new DateConverter("yyyy-MM-dd HH:mm:ss.SSS",
			            new String[] {
						"yyyy-MM-dd HH:mm:ss.S z",
		                "yyyy-MM-dd HH:mm:ss.S a",
		                "yyyy-MM-dd HH:mm:ssz", "yyyy-MM-dd HH:mm:ss z",
		                "yyyy-MM-dd HH:mm:ssa" }));
			}
		}
	}

	/* (non-Javadoc)
	 * @see com.rif.common.serializer.IDataSerializer#marshall(java.lang.Object)
	 */
	@Override
	public byte[] marshall(Object obj) {
		init();
		ByteArrayOutputStream baout = new ByteArrayOutputStream();
		OutputStreamWriter writer = null;
		try {
			writer = new OutputStreamWriter(baout, "UTF-8");
			xstream.toXML(obj, baout);
			return baout.toByteArray();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(null != writer){
				try {
					writer.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return null;
	}

	/* (non-Javadoc)
	 * @see com.rif.common.serializer.IDataSerializer#unmarshall(byte[])
	 */
	@Override
	public Object unmarshall(byte[] bytes) {
		init();
		ByteArrayInputStream in = new ByteArrayInputStream(bytes);
		InputStreamReader reader = null;
		
		try {
			reader = new InputStreamReader(in, "UTF-8");
		return	xstream.fromXML(reader);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(null != reader){
				try {
					reader.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		return null;
	}

	@Override
	public int getIndex() {
		return 0;
	}

}
