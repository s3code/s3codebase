package com.unibet.at.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.unibet.at.utils.CoreTestUtils;

import common.SharedDriver;

public class BlogPanel extends SharedDriver {

	WebDriver driver;

	private String blogURL = prop.getProperty("blog");

	@FindBy(id = "CybotCookiebotDialogBodyButtonAccept")
	WebElement cookiesOkButton;

	@FindBy(xpath = "//*[@id='nav-main']/nav/ul[1]/li[6]/a")
	WebElement pokerClick;

	public BlogPanel(WebDriver driver) {

		this.driver = driver;

		PageFactory.initElements(driver, this);

	}

	public void loadBlogUrl() {

		driver.get(blogURL);

	}

	public void acceptTheCookies() {
		
		if(cookiesOkButton.isDisplayed()) {
		cookiesOkButton.click();
		}
	}

}
