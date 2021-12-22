package com.makemytrip.utilities;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.google.common.io.Files;

public class GeneralUtilties {

	
	public static void sleep(int milliseconds) {
		/*
		 *	Goal: Method to make automation sleep for sometime for elements to load in DOM
		 *	Parameters : milliseconds : Number of seconds to wait
		 */
		
		try {
			Thread.sleep(milliseconds);
		}
		catch(Exception e) {
			System.out.println("Exception while waiting the code in sleep state: "+e);
		}
	}
	
	public static List<String> dateCalculator(int numberOfDays) {
		/*
		 *  Goal: To calculate checkin and checkout date X number of days ahead from current date
		 *  Parameters: numberOfDays : Number of days from current date
		 */
		
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
	
	public static String capture(WebDriver driver){
		/*
		 * Goal: In the event of failure or exception, screenshot of problem area to be taken and stored in ErrImages folder
		 * Parameters: driver : Selenium Webdriver
		 */
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		File Dest = new File(System.getProperty("user.dir") +"\\ErrImages\\" + System.currentTimeMillis()
		+ ".png");
		String errflpath = Dest.getAbsolutePath();
		
		try {
			Files.copy(scrFile, Dest);
		}
		catch(IOException ioException) {
			System.out.println("Exception in taking Screenshot" +ioException);
		}
		
		return errflpath;
		}
	
}
