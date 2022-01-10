package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MSSLoginPO {
	
	public WebDriver driver;

	// OBJECTS
	
		By userNameInput = By.id("UserName"); //text input field
		By passwordInput = By.id("Password"); //text input field
		By loginButton = By.xpath("//h3[contains(text(),'Log-In')]");
		
		
		public MSSLoginPO(WebDriver driver) {
			// TODO Auto-generated constructor stub
			this.driver = driver;
		}
	// METHODS

		public WebElement getUserNameInput()
		{
			return driver.findElement(userNameInput);
		}
		public WebElement getPasswordInput()
		{
			return driver.findElement(passwordInput);
		}
		public WebElement getLoginButton()
		{
			return driver.findElement(loginButton);
		}
		

}
