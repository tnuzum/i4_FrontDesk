package FrontDesk;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pageObjects.ChangerequestPO;
import resources.base;

public class Changerequesttest extends base {
	
	
public static SoftAssert softAssertion = new SoftAssert();	
	
	LoginPageTest log = new LoginPageTest();
	
    public ChangerequestPO change;
    
    String firstletter, creditcardnummc, visacard;
    
  @Test(priority = 7, description = "Change request")
	
	public void changerequest() throws Exception{
		
		log.initialize();
		log.login();
		
	change = new ChangerequestPO(driver);
		
		firstletter = prop.getProperty("firstletter");
		
		
		creditcardnummc = prop.getProperty("creditcardnummc");
		
		visacard = prop.getProperty("visacard");
		
		change.updatememberinfo(firstletter, creditcardnummc, visacard);
		
		log.teardown();
		
		
		
}
}
