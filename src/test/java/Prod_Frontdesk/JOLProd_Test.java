package Prod_Frontdesk;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pageObjects.JOLPO;
import resources.CustomActions;
import resources.base;

@Listeners(resources.Listeners.class)

public class JOLProd_Test extends base {

	private static String firstname = "Auto11";
	private static String lastname = "tes12222";
	private static String address1 = "caaabbgg";
	private static String city = "eretht";
	private static String state = "NS";
	private static String zipcode = "447752";
	private static String email = "t7776@gmail.com";
	private static String dateofbirth = "02/02/1991";
	private static String downCCNo = "5454545454545454";
	private static String downCCname = "Test";
	private static String downCCexp = "01/2022";
	private static String downCCCvv = "123";

	private static JavascriptExecutor jse;

	public SoftAssert softAssertion = new SoftAssert();

	public CustomActions ca;
	public JOLPO jol;

	public JOLProd_Test() {
		ca = new CustomActions();

		String classname = this.getClass().getSimpleName();
		System.out.println("classname :" + classname);
	}

	@BeforeClass
	public void initialize() throws Exception {
		driver = initializeDriver();
		ca.setDriver(driver);

		driver.get(prop.getProperty("JOLProdURL"));

		jse = (JavascriptExecutor) driver;
		jol = new JOLPO(driver);

	}

	@Test(priority = 1, description = "page header")

	public void pageheader() throws Exception {

		Assert.assertEquals("Select A Gym", jol.getpageheader().getText());
		Assert.assertTrue(jol.getSelectcityheader().getText().contains("Filter By Location:"));
//System.out.println(jol.getSelectcityheader().getText());

		List<WebElement> clubs = driver.findElements(By.tagName("h2"));

		System.out.println(clubs.size());

		for (int i = 0; i < clubs.size(); i++) {

			System.out.println(clubs.get(i).getText());

		}

	}

	@Test(priority = 2, description = "Select Club")

	public void SelectClub() throws Exception {
		Assert.assertEquals("Executive Fitness Club", jol.getclubheader().getText());
		Assert.assertTrue(jol.getclublocation().isDisplayed());
		Assert.assertTrue(jol.getclubimage().isDisplayed());

		int viewplan = driver.findElements(By.xpath("//a[contains(text(),'View Plans')]")).size();
		// System.out.println(viewplan);
		Thread.sleep(2000);
		for (int i = 0; i < viewplan; i++) {

			String club = driver.findElements(By.xpath("//div[@class='span8']/div/h2")).get(i).getText();

			if (club.contains("Executive Fitness Club")) {
				jse.executeScript("arguments[0].click();",
						driver.findElements(By.xpath("//a[contains(text(),'View Plans')]")).get(i));

				break;

			}
		}

	}

	@Test(priority = 3, description = "Select Plan and Change Plan")

	public void SelectPlan() throws Exception {
		Actions action = new Actions(driver);

		// Assert.assertTrue(jol.getvistedlink().isDisplayed());
		Assert.assertTrue(jol.getfeaturedplanslabel().getText().contains("Featured Plans"));

		action.sendKeys(Keys.PAGE_DOWN).perform();

		Assert.assertTrue(jol.getViewAllPlans().getText().contains("View All Plans"));
		int plans = driver.findElements(By.xpath("//section[@class='allPlans']/div/div/div/div")).size();
		// System.out.println(plans);
		Thread.sleep(2000);
		for (int i = 0; i < plans; i++) {
			String planname = driver.findElements(By.xpath("//div[@class='span8']/div/h2")).get(i).getText();
			if (planname.contains("Test $1")) {

				jse.executeScript("arguments[0].click();",
						driver.findElements(By.xpath("//div[@class='span4 pricing-table']/ul/li/a")).get(i));

				break;
			}

		}

		Thread.sleep(400);

		Assert.assertTrue(jol.getchangeplanlink().isDisplayed());
		jse.executeScript("arguments[0].click();", jol.getchangeplanlink());

		Assert.assertTrue(jol.getfeaturedplanslabel().getText().contains("Featured Plans"));

	}
@Test(priority = 4, groups = { "Regression" }, description = "sell a plan End to End")

public void Sellplan() throws Exception {
	

	Assert.assertTrue(jol.getfeaturedplanslabel().getText().contains("Featured Plans"));
	Actions action = new Actions(driver);

	action.sendKeys(Keys.PAGE_DOWN).perform();

	int plans = driver.findElements(By.xpath("//section[@class='allPlans']/div/div/div/div")).size();
	//System.out.println(plans);
	Thread.sleep(2000);
	for (int i = 0; i < plans; i++) {
		String planname = driver.findElements(By.xpath("//div[@class='span8']/div/h2")).get(i).getText();
		if (planname.contains("Test $1")) {

			jse.executeScript("arguments[0].click();",
					driver.findElements(By.xpath("//div[@class='span4 pricing-table']/ul/li/a")).get(i));

			break;
		}

	}

	Thread.sleep(400);

	Assert.assertTrue(jol.getchangeplanlink().isDisplayed());

	jse.executeScript("arguments[0].click();", jol.getcontinuebtn());
	Thread.sleep(400);

	Assert.assertTrue(jol.getbackbtn().getText().contains("Back"));

	// Member information
	jol.getFirstnamefield().sendKeys(firstname);
	jol.getLastnamefield().sendKeys(lastname);
	jol.getAddress1field().sendKeys(address1);
	jol.getCityfield().sendKeys(city);
	jol.getStatefield().sendKeys(state);
	jol.getZipfield().sendKeys(zipcode);
	jol.getEmailfield().sendKeys(email);
	jol.getDateofBirthfield().sendKeys(dateofbirth);
	// driver.findElement(By.cssSelector("input#homePhone")).click();
	jol.getCityfield().click();
	Thread.sleep(200);
	action.sendKeys(Keys.PAGE_DOWN).perform();
	jol.getDownCCNofield().sendKeys(downCCNo);
	jol.getDownCCNamefield().sendKeys(downCCname);
	jol.getDownCCExpfield().sendKeys(downCCexp);
	jol.getDownCCCVVfield().sendKeys(downCCCvv);
	jse.executeScript("arguments[0].click();", jol.getsameasdownpayment());
	jse.executeScript("arguments[0].click();", jol.getReviewAndConfirmlink());

	Thread.sleep(200);
	Assert.assertTrue(jol.getconfirmdetailsheader().isDisplayed());

	// Confirm details
	jse.executeScript("window.scrollBy(0,400)");// window scroll down

	jse.executeScript("document.querySelector('div#divReviewAgreement').scrollTop=1200");// scrolldown sub window
	Thread.sleep(200);

	jse.executeScript("window.scrollBy(0,300)");// window scroll down
	jse.executeScript("document.querySelector('div#divTermsAndCondition').scrollTop=1200");

	Thread.sleep(400);
	Assert.assertTrue(jol.getAccepttermscheckbox().isDisplayed());
	Assert.assertTrue(jol.getAccepttermscheckbox().isEnabled());

	jse.executeScript("arguments[0].click();", jol.getAccepttermscheckbox());

	jse.executeScript("arguments[0].click();", jol.getclicktoConfirm());
	Thread.sleep(200);
	Assert.assertTrue(driver.findElement(By.xpath("//h1[contains(text(),'Confirmation')]")).isDisplayed());

	List<WebElement> confirmationdetails = driver.findElements(By.xpath("//div[@class='margin10']"));
	

	for (int i = 0; i < confirmationdetails.size(); i++) {

		System.out.println(confirmationdetails.get(i).getText());

	}
	jse.executeScript("arguments[0].click();", jol.getstartoverlink());

}

@AfterClass(enabled = true)
public void teardown() {

	driver.quit();
	driver = null;
}

}


