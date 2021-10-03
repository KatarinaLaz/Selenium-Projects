package z27_9_2021;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Zadatak1 {

	public static void main(String[] args) throws InterruptedException {
		
//		1.Zadatak
//		Napisati program koji ucitava stranicu youtube.com i kuca tekst za pretragu a zatim klikce na dugme pretrazi preko javascript executora. 
//		Skripta koja je za izvrsenje je arguments[0].click(); a kao parametar se prosledjuje dugme.

		System.setProperty("webdriver.chrome.driver",  "driver-lib\\chromedriver.exe"); 
		
		Scanner s = new Scanner(System.in);

		WebDriver driver = new ChromeDriver(); 
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.get("https://www.youtube.com/");
		
		System.out.print("Unesite pretragu: ");
		driver.findElement(By.xpath("//input[@id= 'search']")).sendKeys(s.nextLine());
		
		Thread.sleep(1000);
		
		WebElement btn = driver.findElement(By.xpath("//div[@id='center']//button[@id='search-icon-legacy']"));
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click()", btn);
		
		System.out.println("klik");
		
		s.close();
		
		
		
		
	}

}
