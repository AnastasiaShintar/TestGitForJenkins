package com.epam.ta.lab19.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 created by Anastasia Shintar
 */

public class LoginPage extends AbstractPage {

	public LoginPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(this.driver, this);
	}

	private final Logger logger = LogManager.getRootLogger();
	private final String BASE_URL = "https://github.com/login";

	@FindBy(xpath = "//*[@id=\"login\"]/p/a")
	private WebElement createNewAccountLink;

	@FindBy(id = "user_login")
	private WebElement inputUserLogin;

	@FindBy(id = "user_email")
	private WebElement inputUserEmail;

	@FindBy(id = "user_password")
	private WebElement inputUserPassword;

	@FindBy(xpath = "//*[@id=\"signup_button\"]")
	private WebElement createAnAccountButton;

	@FindBy(xpath = "//*[@id=\"js-pjax-container\"]/div/div[2]/div/form/div[3]/button")
	private WebElement step2ContinueButton;

	@FindBy(name = "answers[98][choice]")
	private WebElement step3SomewhatExperiencedRadioButton;

	@FindBy(name = "answers[99][choices][]")
	private WebElement step3ResearchCheckbox;

	@FindBy(name = "answers[100][choice]")
	private WebElement step3StudentRadioButton;

	@FindBy(name = "commit")
	private WebElement step3SubmitButton;

	@FindBy(id = "login_field")
	private WebElement inputLogin;

	@FindBy(id = "password")
	private WebElement inputPassword;

	@FindBy(xpath = "//input[@value='Sign in']")
	private WebElement buttonSubmit;


	@Override
	public void openPage() {
		driver.navigate().to(BASE_URL);
		if ((!driver.getTitle().equals("Sign in to GitHub · GitHub")) || (!driver.getCurrentUrl().equals(BASE_URL))) {
			throw new IllegalStateException("Wrong site page!");
		}
		logger.info("Login page opened.");
	}

	public void createNewAccount(String userLogin, String emailAddress, String userPassword) {
		createNewAccountLink.click();
		inputUserLogin.sendKeys(userLogin);
		inputUserEmail.sendKeys(emailAddress);
		inputUserPassword.sendKeys(userPassword);
		createAnAccountButton.click();
		step2ContinueButton.click();
		step3SomewhatExperiencedRadioButton.click();
		step3ResearchCheckbox.click();
		step3StudentRadioButton.click();
		step3SubmitButton.click();
		logger.info("New account created.");
	}


	public void login(String username, String password) {
		inputLogin.sendKeys(username);
		inputPassword.sendKeys(password);
		buttonSubmit.click();
		logger.info("Login performed.");
	}

}