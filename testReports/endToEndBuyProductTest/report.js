$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("endToEndBuyProduct.feature");
formatter.feature({
  "line": 1,
  "name": "tests perform end to end buy order functionality,",
  "description": "and adding product to wishlist as a not logged in user",
  "id": "tests-perform-end-to-end-buy-order-functionality,",
  "keyword": "Feature"
});
formatter.scenarioOutline({
  "line": 28,
  "name": "Verifies, if user changes quantity on \u0027Shopping Cart Summary\u0027 Page",
  "description": "the total price is displayed correctly",
  "id": "tests-perform-end-to-end-buy-order-functionality,;verifies,-if-user-changes-quantity-on-\u0027shopping-cart-summary\u0027-page",
  "type": "scenario_outline",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 27,
      "name": "@top"
    }
  ]
});
formatter.step({
  "line": 31,
  "name": "user goes to web page",
  "keyword": "Given "
});
formatter.step({
  "line": 32,
  "name": "user goes to login page",
  "keyword": "When "
});
formatter.step({
  "line": 33,
  "name": "user logs in to app with following email \u003cemail\u003e and password \u003cpassword\u003e",
  "keyword": "And "
});
formatter.step({
  "line": 34,
  "name": "user moves over womens link",
  "keyword": "Then "
});
formatter.step({
  "line": 35,
  "name": "user chooses \u003cproduct\u003e product",
  "keyword": "When "
});
formatter.step({
  "line": 36,
  "name": "user moves to displayed product",
  "keyword": "And "
});
formatter.step({
  "line": 37,
  "name": "user click more link",
  "keyword": "Then "
});
formatter.step({
  "line": 38,
  "name": "user enters quantity of \u003cquantity\u003e",
  "keyword": "When "
});
formatter.step({
  "line": 39,
  "name": "user selects size \u003csize\u003e of product",
  "keyword": "And "
});
formatter.step({
  "line": 40,
  "name": "user selects color \u003ccolor\u003e of product",
  "keyword": "And "
});
formatter.step({
  "line": 41,
  "name": "user adds product to cart",
  "keyword": "Then "
});
formatter.step({
  "line": 42,
  "name": "user proceeds to checkout",
  "keyword": "When "
});
formatter.step({
  "line": 43,
  "name": "user changes the quantity to \u003cmodifiedQty\u003e",
  "keyword": "And "
});
formatter.step({
  "line": 44,
  "name": "user verifies if total price is changing and reflecting correct price",
  "keyword": "Then "
});
formatter.examples({
  "line": 46,
  "name": "",
  "description": "",
  "id": "tests-perform-end-to-end-buy-order-functionality,;verifies,-if-user-changes-quantity-on-\u0027shopping-cart-summary\u0027-page;",
  "rows": [
    {
      "cells": [
        "email",
        "password",
        "product",
        "quantity",
        "size",
        "color",
        "modifiedQty"
      ],
      "line": 47,
      "id": "tests-perform-end-to-end-buy-order-functionality,;verifies,-if-user-changes-quantity-on-\u0027shopping-cart-summary\u0027-page;;1"
    },
    {
      "cells": [
        "indiana@jones.com",
        "jones",
        "T-shirts",
        "2",
        "L",
        "Blue",
        "8"
      ],
      "line": 48,
      "id": "tests-perform-end-to-end-buy-order-functionality,;verifies,-if-user-changes-quantity-on-\u0027shopping-cart-summary\u0027-page;;2"
    }
  ],
  "keyword": "Examples"
});
formatter.before({
  "duration": 1831669019,
  "status": "passed"
});
formatter.scenario({
  "line": 48,
  "name": "Verifies, if user changes quantity on \u0027Shopping Cart Summary\u0027 Page",
  "description": "the total price is displayed correctly",
  "id": "tests-perform-end-to-end-buy-order-functionality,;verifies,-if-user-changes-quantity-on-\u0027shopping-cart-summary\u0027-page;;2",
  "type": "scenario",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 27,
      "name": "@top"
    }
  ]
});
formatter.step({
  "line": 31,
  "name": "user goes to web page",
  "keyword": "Given "
});
formatter.step({
  "line": 32,
  "name": "user goes to login page",
  "keyword": "When "
});
formatter.step({
  "line": 33,
  "name": "user logs in to app with following email indiana@jones.com and password jones",
  "matchedColumns": [
    0,
    1
  ],
  "keyword": "And "
});
formatter.step({
  "line": 34,
  "name": "user moves over womens link",
  "keyword": "Then "
});
formatter.step({
  "line": 35,
  "name": "user chooses T-shirts product",
  "matchedColumns": [
    2
  ],
  "keyword": "When "
});
formatter.step({
  "line": 36,
  "name": "user moves to displayed product",
  "keyword": "And "
});
formatter.step({
  "line": 37,
  "name": "user click more link",
  "keyword": "Then "
});
formatter.step({
  "line": 38,
  "name": "user enters quantity of 2",
  "matchedColumns": [
    3
  ],
  "keyword": "When "
});
formatter.step({
  "line": 39,
  "name": "user selects size L of product",
  "matchedColumns": [
    4
  ],
  "keyword": "And "
});
formatter.step({
  "line": 40,
  "name": "user selects color Blue of product",
  "matchedColumns": [
    5
  ],
  "keyword": "And "
});
formatter.step({
  "line": 41,
  "name": "user adds product to cart",
  "keyword": "Then "
});
formatter.step({
  "line": 42,
  "name": "user proceeds to checkout",
  "keyword": "When "
});
formatter.step({
  "line": 43,
  "name": "user changes the quantity to 8",
  "matchedColumns": [
    6
  ],
  "keyword": "And "
});
formatter.step({
  "line": 44,
  "name": "user verifies if total price is changing and reflecting correct price",
  "keyword": "Then "
});
formatter.match({
  "location": "EndToEndBuyProductSteps.userNavigatePage()"
});
formatter.result({
  "duration": 5286591295,
  "status": "passed"
});
formatter.match({
  "location": "EndToEndBuyProductSteps.userGoesToLoginPage()"
});
formatter.result({
  "duration": 1731560052,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "indiana@jones.com",
      "offset": 41
    },
    {
      "val": "jones",
      "offset": 72
    }
  ],
  "location": "EndToEndBuyProductSteps.userLogsInToAppUsingValidCredentials(String,String)"
});
formatter.result({
  "duration": 2837859372,
  "status": "passed"
});
formatter.match({
  "location": "EndToEndBuyProductSteps.userMovesToWomensLink()"
});
formatter.result({
  "duration": 192534207,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "T-shirts",
      "offset": 13
    }
  ],
  "location": "EndToEndBuyProductSteps.userChoosesProduct(String)"
});
formatter.result({
  "duration": 2490122429,
  "status": "passed"
});
formatter.match({
  "location": "EndToEndBuyProductSteps.userMovesToDisplayedProduct()"
});
formatter.result({
  "duration": 160734516,
  "status": "passed"
});
formatter.match({
  "location": "EndToEndBuyProductSteps.userClicksMoreLink()"
});
formatter.result({
  "duration": 3110338234,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "2",
      "offset": 24
    }
  ],
  "location": "EndToEndBuyProductSteps.userEntersQuantity(String)"
});
formatter.result({
  "duration": 135508535,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "L",
      "offset": 18
    }
  ],
  "location": "EndToEndBuyProductSteps.userSelectsSizeOfProduct(String)"
});
formatter.result({
  "duration": 163659667,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Blue",
      "offset": 19
    }
  ],
  "location": "EndToEndBuyProductSteps.userSelectsColorOfProduct(String)"
});
formatter.result({
  "duration": 119172940,
  "status": "passed"
});
formatter.match({
  "location": "EndToEndBuyProductSteps.userAddsProductToCart()"
});
formatter.result({
  "duration": 97413666,
  "status": "passed"
});
formatter.match({
  "location": "EndToEndBuyProductSteps.userProceedsToCheckout()"
});
formatter.result({
  "duration": 2538505316,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "8",
      "offset": 29
    }
  ],
  "location": "EndToEndBuyProductSteps.userChangesQuantity(String)"
});
formatter.result({
  "duration": 1753343611,
  "status": "passed"
});
formatter.match({
  "location": "EndToEndBuyProductSteps.userVerifiesTotalPrice()"
});
formatter.result({
  "duration": 84337860,
  "status": "passed"
});
formatter.after({
  "duration": 53377,
  "status": "passed"
});
});