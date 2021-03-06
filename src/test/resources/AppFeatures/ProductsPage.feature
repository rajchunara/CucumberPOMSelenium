Feature: Products page feature

Background:
Given user is already logged in
|username|password|
|standard_user|secret_sauce|

Scenario: Six products available on products page
Given user is on Products page
Then search product list
And there should be 6 products in list

Scenario: Check product is available on the page
Given user is on Products page
Then product is available with name
|Sauce Labs Backpack|
|Sauce Labs Bike Light|
|Sauce Labs Bolt T-Shirt|
|Sauce Labs Fleece Jacket|
|Sauce Labs Onesie|
|Test.allTheThings() T-Shirt (Red)|

Scenario: Add product to the cart feature
Given user is on Products page
Then find product with title "Sauce Labs Bolt T-Shirt" and "Sauce Labs Bike Light"
And click on add to cart button for all products
Then click on cart logo on top-right to move to cart page
And verify those products with title "Sauce Labs Bolt T-Shirt" and "Sauce Labs Bike Light" are present in cart
