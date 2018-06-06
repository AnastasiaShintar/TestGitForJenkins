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

public class PublicProfilePage extends AbstractPage {

    private final Logger logger = LogManager.getRootLogger();
    private final String BASE_URL = "https://github.com/settings/profile";

    private final String PROFILE_PICTURE_PATH = "C:\\Users\\Anastasia_Shintar\\IdeaProjects\\GitHubAutomation\\src\\test\\resources\\profile_picture.jpg";// необходимо указать полный путь к файлу.Если
    // путь и название файла иное - исправьте.



    @FindBy(name = "user[profile_name]")
    private WebElement userName;

    @FindBy(name = "user[profile_bio]")
    private WebElement profileBio;

    @FindBy(name = "user[profile_company]")
    private WebElement profileCompany;

    @FindBy(id = "upload-profile-picture")
    private WebElement uploadProfilePictureButton;

    @FindBy(name = "user[profile_location]")
    private WebElement profileLocation;

    @FindBy(xpath = "//*[@id=\"js-pjax-container\"]/div/div[2]/form/div/p/button")
    private WebElement updateProfileButton;

    @FindBy(name = "op")
    private WebElement setNewProfilePictureButton;

    @FindBy(tagName = "body")
    private WebElement pageBody;


    public PublicProfilePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);   }


    public void setProfilePicture() {
        uploadProfilePictureButton.sendKeys(PROFILE_PICTURE_PATH);
        WebDriverWait wait = new WebDriverWait(driver, 3);
        wait.until(ExpectedConditions.visibilityOf(this.setNewProfilePictureButton));
        setNewProfilePictureButton.click();
        updateProfileButton.click();
        logger.info("Profile picture updated.");
    }

    public String getSuccessMessage() {
        String successMessage = pageBody.getText();
        return successMessage;
    }

    @Override
    public void openPage() {
        driver.navigate().to(BASE_URL);
        if ((!driver.getTitle().equals("Your Profile")) || (!driver.getCurrentUrl().equals(BASE_URL))) {
            throw new IllegalStateException("Wrong site page!");
        }
        logger.info("Public profile page opened");
    }

}
