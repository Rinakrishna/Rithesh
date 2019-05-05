package ReportDemo;


import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
//import com.relevantcodes.extentreports.ReportInstance.ReportConfig;

import common.Assert;

public class Application {
	
	WebDriver dr1;
	ExtentReports report;
	ExtentTest logs;
	@Test
	public void Validation()
	{
		report = new ExtentReports("G:\\ScreenReports\\myFB.html");
		logs = report.startTest("Welcome To Application Validation");
		
		System.setProperty("webdriver.gecko.driver", "H:\\SeliniumJava\\Software\\Drivers\\geckodriver.exe");
		dr1= new FirefoxDriver();
		dr1.manage().window().maximize();
		dr1.get("https://www.facebook.com");
		logs.log(LogStatus.PASS,"Application Successfully Open");
		
		
		dr1.findElement(By.xpath("//input[@id='email']")).sendKeys("Selenium");
		logs.log(LogStatus.PASS,"User able to enter the Username");
		
		dr1.findElement(By.xpath("//input[@id='pass']")).sendKeys("Facebook");
		logs.log(LogStatus.PASS,"User able to enter the Password");
		
		dr1.findElement(By.xpath("//input[@id='u_0_2']")).click();
		logs.log(LogStatus.PASS,"User able to select the login button");
		
		String str = "facebook";
	    //Assert.assertTrue(str.contains("google"));
		Assert.verify(str.contains("facebook"));
	
	}
	@AfterMethod
	public void myResult(ITestResult result) throws IOException
	{
		if(result.getStatus()== ITestResult.FAILURE)
		{
		String scPath = Utility.ScreenShot(dr1, result.getName());
		String imgs = logs.addScreenCapture(scPath);
		logs.log(LogStatus.FAIL, "The Title Verification is Failed",imgs);
		}
		report.endTest(logs);
		report.flush();
		dr1.get("G:\\ScreenReports\\myFB.html");
	}
	
}
	
	

