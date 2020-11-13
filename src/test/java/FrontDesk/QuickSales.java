package FrontDesk;
import org.openqa.selenium.Keys;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pageObjects.DashboardPO;
import pageObjects.LoginPO;
import pageObjects.QuickSalesPO;
import resources.CustomActions;
import resources.base;


public class QuickSales extends base {
	public SoftAssert softAssertion = new SoftAssert();

	DashboardPO d;
	String clubBarcodeId;
	String clubPassword;
	
	LoginPO L;
	String BarcodeIDEmp;
	String PasswordEmp;
	public CustomActions ca;
	public QuickSales() {
	ca = new CustomActions();
	
	
	}
	@BeforeTest
	public void initialize() throws Exception {

		driver = initializeDriver();
		ca.setDriver(driver);
		
		driver.get(prop.getProperty("clubLoginPage"));

		d = new DashboardPO(driver);
		clubBarcodeId = prop.getProperty("clubBarcodeId");
		clubPassword = prop.getProperty("clubPassword");
		
		L = new LoginPO(driver);
		BarcodeIDEmp = prop.getProperty("EmpBarcodeID");
		PasswordEmp = prop.getProperty("EmpPassword");
		
		
		
	}
	@Test (priority = 1)
	public void QuickSalesTest() throws InterruptedException {
		QuickSalesPO p = new QuickSalesPO(driver);
	ca.LoginFD(clubBarcodeId,clubPassword,BarcodeIDEmp,PasswordEmp);
	Thread.sleep(2000);
	ca.quickSalesTab1();
	ca.newContract();
	Thread.sleep(2000);
	//p.getselectPlan1Radiobtn().click();
	ca.existingMember();
	p.getsearchMember1().sendKeys("016");
	p.getsearchMember1().sendKeys(Keys.ENTER);
	p.getselectMember1().click();
	p.getgoTobilling1().click();
	p.getplanDetailsbtnProceed1().click();
	p.getplanPaymentbtnProceed().click();
	//p.getbtnContinue1().click();
	p.getplanPaymentbtnProceed().click();
	//p.getZeroDollarPaymentbtnProceed().click();
	}

	
	
	
	
}
