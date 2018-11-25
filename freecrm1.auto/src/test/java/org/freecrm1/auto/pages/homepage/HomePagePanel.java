package org.freecrm1.auto.pages.homepage;

import org.freecrm1.auto.common.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePagePanel extends TestBase {

	@FindBy(xpath = "//*[contains(text(),'User: Test user')]")
	private WebElement userText;
	
	@FindBy(xpath = "//img[contains(@src, 'freecrm')]")
	private WebElement freeCrmLogo;

	// private TestBase driver;
	public HomePagePanel() {
		initialisation();
		PageFactory.initElements(driver, this);
	}

	public void loadTheurl() {
		loadUrl();
	}

	public String getTitle() {

		return driver.getTitle();
	}

	public void exitDriver() {
		driver.close();
	}

	public String getUserName() {
		return userText.getText();
	}
	
	public Boolean isFreeCrmLogoDisplayed() {
		return freeCrmLogo.isDisplayed();
	}
	
}
