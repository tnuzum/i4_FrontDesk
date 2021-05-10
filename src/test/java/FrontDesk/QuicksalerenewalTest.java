package FrontDesk;

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
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pageObjects.DashboardPO;
import pageObjects.LoginPO;
import pageObjects.Quicksale_renewalPO;
import resources.CustomActions;
import resources.base;

public class QuicksalerenewalTest extends base{
	
public SoftAssert softAssertion = new SoftAssert();

private static String barcode = "G3131";



//private static String cvvnum = "854";
private static String zip = "M5H2N1";
private static String familyfirstname = "James";
private static String familyphone = "9856741256";
private static String familycell = "6523741256";
private static String familymemberemail = "Jamespeter452@gmail.com";
private static JavascriptExecutor jse;


private static String expectedconfirmationmsg = "Contract Created Successfully. You can perform the following actions:";

DashboardPO d;
String clubBarcodeId;
String clubPassword;

LoginPO L;
String BarcodeIDEmp;
String PasswordEmp;
public CustomActions ca;

public Quicksale_renewalPO ren;

String expyear, address1, city, state;

String firstname, lastname, dateofbirth;

String billingname, mobilenumber, workphone, email, creditcard, visacard, mastercard;
String Paymentopt, paymentmthd, cardtype, cardexpmonthfield, cardexpyearfield, cvvnum;

public QuicksalerenewalTest() {
	ca = new CustomActions();
}

@BeforeClass
public void initialize() throws Exception {
	driver = initializeDriver();
	ca.setDriver(driver);

	driver.get(prop.getProperty("clubLoginPage"));

	d = new DashboardPO(driver);
	clubBarcodeId = prop.getProperty("clubBarcodeId");
	clubPassword = prop.getProperty("clubPassword");

	// driver - initializeDriver();
	// driver.get(prop.getProperty("EmpLoginPage"));

	L = new LoginPO(driver);
	BarcodeIDEmp = prop.getProperty("EmpBarcodeID");
	PasswordEmp = prop.getProperty("EmpPassword");

	cardtype = prop.getProperty("cardtype");
	cardexpmonthfield = prop.getProperty("cardexpmonthfield");
	cardexpyearfield = prop.getProperty("cardexpyearfield");

	visacard = prop.getProperty("visacard");
	mastercard = prop.getProperty("Mccard");
	cvvnum = prop.getProperty("cvvnum");

	jse = (JavascriptExecutor) driver;

	ca.LoginFD(clubBarcodeId, clubPassword, BarcodeIDEmp, PasswordEmp);
	Thread.sleep(2000);
	
	ren = new Quicksale_renewalPO(driver);

	jse.executeScript("arguments[0].click();", ren.getquicksalebtn());

}

@Test(enabled = true, priority = 1, description = "Quicksale_renewal contract, making Payment with Cash")
public void renewalcontract() throws Exception {

	//ren = new Quicksale_renewalPO(driver);

	// jse.executeScript("arguments[0].click();",ren.getquicksalebtn());

	jse.executeScript("arguments[0].click();", ren.getrenewal());
	ren.getsearchbybarcode().sendKeys(barcode);
	jse.executeScript("arguments[0].click();", ren.getsearchallclubbtn());

	Actions action = new Actions(driver);
	action.sendKeys(Keys.PAGE_DOWN).perform();

	jse.executeScript("arguments[0].click();", ren.getselectmemberbtn());

	String s2 = driver.findElement(By.className("modal-body")).getText();
	// System.out.println(s2)
	String s3 = driver.findElement(By.className("modal-title")).getText();
	System.out.println("Member name " + s3);

	jse.executeScript("arguments[0].click();", driver.findElement(By.id("btnNewPlanForRenewal")));

	Thread.sleep(2000);
	int count = driver.findElements(By.tagName("tr")).size();
	System.out.println(count);

	String before_xpath = "//tbody/tr[";
	String after_Xpath = "]/td[2]";

	for (int i = 4; i < count; i++) {

		String planname = driver.findElement(By.xpath(before_xpath + i + after_Xpath)).getText();
		System.out.println(planname);
		if (planname.contains("!umas open ended plan")) {

			jse.executeScript("arguments[0].click();",
					driver.findElement(By.xpath("//tbody/tr[" + i + "]/td[1]/label[1]/span[1]/span[2]")));

			break;

		}

	}

	jse.executeScript("arguments[0].click();", ren.getproceedexistingbtn());

	action.sendKeys(Keys.PAGE_DOWN).perform();
	action.sendKeys(Keys.PAGE_DOWN).perform();

	action.sendKeys(Keys.CONTROL + "end" + Keys.CONTROL).perform();
	jse.executeScript("arguments[0].click();", ren.getcheckprivacypolicybtn());

	jse.executeScript("arguments[0].click();", ren.getproceedgotobilling());

	action.sendKeys(Keys.PAGE_DOWN).perform();

	//ren.getformofpayment().click();

	Select select = new Select(ren.getformofpayment());

	if (cardtype.equals("Visa")) {
		select.selectByIndex(5);
		ren.getcreditcardfield().sendKeys(visacard);

	}
	if (cardtype.equals("Mc")) {
		select.selectByIndex(4);
		ren.getcreditcardfield().sendKeys(mastercard);

	}

	ren.getcardexpmonth().sendKeys(cardexpmonthfield);
	ren.getcardexpyear().sendKeys(cardexpyearfield);

	jse.executeScript("arguments[0].click();", ren.getproceedgotoplan());

	// Adding Family membber

	jse.executeScript("arguments[0].click();", ren.getAddfamilymember());
	ren.getfamilyfirstname().sendKeys(familyfirstname);
	ren.getfamilyphone().sendKeys(familyphone);
	ren.getfamilycell().sendKeys(familycell);
	ren.getfamilygender().click();
	ren.getfamilymemberemail().sendKeys(familymemberemail);
	action.sendKeys(Keys.PAGE_DOWN).perform();
	action.sendKeys(Keys.CONTROL + "end" + Keys.CONTROL).perform();
	jse.executeScript("arguments[0].click();", ren.getcustomeragreepolicy());
	jse.executeScript("arguments[0].click();", ren.getsavebtn());

	List<WebElement> btnIgnore = driver.findElements(By.id("btnIgnore"));
	if (btnIgnore.size() > 0) {

		jse.executeScript("arguments[0].click();", btnIgnore.get(0));

	}

	jse.executeScript("arguments[0].click();", ren.geteditplanbutton());

	String edt = driver.findElement(By.className("modal-body")).getText();

	DateFormat df = new SimpleDateFormat("MM/d/yyyy");
	Calendar today = Calendar.getInstance();
	String currentdate = df.format(today.getTime());
	System.out.println(currentdate);

	WebElement date = driver.findElement(By.xpath("//input[@id='ctl00_ContentPlaceHolder1_txtFirstPaymentDate']"));

	selectDateByJS(driver, date, currentdate);

	WebElement date1 = driver.findElement(By.xpath("//input[@id='ctl00_ContentPlaceHolder1_txtRecDuesDate']"));
	selectDateByJS(driver, date1, currentdate);

	driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

	action.click();

	jse.executeScript("arguments[0].click();", ren.getokbtn());
	driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

	action.sendKeys(Keys.PAGE_DOWN).click();
	action.sendKeys(Keys.TAB).perform();
	action.sendKeys(Keys.TAB).perform();
	action.sendKeys(Keys.TAB).perform();
	action.sendKeys(Keys.TAB).perform();
	action.sendKeys(Keys.TAB).perform();
	action.sendKeys(Keys.TAB).perform();
	action.sendKeys(Keys.CONTROL + "end" + Keys.CONTROL).perform();

	driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	jse.executeScript("arguments[0].click();", ren.getproceedgotoplan());

	List<WebElement> Continuebtn = driver.findElements(By.xpath("//input[@id='btnContinue']"));

	if (Continuebtn.size() > 0) {

		jse.executeScript("arguments[0].click();", Continuebtn.get(0));

	}
	action.sendKeys(Keys.PAGE_DOWN).click();

	action.sendKeys(Keys.TAB).perform();
	action.sendKeys(Keys.CONTROL + "end" + Keys.CONTROL).perform();
	action.sendKeys(Keys.PAGE_DOWN).click();
	action.sendKeys(Keys.PAGE_DOWN).click();
	Thread.sleep(2000);

	driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

	action.sendKeys(Keys.PAGE_DOWN).click();

	driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

	jse.executeScript("arguments[0].click();", ren.getproceedplanpayment());
	// ren.getproceedplanpayment().click();

	driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

	String Paymentopt = prop.getProperty("Paymentoption");

	if (Paymentopt.equals("PayNow")) {
		jse.executeScript("arguments[0].click();", ren.getpaynowbtn());

		jse.executeScript("arguments[0].click();", ren.getsplitpaymentno());

		jse.executeScript("arguments[0].click();", ren.getpaymentbycash());

	}

	if (Paymentopt.equals("PayLater")) {

		jse.executeScript("arguments[0].click();", ren.getpaylaterbtn());
	}

	jse.executeScript("arguments[0].click();", ren.getproceedgotobilling());
	Thread.sleep(2000);
	String actualConfirmMessage = driver.findElement(By.cssSelector(".control-label")).getText();
	System.out.println(actualConfirmMessage);
	Assert.assertEquals(actualConfirmMessage, expectedconfirmationmsg);
	driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	jse.executeScript("arguments[0].click();", ren.getbtnapprove());

}

@Test(enabled = true, priority = 2, description = "Quicksale_renewal contract, making Payment with Creditcard")
public void renewalcontract_Creditcard() throws Exception {
	//ren = new Quicksale_renewalPO(driver);

	jse.executeScript("arguments[0].click();", ren.getrenewal());

	ren.getsearchbybarcode().sendKeys(barcode);
	jse.executeScript("arguments[0].click();", ren.getsearchallclubbtn());

	jse.executeScript("arguments[0].click();", ren.getselectmemberbtn());

	Actions action = new Actions(driver);

	String s2 = driver.findElement(By.className("modal-body")).getText();
	// System.out.println(s2)
	String s3 = driver.findElement(By.className("modal-title")).getText();
	System.out.println("Member name " + s3);

	jse.executeScript("arguments[0].click();", driver.findElement(By.id("btnNewPlanForRenewal")));

	Thread.sleep(2000);
	int count = driver.findElements(By.tagName("tr")).size();
	System.out.println(count);

	String before_xpath = "//tbody/tr[";
	String after_Xpath = "]/td[2]";

	for (int i = 4; i < count; i++) {

		String planname = driver.findElement(By.xpath(before_xpath + i + after_Xpath)).getText();
		System.out.println(planname);
		if (planname.contains("!umas open ended plan")) {

			jse.executeScript("arguments[0].click();",
					driver.findElement(By.xpath("//tbody/tr[" + i + "]/td[1]/label[1]/span[1]/span[2]")));

			break;

		}

	}

	jse.executeScript("arguments[0].click();", ren.getproceedexistingbtn());

	action.sendKeys(Keys.PAGE_DOWN).perform();
	action.sendKeys(Keys.PAGE_DOWN).perform();

	action.sendKeys(Keys.CONTROL + "end" + Keys.CONTROL).perform();
	jse.executeScript("arguments[0].click();", ren.getcheckprivacypolicybtn());

	jse.executeScript("arguments[0].click();", ren.getproceedgotobilling());

	action.sendKeys(Keys.PAGE_DOWN).perform();

	//ren.getformofpayment().click();

	Select select = new Select(ren.getformofpayment());

	if (cardtype.equals("Visa")) {
		select.selectByIndex(5);
		ren.getcreditcardfield().sendKeys(visacard);

	}
	if (cardtype.equals("Mc")) {
		select.selectByIndex(4);
		ren.getcreditcardfield().sendKeys(mastercard);

	}

	ren.getcardexpmonth().sendKeys(cardexpmonthfield);
	ren.getcardexpyear().sendKeys(cardexpyearfield);

	jse.executeScript("arguments[0].click();", ren.getproceedgotoplan());

//	// Adding Family membber
//
//	jse.executeScript("arguments[0].click();", ren.getAddfamilymember());
//	ren.getfamilyfirstname().sendKeys(familyfirstname);
//	ren.getfamilyphone().sendKeys(familyphone);
//	ren.getfamilycell().sendKeys(familycell);
//	ren.getfamilygender().click();
//	ren.getfamilymemberemail().sendKeys(familymemberemail);
//	action.sendKeys(Keys.PAGE_DOWN).perform();
//	action.sendKeys(Keys.CONTROL + "end" + Keys.CONTROL).perform();
//	jse.executeScript("arguments[0].click();", ren.getcustomeragreepolicy());
//	jse.executeScript("arguments[0].click();", ren.getsavebtn());
//	// jse.executeScript("arguments[0].click();",driver.findElement(By.id("btnIgnore")));
//	List<WebElement> btnIgnore = driver.findElements(By.id("btnIgnore"));
//	if (btnIgnore.size() > 0) {
//
//		jse.executeScript("arguments[0].click();", btnIgnore.get(0));
//
//	}

	jse.executeScript("arguments[0].click();", ren.geteditplanbutton());

	String edt = driver.findElement(By.className("modal-body")).getText();

	DateFormat df = new SimpleDateFormat("MM/d/yyyy");
	Calendar today = Calendar.getInstance();
	String currentdate = df.format(today.getTime());
	System.out.println(currentdate);

	WebElement date = driver.findElement(By.xpath("//input[@id='ctl00_ContentPlaceHolder1_txtFirstPaymentDate']"));

	selectDateByJS(driver, date, currentdate);

	WebElement date1 = driver.findElement(By.xpath("//input[@id='ctl00_ContentPlaceHolder1_txtRecDuesDate']"));
	selectDateByJS(driver, date1, currentdate);

	driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

	action.click();

	jse.executeScript("arguments[0].click();", ren.getokbtn());
	driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

	action.sendKeys(Keys.PAGE_DOWN).click();
	action.sendKeys(Keys.TAB).perform();
	action.sendKeys(Keys.TAB).perform();
	action.sendKeys(Keys.TAB).perform();
	action.sendKeys(Keys.TAB).perform();
	action.sendKeys(Keys.TAB).perform();
	action.sendKeys(Keys.TAB).perform();
	action.sendKeys(Keys.CONTROL + "end" + Keys.CONTROL).perform();

	driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	jse.executeScript("arguments[0].click();", ren.getproceedgotoplan());

	List<WebElement> Continuebtn = driver.findElements(By.xpath("//input[@id='btnContinue']"));

	if (Continuebtn.size() > 0) {

		jse.executeScript("arguments[0].click();", Continuebtn.get(0));

	}
	action.sendKeys(Keys.PAGE_DOWN).click();

	action.sendKeys(Keys.TAB).perform();
	action.sendKeys(Keys.CONTROL + "end" + Keys.CONTROL).perform();
	action.sendKeys(Keys.PAGE_DOWN).click();
	action.sendKeys(Keys.PAGE_DOWN).click();
	Thread.sleep(2000);

	driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

	action.sendKeys(Keys.PAGE_DOWN).click();

	driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

	jse.executeScript("arguments[0].click();", ren.getproceedplanpayment());
	// ren.getproceedplanpayment().click();

	driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

	String Paymentopt = prop.getProperty("Paymentoption");

	if (Paymentopt.equals("PayNow")) {
		jse.executeScript("arguments[0].click();", ren.getpaynowbtn());

		jse.executeScript("arguments[0].click();", ren.getsplitpaymentno());

		jse.executeScript("arguments[0].click();", ren.getpaymentbycreditcard());
		jse.executeScript("arguments[0].click();", ren.getselectcardtype());
		Thread.sleep(2000);

		Select select1 = new Select(driver.findElement(By.id("creditCardTypes")));

		if (cardtype.equals("Visa")) {
			select1.selectByIndex(2);
			ren.getcreditcardfield().sendKeys(visacard);
		}
		if (cardtype.equals("Mc")) {
			select1.selectByIndex(1);
			ren.getcreditcardfield().sendKeys(mastercard);
		}

		ren.getcardexpmonth().sendKeys(cardexpmonthfield);
		ren.getcardexpyear().clear();
		ren.getcardexpyear().sendKeys(cardexpyearfield);
		ren.getcvvnum().sendKeys(cvvnum);
		ren.getnameoncard().sendKeys(s3);
		// ren.getmemaddress().sendKeys(address1);
		// ren.getmemcity().sendKeys(city);
		// ren.getmemstate().sendKeys(state);
		ren.getmemzip().sendKeys(zip);
	}

	if (Paymentopt.equals("PayLater")) {

		jse.executeScript("arguments[0].click();", ren.getpaylaterbtn());
	}

	jse.executeScript("arguments[0].click();", ren.getproceedgotobilling());

	jse.executeScript("arguments[0].click();", ren.getbtnapprove());

}

@Test(enabled = true, priority = 3, description = "Quicksale_renewal contract, making Split Payment with Cash and Creditcard")
public void renewalcontract_splitpayment() throws Exception {
	ren = new Quicksale_renewalPO(driver);

	jse.executeScript("arguments[0].click();", ren.getrenewal());
	ren.getsearchbybarcode().sendKeys(barcode);
	jse.executeScript("arguments[0].click();", ren.getsearchallclubbtn());

	jse.executeScript("arguments[0].click();", ren.getselectmemberbtn());

	Actions action = new Actions(driver);

	String s2 = driver.findElement(By.className("modal-body")).getText();
	// System.out.println(s2)
	String s3 = driver.findElement(By.className("modal-title")).getText();
	System.out.println("Member name " + s3);

	jse.executeScript("arguments[0].click();", driver.findElement(By.id("btnNewPlanForRenewal")));

	Thread.sleep(2000);
	int count = driver.findElements(By.tagName("tr")).size();
	System.out.println(count);

	String before_xpath = "//tbody/tr[";
	String after_Xpath = "]/td[2]";

	for (int i = 4; i < count; i++) {

		String planname = driver.findElement(By.xpath(before_xpath + i + after_Xpath)).getText();
		System.out.println(planname);
		if (planname.contains("!umas open ended plan")) {

			jse.executeScript("arguments[0].click();",
					driver.findElement(By.xpath("//tbody/tr[" + i + "]/td[1]/label[1]/span[1]/span[2]")));

			break;

		}

	}
	jse.executeScript("arguments[0].click();", ren.getproceedexistingbtn());

	action.sendKeys(Keys.PAGE_DOWN).perform();
	action.sendKeys(Keys.PAGE_DOWN).perform();

	action.sendKeys(Keys.CONTROL + "end" + Keys.CONTROL).perform();
	jse.executeScript("arguments[0].click();", ren.getcheckprivacypolicybtn());

	jse.executeScript("arguments[0].click();", ren.getproceedgotobilling());

	action.sendKeys(Keys.PAGE_DOWN).perform();

	//ren.getformofpayment().click();
	Select select = new Select(ren.getformofpayment());

	if (cardtype.equals("Visa")) {
		select.selectByIndex(5);
		ren.getcreditcardfield().sendKeys(visacard);

	}
	if (cardtype.equals("Mc")) {
		select.selectByIndex(4);
		ren.getcreditcardfield().sendKeys(mastercard);

	}

	ren.getcardexpmonth().sendKeys(cardexpmonthfield);
	ren.getcardexpyear().sendKeys(cardexpyearfield);


	jse.executeScript("arguments[0].click();", ren.getproceedgotoplan());

	// Adding Family membber

	jse.executeScript("arguments[0].click();", ren.getAddfamilymember());
	ren.getfamilyfirstname().sendKeys(familyfirstname);
	ren.getfamilyphone().sendKeys(familyphone);
	ren.getfamilycell().sendKeys(familycell);
	ren.getfamilygender().click();
	ren.getfamilymemberemail().sendKeys(familymemberemail);
	action.sendKeys(Keys.PAGE_DOWN).perform();
	action.sendKeys(Keys.CONTROL + "end" + Keys.CONTROL).perform();
	jse.executeScript("arguments[0].click();", ren.getcustomeragreepolicy());
	jse.executeScript("arguments[0].click();", ren.getsavebtn());
	// jse.executeScript("arguments[0].click();",driver.findElement(By.id("btnIgnore")));
	List<WebElement> btnIgnore = driver.findElements(By.id("btnIgnore"));
	if (btnIgnore.size() > 0) {

		jse.executeScript("arguments[0].click();", btnIgnore.get(0));

	}

	jse.executeScript("arguments[0].click();", ren.geteditplanbutton());

	String edt = driver.findElement(By.className("modal-body")).getText();

	DateFormat df = new SimpleDateFormat("MM/d/yyyy");
	Calendar today = Calendar.getInstance();
	String currentdate = df.format(today.getTime());
	System.out.println(currentdate);

	WebElement date = driver.findElement(By.xpath("//input[@id='ctl00_ContentPlaceHolder1_txtFirstPaymentDate']"));

	selectDateByJS(driver, date, currentdate);

	WebElement date1 = driver.findElement(By.xpath("//input[@id='ctl00_ContentPlaceHolder1_txtRecDuesDate']"));
	selectDateByJS(driver, date1, currentdate);

	driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

	action.click();

	jse.executeScript("arguments[0].click();", ren.getokbtn());
	driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

	action.sendKeys(Keys.PAGE_DOWN).click();
	action.sendKeys(Keys.TAB).perform();
	action.sendKeys(Keys.TAB).perform();
	action.sendKeys(Keys.TAB).perform();
	action.sendKeys(Keys.TAB).perform();
	action.sendKeys(Keys.TAB).perform();
	action.sendKeys(Keys.TAB).perform();
	action.sendKeys(Keys.CONTROL + "end" + Keys.CONTROL).perform();

	driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	jse.executeScript("arguments[0].click();", ren.getproceedgotoplan());

	List<WebElement> Continuebtn = driver.findElements(By.xpath("//input[@id='btnContinue']"));

	if (Continuebtn.size() > 0) {

		jse.executeScript("arguments[0].click();", Continuebtn.get(0));

	}
	action.sendKeys(Keys.PAGE_DOWN).click();

	action.sendKeys(Keys.TAB).perform();
	action.sendKeys(Keys.CONTROL + "end" + Keys.CONTROL).perform();
	action.sendKeys(Keys.PAGE_DOWN).click();
	action.sendKeys(Keys.PAGE_DOWN).click();
	Thread.sleep(2000);

	driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

	action.sendKeys(Keys.PAGE_DOWN).click();

	driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

	jse.executeScript("arguments[0].click();", ren.getproceedplanpayment());
	

	driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

	// ca.takescreenshot();
	String Paymentopt = prop.getProperty("Paymentoption");

	if (Paymentopt.equals("payNow")) {
		jse.executeScript("arguments[0].click();", ren.getpaynowbtn());

		jse.executeScript("arguments[0].click();", ren.getsplitpaymentyes());

		jse.executeScript("arguments[0].click();", ren.getpaymentbycash());

		jse.executeScript("arguments[0].click();", ren.getpaymentbycreditcard());
		ren.getcashamount().sendKeys("5");
		ren.getccamount().sendKeys("10");
		jse.executeScript("arguments[0].click();", ren.getselectcardtype());
		Thread.sleep(2000);

		Select select1 = new Select(driver.findElement(By.id("creditCardTypes")));

		if (cardtype.equals("Visa")) {
			select1.selectByIndex(2);
			ren.getcreditcardfield().sendKeys(visacard);
		}
		if (cardtype.equals("Mc")) {
			select1.selectByIndex(1);
			ren.getcreditcardfield().sendKeys(mastercard);
		}

		ren.getcardexpmonth().sendKeys(cardexpmonthfield);
		ren.getcardexpyear().clear();
		ren.getcardexpyear().sendKeys(cardexpyearfield);
		ren.getcvvnum().sendKeys(cvvnum);
		ren.getnameoncard().sendKeys(s3);
		ren.getmemaddress().sendKeys(address1);
		ren.getmemcity().sendKeys(city);
		ren.getmemstate().sendKeys(state);
		ren.getmemzip().sendKeys(zip);

	}

	if (Paymentopt.equals("PayLater")) {

		jse.executeScript("arguments[0].click();", ren.getpaylaterbtn());
	}

	jse.executeScript("arguments[0].click();", ren.getproceedgotobilling());
	String actualConfirmMessage = driver.findElement(By.cssSelector(".control-label")).getText();
	System.out.println(actualConfirmMessage);
	Assert.assertEquals(actualConfirmMessage, expectedconfirmationmsg);
	jse.executeScript("arguments[0].click();", ren.getbtnapprove());

}

public void selectDateByJS(WebDriver driver, WebElement element, String dateVal) {
	JavascriptExecutor js = ((JavascriptExecutor) driver);
	js.executeScript("arguments[0].setAttribute('value','" + dateVal + "');", element);

}

@AfterClass(enabled = true)
public void teardown() {

	driver.close();
	driver = null;
}
		
		
		
}

