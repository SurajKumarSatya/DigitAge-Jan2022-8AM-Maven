package appUtilities;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import gUtilities.ReadProperties;

public class DriverSetUp 
{
	ReadProperties config;
	WebDriver driver;
	
	
	public DriverSetUp()
	{
		config = new ReadProperties("TestData/Config.properties");
	}
	
	public WebDriver getDriver()
	{
		if(config.readData("ExecutionType").equalsIgnoreCase("LOCAL"))
		{
			driver = getLocalDriver();
		}
		
		else if(config.readData("ExecutionType").equalsIgnoreCase("REMOTE"))
		{
			getRemoteDriver();
		}
		
		else 
		{
			System.out.println("Given Execution is not supported, :" + config.readData("ExecutionType").toUpperCase());
		}
		driver.manage().window().maximize();
		return driver;
	}
	
	URL url;
	public WebDriver getRemoteDriver()
	{
		try{
			url = new URL(config.readData("SaucelabsURL"));
		}catch (MalformedURLException e){
			e.printStackTrace();
		}
		
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("name", config.readData("ApplicationName"));
		capabilities.setCapability(CapabilityType.BROWSER_NAME, config.readData("Browser"));
		capabilities.setCapability(CapabilityType.VERSION, config.readData("BrowserVersion"));
		capabilities.setCapability(CapabilityType.PLATFORM, config.readData("OS"));
		capabilities.setCapability("screen-resolution", config.readData("ScreenResolution"));
		capabilities.setCapability("username", config.readData("SauceLabsUserName"));
		capabilities.setCapability("accessKey", config.readData("SauceLabsAccessKey"));	
		driver = new RemoteWebDriver(url,capabilities);
		return driver;
	}
	
	
	public WebDriver getLocalDriver()
	{
		if(config.readData("Browser").equalsIgnoreCase("CHROME"))
		{
			System.setProperty("webdriver.chrome.driver",
					  "C:\\Software(Suraj)\\chromedriver_win32\\chromedriver.exe");		
			driver = new ChromeDriver();
		}
		else if(config.readData("Browser").equalsIgnoreCase("FIREFOX"))
		{
			System.setProperty("webdriver.gecko.driver",
					  "C:\\Software(Suraj)\\geckodriver-v0.30.0-win64\\geckodriver.exe"); 
			driver = new FirefoxDriver();
		}
		else if(config.readData("Browser").equalsIgnoreCase("IE"))
		{
			System.setProperty("webdriver.ie.driver",
					  "C:\\Users\\gurunath\\Downloads\\IEDriverServer_x64_4.0.0\\IEDriverServer.exe"); 
			driver = new InternetExplorerDriver();
		}
		

		else
		{
			System.setProperty("webdriver.chrome.driver",
					  "C:\\Software(Suraj)\\chromedriver_win32\\chromedriver.exe"); 
			driver = new ChromeDriver();
		}
		return driver;
	}
	
	//C:\Software(Suraj)\IEDriverServer_Win32_4.0.0\IEDriverServer.exe

}
