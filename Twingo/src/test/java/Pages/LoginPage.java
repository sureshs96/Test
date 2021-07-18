package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {
	WebDriver driver;
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}
	
	@FindBy(xpath="//input[@name='pf.username']") WebElement username;
	@FindBy(xpath="//input[@name='pf.pass']") WebElement password;
	@FindBy(xpath="//input[@type='submit']") WebElement submit;
	
	public void login(String Username,String Password) throws InterruptedException {
		Thread.sleep(5000);
		username.sendKeys(Username);
		password.sendKeys(Password);
		submit.click();
	}
	
	
	
}
