package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePO {
	public WebDriver driver;
	// OBJECTS
	By quickSalesTab = By.id("lnkQuickSal");
	By POSTab1 = By.id("lnkWebPOS");



	//CONSTRUCTOR
	public HomePO(WebDriver driver) {
	this.driver = driver;
}
	//METHODS
	public WebElement getquickSalesTab()
	{
		return driver.findElement(quickSalesTab);
	}
	
	
	public WebElement getPOSTab1()
	{
		return driver.findElement(POSTab1);
	}

}
