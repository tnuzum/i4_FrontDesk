package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.remote.CapabilityType;

public class base {
	public WebDriver driver;
	public Properties prop;
    static String projectPath = System.getProperty("user.dir");

	public WebDriver initializeDriver() throws Exception {

		ChromeOptions dcch = new ChromeOptions(); // DesiredCapabilities dcch = DesiredCapabilities.chrome();
		dcch.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
		dcch.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);

		prop = new Properties();
		FileInputStream fis=new FileInputStream(projectPath + "\\src\\main\\java\\resources\\properties");
		prop.load(fis);

		String browserName = prop.getProperty("browser"); // Use this to run locally
		//String browserName = System.getProperty("browser"); // Use this to run on Automation Server

			if (browserName.equals("Chrome")) {
				ChromeOptions co = new ChromeOptions();
				co.merge(dcch);
				System.setProperty("webdriver.chrome.driver",
						projectPath + "\\src\\main\\java\\webDrivers\\chromedriver.exe");
				driver = new ChromeDriver(co);
			}
			if (browserName.equals("Firefox")) {
				System.setProperty("webdriver.gecko.driver",
						projectPath + "\\src\\main\\java\\webDrivers\\geckodriver.exe");
				driver = new FirefoxDriver();
			}
			if (browserName.equals("Edge")) {
				System.setProperty("webdriver.edge.driver",
						projectPath + "\\src\\main\\java\\webDrivers\\msedgedriver.exe");
				driver = new EdgeDriver();
			}
			if (browserName.equals("IE")) {
				
			

				InternetExplorerOptions options = new InternetExplorerOptions();
				System.setProperty("webdriver.ie.driver",projectPath + "\\src\\main\\java\\webdrivers\\IEDriverServer_32.exe");
				options.setCapability("ignoreZoomSetting", true);
				
				options.setCapability("nativeEvents", false);    
				options.setCapability("unexpectedAlertBehaviour", "accept");
				options.setCapability("ignoreProtectedModeSettings", true);
				options.setCapability("disable-popup-blocking", true);
				options.setCapability("enablePersistentHover", true);
				driver = new InternetExplorerDriver(options); 
				}


		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		return driver;
	}
	

	public  String takescreenshot(String Result, WebDriver driver) throws Exception {
		
		
	
			  try {
				TakesScreenshot ts = ((TakesScreenshot)driver);
				  
				   File SrcFile = ts.getScreenshotAs(OutputType.FILE);
				  
				 // File DestFile = new File("./Screenshot/AddGuest_details");
				   
				   String timestamp = new SimpleDateFormat("MM_dd_yyyy__hh_mm_ss").format(new Date());
				  
				  FileUtils.copyFile(SrcFile, new File("./Screenshot/FailedTest"+ timestamp +".png"));
				  
				 
				  
			} catch (WebDriverException e) {
				
			} catch (IOException e) {
				
			}
			return null;
		
		}
	
}
