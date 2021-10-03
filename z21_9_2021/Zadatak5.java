package z21_9_2021;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Zadatak5 {

	public static void main(String[] args) throws InterruptedException {
		
//		5. Zadatak (dok ne stignemo do ovog zadatka izguglajte kako da selektujete vrednost u select elementu)
//		Napisati program koji ucitava stranicu https://www.ebay.com/ i bira kategoriju “Crafts”

		System.setProperty("webdriver.chrome.driver",  "driver-lib\\chromedriver.exe"); 

		WebDriver driver = new ChromeDriver(); 
		driver.manage().window().maximize();

		driver.get("https://www.ebay.com/"); 
		Thread.sleep(1000);
		
		Select category = new Select(driver.findElement(By.id("gh-cat")));
		category.selectByValue("14339");
		
		
	}

}
