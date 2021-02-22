package com.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProductsPage {
private WebDriver driver;

//By Locators
private By allProducts = By.cssSelector("div.inventory_list div.inventory_item_name");


//constructor
public ProductsPage(WebDriver driver) {
	this.driver = driver;
}

//page actions

public String getPageTitle() {
	return driver.getTitle();
}

public int getAllProductsCount() {
	return driver.findElements(allProducts).size();
}


public List<String> getAllProductsList() {
	List<WebElement> productsListElements = driver.findElements(allProducts);
	List<String> productsList= new ArrayList<String>();
	
	for(WebElement e: productsListElements) {
		productsList.add(e.getText());
	}
	
	return productsList;
}


}
