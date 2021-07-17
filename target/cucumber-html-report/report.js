$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("features/test.feature");
formatter.feature({
  "line": 2,
  "name": "testing",
  "description": "",
  "id": "testing",
  "keyword": "Feature",
  "tags": [
    {
      "line": 1,
      "name": "@test1"
    }
  ]
});
formatter.before({
  "duration": 2936211253,
  "status": "passed"
});
formatter.scenario({
  "line": 3,
  "name": "Testing scenario",
  "description": "",
  "id": "testing;testing-scenario",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 4,
  "name": "navigate to url \"Sereapp1\"",
  "keyword": "Given "
});
formatter.step({
  "line": 5,
  "name": "Login to app",
  "keyword": "When "
});
formatter.step({
  "line": 6,
  "name": "verify title",
  "keyword": "Then "
});
formatter.match({
  "arguments": [
    {
      "val": "Sereapp1",
      "offset": 17
    }
  ],
  "location": "LoginStepDefinition.navigate_to_url(String)"
});
formatter.result({
  "duration": 2114754792,
  "status": "passed"
});
formatter.match({
  "location": "LoginStepDefinition.open_browser()"
});
formatter.result({
  "duration": 14142962658,
  "error_message": "org.openqa.selenium.NoSuchElementException: Cannot locate an element using id\u003duser_email\nFor documentation on this error, please visit: https://www.seleniumhq.org/exceptions/no_such_element.html\nBuild info: version: \u00273.141.59\u0027, revision: \u0027e82be7d358\u0027, time: \u00272018-11-14T08:17:03\u0027\nSystem info: host: \u0027rs-MAC15.local\u0027, ip: \u00272406:b400:d4:9cf2:3d4a:2e1e:deb3:1dda%en0\u0027, os.name: \u0027Mac OS X\u0027, os.arch: \u0027x86_64\u0027, os.version: \u002710.13.6\u0027, java.version: \u002710.0.2\u0027\nDriver info: driver.version: RemoteWebDriver\n\tat org.openqa.selenium.remote.RemoteWebDriver.findElement(RemoteWebDriver.java:327)\n\tat org.openqa.selenium.remote.RemoteWebDriver.findElementById(RemoteWebDriver.java:372)\n\tat org.openqa.selenium.By$ById.findElement(By.java:188)\n\tat org.openqa.selenium.remote.RemoteWebDriver.findElement(RemoteWebDriver.java:315)\n\tat org.openqa.selenium.support.pagefactory.DefaultElementLocator.findElement(DefaultElementLocator.java:69)\n\tat org.openqa.selenium.support.pagefactory.internal.LocatingElementHandler.invoke(LocatingElementHandler.java:38)\n\tat com.sun.proxy.$Proxy20.sendKeys(Unknown Source)\n\tat stepDefinitions.Login.LoginSteps.logIn(LoginSteps.java:34)\n\tat stepDefinitions.Login.LoginStepDefinition.open_browser(LoginStepDefinition.java:17)\n\tat ✽.When Login to app(features/test.feature:5)\n",
  "status": "failed"
});
formatter.match({
  "location": "LoginStepDefinition.verify_title()"
});
formatter.result({
  "status": "skipped"
});
formatter.after({
  "duration": 113748264,
  "status": "passed"
});
});