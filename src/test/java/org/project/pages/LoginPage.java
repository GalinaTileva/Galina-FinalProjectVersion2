package org.project.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    @FindBy(css = ".header-logo")
    private WebElement catLogoLink;

    @FindBy(css = ".auth-form-header")
    private WebElement signInText;

    @FindBy(css = "[for='login_field']")
    private WebElement userLabel;

    @FindBy(css = "#login_field")
    private WebElement userInput;

    @FindBy(css = "#forgot-password")
    private WebElement forgottenPasswordLink;

    @FindBy(css = "[for='password']")
    private WebElement passwordLabel;

    @FindBy(css = "#password")
    private WebElement passwordInput;

    @FindBy(css = "[value='Sign in']")
    private WebElement loginButton;

    @FindBy(css = "[data-target='webauthn-get.buttonText']")
    private WebElement passkeyButton;

    @FindBy(css = "a[href='/signup?source=login']")
    private WebElement signUpLink;


    @Step("Visibility of 'Sign In' page element")
    public Boolean loginElementVisible() {
        try {
            return userInput.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    @Step("Redirection to Main page")
    public MainPage goToMainPage (String username, String password) {
        userInput.click();
        userInput.sendKeys(username);
        passwordInput.click();
        passwordInput.sendKeys(password);
        loginButton.click();
        return new MainPage();
    }








}
