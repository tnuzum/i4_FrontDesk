package resources;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CustomWaits extends base {

	public CustomWaits() {
		
		
	}
	
 
	public void setDriver(WebDriver wd) {
	driver = wd;
	}
	    
	

	public String waitForLoginPage(int seconds) {

		WebDriverWait wait = new WebDriverWait(driver, seconds);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("UserName")));
		return null;

	}

	public String waitForSelectClubPage(int seconds) {
		
		WebDriverWait wait = new WebDriverWait(driver, seconds);
		wait.until(ExpectedConditions
				.urlMatches("https://ess-web-future2.test-jfisoftware.com:8945/CompeteOnTheGo/Account/ClubSelection"));
		return null;
	}

	public String waitForDashboard(int seconds) {
		
		WebDriverWait wait = new WebDriverWait(driver, seconds);
		wait.until(ExpectedConditions.urlMatches("https://ess-web-future2.test-jfisoftware.com:8945/CompeteOnTheGo/"));
		return null;
	}

}
