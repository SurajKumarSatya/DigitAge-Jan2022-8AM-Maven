package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import appUtilities.ApplicationUtilities;
import gUtilities.ReadProperties;
import testBatches.TestBatches;

public class TicketStatus 
{
	WebDriver driver;
	ReadProperties data;
	ApplicationUtilities appUtils;
	
	public TicketStatus(WebDriver driver)
	{
		this.driver = driver;
		data = new ReadProperties("TestData/"+TestBatches.env+"Data.properties");
		appUtils = new ApplicationUtilities(driver);
		PageFactory.initElements(driver, this);
	}

	//----------------WebElements----------------

		@FindBy(xpath = "//a[@title='Ticket Status']") WebElement ticketStatusTab;
	//-------------------------------------------
	
	public boolean navigateToTicketStatus()
	{
		System.out.println("RC : Navigate To Ticket Status");
		appUtils.getElement("//a[@title='Ticket Status']").click();
		ticketStatusTab.click();
		return true;
	}
	
	public boolean checkTicketStatus()
	{
		System.out.println("RC : Check  Ticket Status");
		appUtils.getElement("//input[@name='id' and @class='searchTktCancel']").sendKeys(data.readData("TicketNumber"));
		return true;
	}

}
