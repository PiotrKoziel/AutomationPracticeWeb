package steps.orderProcedureSteps;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.*;

import java.util.concurrent.TimeUnit;

public class OrderProcedureSteps {
    private WebDriver driver;
    private HomePage homePage;
    private LoginPage loginPage;
    private UserPage userPage;
    private ProductPage productPage;
    private DetailedProductPage detailedProductPage;
    private OrderPage orderPage;

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

    @When("^user goes to login page$")
    public void userGoesToLoginPage() {
        homePage = new HomePage(driver);
        homePage.userClicksSignInButton();
    }

    @And("^user logs in to app with following email (.*[^/]) and password (.*[^/])$")
    public void userLogsIn(String email, String password) {
        loginPage = new LoginPage(driver);
        loginPage.userEntersLoginCredentials(email, password);
        loginPage.userSignsIn();
        Assert.assertTrue("user is not directed to My Account page",
                driver.getTitle().equals("My account - My Store"));
    }

    @Then("^user moves over womens link$")
    public void userMovesOverWomensLink() {
        userPage = new UserPage(driver);
        userPage.userMovesOverLink();
    }


    @When("^user chooses (.*[^/]) product$")
    public void userChoosesTheProduct(String product) {
        userPage.userClickOnProductLink(product);
    }

    @And("^user moves to displayed product")
    public void userMovesToDisplayedProduct() {
        productPage = new ProductPage(driver);
        productPage.userMovesToDisplayedProduct();
    }

    @Then("^user click more link$")
    public void userClicksMoreLink() {
        productPage.userClicksMoreBtn();
    }

    @When("^user enters quantity of (.*[^/])$")
    public void userEntersQuantity(String qty) {
        detailedProductPage = new DetailedProductPage(driver);
        detailedProductPage.userEntersNumberOfProducts(qty);
    }

    @And("^user selects size (.*[^/]) of product$")
    public void userSelectsSizeOfProduct(String newSize) {
        detailedProductPage.userSelectsSize(newSize);
    }

    @And("^user selects color (.*[^/]) of product$")
    public void userSelectsColorOfProduct(String color) {
        detailedProductPage.userSelectsColor(color);
    }

    @Then("^user adds product to cart$")
    public void userAddsProductToCart() {
        detailedProductPage.userClicksAddToCart();
    }

    @When("^user proceeds to checkout$")
    public void userGoesToCheckout() {
        detailedProductPage.userClicksProceedToCheckout();
    }


    @And("^user changes the quantity to (.*[^/])$")
    public void userChangesTheQty(String qty2) {
        orderPage = new OrderPage(driver);
        orderPage.userChangesQuantity(qty2);

        orderPage.ExpectedCondition(qty2);
    }

    @Then("^user verifies total price$")
    public void userVerifiesTotalPrice() {

        Double unitPriceNow = Double.parseDouble(orderPage.getUnitPriceOff());
        Double totalPriceCalc = (unitPriceNow * Double.parseDouble(orderPage.getQuantity()));
        Double totalPriceToCompareParsed = Double.parseDouble(orderPage.getTotalPriceToCompareOff());

        Assert.assertEquals(totalPriceToCompareParsed, totalPriceCalc);
    }

    @When("^user goes to payment conditions$")
    public void userGoesToPaymentConditions() {
        orderPage.proceedToAddress();
        orderPage.proceedToShipping();

        if (orderPage.termsOfService()) {
            orderPage.termsOfServiceMatched();
            orderPage.proceedToPayment();
        } else {
            System.out.println("Select terms of service");
        }
    }

    @And("^user selects payment method$")
    public void userSelectsPaymentMethod() {
        orderPage.payByCheckMethod();
    }

    @And("^user confirms the order$")
    public void userConfirmsTheOrder() {
        orderPage.orderConfirmed();
    }

    @Then("^user sees following successful message (.*[^/])$")
    public void userSeesSuccessfulMessage(String message) {
        Assert.assertEquals(message, orderPage.getSuccessMessage());
    }
}

