package com.makemytrip.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.makemytrip.utilities.DOMElementIdentifierReader;

public class LogoutPage {

	private WebDriver driver;
	
	public LogoutPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void logout() {
		driver.get(DOMElementIdentifierReader.getProfilePageUrl());
		
		WebElement sideBarOptions = driver.findElement(By.className(DOMElementIdentifierReader.profilePageSidebarSelector()));
		List<WebElement> opt = sideBarOptions.findElements(By.tagName("li"));
		
		for(WebElement profileElement: opt) {
			if(profileElement.getText().equals("Logout")) {
				profileElement.click();
				break;
			}
		}
		
	}
}
