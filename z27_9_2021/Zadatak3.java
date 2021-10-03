package z27_9_2021;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Zadatak3 {

	public static void main(String[] args) {

//		3.Zad
//		Napisati program koji ucitava stranicu https://getbootstrap.com/docs/5.0/forms/select/
//		i skrola stranicu do footera tako sto izvrsava skriptu arguments[0].scrollIntoView();
//		Kao parametar se prosledjuje footer element sa stranice.

		
		System.setProperty("webdriver.chrome.driver",  "driver-lib\\chromedriver.exe"); 

		WebDriver driver = new ChromeDriver(); 
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		
		driver.get("https://getbootstrap.com/docs/5.0/forms/select/");
		
		WebElement footer = driver.findElement(By.className("bd-footer"));
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView()", footer);
		
		
		
	}

}
