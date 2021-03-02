package pages;

import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class UserPage {

    private WebDriver driver;

    @FindBy(xpath = "//a[@title='Women']")
    WebElement wowensLink;
    @FindBy(xpath = "//*[@id='block_top_menu']/ul/li[1]/ul/li[1]/ul//a")
    List<WebElement> productLinks;


    public UserPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void userMovesOverLink() {
        Actions actions = new Actions(driver);
        actions.moveToElement(wowensLink).build().perform();
    }


    public void userClickOnProductLink(String prod) {
        try {
            for (WebElement product : productLinks) {
                if (product.getText().equals(prod)) {
                    product.click();
                }
            }
        } catch (StaleElementReferenceException ex) {
            for (WebElement product : productLinks) {
                if (product.getText().equals(prod)) {
                    product.click();

                }
            }


        }

    }


}
