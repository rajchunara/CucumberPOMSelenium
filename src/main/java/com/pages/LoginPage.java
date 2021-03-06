package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
	
	private WebDriver driver;
	
	// By locators
	private By usernameElement = By.id("user-name");
	private By passwordElement = By.id("password");	
	private By loginButton = By.id("login-button");
	private By acceptedUsernameHeader=By.xpath("//h4[text()=\"Accepted usernames are:\"]");
	private By acceptedPasswordHeader = By.xpath("//h4[text()=\"Password for all users:\"]");
	private By productsHeader = By.xpath("//div[text()=\"Products\"]");
	private By errorHeader = By.xpath("//h3[@data-test=\"error\"]");
	
	
	//constructor
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		
	}
	
	//page actions(methods)
	public String getLoginPageTitle() {
		return driver.getTitle();
	}
	

	public boolean getAcceptedUsernameHeader() {
		System.out.println("getAcceptedUsernameHeader is executed");
//		System.out.println("Accepted username is displayed:" +driver.findElement(acceptedUsernameHeader).isDisplayed());

		return driver.findElement(acceptedUsernameHeader).isDisplayed();
	}
	
	public boolean getPasswordHeader() {
		return driver.findElement(acceptedPasswordHeader).isDisplayed();
	}
	
	
	public void enterUsername(String username) {
		driver.findElement(usernameElement).sendKeys(username);
	}
	
	public void enterPassword(String password) {
		driver.findElement(passwordElement).sendKeys(password);
	}
	
	public ProductsPage clickLoginButton() {
		driver.findElement(loginButton).click();
		
		return new ProductsPage(driver);
	}
	
	public boolean isProductsPageDisplayed() {
		return driver.findElement(productsHeader).isDisplayed();
	}
	
	
	public ProductsPage doLogin(String username, String password) {
		driver.findElement(usernameElement).sendKeys(username);
		driver.findElement(passwordElement).sendKeys(password);
		driver.findElement(loginButton).click();
		
		return new ProductsPage(driver);
		
	}
	

	
	
	//Errors WebElements checking
	public boolean isErrorElementDisplayed() {
		return driver.findElement(errorHeader).isDisplayed();
	}
	
	public String getErrorMessage() {
		return driver.findElement(errorHeader).getText();
	}
	
	

}
