package resources;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class POScustomActions extends base {
	
	public static String pointofsale(String lastname, String cvvcode) {
		pageObjects.POSPO po = new pageObjects.POSPO(driver);

		po.getPOSbtn().click();
	
		po.getmemberbarcode().click();
		po.getlastname().sendKeys(lastname);
		
		po.getsearchbtn().click();
		po.getselectmemberbtn().click();
		po.getitembarcode().click();
		po.getinventorybtn().click();
		po.getitemsearch().click();
		po.getitemselect().click();
		
		po.getproceed().click();
		
		String paymenttype = prop.getProperty("payment");
		if (paymenttype.equals("cash")) {
			po.getcashbtn().click();
			po.getpaymentprocess().click();
			po.gethistory().click();

		}
		if (paymenttype.equals("mastercard")) {

			po.getmastercard().click();

			String s1 = driver.findElement(By.className("modal-content")).getText();
			// System.out.println(s1);
			String s2 = driver.findElement(By.className("modal-body")).getText();
			// System.out.println(s2);

			Select selectmonth = new Select(
					driver.findElement(By.id("ContentPlaceHolder1_ucAcceptCCPayment_drpCCExpiryMonth")));

			selectmonth.selectByVisibleText("12");
			Select selectyear = new Select(
					driver.findElement(By.id("ContentPlaceHolder1_ucAcceptCCPayment_drpCCExpiryYear")));
			selectyear.selectByVisibleText("2020");
			driver.findElement(By.id("ContentPlaceHolder1_ucAcceptCCPayment_txtCVM")).sendKeys(cvvcode);
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			
			
			
			Actions action = new Actions(driver);
			
			action.sendKeys(Keys.TAB).build().perform();
			action.sendKeys(Keys.TAB).build().perform();
			action.sendKeys(Keys.TAB).build().perform();
			action.sendKeys(Keys.TAB).build().perform();
			action.sendKeys(Keys.TAB).build().perform();
			
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			
			WebElement link = driver.findElement(By.id("ContentPlaceHolder1_ucAcceptCCPayment_lnkSubmit"));
			//action.keyDown(Keys.CONTROL).sendKeys(Keys.END).perform();
			action.doubleClick(link).perform();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			link.click();

		}
	
		
		

	


		return null;

}
}