package steps.userRegistrationSteps;

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
import pages.CreateNewAccountPage;
import pages.HomePage;
import pages.LoginPage;
import pages.UserAccountPage;

import java.util.Map;
import java.util.concurrent.TimeUnit;

public class UserRegistrationSteps {

    private WebDriver driver;
    private AggregatedAsserts aggregatedAsserts = new AggregatedAsserts();


    private LoginPage loginPage;
    private HomePage homePage;
    private CreateNewAccountPage createNewAccountPage;
    private UserAccountPage userAccountPage;


    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @After
    public void tearDown() {
        //driver.quit();
    }


    @Given("^user navigates to web page")
    public void userNavigateToUrl() {

        driver.get("http://automationpractice.com/index.php");
    }

    @When("^user clicks on sign in link$")
    public void userClicksOnSignInLink() {
        homePage = new HomePage(driver);
        homePage.userClicksSignInButton();
    }

    @And("^user enters email address (.*[^/]) in 'Create and account' section$")
    public void userEntersEmail(String newEmailAddress) {
        loginPage = new LoginPage(driver);
        loginPage.userEntersEmailAddress(newEmailAddress);
    }

    @Then("^user clicks on Create an Account button$")
    public void userClicksCreateAnAccountButton() {
        loginPage.userSubmitsEmailAddress();
    }


    @When("^user selects the title (.*[^/])$")
    public void userSelectsTitle(String title) {
        createNewAccountPage = new CreateNewAccountPage(driver);
        createNewAccountPage.userSelectsTitle(title);

    }

    @And("^user enters personal information$")
    public void userEntersPersonalInformation(DataTable dataTable) {
        createNewAccountPage.userEntersFirstName(dataTable);
        createNewAccountPage.userEntersLastName(dataTable);
        createNewAccountPage.userEntersPassword(dataTable);
        createNewAccountPage.userEntersAddress(dataTable);
        createNewAccountPage.userEntersCity(dataTable);
        createNewAccountPage.userEntersPostcode(dataTable);
        createNewAccountPage.userEntersPhone(dataTable);
        createNewAccountPage.userSelectsState(dataTable);
        createNewAccountPage.userSelectsCountry(dataTable);

    }

    @And("^user register in application$")
    public void userRegistersInApplication() {
        createNewAccountPage.userClicksRegisterButton();
    }

    @Then("^user successfully sings in$")
    public void userSignIn(DataTable dataTable) {
        userAccountPage = new UserAccountPage(driver);
        Map<String, String> data = dataTable.asMap(String.class, String.class);
        System.out.println(userAccountPage.getUserId());
        Assert.assertTrue("log in not completed",
                userAccountPage.getUserId().contains(data.get("lastName")));
    }


    @When("^user enters invalid (.*[^/]) email address$")
    public void userEntersInvalidEmailAddress(String invalidEmail) {
        loginPage = new LoginPage(driver);
        loginPage.userEntersEmailAddress(invalidEmail);
    }


    @And("^user clicks enter$")
    public void userClicksEnter() {
        loginPage.userClicksEnter();
    }


    @Then("^user sees the following message (.*[^/])$")
    public void userSeesUnsuccessfulMessage(String message) {
        Assert.assertEquals(message, loginPage.getInvalidMessage());
    }


    @And("^user leaves mandatory fields empty$")
    public void userLeavesMandatoryFieldsBlank() throws InterruptedException {
        createNewAccountPage = new CreateNewAccountPage(driver);
        createNewAccountPage.userLeavesFirstNameEmpty();
        createNewAccountPage.userLeavesLastNameEmpty();
        createNewAccountPage.userLeavesEmailEmpty();
        createNewAccountPage.userLeavesAddressEmpty();
        createNewAccountPage.userLeavesCityEmpty();
        createNewAccountPage.userLeavesPasswordEmpty();
        createNewAccountPage.userLeavesPhoneEmpty();
        createNewAccountPage.userLeavesPostalCodeEmpty();
        createNewAccountPage.userUnselectCountry();

    }

    @Then("^user sees displayed error for the mandatory fields$")
    public void userSeesDisplayedErrorForMandatoryFields() {
        aggregatedAsserts.assertTrue("First name text box is not empty",
                createNewAccountPage.isFirstNameEmpty());

        aggregatedAsserts.assertTrue("Last name text box is not empty",
                createNewAccountPage.isLastNameEmpty());

        aggregatedAsserts.assertTrue("Last name text box is not empty",
                createNewAccountPage.emailEmpty());

        aggregatedAsserts.assertTrue("Password text box is not empty",
                createNewAccountPage.isPassNameEmpty());

        aggregatedAsserts.assertTrue("Address text box is not empty",
                createNewAccountPage.isAddressNameEmpty());

        aggregatedAsserts.assertTrue("City text box is not empty",
                createNewAccountPage.isCityEmpty());

        aggregatedAsserts.assertTrue("Zip code text box is not empty",
                createNewAccountPage.isPostalCodeEmpty());

        aggregatedAsserts.assertTrue("Phone text box is not empty",
                createNewAccountPage.isPhoneEmpty());

        aggregatedAsserts.assertTrue("State text box is not empty",
                createNewAccountPage.isStateEmpty());

        aggregatedAsserts.assertTrue("Country text box is not empty",
                createNewAccountPage.isCountryEmpty());

        aggregatedAsserts.processAllAssertions();
    }


    @And("^user enters incorrect values in personal information fields$")
    public void userEntersIncorrectValues(DataTable dataTable) {
        createNewAccountPage = new CreateNewAccountPage(driver);

        createNewAccountPage.userEntersFirstName(dataTable);
        createNewAccountPage.userEntersLastName(dataTable);
        createNewAccountPage.userEntersPassword(dataTable);
        createNewAccountPage.userEntersAddress(dataTable);
        createNewAccountPage.userEntersCity(dataTable);
        createNewAccountPage.userEntersPostcode(dataTable);
        createNewAccountPage.userEntersPhone(dataTable);

        try {
            createNewAccountPage.userSelectsState(dataTable);
        } catch (NoSuchElementException ex) {
            System.out.println("No such a option in state list");
        }

        try {
            createNewAccountPage.userSelectsCountry(dataTable);
        } catch (NoSuchElementException ex) {
            System.out.println("No such a option in country list");
        }

    }

    @Then("^user sees error messages displayed for respective fields$")
    public void userSeesErrorMessagesDisplayedForRespectiveFields() {
        try {

            System.out.println("Number of errors displayed: " + createNewAccountPage.getError());
            System.out.println("Error messages:\n" + createNewAccountPage.getErrMsg());


            if (!createNewAccountPage.firstSelectedOption("-")) {
                aggregatedAsserts.assertTrue("State is correct",
                        createNewAccountPage.getErrMsg().contains("tochooseastate"));

            } else {
                aggregatedAsserts.assertTrue("Country is correct",
                        createNewAccountPage.getErrMsg().contains("countryisinvalid"));
            }

            aggregatedAsserts.assertTrue("First name is correct",
                    createNewAccountPage.getErrMsg().contains("firstnameisinvalid"));
            aggregatedAsserts.assertTrue("Last name is correct",
                    createNewAccountPage.getErrMsg().contains("lastnameisinvalid"));
            aggregatedAsserts.assertTrue("Password is correct",
                    createNewAccountPage.getErrMsg().contains("passwdisinvalid"));
            aggregatedAsserts.assertTrue("Address is correct",
                    createNewAccountPage.getErrMsg().contains("address1isinvalid"));

            aggregatedAsserts.assertTrue("Zip code is correct",
                    createNewAccountPage.getErrMsg().contains("thezip/postalcode"));

            aggregatedAsserts.assertTrue("City is correct",
                    createNewAccountPage.getErrMsg().contains("cityisinvalid"));

            aggregatedAsserts.processAllAssertions();

        } catch (NoSuchElementException ex) {
            System.out.println("ERROR MESSAGES NOT THERE");
        }
    }
}



