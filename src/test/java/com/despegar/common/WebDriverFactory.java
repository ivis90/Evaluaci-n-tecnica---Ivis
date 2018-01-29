package com.despegar.common;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverFactory {
	
	public static WebDriver getWebDriver() {
		System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		driver.get("https://www.despegar.com.ar");

		WebElement popup = driver.findElement(By.xpath("/html/body/div[16]/div/div[1]/span"));
		popup.click();
		
		return driver;
	}

}
