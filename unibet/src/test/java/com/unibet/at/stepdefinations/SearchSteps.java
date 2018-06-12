package com.unibet.at.stepdefinations;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.unibet.at.pages.BlogPanel;
import com.unibet.at.pages.SearchPanel;
import com.unibet.at.utils.CoreTestUtils;

import common.SharedDriver;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class SearchSteps extends SharedDriver {

	public WebDriver Driver;

	private SearchPanel search;

	private CoreTestUtils coreTestUtils;
	private BlogPanel blog;
	
	

	public SearchSteps(/* WebDriver driver */) {

		// this.driver = driver;

		// search = new SearchPanel(driver);
		// coreTestUtils = new CoreTestUtils(driver);
		// blog = new BlogPanel(driver);

	}

	private void load() {
		search = new SearchPanel(driver);
		coreTestUtils = new CoreTestUtils(driver);
		blog = new BlogPanel(driver);
	}

	@Given("^I open the 'browser'$")
	public void openTheBrowser() {
		initialization();
		load();

	}

	@And("^I enter the blog url$")
	public void i_enter_the_blog_url() {
		// blog = new BlogPanel(driver);
		blog.loadBlogUrl();
		blog.acceptTheCookies();

	}

	@And("^I click on the left side 'Floating Dock'$")
	public void i_click_on_the_left_side_floatingDock() {

		search.clickOnSearch();

	}

	@And("I enter '(.+)' in the search field$")
	public void i_enter_the_world_cup1(String searchItem) {

		search.enterSearchItem(searchItem);
	}

	@And("^I press 'Enter' key$")
	public void i_press_enter_key() {

		search.enterPostSearchItem();

	}

	@Then("^'(.+)' gets loaded$")
	public void search_page_gets_loaded(String str) {

		assertEquals(str, search.pageIsLoaded());
		
	
	}

	@Then("^User is able to search the content$")
	public void user_is_able_to_search_the_conotent() {
		System.out.println("calling this method");
	}
	
	@Then("^User verifies that '(.+)' message displays as a result$")
	public void user_verifies_that_No_search_results_message_displays_as_a_result(String messageExpected) {
		
		System.out.println("Message sent from feature file " + messageExpected);
		//search.verifyTheMessage();
		
		assertEquals(messageExpected, search.verifyTheMessage());
	  	    
	}
	
	@Then("^User verifies that links present in the search result are working links$")
	public void user_verifies_that_links_present_in_the_search_result_are_working_links(){
	    
	assertEquals(0, search.getListOfLinks());
	    
	}
	
	
	
	@After
	public void executePostEachScenario(Scenario scenario) {
		
		if(scenario.isFailed()) {
			scenario.embed(((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES), "image/png" );
			scenario.write("Scenario Failed");
		 } else {
			 scenario.write("Scenario Passed");
		 }
		
		
		driver.close();
		driver.quit();
		//exitDriver();
	}
}
