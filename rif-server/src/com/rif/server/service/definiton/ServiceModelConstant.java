/**
 *
 */
package com.rif.server.service.definiton;

/**
 * @author bruce.liu (mailto:jxta.liu@gmail.com)
 * 2011-7-18 下午09:08:33
 */
public interface ServiceModelConstant {
	public static final String SERVICE_MODEL_SERVICES = "services";
	public static final String SERVICE_MODEL_SERVICE = "service";
	public static final String SERVICE_MODEL_SERVICE_NAME = "name";
	public static final String SERVICE_MODEL_SERVICE_VERSION = "version";
	public static final String SERVICE_MODEL_SERVICE_SERIALIZER = "serializer";
	public static final String SERVICE_MODEL_SERVICE_DESC = "description";
	public static final String SERVICE_MODEL_SERVICE_TRANSPORT_ID = "transport-id";

	public static final String SERVICE_MODEL_SERVICE_IMPLEMENTS_POJO = "implement.pojo";
	public static final String SERVICE_MODEL_SERVICE_IMPLEMENTS_POJO_CLASS = "class";

	public static final String SERVICE_MODEL_SERVICE_IMPLEMENTS_SPRING = "implement.spring";
	public static final String SERVICE_MODEL_SERVICE_IMPLEMENTS_SPRING_BEAN_ID = "bean-id";

	public static final String SERVICE_MODEL_SERVICE_IMPLEMENTS_BPEL = "implement.bpel";
	public static final String SERVICE_MODEL_SERVICE_IMPLEMENTS_BPEL_PROCESS = "process";
}
