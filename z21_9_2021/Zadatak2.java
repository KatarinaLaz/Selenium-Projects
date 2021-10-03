package z21_9_2021;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Zadatak2 {

	public static void main(String[] args) throws InterruptedException {
		
//		2.Zad
//		Napisati program koji:
//		Ucitava stranicu https://demoqa.com
//		Klikce na karticu Book Store Application karticu
//		Klikce na Book Store Application stavku iz levog navigacionog menija
//		Klikce na Login iz padajuceg menija sa leve strane.
//		Loginuje se sa usename itbootcamp i lozinkom ITBootcamp2021!
//		Zatim ceka 5sekundi da se korisnik uloguje
//		Klikce na dugme za logout
//		Gasi google chrome (izguglajte)

		
		System.setProperty("webdriver.chrome.driver",  "driver-lib\\chromedriver.exe"); 

		WebDriver driver = new ChromeDriver(); 
		driver.manage().window().maximize();

		driver.get("https://demoqa.com"); 
		Thread.sleep(1000);

		WebElement bookCard = driver.findElement(By.xpath("//div[@class = 'category-cards']/div[6]"));
		
		scrollToElement(driver, bookCard);
		bookCard.click();
		Thread.sleep(3000);

		WebElement login = driver.findElement(By.xpath("//*[@class='row']//*[@class='left-pannel']/div/div[6]/div/ul/li"));
		
		scrollToElement(driver, login);
		login.click();
		Thread.sleep(3000);
		
		driver.findElement(By.id("userName")).sendKeys("itbootcamp");
		Thread.sleep(1000);
		
		driver.findElement(By.id("password")).sendKeys("ITBootcamp2021!");
		Thread.sleep(5000);
		
		driver.findElement(By.id("login")).click();
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//*[@id='books-wrapper']//*[@id='submit']")).click();
		Thread.sleep(3000);
		
		driver.quit();
		
		
	}

	public static void scrollToElement(WebDriver driver, WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", element);
	}
	
	
	
}

	
	
	
	
	
	
	
