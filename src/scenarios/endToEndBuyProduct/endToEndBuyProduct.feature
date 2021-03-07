Feature: tests perform end to end buy order functionality,
  and adding product to wishlist as a not logged in user

  Scenario Outline: Verifies, if user goes step by step order process
    Given  user goes to web page
    When   user goes to login page
    And    user logs in to app with following email <email> and password <password>
    Then   user moves over womens link
    When   user chooses <product> product
    And    user moves to displayed product
    Then   user click more link
    When   user enters quantity of <quantity>
    And    user selects size <size> of product
    And    user selects color <color> of product
    Then   user adds product to cart
    When   user proceeds to checkout
    And    user goes to payment conditions
    Then   user selects payment method
    And    user confirms the order
    Then   user sees following successful message Your order on My Store is complete.

    Examples:
      | email             | password | product  | quantity | size | color |
      | indiana@jones.com | jones    | T-shirts | 2        | L    | Blue  |


Scenario Outline: Verifies, if user changes quantity on 'Shopping Cart Summary' Page
the total price is displayed correctly

  Given  user goes to web page
  When   user goes to login page
  And    user logs in to app with following email <email> and password <password>
  Then   user moves over womens link
  When   user chooses <product> product
  And    user moves to displayed product
  Then   user click more link
  When   user enters quantity of <quantity>
  And    user selects size <size> of product
  And    user selects color <color> of product
  Then   user adds product to cart
  When   user proceeds to checkout
  And    user changes the quantity to <modifiedQty>
  Then   user verifies if total price is changing and reflecting correct price

  Examples:
    | email             | password | product  | quantity | size | color | modifiedQty |
    | indiana@jones.com | jones    | T-shirts | 2        | L    | Blue  |   8        |


  Scenario: Verifies, if 'Add to Wishlist' only works for log in user
    Given user goes to web page
    When  user moves over women's link
    And   user click on T-shirts link
    And   user moves to displayed product
    And   user adds product to wishlist
    Then  user sees error message You must be logged in to manage your wishlist.

