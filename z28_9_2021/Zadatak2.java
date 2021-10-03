package z28_9_2021;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Zadatak2 {

//	2.Zadatak
//	Napisati program koji:
//	Ucitava google stranicu
//	Vrsti pretragu za “IT Bootcamp”
//	I preko assert-a proverava da li na stranici postoji 7 rezultata po stranici.
	
	private WebDriver driver;
	
	@BeforeMethod
	public void setup() {
		System.setProperty("webdriver.chrome.driver",  "driver-lib\\chromedriver.exe"); 
		
		this.driver = new ChromeDriver(); 
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@Test
	public void resultNumber() throws InterruptedException {
		driver.get("https://www.google.com/");
		driver.findElement(By.xpath("//div[@class='a4bIc']/input")).sendKeys("IT Bootcamp" + Keys.ENTER);
		Thread.sleep(2000);
		
		List<WebElement> linkovi = driver.findElements(By.xpath("//div[@class='v7W49e']/div"));
		
		Assert.assertEquals(linkovi.size(), 6, "Nema tacno 6 rezultata.");
	}
	
	
	@AfterMethod
	public void screenshot(ITestResult result) throws Exception {
		if(ITestResult.FAILURE == result.getStatus()) {
			try {
				TakesScreenshot ts =((TakesScreenshot)driver);
				File scrShot=ts.getScreenshotAs(OutputType.FILE);
				Date date = new Date();
				SimpleDateFormat dtf = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
				FileHandler.copy(scrShot, new File("./Screenshots/" + dtf.format(date) + ".png"));
			} catch (Exception e) {
				System.out.println("Screenshot exception.");
			}
		
		}
		
		Thread.sleep(1000);
		driver.quit();
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
