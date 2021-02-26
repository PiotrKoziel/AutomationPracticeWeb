package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
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
    WebElement proceedToAddress;
    @FindBy(name = "processAddress")
    WebElement proceedShipping;
    @FindBy(id = "cgv")
    WebElement termsOfServiceCheckbox;
    @FindBy(name = "processCarrier")
    WebElement proceedToPayment;
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

    }

    public String getUnitPriceOff() {
        String pricePerUnitOff = pricePerUnit.getText().trim().substring(1);
        return pricePerUnitOff;
    }

    public String getTotalPriceToCompareOff() {

        String totalPriceToCompareOff = totalPriceToCompare.getText().trim().substring(1);
        return totalPriceToCompareOff;
    }

    public Boolean ExpectedCondition(String valueOfAtt) {
        WebDriverWait wait = new WebDriverWait(driver, 5);
        Boolean doesAttributeEqualValue =
                wait.until(ExpectedConditions.attributeToBe(modifiedQuantity, "value", valueOfAtt));
        return doesAttributeEqualValue;
    }

    public String getQuantity() {
        String changedQuantity = modifiedQuantity.getAttribute("value");
        return changedQuantity;
    }

    public void proceedToAddress() {
        proceedToAddress.click();
    }

    public void proceedToShipping() {
        proceedShipping.click();

    }

    public Boolean termsOfService() {
     Boolean termsMatched=!termsOfServiceCheckbox.isSelected();
        return termsMatched;
    }

    public void termsOfServiceMatched(){

        termsOfServiceCheckbox.click();
    }


    public void proceedToPayment() {
        proceedToPayment.click();
    }

    public void payByCheckMethod(){
        payByCheckMethod.click();
    }

    public void orderConfirmed(){
        confirmButton.click();
    }

    public String getSuccessMessage(){
        String successMsg = successMessage.getText();
    return successMsg;
    }
}
