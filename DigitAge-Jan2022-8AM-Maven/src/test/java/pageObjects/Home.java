package pageObjects;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import appUtilities.ApplicationUtilities;
import gUtilities.GeneralUtility;
import gUtilities.ReadProperties;
import testBatches.TestBatches;

public class Home 
{
	WebDriver driver;
	ReadProperties data;
	ApplicationUtilities appUtils;
	
	public Home(WebDriver driver)
	{
		this.driver = driver;
		data = new ReadProperties("TestData/"+TestBatches.env+"Data.properties");
		appUtils = new ApplicationUtilities(driver);
		PageFactory.initElements(driver, this);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	
	//----------------WebElements----------------
	
		@FindBy(xpath = "//input[@name='source']") WebElement fromCityObj;
		@FindBy(xpath = "//input[@name='destination']") WebElement toCityObj;
		@FindBy(xpath = "//input[@name='txtJourneyDate']") WebElement openCalenderBtn;
		@FindBy(xpath = "//input[@name='searchBtn']") WebElement searchBtn;
		@FindBy(xpath = "//a[@title='Home']") WebElement homeBtn;
		@FindBy(xpath = "//a[@id='sbkg']") WebElement modifySearchBtn;
		//-----------------------------------------
	
	public boolean navigateToHome()
	{
		System.out.println("RC : Navigate To Home");
		//explicit wait
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.elementToBeClickable( homeBtn));
		//GeneralUtility.fixedWait(30);
		appUtils.getElement("//a[@title='Home']").click();
		if(fromCityObj.isEnabled())
			return true;
		else
			return false;
	}
	
	
	
	public boolean bookTicket()
	{
		System.out.println("RC : BookTicket");
		//System.out.println("--------------------------------Iteration :" + (i+1));
		fromCityObj.sendKeys(data.readData("FromCity"));
		GeneralUtility.fixedWait(1);
		appUtils.clickEnter();
		toCityObj.sendKeys(data.readData("ToCity"));
		GeneralUtility.fixedWait(1);
		appUtils.clickEnter();
		openCalenderBtn.click();
		//selectDate(data.readData("JDate"));
		appUtils.getElement("//a[text()='"+data.readData("JDate")+"']").click();
		searchBtn.click();
		GeneralUtility.fixedWait(1);
		if(modifySearchBtn.getText().trim().equalsIgnoreCase("Modify Search"))
		{
			homeBtn.click();
			return true;
		}
		else
			return false;
		
	}
	
	public void bookTicket_old()
	{
		System.out.println("RC : BookTicket");
		//System.out.println("--------------------------------Iteration :" + (i+1));
		appUtils.getElement("//input[@name='source']").sendKeys(data.readData("FromCity"));
		GeneralUtility.fixedWait(1);
		appUtils.clickEnter();
		appUtils.getElement("//input[@name='destination']").sendKeys(data.readData("ToCity"));
		GeneralUtility.fixedWait(1);
		appUtils.clickEnter();
		appUtils.getElement("//input[@name='txtJourneyDate']").click();
		//selectDate(data.readData("JDate"));
		appUtils.getElement("//a[text()='"+data.readData("JDate")+"']").click();
		appUtils.getElement("//input[@name='searchBtn']").click();
		GeneralUtility.fixedWait(1);
		appUtils.getElement("//a[@title='Home']").click();
	}
	
	public boolean printTicket()
	{
		System.out.println("RC : PrintTicket");
		return true;
	}

}
