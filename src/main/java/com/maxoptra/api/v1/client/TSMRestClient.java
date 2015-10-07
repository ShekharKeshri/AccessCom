package com.maxoptra.api.v1.client;

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
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;

import com.maxoptra.api.v1.enums.HTTP_METHOD;
import com.maxoptra.api.v1.enums.RequestType;
import com.maxoptra.api.v1.model.request.ApiRequest;
import com.maxoptra.api.v1.model.response.Aoc;
import com.maxoptra.api.v1.model.response.ApiResponse;
import com.maxoptra.api.v1.model.response.Location;
import com.maxoptra.api.v1.model.response.Order;
import com.maxoptra.api.v1.model.response.Performer;
import com.maxoptra.api.v1.model.response.Vehicle;
import com.maxoptra.api.v1.objects.PrepareRequestObject;
import com.tsm.accesscom.v1.client.ClientTest;
import com.tsm.accesscom.v1.util.DateFormat;
import com.tsm.accesscom.v1.util.MaxOptraConfigurationReader;

/**
 * this class is used for making Jersey Client Object
 * 
 * @author Shekhar Keshri
 */
public class TSMRestClient {

	//final static Logger logger = Logger.getLogger(TSMRestClient.class);
	
	protected static String sessionId;
	protected ApiRequest request;
	
    /**
     * clientApplication
     */
    protected TSMClientApplication clientApplication = new TSMClientApplication();

    /**
     * client
     */
    protected RestClient client;

    /**
     * instance
     */
    protected static TSMRestClient instance = new TSMRestClient();


    /**
     *  This is the protected constructor is used to JSON provider configuration while 
     *  creating Cantata Rest Client object.
     */
    protected TSMRestClient() {
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

    /**
     * This method is used to get the Cantata Rest Client object.
     * @return returns CantataRestClient object.
     */
    public static TSMRestClient getInstance() {
        return instance;
    }

    /**
     * This method is used to get the Rest Client object.
     * @return The RestClient object.
     */
    public RestClient getClient() {
        return client;
    }
    
    /*
     * This is the main method to run the application.
     */
    public static void main(String[] args){
    	
    TSMRestClient tsmObj = new TSMRestClient();
	
    try{
    	
    System.out.println("authenticate : "+MaxOptraConfigurationReader.getDefaultProperty("maxoptra.url.authenticate"));
    
	//********************Authenticate User*******************************//
	  ApiResponse apiResponse =tsmObj.callRestAPI(MaxOptraConfigurationReader.getDefaultProperty("maxoptra.url.authenticate"), HTTP_METHOD.POST, "Authenticate User", null);
	//*******************************************************************//
	
	//********************Authenticate Schedule*******************************//
	  //ApiResponse apiResponse =tsmObj.callRestAPI(MaxOptraConfigurationReader.getDefaultProperty("maxoptra.url.authenticate.schedule"), HTTP_METHOD.POST, "Authenticate Schedule", null);
	//*******************************************************************//
	
	//********************Save Order**************************************//
	  //apiResponse = tsmObj.callRestAPI(MaxOptraConfigurationReader.getDefaultProperty("maxoptra.url.saveOrder"), HTTP_METHOD.POST, "Save Order", apiResponse);
	//********************************************************************//
	
	
	
	//********************Update Order***********************************//
	//tsmObj.callRestAPI(ConfigurationReader.getDefaultProperty("maxoptra.url.updateOrder"), HTTP_METHOD.POST, "Update Order", apiResponse);
	//*******************************************************************//
	
	
	
	//********************Order Status***********************************//
//	String orderString="";
//	for(Order order : apiResponse.getOrders().getOrder()){
//		if(!orderString.equalsIgnoreCase("")){
//			orderString += "*";
//		}
//		orderString += order.getOrderReference();
//	}
//	tsmObj.callRestAPIForOrderStatus(ConfigurationReader.getDefaultProperty("maxoptra.url.orderStatus")+"?sessionID="+sessionId+"&orders="+orderString, HTTP_METHOD.POST, "Order Status", apiResponse);
	//*******************************************************************//
	
	
	
	
	//*******************Delete Order************************************//
	//tsmObj.callRestAPI(ConfigurationReader.getDefaultProperty("maxoptra.url.deleteOrder"), HTTP_METHOD.POST, "Delete Order", apiResponse);
	//*******************************************************************//
	
	
	
	
	//*******************Area_Of_Controls********************************//
	  //tsmObj.callRestAPI(MaxOptraConfigurationReader.getDefaultProperty("maxoptra.url.getAreaOfControls")+"?sessionID="+sessionId, HTTP_METHOD.POST, "Area_Of_Controls", apiResponse);
	//*******************************************************************//
	
	
	
	
	//*******************Get Vehicles********************************//
	   //tsmObj.callRestAPI(ConfigurationReader.getDefaultProperty("maxoptra.url.getVehicles")+"?sessionID="+sessionId+"&date="+DateFormat.getDateInString(), HTTP_METHOD.POST, "Get_Vehicles", apiResponse);
	//*******************************************************************//
	
	   
	   
	   
	//*******************Get Vehicles_By_Aoc********************************//
	   tsmObj.callRestAPI(MaxOptraConfigurationReader.getDefaultProperty("maxoptra.url.getVehiclesByAoc")+"?sessionID="+sessionId+"&aocID=320&date="+DateFormat.getTodayDateInString(), HTTP_METHOD.POST, "Vehicles_By_Aoc", apiResponse);
	//*******************************************************************//
	
	 
	//*******************Get Schedule_By_AOC_On_Date********************************//
	   //tsmObj.callRestAPI(ConfigurationReader.getDefaultProperty("maxoptra.url.getScheduleByAOCOnDate")+"?sessionID="+sessionId+"&date="+DateFormat.getDateInString()+"&aocID=320", HTTP_METHOD.POST, "Schedule_By_AOC_On_Date", apiResponse);
	//*******************************************************************//
	
	
	
	 //*******************Get Schedule_By_Vehicle_On_Date********************************//
	   //tsmObj.callRestAPI(ConfigurationReader.getDefaultProperty("maxoptra.url.getScheduleByVehicleOnDate")+"?sessionID="+sessionId+"&date="+DateFormat.getDateInString()+"&vehicleID=1175", HTTP_METHOD.POST, "Schedule_By_Vehicle_On_Date", apiResponse);
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
        resource.accept(MediaType.APPLICATION_XML).contentType(MediaType.APPLICATION_XML);
        
        if (purpose.equalsIgnoreCase("Authenticate User") || purpose.equalsIgnoreCase("Area_Of_Controls") || purpose.equalsIgnoreCase("Get_Vehicles") || purpose.equalsIgnoreCase("Vehicles_By_Aoc") || purpose.equalsIgnoreCase("Schedule_By_AOC_On_Date") || purpose.equalsIgnoreCase("Schedule_By_Vehicle_On_Date")) {
            clientResponse = resource.post("application.xml");
        } 
        else if (purpose.equalsIgnoreCase("Save Order") || purpose.equalsIgnoreCase("Update Order")) {
            clientResponse = resource.post(ClientResponse.class, getApiRequest(sessionId, RequestType.saveOrder));
        }else if(purpose.equalsIgnoreCase("Delete Order")){
        	clientResponse = resource.post(ClientResponse.class, getApiRequest(sessionId, RequestType.deleteOrder));
        }else if(purpose.equalsIgnoreCase("Authenticate Schedule")){
        	resource.contentType(MediaType.APPLICATION_FORM_URLENCODED);
        	clientResponse = resource.post("login=tsm.dispatcher&password=456RTYfgh&account=tsm&remember=false");
        }

        System.out.println("**********************************************************************");
        System.out.println(purpose +" >> Status Code : "+ clientResponse.getStatusCode());
        System.out.println("Message : "+clientResponse.getMessage());
        System.out.println("clientResponse : "+clientResponse.toString());
        
        if(!purpose.equalsIgnoreCase("Authenticate Schedule")){
        	apiResponse = (ApiResponse)clientResponse.getEntity(com.maxoptra.api.v1.model.response.ApiResponse.class);
        }else{
        	 JSONParser parser = new JSONParser();
        		
     		Object obj = clientResponse.getEntity(Object.class);
     		
     		JSONArray jsonArray = (JSONArray)obj;
    		
    		//if(logger.isDebugEnabled()){
     		System.out.println("*****************************************************************************************");
     		System.out.println("jsonArray : "+jsonArray.toJSONString());
     		System.out.println("jsonArray length : "+jsonArray.size());
     		System.out.println("jsonArray : "+jsonArray);
    		//}
        	//System.out.println("Envelop : "+envelop.toString());
        }
        System.out.println("response : "+apiResponse.toString());
        
        
        if (purpose.equalsIgnoreCase("Authenticate User")){
        	sessionId = apiResponse.getAuthResponse().getSessionID();
        }else{
        	if(apiResponse.getError()!=null){
//        		if(logger.isDebugEnabled()){
//	    			logger.debug("Error Code : "+apiResponse.getError().getErrorCode());
//	    			logger.debug("Error Message : "+apiResponse.getError().getErrorMessage());
//	    		}
        		System.out.println("Error Code : "+apiResponse.getError().getErrorCode());
        		System.out.println("Error Message : "+apiResponse.getError().getErrorMessage());
        	}else{
        		if(purpose.equalsIgnoreCase("Order Status")){
        			//System.out.println("apiResponse : "+apiResponse.getOrderStatusResponse().getOrders().getOrder()[0].getReferenceNumber());
        		}else if(purpose.equalsIgnoreCase("Area_Of_Controls")){ 
        			for(Aoc aoc : apiResponse.getAreaOfControlResponse().getAocs().getAoc()){
        				System.out.print("Aoc Id: "+aoc.getId());
        				System.out.println("   Aoc Name: "+aoc.getName());
        			}
        		}else if(purpose.equalsIgnoreCase("Get_Vehicles") || purpose.equalsIgnoreCase("Vehicles_By_Aoc")){
        			
        			System.out.println("Units");
        			System.out.print("timeZone : "+apiResponse.getVehiclesResponse().getUnits().getTimeZone());
        			System.out.print("  timeZoneOffset : "+apiResponse.getVehiclesResponse().getUnits().getTimeZoneOffset());
        			System.out.print("  currency : "+apiResponse.getVehiclesResponse().getUnits().getCurrency());
        			System.out.print("  distanceUnits : "+apiResponse.getVehiclesResponse().getUnits().getDistanceUnits());
        			System.out.print("  speedUnits : "+apiResponse.getVehiclesResponse().getUnits().getSpeedUnits());
        			System.out.println("  durationUnits : "+apiResponse.getVehiclesResponse().getUnits().getDurationUnits());
        			
        			for(Vehicle vechicle : apiResponse.getVehiclesResponse().getVehicles().getVehicle()){
        				System.out.println("Vehicle");
        				System.out.print("id : "+vechicle.getId());
        				System.out.print("  name : "+vechicle.getName());
        				System.out.print("  active : "+vechicle.getActive());
        				System.out.print("  driverName : "+vechicle.getDriverName());
        				System.out.print("  driverPhone : "+vechicle.getDriverPhone());
        				System.out.print("  costByDistance : "+vechicle.getCostByDistance());
        				System.out.print("  availabilityStartTime : "+vechicle.getAvailabilityStartTime());
        				System.out.print("  availabilityEndTime : "+vechicle.getAvailabilityEndTime());
        				System.out.println("  aocId : "+vechicle.getAocId());
        			}
        		}else if(purpose.equalsIgnoreCase("Schedule_By_AOC_On_Date") || purpose.equalsIgnoreCase("Schedule_By_Vehicle_On_Date")){
        			System.out.println("Units");
        			//System.out.print("timeZone : "+apiResponse.getScheduleResponse().getUnits().getTimeZone());
        			//System.out.print("  timeZoneOffset : "+apiResponse.getScheduleResponse().getUnits().getTimeZoneOffset());
        			//System.out.print("  currency : "+apiResponse.getScheduleResponse().getUnits().getCurrency());
        			//System.out.print("  distanceUnits : "+apiResponse.getScheduleResponse().getUnits().getDistanceUnits());
        			//System.out.print("  speedUnits : "+apiResponse.getScheduleResponse().getUnits().getSpeedUnits());
        			//System.out.println("  durationUnits : "+apiResponse.getScheduleResponse().getUnits().getDurationUnits());
        			
        			for(Performer performer : apiResponse.getScheduleResponse().getPerformers().getPerformer()){
        				System.out.println("Performer");
        				System.out.println("id : "+performer.getAocId());
        				System.out.println("vehicle : "+performer.getAocId());
        				System.out.println("name : "+performer.getAocId());
        				System.out.println("aocId : "+performer.getAocId());
        				System.out.println("runDay : "+performer.getAocId());
        				System.out.println("planDistance : "+performer.getAocId());
        				System.out.println("planDuration : "+performer.getAocId());
        				System.out.println("runStartTime : "+performer.getAocId());
        				System.out.println("runEndTime : "+performer.getAocId());
        				System.out.println("availabilityStartTime : "+performer.getAocId());
        				System.out.println("availabilityEndTime : "+performer.getAocId());
        				System.out.println("cost : "+performer.getAocId());
        				
                        for(Location location : performer.getLocation()){
        					System.out.println("Location");
        					
        					if(location.getNumber()!=null){
        						System.out.println("number : "+location.getNumber());
        					}
        					
        					System.out.println("locationType : "+location.getNumber());
        					System.out.println("name : "+location.getNumber());
        					System.out.println("address : "+location.getNumber());
        					System.out.println("latitude : "+location.getNumber());
        					System.out.println("longitude : "+location.getNumber());
        					System.out.println("planArrivalTime : "+location.getNumber());
        					System.out.println("planDepartureTime : "+location.getNumber());
        					
        					if(location.getOrder()!=null){
        						System.out.println("Order");
        						System.out.println("orderReference : "+location.getNumber());
        						System.out.println("status : "+location.getNumber());
        						System.out.println("duration : "+location.getNumber());
        						System.out.println("comments : "+location.getNumber());
        						System.out.println("instructions : "+location.getNumber());
        						System.out.println("price : "+location.getNumber());
        					}
        				}
        			}
        		}else{
        			for(Order order : apiResponse.getOrders().getOrder()){
        				System.out.println("apiResponse : "+order);
        			}
        		}
        	}
        }
        
        System.out.println("**********************************************************************");
        
       return apiResponse;
    }
    
    public com.maxoptra.api.v1.model.order.status.response.ApiResponse callRestAPIForOrderStatus(String restUrl, HTTP_METHOD method, String purpose, ApiResponse apiResponse){
    	com.maxoptra.api.v1.model.order.status.response.ApiResponse response;
    	ClientResponse clientResponse = null;
        Resource resource = null;
        RestClient clients = getClient();
        resource = clients.resource(restUrl);
        resource.accept(MediaType.APPLICATION_XML).contentType(MediaType.APPLICATION_XML);
        
        clientResponse = resource.post("application.xml");

        System.out.println("**********************************************************************");
        System.out.println(purpose +" >> Status Code : "+ clientResponse.getStatusCode());
        System.out.println("Message : "+clientResponse.getMessage());
        System.out.println("clientResponse : "+clientResponse.toString());
        
        response = (com.maxoptra.api.v1.model.order.status.response.ApiResponse)clientResponse.getEntity(com.maxoptra.api.v1.model.order.status.response.ApiResponse.class);
        System.out.println("response : "+apiResponse.toString());
        
        //System.out.println("response : "+response.getOrderStatusResponse().getOrders().getOrder()[0].getReferenceNumber());
        
        for(com.maxoptra.api.v1.model.order.status.response.Order order : response.getOrderStatusResponse().getOrders().getOrder()){
			System.out.println("apiResponse : "+order);
		}
        
        System.out.println("**********************************************************************");
        
       return response;
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
    
    
    public void autoSchedule(String cookie){
		ClientResponse clientResponse = null;
        Resource resource = null;
        RestClient clients = getClient();
        resource = clients.resource("http://service.maxoptra.com/gt/gt-api/ctschedule/batchPlanningQueue");
        resource.contentType(MediaType.APPLICATION_JSON);
        
        clientResponse = resource.post("{'startDate':1442860200000, 'endDate':1442946540000, 'aocIds':[320],	'planCollections':true,	'planningStartTime':1442860200000, 'snapshotDate':1442860200000	}");
        resource.header("Cookie", "Cookie : "+cookie);
        System.out.println("**********************************************************************");
        //System.out.println(purpose +" >> Status Code : "+ clientResponse.getStatusCode());
        System.out.println("Message : "+clientResponse.getMessage());
        System.out.println("clientResponse : "+clientResponse.toString());
        
        //response = (com.maxoptra.api.v1.model.order.status.response.ApiResponse)clientResponse.getEntity(com.maxoptra.api.v1.model.order.status.response.ApiResponse.class);
        //System.out.println("response : "+apiResponse.toString());
        
        //System.out.println("response : "+response.getOrderStatusResponse().getOrders().getOrder()[0].getReferenceNumber());
        
//        for(com.maxoptra.api.v1.model.order.status.response.Order order : response.getOrderStatusResponse().getOrders().getOrder()){
//			System.out.println("apiResponse : "+order);
//		}
        
        System.out.println("**********************************************************************");
	}
}
