package z30_9_2021;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Zadatak3 {

//	2.Zadatak (mozda ostane za vezbanje)
//	Ucitati stranicu https://www.bu.edu/tech/services/cccs/websites/www/wordpress/how-to/sortable-searchable-tables/
//	Kliknuti na header kolonu Athlete (da bi se desilo sortiranje)
//	Sacekajte malo
//	Dohvatite sve redove iz tabele i proverite da li su vrednosti u prvoj koloni sortirane u rastucem redosledu
//	Za poredjenje dva stringa, u kakvom su odnosu trebace vam metoda compareTo
	
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
	public void test() throws InterruptedException {
		driver.get("https://www.bu.edu/tech/services/cccs/websites/www/wordpress/how-to/sortable-searchable-tables/");
		
		scrollTo(By.xpath("//div[@class='entry']/h4"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		js.executeScript("arguments[0].click()", driver.findElement(By.xpath("//div[@class='entry']/h4")));
		
		Thread.sleep(5000);
	}
	
	
	
	@AfterMethod
	public void afterTest() {
		driver.quit();
	}
	
	
	public void scrollTo(By locator) throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView()", driver.findElement(locator));
		Thread.sleep(400);
	}
	
	
	
	
	
	
	
	
	
	
}
