package com.tsm.accesscom.v1.service.impl;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.core.MediaType;


import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;


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
import com.maxoptra.api.v1.model.response.ApiResponse;
import com.maxoptra.api.v1.objects.PrepareRequestObject;
import com.tsm.accesscom.v1.client.ClientTest;
import com.tsm.accesscom.v1.service.BaseService;

public class BaseServiceImpl implements BaseService{

    //final static Logger logger = Logger.getLogger(TSMRestClient.class);
    protected TSMClientApplication clientApplication = new TSMClientApplication();
	private String sessionId;
	private ClientResponse clientResponse;
    private Resource resource;
    private RestClient client;
	private ApiResponse apiResponse;
	protected ApiRequest request;
    
    public BaseServiceImpl() {
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
	
	private ApiRequest getApiRequest(String sessionID, RequestType requestType){
    	ClientTest clientTest = new ClientTest();
    	
    	request = clientTest.doOtherTest();
    	
    	//request = new ApiRequest();
    	request.setSessionID(sessionID);
    	
    	if(requestType.equals(RequestType.saveOrder)){
    		//request.setOrders(PrepareRequestObject.prepareOrders());
    		
        	JAXBContext jaxbContext;
    		try {
    			jaxbContext = JAXBContext.newInstance(ApiRequest.class);
    			Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
    
    			// output pretty printed
    			jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
    			jaxbMarshaller.marshal(request, System.out);
    			
    		} catch (JAXBException e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
//    			if(logger.isDebugEnabled()){
//	    			logger.debug("Exception ........................."+ e.getMessage());
//	    		}
    		}
    	}
    	else if(requestType.equals(RequestType.updateOrder)){
    		request.setOrders(PrepareRequestObject.prepareOrders());
    	}
    	else if(requestType.equals(RequestType.deleteOrder)){
    		request.setOrders(PrepareRequestObject.prepareDeleteOrders());
    	}
    	
    	return request;
    }
}
