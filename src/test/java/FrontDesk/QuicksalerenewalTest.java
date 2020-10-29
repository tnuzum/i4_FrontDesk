package FrontDesk;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pageObjects.Quicksale_renewalPO;
import resources.QuicksalerenewalActions;

public class QuicksalerenewalTest extends LoginPageTest{
	
public static SoftAssert softAssertion = new SoftAssert();

	
	
	public Quicksale_renewalPO ren;
	
	String creditcardmc;
	String expmonth;
	String expyear;
	


	@Test(priority = 5, description = "Quicksale_renewal contract")
	
	public void renewalcontract() {
		
		creditcardmc = prop.getProperty("creditcardnummc");
		expmonth = prop.getProperty("cardexpmonthfield");
		expyear = prop.getProperty("cardexpyearfield");
	
		QuicksalerenewalActions.renewalcontract(creditcardmc, expmonth, expyear );

}
}
