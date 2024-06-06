package org.project.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SettingsPage extends BasePage {

    @FindBy(css = "#rename-field")
    private WebElement renameInput;

    @FindBy(xpath = "//button[contains(text(),'Rename')]")
    private WebElement renameButton;

    @FindBy(css = "#dialog-show-repo-delete-menu-dialog")
    private WebElement deleteRepoButton;

    @FindBy(css = "#repo-delete-proceed-button")
    private WebElement proceedDeleteButton;    //wait visible, x2

    @FindBy(css = "#verification_field")
    private WebElement repoNameInput;

    @FindBy(xpath = "//*[@id='repo-delete-proceed-button']/span/span")
    private WebElement confirmDeleteButton;   //wait clickable   //sel ?

    @Step("Visibility of 'Settings' page element")
    public Boolean settingsPageElementVisible() {
        try {
            return renameButton.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }



    @Step("Write down new repository name")
    public void renameRepo(String newRepo) {
        renameInput.click();
        renameInput.clear();
        renameInput.sendKeys(newRepo);
        //getCurrentUrl();
        renameButton.click();

        waitUntilAjaxRequestCompletes();
        //waitForUrlToChange(currentUrl);

    }





}
