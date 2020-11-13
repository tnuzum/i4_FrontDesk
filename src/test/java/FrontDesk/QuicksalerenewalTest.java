package FrontDesk;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pageObjects.Quicksale_renewalPO;
import resources.QuicksalerenewalActions;
import resources.base;

public class QuicksalerenewalTest extends base{
	
public static SoftAssert softAssertion = new SoftAssert();

LoginPageTest log = new LoginPageTest(); 
	
	public Quicksale_renewalPO ren;
	
	String creditcardmc,visacard, searchfirstname, cvvnum;
	String expmonth;
	String expyear;
	


	@Test(priority = 5, description = "Quicksale_renewal contract")
	
	public void renewalcontract() throws Exception {
		
		log.initialize();
		log.login();
		
		
		//System.out.println(driver.getTitle());
		searchfirstname = prop.getProperty("searchfirstname");
		visacard = prop.getProperty("visacard");
		creditcardmc = prop.getProperty("creditcardnummc");
		expmonth = prop.getProperty("cardexpmonthfield");
		expyear = prop.getProperty("cardexpyearfield");
		cvvnum = prop.getProperty("cvvnum");
	
		QuicksalerenewalActions.renewalcontract(searchfirstname, creditcardmc, visacard, expmonth, expyear, cvvnum );
		
		//log.teardown();

}
}
