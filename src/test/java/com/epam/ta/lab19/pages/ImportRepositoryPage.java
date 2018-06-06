package com.epam.ta.lab19.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 created by Anastasia Shintar
 */

public class ImportRepositoryPage extends AbstractPage {


    public ImportRepositoryPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }


    private final Logger logger = LogManager.getRootLogger();
    private final String BASE_URL = "https://github.com/new/import";
    private WebDriverWait wait = new WebDriverWait(driver, 5);


    @FindBy(name = "vcs_url")
    private WebElement repoUrl;

    @FindBy(name = "repository[name]")
    private WebElement newRepoName;

    @FindBy(xpath = "//*[@id=\"new_repository\"]/div[4]/button")
    private WebElement beginImportButton;


    public void openPage() {
        driver.navigate().to(BASE_URL);
        if ((!driver.getTitle().equals("Import a Repository")) || (!driver.getCurrentUrl().equals(BASE_URL))) {
            throw new IllegalStateException("Wrong site page!");
        }
        logger.info("Import page opened.");
    }

    public void importRepo(String repositoryUrl, String newRepositoryName) {
        repoUrl.sendKeys(repositoryUrl);
        newRepoName.sendKeys(newRepositoryName);
        wait.until(ExpectedConditions.elementToBeClickable(beginImportButton));
        beginImportButton.click();
        logger.info("Repository imported.");

    }


}
