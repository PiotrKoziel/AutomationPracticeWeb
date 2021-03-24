Feature: test performs validation of product name displayed on product page and product name displayed on search page


  Scenario: verifies,if user sees same product name on product page as on the search page
    Given user goes to web page
    When  user moves over womens link
    And   user click on T-shirts link
    And   user enters first product name in search bar
    And   user clicks search
    Then  user validates product name displayed on product page and search page