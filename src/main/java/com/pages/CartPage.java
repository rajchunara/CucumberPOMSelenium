package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage {
	
	private WebDriver driver;
	
	//By Locators
	private By tShirtInCart = By.xpath("//div[@class=\"cart_list\"]//child::div[text()=\"Sauce Labs Bolt T-Shirt\"]");
	private By bikeLightInCart = By.xpath("//div[@class=\"cart_list\"]//child::div[text()=\"Sauce Labs Bike Light\"]");
	
	
	public CartPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
	}
	
	public boolean checkIfProductsPresentInCart() {
		boolean isBothProductsPresentInCart = driver.findElement(tShirtInCart).isDisplayed() && driver.findElement(bikeLightInCart).isDisplayed();
		return isBothProductsPresentInCart;
	}
	
	

}
