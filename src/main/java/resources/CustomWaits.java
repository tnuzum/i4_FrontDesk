package resources;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CustomWaits extends base {

	public static String waitForLoginPage(int seconds) {

		WebDriverWait wait = new WebDriverWait(driver, seconds);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("UserName")));
		return null;

	}

	public static String waitForSelectClubPage(int seconds) {
		
		WebDriverWait wait = new WebDriverWait(driver, seconds);
		wait.until(ExpectedConditions
				.urlMatches("https://ess-web-future2.test-jfisoftware.com:8945/CompeteOnTheGo/Account/ClubSelection"));
		return null;
	}

	public static String waitForDashboard(int seconds) {
		
		WebDriverWait wait = new WebDriverWait(driver, seconds);
		wait.until(ExpectedConditions.urlMatches("https://ess-web-future2.test-jfisoftware.com:8945/CompeteOnTheGo/"));
		return null;
	}

}
