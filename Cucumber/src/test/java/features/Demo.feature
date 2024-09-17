@E2E
Feature: saucedemo application Demo

  @smoke
  Scenario: Login should be success
    And User should enter the username as "standard_user"
    And User should enter the password as "secret_sauce"
    When User click on login button
    Then login should be success

  @smoke @reg
  Scenario: Login should be Fail
    And User should enter the username as "Teacher_user"
    And User should enter the password as "Password"
    When User click on login button
    But login should be fail
