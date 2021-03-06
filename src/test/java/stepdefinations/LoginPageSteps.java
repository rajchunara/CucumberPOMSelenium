package stepdefinations;

import java.util.List;

import com.pages.LoginPage;
import com.pages.ProductsPage;
import com.qa.factory.DriverFactory;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;

public class LoginPageSteps {
	
	private LoginPage loginPage= new LoginPage(DriverFactory.getDriver());
	private ProductsPage productsPage;
	private static String pageTitle;
	

@Given("user is on login page")
public void user_is_on_login_page() {
	DriverFactory.getDriver().get("https://www.saucedemo.com");
}


@When("user gets the title of the page")
public void user_gets_the_title_of_the_page() {
	pageTitle = loginPage.getLoginPageTitle();

}

@Then("page title should be {string}")
public void page_title_should_be(String expectedPageTitle) {
	
	Assert.assertTrue(pageTitle.equals(expectedPageTitle));
}

@Then("accepted usernames should be available with {string}")
public void accepted_usernames_should_be_available_with(String string) {
	
	Assert.assertTrue(loginPage.getAcceptedUsernameHeader());
}

@Then("accepted password should be available with {string}")
public void accepted_password_should_be_available_with(String string) {
	Assert.assertTrue(loginPage.getPasswordHeader());
}

@When("user enters username {string}")
public void user_enters_username(String username) {
	loginPage.enterUsername(username);
}

@When("user enters password {string}")
public void user_enters_password(String password) {
	loginPage.enterPassword(password);
}

@When("user clicks on Login button")
public void user_clicks_on_login_button() {
	productsPage = loginPage.clickLoginButton();
}

@Then("products page appear with header {string}")
public void products_page_appear_with_header(String string) {
	Assert.assertTrue(productsPage.isProductPageHeaderDisplayed());
}


@When("enters password {string}")
public void enters_password(String password) {
	loginPage.enterPassword(password);
}

@Then("page should display error")
public void page_should_display_error() {
	
	Assert.assertTrue(loginPage.isErrorElementDisplayed());
}


@Then("has error message {string}")
public void has_error_message(String expectedErrorMsg) {
	
	String errorMsg=loginPage.getErrorMessage();
	
	Assert.assertTrue(errorMsg.contains(expectedErrorMsg));
}

@Then("page should display error with message {string}")
public void page_should_display_error_with_message(String expectedErrorMessageForLockedUser) {
	String errorMsgOnPage = loginPage.getErrorMessage();
	Assert.assertTrue(errorMsgOnPage.contains(expectedErrorMessageForLockedUser));
}

@Then("image of all products is dog image with source {string}")
public void image_of_all_products_is_dog_image_with_source(String dogImgSrc) {
	
	Assert.assertTrue(productsPage.checkAllImageSrcOfProduct(dogImgSrc));
	
}

}
