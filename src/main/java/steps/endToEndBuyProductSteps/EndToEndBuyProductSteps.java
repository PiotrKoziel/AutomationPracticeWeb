package steps.endToEndBuyProductSteps;


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

public class EndToEndBuyProductSteps {

    private HomePage homePage;
    private LoginPage loginPage;
    private UserAccountPage userAccountPage;
    private ProductPage productPage;
    private DetailedProductPage detailedProductPage;
    private OrderPage orderPage;

    private WebDriver driver;


    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @After
    public void tearDown() {
        //driver.quit();
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
    public void userLogsInToAppUsingValidCredentials(String email, String password) {
        loginPage = new LoginPage(driver);
        loginPage.userEntersLoginCredentials(email, password);
        loginPage.userSignsIn();
    }

    @Then("^user moves over womens link$")
    public void userMovesToWomensLink() {
        userAccountPage = new UserAccountPage(driver);
        userAccountPage.userMovesOverLink();

    }

    @When("^user chooses (.*[^/]) product$")
    public void userChoosesProduct(String product) {
        userAccountPage.userClickOnProductLink(product);
    }

    @And("^user moves to displayed product$")
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
    public void userSelectsSizeOfProduct(String size) {
        detailedProductPage.userSelectsSize(size);

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
    public void userProceedsToCheckout() {
        detailedProductPage.userClicksProceedToCheckout();
    }


    @And("^user goes to payment conditions$")
    public void userGoesToPaymentConditions() {
        orderPage = new OrderPage(driver);
        orderPage.userClicksProceedToCheckoutAtSummary();

        orderPage.userClicksProceedToCheckoutAtAddress();

        if (!orderPage.termsOfService()) {
            orderPage.userClicksTermsOfService();
            orderPage.userClicksProceedToCheckoutAtSipping();
        } else {
            System.out.println("Please select Terms of service prior proceed further");
        }
    }

    @Then("^user selects payment method$")
    public void userSelectsPaymentMethod() {
        orderPage.payByCheckMethod();
    }

    @And("^user confirms the order$")
    public void userConfirmsTheOrder() {
        orderPage.orderConfirmed();
    }

    @Then("^user sees following successful message (.*[^/])$")
    public void userSeesSuccessfulMessage(String message) {
        Assert.assertEquals("Your order on My Store is complete.", orderPage.getSuccessMessage());
    }

    @When("^user moves over women's link$")
    public void userMovesOverWowensLink() {
        homePage = new HomePage(driver);
        homePage.userMovesOverLink();
    }

    @And("^user click on (.*[^/]) link$")
    public void userClicksOnProductLink(String product) {
        homePage.userClickOnProductLink(product);
    }

    @And("^user adds product to wishlist$")
    public void userAddsProductToWishlist() {
        productPage.userClicksAddToWishlist();
    }

    @Then("^user sees error message (.*[^/])$")
    public void userSeesErrorMessage(String message) {
        Assert.assertEquals(message, productPage.getErrorMessage());
    }

    @And("^user changes the quantity to (.*[^/])$")
    public void userChangesQuantity(String modifiedQty) {
        orderPage = new OrderPage(driver);
        orderPage.userChangesQuantity(modifiedQty);

    }

    @Then("^user verifies if total price is changing and reflecting correct price$")
    public void userVerifiesTotalPrice() {
        double modifiedQuantity = Double.parseDouble(orderPage.getModifiedQty());
        double unitPrice = Double.parseDouble(orderPage.getUnitPriceOff());
        double calculatedTotalPrice = unitPrice * modifiedQuantity;
        String calculatedTotalPriceSt = String.valueOf(calculatedTotalPrice);
        Assert.assertEquals(calculatedTotalPriceSt, orderPage.getTotalPriceToCompareOff());

    }


}


