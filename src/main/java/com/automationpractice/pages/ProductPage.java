package com.automationpractice.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ProductPage {

    private WebDriver driver;

    @FindBy(xpath = "//*[@id='center_column']//h5")
    List<WebElement> productsList;

    @FindBy(id = "search_query_top")
    WebElement searchBox;

    @FindBy(name = "submit_search")
    WebElement searchButton;

    @FindBy(xpath = "//img[@title='Faded Short Sleeve T-shirts']")
    WebElement shortSleeve;

    @FindBy(xpath = "//a[normalize-space()='Add to Wishlist']")
    WebElement wishListBtn;

    @FindBy(xpath = "//p[@class = 'fancybox-error']")
    WebElement errorMessage;

    @FindBy(xpath = "//span[text()='More']")
    WebElement moreLink;


    public ProductPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    public String getNameFromFirstProductDisplayedInProductPage() {
        String firstNameFromProductPage = productsList.get(0).getText();

        return firstNameFromProductPage;
    }

    public void userEntersProductInSearchBar() {
        searchBox.sendKeys(getNameFromFirstProductDisplayedInProductPage());

    }

    public void userClicksSearchButton() {
        searchButton.click();

    }

    public void userMovesToDisplayedProduct() {
        Actions action = new Actions(driver);
        action.moveToElement(shortSleeve).build().perform();
    }

    public void userClicksAddToWishlist() {

        wishListBtn.click();
    }


    public void userClicksMoreBtn() {
        moreLink.click();
    }


    public String getErrorMessage() {

        return errorMessage.getText();
    }


}


