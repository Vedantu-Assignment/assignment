package com.makemytripbookings.tests;

import com.makemytrip.pages.HotelSelectorPage;
import com.makemytrip.pages.LoginPage;
import com.makemytrip.pages.LogoutPage;
import com.makemytrip.pages.SearchResultPage;

import tests.BaseTest;

public class BookingReservationTest extends BaseTest {
	
	public void automationScenario() {
		
		SearchResultPage searchResultPage = new SearchResultPage(driver);
		searchResultPage.providePriceRangeFilterAndSelect("20000","1000");
		searchResultPage.removePriceRangeFilterAndSelect();
		
		LogoutPage logoutPage = new LogoutPage(driver);
		logoutPage.logout();
	}
	
	public static void main(String[] args) {
		
		BookingReservationTest b = new BookingReservationTest();
		b.automationScenario();
		
		
		
	}
	
}
