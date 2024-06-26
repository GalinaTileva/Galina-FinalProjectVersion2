package org.project.tests.selenium.signup;

import com.opencsv.exceptions.CsvException;
import io.qameta.allure.*;
import org.project.pages.signup.Header;
import org.project.pages.signup.SignUpPage;
import org.project.pages.signup.VerifPage;
import org.project.tests.selenium.SelenBaseTest;
import org.project.utils.CsvReader;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;

import static org.testng.Assert.assertTrue;

public class SignUpTestSuccess extends SelenBaseTest {
    private Header header;
    private SignUpPage signUpPage;
    private VerifPage verifPage;

    @DataProvider(name = "positive-login-data")
    public static Object[][] positiveLoginDataCsv() throws IOException, CsvException {
        return CsvReader.readCsvFile("src/test/resources/csv/positivelogin/positive-login-data.csv");
    }

    @Epic("User Preferences Management")
    @Feature("Login Preferences")
    @Story("Preferences Checkbox Selection")
    @Severity(SeverityLevel.NORMAL)
    @Description("Verify checkbox is selected.")
    @Test(dataProvider = "positive-login-data")
    public void checkboxSelected(String email, String password, String username) {
        header = new Header();
        signUpPage = header.clickSignUpButton();
        signUpPage.setValidEmail(email);
        signUpPage.setValidPassword(password);
        signUpPage.setValidUsername(username);

        assertTrue(signUpPage.checkCheckbox(), "Checkbox is not selected");
    }

    @Epic("User Management")
    @Feature("User Registration")
    @Story("User can register successfully and use the application.")
    @Severity(SeverityLevel.CRITICAL)
    @Description("New user can successfully sign up for an account.")
    @Test(dataProvider = "positive-login-data")
    public void positiveLogin(String email, String password, String username) throws InterruptedException {
        header = new Header();
        signUpPage = header.clickSignUpButton();
        verifPage = signUpPage.openVerifPage(email, password, username);

        assertTrue(verifPage.verifyPageElementDisplayed(), "Verify page element is not displayed");
    }
}
