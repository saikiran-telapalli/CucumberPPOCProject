package stepDefinitions.Login;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginPage {


    @FindBy(how = How.ID, using = "user_email")
    protected WebElement emailId;

    @FindBy(how = How.ID, using = "user_password")
    protected WebElement password;

    @FindBy(how = How.NAME, using = "commit")
    protected WebElement signIn;

}
