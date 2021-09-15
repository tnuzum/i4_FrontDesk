package FrontDesk;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
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

import pageObjects.DashboardPO;
import pageObjects.LoginPO;
import pageObjects.POSPO;
import resources.CustomActions;
import resources.base;

@Listeners(resources.Listeners.class)

public class POS_Test extends base {
	
	private static JavascriptExecutor jse;
	private static String couponrefference = "4568";
	private static String productBarcode = "14063454";
	public SoftAssert softAssertion = new SoftAssert();
	
	DashboardPO d;
	String clubBarcodeId;
	String clubPassword;
	

	LoginPO L;
	String BarcodeIDEmp;
	String PasswordEmp;
	public CustomActions ca;
	
	String creditcard, cardholdername, barcodeid;
	String  cvvnum;
	
 
	
	public POSPO po;
	
	
	public POS_Test() {
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
		jse = (JavascriptExecutor) driver;
		
		barcodeid = prop.getProperty("barcodeid");
	    cvvnum = prop.getProperty("cvvnum");
		   
	    creditcard = prop.getProperty("Mccard");
	    
	    cardholdername = prop.getProperty("cardholdername");
		
		 ca.LoginFD(clubBarcodeId,clubPassword,BarcodeIDEmp,PasswordEmp);
		Thread.sleep(2000);
				
	}

	@Test(priority = 1, enabled = true, description = "POSTest paymentwith Cash")
	public void POSTest_Paymentwith_cash() throws InterruptedException {
		po = new POSPO(driver);

		Assert.assertEquals(driver.getTitle(), "Member Manager");

		ca.POSTab();

		String expectedtitle = driver.findElement(By.xpath("//a[@title='Point Of Sale']")).getText();
		System.out.println(expectedtitle);

		Assert.assertEquals(expectedtitle, "Point Of Sale");

		Thread.sleep(2000);

		jse.executeScript("arguments[0].click();", po.getmemberbarcode());
		Thread.sleep(2000);
		Assert.assertEquals(driver.findElement(By.xpath("//a[@title='Barcode ID Lookup']")).getText(),"Barcode ID Lookup");
		jse.executeScript("arguments[0].click();", po.getbarcodeid());
		po.getbarcodeid().sendKeys(barcodeid);
		jse.executeScript("arguments[0].click();", po.getsearchbtn());
		jse.executeScript("arguments[0].click();", po.getselectmemberbtn());
		jse.executeScript("arguments[0].click();", po.getitemBarcode1());
		Assert.assertEquals("Item ID Lookup", driver.findElement(By.xpath("//a[@title='Item ID Lookup']")).getText());
		jse.executeScript("arguments[0].click();", po.getinventorybtn());
		po.getitembarcode().sendKeys(productBarcode);
		jse.executeScript("arguments[0].click();", po.getitemsearch());
		jse.executeScript("arguments[0].click();", po.getitemSelect());
		jse.executeScript("arguments[0].click();", po.getproceedBtn());
		Assert.assertEquals("Total Invoice", driver.findElement(By.xpath("//a[@title='Total Invoice']")).getText());

		jse.executeScript("arguments[0].click();", po.getcashbtn());
		Assert.assertEquals("Payment", driver.findElement(By.xpath("//a[@title='Payment']")).getText());
		jse.executeScript("arguments[0].click();", po.getprocessPayment1());
		jse.executeScript("arguments[0].click();", po.gethistory());
		jse.executeScript("arguments[0].click();", po.getclosehistory());

	}
	
		@Test (priority = 3, enabled = false, description = "POSTest paymentwith Creditcard" )
		public void POSTest_paymentwith_Creditcard() throws InterruptedException {
	    po = new POSPO(driver);
	   
	    
		
		ca.POSTab();
		Thread.sleep(2000);
		
		String Expectedtitle = driver.findElement(By.xpath("//a[@title='Point Of Sale']")).getText();
	      System.out.println(Expectedtitle);
	        
		   Assert.assertEquals(Expectedtitle, "Point Of Sale");
		
		jse.executeScript("arguments[0].click();",po.getmemberbarcode());
		Thread.sleep(2000);
		jse.executeScript("arguments[0].click();",po.getbarcodeid());
		po.getbarcodeid().sendKeys(barcodeid);
		
		jse.executeScript("arguments[0].click();",po.getsearchbtn());
		jse.executeScript("arguments[0].click();",po.getselectmemberbtn());
		jse.executeScript("arguments[0].click();",po.getitemBarcode1());
		jse.executeScript("arguments[0].click();",po.getinventorybtn());
		jse.executeScript("arguments[0].click();",po.getitemsearch());
		jse.executeScript("arguments[0].click();",po.getitemSelect());
		jse.executeScript("arguments[0].click();",po.getproceedBtn());
		
	

			jse.executeScript("arguments[0].click();",po.getmastercard());

			String s1 = driver.findElement(By.className("modal-content")).getText();
			// System.out.println(s1);
			String s2 = driver.findElement(By.className("modal-body")).getText();
			// System.out.println(s2);

			//po.getcardholdername().sendKeys();
			po.getcardnumber().clear();
			po.getcardnumber().sendKeys(creditcard);
			
			Select selectmonth = new Select(po.getexpirymonth());

			selectmonth.selectByVisibleText("12");
			
			Select selectyear = new Select(po.getexpiryyear());
			selectyear.selectByVisibleText("2023");
			
			po.getcvv().sendKeys(cvvnum);
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			
			
			
			Actions action = new Actions(driver);
			
			action.sendKeys(Keys.TAB).build().perform();
			action.sendKeys(Keys.TAB).build().perform();
			action.sendKeys(Keys.TAB).build().perform();
			action.sendKeys(Keys.TAB).build().perform();
			action.sendKeys(Keys.TAB).build().perform();
			action.sendKeys(Keys.TAB).build().perform();
			
			Thread.sleep(2000);
			
			//po.getsubmitbtn().click();
			//jse.executeScript("arguments[0].click();",po.getsubmitbtn());
			//action.moveToElement(po.getsubmitbtn()).click().perform();
			//new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@id='ContentPlaceHolder1_ucAcceptCCPayment_lnkSubmit']"))).click();
			po.getsubmitbtn().sendKeys(Keys.ENTER);
			
			
			
		
		}
		
		@Test (priority = 2, enabled=true, description = "POSTest paymentwith Coupon" )
		public void POSTest_Paymentwith_coupon() throws InterruptedException {
	    po = new POSPO(driver);
	  
	    
		ca.POSTab();
		Thread.sleep(2000);
		
		jse.executeScript("arguments[0].click();",po.getmemberbarcode());
		Thread.sleep(2000);
		jse.executeScript("arguments[0].click();",po.getbarcodeid());
		po.getbarcodeid().sendKeys(barcodeid);
		jse.executeScript("arguments[0].click();",po.getsearchbtn());
		jse.executeScript("arguments[0].click();",po.getselectmemberbtn());
		jse.executeScript("arguments[0].click();",po.getitemBarcode1());
		jse.executeScript("arguments[0].click();",po.getinventorybtn());
		po.getitembarcode().sendKeys(productBarcode);
		jse.executeScript("arguments[0].click();",po.getitemsearch());
		jse.executeScript("arguments[0].click();",po.getitemSelect());
		jse.executeScript("arguments[0].click();",po.getproceedBtn());
		
			jse.executeScript("arguments[0].click();",po.getcoupon());
			po.getcouponrefference().sendKeys(couponrefference);
			jse.executeScript("arguments[0].click();",po.getprocessPayment1());
			jse.executeScript("arguments[0].click();",po.gethistory());
			jse.executeScript("arguments[0].click();",po.getclosehistory());

	
		}
	
		



		@AfterClass(enabled =true)
		public void teardown() {

			driver.quit();
			driver = null;
		}
		
				
		}

		
		
		
		
	


	


