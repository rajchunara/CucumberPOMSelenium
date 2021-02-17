Feature: Login page feature

Scenario: Login page title
Given user is on login page
When user gets the title of the page
Then page title should be "Swag Labs"

#Scenario: Forgot passowrd link
#Given user is on login page
#Then forgot password link should be displayed

Scenario: Login details on page
Given user is on login page
Then accepted usernames should be available with "Accepted usernames are:"
And accepted password should be available with "Password for all users:"

Scenario: Login with correct credentials
Given user is on login page
When user enters username "standard_user"
And user enters password "secret_sauce "
And user clicks on Login button
Then products page appear with header "Products"
And page title should be "Swag Labs"
