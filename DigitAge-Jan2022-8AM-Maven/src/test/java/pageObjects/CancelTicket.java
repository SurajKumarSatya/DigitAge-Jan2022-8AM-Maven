package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import appUtilities.ApplicationUtilities;
import gUtilities.ReadProperties;
import testBatches.TestBatches;

public class CancelTicket 
{
	WebDriver driver;
	ReadProperties data;
	ApplicationUtilities appUtils;
	
	public CancelTicket(WebDriver driver)
	{
		this.driver = driver;
		data = new ReadProperties("TestData/"+TestBatches.env+"Data.properties");
		appUtils = new ApplicationUtilities(driver);
		PageFactory.initElements(driver, this);	
}

//----------------WebElements----------------

	@FindBy(xpath = "//a[@title='Cancel Ticket']") WebElement cancelTktObj;
//-------------------------------------------
	public boolean navigateToCancelTicket()
	{
		System.out.println("RC : Navigate To Cancel Ticket ");
		//appUtils.getElement("//a[@title='Cancel Ticket']").click();
		cancelTktObj.click();
		return true;
	}
	
	public boolean cancelTheTicket()
	{
		System.out.println("RC : Cancel The Ticket ");
		appUtils.getElement("//input[@name='id']").sendKeys(data.readData("TicketNumber"));
		return true;
		//return false; //for failing the test case
	}


}
