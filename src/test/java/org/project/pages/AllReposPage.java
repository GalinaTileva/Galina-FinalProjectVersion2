package org.project.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class AllReposPage extends BasePage {

    @FindBy(css = "[itemprop='name codeRepository']")
    private List<WebElement> repositories;



    public List<WebElement> getRepositories() {

        return repositories;
    }

    public WebElement findRepoByName(String repoName){
        WebElement repo = null;
        for (WebElement repository : repositories) {
            if (repository.getText().equals(repoName))
                repo = repository;
        }
        return repo;
    }



}
