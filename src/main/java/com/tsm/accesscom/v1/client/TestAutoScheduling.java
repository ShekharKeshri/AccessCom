package com.tsm.accesscom.v1.client;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

import javax.ws.rs.core.MediaType;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import com.maxoptra.api.v1.enums.RequestType;
import com.maxoptra.api.v1.model.request.ApiRequest;
import com.maxoptra.api.v1.model.response.Aoc;
import com.maxoptra.api.v1.model.response.ApiResponse;
import com.maxoptra.api.v1.model.response.Order;
import com.maxoptra.api.v1.objects.PrepareRequestObject;
import com.tsm.accesscom.v1.util.DateFormat;

public class TestAutoScheduling implements Serializable{

	protected ApiRequest request;
	private static String sessionId = null;
	
	    public static void main(String[] args) { 
	        TimeZone.setDefault(TimeZone.getTimeZone("UTC")); 

	        String login = "tsm.dispatcher"; 
	        String password = "456RTYfgh"; 
	        String account = "tsm"; 
	        String domain = "service.maxoptra.com"; 

	        long startDate = DateFormat.getEarlyMorningTimeStamp(); 
	        long endDate = startDate + 24 * 60 * 60 * 1000 - 1000; // 23:59:59 

	        String sessionId = auth(login, password, account, domain); 
	        saveOrder(login, password, account, domain);
	        
	        //String cookie = getCookie(login, password, account, domain); 
	        //List<String> aocs = getAocs(sessionId, domain); 

	        //System.out.println("aocs.get(0) : "+aocs.get(0));
	        
	        //runBatchPlanning(domain, cookie, aocs.get(0), startDate, endDate); 
	    } 

	    public static String autoSchedule() { 
	        TimeZone.setDefault(TimeZone.getTimeZone("UTC")); 

	        String login = "tsm.dispatcher"; 
	        String password = "456RTYfgh"; 
	        String account = "tsm"; 
	        String domain = "service.maxoptra.com"; 

	        long startDate = DateFormat.getEarlyMorningTimeStamp(); 
	        long endDate = startDate + 24 * 60 * 60 * 1000 - 1000; // 23:59:59 

	        String sessionId = auth(login, password, account, domain); 
	        String cookie = getCookie(login, password, account, domain); 
	        List<String> aocs = getAocs(sessionId, domain); 

	        System.out.println("aocs.get(0) : "+aocs.get(0));
	        
	        runBatchPlanning(domain, cookie, aocs.get(0), startDate, endDate); 
	        
	        return "Successful Order Schedule.";
	    }
	    
	    public static String auth(String login, String password, String account, final String domain) { 
	        HttpURLConnection connection = null; 

	        String sessionId = null; 

	        try { 
	            String urlParameters = String.format("accountID=%s&user=%s&password=%s", account, login, password); 
	            String contentType = "application/x-www-form-urlencoded"; 
	            URL url = new URL("http://" + domain + "/rest/2/authentication/createSession?"); 

	            connection = createConnection(contentType, urlParameters, url); 

	            sendRequest(connection, urlParameters); 

	            JAXBContext jaxbContext = JAXBContext.newInstance(ApiResponse.class);
	            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
	            ApiResponse jsonMap=null;

	            jsonMap = (ApiResponse) unmarshaller.unmarshal(connection.getInputStream());
	            
	            sessionId = jsonMap.getAuthResponse().getSessionID();
	            System.out.println("sessionId : "+sessionId);
	            
	        } catch (Exception e) { 
	            e.printStackTrace(); 
	            System.out.println("ERROR"); 
	        } finally { 
	            if (connection != null) { 
	                connection.disconnect(); 
	            } 
	        } 
	        return sessionId; 
	    } 
	    
	    private static String saveOrder(String login, String password, String account, final String domain) { 
	        HttpURLConnection connection = null; 

	        try { 
	            String urlParameters = ""; 
	            String contentType = MediaType.APPLICATION_XML; // resource.accept(MediaType.APPLICATION_XML).contentType(MediaType.APPLICATION_XML);
	            URL url = new URL("http://" + domain + "/rest/2/engineers-api/orders/save"); 

	            connection = createConnection(contentType, urlParameters, url); 

	            sendRequestObject(connection, urlParameters); 

	            JAXBContext jaxbContext = JAXBContext.newInstance(ApiResponse.class);
	            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
	            ApiResponse jsonMap=null;

	            jsonMap = (ApiResponse) unmarshaller.unmarshal(connection.getInputStream());
	            
	            sessionId = jsonMap.getAuthResponse().getSessionID();
	            System.out.println("sessionId : "+sessionId);
	            
	        } catch (Exception e) { 
	            e.printStackTrace(); 
	            System.out.println("ERROR"); 
	        } finally { 
	            if (connection != null) { 
	                connection.disconnect(); 
	            } 
	        } 
	        return sessionId; 
	    } 

	    public static String getCookie(String login, String password, String account, final String domain) { 
	        HttpURLConnection connection = null; 

	        String cookie = ""; 

	        try { 
	            String contentType = "application/x-www-form-urlencoded"; 
	            String urlParameters = String.format("login=%s&password=%s&account=%s&remember=false", login, password, account); 
	            URL url = new URL("http://" + domain + "/gt/gt-api/auth/login?"); 

	            connection = createConnection(contentType, urlParameters, url); 

	            sendRequest(connection, urlParameters); 

	            //Get Cookie 
	            List<String> cookies = connection.getHeaderFields().get("Set-Cookie"); 
	            for (String s : cookies) { 
	                //if (s.contains("MAXOPTRA_SESS") || s.contains("JSESSIONID")) { 
	                    s = s.substring(0,s.indexOf("path=/")); 
	                    cookie = cookie + s; 
	                //} 
	            } 
	        } catch (Exception e) { 
	            e.printStackTrace(); 
	            System.out.println("ERROR"); 
	        } finally { 
	            if (connection != null) { 
	                connection.disconnect(); 
	            } 
	        } 
	        return cookie; 
	    } 

	    public static List<String> getAocs(String sessionId, final String domain) { 
	        HttpURLConnection connection = null; 

	        List<String> aocs = new ArrayList<>(); 

	        try { 
	            String contentType = "application/x-www-form-urlencoded"; 
	            String urlParameters = String.format("sessionID=%s", sessionId); 
	            URL url = new URL("http://" + domain + "/rest/2/engineers-api/objects/getAreaOfControls?"); 

	            connection = createConnection(contentType, urlParameters, url); 

	            sendRequest(connection, urlParameters); 
	            
	            JAXBContext jaxbContext = JAXBContext.newInstance(ApiResponse.class);
	            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
	            ApiResponse jsonMap=null;

	            jsonMap = (ApiResponse) unmarshaller.unmarshal(connection.getInputStream());
	            
	            for(Aoc ao : jsonMap.getAreaOfControlResponse().getAocs().getAoc()){
	            	aocs.add(ao.getId());
	            }
	            System.out.println("aocs size : "+aocs.size());
	            

	        } catch (Exception e) { 
	            e.printStackTrace(); 
	            System.out.println("ERROR"); 
	        } finally { 
	            if (connection != null) { 
	                connection.disconnect(); 
	            } 
	        } 
	        return aocs; 
	    } 


	    public static void runBatchPlanning(String domain, String cookie, String aoc, long startDate, long endDate) { 
	        
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
	    
	    private static void sendRequestObject(HttpURLConnection connection, String urlParameters) throws IOException { 
	        ObjectOutputStream wr = new ObjectOutputStream( 
	                connection.getOutputStream()); 
	        //wr.writeBytes(urlParameters);
	        
	        TestAutoScheduling auto = new TestAutoScheduling();
	        
	        wr.writeObject(auto.getApiRequest(sessionId, RequestType.saveOrder));
	        wr.flush(); 
	        wr.close(); 

	        connection.getResponseMessage();
	        System.out.println("connection.getResponseMessage(); : "+connection.getResponseMessage());

try{
	        JAXBContext jaxbContext = JAXBContext.newInstance(ApiResponse.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            ApiResponse jsonMap=null;

            jsonMap = (ApiResponse) unmarshaller.unmarshal(connection.getInputStream());
            
            for(Order order : jsonMap.getOrders().getOrder()){
            	System.out.println("order id : "+order.getOrderReference());
            }
}catch(Exception e){
	e.printStackTrace();
}
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
	    			//if(logger.isDebugEnabled()){
		    		//	logger.debug("Exception ........................."+ e.getMessage());
		    		//}
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