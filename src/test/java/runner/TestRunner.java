package runner;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"classpath:features"},
        plugin = {"pretty", "html:target/cucumber-html-report", "json:target/cucumber-report/cucumber.json"},
        tags = {"@test1"},
        glue={"classpath:stepDefinitions"},
        monochrome = true
)
public class TestRunner {

}
