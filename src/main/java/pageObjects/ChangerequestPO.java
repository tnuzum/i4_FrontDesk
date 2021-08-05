package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import resources.base;

public class ChangerequestPO {
	

	public WebDriver driver;
	
	
	By membermanager = By.xpath("//a[@id='lnkMemberManager']");
	
	By Memberbarcode = By.cssSelector("input#ContentPlaceHolder1_txtBarCode");
	
	By searchAllClubsbtn = By.cssSelector("a#ContentPlaceHolder1_btnSubmit3");
	
	By Managebtn = By.xpath("//input[@value='Manage']");
	
	By chechinbtn = By.xpath("//input[@id='ContentPlaceHolder1_grdMemberSearch_btnCheckIn_2']");
	
	By changerequest = By.xpath("//a[@id='ContentPlaceHolder1_changeRequestLink']");
	
	By ChangerequestTitle = By.xpath("//a[@title='Change Request']");
	
	By familymember = By.xpath("//a[@id='ContentPlaceHolder1_btnFamilyMember']");
	
	By billinginfobtn = By.xpath("//a[@id='ContentPlaceHolder1_ChangeRequestForm_billingTab']");
	
	By creditcardbtn = By.xpath("//input[@id='ContentPlaceHolder1_ChangeRequestForm_rdCreditCard']");
	
	//By bankdraftbtn = By.xpath("//input[@id='ContentPlaceHolder1_ChangeRequestForm_rdBankDraft']");
	
	By selectcardtype = By.xpath("//select[@id='ContentPlaceHolder1_ChangeRequestForm_ddlCardType']");
	
	By mastercard = By.xpath("//option[contains(text(),'MC')]");
	
	By visacard = By.xpath("//option[contains(text(),'Visa')]");
	
	By ccexpmonth = By.id("ContentPlaceHolder1_ChangeRequestForm_ddlMonth");
	
	By ccexpyear = By.id("ContentPlaceHolder1_ChangeRequestForm_ddlYear");
	
	By ccardnumber = By.id("ContentPlaceHolder1_ChangeRequestForm_txtCardNumber"); 
	
	By reasonfield = By.id("ContentPlaceHolder1_ChangeRequestForm_txtReason2");
	
	By submitbtn = By.id("ContentPlaceHolder1_ChangeRequestForm_btnSaveChanges");
	
	
	public ChangerequestPO(WebDriver driver) {
		
		this.driver = driver;
	}
	
	 public WebElement getmembermanager() {
			
			return driver.findElement(membermanager);
		
		}
	 public WebElement getMemberbarcode() {
			
			return driver.findElement(Memberbarcode);
		
		}
	 public WebElement getsearchAllClubsbtn() {
			
			return driver.findElement(searchAllClubsbtn);
		
		}
	 public WebElement getManagebtn() {
			
			return driver.findElement(Managebtn);
		
		}
	 public WebElement getchechinbtn() {
			
			return driver.findElement(chechinbtn);
		
		}
	 public WebElement getchangerequest() {
			
			return driver.findElement(changerequest);
		
		}
	 public WebElement getChangerequestTitle() {
			
			return driver.findElement(ChangerequestTitle);
		
		}
	 public WebElement getbillinginfobtn() {
			
			return driver.findElement(billinginfobtn);
		
		}
public WebElement getcreditcardbtn() {
		 
		 return driver.findElement(creditcardbtn);
	 }
public WebElement getccardnumber() {
		 
		 return driver.findElement(ccardnumber);
	 }
	 
 public WebElement  getselectcardtype() {
		 
		 return driver.findElement(selectcardtype);
	 }
 public WebElement  getmastercard() {
	 
	 return driver.findElement(mastercard);
 }
 public WebElement  getvisacard() {
	 
	 return driver.findElement(visacard);
 }
 public WebElement  getccexpmonth() {
	 
	 return driver.findElement(ccexpmonth);
 }
 public WebElement  getccexpyear() {
	 
	 return driver.findElement(ccexpyear);
 }
 public WebElement getreasonfield() {
	 
	 return driver.findElement(reasonfield);
	 
 }
 public WebElement  getsubmitbtn() {
	 
	 return driver.findElement(submitbtn);
 }
           
 
	
	 }


