package com.makemytrip.pages;

import java.util.Iterator;
import java.util.Set;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.makemytrip.utilities.DOMElementIdentifierReader;
import com.makemytrip.utilities.GeneralUtilties;

public class LoginPage {
	
	private WebDriver driver;
	String mainWindowHandle = "";
	
	public LoginPage(WebDriver driver) {
		
		this.driver = driver;
		
	}
	
	public void goToLandingSite(){
		/*
		 * Goal : To navigate to MakeMyTrip landing site
		 */
		driver.get(DOMElementIdentifierReader.getBaseURL());
		mainWindowHandle = driver.getWindowHandle();
	
	}

	
	public String singleSignOnToMMT(String emailId, String secretKey) {
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
					
				}
		}
		
		GeneralUtilties.sleep(12000);
		
		driver.switchTo().window(mainWindowHandle);
		return mainWindowHandle;
	}

}
