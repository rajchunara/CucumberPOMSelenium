package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutStepOnePage {
	
	private WebDriver driver;
	
	//By Locators
	private By subHeaderOfStepOnePage = By.xpath("//div[text()=\"Checkout: Your Information\"]");
	private By firstNameInput = By.id("first-name");
	private By lastNameInput = By.id("last-name");
	private By zipCodeInput = By.id("postal-code");
	private By continueButton = By.xpath("//input[@value=\"CONTINUE\"]");
	

	public CheckoutStepOnePage(WebDriver driver) {
		// TODO Auto-generated constructor stub		
		this.driver = driver;
	}
	
	
	public boolean isSubheaderOfStepOnePageDisplayed() {
		return driver.findElement(subHeaderOfStepOnePage).isDisplayed();
	}
	
	public void fillInputOnStepOnePage(String firstName, String lastName, String zipCode) {
		driver.findElement(firstNameInput).sendKeys(firstName);
		driver.findElement(lastNameInput).sendKeys(lastName);
		driver.findElement(zipCodeInput).sendKeys(zipCode);
	}
	
	public CheckoutStepTwoPage clickOnContinueButton() {
		driver.findElement(continueButton).click();
		
		return new CheckoutStepTwoPage(driver);
	}

}
