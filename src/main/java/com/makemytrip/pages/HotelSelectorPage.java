package com.makemytrip.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.makemytrip.utilities.DOMElementIdentifierReader;
import com.makemytrip.utilities.GeneralUtilties;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class HotelSelectorPage {

	private WebDriver driver;
	private WebDriverWait wait;
	protected ExtentTest test;
	
	public HotelSelectorPage(WebDriver driver, ExtentTest test) {
		
		this.driver = driver;
		this.wait = new WebDriverWait(this.driver, 60);
		this.test = test;
	}
	
	public void goToHotelsTab() {
		driver.get(DOMElementIdentifierReader.getHotelPageURL());
	}
	
	public void enterSearchCriteria(String cityName, int adultGuestCount, int childGuestCount, String childGuestAge, int numberOfDayAfterForBooking) {
		
		GeneralUtilties.sleep(5000);
		
		try {
			WebElement city = wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.id(DOMElementIdentifierReader.citySelector()))));
			city.click();
			WebElement cityAutoSuggest = driver.findElement(By.cssSelector(DOMElementIdentifierReader.cityAutoSuggestSelector()));
			cityAutoSuggest.sendKeys(cityName);
			cityAutoSuggest.sendKeys(Keys.ARROW_DOWN);
			cityAutoSuggest.sendKeys(Keys.ENTER);
		
			List<String> checkInOutDate = GeneralUtilties.dateCalculator(numberOfDayAfterForBooking); 
		
			WebElement checkInDate = driver.findElement(By.xpath("//div[@class='DayPicker-Day'][@aria-label='"+checkInOutDate.get(0)+"']"));
			checkInDate.click();
		
			WebElement checkOutDate = driver.findElement(By.xpath("//div[@class='DayPicker-Day'][@aria-label='"+checkInOutDate.get(1)+"']"));
			checkOutDate.click();
		
		
			WebElement roomAndGuest = driver.findElement(By.id(DOMElementIdentifierReader.guestSelector()));
			roomAndGuest.click();
		
			List<WebElement> counterList = driver.findElements(By.cssSelector(DOMElementIdentifierReader.guestCounterSelector()));
			guestSelector(adultGuestCount, counterList.get(0));
			guestSelector(childGuestCount, counterList.get(1));
	
			Select childAge = new Select(driver.findElement(By.className(DOMElementIdentifierReader.childAgeSelector())));
			childAge.selectByValue(childGuestAge);
			test.log(LogStatus.PASS, "Entered Search Criteria Successfully");
		}
		catch(Exception e) {
			test.log(LogStatus.FAIL, test.addScreenCapture(GeneralUtilties.capture(driver)), "Error while entering Search Criteria");
			
		}
		
		try {
			WebElement applyButton = wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.cssSelector(DOMElementIdentifierReader.searchApplySelector()))));
			applyButton.click();
		
			WebElement searchButton = wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.id(DOMElementIdentifierReader.searchButtonSelector()))));
			searchButton.click();
			test.log(LogStatus.PASS, "Successfully Searched list of hotels");
		}
		catch(Exception e) {
			test.log(LogStatus.FAIL, test.addScreenCapture(GeneralUtilties.capture(driver)), "Error while applying Search Criteria");
		}
		GeneralUtilties.sleep(10000);	
	
	}

	private void guestSelector(int adultGuestCount, WebElement adultCountList) {
		
		List<WebElement> options = adultCountList.findElements(By.tagName("li"));
		
		for(WebElement option: options) {
		
			if(Integer.parseInt(option.getText())==adultGuestCount) {
				option.click();
				break;
			}
		}
	}
}
