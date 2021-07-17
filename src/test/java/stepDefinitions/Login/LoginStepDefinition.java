package stepDefinitions.Login;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LoginStepDefinition {
    LoginSteps loginSteps = new LoginSteps();

    @When("^navigate to url \"([^\"]*)\"$")
    public void navigate_to_url(String url) throws Throwable {
        loginSteps.navigate(url);
    }

    @Given("^Login to app$")
    public void open_browser() throws Throwable {
        loginSteps.logIn();
    }

    @Then("^verify title$")
    public void verify_title() throws Throwable {
        loginSteps.getTitle();
    }
}
