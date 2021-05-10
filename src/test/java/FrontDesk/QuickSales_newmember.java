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
import pageObjects.QuickSalesPO;
import resources.CustomActions;
import resources.base;

public class QuickSales_newmember extends base {
	
	private static JavascriptExecutor jse;
	private static String firstname = "Charlie";
	private static String lastname = "Monroe";
	private static String Address = "Langbrae dr";
	private static String  City = "Halifax";
	private static String State = "NS";
	private static String  Zip = "M4J 5B1";
	private static String dateofbirth = "10/05/1990";
	private static String expectedconfirmationmsg = "Contract Created Successfully. You can perform the following actions:";
	
	public SoftAssert softAssertion = new SoftAssert();

	DashboardPO d;
	String clubBarcodeId;
	String clubPassword;
	
	public QuickSalesPO quicksale;
	
	LoginPO L;
	String BarcodeIDEmp;
	String PasswordEmp;
	String visacard, mastercard, cardtype, cardexpmonthfield, cardexpyearfield, cvvnum;
	public CustomActions ca;
	public QuickSales_newmember() {
	ca = new CustomActions();
	
	
	}
	@BeforeClass
	public void initialize() throws Exception {

		driver = initializeDriver();
		ca.setDriver(driver);
		
		jse = (JavascriptExecutor) driver;
		
		driver.get(prop.getProperty("clubLoginPage"));

		d = new DashboardPO(driver);
		clubBarcodeId = prop.getProperty("clubBarcodeId");
		clubPassword = prop.getProperty("clubPassword");
		
		L = new LoginPO(driver);
		BarcodeIDEmp = prop.getProperty("EmpBarcodeID");
		PasswordEmp = prop.getProperty("EmpPassword");
		
		visacard = prop.getProperty("visacard");
		mastercard = prop.getProperty("Mccard");
		
		cardtype = prop.getProperty("cardtype");
		cardexpmonthfield = prop.getProperty("cardexpmonthfield");
		cardexpyearfield = prop.getProperty("cardexpyearfield");
		cvvnum = prop.getProperty("cvvnum");
		
		ca.LoginFD(clubBarcodeId,clubPassword,BarcodeIDEmp,PasswordEmp);
		Thread.sleep(2000);
		
		
		
	}

	@Test(priority = 1)
	public void QuickSalesTest() throws Exception {
		QuickSalesPO quicksale = new QuickSalesPO(driver);

		Assert.assertEquals(driver.getTitle(), "Member Manager");
		jse.executeScript("arguments[0].click();", quicksale.getquicksalebtn());

		jse.executeScript("arguments[0].click();", quicksale.getnewContract1());

		Thread.sleep(2000);

		int count = driver.findElements(By.tagName("tr")).size();
		System.out.println(count);

		// tbody/tr[15]/td[2]/label[1]/span[1]/span[2]
		// tbody/tr[15]/td[2]/label[1]/span[1]/span[2]

		//// tbody/tr[7]/td[2]
		// tbody/tr[4]/td[2]
		// tbody/tr[6]/td[2]

		String before_xpath = "//tbody/tr[";
		String after_Xpath = "]/td[2]";

		for (int i = 4; i < count; i++) {

			String planname = driver.findElement(By.xpath(before_xpath + i + after_Xpath)).getText();
			System.out.println(planname);
			if (planname.contains("!umas open ended plan")) {

				jse.executeScript("arguments[0].click();",
						driver.findElement(By.xpath("//tbody/tr[" + i + "]/td[1]/label[1]/span[1]/span[2]")));

				System.out.println("clicking");
				break;

			}
		}

		jse.executeScript("arguments[0].click();", quicksale.getnewmemberbtn());

		Actions action = new Actions(driver);

		quicksale.getfirstnamefield().sendKeys(firstname);

		quicksale.getlastnamefield().sendKeys(lastname);
		
		quicksale.getaddress1field().sendKeys(Address);
		quicksale.getcityfield().clear();
		Thread.sleep(2000);
		quicksale.getcityfield().sendKeys(City);
		quicksale.getstatefield().clear();
		Thread.sleep(2000);
		quicksale.getstatefield().sendKeys(State);
		quicksale.getzipcode().clear();
		Thread.sleep(2000);
		quicksale.getzipcode().sendKeys(Zip);

		quicksale.getdateofbirthfield().sendKeys(dateofbirth);
		;
		jse.executeScript("arguments[0].click();", quicksale.getbillingnamefield());
		jse.executeScript("arguments[0].click();", quicksale.getgender());

		action.sendKeys(Keys.PAGE_DOWN).click();
		action.sendKeys(Keys.CONTROL + "end" + Keys.CONTROL).perform();

		jse.executeScript("arguments[0].click();", quicksale.getcheckprivacypolicybtn());
		jse.executeScript("arguments[0].click();", quicksale.getproceedskipadditional());

		List<WebElement> Ignorebtn = driver.findElements(By.xpath("//input[@id='btnIgnore']"));

		if (Ignorebtn.size() > 0) {

			jse.executeScript("arguments[0].click();", Ignorebtn.get(0));

		}

		Select select = new Select(quicksale.getformofpayment());

		if (cardtype.equals("Visa")) {
			select.selectByIndex(5);
			quicksale.getcreditcardfield().sendKeys(visacard);

		}
		if (cardtype.equals("Mc")) {
			select.selectByIndex(4);
			quicksale.getcreditcardfield().sendKeys(mastercard);

		}

		quicksale.getcardexpmonth().sendKeys(cardexpmonthfield);
		quicksale.getcardexpyear().sendKeys(cardexpyearfield);

		jse.executeScript("arguments[0].click();", quicksale.getproceedgotobillibg());
		jse.executeScript("arguments[0].click();", quicksale.geteditplanbutton());

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

		jse.executeScript("arguments[0].click();", quicksale.getokbtn());
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		action.sendKeys(Keys.PAGE_DOWN).click();
		action.sendKeys(Keys.TAB).perform();
		action.sendKeys(Keys.TAB).perform();
		action.sendKeys(Keys.TAB).perform();
		action.sendKeys(Keys.CONTROL + "end" + Keys.CONTROL).perform();

		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		jse.executeScript("arguments[0].click();", quicksale.getproceedgotobillibg());

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

		jse.executeScript("arguments[0].click();", quicksale.getproceedgotobillibg());

			
		String Paymentopt = prop.getProperty("Paymentoption");

		if (Paymentopt.equals("PayNow")) {
			jse.executeScript("arguments[0].click();", quicksale.getpaynowbtn());

			jse.executeScript("arguments[0].click();", quicksale.getsplipaymentno());

			// jse.executeScript("arguments[0].click();",quicksale.getpaymentbycash());
			jse.executeScript("arguments[0].click();", quicksale.getpaymentbycreditcard());
			jse.executeScript("arguments[0].click();", quicksale.getselectcardtype());
			Thread.sleep(2000);

			Select select1 = new Select(driver.findElement(By.id("creditCardTypes")));

			if (cardtype.equals("Visa")) {
				select1.selectByIndex(2);
				quicksale.getcreditcardfield().sendKeys(visacard);
			}
			if (cardtype.equals("Mc")) {
				select1.selectByIndex(1);
				quicksale.getcreditcardfield().sendKeys(mastercard);
			}

			quicksale.getcardexpmonth().sendKeys(cardexpmonthfield);
			quicksale.getcardexpyear().clear();
			quicksale.getcardexpyear().sendKeys(cardexpyearfield);
			quicksale.getcvvnum().sendKeys(cvvnum);
			quicksale.getnameoncard().sendKeys(firstname);

			quicksale.getmemcity().sendKeys(City);
			// ren.getmemstate().sendKeys(state);
			quicksale.getmemzip().sendKeys(Zip);

		}

		if (Paymentopt.equals("PayLater")) {
			jse.executeScript("arguments[0].click();", quicksale.getpaylaterbtn());
		}

		jse.executeScript("arguments[0].click();", quicksale.getproceedgotobillibg());
		Thread.sleep(2000);
		// ca.takescreenshot();
		String actualConfirmMessage = driver.findElement(By.cssSelector(".control-label")).getText();
		System.out.println(actualConfirmMessage);
		Assert.assertEquals(actualConfirmMessage, expectedconfirmationmsg);

		jse.executeScript("arguments[0].click();", quicksale.getbtnapprove());
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
	
	
	
	
	
	
	
	
	

