package z23_9_2021;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Zadatak1 {

	public static void main(String[] args) throws InterruptedException {
		
//		1.Zadatak
//		Ucitava stranicu https://demoqa.com/login
//		Loginuje se sa usename itbootcamp i lozinkom ITBootcamp2021!
//		Zatim ceka 5sekundi da se korisnik uloguje
//		Proverava da li se korisnik ulogovao, tako sto se proverava postojanje dugmeta Logout. Ispisati odgovarajucu poruku u konzoli za rezultat loginovanja.
//		Klikce na dugme za logout
//		Gasi google chrome 

		System.setProperty("webdriver.chrome.driver",  "driver-lib\\chromedriver.exe"); 

		WebDriver driver = new ChromeDriver(); 
		driver.manage().window().maximize();
		
		driver.get("https://demoqa.com/login");
		driver.findElement(By.id("userName")).sendKeys("itbootcamp");
		driver.findElement(By.id("password")).sendKeys("ITBootcamp2021!");;
		
		driver.findElement(By.id("login")).click();	
		Thread.sleep(1000);
		
//		boolean logoutExist = true;
//		try {
//			WebElement logout = driver.findElement(By.id("submit"));
//			logout.click();
//		} catch (Exception e) {
//			logoutExist = false;
//			System.out.println("Element ne postoji.");
//		}
		
		List<WebElement> loginovi = driver.findElements(By.id("submit"));
		Thread.sleep(1000);
		driver.findElement(By.id("submit")).click();
		Thread.sleep(2000);
		
		if (loginovi.size() > 0) {
			System.out.println("Uspesno ste se ulogovali.");
		} else {
			System.out.println("Korisnik se nije uspesno ulogovao.");		
		}
		Thread.sleep(2000);
		
		driver.quit();
		
		
		
		
		
	}

}
