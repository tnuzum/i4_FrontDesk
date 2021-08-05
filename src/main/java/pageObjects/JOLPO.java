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
	
	By clubfilter = By.xpath("(//div[@class='contentCenterFix leftMargin10'])[6]");
	
	By clubheader = By.xpath("//h2[contains(text(),'Executive Fitness Club')]");
	
	By clublocation = By.xpath("//h2[contains(text(),'Houston, TX')] ");
	
	By clubimage = By.xpath("//div[@class='span2 text-center']/img");
	
	By Viewplanslink = By.xpath("(//a[contains(text(), 'View Plans')])[6]");
	
	By vistedlink = By.xpath("(//a[contains(text(),'Have You Visited Us Before? ')])");
	
	By featuredplanslabel = By.xpath("(//div[@class='span12 text-center planHeader'])[2]");
	
	By selectplan = By.xpath("//h2[contains(text(),'!umas open ended plan')]");
	
	By continueplan = By.xpath("(//a[contains(text(),'Continue')])[9]");
	
	By changeplanlink = By.xpath("//a[contains(text(),'Change Plan')]");
	
	By planheader = By.xpath("//div[@class='span10 offset1 text-center allPlanText']/h1");
	
	By continuebtn = By.xpath("//a[contains(text(),'Continue')]");
	
	//production
	By Prod_viewplanslink = By.xpath("//a[@href='/JOL/Plans/605/1']");
	
	By Select_Familyplan = By.xpath("//h2[contains(text(),'Family Plan')]");
	
	By FamilyPlan_Continue = By.xpath("//a[@href='/JOL/PlanDetails/605/1/30/0']");
	
    By CCNofield = By.cssSelector("input#CCNo");
	
	By CCNamefield = By.cssSelector("input#CCName");
	
	By CCExpfield = By.cssSelector("input#CCExp");
	
	
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
   public WebElement getclubfilter() {
		
		return driver.findElement(clubfilter);
	
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
   public WebElement getViewplanslink() {
		
		return driver.findElement(Viewplanslink);
	
	}
 
   public WebElement getvistedlink() {
		
		return driver.findElement(vistedlink);
	
	}
   public WebElement getfeaturedplanslabel() {
		
		return driver.findElement(featuredplanslabel);
	
	}
   public WebElement getselectplan() {
		
		return driver.findElement(selectplan);
	
	}
   public WebElement getcontinueplan() {
		
		return driver.findElement(continueplan);
	
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
   
   //production
   public WebElement getProd_viewplanslink() {
		
 		return driver.findElement(Prod_viewplanslink);
 	
 	}
   public WebElement getSelect_Familyplan() {
		
 		return driver.findElement(Select_Familyplan);
 	
 	}
   public WebElement getFamilyPlan_Continue() {
		
 		return driver.findElement(FamilyPlan_Continue);
 	
 	}
   public WebElement getCCNofield() {
		
 		return driver.findElement(CCNofield);
 	
 	}
   public WebElement getCCNamefield() {
		
 		return driver.findElement(CCNamefield);
 	
 	}
   public WebElement getCCExpfield() {
		
 		return driver.findElement(CCExpfield);
 	
 	}

}
