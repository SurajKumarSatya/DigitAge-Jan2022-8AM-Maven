package testScenarios;

import java.io.File;
import java.util.Random;

import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.TakesScreenshot;

import pageObjects.CancelTicket;
import pageObjects.Home;
import pageObjects.Login;
import pageObjects.TicketStatus;
import pageObjects.TrackService;
import testBatches.TestBatches;

public class TestCases                  
{
	
	WebDriver driver;
	Login login;
	Home home;
	TicketStatus ticketStatus;
	TrackService trackService;
	CancelTicket cancelTicket;
	ExtentTest child;
	
	public TestCases(WebDriver driver)
	{
        this.driver = driver;
//		 System.setProperty("webdriver.chrome.driver",
//				  "C:\\Software(Suraj)\\chromedriver_win32\\chromedriver.exe"); 
//		driver = new ChromeDriver();
		login = new Login(driver);
		home = new Home(driver);
		ticketStatus = new TicketStatus(driver);
		trackService = new TrackService(driver);
		cancelTicket = new CancelTicket(driver); 
	}
	
	boolean result;
	public void logReport(boolean flag,String stepName)
	{
		if(flag)
		{
			child.log(LogStatus.PASS, stepName,"Successfull");
		}
		else
		{
			child.log(LogStatus.FAIL,child.addScreenCapture(TakeErrorScreenShot(stepName)),stepName);
		}
	}
	
	String screenshotfilepath;
	public String TakeErrorScreenShot(String fname)
	{
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try{
			screenshotfilepath = new File(".").getCanonicalPath()+"\\ScreenShots\\"+fname+new Random().nextInt(9999)+".png";
			FileUtils.copyFile(scrFile,new File(screenshotfilepath));
		}catch(Exception e1){
			e1.printStackTrace();
		}  
		    scrFile = null;
		    return screenshotfilepath;
	}
	
	
	@Test
	public void bookBusTicketAndPrint()
	{
		child = TestBatches.extent.startTest("BookBusTicketAndPrint");
		TestBatches.parent.appendChild(child);
		System.out.println("Test Case : BookBusTicketAndPrint ");
		result = login.launchApplication();
		if(result)
		{
			child.log(LogStatus.PASS, "LaunchApplication","Successfull");
		}
		else
		{
			child.log(LogStatus.FAIL, "LaunchApplication","Failed");
		}
		
		result = login.loginToApplication();
		logReport(result,"Login");
		logReport(home.navigateToHome(),"NavigateToHome");
		logReport(home.bookTicket(),"BookTicket");
		logReport(home.printTicket(),"PrintTicket");
		logReport(login.logoutFromApplication(),"LogoutFromApplication");
		logReport(login.closeApplication(),"CloseApplication");
		
	}
	
	@Test
	public void bookBusTicketAndCheckStatus()
	{
		child = TestBatches.extent.startTest("BookBusTicketAndCheckStatus");
		TestBatches.parent.appendChild(child);
		System.out.println("Test Case : BookBusTicketAndCheckStatus ");
//		login.launchApplication();
//		login.loginToApplication();
//		home.navigateToHome();
//		home.bookTicket();
//		ticketStatus.navigateToTicketStatus();
//		ticketStatus.checkTicketStatus();
//		login.logoutFromApplication();
//		login.closeApplication();
		
		logReport(login.launchApplication(),"LaunchApplication");
		logReport(login.loginToApplication(),"LoginToApplication");
		logReport(home.navigateToHome(),"NavigateToHome");
		logReport(home.bookTicket(),"BookTicket");
		logReport(ticketStatus.navigateToTicketStatus(),"NavigateToTicketStatus");
		logReport(ticketStatus.checkTicketStatus(),"CheckTicketStatus");
		//logReport(home.printTicket(),"PrintTicket");
		logReport(login.logoutFromApplication(),"LogoutFromApplication");
		logReport(login.closeApplication(),"CloseApplication");
		
	}
	
	@Test
	public void bookBusTicketAndTrackService()
	{
		child = TestBatches.extent.startTest("BookBusTicketAndTrackService");
		TestBatches.parent.appendChild(child);
		System.out.println("Test Case : BookBusTicketAndTrackService ");
//		login.launchApplication();
//		login.loginToApplication();
//		home.navigateToHome();
//		home.bookTicket();
//		trackService.navigateToTrackService();
//		trackService.trackTicketService();
//		login.logoutFromApplication();
//		login.closeApplication();
		
		logReport(login.launchApplication(),"LaunchApplication");
		logReport(login.loginToApplication(),"LoginToApplication");
		logReport(home.navigateToHome(),"NavigateToHome");
		logReport(home.bookTicket(),"BookTicket");
		logReport(trackService.navigateToTrackService(),"NavigateToTrackServices");
		logReport(trackService.trackTicketService(),"TrackTicketService");
		//logReport(home.printTicket(),"PrintTicket");
		logReport(login.logoutFromApplication(),"LogoutFromApplication");
		logReport(login.closeApplication(),"CloseApplication");
	}
	
	@Test
	public void bookBusTicketAndCancel()
	{
		child = TestBatches.extent.startTest("BookBusTicketAndCancel");
		TestBatches.parent.appendChild(child);
		System.out.println("Test Case : BookBusTicketAndCancel ");
//		login.launchApplication();
//		login.loginToApplication();
//		home.navigateToHome();
//		home.bookTicket();
//		cancelTicket.navigateToCancelTicket();
//		cancelTicket.cancelTheTicket();
//		login.logoutFromApplication();
//		login.closeApplication();
		
		logReport(login.launchApplication(),"LaunchApplication");
		logReport(login.loginToApplication(),"LoginToApplication");
		logReport(home.navigateToHome(),"NavigateToHome");
		logReport(home.bookTicket(),"BookTicket");
		logReport(cancelTicket.navigateToCancelTicket(),"navigateToCancelTicket");
		logReport(cancelTicket.cancelTheTicket(),"CancelTheTicket");
		//logReport(home.printTicket(),"PrintTicket");
		logReport(login.logoutFromApplication(),"LogoutFromApplication");
		logReport(login.closeApplication(),"CloseApplication");
	}
	
	@Test
	public void bookBusTicketPrintAndTrackService()
	{
		child = TestBatches.extent.startTest("BookBusTicketPrintAndTrackService");
		TestBatches.parent.appendChild(child);
		System.out.println("Test Case : BookBusTicketPrintAndTrackService ");
//		login.launchApplication();
//		login.loginToApplication();
//		home.navigateToHome();
//		home.bookTicket();
//		home.printTicket();
//		trackService.navigateToTrackService();
//		trackService.trackTicketService();
//		login.logoutFromApplication();
//		login.closeApplication();
		
		logReport(login.launchApplication(),"LaunchApplication");
		logReport(login.loginToApplication(),"LoginToApplication");
		logReport(home.navigateToHome(),"NavigateToHome");
		logReport(home.bookTicket(),"BookTicket");
		logReport(home.printTicket(),"PrintTicket");
		logReport(trackService.navigateToTrackService(),"NavigateToTrackServices");
		logReport(trackService.trackTicketService(),"TrackTicketService");
		//logReport(home.printTicket(),"PrintTicket");
		logReport(login.logoutFromApplication(),"LogoutFromApplication");
		logReport(login.closeApplication(),"CloseApplication");
		
	}

}
