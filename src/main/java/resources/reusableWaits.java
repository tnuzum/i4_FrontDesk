package resources;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class reusableWaits extends base {

	public static String waitForLoginPage(int seconds){
		// Check 1: wait for member name element
		WebDriverWait wait = new WebDriverWait(driver, seconds);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("UserName")));
//		System.out.println(DateTime+" INFO: Element is now present");
		// Check 2: wait for member name element to not be blank
//		DashboardPO d = new DashboardPO(driver);
//		WebElement wait = d.getMyFamilyMemberCount();
//		while (wait.getText().isBlank())
//		{
////			System.out.println(DateTime+" INFO: Waiting 500ms for Family Member Count element to populate");
//			Thread.sleep(500);
//			wait.getText();
//		}
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
		wait.until(ExpectedConditions
				.urlMatches("https://ess-web-future2.test-jfisoftware.com:8945/CompeteOnTheGo/"));
		return null;
	} 

}
