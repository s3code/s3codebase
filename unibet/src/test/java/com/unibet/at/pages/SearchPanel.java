package com.unibet.at.pages;

import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.unibet.at.utils.CoreTestUtils;

import common.SharedDriver;

public class SearchPanel extends SharedDriver {

	WebDriver driver;

	CoreTestUtils coreTestUtils;

	String listOfBlogsXpath = "//*[@id='social-content-hub']/div/div[2]/div/div[2]/div/div[2]/a";

	@FindBy(xpath = "//*[@id='social-content-hub']/div/div[1]/div/div/div[3]/div[1]/div/a")
	WebElement search;

	@FindBy(xpath = "//*[@id='social-content-hub']/div/div[1]/div/div/div[3]/div[1]/div/a/div[2]/span/input")
	WebElement searchInputField;

	@FindBy(id = "CybotCookiebotDialogBodyButtonAccept")
	WebElement cookiesOkButton;

	@FindBy(xpath = "//*[@id='social-content-hub']/div/div[2]/div/div[2]/div/div[2]/h1")
	WebElement noSearchResult;

	// @FindAll({ @FindBy(xpath =
	// "//*[@id='social-content-hub']/div/div[2]/div/div[2]/div/div[2]/a") })
	// WebElement listofLinks;

	public SearchPanel(WebDriver driver) {

		this.driver = driver;
		coreTestUtils = new CoreTestUtils(driver);
		PageFactory.initElements(driver, this);

	}

	// Actions:

	public void clickOnSearch() {
		search.click();

	}

	public void enterSearchItem(String searchItem) {

		searchInputField.sendKeys(searchItem);

	}

	public void enterPostSearchItem() {
		searchInputField.sendKeys(Keys.ENTER);

	}

	public String pageIsLoaded() {

		String title = driver.getTitle();
		return title;
	}

	public String verifyTheMessage() {

		return noSearchResult.getText();

	}

	public int getListOfLinks() {

		int statusCounter = 0;

		List<WebElement> listOfBlogs = coreTestUtils
				.waituntilExpectedConditionsvisibilityOfAllElementsLocatedBy(listOfBlogsXpath);

		statusCounter = coreTestUtils.verifyBrokenLinks(listOfBlogs);

		return statusCounter;

	}

}
