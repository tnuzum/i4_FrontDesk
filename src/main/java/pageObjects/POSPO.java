package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class POSPO {

	public WebDriver driver;
	// OBJECTS
	
	By itemBarcode1 = By.id("ContentPlaceHolder1_btnSelect");
	By itemBarcodeSearch1 = By.xpath("//a[@type=\"submit\"]");
	By itemSelect1 = By.id("ContentPlaceHolder1_grdItems_btnSelect_4");
	By proceedBtn1 = By.id("ContentPlaceHolder1_lnkBtnTotal");
	By cash1A = By.id("ContentPlaceHolder1_lnkbtnCashOne");
	By processPayment1 = By.id("ContentPlaceHolder1_lnkbtnProcesspayment");
				
	//CONSTRUCTOR
	public POSPO(WebDriver driver) {
		this.driver = driver;
	}
	
	//METHODS
	public WebElement getitemBarcode1()
	{
	return driver.findElement(itemBarcode1);
	}
	
	
	public WebElement getitemBarcodeSearch1()
	{
	return driver.findElement(itemBarcodeSearch1);
	}
	
	public WebElement getitemSelect1()
	{
		return driver.findElement(itemSelect1);
		
	}
	public WebElement getproceedBtn1()
	{
		return driver.findElement(proceedBtn1);
	}
	
	public WebElement getcash1A()
	{
		return driver.findElement(cash1A);
	}
	public WebElement getprocessPayment1()
	{
		return driver.findElement(processPayment1);
	}
}
