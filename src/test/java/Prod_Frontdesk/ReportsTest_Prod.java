package Prod_Frontdesk;

import java.util.Iterator;
import java.util.Set;

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
import pageObjects.ReportsPO;
import resources.CustomActions;
import resources.base;

@Listeners(resources.Listeners.class)
public class ReportsTest_Prod extends base {

	
	private static JavascriptExecutor jse;

	public SoftAssert softAssertion = new SoftAssert();

	public CustomActions ca;
	public ReportsPO report;
	
	DashboardPO d;
	String clubBarcodeId;
	String clubPassword;
	

	LoginPO L;
	String BarcodeIDEmp;
	String PasswordEmp;
	
      
    
	public ReportsTest_Prod() {
		ca = new CustomActions();

		String classname = this.getClass().getSimpleName();
		System.out.println("classname :" + classname);
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
		
		 ca.LoginFD(clubBarcodeId,clubPassword,BarcodeIDEmp,PasswordEmp);
	     Thread.sleep(2000);
	     
	     report = new ReportsPO(driver);

	    jse.executeScript("arguments[0].click();",  report.getReportslnk());
    }
    
	@Test(enabled = true, priority = 1, description = "Daily business Report_CheckIn By Date")
	public void CheckInByDate() throws Exception {

	
		//Assert.assertEquals("Web Reports" ,report.getpageTitle().getText());
		jse.executeScript("arguments[0].click();", report.getDailybusinessmodule());
		Thread.sleep(200);
		Assert.assertEquals("Daily Business Report",report.getdailybusinessReport_PageHeader().getText());
		
		jse.executeScript("arguments[0].click();",report.getSelect_CheckInbyDate());
		
		Assert.assertEquals("Check In by date",report.getverifyReportText().getText());
		Assert.assertTrue(report.getCalenderbtn().isDisplayed());
		jse.executeScript("arguments[0].click();", report.getViewReportbtn());
		
		Thread.sleep(2000);
		Set<String> handles = driver.getWindowHandles();//get the all the open windows 
		Thread.sleep(2000);
		System.out.println(handles);
				Iterator<String> it = handles.iterator();
				Thread.sleep(2000);
				String parentwindowid = it.next();
				String childwindowid = it.next();
             
				
				
		driver.switchTo().window(childwindowid).manage().window().maximize();
		Thread.sleep(200);
		int size = driver.findElements(By.tagName("iframe")).size();
		System.out.println(size);
		Thread.sleep(2000);
		System.out.println("Report title: "+driver.switchTo().frame(0).getTitle());
		Assert.assertTrue(driver.findElement(By.xpath("//*[@id='Text13']/p[1]/span/span")).isDisplayed());
		System.out.println("Report name and date:  "+driver.findElement(By.xpath("//*[@id='Text13']/p[1]/span/span")).getText());
		Thread.sleep(2000);
		driver.switchTo().window(childwindowid).close();	
	
		
		driver.switchTo().window(parentwindowid);
		
		jse.executeScript("arguments[0].click();", report.getBacktoList());
		
		System.out.println("*-----------------------------------------------*");
		
		
	}
	@AfterClass(enabled =true)
	public void teardown() {

		driver.close();
		driver.quit();
		driver = null;
	}
	
}
