package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import resources.base;

public class MSSHomePO extends base {
	
	
public WebDriver driver;
	
	
	By DashboardLink = By.xpath("//a[contains(text(),'Dashboard')]");
	
	By Dashboardheader = By.xpath("//h1/i");
	
	By Getplanname = By.xpath("//h4[contains(text(),'3 Month Gold Membership')]");
	
	By PlanStatus = By.xpath("//h4[contains(text(),'Status: Active')]");
	
	By MyPTPackages = By.xpath("//h4[contains(text(),'My PT Packages')]");
	
	By ViewAllPT = By.xpath("//a[contains(text(),'View All PT')]");
	
	By PersonaltrainingHistoryHeader = By.xpath("//h3[contains(text(),'Personal Training History')]");
	
	By Homelink = By.xpath("//a[@href='/MSS/']");
	
	//Classes
	By ClassEnrollmentTitle = By.xpath("//h4[contains(text(),'Class Enrollment')]");
	
	By Classlink = By.xpath("//a[@href='/MSS/Class']");
	
	By AddClasses = By.xpath("//a[contains(text(),'Add Classes')]");
	
	By SelectClassType = By.id("ddlClassType");
	
	By Classname = By.id("ddlClass");
	
	By FamilyMemberCheckbox = By.xpath("//input[@class='FamilyMemberCheckbox']");
	
	By FindAClass = By.xpath("//a[contains(text(),'Find A Class')]");
	
	By CancelClass = By.xpath("//a[@href='#']/i");
	
	//Appointments
	
	By Appointmentlink = By.xpath("//a[@href='/MSS/Appointment']");
	
	By AddAppointment = By.xpath("//a[contains(text(),'Add Appointments')]");
	
	By AppointmentType = By.id("ddlAppointmentType");
	
	By Dayview = By.cssSelector("span.fc-button.fc-button-agendaDay.fc-state-default.fc-corner-right");

	By Nextbtn = By.cssSelector("span.fc-button.fc-button-next.fc-state-default.fc-corner-right");
	
	By Selectinstructor = By.id("ddlInstructor");
	
	By Submitbutton = By.xpath("//button[@type='submit']");
	
	By finalizeAndPay = By.tagName("h3");
	
	By PaymentMethodText = By.xpath("//h4[contains(text(),'How Would You Like To Pay?')]");
	
	By Makepayment = By.xpath("//a[@id='btnMakePayment']");
	
	By Backbtn = By.xpath("//a[contains(text(),'Back')]");
	
	By EditAppointment = By.xpath("//a[contains(text(),'Edit Appointments')]");
	
	By CanelAppointment = By.xpath("//a[@href='#']/i");
	
	By Appointmenttext = By.tagName("h2");
	
	By AlertHeader = By.xpath("//h4[@id='myModalLabel']");
	
	By AfterCancellation = By.xpath("//label[contains(text(),'   No appointment has scheduled')]");
	
	//Payment information
	
	By PaymentTab = By.xpath("//a[@href='/MSS/Payment']");
	
	By EditPayment = By.cssSelector("a[href='/MSS/Payment/Edit']");
	
	By ChangePaymentMethod = By.cssSelector("a[class='submitForm']");
	
	By MakePaymentLink = By.xpath("//a[@href='/MSS/Payment/MakePayment']");
	
	By NewCCCard = By.cssSelector("input#switch-newcard");
	
	By CardOnFile = By.cssSelector("input#switch-onfile");
	
	By SelectCardType = By.id("CardTypeValue");
	
	By Billingname = By.id("BillingName");
	
	By CardNumber = By.id("CardNumber");
	
	By SelectMonth = By.id("Month");
	
	By SelectYear = By.id("Year");
	
	By SecurityCode = By.id("SecurityCode");
	
	By Address = By.id("Address");
	
	By City = By.id("City");
	
	By State = By.id("State");
	
	By Zip = By.id("Zip");
	
	By ViewCheckinhistory = By.cssSelector("a[href='/MSS/Checkin']");
	
	//Buy PT
	
	By BuyPT_button = By.cssSelector(".cart-button");
	
	//personal information
	By NumberofFamilyMembers = By.xpath("//div/p[contains(text(),'Family Members On Plan:')]");
	By ManageFamilymembers = By.xpath("//a[@href ='/MSS/Customer/ManageFamilyMembers']");
	By Createlogin = By.cssSelector("button[value='Create Login']");
	
	By Cancelbutton = By.xpath("//a[contains(text(),'Cancel')]");
	
	By Changepassword = By.cssSelector("input[value='Change Password']");
	
	By OldpasswordText = By.cssSelector("#currentPassword-error");
	
	By NewPasswordText = By.cssSelector("#newPassword-error");
	By RetypeNewpasword = By.cssSelector("#retypePassword-error");
	
	By Savechanges= By.cssSelector("input#btnSubmit");
	
	By CancelCustomerEdit = By.cssSelector("input[value ='Cancel']");
	
	By Dropdownopen = By.cssSelector(".dropdown-toggle");
	
	By logout = By.cssSelector("a[href='/MSS/Account/LogOff']");
	
	
	public MSSHomePO(WebDriver driver) {
		this.driver = driver;
	}
	
	 public WebElement getDashboardLink() {
			
			return driver.findElement(DashboardLink);
		
		}
	 public WebElement getDashboardheader() {
			
			return driver.findElement(Dashboardheader);
		
		}
	 public WebElement getGetplanname() {
			
			return driver.findElement(Getplanname);
		
		}
	 public WebElement getPlanStatus() {
			
			return driver.findElement(PlanStatus);
		
		}
	 public WebElement getMyPTPackages() {
			
			return driver.findElement(MyPTPackages);
		
		}
	 public WebElement getViewAllPT() {
			
			return driver.findElement(ViewAllPT);
		
		}
	 public WebElement getPersonaltrainingHistoryHeader() {
			
			return driver.findElement(PersonaltrainingHistoryHeader);
		
		}
	 public WebElement getClassEnrollmentTitle() {
			
			return driver.findElement(ClassEnrollmentTitle);
		
		}
	 public WebElement getClasslink() {
			
			return driver.findElement(Classlink);
		
		}
	 public WebElement getAddClasses() {
			
			return driver.findElement(AddClasses);
		
		}
	 public WebElement getSelectClassType() {
			
			return driver.findElement(SelectClassType);
		
		}
	 public WebElement getClassname() {
			
			return driver.findElement(Classname);
		
		}
	 public WebElement getFamilyMemberCheckbox() {
			
			return driver.findElement(FamilyMemberCheckbox);
		
		}
	 public WebElement getFindAClass() {
			
			return driver.findElement(FindAClass);
		
		}
	 public WebElement getAppointmentlink() {
			
			return driver.findElement(Appointmentlink);
		
		}
	 public WebElement getAddAppointment() {
			
			return driver.findElement(AddAppointment);
		
		}
	 public WebElement getAppointmentType() {
			
			return driver.findElement(AppointmentType);
		
		}
	 public WebElement getDayview() {
			
			return driver.findElement(Dayview);
		
		}
	 public WebElement getNextbtn() {
			
			return driver.findElement(Nextbtn);
		
		}
	 public WebElement getSelectinstructor() {
			
			return driver.findElement(Selectinstructor);
		
		}
	 public WebElement getSubmitbutton() {
			
			return driver.findElement(Submitbutton);
		
		}
	 public WebElement getfinalizeAndPay() {
			
			return driver.findElement(finalizeAndPay);
		
		}
	 public WebElement getPaymentMethodText() {
			
			return driver.findElement(PaymentMethodText);
		
		}
	 public WebElement getMakepayment() {
			
			return driver.findElement(Makepayment);
		
		}
	 public WebElement getBackbtn() {
			
			return driver.findElement(Backbtn);
		
		}
	 public WebElement getHomelink() {
			
			return driver.findElement(Homelink);
		
		}
	 public WebElement getEditAppointment() {
			
			return driver.findElement(EditAppointment);
		
		}
	 public WebElement getCanelAppointment() {
			
			return driver.findElement(CanelAppointment);
		
		}
	 public WebElement getAppointmenttext() {
			
			return driver.findElement(Appointmenttext);
		
		}
	 public WebElement getAlertHeader() {
			
			return driver.findElement(AlertHeader);
		
		}
	 public WebElement getAfterCancellation() {
			
			return driver.findElement(AfterCancellation);
		
		}
	 public WebElement getCancelClass() {
			
			return driver.findElement(CancelClass);
		
		}
	 public WebElement getSelectCardType() {
			
			return driver.findElement(SelectCardType);
		
		}
	 public WebElement getBillingname() {
			
			return driver.findElement(Billingname);
		
		}
	 public WebElement getCardNumber() {
			
			return driver.findElement(CardNumber);
		
		}
	 public WebElement getSelectMonth() {
			
			return driver.findElement(SelectMonth);
		
		}
	 public WebElement getSelectYear() {
			
			return driver.findElement(SelectYear);
		
		}
	 public WebElement getSecurityCode() {
			
			return driver.findElement(SecurityCode);
		
		}
	 public WebElement getAddress() {
			
			return driver.findElement(Address);
		
		}
	 public WebElement getCity() {
			
			return driver.findElement(City);
		
		}
	 public WebElement getState() {
			
			return driver.findElement(State);
		
		}
	 public WebElement getZip() {
			
			return driver.findElement(Zip);
		
		}
	 public WebElement getViewCheckinhistory() {
			
			return driver.findElement(ViewCheckinhistory);
		
		}
	 public WebElement getBuyPT_button() {
			
			return driver.findElement(BuyPT_button);
		
		}
	 public WebElement getNumberofFamilyMembers() {
			
			return driver.findElement(NumberofFamilyMembers);
		
		}
	 public WebElement getManageFamilymembers() {
			
			return driver.findElement(ManageFamilymembers);
		
		}
	 public WebElement getCreatelogin() {
			
			return driver.findElement(Createlogin);
		
		}
	 public WebElement getCancelbutton() {
			
			return driver.findElement(Cancelbutton);
		
		}
	 public WebElement getChangepassword() {
			
			return driver.findElement(Changepassword);
		
		}
	 public WebElement getOldpasswordText() {
			
			return driver.findElement(OldpasswordText);
		
		}
	 public WebElement getNewPasswordText() {
			
			return driver.findElement(NewPasswordText);
		
		}
	 public WebElement getRetypeNewpasword() {
			
			return driver.findElement(RetypeNewpasword);
		
		}
	 public WebElement getSavechanges() {
			
			return driver.findElement(Savechanges);
		
		}
	 public WebElement getCancelCustomerEdit() {
			
			return driver.findElement(CancelCustomerEdit);
		
		}
	 public WebElement getDropdownopen() {
			
			return driver.findElement(Dropdownopen);
		
		}
	 public WebElement getPaymentTab() {
			
			return driver.findElement(PaymentTab);
		
		}
	 public WebElement getEditPayment() {
			
			return driver.findElement(EditPayment);
		
		}
	 public WebElement getChangePaymentMethod() {
			
			return driver.findElement(ChangePaymentMethod);
		
		}
	 public WebElement getMakePaymentLink() {
			
			return driver.findElement(MakePaymentLink);
		
		}
	 public WebElement getNewCCCard() {
			
			return driver.findElement(NewCCCard);
		
		}
	 public WebElement getCardOnFile() {
			
			return driver.findElement(CardOnFile);
		
		}
	 public WebElement getlogout() {
			
			return driver.findElement(logout);
		
		}
}
