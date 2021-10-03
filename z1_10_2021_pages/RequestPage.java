package z1_10_2021_pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RequestPage {

//	RequestPage koja ima:
//	geter za dugme Add Friend - //*[contains(text(), 'Add friend')]
//	geter za dugme Cancel Request - //*[contains(text(), 'Cancel Request')]
//	geter za element koji sadrži poruku - //*[@class='ossn-system-messages-inner']/div
//	metodu koja ceka da se element, koji sadrzi poruku, izgubi sa stranice (koristite metodu numberOfElementsToBe da bude nula)
//	metodu koja vraca tekst poruke (tekst elementa koji prikazuje poruku)
//	metodu koja vraca da li dugme Add Friend je na stranici - koristeci logiku sa listama
//	(hvatajte element kao listu ako je lista prazna element ne postoji)
//	metodu koja vraca da li je dugme Cancel Request na stranici - po istoj logici kao i prethodna metoda
	
	private WebDriver driver;
	private WebDriverWait waiter;
	
	public RequestPage(WebDriver driver, WebDriverWait waiter) {
		this.driver = driver;
		this.waiter = waiter;
	}
	
//	GETTERS
	
	public WebElement getAddFriendButton() {
		return this.driver.findElement(By.xpath("//*[contains(text(), 'Add friend')]"));
	}
	
	public WebElement getCancelRequestButton() {
		return this.driver.findElement(By.xpath("//*[contains(text(), 'Cancel Request')]"));
	}
	
	public WebElement getMessage() {
		return this.driver.findElement(By.xpath("//*[@class='ossn-system-messages-inner']/div"));
	}
	
//	METHODS
	
	public void waitForDisappear() {
		waiter.until(ExpectedConditions.numberOfElementsToBe(By.xpath("//*[@class='ossn-system-messages-inner']/div"), 0));
	}
	
	public String getMessageText() {
		return this.getMessage().getText();
	}
	
	public boolean addFriendExist() {
		List<WebElement> addFriend = driver.findElements(By.xpath("//*[contains(text(), 'Add friend')]"));
		return addFriend.size() == 1;
	}
	
	public boolean cancelRequestExist() {
		List<WebElement> cancelRequest = driver.findElements(By.xpath("//*[contains(text(), 'Cancel Request')]"));
		return cancelRequest.size() == 1;
	}
	
	
	
}
