package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UserAccountPage {

    @FindBy(xpath = "*//div[@class='header_user_info']/a/span")
    WebElement userId;

    private static WebDriver driver;

    public UserAccountPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getUserId() {
        String userName = userId.getText();
        return userName;
    }

}
