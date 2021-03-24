package com.automationpractice.helper;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import java.time.Duration;


public class WaitForElement {

    private WebDriver driver;

    public WaitForElement(WebDriver driver) {
        this.driver = driver;
    }


    public void waitForElementToBeDisplayed(WebElement element) {

        FluentWait<WebDriver> wait = new FluentWait<>(driver);
        wait.withTimeout(Duration.ofSeconds(15)).pollingEvery(Duration.ofMillis(1000)).ignoring(NoSuchElementException.class);
        wait.until(ExpectedConditions.visibilityOf(element));


    }

    public void waitForElementToBeDisplayed(By locator) {

        FluentWait<WebDriver> wait = new FluentWait<>(driver);
        wait.withTimeout(Duration.ofSeconds(15)).pollingEvery(Duration.ofMillis(1000)).ignoring(NoSuchElementException.class);
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public void waitForElementToBe(WebElement element) {

        FluentWait<WebDriver> wait = new FluentWait<>(driver);
        wait.withTimeout(Duration.ofSeconds(15)).pollingEvery(Duration.ofMillis(1000)).
                ignoring(NoSuchElementException.class);
        wait.until(ExpectedConditions.attributeToBe(element,
                element.getAttribute("value"),element.getText()));


    }


}
