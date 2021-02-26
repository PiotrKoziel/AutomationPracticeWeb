package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateNewAccountPage {


    @FindBy()
    WebElement titleBox;
    @FindBy(id = "customer_firstname")
    WebElement firstNameInput;
    @FindBy(id = "customer_lastname")
    WebElement lastNameInput;
    @FindBy(id = "passwd")
    WebElement passInput;
    @FindBy(name = "address1")
    WebElement addressInput;
    @FindBy(name = "city")
    WebElement cityInput;
    @FindBy(id = "postcode")
    WebElement postCodeInput;
    @FindBy(id = "phone_mobile")
    WebElement phoneInput;

    private static WebDriver driver;


    public CreateNewAccountPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


}


