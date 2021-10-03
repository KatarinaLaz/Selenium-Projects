package z1_10_2021_pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {

//	LoginPage koja ima:
//	getere za korisničko ime i lozinku
//	metodu login koja submituje formu sa prosledjenim korisničkim nalogom i lozinkom.
	
	private WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}
	
//	GETTERS
	
	public WebElement getUsename() {
		return this.driver.findElement(By.name("username"));
	}
	
	public WebElement getPassword() {
		return this.driver.findElement(By.name("password"));
	}
	
	public WebElement getLoginButton() {
		return this.driver.findElement(By.xpath("//*[@value='Login']"));
	}
	
//	METHODS
	
	public void login(String username, String password) {
		this.getUsename().sendKeys(username);
		this.getPassword().sendKeys(password);
		this.getLoginButton().click();
	}
	
	
	
	
	
}
