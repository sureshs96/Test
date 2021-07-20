package TestCases;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import Pages.BaseClass;
import Pages.LoginPage;

public class WandLogin extends BaseClass {

	
	@Test
	public void StartApp() throws InterruptedException {
		logger = report.createTest("login into wand application");
		LoginPage loginpage = PageFactory.initElements(driver, LoginPage.class);
		logger.info("Starting Application");
		loginpage.login(TestData.getStringData("Sheet1", 1, 0), TestData.getStringData("Sheet1", 1, 1));
		logger.pass("user loggin successfull");
	}
}
