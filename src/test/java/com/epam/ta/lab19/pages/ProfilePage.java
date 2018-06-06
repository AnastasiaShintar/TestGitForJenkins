package com.epam.ta.lab19.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.prefs.BackingStoreException;

/**
 created by Anastasia Shintar
 */

public class ProfilePage extends AbstractPage {


    public ProfilePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);    }


    private final Logger logger = LogManager.getRootLogger();
    private final String BASE_URL = "https://github.com/PermanentTestUserATLab19";


    @FindBy(partialLinkText = "Repositories")
    private WebElement repositoriesLink;


    public void openPage() {
        driver.navigate().to(BASE_URL);
        logger.info("Profile page opened.");
    }

    public void openRepositoriesList() {

        WebDriverWait wait = new WebDriverWait(driver, 3);
        wait.until(ExpectedConditions.visibilityOf(repositoriesLink));
        repositoriesLink.click();
        logger.info("Repositories list opened.");
    }
}
