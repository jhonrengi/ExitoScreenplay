Feature: Add products to cart

  Scenario: Add products to cart success
    Given that user open page exito and select any category and select any subcategory
    When clicks on add on three products choosing their quantities and clicks on the shopping cart
    Then user will be able to see the selected products with their quantities

