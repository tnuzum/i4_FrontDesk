package pageObjects;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import resources.base;

public class POS extends base {

	public static WebDriver driver;

	@FindBy(xpath = "//a[@id='lnkWebPOS']")
	public WebElement POSbtn;

	@FindBy(xpath = "//a[@class='btn btn-sm btn-primary floatleft']")
	public WebElement memberbarcode;

	@FindBy(xpath = "//input[@id='ContentPlaceHolder1_ctl01_txtbarcodeId']")
	public WebElement barcodeid;

	@FindBy(xpath = "//input[@id='ContentPlaceHolder1_ctl01_txtfirstName']")
	public WebElement firstname;

	@FindBy(xpath = "//input[@id='ContentPlaceHolder1_ctl01_txtlastName']")
	public WebElement lastname;

	@FindBy(xpath = "//a[@id='ContentPlaceHolder1_ctl01_lnkbtnSearch']")
	public WebElement searchbtn;

	@FindBy(xpath = "//input[@id='ContentPlaceHolder1_ctl01_grdsearchResult_btnSelect_5']")
	public WebElement selectmemberbtn;

	@FindBy(xpath = "[@id='ContentPlaceHolder1_ctl01_grdsearchResult_GridViewPager1_PageNext']")
	public WebElement pagenxt;

	@FindBy(xpath = "//a[@id='ContentPlaceHolder1_btnSelect']")
	public WebElement itembarcode;

	@FindBy(xpath = "//input[@id='ContentPlaceHolder1_rbtnItemTypeList_0']")
	public WebElement inventorybtn;

	@FindBy(xpath = "//a[@id='ContentPlaceHolder1_btnSearch']")
	public WebElement itemsearch;

	@FindBy(xpath = "//a[@id='ContentPlaceHolder1_grdItems_btnSelect_2']")
	public WebElement teaselect;

	@FindBy(xpath = "//a[@id='ContentPlaceHolder1_grdItems_btnSelect_4']")
	public WebElement item1select;

	// @FindBy(xpath="//input[@id='ContentPlaceHolder1_rbtnItemTypeList_1']")
	// public WebElement servicebtn;

	// @FindBy(xpath="//input[@id='ContentPlaceHolder1_rbtnItemTypeList_2']")
	// public WebElement personaltraining ;

	// @FindBy(xpath="//input[@id='ContentPlaceHolder1_rbtnItemTypeList_3']")
	// public WebElement classbtn;

	// @FindBy(xpath="//input[@id='ContentPlaceHolder1_rbtnItemTypeList_4']")
	// public WebElement feebtn;

	// @FindBy(xpath="//input[@id='ContentPlaceHolder1_rbtnItemTypeList_5']")
	// public WebElement giftcardbtn;

	// @FindBy(xpath="//a[@class='btn btn-danger btn-lg checkb100']")
	// public WebElement deletebtn;

	@FindBy(xpath = "//input[@name='ctl00$ContentPlaceHolder1$btnCloseCart']")
	public WebElement closebtn;

	@FindBy(xpath = "//a[@id='ContentPlaceHolder1_lnkBtnTotal']")
	public WebElement proceed;

	@FindBy(xpath = "//a[@id='ContentPlaceHolder1_lnkbtnCASH']")
	public WebElement cashbtn;

	@FindBy(xpath = "//a[@id='ContentPlaceHolder1_lnkbtnCreditCard1']")
	public WebElement mastercard;

	@FindBy(id = "ContentPlaceHolder1_ucAcceptCCPayment_txtCVM")
	public WebElement security;

	@FindBy(xpath = "//a[@id='ContentPlaceHolder1_lnkbtnProcesspayment']")
	public WebElement paymentprocess;

	@FindBy(xpath = "//a[@class='btn btn-primary btn-sm mrs']")
	public WebElement history;

	// @FindBy(xpath="//a[@id='ContentPlaceHolder1_lnkBtnZOut']")
	// public WebElement Zout;

	@FindBy(xpath = "//a[@class='btn btn-warning mrm']")
	public WebElement closehistory;

	public POS(WebDriver driver) {
		this.driver = driver;

		PageFactory.initElements(driver, this);

	}

	public void pospage(String lastname1, String cvvcode) {
		POSbtn.click();
		
		memberbarcode.click();
		lastname.sendKeys(lastname1);
		searchbtn.click();
		selectmemberbtn.click();
		itembarcode.click();
		inventorybtn.click();
		itemsearch.click();
		item1select.click();
		
		proceed.click();

		String paymenttype = prop.getProperty("payment");
		if (paymenttype.equals("cash")) {
			cashbtn.click();
			paymentprocess.click();

		}
		if (paymenttype.equals("mastercard")) {

			mastercard.click();

			String s1 = driver.findElement(By.className("modal-content")).getText();
			// System.out.println(s1);
			String s2 = driver.findElement(By.className("modal-body")).getText();
			// System.out.println(s2);

			Select selectmonth = new Select(
					driver.findElement(By.id("ContentPlaceHolder1_ucAcceptCCPayment_drpCCExpiryMonth")));

			selectmonth.selectByVisibleText("12");
			Select selectyear = new Select(
					driver.findElement(By.id("ContentPlaceHolder1_ucAcceptCCPayment_drpCCExpiryYear")));
			selectyear.selectByVisibleText("2020");
			driver.findElement(By.id("ContentPlaceHolder1_ucAcceptCCPayment_txtCVM")).sendKeys(cvvcode);
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			
			
			
			Actions action = new Actions(driver);
			
			action.sendKeys(Keys.TAB).build().perform();
			action.sendKeys(Keys.TAB).build().perform();
			action.sendKeys(Keys.TAB).build().perform();
			action.sendKeys(Keys.TAB).build().perform();
			action.sendKeys(Keys.TAB).build().perform();
			
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			
			WebElement link = driver.findElement(By.id("ContentPlaceHolder1_ucAcceptCCPayment_lnkSubmit"));
			//action.keyDown(Keys.CONTROL).sendKeys(Keys.END).perform();
			action.doubleClick(link).perform();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			link.click();

		}

	

		//history.click();
		// closehistory.click();

	}

}
