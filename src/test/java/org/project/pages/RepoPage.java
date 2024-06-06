package org.project.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RepoPage extends BasePage {

    @FindBy(css = ".UnderlineNav-body")
    private WebElement navigationBar;

    @FindBy(css = "#code-tab")
    private WebElement codePageLink;

    @FindBy(css = "#issues-tab")
    private WebElement issuesPageLink;

    @FindBy(css = "#pull-requests-tab")
    private WebElement pullRequestsPageLink;

    @FindBy(css = "#actions-tab")
    private WebElement actionsPageLink;

    @FindBy(css = "#projects-tab")
    private WebElement projectsPageLink;

    @FindBy(css = "#security-tab")
    private WebElement securityPageLink;

    @FindBy(css = "#insights-tab")
    private WebElement insightsPageLink;

    @FindBy(css = "#settings-tab")
    private WebElement settingsPageLink;

    @Step("Visibility of 'Repo page' element")
    public Boolean repoPageElementVisible() {
        try {
            return navigationBar.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    @Step("Click 'Settings' button/link")
    public SettingsPage openSettingsPage() {
        waitForElementToBeClickable(settingsPageLink);
        settingsPageLink.click();
        return new SettingsPage();
    }

}
