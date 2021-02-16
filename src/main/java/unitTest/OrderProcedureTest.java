package unitTest;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

public class OrderProcedureTest {

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
        driver.quit();
    }

    @Test
    public void userPurchaseAndOrder() {
        userGoesToWebPage("http://automationpractice.com/index.php");
        userGoesToLoginPage();
        userLogsIn("indiana@jones.com", "jones");
        userMovesOverWomensLink();
        userClickOnProductLink("T-shirts");
        userMovesToDisplayedProduct();
        userEntersQuantity("2");
        userSelectsSize("L");
        userSelectsColor("Blue");
        userAddsToCart();
        userProceedToPaymentMethod();
        userSelectsPaymentMethod();
        userConfirmsTheOrder();
        userSeesSuccessfulOrderedMessage();

    }

    public void userGoesToWebPage(String url) {

        driver.get(url);
    }

    public void userGoesToLoginPage() {

        driver.findElement(By.linkText("Sign in")).click();
    }

    public void userLogsIn(String username, String pass) {
        driver.findElement(By.id("email")).sendKeys(username);
        driver.findElement(By.id("passwd")).sendKeys(pass);
        driver.findElement(By.id("SubmitLogin")).click();
        Assert.assertTrue(driver.getTitle().equals("My account - My Store"));

    }

    public void userMovesOverWomensLink() {
        WebElement womenLink = driver.findElement(By.xpath("//a[@title='Women']"));
        Actions action = new Actions(driver);
        action.moveToElement(womenLink).build().perform();
    }

    public void userClickOnProductLink(String product) {
        WebElement productLink = driver.findElement(By.linkText("" + product + ""));
        productLink.click();

    }

    public void userMovesToDisplayedProduct() {
        WebElement shortSleeve = driver.findElement(By.xpath("//img[@title='Faded Short Sleeve T-shirts']"));
        WebElement moreBtn = driver.findElement(By.xpath("//span[text()='More']"));
        Actions action = new Actions(driver);
        action.moveToElement(shortSleeve).moveToElement(moreBtn).click().perform();
    }

    public void userEntersQuantity(String qty) {
        WebElement qtyInput = driver.findElement(By.id("quantity_wanted"));
        qtyInput.clear();
        qtyInput.sendKeys(qty);
    }

    public void userSelectsSize(String size) {
        WebElement sizeOpt = driver.findElement(By.id("group_1"));
        Select select = new Select(sizeOpt);
        select.selectByVisibleText(size);
    }

    public void userSelectsColor(String color) {
        WebElement colorOpt = driver.findElement(By.xpath("//a[@title='" + color + "']"));
        if (!colorOpt.isSelected()) {
            colorOpt.click();
        }
    }

    public void userAddsToCart() {
        driver.findElement(By.name("Submit")).click();
    }

    public void userProceedToPaymentMethod() {
        driver.findElement(By.xpath("//*[@title = 'Proceed to checkout']")).click();
        driver.findElement(By.xpath("//*[@id='center_column']/p[2]/a[1]")).click();
        driver.findElement(By.name("processAddress")).click();

        WebElement termsOfService = driver.findElement(By.id("cgv"));
        if (!termsOfService.isSelected()) {
            termsOfService.click();
            driver.findElement(By.name("processCarrier")).click();
        }else{
            System.out.println("Please select Terms of service prior proceed further");
        }

    }

    public void userSelectsPaymentMethod() {
        driver.findElement(By.xpath("//*[contains(text(), 'Pay by check')]")).click();
    }

    public void userConfirmsTheOrder() {
        driver.findElement(By.xpath("//*[@id='cart_navigation']/button")).click();
    }

    public void userSeesSuccessfulOrderedMessage() {
        WebElement successMessage = driver.findElement(By.xpath("//*[@id='center_column']/p[1]"));
        Assert.assertEquals("Your order on My Store is complete.", successMessage.getText());
    }

}




