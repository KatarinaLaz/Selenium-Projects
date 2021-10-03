package z28_9_2021;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
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

public class Zadatak1 {
	
//	Zadatak
//	Napisati program koji vrsi dodavanje podataka u tabelu, citajuci podatke iz fajla.
//	Maksimizirati prozor
//	Ucitati stranicu https://www.tutorialrepublic.com/snippets/bootstrap/table-with-add-and-delete-row-feature.php
//	Dodati red podataka - jedan red u jednoj iteraciji 
//	Kliknite na dugme Add New
//	Unesite name,departmant i phone (mogu da budu uvek iste vrednost)
//	Kliknite na zeleno Add dugme
//	Na kraju programa pobrisati sve podatke iz tabele i verifikovati da je broj redova u tabeli jednak nuli!
//	Na kraju programa ugasite pretrazivac.
	
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
	public void dodavanjePodatakaUTabelu() throws InterruptedException {
		driver.get("https://www.tutorialrepublic.com/snippets/bootstrap/table-with-add-and-delete-row-feature.php");
		for (int i = 0; i < 5; i++) {
			driver.findElement(By.className("add-ne")).click();
			driver.findElement(By.id("name")).sendKeys("Katarina");
			driver.findElement(By.id("department")).sendKeys("Human Resources");
			driver.findElement(By.id("phone")).sendKeys("(503) 555-9945");
			
			driver.findElement(By.xpath("//*[contains(@class, 'table')]/div/table/tbody/tr[last()]/td[4]/a")).click();
			
			Thread.sleep(200);	
		}
		
		List<WebElement> rows = driver.findElements(By.xpath("//*[contains(@class, 'table')]/div/table/tbody/tr"));
		
		Assert.assertEquals(rows.size(), 8, "Lista nema 8 elementa nakon dodavanja.");
		System.out.println("Prvi test proso.");
		
		
		for (int i = 0; i < rows.size(); i++) {
			driver.findElement(By.xpath("//*[contains(@class, 'table')]/div/table/tbody/tr/td[4]/a[3]")).click();
			Thread.sleep(200);
//			rows.get(i).findElement(By.xpath("//*[contains(@class, 'table')]/div/table/tbody/tr/td[4]/a[3]")).click(); -> ovo je dobas stos ako for petlju postavimo kao:
//			for (int i = rows.dize(); i > 0; i--)
		}
			
		rows = driver.findElements(By.xpath("//*[contains(@class, 'table')]/div/table/tbody/tr[last()]"));
	
		Assert.assertEquals(rows.size(), 0, "Nisu svi redovi obrisani.");
		
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
