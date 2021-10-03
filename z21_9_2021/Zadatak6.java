package z21_9_2021;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Zadatak6 {

	public static void main(String[] args) throws InterruptedException {

//		6.Zadatak (MOZDA OSTANE ZA VEZBANJE)
//		Napisti program koji:
//		Ucitava stranicu http://cms.demo.katalon.com/
//		Hvata sve linkove iz navigacije i vraca listu WebElemenata
//		i ispisuje u konzoli tekst svakog linka

		System.setProperty("webdriver.chrome.driver",  "driver-lib\\chromedriver.exe"); 

		WebDriver driver = new ChromeDriver(); 
		driver.manage().window().maximize();

		driver.get("http://cms.demo.katalon.com/"); 
		Thread.sleep(1000);
		
		List<WebElement> lista = driver.findElements(By.xpath("//*[@class=' nav-menu']/li/a"));
		
		for (int i = 0; i < lista.size(); i++) {
			System.out.println(lista.get(i).getAttribute("href"));
		}
		
	
		
		
	}

	
}
