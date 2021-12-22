package com.makemytrip.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyFileReader {
	
	public static String getPropertyValue(String propertyFile, String propertyName) {
		/*
		 * Goal: Utility method to read Automation's dependent parameters from property file
		 * Parameters : propertyFile: Name of property file to refer
		 * 				propertyName: Name of property to be read
		 */
		Properties prop = new Properties();
		InputStream input = null;
		String propertyValue = "";


		try {
			input = new FileInputStream(propertyFile);
			prop.load(input);
			propertyValue = prop.getProperty(propertyName);

		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			if (input != null) {
				try {
					input.close();
					return propertyValue;
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return propertyValue;
	}

}
