package steps.userRegisrationSteps;

import cucumber.api.DataTable;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.Map;
import java.util.concurrent.TimeUnit;

public class UserRegistrationSteps {

    private static WebDriver driver;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
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
        System.out.println(theTitle.getText());
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
        Map<String, String> data = dataTable.asMap(String.class, String.class);

        assert data.get("lastName").contains(userId.getText());
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
        System.out.println(emailBox.getAttribute("value"));
        emailBox.clear();

        Select selectCountry = new Select(driver.findElement(By.id("id_country")));
        selectCountry.selectByIndex(0);
    }

    @Then("^user sees displayed error for the mandatory fields$")
    public void userSeesDisplayedErrorForMandatoryFields() {
        Assert.assertTrue("First name text box is not empty",
                driver.findElement(By.id("customer_firstname")).getAttribute("value").isEmpty());

        Assert.assertTrue("Last name text box is not empty",
                driver.findElement(By.id("customer_lastname")).getAttribute("value").isEmpty());

        Assert.assertTrue("Password text box is not empty",
                driver.findElement(By.id("passwd")).getAttribute("value").isEmpty());

        Assert.assertTrue("Email text box is not empty",
                driver.findElement(By.id("email")).getAttribute("value").isEmpty());

        Assert.assertTrue("Address text box is not empty",
                driver.findElement(By.name("address1")).getAttribute("value").isEmpty());

        Assert.assertTrue("City text box is not empty",
                driver.findElement(By.name("city")).getAttribute("value").isEmpty());

        Assert.assertTrue("Zip code text box is not empty",
                driver.findElement(By.id("postcode")).getAttribute("value").isEmpty());

        Assert.assertTrue("Phone text box is not empty",
                driver.findElement(By.id("phone_mobile")).getAttribute("value").isEmpty());

        Assert.assertTrue("State text box is not empty",
                driver.findElement(By.id("id_state")).getAttribute("value").isEmpty());

        Assert.assertTrue("Country text box is not empty",
                driver.findElement(By.id("id_country")).getAttribute("value").isEmpty());

    }




}
