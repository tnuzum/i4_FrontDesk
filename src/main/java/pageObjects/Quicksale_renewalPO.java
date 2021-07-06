package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Quicksale_renewalPO {
	
	

	public  WebDriver driver;

	By quicksalebtn = By.xpath("//a[@id='lnkQuickSal']");
 
	
	By renewal = By.xpath("//a[@id='lnkRenewal']");
	
	
	//By searchbyfirstname  = By.xpath("//input[@id='txtFirstName']");
	
	By searchbybarcode  = By.xpath("//input[@id='txtBarCode']");
	
	By searchhomeclubbtn = By.xpath("//a[@id='btnSubmit2']");
	
	By searchallclubbtn = By.xpath("//a[@id='btnSubmit3']");
	
	By selectmemberbtn = By.xpath("//a[@id='linkbtn']");//tbody/tr[2]/td[1]/a[1]
	
	By plannametxt = By.xpath("//td[contains(text(),\"!uma's open ended plan\")]");
	
	By selectplanforrenewal = By.xpath("//tbody/tr[9]/td[1]/label[1]");   
	
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
	
	By Addfamilymember = By.id("btnAddFamily");
	
	By Addexistingfamilymeber = By.xpath("//a[@onclick='return existingMemberLookup()']"); 
	
	By familymemberbarcode = By.xpath("//input[@id='txtBarCodeAddExistingMember']");
	
	By searchfamilybtn = By.xpath("//a[@id='btnAddExistingMemberSearch']");
	
	By selectbtn = By.xpath("//a[@onclick='CloseAddExistingMemberWithValue(this);']");
	
	By familyfirstname = By.id("txtFirstName");
	
	By familyphone = By.id("txtWorkPhone");
	
	By familycell = By.id("txtCellPhone");
	
	By familygender =  By.xpath("//*[@id=\"tab0\"]/div[6]/div[2]/div/div[2]/label/span/span[2]");
	
	By familymemberemail = By.id("txtEmail");
	
	By customeragreepolicy = By.xpath("//*[@id=\"form1\"]/div[3]/section/div[4]/div[2]/label/span/span[3]/span/span[2]");
	
	By savebtn = By.id("btnSave");
	
	By editplanbutton = By.xpath("//a[@onclick='return editPlanOption()']");
	
	By okbtn = By.xpath("//input[@id='btnSavePlanPopup']");
	
	By proceedplanpayment = By.id("btnProceed");
	
	By paynowbtn = By.xpath("//Label[@id='lblrbPaymentOption_0']");
	
	By paylaterbtn = By.xpath("//Label[@id='lblrbPaymentOption_1']");
	
	By splitpaymentno = By.xpath("//label[@id='lblrbPaymentSplitOption_1']");
	
	By splitpaymentyes = By.xpath("//label[@id='lblrbPaymentSplitOption_0']");
	
	By cashamount = By.id("txtCashAmount");
	
	By ccamount = By.id("txtCCPayAmount");
	
	By paymentbycash = By.xpath("//Label[@id='lblchkPayMethodCash']");
	
	By paymentbycreditcard = By.xpath("//label[@id='lblchkPayMethodCreditCard']");
	
	By selectcardtype = By.xpath("//select[@id='creditCardTypes']");
	
	By cvvnum = By.xpath("//input[@id='txtxCVM']");
	
	//By continuebtn = By.id("btnContinue");
	
	By nameoncard = By.id("txtNameOnCard");
	
	By memaddress = By.id("txtAddress");
	
	By memcity = By.id("txtCity");
	
	By memstate = By.id("txtxState");
	
	By memzip = By.id("txtxZip");
	
	By gotohome = By.id("btnHome");
	
	By btnapprove = By.xpath("//a[@id='btnApprove']");
	
	By effctivedate = By.xpath("//input[@id='ctl00_ContentPlaceHolder1_txtEffectiveDate']");

	public Quicksale_renewalPO(WebDriver driver) {
		
		this.driver=driver;
				
	}
	
	public WebElement getquicksalebtn() {
		
		return driver.findElement(quicksalebtn);
	
	}
	public WebElement getrenewal() {
		
		return driver.findElement(renewal);
	
	}
	public WebElement getsearchbybarcode() {
		
		return driver.findElement(searchbybarcode);
	
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
	public WebElement getAddfamilymember()
	{
		return driver.findElement(Addfamilymember);
	
	}
	public WebElement getAddexistingfamilymeber()
	{
		return driver.findElement(Addexistingfamilymeber);
	
	}
	public WebElement getfamilymemberbarcode()
	{
		return driver.findElement(familymemberbarcode);
	
	}
	public WebElement getsearchfamilybtn()
	{
		return driver.findElement(searchfamilybtn);
	
	}
	public WebElement getselectbtn()
	{
		return driver.findElement(selectbtn);
	
	}
	public WebElement getfamilyfirstname()
	{
		return driver.findElement(familyfirstname);
	
	}
	public WebElement getfamilyphone()
	{
		return driver.findElement(familyphone);
	
	}
	public WebElement getfamilycell()
	{
		return driver.findElement(familycell);
	
	}
	public WebElement getfamilygender()
	{
		return driver.findElement(familygender);
	
	}
	public WebElement getfamilymemberemail()
	{
		return driver.findElement(familymemberemail);
	}
	public WebElement getsavebtn()
	{
		return driver.findElement(savebtn);
	
	}
	public WebElement getcustomeragreepolicy() 
	{
		return driver.findElement(customeragreepolicy);
	}
	
	public WebElement geteditplanbutton()
	{
		return driver.findElement(editplanbutton);
	
	}
	public WebElement geteffctivedate()
	{
		return driver.findElement(effctivedate);
	
	}
	public WebElement getokbtn()
	{
		return driver.findElement(okbtn);
	
	}
	public WebElement getproceedplanpayment()
	{
		return driver.findElement(proceedplanpayment);
	
	}
	public WebElement getpaynowbtn()
	{
		return driver.findElement(paynowbtn);
	
	}
	public WebElement getpaylaterbtn()
	{
		return driver.findElement(paylaterbtn);
	
	}
	public WebElement getsplitpaymentno()
	{
		return driver.findElement(splitpaymentno);
	
	}
	public WebElement getsplitpaymentyes()
	{
		return driver.findElement(splitpaymentyes);
	
	}
	public WebElement getcashamount()
	{
		return driver.findElement(cashamount);
	
	}
	public WebElement getccamount()
	{
		return driver.findElement(ccamount);
	
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
