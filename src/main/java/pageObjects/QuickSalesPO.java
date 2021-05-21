package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class QuickSalesPO {
	public WebDriver driver;
	// OBJECTS

	By quicksalebtn = By.xpath("//a[@id='lnkQuickSal']");
	
	By newContract1 = By.xpath("//a[@id = 'lnkNewContract']");

    By newmemberbtn = By.xpath("//button[@id='btnNewMember']");
    
    By barcode = By.id("txtBarcode");
	
    By firstnamefield = By.xpath("//input[@id='txtFirstName']");

	By lastnamefield = By.xpath("//input[@id='txtLastName']");
	
	By address1field = By.xpath("//input[@id='txtAddress1']");
	 
	By cityfield = By.xpath("//input[@id='txtCity']");
	 
	By statefield = By.xpath("//input[@id='txtState']");
	
	By zipcode = By.id("txtZip");
	
	By dateofbirthfield = By.xpath("//input[@id='txtDOB']");
	
	By billingnamefield = By.xpath("//input[@id='txtBillingName']");
	
	By gender = By.xpath("//body/form[@id='form1']/div[3]/section[1]/div[1]/div[4]/div[1]/div[5]/div[6]/div[1]/div[2]/label[1]/span[1]/span[2]");
	
    By checkprivacypolicybtn = By.xpath("//body/form[@id='form1']/div[3]/section[1]/div[1]/div[5]/div[2]/label[1]/span[1]/span[1]/span[2]");
	
	By proceedskipadditional = By.xpath("//a[@id='lnkProceed']");
	
	By formofpayment = By.xpath("//select[@id='ddlPayMethod']");
	
    By creditcardfield = By.xpath("//input[@id='txtCardNumber']");
	
	By cardexpmonth = By.xpath("//input[@name='ctl00$ContentPlaceHolder1$txtCCMonth']");
	
	By cardexpyear = By.xpath("//input[@name='ctl00$ContentPlaceHolder1$txtCCYear']");
	
	By proceedgotobillibg = By.id("btnProceed");
	
    By editplanbutton = By.xpath("//a[@onclick='return editPlanOption()']");
	
	By okbtn = By.xpath("//input[@id='btnSavePlanPopup']");
	
    By paynowbtn = By.xpath("//Label[@id='lblrbPaymentOption_0']");
	
	By paylaterbtn = By.xpath("//Label[@id='lblrbPaymentOption_1']");
	
	By splipaymentno = By.xpath("//label[@id='lblrbPaymentSplitOption_1']");
	
	By splipaymentyes = By.xpath("//label[@id='lblrbPaymentSplitOption_0']");
	
	By paymentbycash = By.xpath("//Label[@id='lblchkPayMethodCash']");
	
   By paymentbycreditcard = By.xpath("//label[@id='lblchkPayMethodCreditCard']");
   
   By selectcardtype = By.xpath("//select[@id='creditCardTypes']");
   
   By cvvnum = By.xpath("//input[@id='txtxCVM']");
   
   By nameoncard = By.id("txtNameOnCard");
	
	By memaddress = By.id("txtAddress");
	
	By memcity = By.id("txtCity");
	
	By memstate = By.id("txtxState");
	
	By memzip = By.id("txtxZip");
	
	By gotohome = By.id("btnHome");
	
	By btnapprove = By.cssSelector("a#btnApprove");
	
	//By ZeroDollarPaymentbtnProceed = By.xpath("//a[@id='btnProceed']");
	
	//CONSTRUCTOR
		public QuickSalesPO(WebDriver driver) {
		this.driver = driver;
				}
		
		
		//METHODS
		public WebElement getquicksalebtn() {
			
			return driver.findElement(quicksalebtn);
		
		}
		public WebElement getnewContract1()
		{
			return driver.findElement(newContract1);
		}
		
		public WebElement getnewmemberbtn()
		{
			return driver.findElement(newmemberbtn);
		
		}
		public WebElement getfirstnamefield() 
		{
			return driver.findElement(firstnamefield);
		
		}
		public WebElement getbarcode()
		{
			return driver.findElement(barcode);
		
		}
		public WebElement getlastnamefield()
		{
			return driver.findElement(lastnamefield);
		
		}
		public WebElement getaddress1field()
		{
			return driver.findElement(address1field);
		
		}
		public WebElement getcityfield()
		{
			return driver.findElement(cityfield);
		
		}
		public WebElement getstatefield()
		{
			return driver.findElement(statefield);
		
		}
		public WebElement getzipcode()
		{
			return driver.findElement(zipcode);
		
		}
		public WebElement getdateofbirthfield()
		{
			return driver.findElement(dateofbirthfield);
		
		}
		public WebElement getbillingnamefield()
		{
			return driver.findElement(billingnamefield);
		
		}
		public WebElement getgender()
		{
			return driver.findElement(gender);
		
		}
		public WebElement getcheckprivacypolicybtn()
		{
			return driver.findElement(checkprivacypolicybtn);
		
		}
		public WebElement getproceedskipadditional()
		{
			return driver.findElement(proceedskipadditional);
		
		}
		public WebElement getformofpayment()
		{
			return driver.findElement(formofpayment);
		
		}
		public WebElement getcreditcardfield()
		{
			return driver.findElement(creditcardfield);
		
		}
		public WebElement getcardexpmonth()
		{
			return driver.findElement(cardexpmonth);
		
		}
		public WebElement getcardexpyear()
		{
			return driver.findElement(cardexpyear);
		
		}
		public WebElement getproceedgotobillibg()
		{
			return driver.findElement(proceedgotobillibg);
		
		}
		public WebElement geteditplanbutton()
		{
			return driver.findElement(editplanbutton);
		
		}
		public WebElement getokbtn()
		{
			return driver.findElement(okbtn);
		
		}
		public WebElement getpaynowbtn()
		{
			return driver.findElement(paynowbtn);
		
		}
		public WebElement getpaylaterbtn()
		{
			return driver.findElement(paylaterbtn);
		
		}
		public WebElement getsplipaymentno()
		{
			return driver.findElement(splipaymentno);
		
		}
		public WebElement getsplipaymentyes()
		{
			return driver.findElement(splipaymentyes);
		
		}
		public WebElement getpaymentbycash()
		{
			return driver.findElement(paymentbycash);
		
		}
		public WebElement getpaymentbycreditcard()
		{
			return driver.findElement(paymentbycreditcard);
		
		}
		public WebElement getselectcardtype()
		{
			return driver.findElement(selectcardtype);
		
		}
		public WebElement getcvvnum()
		{
			return driver.findElement(cvvnum);
		
		}
		public WebElement getnameoncard()
		{
			return driver.findElement(nameoncard);
		
		}
		public WebElement getmemaddress()
		{
			return driver.findElement(memaddress);
		
		}
		public WebElement getmemcity()
		{
			return driver.findElement(memcity);
		
		}
		public WebElement getmemstate()
		{
			return driver.findElement(memstate);
		
		}
		public WebElement getmemzip()
		{
			return driver.findElement(memzip);
		
		}
		public WebElement getgotohome() 
		{
			return driver.findElement(gotohome);
		
		}
		public WebElement getbtnapprove() 
		{
			return driver.findElement(btnapprove);
		
		}
		


		
}
