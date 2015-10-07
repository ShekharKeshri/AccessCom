package com.tsm.accesscom.v1.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

//import org.apache.log4j.Logger;

import com.maxoptra.api.v1.model.request.Order;
import com.maxoptra.api.v1.model.request.Orders;
import com.tsm.accesscom.v1.dao.BaseDAO;

/**
 *
 * @author Admin
 */
public class BaseDAOImpl implements BaseDAO{
	
	//final static Logger logger = Logger.getLogger(BaseDAOImpl.class);
	
	private static int flag = 0;
    private static String myDb;
    private static Connection DBconn;
    private static Statement st;
    
    public static void main() {
	        try{
	        Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
	        myDb = "jdbc:derby:accesscom;create=true;";
	        DBconn = DriverManager.getConnection(myDb, "test","test");
	        st=DBconn.createStatement();
	        
                
                ResultSet rs=st.executeQuery("select * from APP.ORDER_STATUS");
                 
	        System.out.println("hello.....................");
	         
	        while(rs.next()){
	            System.out.println(rs.getString("order_reference"));
	        }
	        
	        }catch(Exception e){
	            e.printStackTrace();
//	            if(logger.isDebugEnabled()){
//	    			logger.debug("Exception ........................."+ e.getMessage());
//	    		}
	        }
	    }
    public int countOrders(){
        
        return 0;
    }
    
    public void saveOrder(){
        
    }
    
    @Override
    public void saveOrders(Orders orders){
        try{
        	
//        	if(logger.isDebugEnabled()){
//    			logger.debug("saveOrders is being called .........................");
//    		}
        	
        	if(flag == 0){
        		createTable();
        	}
            
            Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
	        myDb = "jdbc:derby:accesscom;create=true;";
	        DBconn = DriverManager.getConnection(myDb, "test","test");
	        //st=DBconn.createStatement();
                
                DBconn.setAutoCommit(false); 
                PreparedStatement prepStmt = DBconn.prepareStatement("insert into APP.ORDER_STATUS (order_reference, status) values(?,?)");
                
            for(Order order: orders.getOrder()){
                prepStmt.setString(1,order.getOrderReference());                 
                prepStmt.setString(2,"Pending");
                prepStmt.addBatch();
            }
            
            int [] numInserted = prepStmt.executeBatch();
            
            DBconn.setAutoCommit(true); 
            System.out.println("numInserted : "+numInserted.length);
            
//            if(logger.isDebugEnabled()){
//    			logger.debug("numInserted ........................."+numInserted.length);
//    		}
            
            //Insert Value
            //st.execute("insert into APP.ORDER_STATUS (order_reference, status) values('aaa123','Pending')");
            
            
            try{
	        //Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
	        //myDb = "jdbc:derby:accesscom";
	        //DBconn = DriverManager.getConnection(myDb, "test","test");
	        st=DBconn.createStatement();
	        
                
                ResultSet rs=st.executeQuery("select * from APP.ORDER_STATUS");
                 
	        System.out.println("hello.....................");
	         
	        while(rs.next()){
	            System.out.println(rs.getString("order_reference"));
//	            if(logger.isDebugEnabled()){
//	    			logger.debug("value numInserted ........................."+ rs.getString("order_reference"));
//	    		}
	         }
	        
	        }catch(Exception e){
	            e.printStackTrace();
//	            if(logger.isDebugEnabled()){
//	    			logger.debug("Exception ........................."+ e.getMessage());
//	    		}
	        }
            
        }catch(Exception e){
            e.printStackTrace();
//            if(logger.isDebugEnabled()){
//    			logger.debug("Exception ........................."+ e.getMessage());
//    		}
        }
    }
    
    private void createTable(){
    	
//    	if(logger.isDebugEnabled()){
//			logger.debug("Table Creation .........................");
//		}
    	try{
	        Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
	        String myDb = "jdbc:derby:accesscom;create=true;";
	        Connection DBconn = DriverManager.getConnection(myDb, "test","test");
	        Statement st=DBconn.createStatement();
                 
                 
                //Create Table
	        System.out.println("result : "+st.execute("create table APP.ORDER_STATUS(id int not null GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),order_reference varchar(20),status varchar(20),primary key(id))"));
	        
            System.out.println("Table Created .....................");
            
            flag++;
            
	        }catch(Exception e){
	            e.printStackTrace();
//	            if(logger.isDebugEnabled()){
//	    			logger.debug("Exception ........................."+ e.getMessage());
//	    		}
	        }
    	
//    	if(logger.isDebugEnabled()){
//			logger.debug("Table Creation Successfully .........................");
//		}
    }
    
    public void getOrders(){
        
    }
    
    public void getOrderById(){
        
    }
    
    public void getOrdersByIdList(){
        
    }
    
    public void updateOrderById(){
        
    }
    
    public void updateOrdersByIdList(){
        
    }
    
    public void deleteOrderById(){
        
    }
    
    public void deleteOrdersByIdList(){
        
    }
    
    @Override
    public String getLastOrderID(){
        
        String orderReference = null;
        
       try{
	        Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
	        myDb = "jdbc:derby:accesscom";
	        DBconn = DriverManager.getConnection(myDb, "test","test");
	        st=DBconn.createStatement();
                
                ResultSet rs=st.executeQuery("select * from APP.ORDER_STATUS ORDER BY id desc FETCH FIRST ROW ONLY");
                 
	        System.out.println("hello.....................");
	         
	        while(rs.next()){
	            System.out.println(rs.getString("order_reference"));
                    orderReference = rs.getString("order_reference");
	         }
	        
	        }catch(Exception e){
	            e.printStackTrace();
//	            if(logger.isDebugEnabled()){
//	    			logger.debug("Exception ........................."+ e.getMessage());
//	    		}
                }
        
        return orderReference;
    }
}