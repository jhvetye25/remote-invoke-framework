/**
 *
 */
package com.rif.server.service.parser.impl;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.rif.common.impl.ServiceEndpointImpl;
import com.rif.server.service.definiton.ServiceImplementModel;
import com.rif.server.service.definiton.ServiceModel;
import com.rif.server.service.definiton.ServiceModelConstant;
import com.rif.server.service.definiton.ServiceModelManager;
import com.rif.server.service.definiton.TransportModel;
import com.rif.server.service.definiton.TransportModelManager;
import com.rif.server.service.manager.ServiceEndpointManagerFactory;
import com.rif.server.service.parser.IServiceModelParser;

/**
 * @author bruce.liu (mailto:jxta.liu@gmail.com)
 * 2011-7-19 下午09:31:47
 */
public class ServiceModelParserImpl implements IServiceModelParser{
	private DocumentBuilderFactory dbf;
	private DocumentBuilder db;
	private InputStream[] resources;

	public ServiceModelParserImpl(){
		try {
			init();
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		}
	}

	public ServiceModelParserImpl(InputStream[] resources){
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

	public void parser() {
		List<ServiceModel> serviceModels = new ArrayList<ServiceModel>();
		Document doc = null;

		try {
			if (dbf == null || null == db) {
				init();
			}
			if (null != resources) {
			    for (InputStream resource : resources) {
                    if(null != resource){
                        doc = db.parse(resource);
                        parseTransport(doc);
                        List<ServiceModel> tmpServiceModels = parserService(doc);
                        serviceModels.addAll(tmpServiceModels);
                    }
                }
			}
		} catch (Throwable t) {
			t.printStackTrace();
		}

		ServiceModelManager.INSTANCE.register(serviceModels);
        for(ServiceModel serviceModel: serviceModels){
            ServiceEndpointManagerFactory.INSTANCE.getServiceManager().register(serviceModel.getServiceEndpoint());
        }
	}

	private void parseTransport(Document doc) throws XPathExpressionException{
	    XPathFactory f = XPathFactory.newInstance();
        XPath path = f.newXPath();
        NodeList transportList = (NodeList) path.evaluate("rif-server/transports/transport",
                doc, XPathConstants.NODESET);
        int length = transportList.getLength();
        for(int i = 0;i< length; i++){
            TransportModel transportModel = new TransportModel();
            Node transportNode = transportList.item(i);
            NamedNodeMap transportNodeAttrs = transportNode.getAttributes();
            if(null != transportNodeAttrs.getNamedItem("id")){
                transportModel.setId(transportNodeAttrs.getNamedItem("id").getNodeValue());
            }
            if(null != transportNodeAttrs.getNamedItem("type")){
                transportModel.setType(transportNodeAttrs.getNamedItem("type").getNodeValue());
            }

            NodeList transportChildList = transportNode.getChildNodes();
            for(int j=0;j<transportChildList.getLength();j++){
                Node tmpNode = transportChildList.item(j);
                if(tmpNode.getNodeType() == Node.ELEMENT_NODE){
                    if("url".equals(tmpNode.getNodeName())){
                        if(null != tmpNode.getFirstChild()){
                            transportModel.setUrl(tmpNode.getFirstChild().getNodeValue());
                        }
                    }
                }
            }
            TransportModelManager.INSTANCE.register(transportModel);
        }
	}
	private List<ServiceModel> parserService(Document doc) throws XPathExpressionException {
		List<ServiceModel> serviceModelList = new ArrayList<ServiceModel>();
		XPathFactory f = XPathFactory.newInstance();
		XPath path = f.newXPath();
		NodeList serviceList = (NodeList) path.evaluate("rif-server/services/service",
				doc, XPathConstants.NODESET);
		int length = serviceList.getLength();
		for (int i = 0; i < length; i++) {
			ServiceModel serviceModel = new ServiceModel();
			ServiceEndpointImpl serviceEndpoint = new ServiceEndpointImpl();
			ServiceImplementModel serviceImplementModel = new ServiceImplementModel();
			Node serviceNode = serviceList.item(i);
			//build service attribute
			NamedNodeMap serviceNodeAttrs = serviceNode.getAttributes();
			if(null != serviceNodeAttrs.getNamedItem(ServiceModelConstant.SERVICE_MODEL_SERVICE_NAME)){
				serviceEndpoint.setServiceName(serviceNodeAttrs.getNamedItem(ServiceModelConstant.SERVICE_MODEL_SERVICE_NAME).getNodeValue());
			}
			if(null != serviceNodeAttrs.getNamedItem(ServiceModelConstant.SERVICE_MODEL_SERVICE_VERSION)){
				serviceEndpoint.setServiceVersion(serviceNodeAttrs.getNamedItem(ServiceModelConstant.SERVICE_MODEL_SERVICE_VERSION).getNodeValue());
			}
			if(null != serviceNodeAttrs.getNamedItem(ServiceModelConstant.SERVICE_MODEL_SERVICE_SERIALIZER)){
				serviceEndpoint.setSerializerType(serviceNodeAttrs.getNamedItem(ServiceModelConstant.SERVICE_MODEL_SERVICE_SERIALIZER).getNodeValue());
			}
			//build service element
			NodeList serviceChildList = serviceNode.getChildNodes();
			for(int j=0;j<serviceChildList.getLength();j++){
				Node tmpNode = serviceChildList.item(j);
				if(tmpNode.getNodeType() == Node.ELEMENT_NODE){
					if(ServiceModelConstant.SERVICE_MODEL_SERVICE_DESC.equals(tmpNode.getNodeName())){
					    if(null != tmpNode.getFirstChild()){
					        serviceEndpoint.setDescription(tmpNode.getFirstChild().getNodeValue());
					    }
					}
					else if(ServiceModelConstant.SERVICE_MODEL_SERVICE_TRANSPORT_ID.equals(tmpNode.getNodeName())){
					    if(null != tmpNode.getFirstChild()){
					        serviceEndpoint.setTransportID(tmpNode.getFirstChild().getNodeValue());
					    }
					}
					else{
						String tmpNodeName = tmpNode.getNodeName();
						if(null != tmpNodeName){
							if(tmpNodeName.indexOf(".") > -1){
								serviceImplementModel.setType(tmpNodeName.substring(tmpNodeName.lastIndexOf(".")+1, tmpNodeName.length()));
							}else{
								serviceImplementModel.setType(tmpNodeName);
							}
							NamedNodeMap tmpNodeAttrs = tmpNode.getAttributes();
							for(int k=0;k<tmpNodeAttrs.getLength();k++){
								serviceImplementModel.addAttribute(tmpNodeAttrs.item(k).getNodeName(), tmpNodeAttrs.item(k).getNodeValue());
							}
						}
					}
				}
			}

			serviceModel.setServiceEndpoint(serviceEndpoint);
			serviceModel.setServiceImplementModel(serviceImplementModel);
			serviceModelList.add(serviceModel);
		}
		return serviceModelList;
	}

	public InputStream[] getResources() {
		return resources;
	}

	public void setResources(InputStream[] resources) {
		this.resources = resources;
	}
}