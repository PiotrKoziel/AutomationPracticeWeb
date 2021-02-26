package steps.wishListSteps;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.HomePage;
import pages.ProductPage;

import java.util.concurrent.TimeUnit;

public class WishListSteps {

    private WebDriver driver;
    private HomePage homePage;
    private ProductPage productPage;


    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @After
    public void tearDown() {
        driver.quit();
    }


    @Given("^user goes to web page$")
    public void userNavigatePage() {
        driver.get("http://automationpractice.com/index.php");
    }

    @When("^user moves over womens link$")
    public void userMovesToWowensLink() {
        homePage = new HomePage(driver);
        homePage.userMovesOverLink();
    }

    @And("^user click on (.*[^/]) link$")
    public void userClicksProductLink(String product) {
        homePage.userClickOnProductLink(product);
    }

    @And("^user moves to displayed product$")
    public void userMovesToDisplayedProduct() {
        productPage = new ProductPage(driver);
        productPage.userMovesToDisplayedProduct();
    }

    @And("^user adds product to wishlist$")
    public void userAddsProductToWishList() {
        productPage.userClicksAddToWishlist();
    }

    @Then("^user sees error message (.*[^/])$")
    public void userSeesErrorMessage(String message) {
        Assert.assertEquals(message, productPage.getErrorMessage());
    }

}
