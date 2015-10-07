package com.tsm.accesscom.v1.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateFormat {

	private static SimpleDateFormat formatter1 = new SimpleDateFormat("MM/dd/yyyy");
	private static SimpleDateFormat formatter2 = new SimpleDateFormat("MM/dd/yyyy HH:mm:SS");
	private static Calendar cal;
	private static long millis;
	private static String dateTime;
	
	
	public static void main(String[] args) {
		

		System.out.println("**********************************************************");
		
		System.out.println("getTodayDateInString() : "+getTodayDateInString());
		
		System.out.println("getTomorrowDateInString() "+getTomorrowDateInString());
		
		System.out.println("**********************************************************");
	}

	/**
	 * 
	 * @return MM/DD/YYYY
	 */
	public static String getTodayDateInString(){
		 Date date = new Date(System.currentTimeMillis());
	      SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
	      return formatter.format(date);
	}
	
	public static String getTomorrowDateInString(){
		 Date date = new Date(System.currentTimeMillis());
		 
		 Calendar c = Calendar.getInstance(); 
		 c.setTime(date); 
		 c.add(Calendar.DATE, 1);
		 date = c.getTime();
		 
	     SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
	     return formatter.format(date);
	}
	
	public static long getEarlyMorningTimeStamp(){
		dateTime = formatter1.format(new Date())+" 00:00:00";
		try{
			cal = Calendar.getInstance();
			cal.setTime(formatter2.parse(dateTime));
			millis = cal.getTimeInMillis();
		}catch(Exception e){
			e.printStackTrace();
		}

		return millis;
	}

    public static long getLateNightTimeStamp(){
    	dateTime = formatter1.format(new Date())+" 23:59:00";
		try{
			cal = Calendar.getInstance();
			cal.setTime(formatter2.parse(dateTime));
			millis = cal.getTimeInMillis();
		}catch(Exception e){
			e.printStackTrace();
		}

		return millis;
	}
}
