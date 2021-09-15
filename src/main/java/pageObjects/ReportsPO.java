package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import resources.base;

public class ReportsPO extends base{
	
	
		public WebDriver driver;
		
		// Reports
		By Reportslnk = By.cssSelector("a#lnkReports");

		By pageTitle = By.xpath("//span[@id='lbltitle']");

		// Daily business Report module
		By Dailybusinessmodule = By.xpath("//a[@href='#daily']");

		By dailybusinessReport_PageHeader = By.xpath("//h4[@id='myModalLabel1']");

		By Select_CheckInbyDate = By.xpath(
				"//table[@class='table table-responsive table-striped']/tbody/tr/td/a[@href='../Views/ReportFilter.aspx?name=1']");

		By Select_EmployeeContactList = By.xpath(
				"//table[@class='table table-responsive table-striped']/tbody/tr/td/a[@href='../Views/ReportViewer.aspx?name=EmployeeContactList.rpt']");

		// Memberships module
		By Membershipsmodule = By.xpath("//a[@href='#memberships']");

		By MembershipsReport_PageHeader = By.xpath("//h4[@id='myModalLabel2']");

		By Select_contractsEnteredbySalesperson = By.xpath(
				"//table[@class='table table-responsive table-striped']/tbody/tr/td/a[@href='../Views/ReportFilter.aspx?name=9']");

		// members module
		By Membersmodule = By.xpath("//a[@href='#members']");

		By Members_PageHeader = By.xpath("//h4[@id='myModalLabel3']");

		By Select_MemberbyStatus = By.xpath(
				"//table[@class='table table-responsive table-striped']/tbody/tr/td/a[@href='../Views/ReportFilter.aspx?name=13']");

		// Prospect mpdule
		By Prospectsmodule = By.xpath("//a[@href='#pros']");

		By Prospects_PageHeader = By.xpath("//h4[@id='myModalLabel4']");

		By Select_ProspectsExpired = By.xpath(
				"//table[@class='table table-responsive table-striped']/tbody/tr/td/a[@href='../Views/ReportFilter.aspx?name=21']");

		// Sales summary module
		By Sales_Summarymodule = By.xpath("//a[@href='#sales_sum']");//Text4
		
		By SalesSummary_PageHeader = By.xpath("//h4[@id='myModalLabel5']");
		
		By Select_PaymentsReceived = By.xpath(
				"//table[@class='table table-responsive table-striped']/tbody/tr/td/a[@href='../Views/ReportFilter.aspx?name=26']");

		By verifyReportText = By.cssSelector("h3#ContentPlaceHolder1_lblTitleforDateRange");

		By Calenderbtn = By.xpath("//button[@type='button']");// 2

		By ViewReportbtn = By.cssSelector("a#ContentPlaceHolder1_btnView");

		By ViewReportforMemberStatus = By.cssSelector("a#ContentPlaceHolder1_btnAllSecView");

		By BacktoList = By.xpath("//a[@href='ReportList.aspx']");

		By backbtnfromReport = By.xpath("//a[@onclick='cclose();']");	
		
		
		
		public ReportsPO(WebDriver driver) {
			this.driver = driver;
		}

		public WebElement getReportslnk() {

			return driver.findElement(Reportslnk);

		}

		public WebElement getpageTitle() {

			return driver.findElement(pageTitle);

		}

		public WebElement getDailybusinessmodule() {

			return driver.findElement(Dailybusinessmodule);

		}
		public WebElement getdailybusinessReport_PageHeader() {

			return driver.findElement(dailybusinessReport_PageHeader);

		}
		public WebElement getSelect_CheckInbyDate() {

			return driver.findElement(Select_CheckInbyDate);

		}

		public WebElement getSelect_EmployeeContactList() {

			return driver.findElement(Select_EmployeeContactList);

		}

		public WebElement getMembershipsmodule() {

			return driver.findElement(Membershipsmodule);

		}
		public WebElement getMembershipsReport_PageHeader() {

			return driver.findElement(MembershipsReport_PageHeader);

		}
		public WebElement getSelect_contractsEnteredbySalesperson() {

			return driver.findElement(Select_contractsEnteredbySalesperson);

		}

		public WebElement getMembersmodule() {

			return driver.findElement(Membersmodule);

		}

		public WebElement getMembers_PageHeader() {

			return driver.findElement(Members_PageHeader);

		}


		public WebElement getSelect_MemberbyStatus() {

			return driver.findElement(Select_MemberbyStatus);

		}
		public WebElement getProspectsmodule() {

			return driver.findElement(Prospectsmodule);

		}
		public WebElement getProspects_PageHeader() {

			return driver.findElement(Prospects_PageHeader);

		}
		public WebElement getSelect_ProspectsExpired() {

			return driver.findElement(Select_ProspectsExpired);

		}
		public WebElement getSales_Summarymodule() {

			return driver.findElement(Sales_Summarymodule);

		}
		public WebElement getSalesSummary_PageHeader() {

			return driver.findElement(SalesSummary_PageHeader);

		}
		public WebElement getSelect_PaymentsReceived() {

			return driver.findElement(Select_PaymentsReceived);

		}
		public WebElement getCalenderbtn() {

			return driver.findElement(Calenderbtn);

		}

		public WebElement getverifyReportText() {

			return driver.findElement(verifyReportText);

		}

		public WebElement getViewReportbtn() {

			return driver.findElement(ViewReportbtn);

		}

		public WebElement getViewReportforMemberStatus() {

			return driver.findElement(ViewReportforMemberStatus);

		}

		public WebElement getBacktoList() {

			return driver.findElement(BacktoList);

		}

		public WebElement getbackbtnfromReport() {

			return driver.findElement(backbtnfromReport);

		}

	}
