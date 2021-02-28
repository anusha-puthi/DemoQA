package applicationLayer;

import java.time.LocalDate;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

import utilities.ExcelFileUtil;

public class DatePickerPage
{
	//declare global variables
	WebDriver driver;
	WebDriverWait wait;
	
	//constructor for this class
	public DatePickerPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	//Object repository in datepicker page
	@FindBy(xpath="/html/body/div/div/div/div[2]/div/div[4]/div/div[3]/h5")
	public WebElement widgets;
	@FindBy(xpath="//*[@class='element-list collapse show']/ul/li[3]/span")
	public WebElement datepicker_link;
	@FindBy(xpath="/html/body/div/div/div/div[2]/div[2]/div[1]/div[1]/div[2]/div[1]/div/input")
	public WebElement date_picker;
	@FindBy(xpath="/html/body/div/div/div/div[2]/div[2]/div[1]/div[1]/div[2]/div[2]/div[2]/div/div/div[2]/div[1]/div[2]/div[2]/select")
	public WebElement year_dd;
	@FindBy(xpath="/html/body/div/div/div/div[2]/div[2]/div[1]/div[1]/div[2]/div[2]/div[2]/div/div/div[2]/div[1]/div[2]/div[1]/select")
	public WebElement month;
	@FindBy(xpath="/html/body/div/div/div/div[2]/div[2]/div[1]/div[1]/div[2]/div[2]/div[2]/div/div/button[2]")
	public WebElement right_arrow;
	@FindBy(xpath="//*[@class='react-datepicker__month']")
	public WebElement days;
	
	//operational method
	
	public String verifyDatePicker() throws Throwable
	{
		String res="";
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
	    
	    //click on datepicker link
	    System.out.println("Clicking on datepicker link");
	    wait.until(ExpectedConditions.visibilityOf(this.datepicker_link));
		Actions act_datelink=new Actions(this.driver);
	    for(int i=1;i<10;i++)
		 {
			 act_datelink.sendKeys(Keys.ARROW_DOWN).perform();
			 Thread.sleep(1000);
		 }
	    Thread.sleep(3000);
	    this.datepicker_link.click();
	   
	    //click on the datepicker
	    System.out.println("Clicking on datepicker");
	    wait.until(ExpectedConditions.elementToBeClickable(this.date_picker));
	    this.date_picker.click();
		Thread.sleep(4000);
		
		//get the curent date
		String currentdate=this.date_picker.getAttribute("value");
		String curdate[]=currentdate.split("/");
		String curday=curdate[1];
		String curmon=curdate[0];
		String curyear=curdate[2];
		System.out.println(curday+" "+curmon+" "+curyear);
		
		//set the future date
		LocalDate futuredate=LocalDate.now().plusMonths(1);
		String futdate=String.valueOf(futuredate);
		String comingdate[]=futdate.split("-");
		System.out.println(futdate);
		String futday=comingdate[2];
		String futmon=comingdate[1];
		String futyear=comingdate[0];
		System.out.println(futday+" "+futmon+" "+futyear);
		
		//selecting the date
		//select the year
		this.year_dd.click();
		String actyear=this.year_dd.getText();
		System.out.println(actyear+" "+futyear);
		if(actyear.equals(futyear))
		{
		  this.year_dd.findElement(By.xpath("child::option")).click();
		  actyear=this.year_dd.getText();
		}
		//selecting the month
		this.month.click();
		String actmon=this.month.getText();
		
		if(!actmon.equals(futmon))
		{
		    this.right_arrow.click();
		    actmon=this.month.getText();
		}
		//selecting date
		List<WebElement> dates=this.days.findElements(By.xpath("child::div/div"));
		 for(WebElement date:dates)
		 {
			// String actday=date.getText(); 
			 if(date.getText().equals(futday))
			 {
				date.click();
				break;	
			 }
			 if(this.datepicker_link.isDisplayed())
			 {
				 res="Pass";
				 Reporter.log("DatePicker selection is  Successful",true);
				 
			 }
			 else 
			 {
				 res="Fail";
				 Reporter.log("DatePicker selection is not Successful",true);	
			 }
		 }
		
		return res;	
		 
		
	}
}
