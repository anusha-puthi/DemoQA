package applicationLayer;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

public class RegisterPage
{
	//declare global variables
	WebDriver driver;
	WebDriverWait wait;
	
	//constructor for this class
	public RegisterPage(WebDriver driver)
	{
		this.driver=(RemoteWebDriver) driver;
	}
	
	//object repository of register page
	@FindBy(xpath="//*[@id='app']/div/div/div[2]/div/div[2]/div/div[3]/h5")
	public WebElement forms;
	@FindBy(xpath="//span[text()='Practice Form']")
	public WebElement practice_form;
	@FindBy(id="firstName")
	public WebElement first_name;
	@FindBy(id="lastName")
	public WebElement last_name;
	@FindBy(id="userEmail")
	public WebElement email_id;
	@FindBy(xpath="//*[@for='gender-radio-1']")
	public WebElement gender_male;
	@FindBy(xpath="//*[@for='gender-radio-2']")
	public WebElement gender_female;
	@FindBy(xpath="//*[@for='gender-radio-3']")
	public WebElement gender_others;
	@FindBy(id="userNumber")
	public WebElement mobile_no;
	@FindBy(id="dateOfBirthInput")
	public WebElement date_of_birth;
	@FindBy(xpath="//*[@id='dateOfBirth']/div[2]/div[2]/div/div/div[2]/div[1]/div[2]/div[1]/select")
	public WebElement select_month;
	@FindBy(xpath="//*[@id='dateOfBirth']/div[2]/div[2]/div/div/div[2]/div[1]/div[2]/div[2]/select")
	public WebElement select_year;
	@FindBy(xpath="//*[@class='react-datepicker__month']")
	public WebElement select_day;
	@FindBy(xpath="/html/body/div/div/div/div[2]/div[2]/div[1]/form/div[6]/div[2]/div/div/div[1]")
	public WebElement select_subjects;
	@FindBy(xpath="//*[@for='hobbies-checkbox-1']")
	public WebElement select_hobbies;
	@FindBy(xpath="//*[@class='form-file']/input")
	public WebElement upload_picture;
	@FindBy(xpath="(//*[@class='form-control'])[2]")
	public WebElement current_address;
	@FindBy(xpath="/html/body/div/div/div/div[2]/div[2]/div[1]/form/div[10]/div[2]/div/div/div[2]/div/svg")
	public WebElement select_state;
	@FindBy(xpath="/html/body/div/div/div/div[2]/div[2]/div[1]/form/div[10]/div[3]/div/div/div[2]/div/svg")
	public WebElement select_city;
	@FindBy(xpath="//*[text()='Submit']")
	public WebElement click_submit;
	//@FindBy(xpath="//*[@class='modal-title h4']")
	//public WebElement dialogue_text;
	@FindBy(xpath="//*[text()='Close']")
	public WebElement close_button;
	
	//operational methods	
	public String verifyStudentRegistration() throws Throwable
	{
		System.out.println("Clicking on forms link");
		String res="";
		wait=new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOf(this.forms));
		Actions act=new Actions(this.driver);
		 for(int i=1;i<10;i++)
		 {
			 act.sendKeys(Keys.ARROW_DOWN).perform();
			 Thread.sleep(1000);
		 }
		 this.forms.click();
		 Thread.sleep(2000);
		 
		 //click on practice form link
		 System.out.println("Clicking on practice form");
		 wait.until(ExpectedConditions.elementToBeClickable(this.practice_form));
		this. practice_form.click();
		
		//wait for the name field  visibility
		System.out.println("Enter fields");
		wait.until(ExpectedConditions.visibilityOf(this.first_name));
		this.first_name.sendKeys("Ganesh",Keys.TAB);
		this.last_name.sendKeys("Iyer",Keys.TAB);
		this.email_id.sendKeys("ganesh.iyer@gmail.com",Keys.TAB);
		
		//select gender
	    this.gender_male.click();
		this.mobile_no.sendKeys("7890890990",Keys.TAB);
		//select date of birth
		this.date_of_birth.click();
		//select month
		this.select_month.click();
		 Select smon=new Select(this.select_month);
		 smon.selectByVisibleText("March");
		 //select year
		 this.select_year.click();
		 Select syear=new Select(this.select_year);
		 syear.selectByVisibleText("2002");
		 //select day
		 List<WebElement> dates=this.select_day.findElements(By.xpath("child::div/div"));
		 for(WebElement date:dates)
		 {
			 String d=date.getText();
			 if(d.equals("30"))
			 {
				date.click();
				break;
			 }
		 }
		 //go to next tab
		 wait.until(ExpectedConditions.visibilityOf(this.select_subjects));
		 Actions act_subjects=new Actions(driver);
		 act_subjects.moveToElement(this.select_subjects).perform();
		 this.select_subjects.click();
		 
		 //select hobbies 
		 this.select_hobbies.click();
		 
		//upload picture
		wait.until(ExpectedConditions.visibilityOf(this.upload_picture));
		Actions act_upload=new Actions(this.driver);
		 for(int i=1;i<10;i++)
		 {
			 act_upload.sendKeys(Keys.ARROW_DOWN).perform();
			 Thread.sleep(1000);
		 }
		 
		 Actions act_clickupload=new Actions(this.driver);
		 act_clickupload.moveToElement(this.upload_picture).click(this. upload_picture).build().perform();
		//handling file upload window
		Thread.sleep(4000);
		StringSelection f=new StringSelection("C:\\Users\\Personal\\Pictures\\1970-01\\ganesh.jpg");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(f, null);
		Robot r=new Robot();
		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_V);
		r.keyRelease(KeyEvent.VK_V);
		r.keyRelease(KeyEvent.VK_CONTROL);
		Thread.sleep(5000);
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(3000);
		
		//click on address
		wait.until(ExpectedConditions.visibilityOf(this.current_address));
		this.current_address.click();
		this.current_address.sendKeys("test address",Keys.TAB);
	
		//click on submit
	      Actions act_submit=new Actions(this.driver);
	      act_submit.moveToElement(this.click_submit).click(this.click_submit).build().perform();
	      Thread.sleep(3000);
	    //click on close button
	      wait.until(ExpectedConditions.elementToBeClickable(this.close_button));
	      this.close_button.click();  	     
		   
	      
         if(this.first_name.isDisplayed())
         {
        	 res="Pass";
        	 Reporter.log("Student Registration is Successful",true);
         }
         else
         {
        	 res="Fail";
        	 Reporter.log("Student Registration is not Successful",true);
         }		
		
		return res;
		
	}

	

}
