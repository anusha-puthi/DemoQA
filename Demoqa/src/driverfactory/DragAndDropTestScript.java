package driverfactory;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import applicationLayer.DroppablePage;
import applicationLayer.ModalPage;

public class DragAndDropTestScript
{
	WebDriver driver;
	Properties p;
	FileInputStream fi;
	ExtentReports report;
	ExtentTest test;
	
	//launch site in given browser
	@BeforeTest
	public void launch() throws Throwable
	{
		p=new Properties();
		fi=new FileInputStream("G:\\anujava\\Demoqa\\PropertyFile\\Project.properties");
		p.load(fi);
		  if(p.getProperty("Browser").equalsIgnoreCase("chrome"))
			 {
				System.out.println("Executing on chrome");
				System.setProperty("webdriver.chrome.driver","G:\\anujava\\Demoqa\\CommonDrivers\\chromedriver.exe");
				driver=new ChromeDriver();
				driver.get(p.getProperty("Url"));
				driver.manage().window().maximize();
				
			 }
			 else if(p.getProperty("Browser").equalsIgnoreCase("firefox"))
		     {
				  System.out.println("Executing on firefox browser");
				  System.setProperty("webdriver.gecko.driver","G:\\anujava\\Demoqa\\CommonDrivers\\geckodriver.exe");
				  driver=new FirefoxDriver();
				  driver.get(p.getProperty("Url"));	  
		     }
			  else
			  {
		        System.out.println("Browser Value Is Not Matching");
			  } 
	}
	
	@Test()
	public void draganddrop() throws Throwable
	{
		System.out.println("test method is executing");
		report=new ExtentReports("./ExtentReports/"+"DragandDrop"+".html",false);
		test=report.startTest("Validation of Drag and Drop click");
		DroppablePage dd = PageFactory.initElements(driver,DroppablePage.class);
		dd.verifyDragDrop();
		test.log(LogStatus.PASS,"Drag and Drop test passed");
		report.endTest(test);
		report.flush();
	}
	
	
	@AfterTest
	public void teardown()
	{
		driver.close();
	}

}
