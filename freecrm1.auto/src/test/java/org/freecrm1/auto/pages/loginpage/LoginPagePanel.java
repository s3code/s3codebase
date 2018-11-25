package org.freecrm1.auto.pages.loginpage;

import org.freecrm1.auto.common.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPagePanel extends TestBase{
	
	@FindBy(name = "username")
	private WebElement username;
	
	@FindBy(name = "password")
	private WebElement password;
	
	@FindBy(xpath = "//input[@type='submit']")
	private WebElement loginButton;

	public LoginPagePanel() {
		
		PageFactory.initElements(driver, this);
	}
	
	public void enterInToField(String input) {
		username.sendKeys(input);
	}
	
	public void clickTheButton() {
		
		loginButton.click();
	}
	
}
