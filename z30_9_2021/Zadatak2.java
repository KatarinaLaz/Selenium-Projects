package z30_9_2021;

import java.util.concurrent.TimeUnit;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Zadatak2 {

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
	public void test() throws InterruptedException, ScriptException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		driver.get("file:///C:/Users/Kata/Desktop/snippet%20(1)/index.html");
		
		String formula = "190 + 8.9 - 1.1 + 293284.12123";
		
		calculateFormula(formula);
		operator("=");
		
		String valueString = (String) js.executeScript("return arguments[0].value", driver.findElement(By.className("calculator-screen")));
		
		Assert.assertEquals(valueString, calculateString(formula), "The calcualtion is wrong.");
		
		driver.findElement(By.xpath("//button[@value='all-clear']")).click();
		
		valueString = (String) js.executeScript("return arguments[0].value", driver.findElement(By.className("calculator-screen")));
		Double value = Double.valueOf(valueString);
		
		Assert.assertTrue(value == 0, "AC didn't work.");
	}
	
	
	@AfterMethod
	public void afterTest() {
		driver.quit();
	}
	
	
	public void operator(String ch) throws InterruptedException {
		driver.findElement(By.xpath("//div[@class='calculator-keys']/button[@value='" + ch + "']")).click();
		Thread.sleep(200);
	}
	
	public void calculateFormula(String formula) throws InterruptedException, ScriptException {
		formula = formula.replaceAll("\\s+","");
		char[] ch = formula.toCharArray();
		
		for (int j = 0; j < ch.length; j++) {
			driver.findElement(By.xpath("//div[@class='calculator-keys']/button[@value='" + ch[j] + "']")).click();	
			Thread.sleep(200);
		}
	}
	
	public String calculateString(String formula) throws ScriptException {
		formula = formula.replaceAll("\\s+","");
		
	    ScriptEngineManager mgr = new ScriptEngineManager();
	    ScriptEngine engine = mgr.getEngineByName("JavaScript");
	    String convertedToString = engine.eval(formula).toString();
	    return convertedToString;
	}
		

	
	
}
