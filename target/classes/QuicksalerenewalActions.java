package resources;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.interactions.Actions;

public class QuicksalerenewalActions extends base {
	
	public  static  String renewalcontract(String searchfirstname, String creditcardmc, String visacard, String expmonth, String expyear, String cvvnum ) throws Exception {
		
		String cardtype = prop.getProperty("cardtype");
		pageObjects.Quicksale_renewalPO ren = new pageObjects.Quicksale_renewalPO(driver);

		
		
	      ren.getquicksalebtn().click();
	
		 ren.getrenewal().click();
		 ren.getsearchbyfirstname().sendKeys(searchfirstname);
		 ren.getsearchallclubbtn().click();
		 
		 ren.getselectmemberbtn().click();
		
			String s2 = driver.findElement(By.className("modal-body")).getText();
			// System.out.println(s2);

			driver.findElement(By.xpath("//input[@id='btnNewPlanForRenewal']")).click();
			
			 Thread.sleep(4000);
			
		String planname =	ren.getplannametxt().getText();
			
			System.out.println(planname);
			
			if(planname.contentEquals("!uma's open ended plan")) {
		
			ren.getselectplanforrenewal().click();
			
			}
			
			ren.getproceedexistingbtn().click();
			
			Actions action = new Actions(driver);
			action.sendKeys(Keys.PAGE_DOWN).perform();
			ren.getcheckprivacypolicybtn().click();
			
			
			ren.getproceedgotobilling().click();
			
			ren.getformofpayment().click();
			
			if(cardtype.equals("Mc")) {
				
		
			ren.getmastercarddrop().click();
		    action.sendKeys(Keys.TAB).perform();
		    ren.getcreditcardfield().sendKeys(creditcardmc);
			ren.getcardexpmonth().sendKeys(expmonth);
			ren.getcardexpyear().clear();
			ren.getcardexpyear().sendKeys(expyear);
			
			}
			
			if(cardtype.equals("Visa")) {
				//driver.findElement(By.xpath("//option[contains(text(),'Visa')]")).click();
				ren.getvisacarddrop().click();
				ren.getcreditcardfield().clear();
				ren.getcreditcardfield().sendKeys(visacard);
				ren.getcardexpmonth().sendKeys(expmonth);
				ren.getcardexpyear().clear();
				ren.getcardexpyear().sendKeys(expyear);
				
			}
			ren.getproceedgotoplan().click();
		
			ren.geteditplanbutton().click();
			
			String edt = driver.findElement(By.className("modal-body")).getText();
		
		
			DateFormat df = new SimpleDateFormat("MM/d/yyyy");
			Calendar today = Calendar.getInstance();
			String currentdate = df.format(today.getTime());
			System.out.println(currentdate);
		
		
			WebElement date = driver.findElement(By.xpath("//input[@id='ctl00_ContentPlaceHolder1_txtFirstPaymentDate']"));
			
			selectDateByJS(driver,date,currentdate);
					 
		
			  
				WebElement date1 = driver.findElement(By.xpath("//input[@id='ctl00_ContentPlaceHolder1_txtRecDuesDate']"));
				selectDateByJS(driver,date1,currentdate);
			 
			 
		    driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			
		action.click();
		    
			ren.getokbtn().click();
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
			action.sendKeys(Keys.PAGE_DOWN).click();
			   action.sendKeys(Keys.TAB).perform();
			   action.sendKeys(Keys.TAB).perform();
			   action.sendKeys(Keys.TAB).perform();
			   action.sendKeys(Keys.TAB).perform();
			   action.sendKeys(Keys.TAB).perform();
			   action.sendKeys(Keys.TAB).perform();
		    action.sendKeys(Keys.CONTROL + "end" + Keys.CONTROL).perform();
		    
		    driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			ren.getproceedgotoplan().click();
			
			String Paymentopt = prop.getProperty("Paymentoption");
			
			String paymentmthd = prop.getProperty("paymentmethod");
			
			if (Paymentopt.equals("paynow")) {
				ren.getpaynowbtn().click();
				
				ren.getsplipaymentno().click();
				
				if(paymentmthd.equals("cash")) {
				ren.getpaymentbycash().click();
				System.out.println("payment is done through cash");
				
				
				}
				if(paymentmthd.equals("creditcard")) {
					ren.getpaymentbycreditcard().click();
					ren.getselectcardtype().click();
					Thread.sleep(2000);
					System.out.println("payment is done by credit card");
					Select select = new Select(driver.findElement(By.id("creditCardTypes")));
					if(cardtype.equals("Visa")){
					select.selectByIndex(2);
					}
					if(cardtype.equals("Mc")){
						select.selectByIndex(1);
						}
					
					ren.getcreditcardfield().sendKeys(visacard);
					ren.getcardexpmonth().sendKeys(expmonth);
					ren.getcardexpyear().clear();
					ren.getcardexpyear().sendKeys(expyear);
					ren.getcvvnum().sendKeys(cvvnum);
				}

			}
			if(Paymentopt.equals("paylater")) {
			
			}
			ren.getproceedgotobilling().click();
			
			action.sendKeys(Keys.TAB).build().perform();
		
		
   return null;
}
	  public static void selectDateByJS(WebDriver driver , WebElement element , String dateVal) {
	        JavascriptExecutor js = ((JavascriptExecutor)driver);
	        js.executeScript("arguments[0].setAttribute('value','"+dateVal+"');", element);

	    }
}