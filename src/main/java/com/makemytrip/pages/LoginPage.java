package com.makemytrip.pages;

import java.util.Iterator;
import java.util.Set;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.makemytrip.utilities.DOMElementIdentifierReader;
import com.makemytrip.utilities.GeneralUtilties;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;


public class LoginPage {
	
	private WebDriver driver;
	String mainWindowHandle = "";
	protected ExtentTest test;
	
	public LoginPage(WebDriver driver, ExtentTest test) {
		
		this.driver = driver;
		this.test = test;
		
	}
	
	public void goToLandingSite(){
		/*
		 * Goal : To navigate to MakeMyTrip landing site
		 */
		try {
			driver.get(DOMElementIdentifierReader.getBaseURL());
			mainWindowHandle = driver.getWindowHandle();
			test.log(LogStatus.PASS, "Launched MakeMyTrip Site");
		}
		catch(Exception exception) {
			test.log(LogStatus.FAIL, "Exception while loading MakeMyTrip Site"+exception);
		}
	
	}

	
	public String singleSignOnToMMT(String emailId, String secretKey) {
		
		boolean loginSuccessful = false;
		
		WebElement login = driver.findElement(By.cssSelector(DOMElementIdentifierReader.getLoginSelector()));
		login.click();
		
		Set<String> windowHandles = driver.getWindowHandles();
		
		Iterator<String> windowIterator = windowHandles.iterator();
		
		while(windowIterator.hasNext()) {
			String childWindow = windowIterator.next();
				if(!mainWindowHandle.equalsIgnoreCase(childWindow)) {
					driver.switchTo().window(childWindow);
					WebElement email = driver.findElement(By.id(DOMElementIdentifierReader.emailSelector()));
					email.sendKeys(emailId);
					email.sendKeys(Keys.ENTER);
					
					GeneralUtilties.sleep(10000);
					
					WebElement password = driver.findElement(By.name(DOMElementIdentifierReader.passwordSelector()));
					password.sendKeys(secretKey);
					password.sendKeys(Keys.ENTER);
					
					loginSuccessful = true;
					
				}
		}
		
		if(loginSuccessful) {
			test.log(LogStatus.PASS, "Single Sign On Successful!");
		}
		else if(!loginSuccessful) {
			test.log(LogStatus.FAIL, test.addScreenCapture(GeneralUtilties.capture(driver)) ,"Single Sign On Failed");
		}
		
		GeneralUtilties.sleep(12000);
		
		driver.switchTo().window(mainWindowHandle);
		return mainWindowHandle;
	}

}
