package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class POSPO {

	public WebDriver driver;
	// OBJECTS
	
	
	By memberbarcode = By.xpath("//a[@class='btn btn-sm btn-primary floatleft']");
	
    By barcodeid = By.xpath("//input[@id='ContentPlaceHolder1_ctl01_txtbarcodeId']");
    
    By lastname = By.xpath("//input[@id='ContentPlaceHolder1_ctl01_txtlastName']");
    
    By  searchbtn = By.xpath("//a[@id='ContentPlaceHolder1_ctl01_lnkbtnSearch']");
	 
	By selectmemberbtn = By.xpath("//input[@name='ctl00$ContentPlaceHolder1$ctl01$grdsearchResult$ctl02$btnSelect']");
	
	By itemBarcode1 = By.id("ContentPlaceHolder1_btnSelect");
	
    By  inventorybtn = By.xpath("//input[@id='ContentPlaceHolder1_rbtnItemTypeList_0']");
	
	By  itemsearch = By.xpath("//a[@id='ContentPlaceHolder1_btnSearch']");
	
	//By itemBarcodeSearch1 = By.xpath("//a[@type=\"submit\"]");
	By itemSelect = By.id("ContentPlaceHolder1_grdItems_btnSelect_4");
	
	By closebtn = By.xpath("//input[@name='ctl00$ContentPlaceHolder1$btnCloseCart']");
	
	By proceedBtn = By.id("ContentPlaceHolder1_lnkBtnTotal");
	
	By cashbtn = By.xpath("//a[@id='ContentPlaceHolder1_lnkbtnCASH']");
	
    By  mastercard = By.xpath("//a[@id='ContentPlaceHolder1_lnkbtnCreditCard1']");
    
    By coupon = By.id("ContentPlaceHolder1_lnkbtnCOUPON");
    
    By couponrefference = By.id("ContentPlaceHolder1_txtReference1");
    
    By cardholdername = By.id("ContentPlaceHolder1_ucAcceptCCPayment_txtNameOnCard");
    
    By cardnumber = By.id("ContentPlaceHolder1_ucAcceptCCPayment_txtCardNumber");
    
    By expirymonth = By.id("ContentPlaceHolder1_ucAcceptCCPayment_drpCCExpiryMonth");
    
    By expiryyear = By.id("ContentPlaceHolder1_ucAcceptCCPayment_drpCCExpiryYear");
	
    By cvv = By.id("ContentPlaceHolder1_ucAcceptCCPayment_txtCVM");

	By security = By.id("ContentPlaceHolder1_ucAcceptCCPayment_txtCVM");
	

	By processPayment1 = By.id("ContentPlaceHolder1_lnkbtnProcesspayment");

	By submitbtn = By.id("ContentPlaceHolder1_ucAcceptCCPayment_lnkSubmit");

	By history = By.xpath("//a[@class='btn btn-primary btn-sm mrs']");


	By closehistory = By.xpath("//a[@class='btn btn-warning mrm']");
	
				
	//CONSTRUCTOR
	public POSPO(WebDriver driver) {
		this.driver = driver;
	}
	
	//METHODS
	public WebElement getmemberbarcode()
	{
	return driver.findElement(memberbarcode);
	}
	public WebElement getbarcodeid()
	{
		return driver.findElement(barcodeid);
		
	}

	public WebElement getlastname()
	{
		return driver.findElement(lastname);
		
	}
	public WebElement getsearchbtn()
	{
		return driver.findElement(searchbtn);
	}
	
	public WebElement getselectmemberbtn()
	{
		return driver.findElement(selectmemberbtn);
	}
	public WebElement getitemBarcode1()
	{
		return driver.findElement(itemBarcode1);
	}
	public WebElement getinventorybtn()
	{
		return driver.findElement(inventorybtn);
	}
	public WebElement getitemsearch()
	{
		return driver.findElement(itemsearch);
	}
	public WebElement getitemSelect()
	{
		return driver.findElement(itemSelect);
	}
	public WebElement getproceedBtn()
	{
		return driver.findElement(proceedBtn);
	}
	public WebElement getcashbtn()
	{
		return driver.findElement(cashbtn);
	}
	public WebElement getmastercard()
	{
		return driver.findElement(mastercard);
	}
	public WebElement getcouponrefference()
	{
		return driver.findElement(couponrefference);
	}
	public WebElement getcoupon()
	{
		return driver.findElement(coupon);
	}
	public WebElement getcardholdername()
	{
		return driver.findElement(cardholdername);
	}
	public WebElement getcardnumber()
	{
		return driver.findElement(cardnumber);
	}
	public WebElement getexpirymonth()
	{
		return driver.findElement(expirymonth);
	}
	public WebElement getexpiryyear()
	{
		return driver.findElement(expiryyear);
	}
	public WebElement getcvv()
	{
		return driver.findElement(cvv);
	}
	
	public WebElement getsecurity()
	{
		return driver.findElement(security);
	}
	public WebElement getsubmitbtn()
	{
		return driver.findElement(submitbtn);
	}
	public WebElement getprocessPayment1()
	{
		return driver.findElement(processPayment1);
	}
	public WebElement gethistory()
	{
		return driver.findElement(history);
	}
	public WebElement getclosehistory()
	{
		return driver.findElement(closehistory);
	}
	
}
