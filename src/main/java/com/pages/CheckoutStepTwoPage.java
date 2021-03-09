package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutStepTwoPage {
	private WebDriver driver;
	
	/* By Locators */
	private By subHeader = By.xpath("//div[text()=\"Checkout: Overview\"]");
	private By finishButton = By.xpath("//a[text()=\"FINISH\"]");

	public CheckoutStepTwoPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
	}
	
	public String getSubHeader() {
		return driver.findElement(subHeader).getText();
	}
	
	public String getStepTwoPageURL() {
		return driver.getCurrentUrl();
	}
	
	public CheckoutCompletePage clickOnFinishButton() {
		driver.findElement(finishButton).click();
		
		return new CheckoutCompletePage(driver);
	}
	
	

}
