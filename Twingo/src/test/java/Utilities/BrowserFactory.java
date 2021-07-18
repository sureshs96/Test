package Utilities;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class BrowserFactory {
	
	@SuppressWarnings("deprecation")
	public static WebDriver startApplication(WebDriver driver, String browsername, String url) {
		
		if(browsername.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\SURESH\\eclipse-workspace\\Twingo\\Drivers\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		else if(browsername.equalsIgnoreCase("edge")) {
			System.setProperty("webdriver.edge.driver", "C:\\Users\\SURESH\\eclipse-workspace\\Twingo\\Drivers\\msedgedriver.exe");
			driver = new EdgeDriver();
		}
		else if(browsername.equalsIgnoreCase("ie")) {
			System.setProperty("webdriver.ie.driver", "C:\\Users\\SURESH\\eclipse-workspace\\Twingo\\Drivers\\IEdriverServer.exe");
			driver = new InternetExplorerDriver();
		}
		else {
			System.out.println("unsupported browser");
		}
		
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		return driver;
		
	}
}
