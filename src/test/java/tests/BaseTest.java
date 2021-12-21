package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseTest {
	
	protected WebDriver driver;
	
	public BaseTest(){
		System.setProperty("webdriver.chrome.driver","C:\\Surbhi\\Chrome\\chromedriver_win32\\chromedriver.exe");
		this.driver = new ChromeDriver();
	}
	
	public void tearDown() {
		this.driver.quit();
	}

}
