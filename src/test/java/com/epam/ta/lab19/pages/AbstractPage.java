package com.epam.ta.lab19.pages;

import org.openqa.selenium.WebDriver;

/**
 created by Anastasia Shintar
  */

public abstract class AbstractPage
{
	protected WebDriver driver;

	public abstract void openPage();

	public AbstractPage(WebDriver driver)
	{
		this.driver = driver;
	}
}
