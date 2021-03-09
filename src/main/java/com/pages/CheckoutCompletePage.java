package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutCompletePage {
	
	private WebDriver driver;
	
	/* By Locators */
	private By subHeader = By.xpath("//div[text()=\"Finish\"]");
	private By confirmationMessage = By.xpath("//h2[text()=\"THANK YOU FOR YOUR ORDER\"]");

	public CheckoutCompletePage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
	}
	
	public String getSubHeader() {
		return driver.findElement(subHeader).getText();
	}
	
	public String getConfirmationMessageText() {
		return driver.findElement(confirmationMessage).getText();
	}
	
	public String getConfirmationPageURL() {
		return driver.getCurrentUrl();
	}
	
	
	
	

}
