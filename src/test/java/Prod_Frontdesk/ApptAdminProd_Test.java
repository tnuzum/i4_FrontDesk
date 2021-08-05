package Prod_Frontdesk;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pageObjects.ApptAdminPO;
import pageObjects.DashboardPO;
import pageObjects.LoginPO;
import resources.CustomActions;
import resources.base;

@Listeners(resources.Listeners.class)

public class ApptAdminProd_Test extends base {
	
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

	public ApptAdminPO appt;
	public CustomActions ca;

	public ApptAdminProd_Test() {
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
		appt = new ApptAdminPO(driver);

		ca.LoginFD(clubBarcodeId, clubPassword, BarcodeIDEmp, PasswordEmp);
		Thread.sleep(2000);

		Assert.assertEquals(driver.getTitle(), "Member Manager");

		jse.executeScript("arguments[0].click();", appt.getApptadmintbtn());

		String expectedtitle = driver.findElement(By.xpath("//a[@title='Appointment Admin']")).getText();
		System.out.println(expectedtitle);

		Assert.assertEquals(expectedtitle, "Appointment Admin");

	}

	@Test(enabled = true, priority = 1, description = "Apptadmin_makeappointment")
	public void Apptadmin_makeappointment() throws Exception {

		Actions action = new Actions(driver);

		jse.executeScript("arguments[0].click();", appt.getbtnbarcode());

		appt.getmemberbarcode().sendKeys(memberbarcode);

		jse.executeScript("arguments[0].click();", appt.getsearchbtn());

		jse.executeScript("arguments[0].click();", appt.getselectbtn());

		Thread.sleep(2000);

		Select select = new Select(appt.getclubs());
		select.selectByVisibleText("Executive Fitness Club");

		Select select1 = new Select(appt.getschedulegroup());
		select1.selectByVisibleText("Automation Test");

		Thread.sleep(1000);

		Select select2 = new Select(appt.getschedulebook());
		select2.selectByVisibleText("Testing Book");

		DateFormat df = new SimpleDateFormat("MM/d/yyyy");// HH:mm:ss
		Calendar today = Calendar.getInstance();
		String currentdate = df.format(today.getTime());
		System.out.println("Current date is  " + currentdate);

		Calendar calendar = Calendar.getInstance();

		
		int n = (calendar.get(Calendar.DAY_OF_WEEK) - 1);

		jse.executeScript("window.scrollBy(0,400)");// window scroll down
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		jse.executeScript("document.querySelector('div.fc-scroller.fc-time-grid-container').scrollTop=400");

		System.out.println(driver.findElements(By.xpath("//div[@data-full='1:00 PM - 1:15 PM']")).get(n)
				.getAttribute("data-start"));

		WebElement timeslot = driver.findElements(By.xpath("//div[@data-full='1:00 PM - 1:15 PM']")).get(n);
		jse.executeScript("arguments[0].click();", timeslot);
		Thread.sleep(2000);

//			jse.executeScript("arguments[0].click();",appt.getokbtn());

		jse.executeScript("arguments[0].click();", appt.getappintmentbtn());

		
		action.sendKeys(Keys.PAGE_DOWN).perform();

	//	jse.executeScript("arguments[0].click();",
	//			driver.findElements(By.xpath("//div[@data-full='1:00 PM - 1:15 PM']")).get(n).click();
		
	


		Select selectclub = new Select(appt.getclubs());
		selectclub.selectByVisibleText("Executive Fitness Club");
		Thread.sleep(2000);

		Select selectgroup = new Select(appt.getschedulegroup());
		selectgroup.selectByVisibleText("Automation Test");

		Thread.sleep(2000);

		Select selectbook = new Select(appt.getschedulebook());
		selectbook.selectByVisibleText("Testing Book");

		jse.executeScript("window.scrollBy(0,400)");// window scroll down
		Thread.sleep(1000);

		jse.executeScript("document.querySelector('div.fc-scroller.fc-time-grid-container').scrollTop=500");

	}

	@Test(enabled = true, priority = 2, description = "Apptadmin_cancelappointment")
	public void Apptadmin_cancelappointment() throws Exception {

		Actions action = new Actions(driver);
		jse.executeScript("arguments[0].click();", appt.getApptadmintbtn());

		

		Thread.sleep(2000);

		Select select = new Select(appt.getclubs());
		select.selectByVisibleText("Executive Fitness Club");

		Select select1 = new Select(appt.getschedulegroup());
		select1.selectByVisibleText("Automation Test");

		Thread.sleep(1000);

		Select select2 = new Select(appt.getschedulebook());
		select2.selectByVisibleText("Testing Book");

		DateFormat df = new SimpleDateFormat("MM/d/yyyy");// HH:mm:ss
		Calendar today = Calendar.getInstance();
		String currentdate = df.format(today.getTime());
		System.out.println("Current date is  " + currentdate);

		Calendar calendar = Calendar.getInstance();

		
		int n = (calendar.get(Calendar.DAY_OF_WEEK) - 1);

		jse.executeScript("window.scrollBy(0,400)");// window scroll down
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		jse.executeScript("document.querySelector('div.fc-scroller.fc-time-grid-container').scrollTop=400");

		jse.executeScript("arguments[0].click();",
				driver.findElements(By.xpath("//div[@data-full='1:00 PM - 1:15 PM']")).get(n));

		Thread.sleep(1000);

		
		String s2 = driver.findElement(By.className("modal-body")).getText();

		String s3 = driver.findElement(By.className("modal-title")).getText();

		List<WebElement> details = driver
				.findElements(By.xpath("//table[@id='ContentPlaceHolder1_AppointmentFormView']/tbody/tr/td/div/div/p"));
		System.out.println(details.size());

		for (int i = 0; i < details.size(); i++) {

			System.out.println(details.get(i).getText());
		

		}
		Assert.assertTrue(details.get(1).getText().contains("Executive Fitness Club"));
		Assert.assertTrue(details.get(1).getText().contains("1:00 PM"));
		
		action.sendKeys(Keys.CONTROL + "end" + Keys.CONTROL).perform();

		
		System.out.println(driver
				.findElement(By.xpath(
						"//table[@id='ContentPlaceHolder1_AppointmentFormView']/tbody/tr/td/div[3]/div/div[4]/div/p"))
				.getText());
		

		jse.executeScript("arguments[0].click();", appt.getcancelappointment());
		Thread.sleep(2000);

		action.sendKeys(Keys.CONTROL + "end" + Keys.CONTROL).perform();
		String cancellation_confirmationnumber = driver
				.findElement(By.xpath(
						"//table[@id='ContentPlaceHolder1_AppointmentFormView']/tbody/tr/td/div[3]/div/div[4]/div/p"))
				.getText();

		Assert.assertNotNull(cancellation_confirmationnumber);
		System.out.println(cancellation_confirmationnumber);
		
		

		jse.executeScript("arguments[0].click();", appt.getApptadmintbtn());

		Select selectclub = new Select(appt.getclubs());
		selectclub.selectByVisibleText("Executive Fitness Club");

		Select selectgroup = new Select(appt.getschedulegroup());
		selectgroup.selectByVisibleText("Automation Test");

		Thread.sleep(1000);

		Select selectbook = new Select(appt.getschedulebook());
		selectbook.selectByVisibleText("Testing Book");

		jse.executeScript("window.scrollBy(0,400)");// window scroll down
		Thread.sleep(1000);

		jse.executeScript("document.querySelector('div.fc-scroller.fc-time-grid-container').scrollTop=400");

	}

	@Test(enabled = true, priority = 3, description = "Apptadmin_makeRecurringappointment")
	public void Apptadmin_Recurringappointment() throws Exception {

		
		jse.executeScript("arguments[0].click();", appt.getbtnbarcode());

		appt.getmemberbarcode().sendKeys(memberbarcode);

		jse.executeScript("arguments[0].click();", appt.getsearchbtn());

		jse.executeScript("arguments[0].click();", appt.getselectbtn());

		Thread.sleep(2000);

		Select select = new Select(appt.getclubs());
		select.selectByVisibleText("Executive Fitness Club");

		Select select1 = new Select(appt.getschedulegroup());
		select1.selectByVisibleText("Automation Test");

		Thread.sleep(1000);

		Select select2 = new Select(appt.getschedulebook());
		select2.selectByVisibleText("Testing Book");

		DateFormat df = new SimpleDateFormat("MM/d/yyyy");// HH:mm:ss
		Calendar today = Calendar.getInstance();
		String currentdate = df.format(today.getTime());
		System.out.println("Current date is  " + currentdate);

		Calendar calendar = Calendar.getInstance();

		int n = (calendar.get(Calendar.DAY_OF_WEEK) - 1);

		jse.executeScript("window.scrollBy(0,400)");// window scroll down
		Thread.sleep(1000);

		jse.executeScript("document.querySelector('div.fc-scroller.fc-time-grid-container').scrollTop=400");

		System.out.println(driver.findElements(By.xpath("//div[@data-full='1:00 PM - 1:15 PM']")).get(n)
				.getAttribute("data-start"));

		WebElement timeslot = driver.findElements(By.xpath("//div[@data-full='1:00 PM - 1:15 PM']")).get(n);
		jse.executeScript("arguments[0].click();", timeslot);
		Thread.sleep(2000);

		jse.executeScript("arguments[0].click();", appt.getmakerecurringbtn());

		Thread.sleep(2000);
		jse.executeScript("arguments[0].click();", appt.getrecurringappointment());

		jse.executeScript("arguments[0].click();", appt.getsubmitbtn());
		Thread.sleep(2000);

		String s2 = driver.findElement(By.className("modal-body")).getText();

		String s3 = driver.findElement(By.className("modal-title")).getText();

		List<WebElement> details = driver
				.findElements(By.xpath("//table[@id='ContentPlaceHolder1_AppointmentFormView']/tbody/tr/td/div/div/p"));
		System.out.println(details.size());

		for (int i = 0; i < details.size(); i++) {

			System.out.println(details.get(i).getText());

		}

		Assert.assertTrue(details.get(1).getText().contains("Executive Fitness Club"));
		Assert.assertTrue(details.get(1).getText().contains("1:00 PM"));
		
		jse.executeScript("arguments[0].click();", appt.getApptadmintbtn());

		Select selectclub = new Select(appt.getclubs());
		selectclub.selectByVisibleText("Executive Fitness Club");

		Select selectgroup = new Select(appt.getschedulegroup());
		selectgroup.selectByVisibleText("Automation Test");

		Thread.sleep(1000);

		Select selectbook = new Select(appt.getschedulebook());
		selectbook.selectByVisibleText("Testing Book");

		jse.executeScript("window.scrollBy(0,400)");// window scroll down
		Thread.sleep(1000);

		jse.executeScript("document.querySelector('div.fc-scroller.fc-time-grid-container').scrollTop=400");

	}

	@Test(enabled = true, priority = 4, description = "Apptadmin_CancelRecurringappointment")
	public void Apptadmin_CancelRecurringappointment() throws Exception {

		Actions action = new Actions(driver);

		jse.executeScript("arguments[0].click();", appt.getbtnbarcode());

		appt.getmemberbarcode().sendKeys(memberbarcode);

		jse.executeScript("arguments[0].click();", appt.getsearchbtn());

		jse.executeScript("arguments[0].click();", appt.getselectbtn());

		Thread.sleep(2000);

		Select select = new Select(appt.getclubs());
		select.selectByVisibleText("Executive Fitness Club");

		Select select1 = new Select(appt.getschedulegroup());
		select1.selectByVisibleText("Automation Test");

		Thread.sleep(2000);

		Select select2 = new Select(appt.getschedulebook());
		select2.selectByVisibleText("Testing Book");

		DateFormat df = new SimpleDateFormat("MM/d/yyyy");// HH:mm:ss
		Calendar today = Calendar.getInstance();
		String currentdate = df.format(today.getTime());
		System.out.println("Current date is  " + currentdate);

		Calendar calendar = Calendar.getInstance();

		int n = (calendar.get(Calendar.DAY_OF_WEEK) - 1);

		jse.executeScript("window.scrollBy(0,400)");// window scroll down
		Thread.sleep(1000);

		jse.executeScript("document.querySelector('div.fc-scroller.fc-time-grid-container').scrollTop=400");

		System.out.println(driver.findElements(By.xpath("//div[@data-full='1:00 PM - 1:15 PM']")).get(n)
				.getAttribute("data-start"));

		WebElement timeslot = driver.findElements(By.xpath("//div[@data-full='1:00 PM - 1:15 PM']")).get(n);
		jse.executeScript("arguments[0].click();", timeslot);
		Thread.sleep(2000);

		action.sendKeys(Keys.PAGE_DOWN).perform();

		System.out.println(driver
				.findElement(By.xpath(
						"//table[@id='ContentPlaceHolder1_AppointmentFormView']/tbody/tr/td/div[3]/div/div[4]/div/p"))
				.getText());

		jse.executeScript("arguments[0].click();", appt.getCancelallapointment());
		Thread.sleep(2000);

		action.sendKeys(Keys.PAGE_DOWN).perform();

		String cancellation_confirmationnumber = driver
				.findElement(By.xpath(
						"//table[@id='ContentPlaceHolder1_AppointmentFormView']/tbody/tr/td/div[3]/div/div[4]/div/p"))
				.getText();
		Assert.assertNotNull(cancellation_confirmationnumber);
		System.out.println(cancellation_confirmationnumber);

		jse.executeScript("arguments[0].click();", appt.getApptadmintbtn());

		Select selectclub = new Select(appt.getclubs());
		selectclub.selectByVisibleText("Executive Fitness Club");

		Select selectgroup = new Select(appt.getschedulegroup());
		selectgroup.selectByVisibleText("Automation Test");

		Thread.sleep(2000);

		Select selectbook = new Select(appt.getschedulebook());
		selectbook.selectByVisibleText("Testing Book");

		jse.executeScript("window.scrollBy(0,400)");// window scroll down
		Thread.sleep(1000);

		jse.executeScript("document.querySelector('div.fc-scroller.fc-time-grid-container').scrollTop=400");

	}

	@AfterClass(enabled = true)
	public void teardown() {

		driver.close();
		driver.quit();
		driver = null;
	}
}



