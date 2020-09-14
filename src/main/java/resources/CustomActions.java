package resources;

public class CustomActions extends base {
	
	public static String loginEmployee(String barcodeId, String password) {

		pageObjects.LoginPO l = new pageObjects.LoginPO(driver);

		l.getUserNameInputField().sendKeys(barcodeId);

		l.getPasswordInputField().sendKeys(password);

		l.getLoginButton().click();

		return null;
	}

}
