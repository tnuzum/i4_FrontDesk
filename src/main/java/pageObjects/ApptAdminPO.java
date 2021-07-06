package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ApptAdminPO {
	
public WebDriver driver;
	
	
	By Apptadmintbtn = By.xpath("//a[@id='lnkAppt']");
	
	By btnbarcode = By.id("btnBarcodeId");
	
	By memberbarcode = By.xpath("//input[@id='ContentPlaceHolder1_AppointmentParticipantsControl_ctl02_txtbarcodeId']");
	
	//By firstname = By.id("ContentPlaceHolder1_AppointmentParticipantsControl_ctl02_txtfirstName");
	
	By searchbtn = By.id("ContentPlaceHolder1_AppointmentParticipantsControl_ctl02_lnkbtnSearch");
	
	By selectbtn = By.xpath("//input[@id='ContentPlaceHolder1_AppointmentParticipantsControl_ctl02_grdsearchResult_btnSelect_0']");
	
	By clubs = By.xpath("//select[@id='ContentPlaceHolder1_ddlClubs']");
	
	By schedulegroup = By.xpath("//select[@id='ContentPlaceHolder1_ddlGroups']");
	
	By schedulebook = By.xpath("//select[@id='ContentPlaceHolder1_ddlBooks']");
	
	
	By okbtn = By.xpath("//input[@type='submit']");
	
	By appintmentbtn = By.xpath("//a[@id='ContentPlaceHolder1_btnMakeAppointment']");
	
	By makerecurringbtn = By.xpath("//a[@id='ContentPlaceHolder1_btnRecurringAppointments']");
	
	By cancelappointment = By.xpath("//a[@id='ContentPlaceHolder1_AppointmentFormView_btnCancelAppointment']");
	
	By recurringappointment = By.xpath("//input[@id='ContentPlaceHolder1_chkIsRecurring']");
	
	By submitbtn = By.xpath("//a[@id='ContentPlaceHolder1_btnSubmit']");
	
	By Cancelallapointment = By.cssSelector("a#ContentPlaceHolder1_btnCancelAllAppointment");
	
	
	
	
	public ApptAdminPO(WebDriver driver) {
		this.driver = driver;
	}

	 public WebElement getApptadmintbtn() {
			
			return driver.findElement(Apptadmintbtn);
		
		}
	 public WebElement getbtnbarcode() {
			
			return driver.findElement(btnbarcode);
		
		}
	 public WebElement getmemberbarcode() {
			
			return driver.findElement(memberbarcode);
		
		}
	 public WebElement getsearchbtn() {
			
			return driver.findElement(searchbtn);
		
		}
	 public WebElement getselectbtn() {
			
			return driver.findElement(selectbtn);
		
		}
	 public WebElement getclubs() {
			
			return driver.findElement(clubs);
		
		}
	 public WebElement getschedulegroup() {
			
			return driver.findElement(schedulegroup);
		
		}
	 public WebElement getschedulebook() {
			
			return driver.findElement(schedulebook);
		
		}
	
	 public WebElement getokbtn() {
			
			return driver.findElement(okbtn);
		
		}
	 public WebElement getappintmentbtn() {
			
			return driver.findElement(appintmentbtn);
		
		}
	 public WebElement getcancelappointment() {
			
			return driver.findElement(cancelappointment);
		
		}
	 public WebElement getmakerecurringbtn() {
			
			return driver.findElement(makerecurringbtn);
		
		}
	 public WebElement getrecurringappointment() {
			
			return driver.findElement(recurringappointment);
		
		}
	 public WebElement getsubmitbtn() {
			
			return driver.findElement(submitbtn);
		
		}
	 public WebElement getCancelallapointment() {
			
			return driver.findElement(Cancelallapointment);
		
		}
	
}
