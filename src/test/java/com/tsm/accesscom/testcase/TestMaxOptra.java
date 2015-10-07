package com.tsm.accesscom.testcase;

import java.util.List;
import java.util.TimeZone;

import org.junit.Test;

import com.maxoptra.api.v1.model.response.Aoc;
import com.maxoptra.api.v1.model.response.ApiResponse;
import com.maxoptra.api.v1.model.response.Location;
import com.maxoptra.api.v1.model.response.Order;
import com.maxoptra.api.v1.model.response.Performer;
import com.maxoptra.api.v1.model.response.Vehicle;
import com.tsm.accesscom.testcase.service.BaseService;
import com.tsm.accesscom.v1.client.TestAutoScheduling;
import com.tsm.accesscom.v1.util.DateFormat;

public class TestMaxOptra {

	private static BaseService baseService = new BaseService();
	private static String orderReference;
	private static ApiResponse apiResponse;
	private static String sessionId;
	
	@Test
	public void authentication(){
		System.out.println("");
		System.out.println("*********************************Authentication Method Started******************************************************");
		try{
			String sessionId = baseService.getAuthenticate("http://service.maxoptra.com/rest/2/authentication/createSession?accountID=tsm&user=tsm.dispatcher&password=456RTYfgh", "Authenticate User");
			System.out.println("sessionId : "+sessionId);
		}catch(Exception e){
			e.printStackTrace();
		}
		System.out.println("Successful Authenticatin !");
		System.out.println("*********************************Authentication Method Ended******************************************************");
		System.out.println("");
		
		System.out.println("");
		System.out.println("");
		System.out.println("");
	}
	
	@Test
	public void saveOrder(){
		System.out.println("");
		System.out.println("**********************************Save Order Method Started*****************************************************");
		try{
			String sessionId = baseService.getAuthenticate("http://service.maxoptra.com/rest/2/authentication/createSession?accountID=tsm&user=tsm.dispatcher&password=456RTYfgh", "Authenticate User");
			System.out.println("sessionId : "+sessionId);
			
			apiResponse = baseService.saveOrder("http://service.maxoptra.com/rest/2/engineers-api/orders/save", "Save Order", sessionId);
			
			if(apiResponse.getError()!=null){
//        		if(logger.isDebugEnabled()){
//	    			logger.debug("Error Code : "+apiResponse.getError().getErrorCode());
//	    			logger.debug("Error Message : "+apiResponse.getError().getErrorMessage());
//	    		}
        		System.out.println("Error Code : "+apiResponse.getError().getErrorCode());
        		System.out.println("Error Message : "+apiResponse.getError().getErrorMessage());
        	}else{
				for(Order order : apiResponse.getOrders().getOrder()){
					System.out.println("apiResponse : "+order);
					orderReference = order.getOrderReference();
				}
        	}
		}catch(Exception e){
			e.printStackTrace();
			System.exit(0);
		}
		
		System.out.println("Order Saved Successful !");
		System.out.println("***********************************Save Order Method Ended****************************************************");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
	}
	
	@Test
	public void updateOrder(){
		System.out.println("************************************Update Order Method Started***************************************************");
		System.out.println("");
		try{
			
			String sessionId = baseService.getAuthenticate("http://service.maxoptra.com/rest/2/authentication/createSession?accountID=tsm&user=tsm.dispatcher&password=456RTYfgh", "Authenticate User");
			System.out.println("sessionId : "+sessionId);
			
			ApiResponse apiResponse = baseService.updateOrder("http://service.maxoptra.com/rest/2/engineers-api/orders/update", "Update Order", sessionId);
			
			if(apiResponse.getError()!=null){
//        		if(logger.isDebugEnabled()){
//	    			logger.debug("Error Code : "+apiResponse.getError().getErrorCode());
//	    			logger.debug("Error Message : "+apiResponse.getError().getErrorMessage());
//	    		}
        		System.out.println("Error Code : "+apiResponse.getError().getErrorCode());
        		System.out.println("Error Message : "+apiResponse.getError().getErrorMessage());
        	}else{
				for(Order order : apiResponse.getOrders().getOrder()){
					System.out.println("apiResponse : "+order);
					orderReference = order.getOrderReference();
				}
        	}
		}catch(Exception e){
			e.printStackTrace();
		}
		System.out.println("Order Updated Successful !");
		System.out.println("*************************************Update Order Method Ended**************************************************");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
	}
	
	@Test
	public void orderStatus(){
		System.out.println("");
		System.out.println("***************************************Order Status Method Started************************************************");
		String orderString="";
		for(Order order : apiResponse.getOrders().getOrder()){
			if(!orderString.equalsIgnoreCase("")){
				orderString += "*";
			}
			orderString += order.getOrderReference();
		}
		
		System.out.println("orderString : "+orderString);
		
		try{
			
			String sessionId = baseService.getAuthenticate("http://service.maxoptra.com/rest/2/authentication/createSession?accountID=tsm&user=tsm.dispatcher&password=456RTYfgh", "Authenticate User");
			System.out.println("sessionId : "+sessionId);
			
			com.maxoptra.api.v1.model.order.status.response.ApiResponse response = baseService.orderStatus("http://service.maxoptra.com/rest/2/engineers-api/orders/getOrderStatuses?sessionID="+sessionId+"&orders="+orderString, "Order Status", sessionId);
			
    		for(com.maxoptra.api.v1.model.order.status.response.Order order : response.getOrderStatusResponse().getOrders().getOrder()){
    			System.out.println("apiResponse : "+order);
    		}
		}catch(Exception e){
			e.printStackTrace();
		}
		System.out.println("Order Status Executed Successful !");
		System.out.println("*****************************************Order Status Method Ended**********************************************");
		System.out.println("*");
		System.out.println("");
		System.out.println("");
		System.out.println("");
	}
	
	@Test
	public void deleteOrder(){
		System.out.println("*");
		System.out.println("*****************************************Delete Order Method Started**********************************************");
		try{
			
			String sessionId = baseService.getAuthenticate("http://service.maxoptra.com/rest/2/authentication/createSession?accountID=tsm&user=tsm.dispatcher&password=456RTYfgh", "Authenticate User");
			System.out.println("sessionId : "+sessionId);
			
			System.out.println("order reference :"+orderReference);
			
			ApiResponse apiResponse = baseService.deleteOrder("http://service.maxoptra.com/rest/2/engineers-api/orders/delete", "Delete Order", sessionId, orderReference);
			
			if(apiResponse.getError()!=null){
//        		if(logger.isDebugEnabled()){
//	    			logger.debug("Error Code : "+apiResponse.getError().getErrorCode());
//	    			logger.debug("Error Message : "+apiResponse.getError().getErrorMessage());
//	    		}
        		System.out.println("Error Code : "+apiResponse.getError().getErrorCode());
        		System.out.println("Error Message : "+apiResponse.getError().getErrorMessage());
        	}else{
				for(Order order : apiResponse.getOrders().getOrder()){
					System.out.println("apiResponse delete !: "+order);
					orderReference = order.getOrderReference();
				}
        	}
		}catch(Exception e){
			e.printStackTrace();
		}
		
		System.out.println("Delete Order Executed Successful !");
		System.out.println("********************************************Delete Order Method Ended*******************************************");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
	}
	
	@Test
	public void areaOfControls(){
		System.out.println("**********************************************Area Of Controls Method Started*****************************************");
		System.out.println("");
		try{
			String sessionId = baseService.getAuthenticate("http://service.maxoptra.com/rest/2/authentication/createSession?accountID=tsm&user=tsm.dispatcher&password=456RTYfgh", "Authenticate User");
			System.out.println("sessionId : "+sessionId);
			ApiResponse apiResponse = baseService.getAOC("http://service.maxoptra.com/rest/2/engineers-api/objects/getAreaOfControls?sessionID="+sessionId, "Area_Of_Controls");
			
			if(apiResponse.getError()!=null){
//        		if(logger.isDebugEnabled()){
//	    			logger.debug("Error Code : "+apiResponse.getError().getErrorCode());
//	    			logger.debug("Error Message : "+apiResponse.getError().getErrorMessage());
//	    		}
        		System.out.println("Error Code : "+apiResponse.getError().getErrorCode());
        		System.out.println("Error Message : "+apiResponse.getError().getErrorMessage());
        	}else{ 
    			for(Aoc aoc : apiResponse.getAreaOfControlResponse().getAocs().getAoc()){
    				System.out.print("Aoc Id: "+aoc.getId());
    				System.out.println("   Aoc Name: "+aoc.getName());
    			}
    		}
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		System.out.println("Area Of Control Executed Successful !");
		System.out.println("*********************************************Area Of Controls Method Ended******************************************");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
	}
	
	@Test
	public void getVehicle(){
		System.out.println("");
		System.out.println("*********************************************Get Vehicle Method Started******************************************");
		try{
			String sessionId = baseService.getAuthenticate("http://service.maxoptra.com/rest/2/authentication/createSession?accountID=tsm&user=tsm.dispatcher&password=456RTYfgh", "Authenticate User");
			System.out.println("sessionId : "+sessionId);
			ApiResponse apiResponse = baseService.getAOC("http://service.maxoptra.com/rest/2/engineers-api/objects/getVehicles?sessionID="+sessionId+"&date="+DateFormat.getTodayDateInString(), "Area_Of_Controls");
			
			if(apiResponse.getError()!=null){
//        		if(logger.isDebugEnabled()){
//	    			logger.debug("Error Code : "+apiResponse.getError().getErrorCode());
//	    			logger.debug("Error Message : "+apiResponse.getError().getErrorMessage());
//	    		}
        		System.out.println("Error Code : "+apiResponse.getError().getErrorCode());
        		System.out.println("Error Message : "+apiResponse.getError().getErrorMessage());
        	}else{ 
        		System.out.println("Units");
    			System.out.print("timeZone : "+apiResponse.getVehiclesResponse().getUnits().getTimeZone());
    			System.out.print("  timeZoneOffset : "+apiResponse.getVehiclesResponse().getUnits().getTimeZoneOffset());
    			System.out.print("  currency : "+apiResponse.getVehiclesResponse().getUnits().getCurrency());
    			System.out.print("  distanceUnits : "+apiResponse.getVehiclesResponse().getUnits().getDistanceUnits());
    			System.out.print("  speedUnits : "+apiResponse.getVehiclesResponse().getUnits().getSpeedUnits());
    			System.out.println("  durationUnits : "+apiResponse.getVehiclesResponse().getUnits().getDurationUnits());
    			
    			for(Vehicle vechicle : apiResponse.getVehiclesResponse().getVehicles().getVehicle()){
    				System.out.println("");
    				System.out.println("Vehicle ==>");
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
    		}
			
		}catch(Exception e){
			e.printStackTrace();
		}
		System.out.println("Get Vehicle Executed Successful !");
		System.out.println("*****************************************Get Vehicle Method Ended**********************************************");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
	}
	
	@Test
	public void getVehicleByAOC(){
		System.out.println("");
		System.out.println("*****************************************Get Vehicle By AOC Method Started**********************************************");
		try{
			String sessionId = baseService.getAuthenticate("http://service.maxoptra.com/rest/2/authentication/createSession?accountID=tsm&user=tsm.dispatcher&password=456RTYfgh", "Authenticate User");
			System.out.println("sessionId : "+sessionId);
			ApiResponse apiResponse = baseService.getAOC("http://service.maxoptra.com/rest/2/engineers-api/objects/getVehicles?sessionID="+sessionId+"&aocID=320&date="+DateFormat.getTodayDateInString(), "Area_Of_Controls");
			
			if(apiResponse.getError()!=null){
//        		if(logger.isDebugEnabled()){
//	    			logger.debug("Error Code : "+apiResponse.getError().getErrorCode());
//	    			logger.debug("Error Message : "+apiResponse.getError().getErrorMessage());
//	    		}
        		System.out.println("Error Code : "+apiResponse.getError().getErrorCode());
        		System.out.println("Error Message : "+apiResponse.getError().getErrorMessage());
        	}else{ 
        		System.out.println("Units");
    			System.out.print("timeZone : "+apiResponse.getVehiclesResponse().getUnits().getTimeZone());
    			System.out.print("  timeZoneOffset : "+apiResponse.getVehiclesResponse().getUnits().getTimeZoneOffset());
    			System.out.print("  currency : "+apiResponse.getVehiclesResponse().getUnits().getCurrency());
    			System.out.print("  distanceUnits : "+apiResponse.getVehiclesResponse().getUnits().getDistanceUnits());
    			System.out.print("  speedUnits : "+apiResponse.getVehiclesResponse().getUnits().getSpeedUnits());
    			System.out.println("  durationUnits : "+apiResponse.getVehiclesResponse().getUnits().getDurationUnits());
    			
    			for(Vehicle vechicle : apiResponse.getVehiclesResponse().getVehicles().getVehicle()){
    				System.out.println("");
    				System.out.println("Vehicle ==>");
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
    		}
			
		}catch(Exception e){
			e.printStackTrace();
		}
		System.out.println("Get Vehicle By AOC Executed Successful !");
		System.out.println("*******************************************Get Vehicle By AOC Method Ended********************************************");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
	}
	
	//@Test
	public void authenticateSchedule(){
		System.out.println("");
		System.out.println("*****************************************Authenticate Schedule Method Started**********************************************");
		//System.out.println(TestAutoScheduling.autoSchedule());
		
		TimeZone.setDefault(TimeZone.getTimeZone("UTC")); 

        String login = "tsm.dispatcher"; 
        String password = "456RTYfgh"; 
        String account = "tsm"; 
        String domain = "service.maxoptra.com"; 

        String sessionId = TestAutoScheduling.auth(login, password, account, domain);
		
        System.out.println("Authenticate Schedule Executed Successful !");
		System.out.println("******************************************Authenticate Schedule Method Ended*********************************************");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
	}
	
	//@Test
	public void autoSchedule(){
		System.out.println("");
		System.out.println("*****************************************Auto Schedule Method Started**********************************************");
		
		String login = "tsm.dispatcher"; 
        String password = "456RTYfgh"; 
        String account = "tsm"; 
        String domain = "service.maxoptra.com"; 
        
        long startDate = DateFormat.getEarlyMorningTimeStamp(); 
        long endDate = startDate + 24 * 60 * 60 * 1000 - 1000; // 23:59:59

        sessionId = TestAutoScheduling.auth(login, password, account, domain);
		
		String cookie = TestAutoScheduling.getCookie(login, password, account, domain); 
        List<String> aocs = TestAutoScheduling.getAocs(sessionId, domain); 

        System.out.println("aocs.get(0) : "+aocs.get(0));
        
        TestAutoScheduling.runBatchPlanning(domain, cookie, aocs.get(0), startDate, endDate); 
		
        System.out.println("Auto Schedule Executed Successful !");
		System.out.println("******************************************Auto Schedule Method Ended*********************************************");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
	}
	
	//@Test
	public void getScheduleByAOCOnDate(){
		System.out.println("");
		System.out.println("*********************************Get Schedule By AOC On Date Method Started******************************************************");
		
		
		try{
			sessionId = baseService.getAuthenticate("http://service.maxoptra.com/rest/2/authentication/createSession?accountID=tsm&user=tsm.dispatcher&password=456RTYfgh", "Authenticate User");
			System.out.println("sessionId : "+sessionId);
		
			ApiResponse apiResponse = baseService.getScheduleByAOCOnDate("http://service.maxoptra.com/rest/2/engineers-api/schedules/getScheduleByAOCOnDate?sessionID="+sessionId+"&date="+DateFormat.getTodayDateInString()+"&aocID=320", "Authenticate User");
			

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
		
			
		}catch(Exception e){
			e.printStackTrace();
		}
		System.out.println("Schedule By AOC On Date Executed Successful !");
		System.out.println("*********************************Get Schedule By AOC On Date Method Ended******************************************************");
		System.out.println("");
		
		System.out.println("");
		System.out.println("");
		System.out.println("");
	}
	
	//@Test
	public void getScheduleByVehicleOnDate(){
		System.out.println("");
		System.out.println("*********************************Get Schedule By Vehicle On Date Method Started******************************************************");
		
		try{
			sessionId = baseService.getAuthenticate("http://service.maxoptra.com/rest/2/authentication/createSession?accountID=tsm&user=tsm.dispatcher&password=456RTYfgh", "Authenticate User");
			System.out.println("sessionId : "+sessionId);
		
			ApiResponse apiResponse = baseService.getScheduleByAOCOnDate("http://service.maxoptra.com/rest/2/engineers-api/schedules/getScheduleByVehicleOnDate?sessionID="+sessionId+"&date="+DateFormat.getTodayDateInString()+"&vehicleID=7208", "Authenticate User");
			

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
		
			
		}catch(Exception e){
			e.printStackTrace();
		}
		System.out.println("Get Schedule By Vehicle On Date Method Executed Successful !");
		System.out.println("*********************************Get Schedule By Vehicle On Date Method Ended******************************************************");
		System.out.println("");
		
		System.out.println("");
		System.out.println("");
		System.out.println("");
	}
}
