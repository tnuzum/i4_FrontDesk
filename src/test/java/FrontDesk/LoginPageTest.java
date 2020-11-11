package FrontDesk;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pageObjects.DashboardPO;
import resources.CustomActions;
import resources.base;

public class LoginPageTest extends base {

	public static SoftAssert softAssertion = new SoftAssert();

	DashboardPO d;
	String barcodeId;
	String password;

	@BeforeTest
	public void initialize() throws Exception {

		driver = initializeDriver();
		driver.get(prop.getProperty("LoginPage"));

		d = new DashboardPO(driver);
		barcodeId = prop.getProperty("employeeBarcodeId");
		password = prop.getProperty("employeePassword");
	}

	@Test(priority = 1, description = "Validate Page Title")
	public void pageTitle() {

		Assert.assertEquals(driver.getTitle(), "i4: Front Desk");
	}

	@Test(priority = 2, description = "Login To Front Desk")
	public void login() {

		d.getFrontDeskButton().click();

		CustomActions.loginEmployee(barcodeId, password);
//			softAssertion.assertEquals(d.getpasswordRequiredMessage().getText(), "Password is required");
//			softAssertion.assertAll();
	}

	@AfterTest (enabled =true)
	public void teardown() {

		driver.close();
		driver = null;
	}

}
