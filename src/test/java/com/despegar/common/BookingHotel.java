package com.despegar.common;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BookingHotel {

	private static final String DESTINATION_CITY = "Montevideo, Montevideo, Uruguay";

	public static void searchHotel(WebDriver driver, WebDriverWait wait) {
		WebElement hotel = driver.findElement(By.className("nevo-icon-hotels"));
		hotel.click();

		WebElement destinationInput = driver.findElement(
				By.xpath("//*[@id=\"searchbox-sbox-all-boxes\"]/div[2]/div/div[2]/div[1]/div/div/div/div/input"));
		destinationInput.sendKeys(DESTINATION_CITY);

		WebElement destinationInputNotification = driver.findElement(By.xpath(
				"//*[@id=\"searchbox-sbox-all-boxes\"]/div/div/div[2]/div[1]/div/div/div/div/div/div[2]/div/div[1]/ul/li[1]"));
		wait.until(ExpectedConditions.invisibilityOf(destinationInputNotification));

		WebElement destinationHotel = driver.findElement(By.xpath(
				"//*[@id=\"searchbox-sbox-all-boxes\"]/div/div/div[2]/div[1]/div/div/div/div/div/div[2]/div/div[1]/ul/li[1]"));
		destinationHotel.click();

		Locale LOCALE_ES = new Locale("es", "ES");
		DateFormat dateFormat = new SimpleDateFormat("d/MMMM/YYYY", LOCALE_ES);
		Date checkinDate = new Date();
		Calendar cal = Calendar.getInstance();
		cal.setTime(checkinDate);

		cal.add(Calendar.DATE, 10);
		checkinDate = cal.getTime();
		String date1 = dateFormat.format(checkinDate);

		cal.add(Calendar.DATE, 3);
		checkinDate = cal.getTime();
		String date2 = dateFormat.format(checkinDate);

		String splitter1[] = date1.split("/");
		String inDay = splitter1[0];
		String inMonth = splitter1[1];

		String splitter2[] = date2.split("/");
		String outDay = splitter2[0];
		String outMonth = splitter2[1];

		driver.findElement(By.xpath(
				"//*[@id=\"searchbox-sbox-all-boxes\"]/div/div/div[2]/div[2]/div[1]/div[1]/div[2]/div[1]/div[2]/input"))
				.click();

		List<WebElement> startDate = driver.findElements(By.className("_dpmg2--months"));
		Integer pos = 0;
		for (int i = 0; i < startDate.size(); i++) {

			WebElement month = driver
					.findElement(By.xpath("/html/body/div[1]/div/div[3]/div[" + (i + 1) + "]/div[1]/span[1]"));
			if (month.getText().split("\n")[0].toLowerCase().equals(inMonth)) {
				WebElement day = month.findElement(
						By.xpath("/html/body/div[1]/div/div[3]/div[" + (i + 1) + "]/div[4]/span[" + inDay + "]"));
				day.click();
				wait.until(ExpectedConditions.visibilityOf(day));
				pos = i;
				break;
			} else {
				driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/div[2]/i")).click();
			}
		}

		List<WebElement> endDate = driver.findElements(By.className("_dpmg2--months"));
		for (int i = pos; i < endDate.size(); i++) {

			WebElement month = driver
					.findElement(By.xpath("/html/body/div[1]/div/div[3]/div[" + (i + 1) + "]/div[1]/span[1]"));
			if (month.getText().split("\n")[0].toLowerCase().equals(outMonth)) {
				WebElement day = month.findElement(
						By.xpath("/html/body/div[1]/div/div[3]/div[" + (i + 1) + "]/div[4]/span[" + outDay + "]"));
				day.click();
				break;
			} else {
				driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/div[2]/i")).click();
			}
		}

		WebElement room = driver.findElement(By.xpath(
				"//*[@id=\"searchbox-sbox-all-boxes\"]/div/div/div[2]/div[2]/div[1]/div[2]/div[2]/div[1]/div/input"));
		room.click();
		WebElement minorsInput = driver
				.findElement(By.xpath("/html/body/div[2]/div/div[2]/div[1]/div[2]/div[2]/div[2]/div/a[2]"));
		minorsInput.click();
		WebElement ageMinorsButton = driver
				.findElement(By.xpath("/html/body/div[2]/div/div[2]/div[1]/div[2]/div[3]/div[1]/div[2]/div/div"));
		ageMinorsButton.click();
		WebElement ageMinorsSelection = driver.findElement(
				By.xpath("/html/body/div[2]/div/div[2]/div[1]/div[2]/div[3]/div[1]/div[2]/div/div/select/option[14]"));
		ageMinorsSelection.click();
		WebElement applyButton = driver.findElement(By.xpath("/html/body/div[2]/div/div[3]/a[1]"));
		applyButton.click();

		WebElement searchButton = driver
				.findElement(By.xpath("//*[@id=\"searchbox-sbox-all-boxes\"]/div/div/div[2]/div[2]/div[2]/a/em"));
		searchButton.click();
	}

	public static String serachFiveStarHotel(WebDriver driver, WebDriverWait wait) {

		sleep(5000);
		WebElement popup = driver.findElement(By.xpath("//*[@id=\"header\"]/div[3]/div[2]/div/a[2]"));
		wait.until(ExpectedConditions.visibilityOf(popup));
		popup.click();

		WebElement stars = driver
				.findElement(By.xpath("//*[@id=\"filtersHolder\"]/ul[3]/li[1]/ul/li[2]/span/span[1]/span/label/input"));
		stars.click();

		// Selecting the lower price hotel
		sleep(5000);
		WebElement hotelsComponet = driver.findElement(By.xpath("//*[@id=\"hotels\"]"));
		wait.until(ExpectedConditions.visibilityOf(hotelsComponet));
		List<WebElement> hotels = hotelsComponet.findElements(By.className("results-cluster-container"));
		String price = hotels.get(0).findElement(By.className("hf-cluster")).getAttribute("data-price").toString();
		price = price.replaceAll("\\.", "");
		price = price.replaceAll(",", ".");
		float lowPrice = Float.parseFloat(price);
		WebElement minElem = hotels.get(0);
		for (int i = 1; i < hotels.size(); i++) {
			price = hotels.get(i).findElement(By.className("hf-cluster")).getAttribute("data-price").toString();
			price = price.replaceAll("\\.", "");
			price = price.replaceAll(",", ".");
			float value = Float.parseFloat(price);
			if (value < lowPrice) {
				lowPrice = value;
				minElem = hotels.get(i);
			}
		}

		String hotelName = minElem.findElement(By.className("hf-hotel-name")).getText();
		minElem.findElement(By.className("eva-3-btn")).click();

		List<String> browserTabs = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(browserTabs.get(1));

		return hotelName;
	}

	private static void sleep(Integer millis) {
		try {
			Thread.sleep(millis);
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}

}
