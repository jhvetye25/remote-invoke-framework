/**
 *
 */
package com.rif.client.service.stub.impl;

import com.rif.client.service.definition.ClientModelManager;
import com.rif.client.service.definition.ServiceClientModel;
import com.rif.client.service.definition.TransportClientModel;
import com.rif.client.service.stub.IServiceStub;
import com.rif.client.service.transport.ITransportClient;
import com.rif.client.service.transport.TransportProvider;
import com.rif.common.request.IServiceRequest;
import com.rif.common.response.IServiceResponse;
import com.rif.common.serializer.DataSerializerProvider;
import com.rif.common.serializer.IDataSerializer;

/**
 * @author bruce.liu (mailto:jxta.liu@gmail.com)
 * 2011-7-29 下午03:06:01
 */
public class ServiceStubImpl implements IServiceStub {
	private String refId;
	private ServiceClientModel serviceClientModel;
	private TransportClientModel transportClientModel;
	private ITransportClient transport;

	public ServiceStubImpl(String refId){
		this.refId = refId;
		this.serviceClientModel = ClientModelManager.INSTANCE.getServiceClientModel(refId);
		this.transportClientModel = ClientModelManager.INSTANCE.getTransportClientModel(this.serviceClientModel.getTransportId());
		this.transport = TransportProvider.INSTANCE.provider(transportClientModel);
	}

	public ServiceStubImpl(ServiceClientModel serviceClientModel){
		this.serviceClientModel = serviceClientModel;
		this.refId = serviceClientModel.getRefId();
		this.transportClientModel = ClientModelManager.INSTANCE.getTransportClientModel(this.serviceClientModel.getTransportId());
		this.transport = TransportProvider.INSTANCE.provider(transportClientModel);
	}

	/* (non-Javadoc)
	 * @see com.rif.client.service.stub.IServiceStub#execute(com.rif.common.request.IServiceRequest)
	 */
	@Override
	public IServiceResponse execute(IServiceRequest request) {
		IDataSerializer serializer = DataSerializerProvider.INSTANCE.provider(request.getSerializerType());
		byte[] message = serializer.marshall(request);
		byte[] resposeMessage = null;
		try {
			resposeMessage = transport.transport(this.transportClientModel, request, message);
			IServiceResponse response = (IServiceResponse)serializer.unmarshall(resposeMessage);
			return response;
		} catch (Throwable e) {
			e.printStackTrace();
			throw new RuntimeException("make error when execute service" + request.getServiceName(), e);
		}
	}

	@Override
	public String getRefId() {
		return this.refId;
	}

	public ServiceClientModel getServiceClientModel() {
		return serviceClientModel;
	}

	public void setServiceClientModel(ServiceClientModel serviceClientModel) {
		this.serviceClientModel = serviceClientModel;
	}

	public void setRefId(String refId) {
		this.refId = refId;
	}

	public TransportClientModel getTransportClientModel() {
		return transportClientModel;
	}

	public void setTransportClientModel(TransportClientModel transportClientModel) {
		this.transportClientModel = transportClientModel;
	}

	public ITransportClient getTransport() {
		return transport;
	}

	public void setTransport(ITransportClient transport) {
		this.transport = transport;
	}

}
