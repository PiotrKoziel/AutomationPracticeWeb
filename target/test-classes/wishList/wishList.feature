Feature:
  Scenario: Verifies, if not logged user sees displayed error message add
    Given user goes to web page
    When  user moves over womens link
    And   user click on T-shirts link
    And   user moves to displayed product
    And   user adds product to wishlist
    Then  user sees error message You must be logged in to manage your wishlist.
