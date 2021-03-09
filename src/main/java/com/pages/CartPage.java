package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage {
	
	private WebDriver driver;
	
	//By Locators
	private By tShirtInCart = By.xpath("//div[@class=\"cart_list\"]//child::div[text()=\"Sauce Labs Bolt T-Shirt\"]");
	private By bikeLightInCart = By.xpath("//div[@class=\"cart_list\"]//child::div[text()=\"Sauce Labs Bike Light\"]");
	
	private By removeButtonOfBikeLight = By.xpath("//div[text()=\"Sauce Labs Bike Light\"]//ancestor::div[@class=\"cart_item\"]//child::button[text()=\"REMOVE\"]");
	private By checkoutButton = By.xpath("//a[text()=\"CHECKOUT\"]");
	
	
	public CartPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
	}
	
	public boolean checkIfProductsPresentInCart() {
		boolean isBothProductsPresentInCart = driver.findElement(tShirtInCart).isDisplayed() && driver.findElement(bikeLightInCart).isDisplayed();
		return isBothProductsPresentInCart;
	}
	
	public void clickOnRemoveProductButton() {
		driver.findElement(removeButtonOfBikeLight);
	}
	
	public boolean isBikeLightPresentInCart() {
		if(driver.findElements(By.xpath("value")).size() != 0){
			return true;
			}else{
			return false;
			}
	}
	
	public CheckoutStepOnePage clickOnCheckoutButton() {
		driver.findElement(checkoutButton).click();
		
		return new CheckoutStepOnePage(driver);
	}
	
	public String getCartPageURL() {
		return driver.getCurrentUrl();
	}
	
	

}
