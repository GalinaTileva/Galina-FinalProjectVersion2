package org.project.pages.signup;

import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.project.pages.BasePage;

public class VerifPage extends BasePage {

    @FindBy(xpath = "//div[contains(text(), 'Verify')]")
    private WebElement verifText;

    @FindBy(xpath = "//h2[contains(text(),'Protecting')]")
    private WebElement protectText;

    @FindBy(xpath = "//p[contains(text(),'puzzle')]")
    private WebElement puzzleText;

    @FindBy(xpath = "//button[contains(text(),'Verify')]")
    private WebElement verifyButton;

    @FindBy(xpath = "//p[contains(text(),'Audio')]")
    private WebElement audioButton;

    @Step("Visibility of 'Sign Up' page element")
    public Boolean verifyPageElementDisplayed() throws InterruptedException {
        Thread.sleep(5000);
        try {
            return verifText.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

}
