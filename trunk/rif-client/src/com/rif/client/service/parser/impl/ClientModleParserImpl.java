/**
 * 
 */
package com.rif.client.service.parser.impl;

import java.io.InputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.rif.client.service.definition.ClientModelManager;
import com.rif.client.service.definition.ServiceClientModel;
import com.rif.client.service.definition.TransportClientModel;
import com.rif.client.service.parser.IClientModelParser;

/**
 * @author bruce.liu (mailto:jxta.liu@gmail.com)
 * 2011-7-28 下午10:02:20
 */
public class ClientModleParserImpl implements IClientModelParser {
	private DocumentBuilderFactory dbf;
	private DocumentBuilder db;
	private InputStream[] resources;
	
	public ClientModleParserImpl(){
		try {
			init();
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		}
	}
	
	public ClientModleParserImpl(InputStream[] resources){
		this.resources = resources;
		try {
			init();
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		}
	}
	
	private void init() throws ParserConfigurationException{
		dbf = DocumentBuilderFactory.newInstance();
		db = dbf.newDocumentBuilder();
	}

	/* (non-Javadoc)
	 * @see com.rif.client.service.parser.IClientModelParser#parser()
	 */
	@Override
	public void parser() {
		Document doc = null;

		try {
			if (dbf == null || null == db) {
				init();
			}
			if (null != resources) {
				for (InputStream resource : resources) {
					if(null == resource){
						continue;
					}
					doc = db.parse(resource);
					XPathFactory f = XPathFactory.newInstance();
					XPath path = f.newXPath();
					NodeList transportList = (NodeList) path.evaluate("rif-client/transport-refs/transport-ref", doc, XPathConstants.NODESET);
					parserTransportClient(transportList);
				
					NodeList serviceList = (NodeList) path.evaluate("rif-client/service-refs/service-ref", doc, XPathConstants.NODESET);
					parserServiceClient(serviceList);
				}
			}
		} catch (Throwable t) {
			t.printStackTrace();
		}
	}
	

	private void parserTransportClient(NodeList transportList) {
		int length = transportList.getLength();
		for(int i = 0; i < length; i++){
			Node transportClientNode = transportList.item(i);
			
			TransportClientModel transportClientModel = new TransportClientModel();
			
			//parse attribute/
			//id
			NamedNodeMap transportClientNodeAttrs = transportClientNode.getAttributes();
			if(null != transportClientNodeAttrs.getNamedItem("id")){
				transportClientModel.setRefId(transportClientNodeAttrs.getNamedItem("id").getNodeValue());
			}
			//type
			if(null != transportClientNodeAttrs.getNamedItem("type")){
				transportClientModel.setType(transportClientNodeAttrs.getNamedItem("type").getNodeValue());
			}
			//serialize
			if(null != transportClientNodeAttrs.getNamedItem("serializer")){
				transportClientModel.setSerializerType(transportClientNodeAttrs.getNamedItem("serializer").getNodeValue());
			}
			
			//parse sub element
			NodeList transportClientChildList = transportClientNode.getChildNodes();
			for(int j=0;j<transportClientChildList.getLength();j++){
				Node tmpNode = transportClientChildList.item(j);
				if(tmpNode.getNodeType() == Node.ELEMENT_NODE){
					if("url".equals(tmpNode.getNodeName())){
						transportClientModel.setUrl(tmpNode.getFirstChild().getNodeValue());
					}else if("security".equals(tmpNode.getNodeName())){
						if(null != tmpNode.getFirstChild()){
							transportClientModel.setSecurity(tmpNode.getFirstChild().getNodeValue());
						}
					}
				}
			}
			ClientModelManager.INSTANCE.regiesterTrasport(transportClientModel);
		}
	}

	private void parserServiceClient(NodeList serviceList) {

		int length = serviceList.getLength();
		for(int i = 0; i < length; i++){
			Node serviceClientNode = serviceList.item(i);
			
			ServiceClientModel serviceClientModel = new ServiceClientModel();
			
			//parse attribute/
			//id
			NamedNodeMap serviceClientNodeAttrs = serviceClientNode.getAttributes();
			if(null != serviceClientNodeAttrs.getNamedItem("id")){
				serviceClientModel.setRefId(serviceClientNodeAttrs.getNamedItem("id").getNodeValue());
			}
			//parse sub element
			NodeList serviceClientChildList = serviceClientNode.getChildNodes();
			for(int j=0;j<serviceClientChildList.getLength();j++){
				Node tmpNode = serviceClientChildList.item(j);
				if(tmpNode.getNodeType() == Node.ELEMENT_NODE){
					if("service-name".equals(tmpNode.getNodeName())){
						serviceClientModel.setServieName(tmpNode.getFirstChild().getNodeValue());
					}else if("service-version".equals(tmpNode.getNodeName())){
						serviceClientModel.setServiceVersion(tmpNode.getFirstChild().getNodeValue());
					}else if("description".equals(tmpNode.getNodeName())){
						serviceClientModel.setDescription(tmpNode.getFirstChild().getNodeValue());
					}else if("transport-id".equals(tmpNode.getNodeName())){
						serviceClientModel.setTransportId(tmpNode.getFirstChild().getNodeValue());
					}else if("serializer".equals(tmpNode.getNodeName())){
						serviceClientModel.setSerializerType(tmpNode.getFirstChild().getNodeValue());
					}
				}
			}
			ClientModelManager.INSTANCE.regiesterService(serviceClientModel);
		}
	
	}

	/* (non-Javadoc)
	 * @see com.rif.client.service.parser.IClientModelParser#getResources()
	 */
	@Override
	public InputStream[] getResources() {
		return this.resources;
	}

	/* (non-Javadoc)
	 * @see com.rif.client.service.parser.IClientModelParser#setResources(java.io.InputStream[])
	 */
	@Override
	public void setResources(InputStream[] resources) {
		this.resources = resources;
	}

}
