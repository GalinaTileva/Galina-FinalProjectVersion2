package org.project.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.project.utils.drivers.DriverFactory;

import java.time.Duration;

public class BasePage {
    private WebDriver driver;
    public WebDriverWait wait;
    protected Wait<WebDriver> fluentWait;

    public BasePage() {
        this.driver = DriverFactory.getDriver();
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        fluentWait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(20))
                .pollingEvery(Duration.ofMillis(500))
                .ignoring(NoSuchElementException.class);

    }

    public void waitForElementToBeVisibleWithFluentWait(WebElement element) {
        fluentWait.until(ExpectedConditions.visibilityOf(element));
    }

    public void waitForElementToBeVisible(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void waitForElementToBeClickable(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void waitForElementToBeStale(WebElement element) {
        wait.until(ExpectedConditions.stalenessOf(element));
    }

    public void clickWithJS(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
    }

    public void scrollIntoViewWithJS(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public void waitUntilAjaxRequestCompletes() {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        wait.until(driver -> (Boolean) jsExecutor.executeScript("return jQuery.active == 0"));
    }

    public String getCurrentUrl(){
        return driver.getCurrentUrl();
    }

    public void waitForUrlToChange(String currentUrl) {
        fluentWait.until(driver -> !driver.getCurrentUrl().equals(currentUrl));
    }


}
