package com.makemytrip.utilities;

public class DOMElementIdentifierReader {
	
	static String propertyFile = "DOMProperties.properties";
	
	public static String getBaseURL() {
		String propertyName = "homePageUrl";
		return PropertyFileReader.getPropertyValue(propertyFile, propertyName);
	}

	public static String getLoginSelector() {
		String propertyName = "loginButtonSelector";
		return PropertyFileReader.getPropertyValue(propertyFile, propertyName);
	}
	
	public static String emailSelector() {
		String propertyName = "emailIdSelector";
		return PropertyFileReader.getPropertyValue(propertyFile, propertyName);
	}
	
	public static String passwordSelector() {
		String propertyName = "passwordSelector";
		return PropertyFileReader.getPropertyValue(propertyFile, propertyName);
	}
	
	public static String getHotelPageURL() {
		String propertyName = "hotelPageUrl";
		return PropertyFileReader.getPropertyValue(propertyFile, propertyName);
	}
	
	public static String citySelector() {
		String propertyName = "citySelector";
		return PropertyFileReader.getPropertyValue(propertyFile, propertyName);
	}

	public static String cityAutoSuggestSelector() {
		String propertyName = "cityAutoSuggestSelector";
		return PropertyFileReader.getPropertyValue(propertyFile, propertyName);
	}
	
	public static String guestSelector() {
		String propertyName = "guestSelector";
		return PropertyFileReader.getPropertyValue(propertyFile, propertyName);
	}

	public static String guestCounterSelector() {
		String propertyName = "guestCounterSelector";
		return PropertyFileReader.getPropertyValue(propertyFile, propertyName);
	}
	
	public static String childAgeSelector() {
		String propertyName = "childAgeSelector";
		return PropertyFileReader.getPropertyValue(propertyFile, propertyName);
	}
	
	public static String searchApplySelector() {
		String propertyName = "searchApplySelector";
		return PropertyFileReader.getPropertyValue(propertyFile, propertyName);
	}
	
	public static String searchButtonSelector() {
		String propertyName = "searchButtonSelector";
		return PropertyFileReader.getPropertyValue(propertyFile, propertyName);
	}
	
	public static String minSelector() {
		String propertyName = "minSelector";
		return PropertyFileReader.getPropertyValue(propertyFile, propertyName);
	}
	
	public static String maxSelector() {
		String propertyName = "maxSelector";
		return PropertyFileReader.getPropertyValue(propertyFile, propertyName);
	}
	
	public static String filterApplySelector() {
		String propertyName = "filterApplySelector";
		return PropertyFileReader.getPropertyValue(propertyFile, propertyName);
	}
	
	public static String searchResultSelector() {
		String propertyName = "selectSearchResultSelector";
		return PropertyFileReader.getPropertyValue(propertyFile, propertyName);
	}
	
	public static String removeFilterSelector() {
		String propertyName = "removeFilterSelector";
		return PropertyFileReader.getPropertyValue(propertyFile, propertyName);
	}
	
	
	
	
	public static String getProfilePageUrl() {
		String propertyName = "profilePageUrl";
		return PropertyFileReader.getPropertyValue(propertyFile, propertyName);
	}
	
	public static String profilePageSidebarSelector() {
		String propertyName = "profilePageSidebarSelector";
		return PropertyFileReader.getPropertyValue(propertyFile, propertyName);
	}

	

	
}
