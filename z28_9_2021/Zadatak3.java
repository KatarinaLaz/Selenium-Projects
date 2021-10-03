package z28_9_2021;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Zadatak3 {
	
//	3.Zadatak
//	Napisati program koji:
//	Ucitava stranicu https://cms.demo.katalon.com/
//	Dodaje prva 3 proizvoda u korpu tako sto (petljom naravno)
//	Predje misem preko kartice i klikne na dugme ADD TO CART
//	Klikce na Cart link iz navigacije i 
//	Proverava da na stranici postoji 3 proizvoda
//	Proverava da na stranici postoji Proceed to checkout


	private WebDriver driver;
	
	@BeforeMethod
	public void setup() {
		System.setProperty("webdriver.chrome.driver",  "driver-lib\\chromedriver.exe"); 
		
		this.driver = new ChromeDriver(); 
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@Test
	public void test() {
		
	}
	
	
	@AfterMethod
	public void afterMethod() {
		driver.quit();
	}
	
	
	
	
	
	
	
	
	
	
}
