package FrontDesk;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pageObjects.DashboardPO;
import resources.CustomActions;
import resources.base;

import pageObjects.LoginPO;

public class LoginPageTest extends base {

	public SoftAssert softAssertion = new SoftAssert();

	DashboardPO d;
	String clubBarcodeId;
	String clubPassword;
	
	LoginPO L;
	String BarcodeIDEmp;
	String PasswordEmp;
	public CustomActions ca;
	public LoginPageTest() {
	ca = new CustomActions();
	
	
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

	@Test(priority = 1, description = "Validate Page Title")
	public void pageTitle() {

		Assert.assertEquals(driver.getTitle(), "i4: Front Desk");
	}

	@Test(priority = 2, description = "Login To Front Desk")
	public void login() throws InterruptedException {

	//d.getFrontDeskButton().click();
	//	Thread.sleep(2000);
		ca.loginClub(clubBarcodeId, clubPassword);
		Thread.sleep(2000);
		ca.loginEmp(BarcodeIDEmp,PasswordEmp);
		
//			softAssertion.assertEquals(d.getpasswordRequiredMessage().getText(), "Password is required");
//			softAssertion.assertAll();
	}

	@AfterTest (enabled =false)
	public void teardown() {

		driver.close();
		driver = null;
	}

}
