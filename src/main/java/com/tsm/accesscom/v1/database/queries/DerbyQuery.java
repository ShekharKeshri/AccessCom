package com.tsm.accesscom.v1.database.queries;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DerbyQuery {

	public static void main(String[] args) {
		
		try{
	        Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
	        String myDb = "jdbc:derby:accesscom;create=true;";
	        Connection DBconn = DriverManager.getConnection(myDb, "test","test");
	        Statement st=DBconn.createStatement();
                 
                 
                //Create Table
	            //System.out.println("result : "+st.execute("create table APP.ORDER_STATUS(id int not null GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),order_reference varchar(20),status varchar(20),primary key(id))"));
	        
                 
                //Drop Tabel
                //st.execute("drop table APP.ORDER_STATUS");
                 
                 
                //Insert Value
                //st.execute("insert into APP.ORDER_STATUS (order_reference, status) values('aaa123','Pending')");
                
                
                //Select Query
                //ResultSet rs=st.executeQuery("select * from APP.ORDER_STATUS");
                //ResultSet rs=st.executeQuery("select * from APP.ORDER_STATUS order by id desc FETCH FIRST ROW ONLY");
                
                //TRUNCATE TABLE
                st.execute("TRUNCATE TABLE APP.ORDER_STATUS");
                 
	        
                 System.out.println("Queries Working Fine .....................");
	         
                 
//	         while(rs.next()){
//                     System.out.println("while......");
//	            System.out.println(rs.getString("order_reference"));
//	          }
	        
	        }catch(Exception e){
	            e.printStackTrace();
	        }

	}

}
