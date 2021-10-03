package z24_9_2021;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Zadatak4 {

	public static void main(String[] args) throws InterruptedException {

//		4.Zadatak
//		Napisati program testira upload funkcionalnost: Koristan link https://www.guru99.com/upload-download-file-selenium-webdriver.html
//		Ucitava stranicu https://crop-circle.imageonline.co/#circlecropresult
//		Uploadujte sliku na sajt
//		Kliknite na dugme Crop Circle
//		Proverite se promenila  slika na sajtu
//		POMOC: Slika se promenila ukoliko se promenio src atribut rezultujuce slike.
//		DEO DA SE SNADJETE: 
//			kreirajte folder img u projektu
//			iskopirajte sliku u taj folder
//			U kodu zamnite tako da bude apsolutna putanja do fajla i da radi upload


		
		System.setProperty("webdriver.chrome.driver",  "driver-lib\\chromedriver.exe"); 

		WebDriver driver = new ChromeDriver(); 
		
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		driver.get("https://crop-circle.imageonline.co/#circlecropresult");
		
		WebElement originalImageSrc = driver.findElement(By.id("resultphoto"));
		
		WebElement upload = driver.findElement(By.id("inputImage"));
		
		File image = new File("Images/Breland- Argonth.png");
		String imagePath = image.getAbsolutePath();
		
		upload.sendKeys(imagePath);
		
		WebElement crop = driver.findElement(By.id("photobutton"));
		
		scrollToElement(driver, crop);
		
		crop.click();
		
		WebElement newImageSrc = driver.findElement(By.id("resultphoto"));
		
		
		if (originalImageSrc.getAttribute("src") != newImageSrc.getAttribute("src")) {
			System.out.println("Slika je uspesno kropovana.");
		} else {
			System.out.println("Slika nije uspesno kropovana.");
		}
		
	}

	public static void scrollToElement(WebDriver driver, WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", element);
	}
	
}
