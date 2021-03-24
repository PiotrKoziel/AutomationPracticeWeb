$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("userRegistration.feature");
formatter.feature({
  "line": 1,
  "name": "Tests performs validation of new user registration process. User enters correct values in order register. User",
  "description": "leaves the fields blank and enters incorrect values.",
  "id": "tests-performs-validation-of-new-user-registration-process.-user-enters-correct-values-in-order-register.-user",
  "keyword": "Feature"
});
formatter.scenarioOutline({
  "line": 40,
  "name": "Verifies, if user enters incorrect values in personal information fields error messages are",
  "description": "displayed",
  "id": "tests-performs-validation-of-new-user-registration-process.-user-enters-correct-values-in-order-register.-user;verifies,-if-user-enters-incorrect-values-in-personal-information-fields-error-messages-are",
  "type": "scenario_outline",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 39,
      "name": "@Neg"
    }
  ]
});
formatter.step({
  "line": 43,
  "name": "user enters email address \u003cemailAddress\u003e in \u0027Create and account\u0027 section",
  "keyword": "And "
});
formatter.step({
  "line": 44,
  "name": "user clicks on Create an Account button",
  "keyword": "Then "
});
formatter.step({
  "line": 45,
  "name": "user enters incorrect values in personal information fields",
  "rows": [
    {
      "cells": [
        "firstName",
        "\u003cfirstName\u003e"
      ],
      "line": 46
    },
    {
      "cells": [
        "lastName",
        "\u003clastName\u003e"
      ],
      "line": 47
    },
    {
      "cells": [
        "password",
        "\u003cpassword\u003e"
      ],
      "line": 48
    },
    {
      "cells": [
        "address",
        "\u003caddress\u003e"
      ],
      "line": 49
    },
    {
      "cells": [
        "city",
        "\u003ccity\u003e"
      ],
      "line": 50
    },
    {
      "cells": [
        "zipcode",
        "\u003czipCode\u003e"
      ],
      "line": 51
    },
    {
      "cells": [
        "phone",
        "\u003cphone\u003e"
      ],
      "line": 52
    },
    {
      "cells": [
        "state",
        "\u003cstate\u003e"
      ],
      "line": 53
    },
    {
      "cells": [
        "country",
        "\u003ccountry\u003e"
      ],
      "line": 54
    }
  ],
  "keyword": "And "
});
formatter.step({
  "line": 57,
  "name": "user register in application",
  "keyword": "And "
});
formatter.step({
  "line": 58,
  "name": "user sees error messages displayed for respective fields",
  "keyword": "Then "
});
formatter.examples({
  "line": 61,
  "name": "",
  "description": "",
  "id": "tests-performs-validation-of-new-user-registration-process.-user-enters-correct-values-in-order-register.-user;verifies,-if-user-enters-incorrect-values-in-personal-information-fields-error-messages-are;",
  "rows": [
    {
      "cells": [
        "emailAddress",
        "firstName",
        "lastName",
        "password",
        "address",
        "city",
        "zipCode",
        "phone",
        "state",
        "country"
      ],
      "line": 62,
      "id": "tests-performs-validation-of-new-user-registration-process.-user-enters-correct-values-in-order-register.-user;verifies,-if-user-enters-incorrect-values-in-personal-information-fields-error-messages-are;;1"
    },
    {
      "cells": [
        "@com.eu",
        "$%T",
        "$%TTT6",
        "qwe",
        "@3ed4!",
        "$%^TYH",
        "q@dfg",
        "erty",
        "dfgh",
        "-"
      ],
      "line": 63,
      "id": "tests-performs-validation-of-new-user-registration-process.-user-enters-correct-values-in-order-register.-user;verifies,-if-user-enters-incorrect-values-in-personal-information-fields-error-messages-are;;2"
    }
  ],
  "keyword": "Examples"
});
formatter.before({
  "duration": 1804847534,
  "status": "passed"
});
formatter.background({
  "line": 4,
  "name": "",
  "description": "",
  "type": "background",
  "keyword": "Background"
});
formatter.step({
  "line": 5,
  "name": "user navigates to web page",
  "keyword": "Given "
});
formatter.step({
  "line": 6,
  "name": "user clicks on sign in link",
  "keyword": "When "
});
formatter.match({
  "location": "UserRegistrationSteps.userNavigateToUrl()"
});
formatter.result({
  "duration": 4053945807,
  "status": "passed"
});
formatter.match({
  "location": "UserRegistrationSteps.userClicksOnSignInLink()"
});
formatter.result({
  "duration": 1387625809,
  "status": "passed"
});
formatter.scenario({
  "line": 63,
  "name": "Verifies, if user enters incorrect values in personal information fields error messages are",
  "description": "displayed",
  "id": "tests-performs-validation-of-new-user-registration-process.-user-enters-correct-values-in-order-register.-user;verifies,-if-user-enters-incorrect-values-in-personal-information-fields-error-messages-are;;2",
  "type": "scenario",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 39,
      "name": "@Neg"
    }
  ]
});
formatter.step({
  "line": 43,
  "name": "user enters email address @com.eu in \u0027Create and account\u0027 section",
  "matchedColumns": [
    0
  ],
  "keyword": "And "
});
formatter.step({
  "line": 44,
  "name": "user clicks on Create an Account button",
  "keyword": "Then "
});
formatter.step({
  "line": 45,
  "name": "user enters incorrect values in personal information fields",
  "matchedColumns": [
    1,
    2,
    3,
    4,
    5,
    6,
    7,
    8,
    9
  ],
  "rows": [
    {
      "cells": [
        "firstName",
        "$%T"
      ],
      "line": 46
    },
    {
      "cells": [
        "lastName",
        "$%TTT6"
      ],
      "line": 47
    },
    {
      "cells": [
        "password",
        "qwe"
      ],
      "line": 48
    },
    {
      "cells": [
        "address",
        "@3ed4!"
      ],
      "line": 49
    },
    {
      "cells": [
        "city",
        "$%^TYH"
      ],
      "line": 50
    },
    {
      "cells": [
        "zipcode",
        "q@dfg"
      ],
      "line": 51
    },
    {
      "cells": [
        "phone",
        "erty"
      ],
      "line": 52
    },
    {
      "cells": [
        "state",
        "dfgh"
      ],
      "line": 53
    },
    {
      "cells": [
        "country",
        "-"
      ],
      "line": 54
    }
  ],
  "keyword": "And "
});
formatter.step({
  "line": 57,
  "name": "user register in application",
  "keyword": "And "
});
formatter.step({
  "line": 58,
  "name": "user sees error messages displayed for respective fields",
  "keyword": "Then "
});
formatter.match({
  "arguments": [
    {
      "val": "@com.eu",
      "offset": 26
    }
  ],
  "location": "UserRegistrationSteps.userEntersEmail(String)"
});
formatter.result({
  "duration": 780689363,
  "status": "passed"
});
formatter.match({
  "location": "UserRegistrationSteps.userClicksCreateAnAccountButton()"
});
formatter.result({
  "duration": 91906609,
  "status": "passed"
});
formatter.match({
  "location": "UserRegistrationSteps.userEntersIncorrectValues(DataTable)"
});
formatter.result({
  "duration": 10265907144,
  "status": "passed"
});
formatter.match({
  "location": "UserRegistrationSteps.userRegistersInApplication()"
});
formatter.result({
  "duration": 1885078747,
  "status": "passed"
});
formatter.match({
  "location": "UserRegistrationSteps.userSeesErrorMessagesDisplayedForRespectiveFields()"
});
formatter.result({
  "duration": 407436029,
  "status": "passed"
});
formatter.after({
  "duration": 48193,
  "status": "passed"
});
});