package z30_9_2021;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Zadatak1 {

//	1.Zadatak
//	Napisati program koji testira kalkulator:
//	Skinite fajl snipet.zip, otpakujte i pokrenite index.html fajl iz folder. Iskopirajte putanju - to je link za pokretanje stranice
//
//	Ucitati stranicu za kaklulator
//	Proverite funkcionalnost sabiranja
//	Kliknete na prvi broj
//	Kliknete na plus
//	Kliknete na drugi broj
//	Kliknete na jednako
//	Procitate sracunatu vrednost sa stranice (imate pomoc dole)
//	Proverite da li je ta sracunata vrednost jednaka zbiru dva broja na koja je kliknuto
//	Kliknete na AC dugme i proverite da li se u rezultatu kalkulatora postavlja vrednost nula.
//	Proverite funkcinalnost oduzimanja (slicnih koraka)
//
//	(POMOC) Za citanje vrednosti iz dela koji prikazuje rezultat trebace vam JavaScriptExecutor. Skripta je:
//	Double value = (Double) js.executeScript(“return arguments[0].value”, resultInput);
//	ResultInput je element koji prikazuje rezultat.

	
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
	public void test() throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		int num1 = 7;
		int num2 = 5;
		char operation = '+';
		
		driver.get("file:///C:/Users/Kata/Desktop/snippet%20(1)/index.html");
		driver.findElement(By.xpath("//div[@class='calculator-keys']/button[@value='" + num1 + "']")).click();
		Thread.sleep(200);
		driver.findElement(By.xpath("//div[@class='calculator-keys']/button[@value='" + operation + "']")).click();
		Thread.sleep(200);
		driver.findElement(By.xpath("//div[@class='calculator-keys']/button[@value='" + num2 + "']")).click();
		Thread.sleep(200);
		driver.findElement(By.xpath("//div[@class='calculator-keys']/button[@value='=']")).click();
		Thread.sleep(2000);

		int sum = num1 + num2;
		
		String valueString = (String) js.executeScript("return arguments[0].value", driver.findElement(By.className("calculator-screen")));
		int value = Integer.parseInt(valueString);
		
		Assert.assertEquals(value, sum, "The calcualtion is wrong.");
		
		driver.findElement(By.xpath("//button[@value='all-clear']")).click();
		
		valueString = (String) js.executeScript("return arguments[0].value", driver.findElement(By.className("calculator-screen")));
		value = Integer.parseInt(valueString);
		
		Assert.assertTrue(value == 0, "AC didn't work.");
	}
	
	
	@AfterMethod
	public void afterTest() {
		driver.quit();
	}
	
	
	
	
}
