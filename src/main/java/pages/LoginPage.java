package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    private WebDriver driver;

    @FindBy(id = "email_create")
    WebElement emailAddressInput;
    @FindBy(id = "SubmitCreate")
    WebElement createAccountBtn;
    @FindBy(id = "email")
    WebElement emailInput;
    @FindBy(id = "passwd")
    WebElement passwordInput;
    @FindBy(id = "SubmitLogin")
    WebElement signInButton;


    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void userEntersEmailAddress(String emailAddress) {
        emailAddressInput.sendKeys(System.currentTimeMillis() + emailAddress);
    }

    public void userSubmitsEmailAddress() {
        createAccountBtn.click();

    }

    public void userEntersLoginCredentials(String email, String passwd) {
        emailInput.sendKeys(email);
        passwordInput.sendKeys(passwd);
    }

    public void userSignsIn() {
        signInButton.click();
    }


}
