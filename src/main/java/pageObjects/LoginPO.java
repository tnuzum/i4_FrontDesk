package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPO {

	public static WebDriver driver;

	// OBJECTS
	
		By userNameInputField = By.id("ContentPlaceHolder1_txtusername"); //text input field
		By passwordInputField = By.id("ContentPlaceHolder1_txtpassword"); //text input field
		By loginButton = By.cssSelector("input[type='submit']");
//
//		By usernameRequiredMessage = By.xpath("//span[@for='UserName']");
//		By passwordRequiredMessage = By.xpath("//span[@for='Password']");
//		
//		By topOfPageLogo = By.xpath("(//div[@class='logo'])[1]");
//		By bottomOfPageLogo = By.xpath("(//div[@class='logo'])[2]");
//		
//		By credentialsErrorMessage = By.xpath("//div[@class='validation-summary-errors errorfontcolor']/ul/li");
//		By ForgotPassword = By.className("login-link");
		
		
	// CONSTRUCTOR
			
		public LoginPO(WebDriver driver) {
			// TODO Auto-generated constructor stub
			LoginPO.driver = driver;
		}
	// METHODS

		public WebElement getUserNameInputField()
		{
			return driver.findElement(userNameInputField);
		}
		public WebElement getPasswordInputField()
		{
			return driver.findElement(passwordInputField);
		}
		public WebElement getLoginButton()
		{
			return driver.findElement(loginButton);
		}
//		public WebElement getcredentialsErrorMessage()
//		{
//			return driver.findElement(credentialsErrorMessage);
//		}
//		public WebElement getusernameRequiredMessage()
//		{
//			return driver.findElement(usernameRequiredMessage);
//		}
//		public WebElement getpasswordRequiredMessage()
//		{
//			return driver.findElement(passwordRequiredMessage);
//		}
//		public WebElement getForgotPassword()
//		{
//			return driver.findElement(ForgotPassword);
//		}
//		public WebElement getTopOfPageLogo()
//		{
//			return driver.findElement(topOfPageLogo);
//		}
//		public WebElement getBottomOfPageLogo()
//		{
//			return driver.findElement(bottomOfPageLogo);
//		}
}
