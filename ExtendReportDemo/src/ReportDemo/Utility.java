package ReportDemo;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;

public class Utility {
	
	public static String ScreenShot(WebDriver dr1, String ScreenName) throws IOException
	{
		try {
			TakesScreenshot ts=(TakesScreenshot)dr1;
			File src = ts.getScreenshotAs(OutputType.FILE);
			String des="G:\\ScreenReports"+ScreenName+".png";
			File destination=new File(des);
			FileUtils.copyFile(src,destination);
			return des;
		    } catch (WebDriverException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		    }
		return ScreenName; 
	}
	

}
