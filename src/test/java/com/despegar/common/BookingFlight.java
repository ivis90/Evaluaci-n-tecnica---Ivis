package com.despegar.common;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BookingFlight {
	
	private static final String DEPARTURE_MONTH = "Febrero";
	private static final String DEPARTURE_DAY = "10";
	private static final String RETURN_MONTH = "Febrero";
	private static final String RETURN_DAY = "20";

	private static final String DEPARTURE_CITY = "Carrasco International Airport, Montevideo, Uruguay";
	private static final String DESTINATION_CITY = "Arturo Merino Benitez Airport, Santiago, Chile";

	
	public static void flightSearch (WebDriver driver, WebDriverWait wait) {

		WebElement flightTab = driver.findElement(By.className("nevo-icon-flights"));
		flightTab.click();

		WebElement departureAerportInput = driver.findElement(By.xpath(
				"//*[@id=\"searchbox-sbox-all-boxes\"]/div[2]/div/div[2]/div[1]/div[1]/div/div[1]/div/div/div/input"));
		departureAerportInput.clear();
		departureAerportInput.sendKeys(DEPARTURE_CITY);

		WebElement departureInputNotification = driver.findElement(By.xpath(
				"//*[@id=\"searchbox-sbox-all-boxes\"]/div[2]/div/div[2]/div[1]/div[1]/div/div[1]/div/div/div/div/div[2]/div/div[1]/ul/li[1]"));
		wait.until(ExpectedConditions.invisibilityOf(departureInputNotification));

		WebElement departureAerports = driver.findElement(By.xpath(
				"//*[@id=\"searchbox-sbox-all-boxes\"]/div[2]/div/div[2]/div[1]/div[1]/div/div[1]/div/div/div/div/div[2]/div/div[1]/ul/li[1]"));
		departureAerports.click();
		wait.until(ExpectedConditions.invisibilityOf(departureAerports));

		WebElement destinationAerportInput = driver
				.findElement(By.className("sbox-bind-reference-flight-roundtrip-destination-input"));
		destinationAerportInput.sendKeys(DESTINATION_CITY);

		WebElement destinationInputNotification = driver.findElement(By.xpath(
				"//*[@id=\"searchbox-sbox-all-boxes\"]/div/div/div[2]/div[1]/div[1]/div/div[2]/div/div/div/div/div[2]/div/div[1]/ul/li[1]"));
		wait.until(ExpectedConditions.invisibilityOf(destinationInputNotification));

		WebElement destinationAerports = driver.findElement(By.xpath(
				"//*[@id=\"searchbox-sbox-all-boxes\"]/div/div/div[2]/div[1]/div[1]/div/div[2]/div/div/div/div/div[2]/div/div[1]/ul/li[1]"));
		destinationAerports.click();

		WebElement departureDateInput = driver.findElement(By.xpath(
				"//*[@id=\"searchbox-sbox-all-boxes\"]/div[2]/div/div[2]/div[1]/div[2]/div[1]/div[2]/div[1]/div[2]/input"));
		departureDateInput.click();

		Boolean isSelectedStartDate = false;
		Integer monthIndex = 1;
		while (!isSelectedStartDate) {

			WebElement startMonth = driver
					.findElement(By.xpath("/html/body/div[4]/div/div[3]/div[" + monthIndex + "]/div[1]/span[1]"));

			if (startMonth.getText().equals(DEPARTURE_MONTH)) {
				WebElement startDay = startMonth.findElement(By.xpath(
						"/html/body/div[4]/div/div[3]/div[" + monthIndex + "]/div[4]/span[" + DEPARTURE_DAY + "]"));
				startDay.click();
				wait.until(ExpectedConditions.visibilityOf(startDay));
				isSelectedStartDate = true;
			} else {
				driver.findElement(By.xpath("/html/body/div[4]/div/div[1]/div[2]/i")).click();
				monthIndex++;
			}
		}

		Boolean isSelectedEndDate = false;
		while (!isSelectedEndDate) {
			WebElement startMonth = driver
					.findElement(By.xpath("/html/body/div[4]/div/div[3]/div[" + monthIndex + "]/div[1]/span[1]"));

			if (startMonth.getText().equals(RETURN_MONTH)) {
				WebElement startDay = startMonth.findElement(By
						.xpath("/html/body/div[4]/div/div[3]/div[" + monthIndex + "]/div[4]/span[" + RETURN_DAY + "]"));
				startDay.click();
				wait.until(ExpectedConditions.visibilityOf(startDay));
				isSelectedEndDate = true;
			} else {
				driver.findElement(By.xpath("/html/body/div[4]/div/div[1]/div[2]/i")).click();
				monthIndex++;
			}
		}

		WebElement findButton = driver
				.findElement(By.xpath("//*[@id=\"searchbox-sbox-all-boxes\"]/div/div/div[2]/div[4]/div/a"));
		findButton.click();

		Boolean isClosedPopup = false;
		while (!isClosedPopup) {
			try {
				WebElement popup = driver.findElement(By.xpath("//*[@id=\"header\"]/div[3]/div[1]/i"));
				wait.until(ExpectedConditions.visibilityOf(popup));
				popup.click();
				isClosedPopup = true;
			} catch (Exception e) {
				sleep(1000);
			}
		}
	}
	
	public static void reservationCheckout(WebDriver driver, WebDriverWait wait) {
		
		sleep(5000);
		WebElement flightsContainer = driver.findElement(By.xpath("//*[@id=\"flights-container\"]/div/div/div/div[2]"));
		wait.until(ExpectedConditions.visibilityOf(flightsContainer));
		List<WebElement> flights = flightsContainer.findElements(By.className("fare-container"));

		float max = Float.parseFloat(flights.get(0).findElement(By.className("fare-price"))
				.findElement(By.className("price-amount")).getText());
		WebElement maxElem = flights.get(0);
		for (int i = 0; i < flights.size(); i++) {
			float value = Float.parseFloat(flights.get(i).findElement(By.className("fare-price"))
					.findElement(By.className("price-amount")).getText());
			if (value > max) {
				max = value;
				maxElem = flights.get(i);
			}
		}

		maxElem.findElement(By.className("eva-3-btn")).click();
	}
	
	private static void sleep(Integer millis) {
		try {
			Thread.sleep(millis);
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}

}
