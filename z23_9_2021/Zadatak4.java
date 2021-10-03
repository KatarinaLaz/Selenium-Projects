package z23_9_2021;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Zadatak4 {

	public static void main(String[] args) {

//		4.Zadatak 
//		Napisati program koji ucitava stranicu Zadatak3.html
//		I na stranici dodaje 20 poruka “IT Bootcamp”
//		Potrebno  je u svakoj iteraciji kliknuti na dugme Show in
//		Sacekati da se novi element pojavi pre nego sto se doda sledeci

		
		System.setProperty("webdriver.chrome.driver",  "driver-lib\\chromedriver.exe"); 

		WebDriver driver = new ChromeDriver(); 
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		driver.get("file:///C:/Users/Kata/Desktop/Zadatak3.html");
		
		for (int i = 0; i < 20; i++) {
			driver.findElement(By.id("showInBtn")).click();
			driver.findElement(By.id("id-" + i));
		}
		
		
		
	}

}
