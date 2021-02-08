Feature: Register new user. Validation of personal information fields.

  Background:
    Given   user navigates to web page
    When    user clicks on sign in link

@Positive
  Scenario Outline: create new user account
    And     user enters email address <emailAddress> in 'Create and account' section
    Then    user clicks on Create an Account button
    When    user selects the title <title>
    And     user enters personal information

      | firstName | <firstName> |
      | lastName  | <lastName>  |
      | password  | <password>  |
      | address   | <address>   |
      | city      | <city>      |
      | zipcode   | <zipCode>   |
      | phone     | <phone>     |
      | state     | <state>     |
      | country   | <country>   |


    And     user clicks on register button
    Then    user successfully sings in

      | lastName | <lastName> |

    Examples:
      | emailAddress | title | firstName | lastName | password | address   | city      | zipCode | phone       | state  | country       |
      | @gmail.com   | Mr.   | Indiana   | Jones    | jones    | Reckon 13 | Fairbanks | 12345   | 44556677888 | Alaska | United States |

# below scenario still in progress
  Scenario Outline: Verify error messages for entering incorrect values in fields.

    And    user enters email address <emailAddress> in 'Create and account' section
    Then   user clicks on Create an Account button
    And    user enters incorrect values in personal information fields
      | firstName | <firstName> |
      | lastName  | <lastName>  |
      | password  | <password>  |
      | address   | <address>   |
      | city      | <city>      |
      | zipcode   | <zipCode>   |
      | phone     | <phone>     |
      | state     | <state>     |
      | country   | <country>   |


    And    user clicks on register button
    Then   user sees error messages displayed for respective fields


    Examples:
      | emailAddress | firstName | lastName | password | address | city | zipCode | phone | state | country |
      | @com.eu      | 23@?.!^&s | As@(*hb  |          | 3ed asd | 3456 | dfgh    | deded | 3dc   |         |


@Err
  Scenario: Verify error messages for mandatory fields.
    And    user enters email address <emailAddress> in 'Create and account' section
    Then   user clicks on Create an Account button
    And    user leaves mandatory fields empty
    And    user clicks on register button
    Then   user sees displayed error for the mandatory fields

@Inv
  Scenario: Verify invalid email address error.
    When  user enters invalid invalid email address
    And   user clicks enter
    Then  user sees the following message Invalid email address.






