package applicationLayer;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;


public class ModalPage 
{
	//declare global variables
	WebDriver driver;
	WebDriverWait wait;
	
	
	//constructor for this class
	public ModalPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	//object repository of ModalPage
	@FindBy(xpath="//*[@id='app']/div/div/div[2]/div/div[3]/div/div[3]/h5")
	public WebElement alerts;
	@FindBy(xpath="/html/body/div/div/div/div[2]/div[1]/div/div/div[3]/div/ul/li[5]/span\r\n")
	public WebElement modal_dialogs;
	@FindBy(xpath="/html/body/div/div/div/div[2]/div[2]/div[1]/div/button[1]")
	public WebElement small_modal;
	@FindBy(xpath="//*[@id='closeSmallModal']")
	public WebElement close_modal;
	
	//operational methods
	
	public String verifyClickModal() throws InterruptedException
	{
		String res="";
		System.out.println("clicking on Alerts");
		wait=new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOf(this.alerts));
		Actions act=new Actions(this.driver);
	    for(int i=1;i<10;i++)
		 {
			 act.sendKeys(Keys.ARROW_DOWN).perform();
			 Thread.sleep(1000);
		 }
	    Thread.sleep(3000);
	    this.alerts.click();
		
	    //click on Modals link
	    System.out.println("Clicking on Modals Link");
	    wait.until(ExpectedConditions.elementToBeClickable(this.modal_dialogs));
		Actions act_modals=new Actions(this.driver);
	    for(int i=1;i<10;i++)
		 {
			 act_modals.sendKeys(Keys.ARROW_DOWN).perform();
			 Thread.sleep(1000);
		 }
	    Thread.sleep(3000);
	    this.modal_dialogs.click();
	    
	    //click on small modal
	    System.out.println("Clicking on Small modal button");
	    wait.until(ExpectedConditions.elementToBeClickable(this.small_modal));
	    small_modal.click();
	    Thread.sleep(3000);
	   
	    //click on close button
	    System.out.println("Clicking on close button");
	    wait.until(ExpectedConditions.elementToBeClickable(this.close_modal));
	    close_modal.click();
	    Thread.sleep(3000);
	    if(this.small_modal.isDisplayed())
	    {
	    	res="Pass";
			Reporter.log("Small modal click is Successful",true);
		}
		else
		{
			res="Fail";
			Reporter.log("Small modal click is  not Successful",true);
		}
		return res;	
	}
	}
	
	
	
		

