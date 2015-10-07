package com.tsm.accesscom.testcase;

import com.maxoptra.api.v1.model.request.ApiRequest;
import com.maxoptra.api.v1.model.request.Order;
import com.maxoptra.api.v1.model.request.Orders;
import com.tsm.accesscom.v1.util.DateFormat;
import com.tsm.accesscom.v1.util.ReferenceNumberGenerator;

public class TestObject {

	public ApiRequest createOrderRequestObject(){
		ApiRequest request = new ApiRequest();
		Orders orders = new Orders();
		Order[] orderArray = new Order[2];
		Order order = new Order();
		
		order.setAreaOfControl("Sydney");
		order.getCustomerLocation().setContactName("Bugs Bunny");
		order.getCustomerLocation().setName("Flicks Movie Theatres - Newcastle");
		order.getCustomerLocation().getPosition().setAddress("4 Tyrell Street NEWCASTLE 2300 NSW");
		order.getCustomerLocation().setDescription("");
		order.setPrice("");
		order.setPriority("2");
		order.setWorkDescription("DOOVER");
		order.setOrderReference(ReferenceNumberGenerator.getRandomAlphaNumericString());
		order.setDurationDrop("00:15");
		order.setAreaOfControl("Sydney");
		order.setReleaseDate(DateFormat.getTodayDateInString()+" 14:00");
		order.setDueDate(DateFormat.getTomorrowDateInString()+" 12:30");
		order.getClient().setContactNumber("100000001");
		order.getClient().setContactPerson("Garry");
		order.getClient().setName("Customer Davis");
		
		orderArray[0]=order;
		
		
		order = new Order();
		
		order.setAreaOfControl("Sydney");
		order.getCustomerLocation().setContactName("Bugs Bunny");
		order.getCustomerLocation().setName("Flicks Movie Theatres - Newcastle");
		order.getCustomerLocation().getPosition().setAddress("4 Tyrell Street NEWCASTLE 2300 NSW");
		order.getCustomerLocation().setDescription("");
		order.setPrice("");
		order.setPriority("2");
		order.setWorkDescription("DOOVER");
		order.setOrderReference(ReferenceNumberGenerator.getRandomAlphaNumericString());
		order.setDurationDrop("00:15");
		order.setAreaOfControl("Sydney");
		order.setReleaseDate(DateFormat.getTodayDateInString()+" 14:00");
		order.setDueDate(DateFormat.getTomorrowDateInString()+" 12:30");
		order.getClient().setContactNumber("100000001");
		order.getClient().setContactPerson("Garry");
		order.getClient().setName("Customer Davis");
		
		orderArray[1]=order;
		
		orders.setOrder(orderArray);
		request.setOrders(orders);
		
		return request;
	}
	
	public Orders prepareOrderForDelete(String orderReference){
    	Order order = new Order();
    	order.setOrderReference(orderReference);
    	
    	Order[] arrayOrder = new Order[1];
    	arrayOrder[0] = order;
    	
    	Orders orders = new Orders();
    	orders.setOrder(arrayOrder);
    	return orders;
    }
}
