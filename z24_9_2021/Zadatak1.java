package z24_9_2021;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Zadatak1 {

	public static void main(String[] args) throws InterruptedException {

//		1.Zadatak 
//		Napisati program koji ucitava stranicu Zadatak3.html
//		I na stranici dodaje 20 poruka “IT Bootcamp”
//		Potrebno  je u svakoj iteraciji kliknuti na dugme Show in
//		Sacekati da se novi element pojavi pre nego sto se doda sledeci. Provera za postojanje elemenata treba preko eplicit waita

		
		System.setProperty("webdriver.chrome.driver",  "driver-lib\\chromedriver.exe"); 

		WebDriver driver = new ChromeDriver(); 
		
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		driver.get("file:///C:/Users/Kata/Desktop/Zadatak3.html");
		
		WebDriverWait waiter = new WebDriverWait(driver, 10);
		
		for (int i = 0; i < 20; i++) {
			driver.findElement(By.id("showInBtn")).click();
			waiter.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("id-" + i)));
		}
		
		Thread.sleep(2000);
		driver.quit();
		
		
		
		
		
	}

}
