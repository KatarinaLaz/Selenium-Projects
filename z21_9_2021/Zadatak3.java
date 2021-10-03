package z21_9_2021;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Zadatak3 {

	public static void main(String[] args) throws InterruptedException {
		
//		3. Zadatak
//		Napisati program koji:
//		Ucitava stranicu http://cms.demo.katalon.com/ i u delu za pretragu uneti tekst “Pogresan tekst”
//		Brise stari tekst u delu za pretragu
//		Unosi novi tekst “Flying Ninja”
//		Na kraju programa zatvorite stranicu.

		System.setProperty("webdriver.chrome.driver",  "driver-lib\\chromedriver.exe"); 

		WebDriver driver = new ChromeDriver(); 
		driver.manage().window().maximize();

		driver.get("http://cms.demo.katalon.com/"); 
		Thread.sleep(1000);
		
		driver.findElement(By.className("search-field")).sendKeys("Pogresan tekst");
		Thread.sleep(1000);
		
		driver.findElement(By.className("search-field")).clear();
		Thread.sleep(3000);
		
		driver.close();
		
		
		
	}
	
	
	
}

	
	
	
	
	
	
	
