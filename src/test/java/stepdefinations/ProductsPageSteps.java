package stepdefinations;

import java.util.List;
import java.util.Map;

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
	
	@Given("user is already logged in")
	public void user_is_already_logged_in(DataTable dataTable) {
		
		List<Map<String,String>> dataFromFeatureFile = dataTable.asMaps(); 
		
		String username= dataFromFeatureFile.get(0).get("username");
		String password=dataFromFeatureFile.get(0).get("password");
	
		DriverFactory.getDriver().get("https://www.saucedemo.com/index.html");
		
		productsPage = loginPage.doLogin(username, password);
	}

	@Given("user is on Products page")
	public void user_is_on_products_page() {
		String pageTitle = productsPage.getPageTitle();
		System.out.println("Products Page Title is :"+ pageTitle);
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
		System.out.println(expectedProductsList);
		List<String> actualProductsList = productsPage.getAllProductsList();
		System.out.println(actualProductsList);
		
		Assert.assertTrue(expectedProductsList.containsAll(actualProductsList));
	}


}
