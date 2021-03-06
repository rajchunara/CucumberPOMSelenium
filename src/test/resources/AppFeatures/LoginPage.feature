Feature: Login page feature for saucedemo

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
And user enters password "secret_sauce"
And user clicks on Login button
Then products page appear with header "Products"
And page title should be "Swag Labs"

Scenario: Login with incorrect credentials
Given user is on login page
#Then error should not be displayed on the page
When user enters username "Incorrect_Username"
And enters password "Incorrect_Password"
And user clicks on Login button
Then page should display error 
And has error message "Username and password do not match any user in this service"

Scenario: Login for locked-out user
Given user is on login page
When user enters username "locked_out_user"
When user enters password "secret_sauce"
And user clicks on Login button
Then page should display error with message "Sorry, this user has been locked out."

Scenario: Login for problem user
Given user is on login page
When user enters username "problem_user"
When user enters password "secret_sauce"
And user clicks on Login button
Then products page appear with header "Products"
And image of all products is dog image with source "/static/media/sl-404.168b1cce.jpg"

