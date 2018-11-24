package managers;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import enums.DriverType;
import enums.EnvironmentType;
import managers.FileReaderManager;

public class WebDriverManager {
	private WebDriver driver;
	//private static DriverType driverType;
	String driverType;
	//private static EnvironmentType environmentType;
	String envType;
	public WebDriverManager(){
		driverType = FileReaderManager.getInstance().getPropReader().data("browser");
		envType = FileReaderManager.getInstance().getPropReader().data("environment");
		
	}
	
	public WebDriver getDriver(){
		if(driver == null){
			driver = createDriver();
		}
		driver.manage().deleteAllCookies();
		return driver;	
		
	} 
	public WebDriver createDriver(){
		switch(envType){
		case "local":
			driver = createLocalDriver();
			break;
		
		}
		return driver;
	}
	
	public WebDriver createLocalDriver(){
		
		switch (driverType){
		case "chrome":	
		ChromeOptions co = new ChromeOptions();
			co.addArguments("disable-infobars");
			System.setProperty("webdriver.chrome.driver", "Drivers//chromedriver.exe" );
			//ChromeDriver extends RemoteWebDriver which in turn implements WebDriver, 
			//so ChromeDriver is WebDriver 
			//WebDriver's methods will be exposed, but implem will be CD
			driver = new ChromeDriver(co);
			driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
			//driver.manage().timeouts().pageLoadTimeout(100, TimeUnit.SECONDS);
			
			break;
		case "firefox":
			System.setProperty("webdriver.gecko.driver", "Drivers//geckodriver.exe");
			//DesiredCapabilities dc = DesiredCapabilities.firefox();
			//dc.setCapability("marionette", true);
			driver = new FirefoxDriver();
			//driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
			break;
		case "ie":	
			System.setProperty("webdriver.ie.driver", "Drivers//IEDriverServer.exe");
			DesiredCapabilities dc1 = DesiredCapabilities.internetExplorer();
			dc1.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
			driver = new InternetExplorerDriver();
			//driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
			break;
		case "edge":	
			System.setProperty("webdriver.edge.driver", "Drivers//MicrosoftWebDriver.exe");
			driver = new EdgeDriver();
			//driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
			break;
		}	
		return driver;
	
	}
	
	public void closeDriver(){
		driver.close();
		driver.quit();
	}
	
	
	
	
}
