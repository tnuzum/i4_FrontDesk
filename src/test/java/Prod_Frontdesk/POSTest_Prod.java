package Prod_Frontdesk;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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

public class POSTest_Prod extends base {
	private static JavascriptExecutor jse;
	
	public SoftAssert softAssertion = new SoftAssert();
	
	DashboardPO d;
	String clubBarcodeId;
	String clubPassword;
	

	LoginPO L;
	String BarcodeIDEmp;
	String PasswordEmp;
	public CustomActions ca;
	
	String creditcard, cardholdername, barcodeid1;
	String  cvvnum;
	
 
	
	public POSPO po;
	
	
	public POSTest_Prod() {
		ca =new CustomActions();
		
				
	}
	@BeforeClass
	public void initialize() throws Exception {
		driver = initializeDriver();
		ca.setDriver(driver);
		
		driver.get(prop.getProperty("ProcClubLoginpage"));
		d = new DashboardPO(driver);
		clubBarcodeId = prop.getProperty("ClubUserName");
		clubPassword = prop.getProperty("ClubPassword1");
		
		//driver - initializeDriver();
		//driver.get(prop.getProperty("EmpLoginPage"));
		
		L = new LoginPO(driver);
		BarcodeIDEmp = prop.getProperty("EmpUserName");
		PasswordEmp = prop.getProperty("EmpPassword1");
		
		 jse = (JavascriptExecutor) driver;
		
		barcodeid1 = prop.getProperty("barcodeid1");
	   
		
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
			po.getbarcodeid().sendKeys(barcodeid1);
			jse.executeScript("arguments[0].click();", po.getsearchbtn());
			jse.executeScript("arguments[0].click();", po.getselectmemberbtn());
			jse.executeScript("arguments[0].click();", po.getitemBarcode1());
			Assert.assertEquals("Item ID Lookup", driver.findElement(By.xpath("//a[@title='Item ID Lookup']")).getText());
			jse.executeScript("arguments[0].click();", po.getinventorybtn());
			jse.executeScript("arguments[0].click();", po.getitemsearch());
			jse.executeScript("arguments[0].click();", po.getprod$1itemselect());
			jse.executeScript("arguments[0].click();", po.getproceedBtn());

			Assert.assertEquals("Total Invoice", driver.findElement(By.xpath("//a[@title='Total Invoice']")).getText());
			jse.executeScript("arguments[0].click();", po.getcashbtn());
			Assert.assertEquals("Payment", driver.findElement(By.xpath("//a[@title='Payment']")).getText());
			jse.executeScript("arguments[0].click();", po.getprocessPayment1());
			jse.executeScript("arguments[0].click();", po.gethistory());
			jse.executeScript("arguments[0].click();", po.getclosehistory());

		}
	@AfterClass(enabled =true)
	public void teardown() {

		driver.close();
		driver.quit();
		driver = null;
	}

}
