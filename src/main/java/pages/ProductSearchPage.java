package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ProductSearchPage {

    private WebDriver driver;

    @FindBy(xpath = "//*[@id='center_column']//h5")
    List<WebElement> searchedProductsList;


    public ProductSearchPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getNameFromFirstProductDisplayedInSearchPage() {

        String firstNameFromSearchPage = searchedProductsList.get(0).getText();

        return firstNameFromSearchPage;
    }


}
