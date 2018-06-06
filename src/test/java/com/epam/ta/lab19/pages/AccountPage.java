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
 * created by Anastasia Shintar
 */


public class AccountPage extends AbstractPage {

    private final Logger logger = LogManager.getRootLogger();
    private final String BASE_URL = "https://github.com/settings/admin";

    public AccountPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }


    @FindBy(xpath = "//*[@id=\"js-pjax-container\"]/div/div[2]/details/summary")
    private WebElement deleteYourAccountButton;

    @FindBy(name = "sudo_login")
    private WebElement userName;

    @FindBy(name = "confirmation_phrase")
    private WebElement confirmationPhrase;

    @FindBy(xpath = "//*[@id=\"js-pjax-container\"]/div/div[2]/details/details-dialog/div[3]/form/button")
    private WebElement cancelPlanAndDeleteThisAccountButton;


    @Override
    public void openPage() {
        driver.navigate().to(BASE_URL);
        if ((!driver.getTitle().equals("Account settings")) || (!driver.getCurrentUrl().equals(BASE_URL))) {
            throw new IllegalStateException("Wrong site page!");
        }
        logger.info("Account settings page opened.");
    }

    public void deleteAccount(String userName, String confirmationPhrase) {
        deleteYourAccountButton.click();
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOf(this.userName));
        this.userName.sendKeys(userName);
        this.confirmationPhrase.sendKeys(confirmationPhrase);
        cancelPlanAndDeleteThisAccountButton.click();
        logger.info("Account deleted.");
    }

}