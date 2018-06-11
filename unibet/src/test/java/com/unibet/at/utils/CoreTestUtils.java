package com.unibet.at.utils;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import common.SharedDriver;

public class CoreTestUtils extends SharedDriver{
	
	WebDriver driver;
	public static long PAGE_LOAD_TIMEOUT = 60;
	
	public static long IMPLICT_WAIT = 10;
	
	public static long EXPLICIT_WAIT = 20;
	
	public static final long STANDARD_TIMEOUT = 60;
	public static  final long STANDARD_POOLING_TIME = 5;
	
	
	//public static final String UNIBET_APPLICATION_BASE_URL = prop.getProperty("blog");
	
	private CoreTestUtils coreTestUtils;
	
	private static WebDriverWait wait;

	
	private static Wait<WebDriver> fWait;
	
	public CoreTestUtils(WebDriver driver) {
		this.driver = driver;
		
		PageFactory.initElements(driver, this);
		
	}

	public WebDriverWait explicitWait() {
		
		return wait = new WebDriverWait(driver, EXPLICIT_WAIT);
		
	}
	
	/*
	public Wait<WebDriver> getFWait(WebDriver driver){
		
		if(fWait == null) { 
			fWait = new FluentWait<WebDriver>(driver)
			       .withTimeout(60, TimeUnit.SECONDS)
				.pollingEvery(5, TimeUnit.SECONDS)
				.ignoring(NoSuchElementException.class);
		}
		return fWait;
				
	}
	
	*/

	
	
	
	

}
