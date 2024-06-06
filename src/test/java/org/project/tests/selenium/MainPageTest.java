package org.project.tests.selenium;

import io.qameta.allure.*;
import org.project.pages.LoginPage;
import org.project.pages.MainPage;
import org.project.pages.RepoPage;
import org.project.pages.signup.Header;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class MainPageTest extends SelenBaseTest {
    private Header header;
    private LoginPage loginPage;
    private MainPage mainPage;
    private RepoPage repoPage;

    @Epic("Repository Management")
    @Feature("Create Repository")
    @Story("User is able to create a new repository")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Successful generating of new repository.")
    @Test
    public void createNewRepo() {
        header = new Header();
        loginPage = header.clickSignInButton();
        mainPage = loginPage.openMainPage("BiraSKartofki", "GreenAlien88");
        repoPage = mainPage.openRepoPage("NaPlaja");

        assertTrue(repoPage.repoPageElementVisible(), "Repo page element is not displayed");
    }

}
