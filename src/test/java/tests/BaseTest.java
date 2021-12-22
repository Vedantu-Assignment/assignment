package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseTest {
	
	protected WebDriver driver;
	
	public BaseTest(){
		String OS = System.getProperty("os.name").toLowerCase();
		
		if(OS.indexOf("win")>=0){
			System.setProperty("webdriver.chrome.driver","ChromeDriver\\chromedriver.exe");
		}
		else if(OS.indexOf("nix") >=0 || OS.indexOf("nux") >=0 || OS.indexOf("aix") >=0) {
			System.getProperty("webdriver.chrome.driver","ChromeDriver\\chromedriver");
		}
		
		this.driver = new ChromeDriver();
	}
	
	public void tearDown() {
		this.driver.quit();
	}

}
