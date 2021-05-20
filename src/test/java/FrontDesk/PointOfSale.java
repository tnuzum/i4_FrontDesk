package FrontDesk;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pageObjects.POS;
import resources.base;



public class PointOfSale extends LoginPageTest{
	
	public static SoftAssert softAssertion = new SoftAssert();

	
	String lastname1;
	public POS pos1;
	String cvvcode;

	
	
	@Test(priority = 3, description = "point of sale")
	
	public void pointofsale() {
		
		lastname1 = prop.getProperty("memberlastname");
		cvvcode = prop.getProperty("cvv");
		
		pos1 = new POS(driver);
	    pos1.pospage(lastname1,cvvcode);
	    
	   
				
	}
	

}
