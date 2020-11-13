package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Quicksale_renewalPO {
	
	

	public  WebDriver driver;

	By quicksalebtn = By.xpath("//a[@id='lnkQuickSal']");
 
	
	By renewal = By.xpath("//a[@id='lnkRenewal']");
	
	
	By searchbyfirstname  = By.xpath("//input[@id='txtFirstName']");
	
	By searchhomeclubbtn = By.xpath("//a[@id='btnSubmit2']");
	
	By searchallclubbtn = By.xpath("//a[@id='btnSubmit3']");
	
	By selectmemberbtn = By.xpath("//tbody/tr[3]/td[1]/a[1]");
	
	By plannametxt = By.xpath("//td[contains(text(),\"!uma's open ended plan\")]");
	
	By selectplanforrenewal = By.xpath("//tbody/tr[9]/td[1]/label[1]");     //19
	
	By proceedexistingbtn = By.xpath("//button[@title='Prospect or Existing Member']");
	
	By checkprivacypolicybtn = By.xpath("//body/form[@id='form1']/div[3]/section[1]/div[1]/div[4]/div[2]/label[1]/span[1]/span[1]/span[2]");
	
	By proceedgotobilling = By.xpath("//a[@id='btnProceed']");
	
	By formofpayment = By.xpath("//select[@id='ddlPayMethod']");
	////option[contains(text(),'MC')]
	
	By mastedcarddrop = By.xpath("//option[contains(text(),'MC')]");
	
	By visacarddrop = By.xpath("//option[contains(text(),'Visa')]");
	
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
	
	By paymentbycreditcard = By.xpath("//label[@id='lblchkPayMethodCreditCard']");
	
	By selectcardtype = By.xpath("//select[@id='creditCardTypes']");
	
	By cvvnum = By.xpath("//input[@id='txtxCVM']");
	
	//By nameoncard = By.id("txtNameOnCard");
	
	//By memaddress = By.id("txtAddress");
	
	//By memcity = By.id("txtCity");
	
	//By  = By.id("txtNameOnCard");
	
	//By  = By.id("txtNameOnCard");
	
	public Quicksale_renewalPO(WebDriver driver) {
		
		this.driver=driver;
				
	}
	
	public WebElement getquicksalebtn() {
		
		return driver.findElement(quicksalebtn);
	
	}
	public WebElement getrenewal() {
		
		return driver.findElement(renewal);
	
	}
	public WebElement getsearchbyfirstname() {
		
		return driver.findElement(searchbyfirstname);
	
	}
public WebElement getselectmemberbtn() {
		
		return driver.findElement(selectmemberbtn);
	
	}
   public WebElement getsearchallclubbtn() {
		
		return driver.findElement(searchallclubbtn);
	
	}
   public WebElement getselectplanforrenewal() {
		
		return driver.findElement(selectplanforrenewal);
	
	}
   public WebElement getproceedexistingbtn() {
		
		return driver.findElement(proceedexistingbtn);
	
	}
   public WebElement getcheckprivacypolicybtn() {
		
 		return driver.findElement(checkprivacypolicybtn);
 	
 	}
   public WebElement getproceedgotobilling() {
		
		return driver.findElement(proceedgotobilling);
	
	}
   public WebElement getformofpayment()
	{
		return driver.findElement(formofpayment);
	
	}
   public WebElement getvisacarddrop()
  	{
  		return driver.findElement(visacarddrop);
  	
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
	public WebElement getproceedgotoplan()
	{
		return driver.findElement(proceedgotoplan);
	
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
	public WebElement getplannametxt()
	{
		return driver.findElement(plannametxt);
	
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
}