package stepDefinitions.Login;

import org.openqa.selenium.support.PageFactory;
import stepDefinitions.Base.BaseSteps;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class LoginSteps extends BaseSteps {

    LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);

    public void navigate(String url) throws IOException {
        FileReader reader=new FileReader(System.getProperty("user.dir")+"/src/test/resources/TestData/UrlData.properties");
        Properties p=new Properties();
        p.load(reader);

        System.out.println(p.getProperty("appUrl"));
        if(url.equals("Sereapp")){
            driver.get(p.getProperty("appUrl"));
        }
        else{
            driver.get(p.getProperty("otherUrl"));
        }
    }

    public void getTitle() {
        System.out.println(driver.getTitle());
    }

    public void logIn() throws InterruptedException {
        loginPage.emailId.sendKeys("gurdeep.singh@cerebrahealth.com");
        loginPage.password.sendKeys("testsleep1");
        loginPage.signIn.click();
        Thread.sleep(3000);
    }
}
