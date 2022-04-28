package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import appUtilities.ApplicationUtilities;
import gUtilities.ReadProperties;
import testBatches.TestBatches;

public class Login 
{
	
	WebDriver driver;
	ReadProperties data;
	ApplicationUtilities appUtils; 
	
	public Login(WebDriver driver)
	{
		this.driver = driver;
		data = new ReadProperties("TestData/"+TestBatches.env+"Data.properties"); //DevData or Prod orQAData or StageData
		appUtils = new ApplicationUtilities(driver);
		PageFactory.initElements(driver, this);	
	}

	//----------------WebElements----------------

		@FindBy(xpath = "//a[@title='Home']") WebElement homeBtn;
	//-------------------------------------------
	public boolean launchApplication()
	{
		System.out.println("RC : Launch Application");
		driver.get(data.readData("URL"));
		if(driver.getTitle().equals(data.readData("ExpectedTitle")))
			return true;
		else
			return false;
	}
	
	public boolean loginToApplication()
	{
		System.out.println("RC : Login To Application");
		return true;
	}
	
	public boolean logoutFromApplication()
	{
		System.out.println("RC : Logout From Application");
		//appUtils.getElement("//a[@title='Home']").click();
		homeBtn.click();
		return true;
	}
	
	public boolean closeApplication()
	{
		System.out.println("RC : Close Application");
		return true;
	}

	
	
	

}
