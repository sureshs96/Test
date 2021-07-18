package TestCases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;


public class Login {
	WebDriver driver;
	
	@SuppressWarnings("deprecation")
	@Test
	public void startApp(){
		
		System.setProperty("webdriver.edge.driver","C:\\Users\\SURESH\\eclipse-workspace\\Twingo\\Drivers\\msedgedriver.exe");
		driver = new EdgeDriver();
		
		driver.get("http://wand.gene.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		driver.findElement(By.xpath("//input[@name='pf.username']")).sendKeys("singamss");
		driver.findElement(By.xpath("//input[@name='pf.pass']")).sendKeys("Hserus*96");
		driver.findElement(By.xpath("//input[@type='submit']")).click();

		
		driver.findElement(By.xpath("//img[@name='logout']")).click();
		
		
	}
	
		
}
