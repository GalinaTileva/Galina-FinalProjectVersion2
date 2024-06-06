package org.project.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RepoPage extends BasePage {

    @FindBy(css = ".UnderlineNav-body")
    private WebElement navigationBar;

    @FindBy(css = "#code-tab")
    private WebElement codeLink;

    @FindBy(css = "#issues-tab")
    private WebElement issuesLink;

    @FindBy(css = "#pull-requests-tab")
    private WebElement pullRequestsLink;

    @FindBy(css = "#actions-tab")
    private WebElement actionsLink;

    @FindBy(css = "#projects-tab")
    private WebElement projectsLink;

    @FindBy(css = "#security-tab")
    private WebElement securityLink;

    @FindBy(css = "#insights-tab")
    private WebElement insightsLink;

    @FindBy(css = "settings-tab")
    private WebElement settingsLink;


}
