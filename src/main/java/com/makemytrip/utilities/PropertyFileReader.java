package com.makemytrip.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyFileReader {
	
	public static String getPropertyValue(String propertyFile, String propertyName) {
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
