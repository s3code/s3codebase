package com.unibet.at.stepdefinations;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.unibet.at.pages.BlogPanel;
import com.unibet.at.pages.SearchPanel;
import com.unibet.at.utils.CoreTestUtils;

import common.SharedDriver;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import junit.framework.Assert;

public class SearchSteps extends SharedDriver {
	
	public WebDriver Driver;

	private SearchPanel search;

	private CoreTestUtils coreTestUtils;
	private BlogPanel blog;

	public SearchSteps(/*WebDriver driver */) {
       	
	//this.driver = driver;
		
//		search = new SearchPanel(driver);
//		coreTestUtils = new CoreTestUtils(driver);
//		blog = new BlogPanel(driver);
		
	}
	
	private  void load() {
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
		//blog = new BlogPanel(driver);
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

	@And("^I press enter key$")
	public void i_press_enter_keys() {
		
		search.enterPostSearchItem();
		
		
	}
	
	@Given("^Page is loaded$")
	public void pageisloaded() {
		
		assertEquals("Unibet Blog1", search.pageIsLoaded());
	}

}
