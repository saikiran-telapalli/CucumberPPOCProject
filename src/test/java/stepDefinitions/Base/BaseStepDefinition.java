package stepDefinitions.Base;

import cucumber.api.java.en.Given;

public class BaseStepDefinition {

    BaseSteps baseSteps = new BaseSteps();

    //@Given("^open browser$")
    public void open_browser() throws Throwable {
        baseSteps.initilize();
    }

}
