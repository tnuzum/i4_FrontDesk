package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class QuickSalesPO {
	public WebDriver driver;
	// OBJECTS
	By newContract1 = By.id("lnkNewContract");
	
	//CONSTRUCTOR
		public QuickSalesPO(WebDriver driver) {
		this.driver = driver;
				}
		
		//METHODS
		public WebElement getnewContract1()
		{
			return driver.findElement(newContract1);
		}
}
