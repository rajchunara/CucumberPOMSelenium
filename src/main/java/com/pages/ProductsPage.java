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
private By productsHeader = By.xpath("//div[text()=\"Products\"]");
private By allProductsImage = By.xpath("inventory_item_img");


//constructor
public ProductsPage(WebDriver driver) {
	this.driver = driver;
}

//page actions

public String getPageTitle() {
	return driver.getTitle();
}

public boolean isProductPageHeaderDisplayed() {
	return driver.findElement(productsHeader).isDisplayed();
	
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

public List<String> getAllProductsImageSrc(){
	List<WebElement> allProductsImages = driver.findElements(allProductsImage);
	List<String> imgSrcList = new ArrayList<String>();
	
	for (WebElement e: allProductsImages) {
		imgSrcList.add(e.getAttribute("src"));
	}
	
	return imgSrcList;
	
}

public boolean checkAllImageSrcOfProduct(String expectedImgSrc) {
	
	List<String> actualImageSrcOfProducts = getAllProductsImageSrc();
	boolean result=true;
	
	for(String e: actualImageSrcOfProducts) {
		if(!e.contentEquals(expectedImgSrc)) {
			result = false;
			break;
		};
	}
	
	return result;
}


}
