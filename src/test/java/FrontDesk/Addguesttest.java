package FrontDesk;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pageObjects.AddGuestPO;
import resources.base;

public class Addguesttest extends base{
	
	public static SoftAssert softAssertion = new SoftAssert();	
	
	LoginPageTest log = new LoginPageTest();
	
    public AddGuestPO gu;
	
	String guestfirstname, guestlastname, dateofbirth, addressfield, cityname, zipcode, guestpass, guestemail, guestphone, familyfirstname, homeph ;
	

	
	
	@Test(priority = 6, description = "Add guest")
	
	public void addguest() throws Exception{
		
		log.initialize();
		log.login();
		//log.teardown();
		
		guestfirstname = prop.getProperty("guestfirstname");
		guestlastname = prop.getProperty("guestlastname");
		dateofbirth = prop.getProperty("dateofbirth");
		addressfield = prop.getProperty("addressfield");
		cityname = prop.getProperty("city");
		zipcode = prop.getProperty("Zipcode");
		guestpass = prop.getProperty("guestpassperiod");
		guestemail = prop.getProperty("email");
		guestphone = prop.getProperty("workphone");
		familyfirstname = prop.getProperty("familyfirstname");
		homeph = prop.getProperty("homephone");
		
		
		gu = new AddGuestPO(driver);
	gu.guestinformation(guestfirstname, guestlastname, dateofbirth, addressfield, cityname, zipcode, guestpass, guestemail, guestphone, familyfirstname,homeph);
	   
	 
	
	log.teardown();		
	}
}
