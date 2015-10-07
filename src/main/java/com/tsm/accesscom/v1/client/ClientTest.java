package com.tsm.accesscom.v1.client;

import java.util.Iterator;

import jp.ne.so_net.ga2.no_ji.jcom.IDispatch;
import jp.ne.so_net.ga2.no_ji.jcom.ReleaseManager;


//import org.apache.log4j.Logger;
import org.jawin.DispatchPtr;
import org.jawin.win32.COINIT;
import org.jawin.win32.Ole32;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import com.jacob.com.Dispatch;
import com.jacob.com.Variant;
import com.maxoptra.api.v1.model.request.ApiRequest;
import com.maxoptra.api.v1.model.request.Order;
import com.maxoptra.api.v1.model.request.Orders;
import com.tsm.accesscom.v1.api.AccessCom;
import com.tsm.accesscom.v1.api.TsmCom;
import com.tsm.accesscom.v1.dao.BaseDAO;
import com.tsm.accesscom.v1.dao.impl.BaseDAOImpl;
import com.tsm.accesscom.v1.util.DateFormat;
import com.tsm.accesscom.v1.util.ReferenceNumberGenerator;
import com.tsm.accesscom.v1.util.TsmConfigurationReader;

public class ClientTest extends Thread {

	//final static Logger logger = Logger.getLogger(ClientTest.class);
	
    public ClientTest() {
	
    }
    
    public ClientTest(String name) {
	super(name);
    }
    
    private void doTest() {

	Variant result1 = null;
	String result2 = null;
	byte[] result3 = null;

	AccessCom accessCom_01 = new TsmCom();	
	AccessCom accessCom_02 = new TsmCom();

	try {
//	    accessCom_01.callFunction("TSM_INIT_SS", "CRAIG", "", "c:/develop/tsm/TSM68", "LI", null, null, null, null, "apple");
	    System.out.println(accessCom_01.callStringFunction("tsm_vfpfunc", "set('datasession')"));
	    
//	    accessCom_02.callFunction("TSM_INIT_SS", "ADMIN", "", "c:/develop/tsm/TSM68", "LI", null, null, null, null, "banana");
	    System.out.println(accessCom_02.callStringFunction("tsm_vfpfunc", "set('datasession')"));
	    
//	    accessCom_01.getDispatch().
	    
//	    result1 = (Variant) accessCom.callFunction("tsm_read", "invoices", "total");
//	    result2 = accessCom.callStringFunction("tsm_read", "invoices", "total");
//	    result3 = accessCom.callByteArrayFunction("tsm_read", "invoices", "total");
	    
	} catch (Exception e) {
	    e.printStackTrace();
//	    if(logger.isDebugEnabled()){
//			logger.debug("Exception in doTest : "+e.getMessage());
//		}
	}

//	System.out.println(result1);
//	System.out.println(result2);
//	System.out.println(result3);
    }
    
    public ApiRequest doOtherTest() {
	
    ApiRequest request = new ApiRequest();
    	try {
    	
	Dispatch dispatch_01 = new Dispatch(TsmConfigurationReader.getDefaultProperty("tsm.progname"));
	
	System.out.println("********************************************************************************");
	System.out.println("tsm.progname : "+TsmConfigurationReader.getDefaultProperty("tsm.progname"));
	System.out.println("********************************************************************************");
	
	System.out.println("********************************************************************************");
	System.out.println("tsm.dir : "+TsmConfigurationReader.getDefaultProperty("tsm.dir"));
	System.out.println("********************************************************************************");
	
	Object[] params = {TsmConfigurationReader.getDefaultProperty("tsm.user"), "", TsmConfigurationReader.getDefaultProperty("tsm.dir"), "RM", true, true};
	Variant variant = Dispatch.callN(dispatch_01, "TSM_INIT_SS", params);
	//System.out.println(variant.toString());
	//Object[] param = {"select * from servcard where servcard.Allocated < 22/07/2008", "A"};
	
        BaseDAO baseDAO = new BaseDAOImpl();
        //String orderReference = baseDAO.getLastOrderID();
        
        System.out.println("*****************************************************************************************");
        //System.out.println("orderReference : "+orderReference);
	
//        if(logger.isDebugEnabled()){
//			logger.debug("orderReference : "+orderReference);
//		}
        
        Object[] param = new Object[2];
        
        //if(orderReference != null){
           //param[0] = "SELECT servcardid AS orderReference, company AS customer, dept AS area, (ALLTRIM(LEFT(billing, 255)) + ' ' + ALLTRIM(sitesub) + ' ' + ALLTRIM(sitepcode) + ' ' + ALLTRIM(sitestate)) AS customerLocationAddress, siteid AS customerLocationName, contact AS contactName, mobile AS contactNumber, date AS releaseDate, jobdate AS dueDate, TTOC(jobdate, 2) AS timeFrom1, start2 AS timeTo1, '' AS orderTimeFrom2, '' AS orderTimeTo2, 2 AS priority, '' AS skills, jobtype AS orderType, duration AS estimatedDuration, '' AS estimatedCost, (ALLTRIM(jobname) + ' ' + LEFT(servreques, 174)) AS workDescription, LEFT(jobnote, 255) AS toolAndSpareParts, sitenote AS customerLocationDescription FROM servcard where servcardid > 1009";
           //param[1] = "A";
//        }else{
           param[0] = "SELECT servcardid AS orderReference, company AS customer, dept AS area, (ALLTRIM(LEFT(billing, 255)) + ' ' + ALLTRIM(sitesub) + ' ' + ALLTRIM(sitepcode) + ' ' + ALLTRIM(sitestate)) AS customerLocationAddress, siteid AS customerLocationName, contact AS contactName, mobile AS contactNumber, date AS releaseDate, jobdate AS dueDate, TTOC(jobdate, 2) AS timeFrom1, start2 AS timeTo1, '' AS orderTimeFrom2, '' AS orderTimeTo2, 2 AS priority, '' AS skills, jobtype AS orderType, duration AS estimatedDuration, '' AS estimatedCost, (ALLTRIM(jobname) + ' ' + LEFT(servreques, 174)) AS workDescription, LEFT(jobnote, 255) AS toolAndSpareParts, sitenote AS customerLocationDescription FROM servcard";
           param[1] = "A";
//        }
        
	//System.out.println("length of the Param Object : "+param.length);
//        if(logger.isDebugEnabled()){
//			logger.debug("*****************************************************************************************");
//		}

        JSONParser parser = new JSONParser();
	
		Object obj = parser.parse(Dispatch.call(dispatch_01, "TSM_Query", param).toString());
		JSONArray jsonArray = (JSONArray)obj;
		
//		if(logger.isDebugEnabled()){
//			logger.debug("*****************************************************************************************");
//			logger.debug("jsonArray : "+jsonArray.toJSONString());
//			logger.debug("jsonArray length : "+jsonArray.size());
//			logger.debug("jsonArray : "+jsonArray);
//		}
		
		Orders orders = new Orders();
		
		Order order = new Order();
		
		Iterator iterator = jsonArray.iterator();
		int i=0;
		
		Order[] orderArray = new Order[jsonArray.size()];
		
		while (iterator.hasNext()) {
			order = new Order();
			JSONObject innerObj = (JSONObject) iterator.next();
			System.out.println("innerObj : "+innerObj.toJSONString());
			
			order.setAreaOfControl(innerObj.get("area").toString());
			order.getCustomerLocation().setContactName(innerObj.get("contactname").toString());
			order.getCustomerLocation().setName(innerObj.get("customer").toString());
			
			if(innerObj.get("customerlocationaddress") != null && innerObj.get("customerlocationaddress") != ""){
				order.getCustomerLocation().getPosition().setAddress("4 Tyrell Street NEWCASTLE 2300 NSW");
			}else {
				order.getCustomerLocation().getPosition().setAddress("");
			}
			
			//order.getCustomerLocation().getPosition().setAddress("4 Tyrell Street NEWCASTLE 2300 NSW");
			
			if(innerObj.get("customerlocationdescription") != null){
				order.getCustomerLocation().setDescription(innerObj.get("customerlocationdescription").toString());
			}else {
				order.getCustomerLocation().setDescription("");
			}
			
			//innerObj.get("customerlocationname").toString();
			order.setDueDate(innerObj.get("duedate").toString());
			order.setPrice(innerObj.get("estimatedcost").toString());
			//innerObj.get("estimatedduration").toString();
			//innerObj.get("ordertimefrom2").toString();
			//innerObj.get("ordertimeto2").toString();
			//innerObj.get("ordertype").toString();
			order.setPriority(innerObj.get("priority").toString());
			order.setReleaseDate(innerObj.get("releasedate").toString());
			//innerObj.get("skills").toString();
			//innerObj.get("timefrom1").toString();
			//innerObj.get("timeto1").toString();
			//innerObj.get("toolandspareparts").toString();
			order.setWorkDescription(innerObj.get("workdescription").toString());
			//order.setOrderReference(innerObj.get("orderreference").toString());
			order.setOrderReference(ReferenceNumberGenerator.getRandomAlphaNumericString());
			order.setDurationDrop("00:15");
			order.setAreaOfControl("Sydney");
			order.setReleaseDate(DateFormat.getTodayDateInString()+" 14:00");
			order.setDueDate(DateFormat.getTomorrowDateInString()+" 12:30");
			order.getClient().setContactNumber("100000001");
			order.getClient().setContactPerson("Garry");
			order.getClient().setName("Customer Davis");
			
			
			orderArray[i++] = order; 
		}
		
		orders.setOrder(orderArray);
		request.setOrders(orders);

//		if(logger.isDebugEnabled()){
//			logger.debug("This is debug : going to save the orders at Derby.........................");
//		}
		//**************************************************************************************************//
		  baseDAO.saveOrders(orders);
		//**************************************************************************************************//
		
//		  if(logger.isDebugEnabled()){
//				logger.debug("This is debug : data is saved at Derby.........................");
//			}
		
	} catch (Exception e) {

		e.printStackTrace();
//		if(logger.isDebugEnabled()){
//			logger.debug("Exception in doTest : "+e.getMessage());
//		}

	}
	
	
	return request;
    }
    
    public void run()  {
	
	System.out.println(getName());
	
	try {
	    doJaWinTest();
	} catch (Exception e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
//	    if(logger.isDebugEnabled()){
//			logger.debug("Exception ........................."+ e.getMessage());
//		}
	}
    }

    public void doOneMoreTest() throws Exception {

	ReleaseManager releaseManager = new ReleaseManager();
	IDispatch iDispatch = new IDispatch(releaseManager, "tsm61.global");
	
	Object[] params = {"CRAIG", "", "c:/develop/tsm/TSM68", "LI", null, null, null, null, "apple"};
	iDispatch.invoke("TSM_INIT_SS", params);
	System.out.println(iDispatch.invoke("tsm_vfpfunc", new Object[] {"global.test"}));
	
	ReleaseManager releaseManager_02 = new ReleaseManager();
	IDispatch iDispatch_02 = new IDispatch(releaseManager_02, "tsm61.global");
	
	Object[] params_02 = {"ADMIN", "", "c:/develop/tsm/TSM68", "LI", null, null, null, null, "banana"};
	iDispatch_02.invoke("TSM_INIT_SS", params_02);
	System.out.println(iDispatch.invoke("tsm_vfpfunc", new Object[] {"global.test"}));
    }
    
    public synchronized void doJaWinTest() throws Exception {
	
	Ole32.CoInitialize(COINIT.MULTITHREADED);
	
	DispatchPtr dispatchPtr = new DispatchPtr("tsm61.global");
	
	Object[] params = {getName(), "", "c:/develop/tsm/TSM68", "LI", null, null, null, null, String.valueOf(Math.random() * 100)};
	dispatchPtr.invokeN("TSM_INIT_SS", params);
	System.out.println(dispatchPtr.invoke("tsm_vfpfunc", "global.test"));
	System.out.println(dispatchPtr.invoke("tsm_vfpfunc", "set('datasession')"));
		
	Ole32.CoUninitialize();
//	
//	DispatchPtr dispatchPtr_02 = new DispatchPtr("tsm61.global");
//	
//	Object[] params_02 = {"ADMIN", "", "c:/develop/tsm/TSM68", "LI", null, null, null, null, "banana"};
//	dispatchPtr_02.invokeN("TSM_INIT_SS", params);
//	System.out.println(dispatchPtr.invoke("tsm_vfpfunc", "global.test"));
//	System.out.println(dispatchPtr_02.invoke("tsm_vfpfunc", "global.test"));
//	Ole32.CoUninitialize();
	
    }
    
    public static void main(String[] args) throws Exception{

	ClientTest clientTest = new ClientTest();
//	clientTest.doTest();
	clientTest.doOtherTest();
//	clientTest.doOneMoreTest();
//	clientTest.doJaWinTest();
	
//	Thread thread = new ClientTest("ADMIN");
//	thread.start();
//	Thread thread_02 = new ClientTest("CRAIG");
//	thread_02.start();
    }

}
