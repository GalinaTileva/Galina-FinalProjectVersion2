package org.project.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage extends BasePage {
    private LoginPage loginPage;
    private MainPage mainPage;

    @FindBy(css = "[aria-label='Start a new repository']")
    private WebElement startRepoSection;

    @FindBy(css = "[for='repository[name]']")
    private WebElement repoNameLabel;

    @FindBy(css = "[placeholder='name your new repository...']")
    private WebElement repoNameInput;

    @FindBy(xpath = "//label[contains(text(),'Public')]")
    private WebElement publicCheckboxLabel;

    @FindBy(css = "[value='public']")
    private WebElement publicCheckbox;

    @FindBy(xpath = "//label[contains(text(),'Private')]")
    private WebElement privateCheckboxLabel;

    @FindBy(css = "[value='private']")
    private WebElement privateCheckbox;

    @FindBy(css = "[value='Create a new repository']")
    private WebElement createRepoButton;

    @Step("Visibility of 'Main page' element")
    public Boolean mainPageElementVisible() {
        try {
            return createRepoButton.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }



}
