package applicationLayer;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

public class ToolTipPage 
{
	//declare global variables
	WebDriver driver;
	WebDriverWait wait;
	
	//constructor for this class
	public ToolTipPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	//object repository of tooltip page	
	@FindBy(xpath="/html/body/div/div/div/div[2]/div/div[4]/div/div[3]/h5")
	public WebElement widgets;
	@FindBy(xpath="/html/body/div/div/div/div[2]/div[1]/div/div/div[4]/div/ul/li[7]/span")
	public WebElement tool_tips;
	@FindBy(xpath="//div[@id='toopTipContainer']/div/button")
	public WebElement tool_button;
	@FindBy(xpath="//div[@id='toopTipContainer']/div/button/following::div[1]/input")
	public WebElement tool_ele;
	
	//operational methods

	public String verifyToolTips() throws Throwable
	{
		String res ="";
		System.out.println("Clicking on Widgets link");
	    wait=new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.visibilityOf(this.widgets));
		Actions act=new Actions(this.driver);
	    for(int i=1;i<10;i++)
		 {
			 act.sendKeys(Keys.ARROW_DOWN).perform();
			 Thread.sleep(1000);
		 }
	    Thread.sleep(3000);
	    this.widgets.click();
		
		//click on tooltip link
	    System.out.println("Clicking on Tooltip link");
	    wait.until(ExpectedConditions.visibilityOf(this.tool_tips));
	    Actions act_tooltip=new Actions(this.driver);
	    for(int i=1;i<10;i++)
		 {
			 act_tooltip.sendKeys(Keys.ARROW_DOWN).perform();
			 Thread.sleep(1000);
		 }
	    Thread.sleep(3000);
		this.tool_tips.click();
		
		//click on tooltip button
		System.out.println("Clicking on tooltip button");
		wait.until(ExpectedConditions.visibilityOf(this.tool_button));
		Actions act_toolbutton=new Actions(this.driver);
		act_toolbutton.moveToElement(this.tool_button).perform();
		Thread.sleep(5000);
		
		//Click on tooltip element
		System.out.println("clicking in tooltip element");
		wait.until(ExpectedConditions.visibilityOf(this.tool_ele));
		Actions act_toolele=new Actions(this.driver);
		act_toolele.moveToElement(this.tool_ele).perform();
		Thread.sleep(5000);
		
		if(this.tool_ele.isDisplayed())
		{
			res="Pass";
			Reporter.log("Tooltip hover is Successful",true);
		}
		else
		{
			res="Fail";
			Reporter.log("Tooltip hover is  not Successful",true);
		}
		return res;	
	}
	

}
