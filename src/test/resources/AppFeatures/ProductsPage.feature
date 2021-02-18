Feature: Products page feature

Background:
Given user is already logged in
|username|password|
|standard_user|secret_sauce|

Scenario: Six products available on products page
Given user is on Products page
Then search product list
And there should be six products in list

Scenario: Check product is available on the page
Given user is on Products page
Then product is available with name
|Sauce Labs Backpack|
|Sauce Labs Bike Light|
|Sauce Labs Bolt T-Shirt|
|Sauce Labs Fleece Jacket|
|Sauce Labs Onesie|
|Test.allTheThings() T-Shirt (Red)|