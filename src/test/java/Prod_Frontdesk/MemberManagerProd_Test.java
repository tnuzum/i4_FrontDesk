package Prod_Frontdesk;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pageObjects.DashboardPO;
import pageObjects.LoginPO;
import pageObjects.Membermanager_takepaymentPO;
import resources.CustomActions;
import resources.base;

@Listeners(resources.Listeners.class)

public class MemberManagerProd_Test extends base {
	
	private static JavascriptExecutor jse;
	private static String memberbarcode = "WEB-101132";
	public WebDriver driver;

	public SoftAssert softAssertion = new SoftAssert();

	DashboardPO d;
	String clubBarcodeId;
	String clubPassword;

	LoginPO L;
	String BarcodeIDEmp;
	String PasswordEmp;

	
	public CustomActions ca;
	public Membermanager_takepaymentPO takepay;

	public MemberManagerProd_Test() {
		ca = new CustomActions();

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
		

		ca.LoginFD(clubBarcodeId, clubPassword, BarcodeIDEmp, PasswordEmp);
		Thread.sleep(2000);

		Assert.assertEquals(driver.getTitle(), "Member Manager");

		

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

		takepay.getMemberbarcode().sendKeys(memberbarcode);

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

	
	@AfterClass(enabled = true)
	public void teardown() {

		driver.close();
		driver = null;
	}

}
