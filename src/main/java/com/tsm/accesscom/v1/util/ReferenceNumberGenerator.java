package com.tsm.accesscom.v1.util;

public class ReferenceNumberGenerator {

	public static void main(String[] args) {
		

		System.out.println("**********************************************************");
		
		System.out.println("getRandomAlphaNumericString() : "+getRandomAlphaNumericString());
		
		System.out.println("getRandomNumberString() "+getRandomNumberString());
		
		System.out.println("**********************************************************");
	}

	
	/**
     * This method is used to get the combination of 5 random alpha numeric string in StringBuffer format.
     * 
     * @return The StringBuffer object, which have the combination of 5 random character.
     */
    public static String getRandomAlphaNumericString() {
        
        String characters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";

        // taking 4 random generator Alpha Numeric Character
        StringBuffer strRandomNumber = new StringBuffer();

        int length = characters.length();
        for (int i = 0; i < 10; i++) {
            int index = (int) (Math.random() * length);
            strRandomNumber.append(characters.charAt(index));
        }
        return strRandomNumber.toString();
    }

    /**
     * This method is used to get the combination of 5 random number in String.
     * 
     * @return The StringBuffer object, which have the combination of 5 random character.
     */
    public static String getRandomNumberString() {
        String characters = "1234567890";

        // taking 4 random generator Alpha Numeric Character
        StringBuffer strRandomNumber = new StringBuffer();

        int length = characters.length();
        for (int i = 0; i < 10; i++) {
            int index = (int) (Math.random() * length);
            strRandomNumber.append(characters.charAt(index));
        }
        return strRandomNumber.toString();
    }
    
}
