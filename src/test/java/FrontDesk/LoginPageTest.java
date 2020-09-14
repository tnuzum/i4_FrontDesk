package FrontDesk;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pageObjects.LoginPO;
import resources.base;

public class LoginPageTest extends base{
	
	public static SoftAssert softAssertion= new SoftAssert();

	@BeforeTest
		public void initialize() throws Exception
		{
			 driver = initializeDriver();
			 driver.get(prop.getProperty("LoginPage"));
		}
	@Test (priority = 1, description="Page Title")
		public void pageTitle() {
			Assert.assertEquals(driver.getTitle(),"i4: Front Desk");
		}		
	@Test (priority = 2, description="pageVerifications", enabled = false)
		public void pageVerifications()
		{
			LoginPO l = new LoginPO(driver);
			softAssertion.assertEquals(l.getUserName().getAttribute("placeholder"), "Enter your name");
			softAssertion.assertEquals(l.getPassword().getAttribute("placeholder"), "Password");
			softAssertion.assertTrue(l.getTopOfPageLogo().isDisplayed());
			softAssertion.assertTrue(l.getBottomOfPageLogo().isDisplayed());
			softAssertion.assertEquals(l.getLoginButton().getText(), "Login");
			softAssertion.assertEquals(l.getForgotPassword().getText(), "Lost your password?");
			softAssertion.assertAll();
		}
	@Test (priority = 3, description="credentialsRequired", enabled = false)
		public void credentialsRequired()
		{
			LoginPO l = new LoginPO(driver);
			l.getLoginButton().click();
			softAssertion.assertEquals(l.getusernameRequiredMessage().getText(),"User name is required");
			softAssertion.assertEquals(l.getpasswordRequiredMessage().getText(), "Password is required");
			softAssertion.assertAll();
		}
	@Test (priority = 4, description="Wrong Credentials", enabled = false)
		public void wrongCredentials() throws InterruptedException
		{
			LoginPO l = new LoginPO(driver);
			l.getUserName().sendKeys(prop.getProperty("Employee1UserName"));
			l.getPassword().sendKeys("wrongpassword");
			l.getLoginButton().click();
				WebDriverWait wait = new WebDriverWait(driver, 10);
				wait.until(ExpectedConditions.visibilityOf(l.getcredentialsErrorMessage()));
			Assert.assertEquals(l.getcredentialsErrorMessage().getText(), "Login Failed: Please try again later or contact your club for assistance.");
		}

	@AfterTest
		public void teardown() throws InterruptedException
		{
			driver.close();
			driver=null;
		}
	
	
	
	

}
