package com.unibet.at.utils;

import java.net.URL;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.net.ssl.HttpsURLConnection;

import org.openqa.selenium.By;
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
	
	public static long PAGE_LOAD_TIMEOUT = 120;
	
	public static long IMPLICT_WAIT = 10;
	
	public static long EXPLICIT_WAIT = 30;
	
	public static final long STANDARD_TIMEOUT = 60;
	public static  final long STANDARD_POOLING_TIME = 5;
	
	
	//public static final String UNIBET_APPLICATION_BASE_URL = prop.getProperty("blog");
	
	private CoreTestUtils coreTestUtils;
	
	private static WebDriverWait wait;

	
	private static Wait<WebDriver> fWait;
	
	public CoreTestUtils(WebDriver driver) {
		this.driver = driver;
		
		wait = new WebDriverWait(driver, EXPLICIT_WAIT);
		
		PageFactory.initElements(driver, this);
		
	}
/*
	public WebDriverWait explicitWait(WebDriver driver) {
		this.driver = driver;
		
		return wait = new WebDriverWait(driver, EXPLICIT_WAIT);
		
	}  */
	
	
	public List<WebElement> waituntilExpectedConditionsvisibilityOfAllElementsLocatedBy( String xpath ) { 
		
		return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(xpath)));
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

	public int verifyBrokenLinks(List<WebElement> listOfLinks) {
		
		int brokenLinks = 0;
		
		for (WebElement link : listOfLinks) {
			String url = link.getAttribute("href");
			
			
			try {
				URL urls = new URL(url);
				HttpsURLConnection httpconect = (HttpsURLConnection) urls.openConnection();
				httpconect.setConnectTimeout(3000);
				httpconect.connect();
      							  
				  if( httpconect.getResponseCode()== 200) 
				  { 
			  // Loggers can be used here to verify the strace.
			//System.out.println(url + " - "+ httpconect.getResponseCode());
				
					  } 
				   else {
					   // if the status code is not equal to 200 then counter will be incremented
					 //statusCounter++;
					brokenLinks++;
				   } 
			} catch (Exception e) {}
			
		}
		return brokenLinks;
	}
	
	
}
