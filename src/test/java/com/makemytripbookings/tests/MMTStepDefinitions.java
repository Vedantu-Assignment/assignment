package com.makemytripbookings.tests;


import com.makemytrip.pages.HotelSelectorPage;
import com.makemytrip.pages.LoginPage;
import com.makemytrip.pages.LogoutPage;
import com.makemytrip.pages.SearchResultPage;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import tests.BaseTest;


public class MMTStepDefinitions extends BaseTest{
	
	LoginPage loginPage = null;
	HotelSelectorPage hotelSelectorPage = null;
	SearchResultPage searchResultPage = null;
	LogoutPage logoutPage = null;
	
	@Before
	public void beforeScenarios() {
		
		loginPage = new LoginPage(driver, test);
		hotelSelectorPage = new HotelSelectorPage(driver, test);
		searchResultPage = new SearchResultPage(driver, test);
		logoutPage = new LogoutPage(driver, test);
		
	}
	
	@After
	public void afterScenarios() {
		tearDown();
	}

	@Given("^I navigate to makemytrip website$")
	public void navigate_to_makemytrip_website() {
		loginPage.goToLandingSite();
	}
	
	@And("^I login using username \"(.*?)\" and password \"(.*?)\"$")
	public void loginUsingSingleSignOn(String username, String password) {
		loginPage.singleSignOnToMMT(username, password);
	}
	
	@Then("^I navigate to hotels tab$")
	public void navigate_to_hotels_tab() {
		hotelSelectorPage.goToHotelsTab();
	}
	
	@And("^I search Hotel in \"(.*?)\" for \"(.*?)\" Adults and \"(.*?)\" child of \"(.*?)\" years. I book after \"(.*?)\" days from now$")
	public void searchHotel(String city, String numberOfAdults, String numberOfChildren, String ageOfChild, String numberOfDaysAfterForBooking) {
		hotelSelectorPage.enterSearchCriteria(city, Integer.parseInt(numberOfAdults), Integer.parseInt(numberOfChildren), ageOfChild, Integer.parseInt(numberOfDaysAfterForBooking));
	}
	
	@Then("^I apply price filter of minimum \"(.*?)\" to maximum \"(.*?)\" and select first hotel$")
	public void apply_price_filter_and_select_hotel(String min, String max) {
		searchResultPage.providePriceRangeFilterAndSelect(max, min);
	}
	
	@Then("^I remove the price filter and select first hotel$")
	public void remove_price_filter_and_select_hotel() {
		searchResultPage.removePriceRangeFilterAndSelect();
	}
	
	@And("^I logout from makemytrip$")
	public void logout_from_makemytrip() {
		logoutPage.logout();
	}
	
	
	
	
}
