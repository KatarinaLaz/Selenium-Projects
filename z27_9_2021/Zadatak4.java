package z27_9_2021;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Zadatak4 {

	public static void main(String[] args) {
		
//		4.
//		Napisati program koji ucitava stranicu https://www.jqueryscript.net/demo/ajax-infinite-scroll-template/
//		i ucitava paragrafe sve dok se ne ucita bar 150 paragrafa. 
//		Program nakon svakog ucitavanja skrola do elementa id=”more”


		System.setProperty("webdriver.chrome.driver",  "driver-lib\\chromedriver.exe"); 

		WebDriver driver = new ChromeDriver(); 
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.get("https://www.jqueryscript.net/demo/ajax-infinite-scroll-template/");
		
		List<WebElement> p = driver.findElements(By.xpath("//div[@id='result']/p"));
		WebElement more = driver.findElement(By.id("more"));
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		
		while (p.size() < 150) {
			js.executeScript("arguments[0].scrollIntoView()", more);
			p = driver.findElements(By.xpath("//div[@id='result']/p")); 
		}
		
		System.out.println("Kraj. " + p.size());
		
		
		
	}

}
