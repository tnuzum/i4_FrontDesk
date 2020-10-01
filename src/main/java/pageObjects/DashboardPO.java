package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DashboardPO {

	public WebDriver driver;
	
	// OBJECTS
	By frontDeskButton 		= By.id("ContentPlaceHolder1_lnkFrontDesk");
	
	// CONSTRUCTOR
	public DashboardPO(WebDriver driver) {
		this.driver = driver;
	}
	
	// METHODS
	public WebElement getFrontDeskButton()
	{
		return driver.findElement(frontDeskButton);
	}
	
	
	/* !! Examples !!

	// OBJECTS
		By logo 				= By.xpath("//div[@class='logo']//a//img");
		By changePasswordLink 	= By.xpath("//a[@id='linkChangepwd']");
		By logoffLink			= By.xpath("//a[@href='/CompeteOnTheGo/Account/Logoff']");
		
		By fDeskTileTitle 		= By.xpath("(//h3[@class='tile-title'])[1]");
		By fDeskHomeLink		= By.xpath("(//div[@class='tile'])[1]/p/a");
		By fDeskMemberGuestEnroll= By.xpath("(//div[@class='tile'])[1]/a[1]");
		By fDeskCheckIn			= By.xpath("(//div[@class='tile'])[1]/a[2]");
		By fDeskPOS				= By.xpath("(//div[@class='tile'])[1]/a[3]");
		By fDeskClassCheckIn	= By.xpath("(//div[@class='tile'])[1]/a[4]");
		
		By bOfficeTileTitle 	= By.xpath("(//h3[@class='tile-title'])[2]");
		By bOfficeHomeLink		= By.xpath("(//div[@class='tile'])[2]/p/a");
		By bOfficeMemberMgmt	= By.xpath("(//div[@class='tile'])[2]/a[1]");
		By bOfficeClubTaxes		= By.xpath("(//div[@class='tile'])[2]/a[2]");
		By bOfficeAgreementMgmt	= By.xpath("(//div[@class='tile'])[2]/a[3]");
		
		By reportingTileTitle 	= By.xpath("(//h3[@class='tile-title'])[3]");
		By reportingHomeLink	= By.xpath("(//div[@class='tile'])[3]/p/a");
		By reportingViewAllReports	= By.xpath("(//div[@class='tile'])[3]/a[1]");
		
		By adminTileTitle 		= By.xpath("(//h3[@class='tile-title'])[4]");
		By adminHomeLink		= By.xpath("(//div[@class='tile'])[4]/p/a");
		By adminJOLAdmin		= By.xpath("(//div[@class='tile'])[4]/a[1]");
		By adminEMEAdmin		= By.xpath("(//div[@class='tile'])[4]/a[2]");
		
		By footerHomeLink		= By.xpath("//span[@class='footer-icon']/a");
		//these locators below have an extra SPACE after the class attribute
		By footerShoppingCart	= By.xpath("(//span[@class='footer-icon '])[1]/a");
		By footerBackOffice		= By.xpath("(//span[@class='footer-icon '])[2]/a");
		By footerReports		= By.xpath("(//span[@class='footer-icon '])[3]/a");
		By footerAdmin			= By.xpath("(//span[@class='footer-icon '])[4]/a");
		By footerCopyright		= By.xpath("//p[@class='textSmall text-inverse']");
		
	// CONSTRUCTOR
		public DashboardPO(WebDriver driver) {
			DashboardPO.driver = driver;
		}
		
	// METHODS
		public WebElement getLogo()
		{
			return driver.findElement(logo);
		}
		public WebElement getChangePasswordLink()
		{
			return driver.findElement(changePasswordLink);
		}
		public WebElement getLogoffLink()
		{
			return driver.findElement(logoffLink);
		}
		public WebElement getFDeskTileTitle()
		{
			return driver.findElement(fDeskTileTitle);
		}
		public WebElement getFDeskHomeLink()
		{
			return driver.findElement(fDeskHomeLink);
		}
		public WebElement getFDeskMemberGuestEnroll()
		{
			return driver.findElement(fDeskMemberGuestEnroll);
		}
		public WebElement getFDeskCheckIn()
		{
			return driver.findElement(fDeskCheckIn);
		}
		public WebElement getFDeskPOS()
		{
			return driver.findElement(fDeskPOS);
		}
		public WebElement getFDeskClassCheckIn()
		{
			return driver.findElement(fDeskClassCheckIn);
		}
		
		public WebElement getBOfficeTileTitle()
		{
			return driver.findElement(bOfficeTileTitle);
		}
		public WebElement getBOfficeHomeLink()
		{
			return driver.findElement(bOfficeHomeLink);
		}
		public WebElement getBOfficeMemberMgmt()
		{
			return driver.findElement(bOfficeMemberMgmt);
		}
		public WebElement getBOfficeClubTaxes()
		{
			return driver.findElement(bOfficeClubTaxes);
		}
		public WebElement getBOfficeAgreementMgmt()
		{
			return driver.findElement(bOfficeAgreementMgmt);
		}
		
		public WebElement getReportingTileTitle()
		{
			return driver.findElement(reportingTileTitle);
		}
		public WebElement getReportingHomeLink()
		{
			return driver.findElement(reportingHomeLink);
		}
		public WebElement getReportingViewAllReports()
		{
			return driver.findElement(reportingViewAllReports);
		}
		
		public WebElement getAdminTileTitle()
		{
			return driver.findElement(adminTileTitle);
		}
		public WebElement getAdminHomeLink()
		{
			return driver.findElement(adminHomeLink);
		}
		public WebElement getAdminJOLAdmin()
		{
			return driver.findElement(adminJOLAdmin);
		}
		public WebElement getAdminEMEAdmin()
		{
			return driver.findElement(adminEMEAdmin);
		}
		
		public WebElement getFooterHomeLink()
		{
			return driver.findElement(footerHomeLink);
		}
		public WebElement getFooterShoppingCart()
		{
			return driver.findElement(footerShoppingCart);
		}
		public WebElement getFooterBackOffice()
		{
			return driver.findElement(footerBackOffice);
		}
		public WebElement getFooterReports()
		{
			return driver.findElement(footerReports);
		}
		public WebElement getFooterAdmin()
		{
			return driver.findElement(footerAdmin);
		}
		public WebElement getFooterCopyright()
		{
			return driver.findElement(footerCopyright);
		}
		*/
}
