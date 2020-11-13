package FrontDesk;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pageObjects.DashboardPO;
import pageObjects.LoginPO;
import resources.CustomActions;
import resources.base;

public class POS extends base {
	public SoftAssert softAssertion = new SoftAssert();
	
	DashboardPO d;
	String clubBarcodeId;
	String clubPassword;
	

	LoginPO L;
	String BarcodeIDEmp;
	String PasswordEmp;
	public CustomActions ca;
	
	public POS() {
		ca =new CustomActions();
	}
	@BeforeTest
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
		
				
		}
		@Test (priority = 1)
		public void POSTest() throws InterruptedException {
		ca.LoginFD(clubBarcodeId,clubPassword,BarcodeIDEmp,PasswordEmp);
		Thread.sleep(2000);
		ca.POSTab();
		Thread.sleep(2000);
		ca.itemBarcode();
		Thread.sleep(2000);
		ca.itemBarcodeSearch();
		ca.itemSelect();
		ca.proceedBtn();
		ca.cash1();
		ca.processPayment();
		}

		
		
		
		
	}


	


