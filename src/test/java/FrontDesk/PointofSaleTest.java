package FrontDesk;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pageObjects.POS;
import pageObjects.POSPO;
import resources.POScustomActions;

public class PointofSaleTest extends LoginPageTest {
	
	

	public static SoftAssert softAssertion = new SoftAssert();

	
	
	public POSPO po;
	
	String lastname;
	String cvvcode;

	
	
	@Test(priority = 3, description = "point of sale")
	
	public void pointofsale() {
		
		
		po = new POSPO(driver);
		lastname = prop.getProperty("searchlastname");
		cvvcode = prop.getProperty("cvv");
		
		
	    POScustomActions.pointofsale(lastname,cvvcode);
	    
	    
	   
				
	}

}
