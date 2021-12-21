package com.makemytrip.utilities;

public class GeneralUtilties {

	
	public static void sleep(int milliseconds) {
		
		try {
			Thread.sleep(milliseconds);
		}
		catch(Exception e) {
			System.out.println("Exception while waiting the code in sleep state: "+e);
		}
	}
}
