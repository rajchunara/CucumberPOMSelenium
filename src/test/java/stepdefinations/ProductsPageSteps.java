package stepdefinations;

import java.util.List;
import java.util.Map;

import com.pages.CartPage;
import com.pages.LoginPage;
import com.pages.ProductsPage;
import com.qa.factory.DriverFactory;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import junit.framework.Assert;


public class ProductsPageSteps {
	
	private LoginPage loginPage= new LoginPage(DriverFactory.getDriver());
	private ProductsPage productsPage;
	private CartPage cartPage;
	
	@Given("user is already logged in")
	public void user_is_already_logged_in(DataTable dataTable) {
		
		List<Map<String,String>> dataFromFeatureFile = dataTable.asMaps(); 
		
		String username= dataFromFeatureFile.get(0).get("username");
		String password=dataFromFeatureFile.get(0).get("password");
	
		DriverFactory.getDriver().get("https://www.saucedemo.com");
		
		productsPage = loginPage.doLogin(username, password);
	}

	@Given("user is on Products page")
	public void user_is_on_products_page() {
		String pageTitle = productsPage.getPageTitle();
	}

	@Then("search product list")
	public void search_product_list() {
	}

	@Then("there should be {int} products in list")
	public void there_should_be_products_in_list(Integer expectedProductsCount) {
		Assert.assertTrue(productsPage.getAllProductsCount() == expectedProductsCount);
	}

	@Then("product is available with name")
	public void product_is_available_with_name(DataTable dataTable) {
		List<String> expectedProductsList=dataTable.asList();
		List<String> actualProductsList = productsPage.getAllProductsList();
		
		Assert.assertTrue(expectedProductsList.containsAll(actualProductsList));
	}
	


	@Then("find product with title {string} and {string}")
	public void find_product_with_title_and(String string, String string2) {
		Assert.assertTrue(productsPage.checkIfProductsAreAvailableOnProductsPage());
	}

	@Then("click on add to cart button for all products")
	public void click_on_add_to_cart_button_for_all_products() {
		productsPage.addProductsToCart();
	}

	@Then("click on cart logo on top-right to move to cart page")
	public void click_on_cart_logo_on_top_right_to_move_to_cart_page() {
		cartPage = productsPage.goToCartPage();
	}

	@Then("verify those products with title {string} and {string} are present in cart")
	public void verify_those_products_with_title_and_are_present_in_cart(String string, String string2) {
		Assert.assertTrue(cartPage.checkIfProductsPresentInCart());
	}
	
	@Then("click on remove button of bike light product")
	public void click_on_remove_button_of_bike_light_product() {
		
		cartPage.clickOnRemoveProductButton();
	}

	@Then("check if the button is removed from the cart")
	public void check_if_the_button_is_removed_from_the_cart() {
		Assert.assertFalse(cartPage.isBikeLightPresentInCart());
		
	}
	
	
	


}
