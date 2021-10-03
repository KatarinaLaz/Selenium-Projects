package z27_9_2021;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Zadatak2 {

	public static void main(String[] args) {
		
//		2.Zadatak
//		Napisati program koji:
//		Ucitava stranice (svaku stranicu u posebnom prozoru)
//		https://www.google.com/ 
//		https://www.youtube.com/
//		https://www.facebook.com/
//		https://www.bing.com/?setlang=sr
//		Otvara nove prozore preko JavaScriptExecutora, kao parametar se salje url 
//		Skripta: window.open(arguments[0]);


		System.setProperty("webdriver.chrome.driver",  "driver-lib\\chromedriver.exe"); 

		WebDriver driver = new ChromeDriver(); 
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		for (int i = 0; i < 5; i++) {
			js.executeScript("window.open(arguments[" + i + "])",
					"https://www.google.com/", "https://www.youtube.com/", "https://www.facebook.com/", "https://www.facebook.com/", "https://www.bing.com/?setlang=sr");
		}
		
		
		
	}

}
