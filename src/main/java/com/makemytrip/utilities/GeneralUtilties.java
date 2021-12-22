package com.makemytrip.utilities;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class GeneralUtilties {

	
	public static void sleep(int milliseconds) {
		
		try {
			Thread.sleep(milliseconds);
		}
		catch(Exception e) {
			System.out.println("Exception while waiting the code in sleep state: "+e);
		}
	}
	
	public static List<String> dateCalculator(int numberOfDays) {
		
		List<String> checkInOutDates = new ArrayList<String>();
		DateFormat dateFormat = new SimpleDateFormat("EEE MMM dd yyyy");
		
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, numberOfDays);
		
		String checkInDate = dateFormat.format(cal.getTime());
		checkInOutDates.add(checkInDate);
		
		cal.add(Calendar.DATE, 1);
		String checkOutDate = dateFormat.format(cal.getTime());
		checkInOutDates.add(checkOutDate);
		
		return checkInOutDates;
	}
	
}
