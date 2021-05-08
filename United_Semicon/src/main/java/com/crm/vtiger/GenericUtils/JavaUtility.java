package com.crm.vtiger.GenericUtils;

import java.util.Date;
import java.util.Random;

/*
 * this class contains java specific methods
 */
public class JavaUtility {
	/*
	 * generic random number
	 * @Neeraj
	 */
	public String getRandomData() {
		Random random=new Random();
		int ran=random.nextInt(1000);
		return ""+ran;
	}
	
	/*
	 * Generate current system date
	 * @Neeraj
	 */
	public String getCurrentSystemDate() {
		Date date=new Date();
		String currentDate = date.toString();
		return currentDate;
	}
	
}
