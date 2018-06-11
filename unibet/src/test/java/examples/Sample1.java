package examples;

import java.awt.Robot;
import java.util.ArrayList;
import java.util.List;

import org.junit.rules.ExpectedException;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import junit.framework.Assert;

public class Sample1 {
	
	

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		WebDriver driver;

		System.setProperty("webdriver.chrome.driver",
				System.getProperty("user.dir") + "\\resources\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();

		WebDriverWait wait = new WebDriverWait(driver, 5);

		// System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") +
		// "\\resources\\geckodriver-v0.20.1-win64\\geckodriver.exe" );
		// driver = new FirefoxDriver();

		driver.manage().window().maximize();

		driver.get("https://www.unibet.co.uk/blog");

		// to accept the cookies tab
		driver.findElement(By.id("CybotCookiebotDialogBodyButtonAccept")).click();

		// Thread.sleep(3000);

		WebElement search = driver
				.findElement(By.xpath("//*[@id='social-content-hub']/div/div[1]/div/div/div[3]/div[1]/div/a"));

		search.click();

		driver.findElement(
				By.xpath("//*[@id='social-content-hub']/div/div[1]/div/div/div[3]/div[1]/div/a/div[2]/span/input"))
				.sendKeys("#World Cup");
		// enter on search box

		driver.findElement(
				By.xpath("//*[@id='social-content-hub']/div/div[1]/div/div/div[3]/div[1]/div/a/div[2]/span/input"))
				.sendKeys(Keys.ENTER);

		Thread.sleep(10000);
		List<WebElement> listOfBlogs = driver
				.findElements(By.xpath("//div[@class='Group__horizontal___33MBr Group__root___hnqau']"));

		System.out.println("The list of the no of blogs are :" + listOfBlogs.size());

		String newsHeaderPrt1 = "//*[@id=\"social-content-hub\"]/div/div[2]/div/div[2]/div/div[2]/a[";
		String newsHeaderPrt2 = "]/div/div/h1";

		
		// Pass the testdata from the feature file
		List<String> testString = new ArrayList();

		testString.add("Egypt World Cup Team Preview: Return of Salah is the be all and end all for Pharaoh");
		testString.add("England World Cup Team Guide: Assertive Southgate has made Three Lions a pacy force");
		testString.add(
				"Denmark World Cup Team Guide: Organisation and Christian Eriksen makes the Danes a threat in the group stage");
		testString.add("Costa Rica World Cup Team Guide: Los Ticos aren’t the scrappy, young underdogs any more");
		testString.add(
				"Colombia World Cup Team Guide: Los Cafeteros have the ingredients to match their historic performance in 2014");
		testString
				.add("Brazil World Cup Team Guide: The Seleção have restored confidence and brought back the swagger");
		testString.add("Mexico World Cup Team Guide: El Tri can overcome their curse and go beyond the round of 16");
		testString.add("Jogi Loew is making a mistake in choosing Neuer ahead of Ter Stegen at the World Cup");
		testString.add(
				"Argentina World Cup Team Guide: The Albiceleste are not in great shape, but anothing is possible with Lionel Messi");
		testString.add("Australia World Cup Team Guide: Simeone inspired Socceroos can make it out of the group");
		testString.add(
				"World Cup One To Watch: Berg Gudmundsson – Iceland’s assist king who provides their best route to goal");
		testString.add("That Was The World Cup That Was – Japan and South Korea 2002");
		testString.add("Arsene Wenger at the Bernabeu would be an appointment that has been a decade in the making)");
		
		int testSize = testString.size();
		for (int y = 0; y <= testSize - 1; y++) {

			String testData1 = testString.get(y);
			for (int i = 1; i <= listOfBlogs.size(); i++) {

				String testDataUi = wait
						.until(ExpectedConditions.elementToBeClickable(By.xpath(newsHeaderPrt1 + i + newsHeaderPrt2)))
						.getText();
				if (testData1.equals(testDataUi)) {
					
					System.out.println(" /" +testData1 + " equals to " + testDataUi + " /");
					break;
				}

			//			System.out.println(i);
	//		System.out.println(
		//			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(newsHeaderPrt1 + i + newsHeaderPrt2)))
			//				.getText());

		}

		// driver.quit();
	}
	
	}

}
