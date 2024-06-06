package org.project.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SettingsPage extends BasePage {

    @FindBy(css = "#repo-title-component > strong > a")
    private WebElement repoTitle;  //sel ?

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


}