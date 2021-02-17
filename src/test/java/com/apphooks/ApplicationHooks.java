package com.apphooks;

import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.qa.factory.DriverFactory;
import com.qa.util.ConfigReader;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class ApplicationHooks {

	
	private DriverFactory driverFactory;
	
	private WebDriver webDriver;
	private ConfigReader configReader;
	Properties prop;
	
	@Before(order=0)
	public void getProperty() {
		configReader = new ConfigReader();
		prop=configReader.init_props();
	}
	
	@Before(order = 1)
	public void launchBrowser() {
		String browser = prop.getProperty("browser");
		driverFactory = new DriverFactory();
		webDriver = driverFactory.init_driver(browser);
	}
	
	
	/*	This After will be executed at the end*/
	@After(order = 0)
	public void quidBrowser() {
		webDriver.quit();
	}
	
	@After(order=1)
	public void tearDown(Scenario sc) {
		
	/* Take screenshot if the scenario is failed */
		if(sc.isFailed()) {
			
			//Take screenshot
			byte[] sourcePath = ((TakesScreenshot)webDriver).getScreenshotAs(OutputType.BYTES);
			
			//create screenshot name from the actual screenshot
			String screenshotName = sc.getName().replaceAll(" ", "_");
			
			//storing it as image with screenshotName
			sc.attach(sourcePath, "image/png",screenshotName);
		}
	}
}
