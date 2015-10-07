package com.maxoptra.api.v1.objects;

//import org.apache.log4j.Logger;

import com.maxoptra.api.v1.model.request.AccessTimes;
import com.maxoptra.api.v1.model.request.Client;
import com.maxoptra.api.v1.model.request.CustomFields;
import com.maxoptra.api.v1.model.request.Customer;
import com.maxoptra.api.v1.model.request.CustomerLocation;
import com.maxoptra.api.v1.model.request.DefaultAccessTime;
import com.maxoptra.api.v1.model.request.Field;
import com.maxoptra.api.v1.model.request.Order;
import com.maxoptra.api.v1.model.request.Orders;
import com.maxoptra.api.v1.model.request.Position;

public class PrepareRequestObject {
	
	//final static Logger logger = Logger.getLogger(PrepareRequestObject.class);

	public static Orders prepareOrders(){
    	Orders orders = new Orders();
    	Order[] orderArr = new Order[1];
    	orderArr[0]=prepareOrder();
    	orders.setOrder(orderArr);
    	
    	return orders;
    }

    private static Order prepareOrder(){
    	Order order = new Order();
    	order.setAreaOfControl("Sydney");
    	order.setClient(prepareClient());
    	order.setCustomerLocation(prepareCustomerLocation());
    	order.setCustomFields(prepareCustomFields());
    	order.setDueDate("12/25/2015 12:30");
    	order.setDurationDrop("00:15");
    	order.setOrderReference("mID200143");
    	order.setPrice("24");
    	order.setPriority("3");
    	order.setReleaseDate("12/09/2015 14:00");
    	order.setToolAndSpareParts("tool And Spare Parts011");
    	order.setWorkDescription("work Description 01");
    	
    	return order;
    }
    
    private static Client prepareClient(){
    	Client client = new Client();
    	client.setContactNumber("100000001");
    	client.setContactPerson("Garry");
    	client.setName("Customer Davis");
    	
    	return client;
    }
    
    private static CustomerLocation prepareCustomerLocation(){
    	CustomerLocation customerLocation = new CustomerLocation();
    	customerLocation.setAccessTimes(prepareAccessTimes());
    	customerLocation.setContactName("John");
    	customerLocation.setCustomer(prepareCustomer());
    	customerLocation.setDescription("simple description");
    	customerLocation.setEmail("john@example.com");
    	customerLocation.setName("Customer Location");
    	customerLocation.setPhoneNumber("11223543564");
    	customerLocation.setPosition(preparePosition());
    	
    	return customerLocation;
    }
    
    private static Customer prepareCustomer(){
        Customer customer = new Customer();
        customer.setContactNumber("223344556");
        customer.setContactPerson("Petr");
        customer.setName("Customer name");
    	
    	return customer;
    }
    
    private static Position preparePosition(){
    	Position position = new Position();
    	position.setAddress("Hanney Road 100, Abingdon, England22, OX1322 6, GB");
    	position.setLatitude("51.621914");
    	position.setLongitude("-0.1767671");
    	
    	return position;
    }
    
    private static CustomFields prepareCustomFields(){
    	Field[] fields = new Field[6];
    	Field field = null;
    	
    	field = new Field();
    	field.setName("urn");
    	field.setValue("urn 1");
    	fields[0] = field;
    	
    	field = new Field();
    	field.setName("equipmentMake");
    	field.setValue("equipmentMake 1");
    	fields[1] = field;
    	
    	field = new Field();
    	field.setName("faultDescription");
    	field.setValue("faultDescription 1");
    	fields[2] = field;
    	
    	field = new Field();
    	field.setName("customerLocationDescription");
    	field.setValue("customerLocationDescription 34");
    	fields[3] = field;
    	
    	field = new Field();
    	field.setName("equipmentModel");
    	field.setValue("equipmentModel 1");
    	fields[4] = field;
    	
    	field = new Field();
    	field.setName("to_be_booked");
    	field.setValue("true");
    	fields[5] = field;
    	
    	
    	CustomFields customFields = new CustomFields();
    	customFields.setField(fields);
    	return customFields;
    }
    
    private static AccessTimes prepareAccessTimes(){
    	AccessTimes accessTimes = new AccessTimes();
    	accessTimes.setDefaultAccessTime(prepareDefaultAccessTime());
    	
    	return null;
    }
    
    private static DefaultAccessTime prepareDefaultAccessTime(){
    	DefaultAccessTime defaultAccessTime = new DefaultAccessTime();
    	defaultAccessTime.setEnd("18:00");
    	defaultAccessTime.setEnd2("19:00");
    	defaultAccessTime.setStart("08:00");
    	defaultAccessTime.setStart2("23:48");
    	
    	return defaultAccessTime;
    }
    
    public static Orders prepareDeleteOrders(){
    	Orders orders = new Orders();
    	Order[] orderArr = new Order[1];
    	orderArr[0]=prepareOrderForDelete();
    	orders.setOrder(orderArr);
    	
    	return orders;
    }
    
    private static Order prepareOrderForDelete(){
    	Order order = new Order();
    	order.setOrderReference("mID200138");
    	
    	return order;
    }
}
