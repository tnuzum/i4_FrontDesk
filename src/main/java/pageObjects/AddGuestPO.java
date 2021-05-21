package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AddGuestPO {
	
	public WebDriver driver;
	
	
	By Addguestbtn = By.xpath("//a[@id='lnkAddGuest']");
	
	//By Addguestbtn = By.id("lnkAddGuest");
	
	By guestfirstname = By.xpath("//input[@id='ContentPlaceHolder1_AddGuestForm_rftxtFirstName']");
	
	By guestlastname = By.xpath("//input[@id='ContentPlaceHolder1_AddGuestForm_rftxtLastName']");
	
	By guesttitle = By.xpath("//*[@id='ContentPlaceHolder1_AddGuestForm_rfddlTitle']");
	
	//By titledrop = By.xpath("//option[contains(text(),'Mr.')]");
	
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
 //  public WebElement gettitledrop() {
		
//		return driver.findElement(titledrop);

//	}
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
   
   
   

	   
   }

