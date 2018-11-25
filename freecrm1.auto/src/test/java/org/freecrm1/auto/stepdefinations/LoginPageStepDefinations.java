package org.freecrm1.auto.stepdefinations;

import org.freecrm1.auto.common.TestBase;
import org.freecrm1.auto.pages.homepage.HomePagePanel;
import org.freecrm1.auto.pages.loginpage.LoginPagePanel;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LoginPageStepDefinations extends TestBase{
	
	private LoginPagePanel loginPagePanel = new LoginPagePanel();
	private HomePagePanel homePagePanel = new HomePagePanel();
	
	
	
	@Given("^I am on home page of the application$")
	public void i_am_on_home_page_of_the_application() {
	    // Write code here that turns the phrase above into concrete actions
	loadUrl();
	}

	@And("^I enter the userid as (.+)$")
	public void i_enter_the_userid_as(String userid) {
	   // loginPagePanel.enterInToField(userid);
	    
	    System.out.println(" ****** user id =  "+userid);
	
	}

	@And("I enter the password as  (.+)")
	public void i_enter_the_password_as(String password) {
	   
		//loginPagePanel.enterInToField(password);
		
		System.out.println("******* password = " + password);
	
	}

	@When("I click on login button")
	public void i_click_on_login_button() {

	loginPagePanel.clickTheButton();
	}

	@Then("Login is successfull.")
	public void login_is_successfull() {
	  
		String username = homePagePanel.getUserName();
		
	}
	
	
	@After("@browser")
	public void tearDown(Scenario scenario) {
	    if (scenario.isFailed()) {
	            final byte[] screenshot = ((TakesScreenshot) driver)
	                        .getScreenshotAs(OutputType.BYTES);
	            scenario.embed(screenshot, "image/png"); //stick it in the report
	    }
	    driver.close();
	}

	

}
