package FrontDesk;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pageObjects.Quicksale_newmemberPO;
import resources.QuicksalenewcustomActions;
import resources.base;

// change the first name before run the test, it will give you with message exisiting member found with same name
public class Quicksale_newcontractTest extends base {
	
	public static SoftAssert softAssertion = new SoftAssert();
	
	public Quicksale_newmemberPO con;
	
	LoginPageTest log = new LoginPageTest();
	
	
	String firstname;
	String lastname;
	String address1;
	String city;
	String state;
	String dateofbirth;
	String billingname;
	String mobilenumber;
	String workphone;
	String email;
	String creditcard;
	String expmonth;
	String expyear;
	
	
	@Test(priority = 4, description = "create new contract")
	public void newcontract () throws Exception {
		
	
		con = new Quicksale_newmemberPO(driver);
		
		log.initialize();
		log.login();
		
		
		firstname = prop.getProperty("memberfirstname");
		lastname = prop.getProperty("memberlastname");
		address1 = prop.getProperty("memberaddress");
		city = prop.getProperty("membercity");
		 state = prop.getProperty("memberstate");
		dateofbirth = prop.getProperty("memberdateofbirth");
		billingname = prop.getProperty("memberbillingname");
		mobilenumber = prop.getProperty("membermobilenumber");
		workphone = prop.getProperty("memberworknumber");
		email = prop.getProperty("memberemail");
		creditcard = prop.getProperty("creditcardnum");
		expmonth = prop.getProperty("cardexpmonth");
		expyear = prop.getProperty("cardexpyear");
		
		QuicksalenewcustomActions.loginEmployee(firstname, lastname, address1, city, state, dateofbirth, billingname, mobilenumber, workphone, email,
				creditcard,expmonth,expyear);
		
		//log.teardown();
		
	}}
		
		
		
	
              
              
				
	
	


