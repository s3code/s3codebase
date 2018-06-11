package com.unibet.at.pages;

import org.apache.commons.io.filefilter.AgeFileFilter;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.unibet.at.utils.CoreTestUtils;

import common.SharedDriver;

public class SearchPanel extends SharedDriver {
	
	WebDriver driver;
	
	@FindBy(xpath = "//*[@id='social-content-hub']/div/div[1]/div/div/div[3]/div[1]/div/a")
	 WebElement search;
	
	@FindBy(xpath ="//*[@id='social-content-hub']/div/div[1]/div/div/div[3]/div[1]/div/a/div[2]/span/input")
	 WebElement searchInputField;
	
	@FindBy(id = "CybotCookiebotDialogBodyButtonAccept")
	 WebElement cookiesOkButton;
	
	public SearchPanel(WebDriver driver) {
				
		this.driver = driver;
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
}
