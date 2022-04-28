package appUtilities;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ApplicationUtilities 
{
	WebDriver driver; //null
	Actions actions;
	JavascriptExecutor js;
	public ApplicationUtilities(WebDriver driver)
	{
		//System.setProperty("webdriver.chrome.driver",
		//		  "D:\\Softwares\\JarFiles\\chromedriver-win32-90\\chromedriver.exe"); 
		//driver = new ChromeDriver(); // a new empty chrome browser will be opened
		this.driver = driver;  // a = a ;
		actions = new Actions(driver);
		js = (JavascriptExecutor)driver ;
	}
	
	//--------------Utility Functions ---------------
		public WebElement getElement(String myxpath) //static polymorphism , early binding
		{
			if(driver.findElement(By.xpath(myxpath)).isEnabled())
			{
				System.out.println("Element is Enabled , Xpath :" + myxpath);
				return driver.findElement(By.xpath(myxpath));
			}
			else
			{
				System.out.println("Element is not Enabled, Xpath :" + myxpath);
				return null;
			}		
		}
		public WebElement getElement(String myxpath,String elementName)
		{
			if(driver.findElement(By.xpath(myxpath)).isEnabled())
			{
				System.out.println(elementName + " : is Enabled");
				return driver.findElement(By.xpath(myxpath));
			}
			else
			{
				System.out.println(elementName + " : is not Enabled");
				return null;
			}		
		}
		//----------------Application Utility functions----------------------
		public void actionsWait(int timeInSec)
		{
			actions.pause(timeInSec * 1000).perform();
		}
		
		public void scrollToElement(WebElement element)
		{
			actions.moveToElement(element).perform();
		}
		public void mouseHover(WebElement element)
		{
			actions.moveToElement(element).perform();
		}
		public void jsClick(WebElement element)
		{
			js.executeScript("arguments[0].click();", element);
		}
		public void asClick(WebElement element)
		{
			actions.click(element).perform();
		}
		public void clickEnter()
		{
			actions.sendKeys(Keys.ENTER).perform();
		}
		public void clickTab()
		{
			actions.sendKeys(Keys.TAB).perform();
		}
		
		//---------------------------------------

}