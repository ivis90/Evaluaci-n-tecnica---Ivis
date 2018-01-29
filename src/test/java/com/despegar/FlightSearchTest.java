package com.despegar;

import org.junit.Assert;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.despegar.common.BookingFlight;
import com.despegar.common.WebDriverFactory;

public class FlightSearchTest {
	
	private static WebDriver driver;
	private static WebDriverWait wait;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {

		driver = WebDriverFactory.getWebDriver();

		wait = new WebDriverWait(driver, 10);
		
		BookingFlight.flightSearch(driver, wait);
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		driver.quit();
	}
	
	@Test
	void flightSearchResultCheck() {
		Assert.assertEquals("Despegar.com . Resultados de Vuelos", driver.getTitle());
	}
}
