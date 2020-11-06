package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class QuickSalesPO {
	public WebDriver driver;
	// OBJECTS
	By newContract1 = By.id("lnkNewContract");
	//By selectPlan1Radiobtn = By.xpath("//td[contains(text(), 'Seema's Open ended')]/../td/input");
	//By selectPlan1Radiobtn = By.xpath("//tbody/tr[2]/td[1]/label/input");
	
	By selectPlan1Radiobtn = By.xpath("//tbody/tr[8]/td[1]/label[1]/span[1]/span[2]");
	//By selectPlan1Radiobtn = By.xpath("//td[contains(text(),'!Seema's Open ended')]");
	//	By plan = By.tagName("td");  
	//	public List<WebElement> getplan()
	//{​​​​​
	//return driver.findElements(plan);
	//}​​​​​
	By existingMember1 = By.id("btnExistingMember");
	By searchMember1 = By.id("txtBarCode");
	By selectMember1 = By.id("linkbtn");
	By goTobilling1 = By.id("btnGoToBilling");
	By planDetailsbtnProceed1 = By.id("btnProceed");
	By planPaymentbtnProceed = By.id("btnProceed");
	//By btnContinue1 = By.xpath("//input[@Value='Continue']");
	By btnContinue1 = By.id("btnContinue");
	//By ZeroDollarPaymentbtnProceed = By.xpath("//*[contains(text()='Continue with Zero $ Sale')]");
	
	By ZeroDollarPaymentbtnProceed = By.xpath("//a[@id='btnProceed']");
	//CONSTRUCTOR
		public QuickSalesPO(WebDriver driver) {
		this.driver = driver;
				}
		
		//METHODS
		public WebElement getnewContract1()
		{
			return driver.findElement(newContract1);
		}
		public WebElement getselectPlan1Radiobtn()
		{
			return driver.findElement(selectPlan1Radiobtn);
		}
		public WebElement getexistingMember1()
		{
			return driver.findElement(existingMember1);
		}
		public WebElement getsearchMember1()
		{
			return driver.findElement(searchMember1);
		}
		public WebElement getselectMember1()
		{
			return driver.findElement(selectMember1);
		}
		public WebElement getgoTobilling1()
		{
			return driver.findElement(goTobilling1);
		}
		public WebElement getplanDetailsbtnProceed1()
		{
			return driver.findElement(planDetailsbtnProceed1);
		}
		public WebElement getplanPaymentbtnProceed()
		{
			return driver.findElement(planPaymentbtnProceed);
		}
		public WebElement getbtnContinue1()
		{
			return driver.findElement(btnContinue1);
		}
		
		public WebElement getZeroDollarPaymentbtnProceed()
		{
			return driver.findElement(ZeroDollarPaymentbtnProceed);
		}
		
}
