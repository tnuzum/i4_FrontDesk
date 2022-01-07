package FrontDesk;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pageObjects.MSSHomePO;
import pageObjects.MSSLoginPO;
import resources.CustomActions;
import resources.base;

@Listeners(resources.Listeners.class)
public class MSSTest extends base {
	
public  SoftAssert softAssertion = new SoftAssert();	
private static JavascriptExecutor jse;
	

	MSSLoginPO login;
	String BarcodeIDMem;
	String PasswordMem;
	
      
      String  Mccard, cvvnum, zip, Address, City,State, cardholdername;
      
      public CustomActions ca;
	
      public MSSHomePO mss;
      
     
      public MSSTest() {
  		ca =new CustomActions();
  		
  				
  	}
      @BeforeClass
  	public void initialize() throws Exception {
  		driver = initializeDriver();
  		ca.setDriver(driver);
  		
  		driver.get(prop.getProperty("MSSurl"));
  		//driver - initializeDriver();
  		//driver.get(prop.getProperty("EmpLoginPage"));
  		
  		login = new MSSLoginPO(driver);
  		BarcodeIDMem = prop.getProperty("MemebrUsername");
  		PasswordMem = prop.getProperty("MemberPassword");
  		
  		 Mccard = prop.getProperty("Mccard");
		 cardholdername = prop.getProperty("cardholdername");
		 cvvnum = prop.getProperty("cvvnum");
		 Address = prop.getProperty("Address");
		 City = prop.getProperty("City");
		 State= prop.getProperty("State");
		 zip = prop.getProperty("zip");

		 jse = (JavascriptExecutor) driver;
  		
		 ca.MSSlogin(BarcodeIDMem, PasswordMem);
	     Thread.sleep(2000);
	    
	     
	     mss = new MSSHomePO(driver);
  		}
  	
		@Test(enabled = true, priority = 1, description = "MSSHome page")
		public void MSSHome() throws Exception {

			Assert.assertEquals("Index", driver.getTitle());
			mss.getDashboardLink().click();
			Thread.sleep(2000);

			Assert.assertTrue(mss.getDashboardLink().getText().contains("Dashboard"));
	
			List<WebElement> allheaders = driver.findElements(By.tagName("h4"));

			System.out.println(driver.findElements(By.tagName("h4")).size());
			ArrayList<String> headerTexts= new ArrayList<String>();

			

			for (int i = 0; i < allheaders.size(); i++) {

				String headerText = driver.findElements(By.tagName("h4")).get(i).getText();
				//System.out.println(headerText);
				headerTexts.add(headerText);
			}
			
			
			
					Assert.assertTrue(headerTexts.get(0).contains("3 Month Gold Membership"));
			
			
					Assert.assertTrue(headerTexts.get(1).contains("Status: "));
			

					Assert.assertTrue(headerTexts.get(2).contains("Exp: "));
			

					Assert.assertTrue(headerTexts.get(3).contains("My PT Packages"));
			

					Assert.assertTrue(headerTexts.get(4).contains("Class Enrollment"));
			

					Assert.assertTrue(headerTexts.get(5).contains("Reservation Request"));
				

					Assert.assertTrue(headerTexts.get(6).contains("Personal Information"));
			

					Assert.assertTrue(headerTexts.get(7).contains("Payment Information"));
				
			
			}

		
      
   
		@Test(enabled = true, priority = 2, description = "Verify Appointments")
		public void VerifyAppointments() throws Exception {

			jse.executeScript("arguments[0].click();",mss.getDashboardLink());
			Thread.sleep(2000);
			jse.executeScript("arguments[0].click();", mss.getAppointmentlink());
			

			jse.executeScript("arguments[0].click();", mss.getAddAppointment());

			Select select = new Select(mss.getAppointmentType());
			select.selectByVisibleText("Automation Test");

			Select select1 = new Select(mss.getSelectinstructor());
			select1.selectByVisibleText("Testing Book");
			Thread.sleep(2000);
			
			jse.executeScript("arguments[0].click();", mss.getDayview());
			
			jse.executeScript("arguments[0].click();", mss.getNextbtn());
			
			//System.out.println(driver.findElement(By.xpath("//div[contains(text(),'2:00 - 2:30')]")).getText());

			driver.findElement(By.xpath("//div[contains(text(),'2:00 - 2:30')]")).click();
	

			Thread.sleep(1000);
			List<WebElement> enrolling_details = driver.findElements(By.xpath("//div[@class='modal-body']"));

			for (WebElement e : enrolling_details) {
				System.out.println(e.getText());
				
			}

			jse.executeScript("arguments[0].click();", mss.getFamilyMemberCheckbox());

			jse.executeScript("arguments[0].click();", mss.getSubmitbutton());

			jse.executeScript("arguments[0].click();", mss.getfinalizeAndPay());
			Thread.sleep(2000);

			Assert.assertEquals("How Would You Like To Pay?", mss.getPaymentMethodText().getText());

			List<WebElement> total = driver.findElements(By.xpath("//*[@id='MakePayment']/div[2]/p"));

			for (WebElement e : total) {
				System.out.println(e.getText());
			}

			jse.executeScript("arguments[0].click();", mss.getMakepayment());

			System.out.println("Alert Text: " + driver.switchTo().alert().getText());

			driver.switchTo().alert().accept();
			Thread.sleep(2000);

			
			jse.executeScript("arguments[0].click();", mss.getCardOnFile());
			  jse.executeScript("arguments[0].click();", mss.getMakepayment()); //
			//  jse.executeScript("arguments[0].click();", mss.getBackbtn());
			  Thread.sleep(2000);
			  
			  Assert.assertTrue(driver.findElement(By.tagName("h1")).getText().contains(
			  "Thanks"));
			  Assert.assertTrue(driver.findElement(By.tagName("h3")).getText()
			  .contains("Your payment has been processed for Appointments Sale."));
			  
			  List<WebElement> payment_details = driver.findElements(By.tagName("p"));
			  
			  for (WebElement e : payment_details) { 
				  System.out.println(e.getText()); 
				  }
			  Thread.sleep(2000); 
			  jse.executeScript("arguments[0].click();",
			  mss.getHomelink());
			 

		}
		@Test(enabled = true, priority = 3, description = "Cancel Appointment")
		public void VerifyCancelAppointment() throws Exception {

			Thread.sleep(2000);
			jse.executeScript("arguments[0].click();", mss.getDashboardLink());
			Thread.sleep(2000);
			jse.executeScript("arguments[0].click();", mss.getEditAppointment());
			Assert.assertTrue(mss.getAppointmenttext().isDisplayed());
			
			List<WebElement> CancelAppointment_details = driver.findElements(By.xpath("//div[@id='divAppointmentList']/div/div/div/div/p"));

			for (WebElement e : CancelAppointment_details) {
				System.out.println(e.getText());
			}
			Thread.sleep(2000);
			jse.executeScript("arguments[0].click();", mss.getCanelAppointment());
			
			String Alert = driver.findElement(By.className("modal-body")).getText();
			Assert.assertEquals("Are you sure you want to cancel this appointment?", Alert);
			jse.executeScript("arguments[0].click();",driver.findElement(By.xpath("//button[@name='btnCancel']")));
		
			//driver.switchTo().alert().accept();
			Thread.sleep(2000);
			
			Assert.assertTrue(mss.getAfterCancellation().getText().contains("No appointment has scheduled"));
			
			jse.executeScript("arguments[0].click();", mss.getDashboardLink());
			
		
		}
		@Test(enabled = true, priority = 4, description = "Verify Classes")
		public void VerifyClasses() throws Exception {
			
		      
			jse.executeScript("arguments[0].click();", mss.getDashboardLink());
			Thread.sleep(2000);

			jse.executeScript("arguments[0].click();", mss.getClasslink());
		
			//System.out.println(driver.findElement(By.tagName("h2")).getText());

			jse.executeScript("arguments[0].click();", mss.getAddClasses());

			Select select = new Select(mss.getSelectClassType());
			select.selectByVisibleText("Classes");

			Select select1 = new Select(mss.getClassname());
			select1.selectByVisibleText("Swimming Class");
			Thread.sleep(2000);

			jse.executeScript("window.scrollBy(0,200)");
			Thread.sleep(1000);
			
	        jse.executeScript("arguments[0].click();", mss.getDayview());
			
			jse.executeScript("arguments[0].click();", mss.getNextbtn());

			//System.out.println(driver.findElement(By.xpath("//div[@class='fc-event-time']")).getText());
			 driver.findElement(By.cssSelector("div.fc-event-time")).click();
			
			Thread.sleep(1000);

			List<WebElement> enrolling_details = driver.findElements(By.xpath("//div[@class='modal-body']"));

			for (WebElement e : enrolling_details) {
				System.out.println(e.getText());
			}
			jse.executeScript("arguments[0].click();", mss.getFamilyMemberCheckbox());

			jse.executeScript("arguments[0].click();", mss.getSubmitbutton());

			jse.executeScript("arguments[0].click();", mss.getfinalizeAndPay());
			Thread.sleep(2000);

			Assert.assertEquals("How Would You Like To Pay?", mss.getPaymentMethodText().getText());

			List<WebElement> total = driver.findElements(By.xpath("//*[@id='MakePayment']/div[2]/p"));

			for (WebElement e : total) {
				System.out.println(e.getText());
			}

			jse.executeScript("arguments[0].click();", mss.getMakepayment());

			System.out.println("Alert Text: " + driver.switchTo().alert().getText());

			driver.switchTo().alert().accept();
			Thread.sleep(2000);

			jse.executeScript("arguments[0].click();", mss.getNewCCCard());
			Select selectcard = new Select(mss.getSelectCardType());
			selectcard.selectByVisibleText("Master Card");
			
			mss.getBillingname().sendKeys(cardholdername);
			mss.getCardNumber().sendKeys(Mccard);
			Select selectmonth = new Select(mss.getSelectMonth());
			selectmonth.selectByVisibleText("Apr");
			
			Select selectYear = new Select(mss.getSelectYear());
			selectYear.selectByVisibleText("2023");
			
			mss.getSecurityCode().sendKeys(cvvnum);
			mss.getAddress().sendKeys(Address);
			mss.getCity().sendKeys(City);
			mss.getState().sendKeys(State);
			mss.getZip().sendKeys(zip);
			
			jse.executeScript("arguments[0].click();", mss.getMakepayment());
			// jse.executeScript("arguments[0].click();", mss.getBackbtn());
			Thread.sleep(2000);

			Assert.assertTrue(driver.findElement(By.tagName("h1")).getText().contains("Thanks"));
			  jse.executeScript("arguments[0].click();", mss.getHomelink());
					 
		}
		

		@Test(enabled = true, priority = 5, description = "Verify cancel Classes")
		public void VerifyCancelClasses() throws Exception {
			
		      
			jse.executeScript("arguments[0].click();", mss.getDashboardLink());
			Thread.sleep(2000);
			
			jse.executeScript("arguments[0].click();", mss.getFindAClass());
			
//			List<WebElement> enrolling_details = driver.findElements(By.tagName("//tbody/tr/td"));
//
//			for (WebElement e : enrolling_details) {
//				System.out.println(e.getText());
//			}
			
			jse.executeScript("arguments[0].click();", mss.getCancelClass());
			String Alert = driver.findElement(By.className("modal-body")).getText();
			System.out.println(Alert);
			Assert.assertEquals("Are you sure you want to cancel this class?", Alert);
			jse.executeScript("arguments[0].click();",driver.findElement(By.xpath("//button[@name='btnCancel']")));
			Thread.sleep(1000);
			jse.executeScript("arguments[0].click();", mss.getDashboardLink());
			
		}
		
		@Test(enabled = true, priority = 6, description = "Verify Check-in History")
		public void CheckinHistory() throws Exception {

			jse.executeScript("arguments[0].click();", mss.getDashboardLink());
			Thread.sleep(2000);
			System.out.println(driver.findElements(By.tagName("h3")).get(2).getText());
			Assert.assertTrue(driver.findElements(By.tagName("h3")).get(2).getText().contains("Check-In History"));

			jse.executeScript("arguments[0].click();", mss.getViewCheckinhistory());

			Assert.assertTrue(driver.findElement(By.tagName("h1")).getText().contains("Check-Ins"));

			List<WebElement> Visits = driver.findElements(By.tagName("p"));
			
			ArrayList<String> Checkinheaders = new ArrayList<String>();
			

			for (int i = 0; i < Visits.size(); i++) {

				String checkinvisits = driver.findElements(By.tagName("p")).get(i).getText();
				//System.out.println(checkinvisits);
				Checkinheaders.add(checkinvisits);
				
			}
				Thread.sleep(2000);

					Assert.assertTrue(Checkinheaders.get(0).contains("Last Check-In"));
					System.out.println(Checkinheaders.get(0) + ":" + driver.findElements(By.tagName("h1")).get(0).getText());
				
					Assert.assertTrue(Checkinheaders.get(1).contains("Visits This Month"));
					Assert.assertTrue(Checkinheaders.get(2).contains("Visits Last Month"));


					Assert.assertTrue(Checkinheaders.get(3).contains("Visits This Year"));



			jse.executeScript("arguments[0].click();", mss.getDashboardLink());
		
}
		@Test(enabled = true, priority = 7, description = "Verify manage family members")
		public void ManageFamilyMembers() throws Exception {
			
			Thread.sleep(2000);
			jse.executeScript("arguments[0].click();", mss.getDashboardLink());
			Thread.sleep(2000);
			
			List<WebElement> allheaders = driver.findElements(By.tagName("h4"));
			
			ArrayList<String> headers = new ArrayList<String>();
			
			for(int i=0; i<allheaders.size();i++) {
				
				String headerText = driver.findElements(By.tagName("h4")).get(i).getText();
				//System.out.println(headerText);
				headers.add(headerText);
				
			}
					
					Assert.assertTrue(headers.get(6).contains("Personal Information"));
				
		
			
			
		//	Assert.assertTrue(driver.findElement(By.xpath("//h2[contains(text(), 'kollu, kollu')]")).getText().contains("kollu, kollu"));
			
			Assert.assertTrue(mss.getNumberofFamilyMembers().getText().contains("Family Members On Plan:"));
			
			System.out.println(mss.getNumberofFamilyMembers().getText());
			
			jse.executeScript("arguments[0].click();", mss.getManageFamilymembers());
			Thread.sleep(2000);
			Assert.assertTrue(driver.findElement(By.tagName("h1")).getText().contains("Manage Family Members"));
			
			Assert.assertTrue(driver.findElement(By.xpath("//h2[contains(text(),'Family Members')]")).getText().contains("Family Members"));
			
			//System.out.println(driver.findElement(By.xpath("//tbody/tr")).getText());
			Thread.sleep(2000);
			jse.executeScript("arguments[0].click();", mss.getCreatelogin());
			
			Assert.assertTrue(driver.findElement(By.cssSelector("#MemberEmail-error")).getText().contains("Email is required"));
			
			jse.executeScript("arguments[0].click();", mss.getCancelbutton());
		}
		
		@Test(enabled = true, priority = 8, description = "Verify Edit personal information")
		public void personalInformation() throws Exception {

			Thread.sleep(2000);
			jse.executeScript("arguments[0].click();", mss.getDashboardLink());
			Thread.sleep(2000);

			List<WebElement> EditCustomer = driver.findElements(By.xpath("//a[@href='/MSS/Customer']"));
			
			//System.out.println(EditCustomer.size());

			for (int i = 0; i < EditCustomer.size(); i++) {

				jse.executeScript("arguments[0].click();", mss.getDropdownopen());
				Thread.sleep(2000);
			

				String EditCustomerinfo = driver.findElements(By.xpath("//a[@href='/MSS/Customer']")).get(i).getText();
				//System.out.println(EditCustomerinfo);

				if (EditCustomerinfo.equals("Edit Personal Info")) {

					driver.findElements(By.xpath("//a[@href='/MSS/Customer']")).get(i).click();
					Thread.sleep(2000);
					Assert.assertTrue(driver.findElement(By.tagName("h1")).getText().contains("Personal Information"));

					jse.executeScript("arguments[0].click();", mss.getChangepassword());

					Assert.assertTrue(mss.getOldpasswordText().getText().contains("Please enter old password"));

					Assert.assertTrue(mss.getNewPasswordText().getText().contains("Please enter new password"));
					Assert.assertTrue(mss.getRetypeNewpasword().getText().contains("Please retype new password"));

					jse.executeScript("arguments[0].click();", mss.getSavechanges());
					Thread.sleep(2000);
					jse.executeScript("arguments[0].click();", mss.getCancelCustomerEdit());

				}
				if (EditCustomerinfo.equals("Edit")) {

					driver.findElements(By.xpath("//a[@href='/MSS/Customer']")).get(i).click();

					Thread.sleep(2000);

					Assert.assertTrue(driver.findElement(By.tagName("h1")).getText().contains("Personal Information"));
	
					List<WebElement> personalInfoheaders = driver.findElements(By.tagName("h2"));
					
					ArrayList<String> personalheaders = new ArrayList<String>();
					
					for(int j=0; j<personalInfoheaders.size();j++) {
						
						String personalInfoheadersText = driver.findElements(By.tagName("h2")).get(j).getText();
						//System.out.println(personalInfoheadersText);
						personalheaders.add(personalInfoheadersText);
					
					}
					
							Assert.assertTrue(personalheaders.get(0).contains("Change Password"));
						
							Assert.assertTrue(personalheaders.get(1).contains("General"));
						
							Assert.assertTrue(personalheaders.get(2).contains("Address"));
				
							Assert.assertTrue(personalheaders.get(3).contains("Phone Numbers"));
					
				
					jse.executeScript("arguments[0].click();", mss.getSavechanges());
					jse.executeScript("arguments[0].click();", mss.getCancelCustomerEdit());
					 Thread.sleep(2000);
					Assert.assertTrue(driver.findElement(By.tagName("h1")).getText().contains("Dashboard"));
				}
				}

			}
		
		@Test(enabled = true, priority = 9, description = "Verify Edit and change Payment information")
		public void PaymentInformation() throws Exception {

			Thread.sleep(2000);
			jse.executeScript("arguments[0].click();", mss.getDashboardLink());
			Thread.sleep(2000);

			jse.executeScript("arguments[0].click();", mss.getPaymentTab());
			Thread.sleep(2000);
			
			Assert.assertTrue(driver.findElement(By.tagName("h1")).getText().contains("Payment Information"));
			
			Assert.assertTrue(driver.findElement(By.tagName("h4")).getText().contains("Billing Information"));
			
			Assert.assertTrue(driver.findElement(By.tagName("p")).getText().contains("Payment Method:"));
			
			jse.executeScript("arguments[0].click();", mss.getEditPayment());
			
			Thread.sleep(2000);
			Assert.assertTrue(driver.findElement(By.tagName("h1")).getText().contains("Edit Billing Info"));
			
			Assert.assertTrue(driver.findElement(By.tagName("h4")).getText().contains("Active Payment Method"));
			
			String ActivePaymentDetails = driver.findElement(By.xpath("//table/tbody/tr[1]")).getText();
			
			System.out.println("Active Payment Method details: "+ActivePaymentDetails);
			
			
			jse.executeScript("arguments[0].click();", mss.getChangePaymentMethod());
			
			Assert.assertTrue(driver.findElement(By.id("billingName-error")).getText().contains("Please enter your billing name"));
			Assert.assertTrue(driver.findElement(By.id("cardNumber-error")).getText().contains("Please enter your card number"));
			Assert.assertTrue(driver.findElement(By.id("submissionReason-error")).getText().contains("Please enter your submission reason"));
			
		}
		
		@Test(enabled = true, priority = 10, description = "Verify Make Payment")
		public void MakePayment() throws Exception {

			jse.executeScript("arguments[0].click();", mss.getDashboardLink());
			Thread.sleep(2000);

			jse.executeScript("arguments[0].click();", mss.getPaymentTab());
			Thread.sleep(2000);
			
			Assert.assertTrue(driver.findElement(By.tagName("h1")).getText().contains("Payment Information"));
			
			jse.executeScript("arguments[0].click();", mss.getMakePaymentLink());
			Thread.sleep(2000);
		
			Assert.assertTrue(driver.findElement(By.tagName("h1")).getText().contains("Make Payment"));
			
			String Balancedue = driver.findElement(By.tagName("p")).getText();
			System.out.println(Balancedue);
			
			
			jse.executeScript("arguments[0].click();", mss.getMakepayment());
			System.out.println("Alert Text: " + driver.switchTo().alert().getText());

			driver.switchTo().alert().accept();
			Thread.sleep(2000);
			
			jse.executeScript("arguments[0].click();", mss.getNewCCCard());
			Select selectcard = new Select(mss.getSelectCardType());
			selectcard.selectByVisibleText("Master Card");
			
			mss.getBillingname().sendKeys(cardholdername);
			mss.getCardNumber().sendKeys(Mccard);
			Select selectmonth = new Select(mss.getSelectMonth());
			selectmonth.selectByVisibleText("Apr");
			
			Select selectYear = new Select(mss.getSelectYear());
			selectYear.selectByVisibleText("2023");
			
			mss.getSecurityCode().sendKeys(cvvnum);
			mss.getAddress().sendKeys(Address);
			mss.getCity().sendKeys(City);
			mss.getState().sendKeys(State);
			mss.getZip().sendKeys(zip);
			
			Thread.sleep(2000);
			
			jse.executeScript("arguments[0].click();", mss.getBackbtn());
			
			jse.executeScript("arguments[0].click();", mss.getDashboardLink());
			
		}
		
		
		@AfterClass(enabled = true)
		public void teardown() throws Exception {
			
			jse.executeScript("arguments[0].click();", mss.getDashboardLink());
			
			Thread.sleep(2000);
			jse.executeScript("arguments[0].click();", mss.getlogout());
			Thread.sleep(1000);
			System.out.println(driver.getTitle());
			Assert.assertEquals(driver.getTitle(), "Log-In");
			driver.close();
			driver = null;
		}
}








