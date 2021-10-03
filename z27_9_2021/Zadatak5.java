package z27_9_2021;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Zadatak5 {

	public static void main(String[] args) throws InterruptedException {
		
//		5. Napisati program koji ucitava stranicu google i vrsi pretragu preko JSE.
//		Unos teksta u input polje kao i klik na dugme pretrazi mora da bude preko JSE.
//		Koristan link kako da se u input polje unese tekst preko JavaScripta https://www.w3schools.com/jsref/prop_text_value.asp
		
//		document.getElementById("myText").value = "Johnny Bravo";

		System.setProperty("webdriver.chrome.driver",  "driver-lib\\chromedriver.exe"); 

		WebDriver driver = new ChromeDriver(); 
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		
		driver.get("https://www.google.com");
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		WebElement input = driver.findElement(By.className("gLFyf"));
		WebElement btn = driver.findElement(By.className("gNO89b"));
		
		js.executeScript("arguments[0].value = 'Cute dogs'", input);
		Thread.sleep(1000);
		js.executeScript("arguments[0].click()", btn);
		
		
		
		
		
	}

}
