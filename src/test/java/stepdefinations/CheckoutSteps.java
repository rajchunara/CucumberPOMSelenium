package stepdefinations;

import java.util.List;
import java.util.Map;

import com.pages.CartPage;
import com.pages.CheckoutCompletePage;
import com.pages.CheckoutStepOnePage;
import com.pages.CheckoutStepTwoPage;
import com.pages.LoginPage;
import com.pages.ProductsPage;
import com.qa.factory.DriverFactory;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import junit.framework.Assert;

public class CheckoutSteps {

	private LoginPage loginPage= new LoginPage(DriverFactory.getDriver());
	private ProductsPage productsPage;
	private CartPage cartPage;
	private CheckoutStepOnePage checkoutStepOnePage;
	private CheckoutStepTwoPage checkoutStepTwoPage;
	private CheckoutCompletePage checkoutCompletePage;


	/* Step definations */
	@Given("User is on login page of swaglabs")
	public void user_is_on_login_page_of_swaglabs() {
		DriverFactory.getDriver().get("https://www.saucedemo.com");
	}

	@Then("log in with credentials")
	public void log_in_with_credentials(io.cucumber.datatable.DataTable dataTable) {
		List<Map<String,String>> dataFromFeatureFile = dataTable.asMaps(); 

		String username= dataFromFeatureFile.get(0).get("username");
		String password=dataFromFeatureFile.get(0).get("password");

		DriverFactory.getDriver().get("https://www.saucedemo.com");

		productsPage = loginPage.doLogin(username, password);
	}

	@Given("user is on Products page for checkout feature")
	public void user_is_on_products_page_for_checkout_feature() {
		String productPageUrl = productsPage.getProductPageURL();
		
		Assert.assertEquals("https://www.saucedemo.com/inventory.html", productPageUrl);
		
	}

	@Then("add products to the cart")
	public void add_products_to_the_cart() {
		productsPage.addProductsToCart();
	}

	@Then("click on cart logo to move to cart page")
	public void click_on_cart_logo_to_move_to_cart_page() {
		cartPage = productsPage.goToCartPage();
	}

	@Given("user is on cart page")
	public void user_is_on_cart_page() {
		Assert.assertEquals("https://www.saucedemo.com/cart.html", cartPage.getCartPageURL());
	}



	@Then("click on checkout button to move to step-one page of checkout")
	public void click_on_checkout_button_to_move_to_step_one_page_of_checkout() {
		
		checkoutStepOnePage = cartPage.clickOnCheckoutButton();

	}

	@Then("check if subheader is displayed on step-one page")
	public void check_if_subheader_is_displayed_on_step_one_page() {
		Assert.assertTrue(checkoutStepOnePage.isSubheaderOfStepOnePageDisplayed());
		
	}

	@Then("Enter following information to input")
	public void enter_following_information_to_inpu(DataTable dataTable) {
		List<Map<String,String>>  inputDataFromFeatureFile = dataTable.asMaps();
		
		String firstName = inputDataFromFeatureFile.get(0).get("firstname");
		String lastName = inputDataFromFeatureFile.get(0).get("lastname");
		String zipCode = inputDataFromFeatureFile.get(0).get("zipcode");
		
		checkoutStepOnePage.fillInputOnStepOnePage(firstName, lastName, zipCode);
		
		
	}

	@Then("click on continue button which navigates to step-two page")
	public void click_on_continue_button_which_navigates_to_step_two_page() {
		checkoutStepTwoPage = checkoutStepOnePage.clickOnContinueButton();
		
		Assert.assertEquals("https://www.saucedemo.com/checkout-step-two.html", checkoutStepTwoPage.getStepTwoPageURL());
	}

	@Then("check the subheader on step-two page")
	public void check_the_subheader_on_step_two_page() {
		Assert.assertEquals("Checkout: Overview", checkoutStepTwoPage.getSubHeader());
	}

	@Then("click on finish button which takes you to checkout-complete page")
	public void click_on_finish_button_which_takes_you_to_checkout_complete_page() {
		
		checkoutCompletePage = checkoutStepTwoPage.clickOnFinishButton();
		
		Assert.assertEquals("https://www.saucedemo.com/checkout-complete.html", checkoutCompletePage.getConfirmationPageURL());
		
	}

	@Then("check if there is message {string}")
	public void check_if_there_is_message(String message) {
		Assert.assertEquals(message	, checkoutCompletePage.getConfirmationMessageText());
		
	}


}
