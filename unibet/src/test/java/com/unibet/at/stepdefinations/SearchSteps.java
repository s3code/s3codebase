package com.unibet.at.stepdefinations;
import com.unibet.at.pages.Search;

import common.SharedDriver;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;

public class SearchSteps extends SharedDriver{
	
	
	private Search search;
	
	public SearchSteps() {
		
		SharedDriver driver = new SharedDriver();
		search = new Search();
	}
	
	

	@Given("^I enter the url in browser$")
	public void i_enter_the_url_in_browser() {
		System.out.println("*******************I enter the url in browser****************************");
		initialization();
	}
	
	@And("^I enter the world cup$")
    public void i_enter_the_world_cup() {
		System.out.println("*********************i_enter_the_world_cup**********************");
    }
	
	@And("^I enter the world cup1$")
    public void i_enter_the_world_cup1() {
		System.out.println("********************************i_enter_the_world_cup************************");
    }
	
	@And("^I enter the world cup2$")
    public void i_enter_the_world_cup2() {
		System.out.println("********************************i_enter_the_world_cup************************");
    }
	
	
	
}
