package com.epam.ta.lab19.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.epam.ta.lab19.steps.Steps;

/**
 created by Anastasia Shintar
 The class GitHubAccountTest contains tests related to GitHub account (create, change, delete, etc.)
 */

public class GitHubAccountTest {

    private Steps steps;
    private TestsData testsData;

    @BeforeMethod(description = "Init browser")
    public void setUp() {
        steps = new Steps();
        steps.initBrowser();
    }

    @Test(description = "Create new account", priority = 1) // create new GitHub account
    public void createNewGitHubAccount() {
        steps.createNewAccount(testsData.NEW_USER_LOGIN, testsData.NEW_USER_EMAIL_ADDRESS, testsData.NEW_USER_PASSWORD);
        Assert.assertEquals(steps.getUserLogin(), testsData.NEW_USER_LOGIN);
    }

    @Test(description = "UploadProfilePicture", priority = 2) // Change of profile data
    public void uploadProfilePicture() {
        steps.loginGithub(testsData.NEW_USER_LOGIN, testsData.NEW_USER_PASSWORD);
        steps.enterProfileData();
        Assert.assertTrue(steps.getSuccessEnterProfileData().contains(testsData.UPDATE_PROFILE_SUCCESS_MESSAGE));	}


    @Test(description = "Delete an account", priority = 3) // Delete a GitHub account
    public void deleteGitHubAccount() {
        steps.loginGithub(testsData.NEW_USER_LOGIN, testsData.NEW_USER_PASSWORD);
        Assert.assertTrue(steps.deleteAccount(testsData.NEW_USER_LOGIN, testsData.DELETE_ACCOUNT_CONFIRMATION_PHRASE).contains(testsData.DELETE_ACCOUNT_SUCCESS_MESSAGE));
    }

    @AfterMethod(description = "Stop Browser")
    public void stopBrowser() {
        steps.closeDriver();
    }
}
