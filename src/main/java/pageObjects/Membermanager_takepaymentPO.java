package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Membermanager_takepaymentPO {

	public WebDriver driver;

	// verify Member Management
	By Pageheader = By.cssSelector("span#lbltitle");// Member Management

	By Memberbarcode = By.cssSelector("input#ContentPlaceHolder1_txtBarCode");

	By searchAllClubsbtn = By.cssSelector("a#ContentPlaceHolder1_btnSubmit3");

	By Managebtn = By.xpath("//input[@value='Manage']");
	// WEB-104269
	By CheckInHistory = By.xpath("//a[@href='MemberCheckInHistory.aspx']");

	By CheckinTitle = By.xpath("//a[@title ='Check In History']");

	By CheckinHistory_backbtn = By.cssSelector("a#btnBack");

	By FamilyMembers = By.cssSelector("a#ContentPlaceHolder1_btnFamilyMember");

	By Classeslink = By.cssSelector("a#ContentPlaceHolder1_btnClass");

	By Changerequestlink = By.cssSelector("a#ContentPlaceHolder1_changeRequestLink");

	By VerifyfamilyOf = By.xpath("//div[@class='row']/h5");

	By FamilyTitle = By.xpath("//a[@title='Family Member']");

	By Backbtn = By.cssSelector("a#ContentPlaceHolder1_btnBack");

	By membermanager = By.xpath("//a[@id='lnkMemberManager']");

	// By statuss = By.id("ContentPlaceHolder1_ddlStatus");

	// By billingproblemstatus = By.xpath("//option[@value='5']");

	By getpaymentbtn = By.id("ContentPlaceHolder1_btnGetPayment");

	By paymentamount = By.id("txtAmount");

	By ddlcategory = By.xpath("//select[@id='ddlCategory']");

	By selectcategory = By.xpath("//option[@value='6']"); // Collections

	By emailreceipt = By.id("chkEmailReceipt");

	// By autoapplynextbtn = By.id("btnAutoApplyNextPayment");
	By autoapplynextbtn = By.xpath("//a[@id='btnOKPreConfirmAppliedPayment']");

	By applytospecificbalance = By.id("rbtnAutoApplyToSpecificBalance");

	By btnokappliedpayment = By.id("btnOKPreConfirmAppliedPayment");

	By cancelbtn = By.id("btnCancelPreConfirmAppliedPayment");

	By usediffcard = By.id("rbtnUseDiffCard");

	By cardonaccount = By.id("rbtnCreditOnAccount");

	By ccpaymenttype = By.id("ddlDiffCCPaymentMethodType");

	By ccardmc = By.xpath("//option[@value='11']");

	By ccardvisa = By.xpath("//option[@value='12']");

	By ccardnumber = By.id("txtDiffCCcardNumber");

	By ccexpmonth = By.id("ddlDiffCCExpiryMonth");

	By ccexpyear = By.id("ddlDiffCCExpiryYear");

	By makepaymentbtn = By.id("btnCCMakePayment");

	By confirmbtn = By.xpath("//a[@id='btnConfirm']");

	By updateokbtn = By.id("btnOKConfirmModal");

	By donebtn = By.id("btnDone");

	public Membermanager_takepaymentPO(WebDriver driver) {

		this.driver = driver;

	}

	public WebElement getmembermanager() {

		return driver.findElement(membermanager);

	}

	public WebElement getMemberbarcode() {

		return driver.findElement(Memberbarcode);

	}

	public WebElement getsearchAllClubsbtn() {

		return driver.findElement(searchAllClubsbtn);

	}

	public WebElement getManagebtn() {

		return driver.findElement(Managebtn);

	}

	public WebElement getCheckInHistory() {

		return driver.findElement(CheckInHistory);

	}

	public WebElement getCheckinHistory_backbtn() {

		return driver.findElement(CheckinHistory_backbtn);

	}

	public WebElement getFamilyMembers() {

		return driver.findElement(FamilyMembers);

	}

	public WebElement getBackbtn() {

		return driver.findElement(Backbtn);

	}

	public WebElement getFamilyTitle() {

		return driver.findElement(FamilyTitle);

	}

	public WebElement getVerifyfamilyOf() {

		return driver.findElement(VerifyfamilyOf);

	}

	public WebElement getClasseslink() {

		return driver.findElement(Classeslink);

	}

	public WebElement getCheckinTitle() {

		return driver.findElement(CheckinTitle);

	}

	public WebElement getgetpaymentbtn() {

		return driver.findElement(getpaymentbtn);

	}

	public WebElement getpaymentamount() {

		return driver.findElement(paymentamount);

	}

	public WebElement getddlcategory() {

		return driver.findElement(ddlcategory);

	}

	public WebElement getselectcategory() {

		return driver.findElement(selectcategory);

	}

	public WebElement getemailreceipt() {

		return driver.findElement(emailreceipt);

	}

	public WebElement getautoapplynextbtn() {

		return driver.findElement(autoapplynextbtn);

	}

	public WebElement getapplytospecificbalance() {

		return driver.findElement(applytospecificbalance);

	}

	public WebElement getbtnokappliedpayment() {

		return driver.findElement(btnokappliedpayment);

	}

	public WebElement getcancelbtn() {

		return driver.findElement(cancelbtn);

	}

	public WebElement getusediffcard() {

		return driver.findElement(usediffcard);

	}

	public WebElement getcardonaccount() {

		return driver.findElement(cardonaccount);

	}

	public WebElement getccpaymenttype() {

		return driver.findElement(ccpaymenttype);

	}

	public WebElement getccardmc() {

		return driver.findElement(ccardmc);

	}

	public WebElement getccardvisa() {

		return driver.findElement(ccardvisa);

	}

	public WebElement getccardnumber() {

		return driver.findElement(ccardnumber);

	}

	public WebElement getccexpmonth() {

		return driver.findElement(ccexpmonth);
	}

	public WebElement getccexpyear() {

		return driver.findElement(ccexpyear);

	}

	public WebElement getmakepaymentbtn() {

		return driver.findElement(makepaymentbtn);

	}

	public WebElement getconfirmbtn() {

		return driver.findElement(confirmbtn);

	}

	public WebElement getupdateokbtn() {

		return driver.findElement(updateokbtn);

	}

	public WebElement getdonebtn() {

		return driver.findElement(donebtn);

	}
}
