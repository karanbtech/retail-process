package com.retailprocess.util;

import java.util.Date;
import java.util.Random;

public class ApplicationUtil {
	
	public static long getUniqueId() {
		Random random = new Random();
	    return random.nextLong();
			
		
	}
	
	//calculate the customer duration and return the number of years
	public static int getCustomerDuration(Date registrationDate) {
		long diffInMillies = Math.abs(new Date().getTime() - registrationDate.getTime());
	    int years =  (int) (diffInMillies / (1000l * 60 * 60 * 24 * 365));
	    return years;
	}
}
