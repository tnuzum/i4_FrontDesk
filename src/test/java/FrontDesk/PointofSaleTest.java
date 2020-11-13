package FrontDesk;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pageObjects.POSmodulePO;
import resources.POScustomActions;
import resources.base;

public class PointofSaleTest extends base {
	
	

	public static SoftAssert softAssertion = new SoftAssert();

	
	LoginPageTest log = new LoginPageTest();
	
	public POSmodulePO po;
	
	String memlastname;
	String cvvcode;

	
	
	@Test(priority = 3, description = "point of sale")
	
	public void pointofsale() throws Exception {
		
		log.initialize();
		log.login();
		//log.pageTitle();
		
		
		//Assert.assertEquals(driver.getTitle(), "Member Manager");
		//System.out.println(driver.getTitle());
	
		po = new POSmodulePO(driver);
		memlastname = prop.getProperty("searchlastname");
		cvvcode = prop.getProperty("cvv");
		
		
	    POScustomActions.pointofsale(memlastname,cvvcode);
	    
	    log.teardown();
	   
				
	}

}
