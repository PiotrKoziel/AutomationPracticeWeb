package com.automationpractice.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class DetailedProductPage {

    private WebDriver driver;

    @FindBy(id = "quantity_wanted")
    WebElement qtyInput;
    @FindBy(id = "group_1")
    WebElement sizeOpt;
    @FindBy(xpath = "//*[@id='color_to_pick_list']/li/a")
    List<WebElement> colorList;
    @FindBy(name = "Submit")
    WebElement addToCartButton;
    @FindBy(xpath = "//*[@title = 'Proceed to checkout']")
    WebElement proceedToCheckoutButton;



    public DetailedProductPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void userEntersNumberOfProducts(String quantity) {
        qtyInput.clear();
        qtyInput.sendKeys(quantity);

    }

    public void userSelectsSize(String size) {
        Select select = new Select(sizeOpt);
        select.selectByVisibleText(size);
    }

    public void userSelectsColor(String col) {
        for (WebElement color : colorList) {
            if (color.getAttribute("title").equals(col)) {
                color.click();
            }

        }
    }

    public void userClicksAddToCart() {
        addToCartButton.click();
    }

    public void userClicksProceedToCheckout() {

        proceedToCheckoutButton.click();
    }




}