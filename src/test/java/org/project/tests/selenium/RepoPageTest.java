package org.project.tests.selenium;

import io.qameta.allure.*;
import org.project.pages.LoginPage;
import org.project.pages.MainPage;
import org.project.pages.RepoPage;
import org.project.pages.SettingsPage;
import org.project.pages.signup.Header;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class RepoPageTest extends SelenBaseTest {
    private Header header;
    private LoginPage loginPage;
    private MainPage mainPage;
    private RepoPage repoPage;
    private SettingsPage settingsPage;

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
