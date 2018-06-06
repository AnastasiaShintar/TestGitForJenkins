package com.epam.ta.lab19.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.epam.ta.lab19.steps.Steps;

/**
 created by Anastasia Shintar
 The class GitHubRepositoryTest contains tests related to GitHub repositories (create, import, change, delete, etc.)
 */

public class GitHubRepositoryTest {

	private Steps steps;
	private TestsData testsData;

	@BeforeMethod(description = "Init browser")
	public void setUp() {
		steps = new Steps();
		steps.initBrowser();
	}

	@Test(description = "Import repository", priority = 4) //Import repository

	public void importRepository(){
		steps.loginGithub(testsData.USER_LOGIN, testsData.USER_PASSWORD);
		steps.importRepository(testsData.REPOSITORY_URL, testsData.NEW_REPOSITORY_NAME);
		Assert.assertTrue(steps.checkImportedRepository(testsData.NEW_REPOSITORY_NAME).contains(testsData.NEW_REPOSITORY_NAME));
	}

	@AfterMethod(description = "Stop Browser")
	public void stopBrowser() {
		steps.closeDriver();
	}
}
