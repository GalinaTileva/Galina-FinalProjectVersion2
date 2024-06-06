package org.project.tests.selenium.signup;

import io.qameta.allure.*;
import org.openqa.selenium.WebElement;
import org.project.pages.*;
import org.project.pages.signup.Header;
import org.project.tests.selenium.SelenBaseTest;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;

public class SettingsPageTest extends SelenBaseTest {
    private Header header;
    private LoginPage loginPage;
    private MainPage mainPage;
    private RepoPage repoPage;
    private SettingsPage settingsPage;
    private GlobalBarHeader globalBarHeader;
    private AllReposPage allReposPage;


    @Epic("Repository Management")
    @Feature("Rename Repository")
    @Story("Enter new repository name and submit")
    @Severity(SeverityLevel.NORMAL)
    @Description("Verifies setting of renaming repository")
    @Test
    public void renameRepo() {
        header = new Header();
        loginPage = header.clickSignInButton();
        mainPage = loginPage.openMainPage("BiraSKartofki", "GreenAlien88");
        repoPage = mainPage.openRepoPage("NaPlaja");
        settingsPage = repoPage.openSettingsPage();
        settingsPage.renameRepo("VsekiDen");

        globalBarHeader = new GlobalBarHeader();
        allReposPage = new AllReposPage();
        globalBarHeader.openAllRepos();


        WebElement repo = allReposPage.findRepoByName("VsekiDen");
        assertNotNull(repo, "Repository 'VsekiDen' is not in the list.");

    }

}
