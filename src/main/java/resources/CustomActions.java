package resources;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import pageObjects.HomePO;
import pageObjects.POSPO;
import pageObjects.QuickSalesPO;

public class CustomActions extends base {



	public CustomActions() {
		
	}
	


	public void setDriver(WebDriver wd) {
	driver = wd;
	}
	
	  
		
		public String loginClub(String clubBarcodeId, String clubPassword) throws InterruptedException {

		pageObjects.LoginPO l = new pageObjects.LoginPO(driver);

		l.getUserNameInputField().sendKeys(clubBarcodeId);

		l.getPasswordInputField().sendKeys(clubPassword);
		Thread.sleep(2000);
		JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].click();", l.getLoginButton());
		//l.getLoginButton().click();

		return null;
	}

	
	public String loginEmp(String BarcodeIDEmp, String PasswordEmp){
		
		pageObjects.LoginPO L = new pageObjects.LoginPO(driver);
		
		L.getEmpId().sendKeys(BarcodeIDEmp);
		//System.out.println(PasswordEmp);
		L.getEmpPW().sendKeys(PasswordEmp);
		JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].click();", L.getEmpLogin());
		//L.getEmpLogin().click();
		return null;
	}
	public String LoginFD(String clubBarcodeId, String clubPassword, String BarcodeIDEmp, String PasswordEmp) throws InterruptedException{
	this.loginClub(clubBarcodeId, clubPassword);
	Thread.sleep(2000);
		this.loginEmp(BarcodeIDEmp, PasswordEmp);
		
		return null;
			}
	
	public Object quickSalesTab1() {
		
		//pageObjects.HomePO H = new pageObjects.HomePO(driver);
		HomePO H = new HomePO(driver); 		
		H.getquickSalesTab().click();
		
		return null;
	
	}
	
	public Object Membermanagertab() {
		
		HomePO H = new HomePO(driver);
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].click();",H.getmembermanagertab());
		
		return null;
	}
	
    public Object POSTab() {
		
		HomePO H = new HomePO(driver); 		
		
		JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].click();", H.getPOSTab1());
		//H.getPOSTab1().click();
		
		return null;
	
	}
	public Object newContract() {
		QuickSalesPO Q = new QuickSalesPO(driver);
		Q.getnewContract1().click();
		//Q.getexistingMember1().click();
		return null;
}	
	public Object existingMember() {
		QuickSalesPO s = new QuickSalesPO(driver);
	//s.getexistingMember1().click();
		return null;
}	
	
	
	
	
	public String itemBarcode() {
		POSPO P = new POSPO(driver);
		JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].click();", P.getitemBarcode1());
		//P.getitemBarcode1().click();
		return null;
	}
	
	
public String MSSlogin(String BarcodeIDMem, String PasswordMem){
		
		pageObjects.MSSLoginPO Log = new pageObjects.MSSLoginPO(driver);
		
		Log.getUserNameInput().sendKeys(BarcodeIDMem);
		
		Log.getPasswordInput().sendKeys(PasswordMem);
		JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].click();", Log.getLoginButton());
		//L.getEmpLogin().click();
		return null;
	}


	
	}

	

