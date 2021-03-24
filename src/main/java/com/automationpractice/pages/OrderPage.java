package com.automationpractice.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OrderPage {

    private WebDriver driver;

    @FindBy(name = "quantity_1_6_0_443127")
    WebElement qtyInput;
    @FindBy(name = "quantity_1_6_0_443127_hidden")
    WebElement modifiedQuantity;
    @FindBy(id = "product_price_1_6_443127")
    WebElement pricePerUnit;
    @FindBy(id = "total_product_price_1_6_443127")
    WebElement totalPriceToCompare;
    @FindBy(xpath = "//*[@id='center_column']/p[2]/a[1]")
    WebElement proceedToCheckoutSummary;
    @FindBy(name = "processAddress")
    WebElement proceedToCheckoutAddress;
    @FindBy(id = "cgv")
    WebElement termsOfServiceCheckbox;
    @FindBy(name = "processCarrier")
    WebElement proceedToCheckoutShipping;
    @FindBy(xpath = "//*[contains(text(), 'Pay by check')]")
    WebElement payByCheckMethod;
    @FindBy(xpath = "//*[@id='cart_navigation']/button")
    WebElement confirmButton;
    @FindBy(xpath = "//*[@id='center_column']/p[1]")
    WebElement successMessage;


    public OrderPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    public void userChangesQuantity(String quantity2) {
        qtyInput.clear();
        qtyInput.sendKeys(quantity2);

        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.attributeToBe(modifiedQuantity, "value", quantity2));
    }

    public String getUnitPriceOff() {
        String pricePerUnitOff = pricePerUnit.getText().trim().substring(1);
        return pricePerUnitOff;
    }

    public String getTotalPriceToCompareOff() {
        String totalPriceToCompareOff = totalPriceToCompare.getText().trim().substring(1);
        return totalPriceToCompareOff;
    }


    public void userClicksProceedToCheckoutAtSummary() {
        proceedToCheckoutSummary.click();
    }

    public void userClicksProceedToCheckoutAtAddress() {
        proceedToCheckoutAddress.click();

    }

    public Boolean termsOfService() {
        return termsOfServiceCheckbox.isSelected();
    }

    public void userClicksTermsOfService() {
        termsOfServiceCheckbox.click();
    }


    public void userClicksProceedToCheckoutAtSipping() {

        proceedToCheckoutShipping.click();
    }


    public void payByCheckMethod() {
        payByCheckMethod.click();
    }

    public void orderConfirmed() {

        confirmButton.click();
    }

    public String getModifiedQty() {
        return modifiedQuantity.getAttribute("value");
    }


    public String getSuccessMessage() {
        return successMessage.getText();
    }
}
