package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Membermanager_takepaymentPO {
	
	
	public WebDriver driver;
	
	By membermanager = By.xpath("//a[@id='lnkMemberManager']");
	
	By statuss = By.id("ContentPlaceHolder1_ddlStatus");
	
	By barcodeid = By.xpath("//input[@name='ctl00$ContentPlaceHolder1$txtBarCode']");
	
	By billingproblemstatus = By.xpath("//option[@value='5']");
	
	By Searchallclubs = By.xpath("//a[@id='ContentPlaceHolder1_btnSubmit3']");
	
	By managebtn = By.id("ContentPlaceHolder1_grdMemberSearch_btnManage_3");
	
	By managebtn_Jake = By.xpath("//input[@name='ctl00$ContentPlaceHolder1$grdMemberSearch$ctl02$btnManage']");
	
	By getpaymentbtn = By.id("ContentPlaceHolder1_btnGetPayment");
	
	By paymentamount = By.id("txtAmount");
	
	By ddlcategory = By.xpath("//select[@id='ddlCategory']");
	
	By selectcategory = By.xpath("//option[@value='6']");  //Collections
	
	By emailreceipt = By.id("chkEmailReceipt");
	
	//By autoapplynextbtn = By.id("btnAutoApplyNextPayment");
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
		
		this.driver=driver;
				
	}
	
public WebElement getmembermanager() {
		
		return driver.findElement(membermanager);
	
	}
public WebElement getstatuss() {
		
		return driver.findElement(statuss);
	
	}
public WebElement getbarcodeid() {
	
	return driver.findElement(barcodeid);

}
public WebElement getbillingproblemstatus() {
	
	return driver.findElement(billingproblemstatus);

}
public WebElement getSearchallclubs() {
	
	return driver.findElement(Searchallclubs);

}
public WebElement getmanagebtn() {
	
	return driver.findElement(managebtn);

}
public WebElement getmanagebtn_Jake() {
	
	return driver.findElement(managebtn_Jake);

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
