package com.epam.ta.lab19.steps;

import com.epam.ta.lab19.pages.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.epam.ta.lab19.driver.DriverSingleton;


public class Steps {

    private WebDriver driver;

    public void initBrowser() {
        driver = DriverSingleton.getDriver();
    }

    public void createNewAccount(String userLogin, String emailAddress, String userPassword) {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.openPage();
        loginPage.createNewAccount(userLogin, emailAddress, userPassword);

    }

    public String getUserLogin() {
        MainPage mainPage = new MainPage(driver);
        mainPage.openPage();
        String userLogin = mainPage.getAccountName();
        return userLogin;
    }

    public void loginGithub(String username, String password) {
        LoginPage loginPage = new LoginPage(driver);
		loginPage.openPage();
        loginPage.login(username, password);
    }

    public void enterProfileData() {
        PublicProfilePage publicProfilePage = new PublicProfilePage(driver);
        publicProfilePage.openPage();
        publicProfilePage.setProfilePicture();
    }

    public void openProfilePage() {

    }

    public String getSuccessEnterProfileData() {
        PublicProfilePage publicProfilePage = new PublicProfilePage(driver);
        String message = publicProfilePage.getSuccessMessage();
        return message;
    }

    public String searchGitHub(String inputData) {
        MainPage mainPage = new MainPage(driver);
        mainPage.enterDataIntoSearchLine(inputData);
        String title = driver.getTitle();
        return title;
    }

    public void closeDriver() {
        DriverSingleton.closeDriver();
    }

    public String deleteAccount(String userName, String confirmationPhrase) {
        AccountPage accountPage = new AccountPage(driver);
        accountPage.openPage();
        accountPage.deleteAccount(userName, confirmationPhrase);
        String message = driver.findElement(By.tagName("body")).getText();
        return message;
    }

    public void importRepository (String repositoryURL, String newRepositoryName){
        ImportRepositoryPage importRepositoryPage = new ImportRepositoryPage(driver);
        importRepositoryPage.openPage();
        importRepositoryPage.importRepo(repositoryURL, newRepositoryName);
    }

    public String checkImportedRepository(String importedRepositoryName){
        ProfilePage profilePage = new ProfilePage(driver);
        profilePage.openPage();
        profilePage.openRepositoriesList();

        String repoName = driver.findElement(By.partialLinkText(importedRepositoryName)).getText();
        return repoName;
    }

}
