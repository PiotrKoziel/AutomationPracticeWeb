Feature: Tests performs validation of new user registration process. User enters correct values in order register. User
  leaves the fields blank and enters incorrect values.

  Background:
    Given   user navigates to web page
    When    user clicks on sign in link


  @Pos
  Scenario Outline: Verifies, if user enters correct values in personal information fields successful registration
  message is displayed

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


    And     user register in application
    Then    user successfully sings in

      | lastName | <lastName> |

    Examples:
      | emailAddress | title | firstName | lastName | password | address   | city      | zipCode | phone       | state  | country       |
      | @gmail.com   | Mr.   | Indiana   | Jones    | jones    | Reckon 13 | Fairbanks | 12345   | 44556677888 | Alaska | United States |


  @Neg
  Scenario Outline: Verifies, if user enters incorrect values in personal information fields error messages are
  displayed

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


    And    user register in application
    Then   user sees error messages displayed for respective fields


    Examples:
      | emailAddress | firstName | lastName | password | address | city   | zipCode | phone | state | country |
      | @com.eu      | $%T      | $%TTT6    | qwe     |  @3ed4! | $%^TYH  | q@dfg  | erty   | dfgh  |- |


  @Err
  Scenario: Verifies, if user leaves mandatory fields empty/blank error messages are displayed
    And    user enters email address @com.rw in 'Create and account' section
    Then   user clicks on Create an Account button
    And    user leaves mandatory fields empty
    And    user register in application
    Then   user sees displayed error for the mandatory fields


  @Inv
  Scenario: Verifies, if user enters invalid email address error is displayed
    When  user enters invalid invalid email address
    And   user clicks enter
    Then  user sees the following message Invalid email address.






