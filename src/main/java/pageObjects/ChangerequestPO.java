package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import resources.base;

public class ChangerequestPO extends base {
	

	public WebDriver driver;
	
	
	By membermanager = By.xpath("//a[@id='lnkMemberManager']");
	
	By searchwithfirstname = By.xpath("//input[@id='ContentPlaceHolder1_txtFirstName']");
	
	By searchallclubs = By.xpath("//a[@id='ContentPlaceHolder1_btnSubmit3']");
	
	By managebtn = By.xpath("//input[@id='ContentPlaceHolder1_grdMemberSearch_btnManage_2']");
	
	By chechinbtn = By.xpath("//input[@id='ContentPlaceHolder1_grdMemberSearch_btnCheckIn_2']");
	
	By changerequest = By.xpath("//a[@id='ContentPlaceHolder1_changeRequestLink']");
	
	By familymember = By.xpath("//a[@id='ContentPlaceHolder1_btnFamilyMember']");
	
	By billinginfobtn = By.xpath("//a[@id='ContentPlaceHolder1_ChangeRequestForm_billingTab']");
	
	By creditcardbtn = By.xpath("//input[@id='ContentPlaceHolder1_ChangeRequestForm_rdCreditCard']");
	
	//By bankdraftbtn = By.xpath("//input[@id='ContentPlaceHolder1_ChangeRequestForm_rdBankDraft']");
	
	By selectcardtype = By.xpath("//select[@id='ContentPlaceHolder1_ChangeRequestForm_ddlCardType']");
	
	By mastercard = By.xpath("//option[contains(text(),'MC')]");
	
	By visacard = By.xpath("//option[contains(text(),'Visa')]");
	
	
	public ChangerequestPO(WebDriver driver) {
		
		this.driver = driver;
	}
	
	 public WebElement getmembermanager() {
			
			return driver.findElement(membermanager);
		
		}
	 public WebElement getsearchwithfirstname() {
			
			return driver.findElement(searchwithfirstname);
		
		}
	 public WebElement getsearchallclubs() {
			
			return driver.findElement(searchallclubs);
		
		}
	 public WebElement getmanagebtn() {
			
			return driver.findElement(managebtn);
		
		}
	 public WebElement getchechinbtn() {
			
			return driver.findElement(chechinbtn);
		
		}
	 public WebElement getchangerequest() {
			
			return driver.findElement(changerequest);
		
		}
	 public WebElement getbillinginfobtn() {
			
			return driver.findElement(billinginfobtn);
		
		}
	 public WebElement getcreditcardbtn() {
		 
		 return driver.findElement(creditcardbtn);
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
 
           
 
	 public void updatememberinfo(String firstletter, String creditcardnummc, String visacard) throws Exception {
		 
		 
		 getmembermanager().click();
		 
		 getsearchwithfirstname().sendKeys(firstletter);
		 
		 getsearchallclubs().click();
		 
		 getmanagebtn().click();
		 
		 getchangerequest().click();
		 
		 getbillinginfobtn().click();
		 
		 getcreditcardbtn().click();
		 
		 getselectcardtype().click();
		 
		
		 
		String cardtype = prop.getProperty("cardtype");
		 
			if(cardtype.equals("Mc")) {
		
			 getmastercard().click();
			 
			 driver.findElement(By.xpath("//input[@id='ContentPlaceHolder1_ChangeRequestForm_txtCardNumber']")).clear();
			 Thread.sleep(2000);
			 
			 driver.findElement(By.xpath("//input[@id='ContentPlaceHolder1_ChangeRequestForm_txtCardNumber']")).sendKeys(creditcardnummc);
			
			 
			 driver.findElement(By.xpath("//select[@id='ContentPlaceHolder1_ChangeRequestForm_ddlMonth']")).click();
			 
			 driver.findElement(By.xpath("//tbody/tr[1]/td[1]/div[1]/div[1]/div[3]/div[1]/div[2]/div[3]/div[1]/div[2]/div[2]"
			 		+ "/div[2]/div[2]/div[1]/div[1]/select[1]/option[11]")).click();
			 driver.findElement(By.xpath("//select[@id='ContentPlaceHolder1_ChangeRequestForm_ddlYear']")).click();
			 
			 driver.findElement(By.xpath("//tbody/tr[1]/td[1]/div[1]/div[1]/div[3]/div[1]/div[2]/div[3]/div[1]/div[2]/div[2]/div[2]/div[2]/div[1]/div[3]/select[1]/option[4]")).click();
			 
			 driver.findElement(By.xpath("//input[@id='ContentPlaceHolder1_ChangeRequestForm_txtReason2']")).sendKeys("update member status");
			 
			}
		 
		 if(cardtype.equals("Visa")) {
			 
            // driver.findElement(By.xpath("//option[contains(text(),'Visa')]")).click();
			 
			 getvisacard().click();
			 driver.findElement(By.xpath("//input[@id='ContentPlaceHolder1_ChangeRequestForm_txtCardNumber']")).clear();
			 Thread.sleep(2000);
			 driver.findElement(By.xpath("//input[@id='ContentPlaceHolder1_ChangeRequestForm_txtCardNumber']")).sendKeys(visacard);
			 
			 driver.findElement(By.xpath("//select[@id='ContentPlaceHolder1_ChangeRequestForm_ddlMonth']")).click();
			 
			 driver.findElement(By.xpath("//tbody/tr[1]/td[1]/div[1]/div[1]/div[3]/div[1]/div[2]/div[3]/div[1]/div[2]/div[2]"
				 		+ "/div[2]/div[2]/div[1]/div[1]/select[1]/option[11]")).click();
			// driver.findElement(By.xpath("//option[contains(text(), '12')")).click();
			 driver.findElement(By.xpath("//select[@id='ContentPlaceHolder1_ChangeRequestForm_ddlYear']")).click();
			 
			// driver.findElement(By.xpath("//option[contains(text(), '2023')")).click();
			 
			 driver.findElement(By.xpath("//tbody/tr[1]/td[1]/div[1]/div[1]/div[3]/div[1]/div[2]/div[3]/div[1]/div[2]/div[2]/div[2]/div[2]/div[1]/div[3]/select[1]/option[4]")).click();
			 
			 
			 driver.findElement(By.xpath("//input[@id='ContentPlaceHolder1_ChangeRequestForm_txtReason2']")).sendKeys("update member status");
			  
		 }
		 
	 }

}
