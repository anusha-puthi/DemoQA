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

public class DroppablePage 
{
	//declare global variables
	WebDriver driver;
	WebDriverWait wait;
	
	//constructor for this class
	public DroppablePage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	//object repository of Droppablepage
	@FindBy(xpath="/html/body/div/div/div/div[2]/div/div[5]/div/div[3]/h5")
	public WebElement interactions;
	@FindBy(xpath="//div[@class='element-list collapse show']/ul/li[4]/span")
	public WebElement droppable;
	@FindBy(xpath="//*[text()='Drag me']")
	public WebElement drag_me;
	@FindBy(xpath="//*[@class='drop-box ui-droppable']")
	public WebElement drop_here;
	
	//operational methods
	public String verifyDragDrop() throws Throwable 
	{
		//click on the Interactions link
			 String res="";
			 System.out.println("Clicking on Interactions Link");
			 wait=new WebDriverWait(driver,30);
			 wait.until(ExpectedConditions.elementToBeClickable(this.interactions));
			 Actions act=new Actions(this.driver);
		     for(int i=1;i<10;i++)
			  {
				 act.sendKeys(Keys.ARROW_DOWN).perform();
				 Thread.sleep(1000);
			 }
		     Thread.sleep(3000);
		     this.interactions.click();
		    
		     //click on Droppable link
		     System.out.println("Clicking on Droppable link");
		     wait.until(ExpectedConditions.elementToBeClickable(this.droppable));
		     Actions act_drop=new Actions(this.driver);
		     for(int i=1;i<10;i++)
			 {
				 act_drop.sendKeys(Keys.ARROW_DOWN).perform();
				 Thread.sleep(1000);
			 }
		    this.droppable.click();
		    Thread.sleep(3000);
		   
		    //click on close button
		    System.out.println("Dragging and dropping into box");
		    wait.until(ExpectedConditions.elementToBeClickable(this.drag_me));
		    Actions act_drag=new Actions(driver);
			act_drag.moveToElement(this.drag_me);
			Thread.sleep(3000);
			act_drag.dragAndDrop(this.drag_me,this.drop_here).perform();
			Thread.sleep(3000);
			
		    if(this.drop_here.getText().contains("dropped"))
		    {
		    	res="Pass";
				Reporter.log("Drag and Drop is Successful",true);
			}
			else
			{
				res="Fail";
				Reporter.log(" Drag and Drop is  not Successful",true);
			}
			return res;	
			}
	 
	}
    

	
