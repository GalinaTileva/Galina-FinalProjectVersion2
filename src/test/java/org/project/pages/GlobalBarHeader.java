package org.project.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GlobalBarHeader extends BasePage {

    @FindBy(css = "[aria-label='Open user account menu']")
    private WebElement avatarMenu;

    @FindBy(xpath = "//span[contains(text(),'Your repositories')]")
    private WebElement yourReposLink;


    @Step("Open 'All repositories' page")
    public void openAllRepos() {
        avatarMenu.click();
        yourReposLink.click();
    }


}
