package z24_9_2021;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Zadatak3 {

	public static void main(String[] args) throws InterruptedException {

//		3.Zadatak
//		Napisati program koji ucitava stranicu
//		https://s.bootsnipp.com/iframe/klDWV i ceka da se ucita progress bar na 100% a zatim ispisuje tekst u konzoli “Stranica ucitana”
		
		System.setProperty("webdriver.chrome.driver",  "driver-lib\\chromedriver.exe"); 

		WebDriver driver = new ChromeDriver(); 
		
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		driver.get("https://s.bootsnipp.com/iframe/klDWV");
		
		WebElement loader = driver.findElement(By.className("preloader-wrap"));
		
		WebDriverWait waiter = new WebDriverWait(driver, 10);
		waiter.until(ExpectedConditions.attributeContains(loader, "style", "display: none;"));
		System.out.println("Stranica ucitana.");
		
		Thread.sleep(2000);
		driver.quit();
		
		
		
		
		
		
		
		
	}

}
