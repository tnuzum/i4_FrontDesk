package FrontDesk;

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

public class ReportTest extends base {
	
	

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
	
      
    
	public ReportTest() {
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
		
		
		String parent = driver.getWindowHandle();
		System.out.println(parent);
		Thread.sleep(2000);
		Set<String> handles = driver.getWindowHandles();//get the all the open windows 
		System.out.println(handles);
		Iterator<String> it = handles.iterator();
	
			String parent_window=it.next();
			System.out.println(parent_window);
			String child_window = it.next();
			
		
		System.out.println(child_window);
		driver.switchTo().window(child_window).manage().window().maximize();
		Thread.sleep(2000);

		int size = driver.findElements(By.tagName("iframe")).size();
		System.out.println(size);
		
		System.out.println("Report title: "+driver.switchTo().frame(0).getTitle());
		Assert.assertTrue(driver.findElement(By.xpath("//*[@id='Text13']/p[1]/span/span")).isDisplayed());
		System.out.println("Report name and date:  "+driver.findElement(By.xpath("//*[@id='Text13']/p[1]/span/span")).getText());
		driver.close();
		
	
		//switch to the parent window
		driver.switchTo().window(parent);


		jse.executeScript("arguments[0].click();", report.getBacktoList());
		
		System.out.println("*-----------------------------------------------*");
		
		
	}
	


	@AfterClass(enabled =true)
	public void teardown() {

	
		driver.quit();
		driver = null;
	}
}
