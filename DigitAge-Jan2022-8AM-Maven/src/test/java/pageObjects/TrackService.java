package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import appUtilities.ApplicationUtilities;
import gUtilities.ReadProperties;
import testBatches.TestBatches;

public class TrackService 
{
	WebDriver driver;
	ReadProperties data;
	ApplicationUtilities appUtils;
	
	public TrackService(WebDriver driver)
	{
		this.driver = driver;
		data = new ReadProperties("TestData/"+TestBatches.env+"Data.properties");
		appUtils = new ApplicationUtilities(driver);
		PageFactory.initElements(driver, this);
	}

	//----------------WebElements----------------

		@FindBy(xpath = "//a[@title='Track Service']") WebElement trackServiceTab;
	//-------------------------------------------

	
	public boolean navigateToTrackService()
	{
		System.out.println("RC : Navigate To Track Status");
		//appUtils.getElement("//a[@title='Track Service']").click();
		trackServiceTab.click();
		return true;
	}
	
	public boolean trackTicketService()
	{
		System.out.println("RC : Track Ticket Status");
		appUtils.getElement("//input[@name='serviceCode']").sendKeys(data.readData("ServiceNumber"));
		return true;
	}

}
