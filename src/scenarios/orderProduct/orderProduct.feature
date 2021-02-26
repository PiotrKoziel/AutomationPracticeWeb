Feature:

  Scenario Outline:
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
    Then   user verifies total price
    When   user goes to payment conditions
    And    user selects payment method
    And    user confirms the order
    Then   user sees following successful message Your order on My Store is complete.


    Examples:
      | email             | password | product  | quantity | size | color | modifiedQty |
      | indiana@jones.com | jones    | T-shirts | 2        | L    | Blue  | 8           |
