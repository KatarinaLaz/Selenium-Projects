package z24_9_2021;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Zadatak2 {

	public static void main(String[] args) throws InterruptedException {

//		2.Zadatak
//		Napisati program koji ucitava https://www.kupujemprodajem.com/
//		Cekate da se pojavi reklama i kliknete na x da je iskljucite

		
		System.setProperty("webdriver.chrome.driver",  "driver-lib\\chromedriver.exe"); 

		WebDriver driver = new ChromeDriver(); 
		
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		driver.get("https://www.kupujemprodajem.com/");
		
		WebDriverWait waiter = new WebDriverWait(driver, 10);
		
		waiter.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.className("kpBoxCloseButton")));
		driver.findElement(By.className("kpBoxCloseButton")).click();
		
		Thread.sleep(2000);
		driver.quit();
		
		
		
		
		
		
		
		
	}

}
