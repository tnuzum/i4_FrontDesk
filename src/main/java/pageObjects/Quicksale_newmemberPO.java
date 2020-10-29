package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Quicksale_newmemberPO {
	
	
	public static WebDriver driver;

	By quicksalebtn = By.xpath("//a[@id='lnkQuickSal']");
 
	
	By newcontract = By.xpath("//a[@id='lnkNewContract']");
	 
	
	//By renewal = By.xpath("//a[@id='lnkRenewal']");
	
	//By findcontract = By.xpath("//a[@id='lnkFindContract']");
	
	
	
	By selectplan = By.xpath("//tbody/tr[8]/td[1]/label[1]");

	By newmemberbtn = By.xpath("//button[@id='btnNewMember']");
	
	
    By firstnamefield = By.xpath("//input[@id='txtFirstName']");

	
	By lastnamefield = By.xpath("//input[@id='txtLastName']");
	
	
	By address1field = By.xpath("//input[@id='txtAddress1']");
	 
	
	By cityfield = By.xpath("//input[@id='txtCity']");
	 
	
	By statefield = By.xpath("//input[@id='txtState']");
	
	
	
	By dateofbirthfield = By.xpath("//input[@id='txtDOB']");
	
	
	By billingnamefield = By.xpath("//input[@id='txtBillingName']");
	
	By gender = By.xpath("//body/form[@id='form1']/div[3]/section[1]/div[1]/div[4]/div[1]/div[5]/div[6]/div[1]/div[2]/label[1]/span[1]/span[2]");
	
	By mobilenumberfield = By.xpath("//input[@name='ctl00$ContentPlaceHolder1$12$txtTextBox']");
	

	By workphonefield = By.xpath("//input[@name='ctl00$ContentPlaceHolder1$9$txtTextBox']");
	
	By emailfield = By.xpath("//input[@name='ctl00$ContentPlaceHolder1$13$txtTextBox']");
	
	By checkpolicybtn = By.xpath("//body/form[@id='form1']/div[3]/section[1]/div[1]/div[5]/div[2]/label[1]/span[1]/span[1]/span[2]");
	
	By proceedskipbtn = By.xpath("//a[@id='lnkProceed']");
	
	By formofpayment = By.xpath("//select[@id='ddlPayMethod']");
	////option[contains(text(),'MC')]
	
	By mastedcarddrop = By.xpath("//option[contains(text(),'MC')]");
	
	By creditcardfield = By.xpath("//input[@id='txtCardNumber']");
	
	By cardexpmonth = By.xpath("//input[@name='ctl00$ContentPlaceHolder1$txtCCMonth']");
	
	By cardexpyear = By.xpath("//input[@name='ctl00$ContentPlaceHolder1$txtCCYear']");
	
	By proceedgotoplan = By.xpath("//a[@id='btnProceed']");
	
	By editplanbutton = By.xpath("//a[@onclick='return editPlanOption()']");
	
	
	By okbtn = By.xpath("//input[@id='btnSavePlanPopup']");
	
   By paynowbtn = By.xpath("//Label[@id='lblrbPaymentOption_0']");
	
	By paylaterbtn = By.xpath("//Label[@id='lblrbPaymentOption_1']");
	
	By splipaymentno = By.xpath("//label[@id='lblrbPaymentSplitOption_1']");
	
	By splipaymentyes = By.xpath("//label[@id='lblrbPaymentSplitOption_0']");
	
	By paymentbycash = By.xpath("//Label[@id='lblchkPayMethodCash']");
	
	public Quicksale_newmemberPO(WebDriver driver) {
		Quicksale_newmemberPO.driver=driver;
		
			
	}
	
	public WebElement getquicksalebtn() {
		
		return driver.findElement(quicksalebtn);
	
	}
	public WebElement getnewcontract()
	{
		return driver.findElement(newcontract);
	
	}
	public WebElement getselectplan()
	{
		return driver.findElement(selectplan);
	
	}
	public WebElement getnewmemberbtn()
	{
		return driver.findElement(newmemberbtn);
	
	}
	public WebElement getfirstnamefield()
	{
		return driver.findElement(firstnamefield);
	
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
	public WebElement getmobilenumberfield()
	{
		return driver.findElement(mobilenumberfield);
	
	}
	public WebElement getworkphonefield()
	{
		return driver.findElement(workphonefield);
	
	}
	public WebElement getemailfield()
	{
		return driver.findElement(emailfield);
	
	}
	public WebElement getcheckpolicybtn()
	{
		return driver.findElement(checkpolicybtn);
	
	}
	public WebElement getproceedskipbtn()
	{
		return driver.findElement(proceedskipbtn);
	
	}
	
	public WebElement getformofpayment()
	{
		return driver.findElement(formofpayment);
	
	}
	public WebElement getmastercarddrop()
	{
		return driver.findElement(mastedcarddrop);
	
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

	public WebElement geteditplanbutton()
	{
		return driver.findElement(editplanbutton);
	
	}
	
	public WebElement getproceedgotoplan()
	{
		return driver.findElement(proceedgotoplan);
	
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
	
	
	
	
	

}
