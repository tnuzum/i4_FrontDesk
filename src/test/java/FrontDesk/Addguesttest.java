package FrontDesk;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;


import pageObjects.AddGuestPO;
import pageObjects.DashboardPO;
import pageObjects.LoginPO;
import resources.CustomActions;
import resources.base;

public class Addguesttest extends base {

	private static String guestfirstname = "Autote3";
	private static String guestlastname = "test1234";
	private static String dateofbirth = "10/05/1990";
	private static String addressfield = "Southpark";
	private static String cityname = "Halifax";
	private static String zipcode = "M1K2N6";
	private static String guestpass = "3";
	private static String guestemail = "autotest12@gmail.com";
	private static String guestphone = "6478529856";
	private static String familyfirstname = "Test121222";
	private static String homeph = "9856412375";
	private static JavascriptExecutor jse;

	public SoftAssert softAssertion = new SoftAssert();

	
	  DashboardPO d; String clubBarcodeId; String clubPassword;
	  
	  
	  LoginPO L; String BarcodeIDEmp; String PasswordEmp;
	 
	 public CustomActions ca;
	 public AddGuestPO gus;

	 public Addguesttest() {
		ca = new CustomActions();

		String classname = this.getClass().getSimpleName();
		System.out.println("classname :" + classname);
	}
	
	 
	  
	 @BeforeClass
		public void initialize() throws Exception {
			driver = initializeDriver();
			ca.setDriver(driver);
			
			driver.get(prop.getProperty("clubLoginPage"));

			d = new DashboardPO(driver);
			clubBarcodeId = prop.getProperty("clubBarcodeId");
			clubPassword = prop.getProperty("clubPassword");
			
			//driver - initializeDriver();
			//driver.get(prop.getProperty("EmpLoginPage"));
			
			L = new LoginPO(driver);
			BarcodeIDEmp = prop.getProperty("EmpBarcodeID");
			PasswordEmp = prop.getProperty("EmpPassword");
		
			jse = (JavascriptExecutor) driver;
			
			ca.LoginFD(clubBarcodeId,clubPassword,BarcodeIDEmp,PasswordEmp);
			Thread.sleep(2000);
					
			}
	 
 
	@Test(priority = 1, description = "Add guest")

	public void addguest() throws Exception {
	
  
		
		gus = new AddGuestPO(driver);

	
		Actions act = new Actions(driver);
		
		Thread.sleep(2000);
		Assert.assertEquals(driver.getTitle(), "Member Manager");
	 
        jse.executeScript("arguments[0].click();",gus.getAddguestbtn());
        
      String expectedtitle = driver.findElement(By.xpath("//a[@title='Add Guest Home']")).getText();//span[@id='lbltitle']
      System.out.println(expectedtitle);
        
	   Assert.assertEquals(expectedtitle, "Add Guest Home");
	  
		
		gus.getguestfirstname().sendKeys(guestfirstname);
		gus.getguestlastname().sendKeys(guestlastname);
	
		Select s = new Select(gus.getguesttitle());
		
		s.selectByVisibleText("Mr.");
		
		jse.executeScript("arguments[0].click();",gus.getguesttitle());
	    act.click();
	//	jse.executeScript("arguments[0].click();",gus.gettitledrop());
		act.click();
		Thread.sleep(2000);		
		 jse.executeScript("arguments[0].click();",gus.getgenderbtn());
		
		gus.getdateofbirthfield().sendKeys(dateofbirth);
		act.click();
		gus.getaddressfield().sendKeys(addressfield);
		gus.getcityfield().clear();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		gus.getcityfield().sendKeys(cityname);
		gus.getzipcodefield().clear();
		gus.getzipcodefield().sendKeys(zipcode);
		act.sendKeys(Keys.PAGE_DOWN).click();
		gus.getguestpass().clear();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		Thread.sleep(2000);
		gus.getguestpass().sendKeys(guestpass);
		act.sendKeys(Keys.PAGE_DOWN).click();
		Thread.sleep(4000);
		gus.getguestemail().click();

		gus.getguestemail().sendKeys(guestemail);
		gus.getguestphone().clear();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		Thread.sleep(2000);
		gus.getguestphone().sendKeys(guestphone);
		jse.executeScript("arguments[0].click();",gus.getprivacypolicy());
		jse.executeScript("arguments[0].click();",gus.getsubmit());

//		List<WebElement> Continuebtn = driver.findElements(By.xpath("//input[@id='ContentPlaceHolder1_btnContinue']"));
//
//		if (Continuebtn.size() > 0) {
//
//			 jse.executeScript("arguments[0].click();",Continuebtn.get(0));
//
//		}
//
//		String ActualTitle1 = driver.findElement(By.id("ContentPlaceHolder1_lblmessaage")).getText();
//		System.out.println( "Actualtitle is :" + ActualTitle1);
//	//	System.out.println("Guest firstname is "+guestfirstname );
//	//	System.out.println("Guest firstname is "+guestlastname );
//		String ExpectedTitle1 = guestfirstname+" " +guestlastname+" " +"is added.";
//		System.out.println( "Expectedtitle is :" + ExpectedTitle1);
//		Assert.assertEquals(ActualTitle1, ExpectedTitle1);
//		
//		
//	//	ca.takescreenshot();
//		jse.executeScript("arguments[0].click();",gus.getaddfamilymember());
//		Thread.sleep(2000);
//		gus.getfamilyfirstname().sendKeys(familyfirstname);
//		gus.gethomeph().sendKeys(homeph);
//		jse.executeScript("arguments[0].click();",gus.getfamilygender());
//
//		jse.executeScript("arguments[0].click();",gus.getprivacypolicy());
//		jse.executeScript("arguments[0].click();",gus.getfamilyformsubmit());
//		
			

	}

	@AfterClass(enabled =false)
	public void teardown() {

		driver.close();
		driver = null;
	}

}
