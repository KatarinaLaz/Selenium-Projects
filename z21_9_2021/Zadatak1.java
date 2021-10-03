package z21_9_2021;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Zadatak1 {

	public static void main(String[] args) {
		
//		1.Zad
//		Posetite stranicu http://cms.demo.katalon.com/ i u delu za pretragu uneti
//		tekst “Flying Ninja” i kliknuti na search dugme (search ikonica). Pri ucitavanju stranice maksimizovati prozor.
		
		System.setProperty("webdriver.chrome.driver",  "driver-lib\\chromedriver.exe"); 

		WebDriver driver = new ChromeDriver(); 
		driver.manage().window().maximize();

		driver.get("http://cms.demo.katalon.com/"); 

		driver.findElement(By.className("search-field")).sendKeys("Flying Ninja");

		driver.findElement(By.className("search-submit")).click();
	}

	
	
	
	
}

	
	
	
	
	
	
	
