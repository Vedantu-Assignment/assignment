package com.makemytrip.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.makemytrip.utilities.DOMElementIdentifierReader;
import com.makemytrip.utilities.GeneralUtilties;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

/*
 * Goal: Logout Page class to logout from MakeMyTrip Portal 
 */

public class LogoutPage {

	private WebDriver driver;
	protected ExtentTest test;
	
	public LogoutPage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}
	
	public void logout() {
		/*
		 * Goal: To logout from MakeMyTrip Portal
		 */
		try {
			driver.get(DOMElementIdentifierReader.getProfilePageUrl());
		
			WebElement sideBarOptions = driver.findElement(By.className(DOMElementIdentifierReader.profilePageSidebarSelector()));
			List<WebElement> opt = sideBarOptions.findElements(By.tagName("li"));
		
			for(WebElement profileElement: opt) {
				if(profileElement.getText().equals("Logout")) {
					profileElement.click();
					break;
				}
			}
			test.log(LogStatus.PASS, "Successfully logged out from MakeMyTrip");
		}
		catch(Exception e) {
			test.log(LogStatus.FAIL, test.addScreenCapture(GeneralUtilties.capture(driver)), "Failed at logging out user from MakeMyTrip");
		}
	}
}