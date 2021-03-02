package pages;

import cucumber.api.DataTable;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.Map;

public class CreateNewAccountPage {


    @FindBy(xpath = "//label[@class][normalize-space()]")
    List<WebElement> titleBoxes;
    @FindBy(id = "email")
    WebElement emailInput;
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
    @FindBy(id = "id_state")
    WebElement stateOpt;
    @FindBy(id = "id_country")
    WebElement countryOpt;
    @FindBy(id = "submitAccount")
    WebElement submitButton;
    @FindBy(css = "#center_column > div > p")
    WebElement error;
    @FindBy(xpath = "//*[@id='center_column']/div/ol")
    WebElement errorMessages;


    private static WebDriver driver;


    public CreateNewAccountPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    public void userSelectsTitle(String title) {
        for (WebElement titles : titleBoxes) {
            if (titles.getText().equals(title)) {
                titles.click();
            }
        }
    }


    public void userEntersFirstName(DataTable dataTable) {
        Map<String, String> data = dataTable.asMap(String.class, String.class);
        firstNameInput.sendKeys(data.get("firstName"));
    }

    public void userEntersLastName(DataTable dataTable) {
        Map<String, String> data = dataTable.asMap(String.class, String.class);
        lastNameInput.sendKeys(data.get("lastName"));
    }

    public void userEntersPassword(DataTable dataTable) {
        Map<String, String> data = dataTable.asMap(String.class, String.class);
        passInput.sendKeys(data.get("password"));
    }

    public void userEntersAddress(DataTable dataTable) {
        Map<String, String> data = dataTable.asMap(String.class, String.class);
        addressInput.sendKeys(data.get("address"));
    }

    public void userEntersCity(DataTable dataTable) {
        Map<String, String> data = dataTable.asMap(String.class, String.class);
        cityInput.sendKeys(data.get("city"));
    }

    public void userEntersPostcode(DataTable dataTable) {
        Map<String, String> data = dataTable.asMap(String.class, String.class);
        postCodeInput.sendKeys(data.get("zipcode"));
    }

    public void userEntersPhone(DataTable dataTable) {
        Map<String, String> data = dataTable.asMap(String.class, String.class);
        phoneInput.sendKeys(data.get("phone"));
    }

    public void userSelectsState(DataTable dataTable) {
        Map<String, String> data = dataTable.asMap(String.class, String.class);
        Select selectState = new Select(stateOpt);
        selectState.selectByVisibleText(data.get("state"));
    }

    public void userSelectsCountry(DataTable dataTable) {
        Map<String, String> data = dataTable.asMap(String.class, String.class);
        Select selectCountry = new Select(countryOpt);
        selectCountry.selectByVisibleText(data.get("country"));
    }

    public void userLeavesEmailEmpty() {
        emailInput.clear();
    }

    public void userLeavesFirstNameEmpty() {
        firstNameInput.clear();
    }

    public void userLeavesLastNameEmpty() {
        lastNameInput.clear();
    }

    public void userLeavesPasswordEmpty() {
        passInput.clear();
    }

    public void userLeavesAddressEmpty() {
        addressInput.clear();
    }

    public void userLeavesCityEmpty() {
        cityInput.clear();
    }

    public void userLeavesPostalCodeEmpty() {
        postCodeInput.clear();
    }

    public void userLeavesPhoneEmpty() {
        phoneInput.clear();
    }

    public void userUnselectCountry() {
        Select selectCountry = new Select(countryOpt);
        selectCountry.selectByIndex(0);
    }

    public void userClicksRegisterButton() {
        submitButton.click();
    }

    public Boolean isFirstNameEmpty() {
        boolean firstNameIsEmpty = firstNameInput.getAttribute("value").isEmpty();
        return firstNameIsEmpty;
    }

    public Boolean isLastNameEmpty() {
        boolean lastNameIsEmpty = lastNameInput.getAttribute("value").isEmpty();
        return lastNameIsEmpty;
    }

    public Boolean emailEmpty() {
        boolean emailIsEmpty = emailInput.getAttribute("value").isEmpty();
        return emailIsEmpty;
    }

    public Boolean isPassNameEmpty() {
        boolean passIsEmpty = passInput.getAttribute("value").isEmpty();
        return passIsEmpty;
    }

    public Boolean isAddressNameEmpty() {
        boolean addressIsEmpty = addressInput.getAttribute("value").isEmpty();
        return addressIsEmpty;
    }

    public Boolean isCityEmpty() {
        boolean cityIsEmpty = cityInput.getAttribute("value").isEmpty();
        return cityIsEmpty;
    }

    public Boolean isPostalCodeEmpty() {
        boolean postalCodeIsEmpty = postCodeInput.getAttribute("value").isEmpty();
        return postalCodeIsEmpty;
    }

    public Boolean isPhoneEmpty() {
        boolean phoneIsEmpty = phoneInput.getAttribute("value").isEmpty();
        return phoneIsEmpty;
    }

    public Boolean isStateEmpty() {
        boolean stateIsEmpty = stateOpt.getAttribute("value").isEmpty();
        return stateIsEmpty;
    }

    public Boolean isCountryEmpty() {
        boolean countryIsEmpty = countryOpt.getAttribute("value").isEmpty();
        return countryIsEmpty;
    }


    public String getError() {
        String numOfErrors = error.getText();
        return numOfErrors;
    }

    public String getErrMsg() {
        String errorMessage = errorMessages.getText().trim().toLowerCase().
                replaceAll("[: .+]", "");
        return errorMessage;
    }

    public Boolean firstSelectedOption(String option) {
        Select selectCountry = new Select(countryOpt);
        boolean firstSelectedOption = selectCountry.getFirstSelectedOption().getText().equals(option);
        return firstSelectedOption;
    }

}


