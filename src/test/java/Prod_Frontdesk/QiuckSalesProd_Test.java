package Prod_Frontdesk;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pageObjects.DashboardPO;
import pageObjects.LoginPO;
import pageObjects.Membermanager_takepaymentPO;
import pageObjects.QuickSalesPO;
import resources.CustomActions;
import resources.base;

public class QiuckSalesProd_Test extends base {
	
	private static JavascriptExecutor jse;
	
	public WebDriver driver;

	public SoftAssert softAssertion = new SoftAssert();

	DashboardPO d;
	String clubBarcodeId;
	String clubPassword;

	LoginPO L;
	String BarcodeIDEmp;
	String PasswordEmp;

	public QuickSalesPO quicksale;
	public CustomActions ca;
	

	public QiuckSalesProd_Test() {
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

		
		quicksale = new QuickSalesPO(driver);
		Assert.assertEquals(driver.getTitle(), "Member Manager");
		jse.executeScript("arguments[0].click();", quicksale.getquicksalebtn());
	}

	
	@Test(priority = 1)
	public void QuickSales_Pagenavigation() throws Exception {
		
		//Assert.assertEquals(driver.findElement(By.xpath("//a[contains(text(),'Quick Sales')]")),"Quick Sales");
		Thread.sleep(1000);
		Assert.assertTrue(driver.findElement(By.xpath("//h3[@class='tile-title']")).getText().contains("New Contract"));
		
		jse.executeScript("arguments[0].click();", quicksale.getnewContract1());
		Assert.assertTrue(quicksale.getSearchplanTitle().getText().contains("Search Plans"));
		Assert.assertTrue(quicksale.getSelectplanTitle().getText().contains("1. Select Plan"));
		jse.executeScript("arguments[0].click();", quicksale.getnewmemberbtn());
		Thread.sleep(1000);
		
		Assert.assertTrue(quicksale.getrequiredFieldsTitle().getText().contains("Required Fields"));
		jse.executeScript("arguments[0].click();", quicksale.gethomebtn());
	}
	
	@AfterClass(enabled = true)
	public void teardown() {

		driver.close();
		driver = null;
	}
}
