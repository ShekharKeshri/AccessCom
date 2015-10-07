package com.tsm.accesscom.v1.client;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;



//import org.apache.log4j.Logger;
import org.apache.wink.client.ClientConfig;
import org.apache.wink.client.ClientResponse;
import org.apache.wink.client.Resource;
import org.apache.wink.client.RestClient;
import org.codehaus.jackson.jaxrs.JacksonJsonProvider;
import org.codehaus.jackson.map.DeserializationConfig;
import org.json.simple.JSONObject;

import com.maxoptra.api.v1.client.TSMClientApplication;
import com.maxoptra.api.v1.client.TSMRestClient;
import com.maxoptra.api.v1.enums.HTTP_METHOD;
import com.maxoptra.api.v1.model.request.ApiRequest;
import com.maxoptra.api.v1.model.response.ApiResponse;
import com.tsm.accesscom.v1.util.DateFormat;
import com.tsm.accesscom.v1.util.MaxOptraConfigurationReader;

public class Test {

	//final static Logger logger = Logger.getLogger(TSMRestClient.class);
	
	protected static String sessionId;
	protected ApiRequest request;
    protected TSMClientApplication clientApplication = new TSMClientApplication();
    protected RestClient client;
    protected static Test instance = new Test();
    protected Test() {
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

    public static Test getInstance() {
        return instance;
    }

    public RestClient getClient() {
        return client;
    }
    
    public static void main(String[] args){
    	Test tsmObj = new Test();
	
    try{
    	
    //System.out.println("authenticate : "+MaxOptraConfigurationReader.getDefaultProperty("maxoptra.url.authenticate"));
    
	//********************Authenticate User*******************************//
	  //ApiResponse apiResponse =tsmObj.callRestAPI(MaxOptraConfigurationReader.getDefaultProperty("maxoptra.url.authenticate"), HTTP_METHOD.POST, "Authenticate User", null);
	//*******************************************************************//
	
	//********************Authenticate Schedule*******************************//
	  ApiResponse apiResponse =tsmObj.callRestAPI(MaxOptraConfigurationReader.getDefaultProperty("maxoptra.url.authenticate.schedule"), HTTP_METHOD.POST, "Authenticate Schedule", null);
	//*******************************************************************//

    }catch(Exception e){
    	e.printStackTrace();
//    	if(logger.isDebugEnabled()){
//			logger.debug("Exception ........................."+ e.getMessage());
//		}
    }
    
    }
    
    public ApiResponse callRestAPI(String restUrl, HTTP_METHOD method, String purpose, ApiResponse apiResponse){
        ClientResponse clientResponse = null;
        Resource resource = null;
        RestClient clients = getClient();
        
        System.out.println("rest url : "+restUrl);
        
        resource = clients.resource(restUrl);
        
        if (purpose.equalsIgnoreCase("Authenticate User") || purpose.equalsIgnoreCase("Area_Of_Controls") || purpose.equalsIgnoreCase("Get_Vehicles") || purpose.equalsIgnoreCase("Vehicles_By_Aoc") || purpose.equalsIgnoreCase("Schedule_By_AOC_On_Date") || purpose.equalsIgnoreCase("Schedule_By_Vehicle_On_Date")) {
        	resource.accept(MediaType.APPLICATION_XML).contentType(MediaType.APPLICATION_XML);
        	clientResponse = resource.post("application.xml");
        }else if(purpose.equalsIgnoreCase("Authenticate Schedule")){
        	resource.accept(MediaType.APPLICATION_JSON).contentType("application/x-www-form-urlencoded");
        	clientResponse = resource.post("login=tsm.dispatcher&password=456RTYfgh&account=tsm&remember=false");
        }

        System.out.println("**********************************************************************");
        System.out.println(purpose +" >> Status Code : "+ clientResponse.getStatusCode());
        System.out.println("Message : "+clientResponse.getMessage());
        System.out.println("clientResponse : "+clientResponse.toString());
        
        
        
        if(!purpose.equalsIgnoreCase("Authenticate Schedule")){
        	apiResponse = (ApiResponse)clientResponse.getEntity(com.maxoptra.api.v1.model.response.ApiResponse.class);
        }else{
        		
        	 JSONObject innerObj = clientResponse.getEntity(JSONObject.class);
        	 MultivaluedMap<String, String>  map = resource.get().getHeaders();
      		
//        	 System.out.println("map length "+map.size());
//        	 Iterator itr = map.entrySet().iterator();
        	 
        	 String cookie = ""; 
        	 
        	 for (Map.Entry<String,List<String>> entry : map.entrySet())
        	 {
        	     //System.out.println("app : "+entry.getKey() + "/" + entry.getValue().get(0));
        	     
        	     if(entry.getKey() !=null && entry.getKey().equals("Set-Cookie")){
        	    	 System.out.println("key : "+entry.getKey());
	        	     for(String str : entry.getValue()){
	        	    	 str = str.substring(0,str.indexOf("path=/")); 
		                    cookie = cookie + str; 
	        	    	 	 //System.out.println("value : "+str);
	        	     }
        	     }
        	     
        	 }
        	 
        	 System.out.println("Cookie : "+cookie);
        	 
        	 System.out.println("innerObj : "+innerObj.toJSONString());
        	 
        	String domain = "service.maxoptra.com"; 
        	long startDate = DateFormat.getEarlyMorningTimeStamp(); 
 	        long endDate = startDate + 24 * 60 * 60 * 1000 - 1000; // 23:59:59 
        	 
        }
        
        
        if (purpose.equalsIgnoreCase("Authenticate User")){
        	sessionId = apiResponse.getAuthResponse().getSessionID();
        }
        
        callRestAPI2(restUrl, method, purpose, apiResponse);
        
        System.out.println("**********************************************************************");
        
       return apiResponse;
    }
    
    public void callRestAPI2(String restUrl, HTTP_METHOD method, String purpose, ApiResponse apiResponse){
        ClientResponse clientResponse = null;
        Resource resource = null;
        RestClient clients = getClient();
        
        System.out.println("rest url : "+restUrl);
        
        resource = clients.resource(restUrl);
        
        
        long startDate = DateFormat.getEarlyMorningTimeStamp(); 
        long endDate = startDate + 24 * 60 * 60 * 1000 - 1000; // 23:59:59 
        
        String urlParameters = String.format("{\"startDate\":%d, \"endDate\":%d," + 
                "\"aocIds\":[%s]," + 
                "\"planCollections\":true," + 
                "\"planningStartTime\":%d," + 
                "\"snapshotDate\":%d" + 
                "}", 
        startDate, endDate, 
        "320", 
        new Date().getTime(), 
        startDate);
        
        
        resource.accept(MediaType.APPLICATION_JSON).contentType("application/x-www-form-urlencoded");
    	clientResponse = resource.post(urlParameters);
        
        System.out.println("clientResponse : "+clientResponse.getStatusCode());
    }
    
    private static void runBatchPlanning(String domain, String cookie, String aoc, long startDate, long endDate) { 
        
    	System.out.println("******************************************************************");
    	System.out.println("cookie : "+cookie);
    	System.out.println("startDate : "+startDate);
    	System.out.println("endDate : "+endDate);
    	System.out.println("******************************************************************");
    	
    	
    	HttpURLConnection connection = null; 

        try { 
            String contentType = "application/json"; 
            String urlParameters = String.format("{\"startDate\":%d, \"endDate\":%d," + 
                            "\"aocIds\":[%s]," + 
                            "\"planCollections\":true," + 
                            "\"planningStartTime\":%d," + 
                            "\"snapshotDate\":%d" + 
                            "}", 
                    startDate, endDate, 
                    aoc, 
                    new Date().getTime(), 
                    startDate); 
            URL url = new URL("http://" + domain + "/gt/gt-api/ctschedule/batchPlanningQueue"); 

            connection = createConnection(contentType, urlParameters, url); 
            connection.setRequestProperty("Cookie", cookie); 

            sendRequest(connection, urlParameters); 

        } catch (Exception e) { 
            e.printStackTrace(); 
            System.out.println("ERROR"); 
        } finally { 
            if (connection != null) { 
                connection.disconnect(); 
            } 
        } 
    } 
    
    private static HttpURLConnection createConnection(String contentType, String urlParameters, URL url) throws IOException { 
        HttpURLConnection connection = (HttpURLConnection) url.openConnection(); 
        connection.setRequestMethod("POST"); 
        connection.setRequestProperty("Content-Type", contentType); 

        connection.setRequestProperty("Content-Length", Integer.toString(urlParameters.getBytes().length)); 
        connection.setRequestProperty("Content-Language", "en-US"); 

        connection.setUseCaches(false); 
        connection.setDoInput(true); 
        connection.setDoOutput(true); 
        return connection; 
    } 

    private static void sendRequest(HttpURLConnection connection, String urlParameters) throws IOException { 
        DataOutputStream wr = new DataOutputStream( 
                connection.getOutputStream()); 
        wr.writeBytes(urlParameters); 
        wr.flush(); 
        wr.close(); 

        connection.getResponseMessage(); 
    } 
    
}
