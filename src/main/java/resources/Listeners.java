package resources;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class Listeners extends base implements ITestListener{
	
	resources.base b = new resources.base();
	public WebDriver driver;
	ExtentTest test;
	ExtentReports extent=ExtentReport.getReportobject();
	ThreadLocal<ExtentTest> extentTest =new ThreadLocal<ExtentTest>();
	
	    @Override		
	    public void onStart(ITestContext Result)					
	    {		
	    
	    	test= extent.createTest(Result.getName());
			extentTest.set(test);

	    	
	    }
	    
	    // When Test case get passed, this method is called.		
	    @Override		
	    public void onTestSuccess(ITestResult Result)					
	    {		
	    System.out.println("The name of the testcase passed is :"+Result.getName());
	    extentTest.get().log(Status.PASS, "Test Passed");
	   extent.flush();
	    }	

	    @Override		
	    public void onTestFailedButWithinSuccessPercentage(ITestResult Result)					
	    {		
	    		
	    }		

	    // When Test case get failed, this method is called.		
	    @Override		
	    public void onTestFailure(ITestResult Result) 					
	    {		
	    System.out.println("The name of the testcase failed is :"+Result.getName());
	    extentTest.get().log(Status.FAIL, "Test failed");
		   extent.flush();
	  
	     extentTest.get().fail(Result.getThrowable());
		
		try {
			driver =(WebDriver)Result.getTestClass().getRealClass().getField("driver").get(Result.getInstance());
		} catch(Exception e) {}
		
 
	     try {
			b.takescreenshot(Result.getMethod().getMethodName(), driver);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


		
	    		

	    // When Test case get Skipped, this method is called.		
	    @Override		
	    public void onTestSkipped(ITestResult Result)					
	    {		
	    System.out.println("The name of the testcase Skipped is :"+Result.getName());					
	    }		

	    // When Test case get Started, this method is called.		
	    @Override		
	    public void onTestStart(ITestResult Result)					
	    {		
	    //System.out.println(Result.getName()+" test case started");					
	    }		

	   	

	}			


