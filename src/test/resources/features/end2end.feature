Feature: Automated End to End Test
  As an employee of the company
  I want to test some feature
  In order to be confident that is works correctly

  Scenario: Customer replace an order
    Given user is on Home Page
    When he search for "dress"
    And choose to buy the first item
    And moves to checkout from mini cart
    And enter personal details on checkout page
    And select same delivery address
    And select payment method as "check" payment
    And place the order


