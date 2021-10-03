package z1_10_2021_tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import z1_10_2021_pages.LoginPage;
import z1_10_2021_pages.RequestPage;

public class RequestTest {
	
//	Zadatak ( I GRUPA)
//	Napisati program koji testira funkcionalnost dodavanja prijatelja na društvenoj mreži. Od klasa je potrebno:
//	
//	LoginPage koja ima:
//	getere za korisničko ime i lozinku
//	metodu login koja submituje formu sa prosledjenim korisničkim nalogom i lozinkom.
//
//	RequestPage koja ima:
//	geter za dugme Add Friend - //*[contains(text(), 'Add friend')]
//	geter za dugme Cancel Request - //*[contains(text(), 'Cancel Request')]
//	geter za element koji sadrži poruku - //*[@class='ossn-system-messages-inner']/div
//	metodu koja ceka da se element, koji sadrzi poruku, izgubi sa stranice (koristite metodu numberOfElementsToBe da bude nula)
//	metodu koja vraca tekst poruke (tekst elementa koji prikazuje poruku)
//	metodu koja vraca da li dugme Add Friend je na stranici - koristeci logiku sa listama
//	(hvatajte element kao listu ako je lista prazna element ne postoji)
//	metodu koja vraca da li je dugme Cancel Request na stranici - po istoj logici kao i prethodna metoda
//
//	RequestTest koja:
//	Ucitava stranicu https://demo.opensource-socialnetwork.org/login
//	Prijavljuje se na sajt koristeci podatke administrator/administrator
//	Ucitava jednu od stranica (svako neka izabere jednu):
//	https://demo.opensource-socialnetwork.org/u/zKutch
//	https://demo.opensource-socialnetwork.org/u/Keyshawn89
//	https://demo.opensource-socialnetwork.org/u/wVandervort
//	https://demo.opensource-socialnetwork.org/u/Makenna51
//	https://demo.opensource-socialnetwork.org/u/Anika25
//	https://demo.opensource-socialnetwork.org/u/wMoen
//	Proverava da li na stranici postoji Add Friend dugme
//	Salje zahtev za prijateljstvo
//	Proverava da li je prikazana poruka koja sadrzi tekst “Your friend request has been sent!”
//	Proverava da li na stranici postoji dugme Cancel Request
//	Zatim osvezava stranicu i
//	Opet proverava da li na stranici postoji dugme Cancel Request
//	Ponistava zahtev za prijateljstvo
//	Proverava da li je prikazana poruka koja sadrzi tekst “Friend request deleted!”
//	I na kraju proverava da li na stranici je prikazano Add Friend dugme
//
//
//	U AfterClass metodi zatvara stranicu


	private WebDriver driver;
	private WebDriverWait waiter;
	private LoginPage loginPage;
	private RequestPage requestPage;
	
	@BeforeMethod
	public void setup() {
		System.setProperty("webdriver.chrome.driver",  "driver-lib\\chromedriver.exe"); 
		
		this.driver = new ChromeDriver(); 
		this.waiter = new WebDriverWait(driver, 10);
		this.loginPage = new LoginPage(driver);
		this.requestPage = new RequestPage(driver, waiter);
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	
	@Test
	public void test() throws InterruptedException {
		driver.get("https://demo.opensource-socialnetwork.org/login");
		
		loginPage.login("", "");
		
		driver.get("https://demo.opensource-socialnetwork.org/u/zKutch");
		
		Assert.assertEquals(requestPage.addFriendExist(), true, "'Add Friend' button doesn't exist.");
		System.out.println("First test passed.");
		
		requestPage.getAddFriendButton().click();
		
		Thread.sleep(500);
				
		Assert.assertEquals(requestPage.getMessageText().contains("Your friend request has been sent!"), true, "Message not displayed after adding a friend.");
		System.out.println("Second test passed.");
		
		requestPage.waitForDisappear();
		
		Assert.assertEquals(requestPage.cancelRequestExist(), true, "'Cancel Request' button doesn't exist.");
		System.out.println("Third test passed.");
		
		driver.navigate().refresh();
		
		Assert.assertEquals(requestPage.cancelRequestExist(), true, "'Cancel Request' button doesn't exist.");
		System.out.println("Fourth test passed.");
		
		requestPage.getCancelRequestButton().click();
		
		Thread.sleep(500);
		
		Assert.assertEquals(requestPage.getMessageText().contains("Friend request deleted!"), true, "Message not displayed after canceling a friend request.");
		System.out.println("Fifth test passed.");
		
		requestPage.waitForDisappear();
		
		Assert.assertEquals(requestPage.addFriendExist(), true, "'Add Friend' button doesn't exist.");
		
	}
	
	
	@AfterMethod
	public void afterTest() {
		driver.quit();
	}
	
	
	
	
	
	
	
}
