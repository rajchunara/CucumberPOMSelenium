package com.qa.factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {
	
	public WebDriver driver;
	public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();
	
	
	/*
	 * This method is used to initialize the web driver based on the argument passed
	 * @param browser
	 * @return WebDriver 	
	 */
	public WebDriver init_driver(String browser) {
		System.out.println("browser value is "+browser);
		
		if(browser.equals("chrome")) {
			WebDriverManager.chromedriver().setup();	
			
			tlDriver.set(new ChromeDriver());
		}else if(browser.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			tlDriver.set(new FirefoxDriver());
		}else {
			System.out.println("Please pass correct browser value"+ browser);
		}
		
		performInitialTasksOnWebDriver();
		
		return getDriver();
		
	}
	
	
	
	public static synchronized WebDriver getDriver() {
		return tlDriver.get();
	}
	
	public void performInitialTasksOnWebDriver() {
		getDriver().manage().deleteAllCookies();
		getDriver().manage().window().maximize();
	}
	
}
