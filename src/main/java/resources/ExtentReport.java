package resources;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReport {
	
	static ExtentReports extent;
	
	
	public static ExtentReports getReportobject() {
		
		String timestamp = new SimpleDateFormat("MM_dd_yyyy__hh_mm_ss").format(new Date());
		String path = System.getProperty("user.dir")+"\\reports\\index.html"+timestamp;
		
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		
		reporter.config().setReportName("Web Automation results");
		reporter.config().setDocumentTitle("TestResults");
		
		extent = new ExtentReports();
		extent.attachReporter(reporter);
		
	  return extent;
		
	}
	

}
