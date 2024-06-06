package org.project.tests.selenium.signup;

import io.qameta.allure.*;
import org.project.pages.LoginPage;
import org.project.pages.signup.Header;
import org.project.pages.signup.SignUpPage;
import org.project.tests.selenium.SelenBaseTest;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertTrue;

public class HeaderTest extends SelenBaseTest {
    private Header header;
    private SignUpPage signUpPage;
    private LoginPage loginPage;

    @Epic("User Management")
    @Feature("User Navigation")
    @Story("Navigation from home to sign up page for new registration.")
    @Severity(SeverityLevel.NORMAL)
    @Description("User can navigate from home to sign up page and is redirected to sign up form.")
    @Test
    public void goToSignUpPage(){
        header = new Header();
        signUpPage = header.clickSignUpButton();

        assertTrue("Sign up container is not visible on the sign up page", signUpPage.signUpElementVisible());
    }

    @Epic("User Management")
    @Feature("User Navigation")
    @Story("Navigation from home to login page.")
    @Severity(SeverityLevel.NORMAL)
    @Description("User can navigate from home to login page and is redirected to login form.")
    @Test
    public void goToLoginPage() {
        header = new Header();
        loginPage = header.clickSignInButton();

        assertTrue("Login username field is not visible on login page.", loginPage.loginElementVisible());
    }
}