package applicationLayer;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

import utilities.ExcelFileUtil;

public class AlertsPage 
{
	//declare global variables
	WebDriver driver;
	WebDriverWait wait;
	//constructor for this class
	public AlertsPage(WebDriver driver)
	{
		this.driver=driver;	
	}

	//object repository of alerts page
	
	@FindBy(xpath="//*[@id='app']/div/div/div[2]/div/div[3]/div/div[3]/h5")
	public WebElement alerts;
	@FindBy(xpath="/html/body/div/div/div/div[2]/div[1]/div/div/div[3]/div/ul/li[2]/span")
	public WebElement alert_link;
	@FindBy(xpath="/html/body/div/div/div/div[2]/div[2]/div[1]/div[2]/div[2]/button")
	public WebElement click_me;
	
	//operational method
	
		public String verifyAlert() throws Throwable
		{
			//click on the alerts link
			System.out.println("Clicking on Alerts");
			String res="";
		    wait=new WebDriverWait(driver,40);
			wait.until(ExpectedConditions.visibilityOf(this.alerts));
			//this.driver.executeScript("arguments[0].scrollIntoView();",this.alerts);
			Actions act=new Actions(this.driver);
		    for(int i=1;i<10;i++)
			 {
				 act.sendKeys(Keys.ARROW_DOWN).perform();
				 Thread.sleep(1000);
			 }
		    Thread.sleep(3000);
		    this.alerts.click();
		    
		  //click on the alert link
		    System.out.println("Clicking on Alert link");
		    wait.until(ExpectedConditions.elementToBeClickable(this.alert_link));
		    //this.driver.executeScript("arguments[0].scrollIntoView();",this.alert_link);
		    Actions act_link=new Actions(this.driver);
		    for(int i=1;i<10;i++)
			 {
				 act_link.sendKeys(Keys.ARROW_DOWN).perform();
				 Thread.sleep(1000);
			 }
		    Thread.sleep(3000);
			
			this.alert_link.click();
			
		   //click on the alert box
			System.out.println("Clicking on Alert button");
			wait.until(ExpectedConditions.elementToBeClickable(this.click_me));
			this.click_me.click();
			Thread.sleep(5000);
			//accept the alert
			System.out.println("Accepting the Alert");
			this.driver.switchTo().alert().accept();
			Thread.sleep(4000);
			if(this.click_me.isDisplayed())
			{
				res="Pass";
				Reporter.log("Alert click is Successful",true);
			    
			}
			else
			{
				res="Fail";
				Reporter.log("Alert click is not Successful",true);
				
			}
			return res;
				
		}
	
	
	
	
}
