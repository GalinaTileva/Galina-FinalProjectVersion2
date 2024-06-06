package org.project.tests.selenium;

import com.opencsv.exceptions.CsvException;
import io.qameta.allure.*;
import org.project.pages.LoginPage;
import org.project.pages.MainPage;
import org.project.pages.signup.Header;
import org.project.utils.CsvReader;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;

import static org.testng.Assert.assertTrue;

public class LoginTest extends SelenBaseTest {
    private Header header;
    private LoginPage loginPage;
    private MainPage mainPage;

    @DataProvider(name = "actual-login-data")
    public static Object[][] actualLoginDataCsv() throws IOException, CsvException {
        return CsvReader.readCsvFile("src/test/resources/csv/actuallogin/actual-login-data.csv");
    }

    @Epic("User Management")
    @Feature("User Login")
    @Story("User can log in successfully and use the application.")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Existing user can successfully log in the system.")
    @Test(dataProvider = "actual-login-data")
    public void login(String username, String password) {
        header = new Header();
        loginPage = header.clickSignInButton();
        mainPage = loginPage.goToMainPage(username, password);

        assertTrue(mainPage.mainPageElementVisible(), "Main page element is not displayed");
    }
    
}
