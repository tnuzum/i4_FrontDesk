package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPO {

	public static WebDriver driver;

	// OBJECTS
	
		By userName = By.id("UserName"); //text input field
		By password = By.id("Password"); //text input field
		By loginButton = By.id("submit");

		By usernameRequiredMessage = By.xpath("//span[@for='UserName']");
		By passwordRequiredMessage = By.xpath("//span[@for='Password']");
		
		By topOfPageLogo = By.xpath("(//div[@class='logo'])[1]");
		By bottomOfPageLogo = By.xpath("(//div[@class='logo'])[2]");
		
		By credentialsErrorMessage = By.xpath("//div[@class='validation-summary-errors errorfontcolor']/ul/li");
		By ForgotPassword = By.className("login-link");
		
		
	// CONSTRUCTOR
			
		public LoginPO(WebDriver driver) {
			// TODO Auto-generated constructor stub
			LoginPO.driver = driver;
		}
	// METHODS

		public WebElement getUserName()
		{
			return driver.findElement(userName);
		}
		public WebElement getPassword()
		{
			return driver.findElement(password);
		}
		public WebElement getLoginButton()
		{
			return driver.findElement(loginButton);
		}
		public WebElement getcredentialsErrorMessage()
		{
			return driver.findElement(credentialsErrorMessage);
		}
		public WebElement getusernameRequiredMessage()
		{
			return driver.findElement(usernameRequiredMessage);
		}
		public WebElement getpasswordRequiredMessage()
		{
			return driver.findElement(passwordRequiredMessage);
		}
		public WebElement getForgotPassword()
		{
			return driver.findElement(ForgotPassword);
		}
		public WebElement getTopOfPageLogo()
		{
			return driver.findElement(topOfPageLogo);
		}
		public WebElement getBottomOfPageLogo()
		{
			return driver.findElement(bottomOfPageLogo);
		}
}
