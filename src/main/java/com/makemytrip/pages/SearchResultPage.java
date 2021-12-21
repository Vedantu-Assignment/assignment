package com.makemytrip.pages;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.makemytrip.utilities.DOMElementIdentifierReader;
import com.makemytrip.utilities.GeneralUtilties;

public class SearchResultPage {
	
	private WebDriver driver;
	private WebDriverWait wait;
	String mainWindowHandle = "";
	
	public SearchResultPage(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(this.driver, 60);
	}
	
	public void providePriceRangeFilterAndSelect(String max, String min) {
		
		mainWindowHandle = driver.getWindowHandle();
		
		WebElement minRange = driver.findElement(By.name(DOMElementIdentifierReader.minSelector()));
		minRange.sendKeys(min);
		
		WebElement maxRange = driver.findElement(By.name(DOMElementIdentifierReader.maxSelector()));
		maxRange.sendKeys(max);
		
		WebElement applyFilter = driver.findElement(By.cssSelector(DOMElementIdentifierReader.filterApplySelector()));
		applyFilter.click();
		
		GeneralUtilties.sleep(10000);
		
		WebElement selectFirstSearchResult = wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.cssSelector(DOMElementIdentifierReader.searchResultSelector()))));
		selectFirstSearchResult.click();
		
		GeneralUtilties.sleep(10000);
		
		ArrayList<String> newTab = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(newTab.get(0));
		
	}
	
	public void removePriceRangeFilterAndSelect() {
		
		WebElement removeFilter = driver.findElement(By.cssSelector(DOMElementIdentifierReader.removeFilterSelector()));
		removeFilter.click();
		
		GeneralUtilties.sleep(4000);

		
		WebElement selectFirstSearchResult1 = wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.cssSelector(DOMElementIdentifierReader.searchResultSelector()))));
		selectFirstSearchResult1.click();
		
		driver.switchTo().window(mainWindowHandle);
		
	}

}
