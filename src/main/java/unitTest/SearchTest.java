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

import java.util.List;
import java.util.concurrent.TimeUnit;

public class SearchTest {

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

    @Test
    public void searchProduct() {
        userGoesToWebPage("http://automationpractice.com/index.php");
        userMovesOverWomensLink();
        userClickOnProductLink("T-shirts");
        userEntersFirstProductNameInSearchBar();
        userClicksSearch();
        userValidatesProductNameDisplayedOnProductPageAndSearchPage();
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

        String productTitlePage = driver.getTitle();
        System.out.println("User is on product page: " + productTitlePage);
        Assert.assertTrue("User is not directed to product page", productTitlePage.contains(product));

    }

    public String getNameFromFirstProductDisplayedInProductPage() {
        List<WebElement> products = driver.findElements(By.xpath("//a[contains(text(), 'Faded')]"));
        String firstNameFromProductPage = products.get(0).getText();

        return firstNameFromProductPage;
    }

    public void userEntersFirstProductNameInSearchBar() {
        WebElement searchBar = driver.findElement(By.id("search_query_top"));
        searchBar.clear();
        searchBar.sendKeys(getNameFromFirstProductDisplayedInProductPage());
    }

    public void userClicksSearch() {

        driver.findElement(By.name("submit_search")).click();
        String searchTitlePage = driver.getTitle();


        System.out.println("User is on search page: " + searchTitlePage);
        Assert.assertTrue("User is not directed to product page", searchTitlePage.equals("Search - My Store"));


    }

    public String getNameFromFirstProductDisplayedInSearchPage() {
        List<WebElement> products = driver.findElements(By.xpath("//a[contains(text(), 'Faded')]"));
        String firstNameFromSearchPage = products.get(0).getText();

        return firstNameFromSearchPage;
    }

    public void userValidatesProductNameDisplayedOnProductPageAndSearchPage() {
        Assert.assertEquals(getNameFromFirstProductDisplayedInProductPage(), getNameFromFirstProductDisplayedInSearchPage());
    }
}