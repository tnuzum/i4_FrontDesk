package FrontDesk;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pageObjects.ChangerequestPO;
import pageObjects.DashboardPO;
import pageObjects.LoginPO;
import pageObjects.Membermanager_takepaymentPO;
import resources.CustomActions;
import resources.base;
//import static org.openqa.selenium.support.locators.RelativeLocator.withTagName;

@Listeners(resources.Listeners.class)
public class Membermanager extends base {
	


private static String firstletter = "t";
private static String reason = "Updating Billing Info";
private static JavascriptExecutor jse;
private static String barcodeid = "WEB-104269";
private static String barcodeid2 = " WEB-104297 ";
	
public  SoftAssert softAssertion = new SoftAssert();	
	
	DashboardPO d;
	String clubBarcodeId;
	String clubPassword;
	

	LoginPO L;
	String BarcodeIDEmp;
	String PasswordEmp;
	
      
      String  Mccard, visacard, cardtype, cardexpmonthfield, cardexpyearfield;
      
      public CustomActions ca;
	
      public ChangerequestPO change;
      public Membermanager_takepaymentPO takepay;
      
      
      public Membermanager() {
  		ca =new CustomActions();
  		
  				
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
  		Mccard = prop.getProperty("Mccard");
		visacard = prop.getProperty("visacard");
		cardtype = prop.getProperty("cardtype");
		cardexpmonthfield = prop.getProperty("cardexpmonthfield");
		cardexpyearfield = prop.getProperty("cardexpyearfield");
		 jse = (JavascriptExecutor) driver;
  		
		 ca.LoginFD(clubBarcodeId,clubPassword,BarcodeIDEmp,PasswordEmp);
	     Thread.sleep(2000);
		 
  		}
  	
		@Test(enabled = true, priority = 1, description = "Member Management")
		public void memebermanager() throws Exception {

			takepay = new Membermanager_takepaymentPO(driver);

			Actions action = new Actions(driver);

			ca.Membermanagertab();

			String ActualTitle = driver.getTitle();
			System.out.println("Actual title is: " + ActualTitle);
			String ExpectedTitle = "Member Manager";
			Assert.assertEquals(ActualTitle, ExpectedTitle);
			System.out.println("Assert passed");

			takepay.getMemberbarcode().sendKeys(barcodeid);

			jse.executeScript("arguments[0].click();", takepay.getsearchAllClubsbtn());
			Thread.sleep(200);
			jse.executeScript("arguments[0].click();", takepay.getManagebtn());

			jse.executeScript("arguments[0].click();", takepay.getCheckInHistory());

			Assert.assertTrue(takepay.getCheckinTitle().isDisplayed());

			jse.executeScript("arguments[0].click();", takepay.getCheckinHistory_backbtn());

			Thread.sleep(200);
			jse.executeScript("arguments[0].click();", takepay.getFamilyMembers());
			jse.executeScript("arguments[0].click();", takepay.getFamilyTitle());
			Thread.sleep(200);
			System.out.println(takepay.getVerifyfamilyOf().getText());
			jse.executeScript("arguments[0].click();", takepay.getBackbtn());

			jse.executeScript("arguments[0].click();", takepay.getClasseslink());

			jse.executeScript("arguments[0].click();", takepay.getBackbtn());

		}

		@Test(enabled = true, priority = 2, description = "Make a payment using different card")
		public void memebermanager_takepayment() throws Exception {

			takepay = new Membermanager_takepaymentPO(driver);

			Actions action = new Actions(driver);

			ca.Membermanagertab();

			String ActualTitle = driver.getTitle();
			System.out.println("Actual title is: " + ActualTitle);
			String ExpectedTitle = "Member Manager";
			Assert.assertEquals(ActualTitle, ExpectedTitle);
			System.out.println("Assert passed");

			takepay.getMemberbarcode().sendKeys(barcodeid);

			jse.executeScript("arguments[0].click();", takepay.getsearchAllClubsbtn());
			Thread.sleep(200);
			jse.executeScript("arguments[0].click();", takepay.getManagebtn());
            Thread.sleep(2000);
			jse.executeScript("arguments[0].click();", takepay.getgetpaymentbtn());
			jse.executeScript("arguments[0].click();", takepay.getpaymentamount());
			takepay.getpaymentamount().clear();
			Thread.sleep(2000);
			takepay.getpaymentamount().sendKeys("1");
			Thread.sleep(2000);

			Select select1 = new Select(takepay.getddlcategory());
			select1.selectByVisibleText("Collections");

			// takepay.getemailreceipt().click();
			jse.executeScript("arguments[0].click();", takepay.getautoapplynextbtn());
			// takepay.getbtnokappliedpayment().click();
			action.sendKeys(Keys.PAGE_DOWN).click();
			action.sendKeys(Keys.CONTROL + "end" + Keys.CONTROL).perform();

			jse.executeScript("arguments[0].click();", takepay.getusediffcard());
			jse.executeScript("arguments[0].click();", takepay.getccpaymenttype());

			if (cardtype.equals("Visa")) {
				takepay.getccardvisa().click();
				takepay.getccardnumber().sendKeys(visacard);

			}
			if (cardtype.equals("Mc")) {
				takepay.getccardmc().click();
				takepay.getccardnumber().sendKeys(Mccard);

			}
			takepay.getccexpmonth().sendKeys(cardexpmonthfield);
			takepay.getccexpyear().sendKeys(cardexpyearfield);
			jse.executeScript("arguments[0].click();", takepay.getmakepaymentbtn());
			Thread.sleep(2000);
			jse.executeScript("arguments[0].click();", takepay.getconfirmbtn());
			jse.executeScript("arguments[0].click();", takepay.getupdateokbtn());

			jse.executeScript("arguments[0].click();", takepay.getdonebtn());

		}

		@Test(enabled = true, priority = 3, groups = {
				"Regression" }, description = "Make a payment using card on File")
		public void memebermanager_takepayment_Cardonfile() throws Exception {

			takepay = new Membermanager_takepaymentPO(driver);

			// Actions action = new Actions(driver);

			ca.Membermanagertab();

			String ActualTitle = driver.getTitle();
			System.out.println("Actual title is: " + ActualTitle);
			String ExpectedTitle = "Member Manager";
			Assert.assertEquals(ActualTitle, ExpectedTitle);
			System.out.println("Assert passed");

			takepay.getMemberbarcode().sendKeys(barcodeid2);

			jse.executeScript("arguments[0].click();", takepay.getsearchAllClubsbtn());
			jse.executeScript("arguments[0].click();", takepay.getManagebtn());
			jse.executeScript("arguments[0].click();", takepay.getgetpaymentbtn());
			jse.executeScript("arguments[0].click();", takepay.getpaymentamount());
			takepay.getpaymentamount().clear();
			Thread.sleep(2000);
			takepay.getpaymentamount().sendKeys("1.10");
			Thread.sleep(2000);

			Select selectcategory = new Select(takepay.getddlcategory());

			selectcategory.selectByVisibleText("Collections");

			// takepay.getemailreceipt().click();
			jse.executeScript("arguments[0].click();", takepay.getautoapplynextbtn());

			Actions action = new Actions(driver);
			jse.executeScript("arguments[0].click();", takepay.getmakepaymentbtn());

			action.sendKeys(Keys.PAGE_DOWN).perform();
			action.sendKeys(Keys.CONTROL + "end" + Keys.CONTROL).perform();
			Thread.sleep(2000);
			jse.executeScript("arguments[0].click();", takepay.getconfirmbtn());
			jse.executeScript("arguments[0].click();", takepay.getupdateokbtn());
			jse.executeScript("arguments[0].click();", takepay.getupdateokbtn());
			jse.executeScript("arguments[0].click();", takepay.getdonebtn());

		}
  
  @Test(enabled = true, priority = 4, description = "Change request")
	
	public void changerequest() throws Exception{
		
		
		
	    change = new ChangerequestPO(driver);
	    
	    Actions action = new Actions(driver);
	 	
	   ca.Membermanagertab();
	    
	   
		//change.getmembermanager().click();
			 
		change.getMemberbarcode().sendKeys(barcodeid);
			 
	
		jse.executeScript("arguments[0].click();",change.getsearchAllClubsbtn());
			 
		jse.executeScript("arguments[0].click();",change.getManagebtn());
			 
		jse.executeScript("arguments[0].click();",change.getchangerequest());
		Assert.assertTrue(change.getChangerequestTitle().isDisplayed());
			 
		jse.executeScript("arguments[0].click();",change.getbillinginfobtn());
			 
		jse.executeScript("arguments[0].click();",change.getcreditcardbtn());
			 
		jse.executeScript("arguments[0].click();",change.getselectcardtype());
			 
		
		if(cardtype.equals("Mc")) {
					
				
				change.getmastercard().click();
				change.getccardnumber().clear();
				change.getccardnumber().sendKeys(Mccard);
				 
				 action.sendKeys(Keys.PAGE_DOWN).perform();
				 action.sendKeys(Keys.PAGE_DOWN).perform();
			
				}
			 
		if(cardtype.equals("Visa")) {
				 
				 change.getvisacard().click();
				 change.getccardnumber().clear();
				 change.getccardnumber().sendKeys(visacard);
				 action.sendKeys(Keys.PAGE_DOWN).perform();
				 action.sendKeys(Keys.PAGE_DOWN).perform();
				 	 					  
			 }
			 change.getccexpmonth().sendKeys(cardexpmonthfield);
			change.getccexpyear().sendKeys(cardexpyearfield);
			change.getreasonfield().sendKeys(reason);
			change.getsubmitbtn().click();
			jse.executeScript("arguments[0].click();",change.getsubmitbtn());
			 
		 }
		
	@AfterClass (enabled =true)
	public void teardown() {

		driver.close();
		driver.quit();
		driver = null;
	}
		
		
}

