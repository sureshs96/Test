package Utilities;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class Helper {
	
	
	public static String CaptureScreenshot(WebDriver driver) {
		String Screenshotpath = System.getProperty("user.dir")+"/Screenshots/sc_"+getCurrentDate()+".png";
		
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try {
			FileHandler.copy(src, new File(Screenshotpath));
		} catch (Exception e) {
			System.out.println("screenshot not captured.."+e.getMessage());
		}
		return Screenshotpath;
	}
	
	public static String getCurrentDate() {
		DateFormat changeformat = new SimpleDateFormat("MM_dd_yyyy_HH_mm_ss");
		
		Date currentdate = new Date();
		return changeformat.format(currentdate);
	}
}
