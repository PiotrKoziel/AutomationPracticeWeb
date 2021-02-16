package steps.userRegisrationSteps;

import cucumber.api.DataTable;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import helper.AggregatedAsserts;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.Map;
import java.util.concurrent.TimeUnit;

public class UserRegistrationSteps {

    private static WebDriver driver;
    private AggregatedAsserts aggregatedAsserts = new AggregatedAsserts();


    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @After
    public void tearDown() {
        driver.quit();
    }


    @Given("^user navigates to web page")
    public void userNavigateToUrl() {
        driver.get("http://automationpractice.com/index.php");
    }

    @When("^user clicks on sign in link$")
    public void userClicksOnSignInLink() {
        driver.findElement(By.cssSelector("a[title='Log in to your customer account']")).click();
    }

    @And("^user enters email address (.*[^/]) in 'Create and account' section$")
    public void userEntersEmail(String emailAddress) {
        driver.findElement(By.id("email_create")).sendKeys(System.currentTimeMillis() + emailAddress);

    }

    @Then("^user clicks on Create an Account button$")
    public void userClicksCreateAnAccountButton() {
        driver.findElement(By.id("SubmitCreate")).click();

    }

    @When("^user selects the title (.*[^/])$")
    public void userSelectsTitle(String title) {
        WebElement theTitle = driver.findElement(By.xpath(" //label[normalize-space()='" + title + "']"));
        //System.out.println(theTitle.getText());
        if (!theTitle.isSelected()) {
            theTitle.click();
        }
    }

    @And("^user enters personal information$")
    public void userEntersPersonalInformation(DataTable dataTable) {
        Map<String, String> data = dataTable.asMap(String.class, String.class);

        driver.findElement(By.id("customer_firstname")).sendKeys(data.get("firstName"));
        driver.findElement(By.id("customer_lastname")).sendKeys(data.get("lastName"));
        driver.findElement(By.id("passwd")).sendKeys(data.get("password"));
        driver.findElement(By.name("address1")).sendKeys(data.get("address"));
        driver.findElement(By.name("city")).sendKeys(data.get("city"));
        driver.findElement(By.id("postcode")).sendKeys(data.get("zipcode"));
        driver.findElement(By.id("phone_mobile")).sendKeys(data.get("phone"));

        Select selectState = new Select(driver.findElement(By.id("id_state")));
        selectState.selectByVisibleText(data.get("state"));

        Select selectCountry = new Select(driver.findElement(By.id("id_country")));
        selectCountry.selectByVisibleText(data.get("country"));

    }

    @And("^user clicks on register button$")
    public void userClicksRegisterButton() {
        driver.findElement(By.id("submitAccount")).click();

    }

    @Then("^user successfully sings in$")
    public void userSignIn(DataTable dataTable) {
        WebElement userId = driver.findElement(By.xpath("//span[contains(text(),'Jones')]"));
        //System.out.println(userId.getText());
        Map<String, String> data = dataTable.asMap(String.class, String.class);

        Assert.assertTrue("log in not completed", userId.getText().contains(data.get("lastName")));

    }


    @When("^user enters invalid (.*[^/]) email address$")
    public void userEntersInvalidEmailAddress(String invalidEmail) {
        driver.findElement(By.id("email_create")).sendKeys(invalidEmail);
    }


    @And("^user clicks enter$")
    public void userClicksEnter() {
        driver.findElement(By.id("email_create")).sendKeys(Keys.ENTER);
    }


    @Then("^user sees the following message (.*[^/])$")
    public void userSeesUnsuccessfulMessage(String message) {
        WebElement invalidMessage = driver.findElement(By.xpath("*//li[contains(text(), 'Invalid')]"));
        System.out.println(invalidMessage.getText());
        Assert.assertEquals(message, invalidMessage.getText());
    }


    @And("^user leaves mandatory fields empty$")
    public void userLeavesMandatoryFieldsBlank() throws InterruptedException {

        Thread.sleep(5000);

        WebElement emailBox = driver.findElement(By.id("email"));

        //System.out.println(emailBox.getAttribute("value"));
        emailBox.clear();

        Select selectCountry = new Select(driver.findElement(By.id("id_country")));
        selectCountry.selectByIndex(0);
    }

    @Then("^user sees displayed error for the mandatory fields$")
    public void userSeesDisplayedErrorForMandatoryFields() {
        aggregatedAsserts.assertTrue("First name text box is not empty",
                driver.findElement(By.id("customer_firstname")).getAttribute("value").isEmpty());

        aggregatedAsserts.assertTrue("Last name text box is not empty",
                driver.findElement(By.id("customer_lastname")).getAttribute("value").isEmpty());

        aggregatedAsserts.assertTrue("Password text box is not empty",
                driver.findElement(By.id("passwd")).getAttribute("value").isEmpty());

        aggregatedAsserts.assertTrue("Email text box is not empty",
                driver.findElement(By.id("email")).getAttribute("value").isEmpty());

        aggregatedAsserts.assertTrue("Address text box is not empty",
                driver.findElement(By.name("address1")).getAttribute("value").isEmpty());

        aggregatedAsserts.assertTrue("City text box is not empty",
                driver.findElement(By.name("city")).getAttribute("value").isEmpty());

        aggregatedAsserts.assertTrue("Zip code text box is not empty",
                driver.findElement(By.id("postcode")).getAttribute("value").isEmpty());

        aggregatedAsserts.assertTrue("Phone text box is not empty",
                driver.findElement(By.id("phone_mobile")).getAttribute("value").isEmpty());

        aggregatedAsserts.assertTrue("State text box is not empty",
                driver.findElement(By.id("id_state")).getAttribute("value").isEmpty());

        aggregatedAsserts.assertTrue("Country text box is not empty",
                driver.findElement(By.id("id_country")).getAttribute("value").isEmpty());

        aggregatedAsserts.processAllAssertions();
    }

    @And("^user enters incorrect values in personal information fields$")
    public void userEntersIncorrectValues(DataTable dataTable) {
        Map<String, String> data = dataTable.asMap(String.class, String.class);
        driver.findElement(By.id("customer_firstname")).sendKeys(data.get("firstName"));
        driver.findElement(By.id("customer_lastname")).sendKeys(data.get("lastName"));
        driver.findElement(By.id("passwd")).sendKeys(data.get("password"));
        driver.findElement(By.name("address1")).sendKeys(data.get("address"));
        driver.findElement(By.name("city")).sendKeys(data.get("city"));
        driver.findElement(By.id("postcode")).sendKeys(data.get("zipcode"));
        driver.findElement(By.id("phone_mobile")).sendKeys(data.get("phone"));

        try {
            Select selectState = new Select(driver.findElement(By.id("id_state")));
            selectState.selectByVisibleText(data.get("state"));
        } catch (NoSuchElementException ex) {
            System.out.println("No such a option in state list");
        }

        try {
            Select selectCountry = new Select(driver.findElement(By.id("id_country")));
            selectCountry.selectByVisibleText(data.get("country"));
        } catch (NoSuchElementException ex) {
            System.out.println("No such a option in country list");
        }

    }

    @Then("^user sees error messages displayed for respective fields$")
    public void userSeesErrorMessagesDisplayedForRespectiveFields() {
        try {

            WebElement error = driver.findElement(By.cssSelector("#center_column > div > p"));
            System.out.println("Number of errors displayed: " + error.getText());

            WebElement errorMessages = driver.findElement(By.xpath("//*[@id='center_column']/div/ol"));
            String errorMessage = errorMessages.getText().trim().toLowerCase().replaceAll("[: .+]", "");
            System.out.println("Error messages:\n" + errorMessage);

            Select selectCountry = new Select(driver.findElement(By.id("id_country")));
            if (!selectCountry.getFirstSelectedOption().getText().equals("-")) {
                aggregatedAsserts.assertTrue("State is correct", errorMessage.contains("tochooseastate"));

            } else {
                aggregatedAsserts.assertTrue("Country is correct", errorMessage.contains("countryisinvalid"));
            }

            aggregatedAsserts.assertTrue("First name is correct", errorMessage.contains("firstnameisinvalid"));
            aggregatedAsserts.assertTrue("Last name is correct", errorMessage.contains("lastnameisinvalid"));
            aggregatedAsserts.assertTrue("Password is correct", errorMessage.contains("passwdisinvalid"));
            aggregatedAsserts.assertTrue("Address is correct", errorMessage.contains("address1isinvalid"));
            aggregatedAsserts.assertTrue("Zip code is correct", errorMessage.contains("postcodeisinvalid"));
            aggregatedAsserts.assertTrue("City is correct", errorMessage.contains("cityisinvalid"));


            aggregatedAsserts.processAllAssertions();

        } catch (NoSuchElementException ex) {
            System.out.println("ERROR MESSAGES NOT THERE");
        }
    }
}



