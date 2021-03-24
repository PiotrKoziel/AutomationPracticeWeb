$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("searchProduct.feature");
formatter.feature({
  "line": 1,
  "name": "test performs validation of product name displayed on product page and product name displayed on search page",
  "description": "",
  "id": "test-performs-validation-of-product-name-displayed-on-product-page-and-product-name-displayed-on-search-page",
  "keyword": "Feature"
});
formatter.before({
  "duration": 1824497394,
  "status": "passed"
});
formatter.scenario({
  "line": 4,
  "name": "verifies,if user sees same product name on product page as on the search page",
  "description": "",
  "id": "test-performs-validation-of-product-name-displayed-on-product-page-and-product-name-displayed-on-search-page;verifies,if-user-sees-same-product-name-on-product-page-as-on-the-search-page",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 5,
  "name": "user goes to web page",
  "keyword": "Given "
});
formatter.step({
  "line": 6,
  "name": "user moves over womens link",
  "keyword": "When "
});
formatter.step({
  "line": 7,
  "name": "user click on T-shirts link",
  "keyword": "And "
});
formatter.step({
  "line": 8,
  "name": "user enters first product name in search bar",
  "keyword": "And "
});
formatter.step({
  "line": 9,
  "name": "user clicks search",
  "keyword": "And "
});
formatter.step({
  "line": 10,
  "name": "user validates product name displayed on product page and search page",
  "keyword": "Then "
});
formatter.match({
  "location": "SearchProductSteps.userNavigatePage()"
});
formatter.result({
  "duration": 4685515188,
  "status": "passed"
});
formatter.match({
  "location": "SearchProductSteps.userMovesToWowensLink()"
});
formatter.result({
  "duration": 238159968,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "T-shirts",
      "offset": 14
    }
  ],
  "location": "SearchProductSteps.userClicksProductLink(String)"
});
formatter.result({
  "duration": 1828832517,
  "status": "passed"
});
formatter.match({
  "location": "SearchProductSteps.userEntersFirstProductNameInSearchBar()"
});
formatter.result({
  "duration": 179164863,
  "status": "passed"
});
formatter.match({
  "location": "SearchProductSteps.userClicksSearch()"
});
formatter.result({
  "duration": 2266215077,
  "status": "passed"
});
formatter.match({
  "location": "SearchProductSteps.userValidatesProductNameDisplayedOnProductPageAndSearchPage()"
});
formatter.result({
  "duration": 63617238,
  "status": "passed"
});
formatter.after({
  "duration": 76228908,
  "status": "passed"
});
});