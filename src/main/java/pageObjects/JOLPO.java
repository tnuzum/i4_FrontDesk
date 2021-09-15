package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import resources.base;

public class JOLPO extends base {
	
	

	public WebDriver driver;
	
	
	By pageheader = By.xpath("//h1[contains(text(),'Select A Gym ')]");
	
	By Selectcityheader = By.xpath("//div[@class='selectCity contentCenterFix'] ");
	
	By selectcity = By.xpath("//Select[@id='ddlFilter']");
	
	By clubheader = By.xpath("//h2[contains(text(),'Executive Fitness Club')]");
	
	By clublocation = By.xpath("//h2[contains(text(),'Houston, TX')] ");
	
	By clubimage = By.xpath("//div[@class='span2 text-center']/img");
	
	By vistedlink = By.xpath("(//a[contains(text(),'Have You Visited Us Before? ')])");
	
	By featuredplanslabel = By.xpath("//h1[contains(text(),'Featured Plans')]");
	
	By changeplanlink = By.xpath("//a[contains(text(),'Change Plan')]");
	
	By planheader = By.tagName("h1");
	
	By continuebtn = By.xpath("//a[contains(text(),'Continue')]");
	
	By ViewAllPlans = By.xpath("//h1[contains(text(),'View All Plans')]");
	
	//member information
	By backbtn = By.xpath("//a[contains(text(),'Back')]");
	
	By Firstnamefield = By.cssSelector("input#firstName");
	
	By Lastnamefield = By.cssSelector("input#lastName");
	
	By Address1field = By.cssSelector("input#address1");
	
	By Cityfield = By.cssSelector("input#city");
	
	By Statefield = By.cssSelector("input#state");
	
	By Zipfield = By.cssSelector("input#zipCode");
	
	By Emailfield = By.cssSelector("input#email");
	
	By DateofBirthfield = By.cssSelector("input#MemberInfo_DOB");
	
	By DownCCNofield = By.cssSelector("input#downCCNo");
	
	By DownCCNamefield = By.cssSelector("input#downCCName");
	
	By DownCCExpfield = By.cssSelector("input#downCCExp");
	
	By DownCCCVVfield = By.cssSelector("input#downCCCVV");
	
	By sameasdownpayment = By.cssSelector("input#creditcardcheck");
	
	By ReviewAndConfirmlink = By.xpath("//a[@class='submitForm']");
	
	By confirmdetailsheader = By.xpath("//h1[contains(text(),'Confirm Details')]");
	
	By Accepttermscheckbox = By.xpath("//input[@type='checkbox']");
	
	By clicktoConfirm = By.cssSelector("a#btnClickToConfirm");
	
	
	
	By startoverlink =By.xpath("//a[contains(text(),'Start Over')]");
	
	
	
	public JOLPO(WebDriver driver) {
		this.driver = driver;
	}
	
   public WebElement getpageheader() {
		
		return driver.findElement(pageheader);
	
	}
   public WebElement getSelectcityheader() {
		
		return driver.findElement(Selectcityheader);
	
	}

   public WebElement getselectcity() {
		
		return driver.findElement(selectcity);
	
	}
   public WebElement getclubheader() {
		
		return driver.findElement(clubheader);
	
	}
   public WebElement getclublocation() {
		
		return driver.findElement(clublocation);
	
	}
   public WebElement getclubimage() {
		
		return driver.findElement(clubimage);
	
	}
  
   public WebElement getvistedlink() {
		
		return driver.findElement(vistedlink);
	
	}
   public WebElement getfeaturedplanslabel() {
		
		return driver.findElement(featuredplanslabel);
	
	}
   public WebElement getViewAllPlans() {
		
 		return driver.findElement(ViewAllPlans);
 	
 	}

   public WebElement getchangeplanlink() {
		
		return driver.findElement(changeplanlink);
	
	}
   public WebElement getplanheader() {
		
		return driver.findElement(planheader);
	
	}
   public WebElement getcontinuebtn() {
		
		return driver.findElement(continuebtn);
	
	}
   
   
   public WebElement getbackbtn() {
		
 		return driver.findElement(backbtn);
 	
 	}
   
   public WebElement getFirstnamefield() {
		
		return driver.findElement(Firstnamefield);
	
	}
   public WebElement getLastnamefield() {
		
		return driver.findElement(Lastnamefield);
	
	}
   public WebElement getAddress1field() {
		
		return driver.findElement(Address1field);
	
	}
   public WebElement getCityfield() {
		
		return driver.findElement(Cityfield);
	
	}
   public WebElement getStatefield() {
		
		return driver.findElement(Statefield);
	
	}
   public WebElement getZipfield() {
		
		return driver.findElement(Zipfield);
	
	}
   public WebElement getEmailfield() {
		
		return driver.findElement(Emailfield);
	
	}
   public WebElement getDateofBirthfield() {
		
		return driver.findElement(DateofBirthfield);
	
	}
   public WebElement getDownCCNofield() {
		
		return driver.findElement(DownCCNofield);
	
	}
   public WebElement getDownCCNamefield() {
		
		return driver.findElement(DownCCNamefield);
	
	}
   public WebElement getDownCCExpfield() {
		
		return driver.findElement(DownCCExpfield);
	
	}
   public WebElement getDownCCCVVfield() {
		
		return driver.findElement(DownCCCVVfield);
	
	}
   public WebElement getsameasdownpayment() {
		
		return driver.findElement(sameasdownpayment);
	
	}
   public WebElement getReviewAndConfirmlink() {
		
		return driver.findElement(ReviewAndConfirmlink);
	
	}
   public WebElement getconfirmdetailsheader() {
		
		return driver.findElement(confirmdetailsheader);
	
	}
   public WebElement getAccepttermscheckbox() {
		
		return driver.findElement(Accepttermscheckbox);
	
	}
   public WebElement getclicktoConfirm() {
		
		return driver.findElement(clicktoConfirm);
	
	}
   public WebElement getstartoverlink() {
		
 		return driver.findElement(startoverlink);
 	
 	}
   


}
