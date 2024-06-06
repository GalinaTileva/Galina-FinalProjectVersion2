package org.project.tests.selenium;

import io.qameta.allure.*;
import org.openqa.selenium.WebElement;
import org.project.pages.*;
import org.project.pages.signup.Header;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class RepoPageTest extends SelenBaseTest {
    private Header header;
    private LoginPage loginPage;
    private MainPage mainPage;
    private RepoPage repoPage;
    private SettingsPage settingsPage;
    private GlobalBarHeader globalBarHeader;
    private AllReposPage allReposPage;

    @Epic("Repository Management")
    @Feature("Repository Title")
    @Story("Confirm repository title")
    @Severity(SeverityLevel.MINOR)
    @Description("Verifies repository title")
    @Test
    public void currentRepoName() {
        header = new Header();
        loginPage = header.clickSignInButton();
        mainPage = loginPage.openMainPage("BiraSKartofki", "GreenAlien88");
        repoPage = mainPage.openRepoPage("NaPlaja");

        globalBarHeader = new GlobalBarHeader();
        allReposPage = new AllReposPage();
        globalBarHeader.openAllRepos();

        WebElement repo = allReposPage.findRepoByName("NaPlaja");
        assertNotNull(repo, "Repository 'NaPlaja' is not in the list.");
    }

    @Epic("Repository Management")
    @Feature("Settings")
    @Story("Navigate to repository 'Settings' page")
    @Severity(SeverityLevel.NORMAL)
    @Description("Verifies functionality of navigating to 'Settings' page of a repository.")
    @Test
    public void goToSettingsPage() {
        header = new Header();
        loginPage = header.clickSignInButton();
        mainPage = loginPage.openMainPage("BiraSKartofki", "GreenAlien88");
        repoPage = mainPage.openRepoPage("NaPlaja");
        settingsPage = repoPage.openSettingsPage();

        assertTrue(settingsPage.settingsPageElementVisible(), "Settings page element is not displayed");
    }

}
