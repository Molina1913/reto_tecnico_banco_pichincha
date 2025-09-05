Feature: Purchase flow in SauceDemo

  As an authenticated SauceDemo user
  I want to be able to successfully complete a purchase
  To verify that the E2E flow is working correctly

  Background:
    Given the user opens the SauceDemo app


  Scenario: User completes a successful purchase
    When the user logs in with valid credentials username "standard_user" paswword "secret_sauce"
    And adds two products to the cart
    And views the cart
    And completes the purchase form with the following information first name "Luis" last name "Molina" postal code "050001"
    Then the user should see the confirmation message "THANK YOU FOR YOUR ORDER"

