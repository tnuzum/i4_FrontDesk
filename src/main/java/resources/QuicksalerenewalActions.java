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
	
	public static String renewalcontract(String creditcardmc, String expmonth, String expyear ) {
		
	
		pageObjects.Quicksale_renewalPO ren = new pageObjects.Quicksale_renewalPO(driver);

	      ren.getquicksalebtn().click();
	
		 ren.getrenewal().click();
		 ren.getsearchbyfirstname().sendKeys("test127");
		 ren.getsearchallclubbtn().click();
		 
		 ren.getselectmemberbtn().click();
		
			String s2 = driver.findElement(By.className("modal-body")).getText();
			// System.out.println(s2);

			driver.findElement(By.xpath("//input[@id='btnNewPlanForRenewal']")).click();
			
			ren.getselectplanforrenewal().click();
			
			
			ren.getproceedexistingbtn().click();
			
			Actions action = new Actions(driver);
			action.sendKeys(Keys.PAGE_DOWN).perform();
			ren.getcheckprivacypolicybtn().click();
			
			
			ren.getproceedgotobilling().click();
			
			ren.getformofpayment().click();
			ren.getmastercarddrop().click();
		    action.sendKeys(Keys.TAB).perform();
		    ren.getcreditcardfield().sendKeys(creditcardmc);
			ren.getcardexpmonth().sendKeys(expmonth);
			ren.getcardexpyear().sendKeys(expyear);
			ren.getproceedgotoplan().click();
		
			ren.geteditplanbutton().click();
			
			String edt = driver.findElement(By.className("modal-body")).getText();
		
		
			DateFormat df = new SimpleDateFormat("MM/d/yyyy");
			Calendar today = Calendar.getInstance();
			String currentdate = df.format(today.getTime());
			System.out.println(currentdate);
			
			//driver.findElement(By.xpath("//input[@id='ctl00_ContentPlaceHolder1_txtFirstPaymentDate']")).clear();
			
			//driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		
		
			WebElement date = driver.findElement(By.xpath("//input[@id='ctl00_ContentPlaceHolder1_txtFirstPaymentDate']"));
			
			selectDateByJS(driver,date,currentdate);
					 
					
		
			//driver.findElement(By.xpath("//input[@id='ctl00_ContentPlaceHolder1_txtFirstPaymentDate']")).sendKeys(currentdate);
			
		  
			
		 // driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
			  
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
			if (Paymentopt.equals("paynow")) {
				ren.getpaynowbtn().click();
				
				ren.getsplipaymentno().click();
				ren.getpaymentbycash().click();

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