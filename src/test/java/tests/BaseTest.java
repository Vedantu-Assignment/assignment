package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class BaseTest {
	
	protected WebDriver driver;
	protected static ExtentTest test;
	protected static ExtentReports report;
	
	public BaseTest(){
		String OS = System.getProperty("os.name").toLowerCase();
		
		if(OS.indexOf("win")>=0){
			System.setProperty("webdriver.chrome.driver","ChromeDriver\\chromedriver.exe");
		}
		else if(OS.indexOf("nix") >=0 || OS.indexOf("nux") >=0 || OS.indexOf("aix") >=0) {
			System.getProperty("webdriver.chrome.driver","ChromeDriver\\chromedriver");
		}
		
		this.driver = new ChromeDriver();
		
		report = new ExtentReports(System.getProperty("user.dir")+"\\ExtentReportResults.html");
		test = report.startTest("MakeMyTrip Hotel Reservation");
	}
	
	public void tearDown() {
		this.driver.quit();
		report.endTest(test);
		report.flush();
	}

}
