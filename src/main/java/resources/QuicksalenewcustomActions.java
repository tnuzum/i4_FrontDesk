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
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class QuicksalenewcustomActions extends base {
	
	public static String loginEmployee(String firstname, String lastname, String address1, String city, String state, String dateofbirth, String billingname,
			String mobilenumber, String workphone, String email, String creditcard, String expmonth, String expyear) {

		pageObjects.Quicksale_newmemberPO con = new pageObjects.Quicksale_newmemberPO(driver);

		con.getquicksalebtn().click();

		con.getnewcontract().click();
		con.getselectplan().click();
		con.getnewmemberbtn().click();
		con.getfirstnamefield().sendKeys(firstname);
		con.getlastnamefield().sendKeys(lastname);
		con.getaddress1field().sendKeys(address1);
		con.getcityfield().sendKeys(city);
		con.getstatefield().sendKeys(state);
		con.getdateofbirthfield().sendKeys(dateofbirth);
		
		Actions action = new Actions(driver);
		action.sendKeys(Keys.ESCAPE).perform();
		//*[@id="edit-plan"]
		//input[@id='txtExtension']
		//input[@id='btnSavePlanPopup']
		
		con.getbillingnamefield().sendKeys(billingname);
		con.getgender().click();
		con.getmobilenumberfield().sendKeys(mobilenumber);
		con.getworkphonefield().sendKeys(workphone);
		con.getemailfield().sendKeys(email);
		con.getcheckpolicybtn().click();
		con.getproceedskipbtn().click();
		con.getformofpayment().click();
		con.getmastercarddrop().click();
		action.sendKeys(Keys.TAB).perform();
		con.getcreditcardfield().sendKeys(creditcard);
		con.getcardexpmonth().sendKeys(expmonth);
		con.getcardexpyear().sendKeys(expyear);
		con.getproceedgotoplan().click();
		con.geteditplanbutton().click();
		
		String s12 = driver.findElement(By.className("modal-content")).getText();
		 System.out.println(s12);
		String s21 = driver.findElement(By.className("modal-body")).getText();
		 System.out.println(s21);
		 

			DateFormat df = new SimpleDateFormat("MM/d/yyyy");
			Calendar today = Calendar.getInstance();
			String currentdate = df.format(today.getTime());
			System.out.println(currentdate);
		

			WebElement date = driver.findElement(By.xpath("//input[@id='ctl00_ContentPlaceHolder1_txtFirstPaymentDate']"));
			
			selectDateByJS(driver,date,currentdate);
		 //driver.findElement(By.xpath("//input[@id='ctl00_ContentPlaceHolder1_txtRecDuesDate']")).clear();
		 
	
		 
			WebElement date1 = driver.findElement(By.xpath("//input[@id='ctl00_ContentPlaceHolder1_txtRecDuesDate']"));
			selectDateByJS(driver,date1,currentdate);
		

		con.getokbtn().click();
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
		    con.getproceedgotoplan().click();
		con.getpaynowbtn().click();
		
		con.getsplipaymentno().click();;
		con.getpaymentbycash().click();;
		con.getproceedgotoplan().click();;
 
		
		return null;
	}

	 public static void selectDateByJS(WebDriver driver , WebElement element , String dateVal) {
	        JavascriptExecutor js = ((JavascriptExecutor)driver);
	        js.executeScript("arguments[0].setAttribute('value','"+dateVal+"');", element);

	    }
	
}
