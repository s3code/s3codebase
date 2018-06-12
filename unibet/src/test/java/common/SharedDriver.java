package common;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.events.WebDriverEventListener;

import com.unibet.at.listeners.WebEventListener;
import com.unibet.at.utils.CoreTestUtils;

public class SharedDriver {

public static WebDriver driver;
public static EventFiringWebDriver eventDriver;
public static WebEventListener webListener;
	
	public static Properties prop;

	//public static String baseURL = null;
	

	public SharedDriver() {
		
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream(System.getProperty("user.dir")
					+ "\\src\\test\\java\\com\\unibet\\at\\properties\\config.properties");
			prop.load(ip);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	

	public static WebDriver initialization() {
				
		String browserName = prop.getProperty("browser");

		if (browserName.equals("ie")) {

			System.setProperty("webdriver.ie.driver",
					System.getProperty("user.dir") + "\\src\\drivers\\IEDriverServer_x64_3.12.0\\IEDriverServer.exe");

			DesiredCapabilities caps = DesiredCapabilities.internetExplorer();
			caps.setCapability(InternetExplorerDriver.IGNORE_ZOOM_SETTING, true);
			caps.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);

			InternetExplorerOptions options = new InternetExplorerOptions(caps);

			driver = new InternetExplorerDriver(options);
			

		} else if (browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver",
					System.getProperty("user.dir") + "\\resources\\chromedriver_win32\\chromedriver.exe");
			driver = new ChromeDriver();
			
			

		} else if (browserName.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver",
					System.getProperty("user.dir") + "\\resources\\geckodriver-v0.20.1-win64\\geckodriver.exe");
			driver = new FirefoxDriver();
		}

		eventDriver = new EventFiringWebDriver(driver); 
		webListener = new WebEventListener(); 
		
		eventDriver.register(webListener);
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(CoreTestUtils.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(CoreTestUtils.IMPLICT_WAIT, TimeUnit.SECONDS);

	    //driver.get(prop.getProperty("blog"));
		
		
		
		
     return driver;

		
	}

	/*
	public String loadBrowser() {

		return baseURL = System.getProperty("baseURL");
	} */
	
	public WebDriver getDriver() {
		return driver;
	}
	
	

	public void exitDriver() {
		driver.quit();
	}

	
}
