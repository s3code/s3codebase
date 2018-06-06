package com.unibet.at.pages;

import org.apache.commons.io.filefilter.AgeFileFilter;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import common.SharedDriver;

public class Search extends SharedDriver {
	
	//@FindBy()
	
	
	// initializing pageObjects :
	public Search() {
		
		PageFactory.initElements(driver, this);
		
		
	}
	
	// Actions:
public void clickSearch() {
	initialization();
}
}
