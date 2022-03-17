Feature: As a business user
  I want to add and verify different products into my wish list
  Also I want to add and verify multiple products into my cart with different prices
  So that I can have better user journey experience


  Scenario: Verify that user is able to perform add and verification of the products into wish list and cart successfully
    Given I add four different products to my wish list
    When I view my wishlist table
    Then I find total four selected items in my Wishlist
    When I search for lowest price product
    And I am able to add the lowest price item to my cart
    Then I am able to verify the item in my cart
