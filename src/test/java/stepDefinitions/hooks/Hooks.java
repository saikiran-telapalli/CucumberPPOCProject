package stepDefinitions.hooks;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.chrome.ChromeDriver;
import stepDefinitions.Base.BaseSteps;

import java.util.concurrent.TimeUnit;

public class Hooks extends BaseSteps {
    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/Drivers/chromedriver");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5000, TimeUnit.SECONDS);
        driver.manage().window().fullscreen();
    }
    @After
    public void tearDown(){
        driver.quit();
    }
}
