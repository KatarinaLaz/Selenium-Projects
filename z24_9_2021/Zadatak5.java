package z24_9_2021;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Zadatak5 {

	public static void main(String[] args) {

//		5.Zad (Za vezbanje)
//		Napisati program koji:
//		Ucitati stranicu https://boomf.com/boomf-bomb
//		Kliknite na Create Your Own dugme
//		I postavlja sliku na svaku od stranica kocke kao i poruku za kocku
//		Stavi waitere posle uploadovanja slike
		
		
		System.setProperty("webdriver.chrome.driver",  "driver-lib\\chromedriver.exe"); 

		WebDriver driver = new ChromeDriver(); 
		
		Scanner s = new Scanner(System.in);
		
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		driver.get("https://boomf.com/boomf-bomb");
		
		try {
			driver.findElement(By.id("onetrust-policy-title"));
			driver.findElement(By.id("onetrust-reject-all-handler")).click();
		} catch (Exception e) {
		}
		
		driver.findElement(By.xpath("//div[contains(text(), 'Create your own')]")).click();
		
		driver.findElement(By.xpath("//*[@class='cube']/div[2]")).click();
		WebElement slikaJedan = driver.findElement(By.xpath("//input[@accept='image/*']"));
		slikaJedan.sendKeys("C:\\Users\\Kata\\Desktop\\DnD\\DnD Kampanja\\Slike za nacije\\Breland- Argonth.png");
		driver.findElement(By.xpath("//div[contains(text(), 'Continue')]"));
		
		s.close();
		
		
	}

}
