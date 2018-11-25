package org.freecrm1.auto.stepdefinations;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.poi.hssf.record.ScenarioProtectRecord;
import org.freecrm1.auto.common.TestBase;
import org.freecrm1.auto.pages.homepage.HomePagePanel;
import org.junit.Assert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;


public class HomePageStepDefination extends TestBase{
	private HomePagePanel homePagePanel;
	
	
	public HomePageStepDefination() {
		homePagePanel = new HomePagePanel();
	}

	@Given("^You are on Home Page$")
	public void you_are_on_Home_Page() {

		homePagePanel.loadTheurl();

	}

	@Then("^You verify the title is '(.+)'$")
	public void you_verify_the_title_is(String string) {

		String title = homePagePanel.getTitle();
	
		Assert.assertEquals(string, title);
	}
	
	@Then("^User verify the FreeCrm logo$")
	public void User_verify_the_FreeCrm_logo() {
		Assert.assertTrue(homePagePanel.isFreeCrmLogoDisplayed());
	}

	@After()
	public void closeTheBrowser(Scenario scenario) {
		
		if(scenario.isFailed()) {
		TakesScreenshot scrShot =((TakesScreenshot)driver);
		File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
		File DestFile=new File("C:\\Users\\somen\\eclipse-workspace\\freecrm1.auto\\target\\test.png");
		
		try {
			FileUtils.copyFile(SrcFile, DestFile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
		driver.close();
	}

}
