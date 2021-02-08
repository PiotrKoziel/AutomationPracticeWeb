$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("userRegistration.feature");
formatter.feature({
  "line": 1,
  "name": "Register new user. Validation of personal information fields.",
  "description": "",
  "id": "register-new-user.-validation-of-personal-information-fields.",
  "keyword": "Feature"
});
formatter.before({
  "duration": 3185636575,
  "status": "passed"
});
formatter.background({
  "line": 3,
  "name": "",
  "description": "",
  "type": "background",
  "keyword": "Background"
});
formatter.step({
  "line": 4,
  "name": "user navigates to web page",
  "keyword": "Given "
});
formatter.step({
  "line": 5,
  "name": "user clicks on sign in link",
  "keyword": "When "
});
formatter.match({
  "location": "UserRegistrationSteps.userNavigateToUrl()"
});
formatter.result({
  "duration": 6378817864,
  "status": "passed"
});
formatter.match({
  "location": "UserRegistrationSteps.userClicksOnSignInLink()"
});
formatter.result({
  "duration": 1574074644,
  "status": "passed"
});
formatter.scenario({
  "line": 69,
  "name": "Verify invalid email address error.",
  "description": "",
  "id": "register-new-user.-validation-of-personal-information-fields.;verify-invalid-email-address-error.",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 68,
      "name": "@Inv"
    }
  ]
});
formatter.step({
  "line": 70,
  "name": "user enters invalid invalid email address",
  "keyword": "When "
});
formatter.step({
  "line": 71,
  "name": "user clicks enter",
  "keyword": "And "
});
formatter.step({
  "line": 72,
  "name": "user sees the following message Invalid email address.",
  "keyword": "Then "
});
formatter.match({
  "arguments": [
    {
      "val": "invalid",
      "offset": 20
    }
  ],
  "location": "UserRegistrationSteps.userEntersInvalidEmailAddress(String)"
});
formatter.result({
  "duration": 746548693,
  "status": "passed"
});
formatter.match({
  "location": "UserRegistrationSteps.userClicksEnter()"
});
formatter.result({
  "duration": 66312998,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Invalid email address.",
      "offset": 32
    }
  ],
  "location": "UserRegistrationSteps.userSeesUnsuccessfulMessage(String)"
});
formatter.result({
  "duration": 1209652667,
  "status": "passed"
});
formatter.after({
  "duration": 57901,
  "status": "passed"
});
});