package extras;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

public class Myclasses {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
//		System.setProperty("webdriver.chrome.driver", "C:\\Users\\somen\\eclipse-workspace\\freecrm1.auto\\helpers\\chromedriver_win32\\chromedriver.exe");
//		WebDriver driver = new ChromeDriver();
		
		/*System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir") + "/helpers/geckodriver-v0.20.1-win64/geckodriver.exe");
		
		WebDriver driver = new FirefoxDriver();
		
		driver.get("https://www.google.com");
		
		TakesScreenshot scrShot =((TakesScreenshot)driver);
		File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
		File DestFile=new File("C:\\Users\\somen\\Desktop\\screeshot\\test.png");
		
		FileUtils.copyFile(SrcFile, DestFile);
	
		driver.close();*/

	}

}
