package com.despegar;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.despegar.common.BookingHotel;
import com.despegar.common.WebDriverFactory;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class HotelSearchTest {

	private static WebDriver driver;
	private static WebDriverWait wait;
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {

		driver = WebDriverFactory.getWebDriver();

		wait = new WebDriverWait(driver, 10);

	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		driver.quit();
	}

	@Test
	void hotelSearchResultCheck01() {
		BookingHotel.searchHotel(driver, wait);
		Assert.assertEquals("Hoteles - Despegar.com", driver.getTitle());
	}
	
	@Test
	void hotelSerachResultCheck02() {
		Assert.assertEquals(BookingHotel.serachFiveStarHotel(driver, wait), driver.getTitle());
	}
	
	@Test
	void hotelSerachResultCheck03() {
		sleep(2000);
		WebElement roomsTab = driver.findElement(By.xpath("//*[@id=\"hf-rooms-new\"]/div"));
		wait.until(ExpectedConditions.visibilityOf(roomsTab));
		Assert.assertTrue(roomsTab.isDisplayed());
	}
	
	private static void sleep(Integer millis) {
		try {
			Thread.sleep(millis);
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}
	
}
