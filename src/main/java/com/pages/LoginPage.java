package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	
	private WebDriver driver;
	
	// By locators
	private By usernameElement = By.id("user-name");
	private By passwordElement = By.id("password");	
	private By loginButton = By.id("login-button");
	private By acceptedUsernameHeader=By.xpath("//h4[text()=\"Accepted usernames are:\"]");
	private By acceptedPasswordHeader = By.xpath("//h4[text()=\"Password for all users:\"]");
	private By productsHeader = By.xpath("//div[text()=\"Products\"]");
	
	
	//constructor
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		
	}
	
	//page actions(methods)
	public String getLoginPageTitle() {
		return driver.getTitle();
	}
	
	public boolean getAcceptedUsernameHeader() {
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
	
	public void clickLoginButton() {
		driver.findElement(loginButton).click();
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
	
	

}
