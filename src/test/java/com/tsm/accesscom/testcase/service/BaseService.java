package com.tsm.accesscom.testcase.service;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.core.MediaType;

//import org.apache.log4j.Logger;
import org.apache.wink.client.ClientConfig;
import org.apache.wink.client.ClientResponse;
import org.apache.wink.client.Resource;
import org.apache.wink.client.RestClient;
import org.codehaus.jackson.jaxrs.JacksonJsonProvider;
import org.codehaus.jackson.map.DeserializationConfig;

import com.maxoptra.api.v1.client.TSMClientApplication;
import com.maxoptra.api.v1.enums.RequestType;
import com.maxoptra.api.v1.model.request.ApiRequest;
import com.maxoptra.api.v1.model.request.Orders;
import com.maxoptra.api.v1.model.response.ApiResponse;
import com.tsm.accesscom.testcase.TestObject;

public class BaseService{

    //final static Logger logger = Logger.getLogger(TSMRestClient.class);
    protected TSMClientApplication clientApplication = new TSMClientApplication();
	private String sessionId;
	private ClientResponse clientResponse;
    private Resource resource;
    private RestClient client;
	private ApiResponse apiResponse;
	protected static ApiRequest request;
    
    public BaseService() {
        Set<Object> s = new HashSet<Object>();
        JacksonJsonProvider jsonProvider = new JacksonJsonProvider();
        jsonProvider
                .configure(
                        DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES,
                        false);

        s.add(jsonProvider);
        clientApplication.setSingletons(s);

        ClientConfig config = new ClientConfig()
                .applications(clientApplication);

        client = new RestClient(config);
	}
    
    
	public String getAuthenticate(String restUrl, String purpose){
		resource = client.resource(restUrl);
        resource.accept(MediaType.APPLICATION_XML).contentType(MediaType.APPLICATION_XML);
        clientResponse = resource.post("application.xml");
        apiResponse = (ApiResponse)clientResponse.getEntity(com.maxoptra.api.v1.model.response.ApiResponse.class);
        sessionId = apiResponse.getAuthResponse().getSessionID();
        
		return sessionId;
	}
	
	public ApiResponse saveOrder(String restUrl, String purpose, String sessionId){
		resource = client.resource(restUrl);
        resource.accept(MediaType.APPLICATION_XML).contentType(MediaType.APPLICATION_XML);
        clientResponse = resource.post(ClientResponse.class, getApiRequest(sessionId, RequestType.saveOrder));
        apiResponse = (ApiResponse)clientResponse.getEntity(com.maxoptra.api.v1.model.response.ApiResponse.class);
        
		return apiResponse;
	}
	
	public com.maxoptra.api.v1.model.order.status.response.ApiResponse orderStatus(String restUrl, String purpose, String sessionId){
		resource = client.resource(restUrl);
        resource.accept(MediaType.APPLICATION_XML).contentType(MediaType.APPLICATION_XML);
        clientResponse = resource.post("application.xml");
        com.maxoptra.api.v1.model.order.status.response.ApiResponse apiResponse = (com.maxoptra.api.v1.model.order.status.response.ApiResponse)clientResponse.getEntity(com.maxoptra.api.v1.model.order.status.response.ApiResponse.class);
        
		return apiResponse;
	}
	
	public ApiResponse updateOrder(String restUrl, String purpose, String sessionId){
		resource = client.resource(restUrl);
        resource.accept(MediaType.APPLICATION_XML).contentType(MediaType.APPLICATION_XML);
        request.setSessionID(sessionId);
        clientResponse = resource.post(ClientResponse.class, request);
        apiResponse = (ApiResponse)clientResponse.getEntity(com.maxoptra.api.v1.model.response.ApiResponse.class);
        
		return apiResponse;
	}
	
	public ApiResponse deleteOrder(String restUrl, String purpose, String sessionId, String orderReference){
		resource = client.resource(restUrl);
        resource.accept(MediaType.APPLICATION_XML).contentType(MediaType.APPLICATION_XML);
        
        request = new ApiRequest();
        request.setSessionID(sessionId);
        request.setOrders(getDeleteOrderObject(orderReference));
        clientResponse = resource.post(ClientResponse.class, request);
        apiResponse = (ApiResponse)clientResponse.getEntity(com.maxoptra.api.v1.model.response.ApiResponse.class);
        
        return apiResponse;
	}
	
	public ApiResponse getAOC(String restUrl, String purpose){
		resource = client.resource(restUrl);
        resource.accept(MediaType.APPLICATION_XML).contentType(MediaType.APPLICATION_XML);
        clientResponse = resource.post("application.xml");
        apiResponse = (ApiResponse)clientResponse.getEntity(com.maxoptra.api.v1.model.response.ApiResponse.class);
        
		return apiResponse;
	}
	
	public ApiResponse getVehicleByDate(String restUrl, String purpose){
		resource = client.resource(restUrl);
        resource.accept(MediaType.APPLICATION_XML).contentType(MediaType.APPLICATION_XML);
        clientResponse = resource.post("application.xml");
        apiResponse = (ApiResponse)clientResponse.getEntity(com.maxoptra.api.v1.model.response.ApiResponse.class);
        
		return apiResponse;
	}
	
	public ApiResponse getVehicleByDateAndAOC(String restUrl, String purpose){
		resource = client.resource(restUrl);
        resource.accept(MediaType.APPLICATION_XML).contentType(MediaType.APPLICATION_XML);
        clientResponse = resource.post("application.xml");
        apiResponse = (ApiResponse)clientResponse.getEntity(com.maxoptra.api.v1.model.response.ApiResponse.class);
        
		return apiResponse;
	}
	
	public ApiResponse getScheduleByAOCOnDate(String restUrl, String purpose){
		resource = client.resource(restUrl);
        resource.accept(MediaType.APPLICATION_XML).contentType(MediaType.APPLICATION_XML);
        clientResponse = resource.post("application.xml");
        apiResponse = (ApiResponse)clientResponse.getEntity(com.maxoptra.api.v1.model.response.ApiResponse.class);
        
		return apiResponse;
	}
	
	private ApiRequest getApiRequest(String sessionID, RequestType requestType){
    	TestObject object = new TestObject();
    	
    	request = object.createOrderRequestObject();
    	request.setSessionID(sessionID);
    	
    	return request;
    }
	
	private Orders getDeleteOrderObject(String orderReference){
		TestObject object = new TestObject();
		
		return object.prepareOrderForDelete(orderReference);
	}
}
