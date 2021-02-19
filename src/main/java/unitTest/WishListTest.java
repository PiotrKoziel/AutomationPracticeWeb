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

import java.util.concurrent.TimeUnit;

public class WishListTest {
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
    public void wishListAfterLogin(){
       userGoesToWebPage("http://automationpractice.com/index.php");
       userMovesOverWomensLink();
       userClickOnProductLink("T-shirts");
       userMovesToDisplayedProduct();
       userSeesErrorMessage();

    }
    public void userGoesToWebPage(String url) {
        driver.get(url);
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
        WebElement wishListBtn = driver.findElement(By.xpath("//a[normalize-space()='Add to Wishlist']"));
        Actions action = new Actions(driver);
        action.moveToElement(shortSleeve).moveToElement(wishListBtn).click().perform();
    }


    public void userSeesErrorMessage() {
        WebElement errorMessage = driver.findElement(By.xpath("//p[@class = 'fancybox-error']"));
        Assert.assertEquals("You must be logged in to manage your wishlist.", errorMessage.getText());
    }
}
