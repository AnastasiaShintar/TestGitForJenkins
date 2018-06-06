package com.epam.ta.lab19.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.epam.ta.lab19.steps.Steps;

/**
 * created by Anastasia Shintar
 *
 * The class GitHubCommonFunctionalTest contains tests related to GitHub functionality
 * excluding account and repositories activity (create, import, change, delete, etc.)
 */

public class GitHubCommonFunctionalTest {

    private Steps steps;
    private TestsData testsData;

    @BeforeMethod(description = "Init browser")
    public void setUp() {
        steps = new Steps();
        steps.initBrowser();
    }

    @Test(description = "Check a search line", priority = 5) 
    public void checkSearchLine() {
        steps.loginGithub(testsData.USER_LOGIN, testsData.USER_PASSWORD);
        Assert.assertEquals(steps.searchGitHub(testsData.INPUT_DATA), "Search · " + testsData.INPUT_DATA);
    }

    @AfterMethod(description = "Stop Browser")
    public void stopBrowser() {
        steps.closeDriver();
    }


}
