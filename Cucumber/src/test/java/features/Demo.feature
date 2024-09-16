Feature: saucedemo application Demo

Scenario: Login should be success

Given user should naviagate to the application
And User should enter the username as "standard_user"
And  User should enter the password as "secret_sauce"
When User click on login button
Then login should be success


Scenario: Login should be Fail

Given user should naviagate to the application
And User should enter the username as "Teacher_user"
And  User should enter the password as "Password"
When User click on login button
But login should be fail