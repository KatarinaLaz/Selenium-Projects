package z21_9_2021;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Zadatak4 {

	public static void main(String[] args) throws InterruptedException {

//		4. Zadatak
//		Napisati program koji prijavljivanju na stranicu http://cms.demo.katalon.com/my-account/, cekira Remember me checkbox.
		
		System.setProperty("webdriver.chrome.driver",  "driver-lib\\chromedriver.exe"); 

		WebDriver driver = new ChromeDriver(); 
		driver.manage().window().maximize();

		driver.get("http://cms.demo.katalon.com/my-account/"); 
		Thread.sleep(1000);
		
		driver.findElement(By.id("rememberme")).click();
	}

}
