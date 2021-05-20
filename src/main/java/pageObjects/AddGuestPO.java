package pageObjects;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class AddGuestPO {
	
	public WebDriver driver;
	
	
	By Addguestbtn = By.xpath("//a[@id='lnkAddGuest']");
	
	By guestfirstname = By.xpath("//input[@id='ContentPlaceHolder1_AddGuestForm_rftxtFirstName']");
	
	By guestlastname = By.xpath("//input[@id='ContentPlaceHolder1_AddGuestForm_rftxtLastName']");
	
	By guesttitle = By.xpath("//select[@id='ContentPlaceHolder1_AddGuestForm_rfddlTitle']");
	
	By titledrop = By.xpath("//option[contains(text(),'Mr.')]");
	
	By genderbtn= By.xpath("//body[1]/form[1]/div[3]/div[1]/div[2]/div[1]/div[1]/table[1]/tbody[1]/tr[1]/td[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]"
			+ "/div[2]/div[3]/div[1]/div[1]/div[1]/div[1]/table[1]/tbody[1]/tr[1]/td[1]/label[1]/span[1]/span[2]");

	By dateofbirthfield = By.xpath("//input[@id='ContentPlaceHolder1_AddGuestForm_rftxtDOB']");
	
	By addressfield = By.xpath("//input[@id='ContentPlaceHolder1_AddGuestForm_rftxtAddress']");
	
	By cityfield = By.xpath("//input[@id='ContentPlaceHolder1_AddGuestForm_rftxtCity']");
	
	By zipcodefield = By.xpath("//input[@id='ContentPlaceHolder1_AddGuestForm_rftxtZip']");
	
	By guestpass = By.xpath("//input[@id='ContentPlaceHolder1_AddGuestForm_rftxtGuestPeriod']");
	
	By guestemail = By.xpath("//input[@id='ContentPlaceHolder1_AddGuestForm_rftxtEmail']");
	
	By guestphone = By.xpath("//input[@id='ContentPlaceHolder1_AddGuestForm_rftxtWorkPhone']");
	
	By privacypolicy = By.xpath("//span[@dest='rfChkPrivacyPolicy']");
	
	By submit = By.xpath("//input[@id='ContentPlaceHolder1_AddGuestForm_btnSubmit']");
	
	By dulpicateinfo = By.xpath("//a[@title='Duplicate Guest Info']");
	
	//By continuebtn = By.xpath("//input[@id='ContentPlaceHolder1_btnContinue']");
	
	By addfamilymember = By.xpath("//a[@id='ContentPlaceHolder1_btnAddFamilymember']");
	
	By familyfirstname = By.xpath("//input[@id='ContentPlaceHolder1_AddFamilyMemberControl_FamilyForm_txtFirstName']");
	
	
	By homeph = By.xpath("//input[@id='ContentPlaceHolder1_AddFamilyMemberControl_FamilyForm_txtHomePh']");
	
	By familygender =  By.xpath("//tbody/tr[1]/td[1]/label[1]/span[1]/span[2]");
	
	By familyformsubmit = By.xpath("//input[@id='ContentPlaceHolder1_AddFamilyMemberControl_FamilyForm_btnSubmit']");
	
	
	//tbody/tr[1]/td[1]/label[1]/span[1]/span[2]male
	//tbody/tr[1]/td[2]/label[1]/span[1]/span[2]female
	
	
	public AddGuestPO(WebDriver driver) {
		this.driver = driver;
	}
	
   public WebElement getAddguestbtn() {
		
		return driver.findElement(Addguestbtn);
	
	}
   public WebElement getguestfirstname() {
	
	return driver.findElement(guestfirstname);

}
   public WebElement getguestlastname() {
		
	return driver.findElement(guestlastname);

}
   public WebElement getguesttitle() {
		
		return driver.findElement(guesttitle);

	}  
   public WebElement gettitledrop() {
		
		return driver.findElement(titledrop);

	}
   public WebElement getgenderbtn() {
		
		return driver.findElement(genderbtn);

	} 
   public WebElement getdateofbirthfield() {
		
 		return driver.findElement(dateofbirthfield);

 	}
   public WebElement getaddressfield() {
		
		return driver.findElement(addressfield);

	}
   public WebElement getcityfield() {
		
		return driver.findElement(cityfield);

	}
   public WebElement getzipcodefield() {
		
		return driver.findElement(zipcodefield);

	}
   public WebElement getguestpass() {
		
		return driver.findElement(guestpass);

	}
   public WebElement getguestemail() {
		
		return driver.findElement(guestemail);

	}
   public WebElement getguestphone() {
		
		return driver.findElement(guestphone);

	}
   public WebElement getprivacypolicy() {
		
		return driver.findElement(privacypolicy);

	}
   public WebElement getsubmit() {
		
		return driver.findElement(submit);

	}
   public WebElement getaddfamilymember() {
		
		return driver.findElement(addfamilymember);

	}
   public WebElement getfamilyfirstname() {
		
		return driver.findElement(familyfirstname);

	}
   public WebElement gethomeph() {
		
		return driver.findElement(homeph);

	}
   public WebElement getfamilygender() {
		
		return driver.findElement(familygender);

	}
   public WebElement getfamilyformsubmit() {
		
		return driver.findElement(familyformsubmit);

	}
 //  public WebElement getcontinuebtn() {
		
	//	return driver.findElement(continuebtn);

	//}
   
   
   
   public void guestinformation(String guestfirstname, String guestlastname, String dateofbirth, String addressfield, String cityname,
			String zipcode, String guestpass, String guestemail, String guestphone, String familyfirstname, String homeph ) throws  InterruptedException {
	   
	 
	   

		Actions act = new Actions(driver);
		

		getAddguestbtn().click();
		getguestfirstname().sendKeys(guestfirstname);
	    getguestlastname().sendKeys(guestlastname);
	    getguesttitle().click();
	    gettitledrop().click(); 
	    act.click();
	   getgenderbtn().click();
	   getdateofbirthfield().sendKeys(dateofbirth);
	   act.click();
	   getaddressfield().click();
	   getaddressfield().sendKeys(addressfield);
	   getcityfield().clear();
	   driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	   getcityfield().sendKeys(cityname);
	   getzipcodefield().clear();
	   getzipcodefield().sendKeys(zipcode);
	   act.sendKeys(Keys.PAGE_DOWN).click();
	   getguestpass().clear();
	   driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	   Thread.sleep(4000);
	   getguestpass().sendKeys(guestpass);
	   act.sendKeys(Keys.PAGE_DOWN).click();
	   Thread.sleep(4000);
	   getguestemail().click();
	   getguestemail().sendKeys(guestemail);
	   getguestphone().clear();
	   driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	   Thread.sleep(4000);
	   getguestphone().sendKeys(guestphone);
	   getprivacypolicy().click();
	   getsubmit().click();
	   
	   
	   List<WebElement> Continuebtn =  driver.findElements(By.xpath("//input[@id='ContentPlaceHolder1_btnContinue']"));
	   
	   
	 if(Continuebtn.size()>0)
	 { 
		 
		 Continuebtn.get(0).click();
		 
	  }
	   getaddfamilymember().click();
	   Thread.sleep(4000);
	   getfamilyfirstname().sendKeys(familyfirstname);
	   gethomeph().sendKeys(homeph);
	   getfamilygender().click();
	   
	   getprivacypolicy().click();
	   getfamilyformsubmit().click();
	   
	   
	   
	   
	   
				
	}
	   
   }

