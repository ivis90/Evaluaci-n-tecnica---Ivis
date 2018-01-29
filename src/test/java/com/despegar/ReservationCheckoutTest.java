package com.despegar;

import org.junit.Assert;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.despegar.common.BookingFlight;
import com.despegar.common.WebDriverFactory;

public class ReservationCheckoutTest {
	
	
	private static WebDriver driver;
	private static WebDriverWait wait;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {

		driver = WebDriverFactory.getWebDriver();

		wait = new WebDriverWait(driver, 10);
		
		BookingFlight.flightSearch(driver, wait);
		BookingFlight.reservationCheckout(driver, wait);
		sleep(2000);
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		driver.quit();
	}
	
	@Test
	void reservationCheckoutCheck() {
		Assert.assertEquals("Despegar.com - Checkout de compra", driver.getTitle());
	}
	
	@Test
	void passengersContainerCheck() {
		WebElement passengersContainer = driver.findElement(By.xpath("//*[@id=\"passengers-container\"]/div[1]/div[1]"));
		wait.until(ExpectedConditions.visibilityOf(passengersContainer));
		Assert.assertTrue(passengersContainer.isDisplayed());
	}
	
	@Test
	void paymentCheck() {
		WebElement payment = driver.findElement(By.xpath("//*[@id=\"payment\"]/span"));
		wait.until(ExpectedConditions.visibilityOf(payment));
		Assert.assertTrue(payment.isDisplayed());
	}
	
	@Test
	void invoiceCheck() {
		WebElement invoice = driver.findElement(By.xpath("//*[@id=\"invoice\"]/span"));
		wait.until(ExpectedConditions.visibilityOf(invoice));
		Assert.assertTrue(invoice.isDisplayed());
	}
	
	@Test
	void contactCheck() {
		WebElement contact = driver.findElement(By.xpath("//*[@id=\"contact\"]/div[3]/span"));
		wait.until(ExpectedConditions.visibilityOf(contact));
		Assert.assertTrue(contact.isDisplayed());
	}
	
	private static void sleep(Integer millis) {
		try {
			Thread.sleep(millis);
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}

}
