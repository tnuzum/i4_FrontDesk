package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class POSmodulePO {
	
	
	public  WebDriver driver;

	By POSmodulebtn = By.xpath("//a[@id='lnkWebPOS']");
	

	By memberbarcode = By.xpath("//a[@class='btn btn-sm btn-primary floatleft']");
	

     By barcodeid = By.xpath("//input[@id='ContentPlaceHolder1_ctl01_txtbarcodeId']");
	

	By firstname = By.xpath("//input[@id='ContentPlaceHolder1_ctl01_txtfirstName']");
	

     By lastname = By.xpath("//input[@id='ContentPlaceHolder1_ctl01_txtlastName']");
	

	By  searchbtn = By.xpath("//a[@id='ContentPlaceHolder1_ctl01_lnkbtnSearch']");
	 

	By selectmemberbtn = By.xpath("//input[@id='ContentPlaceHolder1_ctl01_grdsearchResult_btnSelect_5']");
	

	By pagenxt = By.xpath("[@id='ContentPlaceHolder1_ctl01_grdsearchResult_GridViewPager1_PageNext']");
	

	By itemfieldbarcode = By.xpath("//a[@id='ContentPlaceHolder1_btnSelect']");
	

	By  inventorybtn = By.xpath("//input[@id='ContentPlaceHolder1_rbtnItemTypeList_0']");
	

	By  itemsearch = By.xpath("//a[@id='ContentPlaceHolder1_btnSearch']");


	By teaselect = By.xpath("//a[@id='ContentPlaceHolder1_grdItems_btnSelect_2']");
	

	By itemselect = By.xpath("//a[@id='ContentPlaceHolder1_grdItems_btnSelect_4']");
	
	// By servicebtn = By.xpath("//input[@id='ContentPlaceHolder1_rbtnItemTypeList_1']");


	// By personaltraining = By.xpath("//input[@id='ContentPlaceHolder1_rbtnItemTypeList_2']");
	


	// By giftcardbtn = By.xpath("//input[@id='ContentPlaceHolder1_rbtnItemTypeList_5']");


	// By deletebtn = By.xpath("//a[@class='btn btn-danger btn-lg checkb100']");
	

	By closebtn = By.xpath("//input[@name='ctl00$ContentPlaceHolder1$btnCloseCart']");
	

	By billproceed = By.xpath("//a[@id='ContentPlaceHolder1_lnkBtnTotal']");
	

	By cashbtn = By.xpath("//a[@id='ContentPlaceHolder1_lnkbtnCASH']");
	

	By  mastercard = By.xpath("//a[@id='ContentPlaceHolder1_lnkbtnCreditCard1']");
	

	By security = By.id("ContentPlaceHolder1_ucAcceptCCPayment_txtCVM");
	

	By paymentprocess =  By.xpath("//a[@id='ContentPlaceHolder1_lnkbtnProcesspayment']");


	By history = By.xpath("//a[@class='btn btn-primary btn-sm mrs']");


	By closehistory = By.xpath("//a[@class='btn btn-warning mrm']");
	

	public POSmodulePO(WebDriver driver) {
		this.driver = driver;

		
	}
	
	public WebElement getPOSmodulebtn()
	{
		return driver.findElement(POSmodulebtn);
	
	}
	public WebElement getmemberbarcode()
	{
		return driver.findElement(memberbarcode);
	}
	
	
	public WebElement getfirstname()
	{
		return driver.findElement(firstname);
	}
	
	public WebElement getlastname()
	{
		return driver.findElement(lastname);
	}
	
	public WebElement getsearchbtn ()
	{
		return driver.findElement(searchbtn );
	}
	
	public WebElement getselectmemberbtn()
	{
		return driver.findElement(selectmemberbtn);
	}
	
	public WebElement getpagenxt()
	{
		return driver.findElement(pagenxt);
	}
	
	public WebElement getitemfieldbarcode()
	{
		return driver.findElement(itemfieldbarcode);
	}
	
	public WebElement getinventorybtn()
	{
		return driver.findElement(inventorybtn);
	}
	
	public WebElement getitemsearch()
	{
		return driver.findElement(itemsearch);
	}
	
	public WebElement getitemselect()
	{
		return driver.findElement(itemselect);
	}
	public WebElement getclosebtn()
	{
		return driver.findElement(closebtn);
	}
	public WebElement getbillproceed()
	{
		return driver.findElement(billproceed);
	}
	public WebElement getcashbtn()
	{
		return driver.findElement(cashbtn);
	}
	
	public WebElement getmastercard()
	{
		return driver.findElement(mastercard);
	}
	public WebElement getsecurity()
	{
		return driver.findElement(security);
	}
	public WebElement getpaymentprocess()
	{
		return driver.findElement(paymentprocess);
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
