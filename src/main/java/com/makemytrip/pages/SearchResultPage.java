package com.makemytrip.pages;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.makemytrip.utilities.DOMElementIdentifierReader;
import com.makemytrip.utilities.GeneralUtilties;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

/*
 * Goal: Search Result Class to apply/remove price filter and search the hotel
 */

public class SearchResultPage {
	
	private WebDriver driver;
	private WebDriverWait wait;
	String mainWindowHandle = "";
	protected ExtentTest test;
	
	public SearchResultPage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.wait = new WebDriverWait(this.driver, 60);
		this.test = test;
	}
	
	public void providePriceRangeFilterAndSelect(String max, String min) {
		/*
		 * Goal: To apply price range filter and select the hotel
		 * Parameters: max : Maximum price range
		 * 			   min : Minimum price range
		 */
		
		mainWindowHandle = driver.getWindowHandle();
		
		try {
			WebElement minRange = driver.findElement(By.name(DOMElementIdentifierReader.minSelector()));
			minRange.sendKeys(min);
		
			WebElement maxRange = driver.findElement(By.name(DOMElementIdentifierReader.maxSelector()));
			maxRange.sendKeys(max);
		
			WebElement applyFilter = driver.findElement(By.cssSelector(DOMElementIdentifierReader.filterApplySelector()));
			applyFilter.click();
			
			test.log(LogStatus.PASS, "Successfully applied price filter");
		}
		catch(Exception e) {
			test.log(LogStatus.FAIL, test.addScreenCapture(GeneralUtilties.capture(driver)), "Failed while applying price filters");
		}
		
		GeneralUtilties.sleep(10000);
		
		try {
			WebElement selectFirstSearchResult = wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.cssSelector(DOMElementIdentifierReader.searchResultSelector()))));
			selectFirstSearchResult.click();
		
			GeneralUtilties.sleep(10000);
			test.log(LogStatus.PASS, "Successfully selected first hotel after applying price filter");
		}
		catch(Exception e) {
			test.log(LogStatus.FAIL, test.addScreenCapture(GeneralUtilties.capture(driver)), "Failed selecting hotel after price filter application");
		}
		ArrayList<String> newTab = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(newTab.get(0));
		
	}
	
	public void removePriceRangeFilterAndSelect() {
		/*
		 * Goal: To remove price filter and select hotel
		 */
		try {
			WebElement removeFilter = driver.findElement(By.cssSelector(DOMElementIdentifierReader.removeFilterSelector()));
			removeFilter.click();
		
			GeneralUtilties.sleep(4000);

		
			WebElement selectFirstSearchResult1 = wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.cssSelector(DOMElementIdentifierReader.searchResultSelector()))));
			selectFirstSearchResult1.click();
			test.log(LogStatus.PASS, "Successfully selected first hotel after removal of price filter");
		}
		catch(Exception e) {
			test.log(LogStatus.FAIL, test.addScreenCapture(GeneralUtilties.capture(driver)), "Failed selecting hotel after removal of price filter");
		}
		
		
		driver.switchTo().window(mainWindowHandle);
		
	}

}
