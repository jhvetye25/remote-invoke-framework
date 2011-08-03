/*
 * Copyright 2010 sdp.com, Inc. All rights reserved.
 * sdp.com PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 * creator : liuxiang.bruce
 * create time : 2011-8-2 上午11:22:01
 */
package com.rif.server.service.transport;

import com.rif.server.service.definiton.TransportModel;

public interface ITransportServerFactory {
    boolean accept(String type);
    ITransportServer create(TransportModel model);
}
