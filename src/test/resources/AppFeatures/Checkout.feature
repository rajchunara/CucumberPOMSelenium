Feature: Checkout feature

  Background: 
  	
    Given User is on login page of swaglabs
    Then log in with credentials
      | username      | password     |
      | standard_user | secret_sauce |
    Given user is on Products page for checkout feature
    Then add products to the cart
    Then click on cart logo to move to cart page

  Scenario: test checkout feature
  	Given user is on cart page
    Then click on checkout button to move to step-one page of checkout
    And check if subheader is displayed on step-one page
    Then Enter following information to input
      | firstname | lastname | zipcode |
      | raj       | chunara  | K1K1K1  |
    And click on continue button which navigates to step-two page
    Then check the subheader on step-two page
    And click on finish button which takes you to checkout-complete page
    And check if there is message "THANK YOU FOR YOUR ORDER"
