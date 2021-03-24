package com.automationpractice.steps.searchProductSteps;

import com.automationpractice.pages.ProductPage;
import com.automationpractice.pages.ProductSearchPage;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import com.automationpractice.pages.HomePage;

import java.util.concurrent.TimeUnit;

public class SearchProductSteps {

    private WebDriver driver;
    private HomePage homePage;
    private ProductPage productPage;
    private ProductSearchPage productSearchPage;

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

    @And("^user enters first product name in search bar$")
    public void userEntersFirstProductNameInSearchBar() {
        productPage = new ProductPage(driver);
        productPage.userEntersProductInSearchBar();

    }

    @And("^user clicks search$")
    public void userClicksSearch() {
        productPage.userClicksSearchButton();
    }

    @Then("^user validates product name displayed on product page and search page$")
    public void userValidatesProductNameDisplayedOnProductPageAndSearchPage() {
        productSearchPage = new ProductSearchPage(driver);
        Assert.assertEquals(productPage.getNameFromFirstProductDisplayedInProductPage(),
                productSearchPage.getNameFromFirstProductDisplayedInSearchPage());
    }


}
