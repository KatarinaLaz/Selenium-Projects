package z23_9_2021;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Zadatak2 {

	public static void main(String[] args) throws InterruptedException {

//		2.Zadatak
//		Ucitati stranicu https://demoqa.com/modal-dialogs
//		Kliknuti na dugme Large modal
//		Proverite da li se prikazao dijalog i ispisite u konzoli odgovarajuce poruke

		
		System.setProperty("webdriver.chrome.driver",  "driver-lib\\chromedriver.exe"); 

		WebDriver driver = new ChromeDriver(); 
		driver.manage().window().maximize();
		
		driver.get("https://demoqa.com/modal-dialogs");
		
		driver.findElement(By.id("showLargeModal")).click();
		Thread.sleep(1000);
		
		boolean text = true;
		try {
			driver.findElement(By.xpath("//*[@class='modal-body']/p"));
		} catch (Exception e) {
			System.out.println("Element ne postoji.");
			text = false;
		}
		
		if (text) {
			System.out.println("Tekst je uspesno prikazan.");
		} else {
			System.out.println("Tekst nije uspesno prikazan.");
		}
		
		Thread.sleep(2000);
		
		driver.quit();
		
		
		
	}

}
