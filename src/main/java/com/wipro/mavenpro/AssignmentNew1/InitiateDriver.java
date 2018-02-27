package com.wipro.mavenpro.AssignmentNew1;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.LogStatus;

import utils.DataProviders;
import utils.ExtentTestManager;

public class InitiateDriver {

	public WebDriver driver;
	public ExtentReports extent;

	public WebDriver getDriver() {
        return driver;
    }

	@BeforeTest
	@Parameters( "mybrowser" )
	public void DriverIntiate(String mybrowser) throws MalformedURLException, InterruptedException
	{
		/*System.setProperty("webdriver.chrome.driver","D:/Automation/chromedriver.exe");
		driver = new ChromeDriver();*/
		ExtentTestManager.startTest("Suite1","Opencart Suite execution");
		if(mybrowser.equals("chrome"))
		{
			DesiredCapabilities cap = DesiredCapabilities.chrome();
			driver = new RemoteWebDriver(new URL("http://10.159.34.92:4444/wd/hub"),cap);
			ExtentTestManager.getTest().log(LogStatus.INFO, "This test intiated in Chrome browser");
		}
		else if(mybrowser.equals("iexplorer"))
		{
			Thread.sleep(3000);
			DesiredCapabilities cap = DesiredCapabilities.internetExplorer();	
			driver = new RemoteWebDriver(new URL("http://10.159.34.92:4444/wd/hub"),cap);
			ExtentTestManager.getTest().log(LogStatus.INFO, "This test intiated in IE browser");
		}
		driver.get("http://10.207.182.108:81/opencart/");
		driver.manage().window().maximize();
		
	}
	
	@BeforeClass
	public void beforeClass() 
	{
		String className = null;
		className = this.getClass().getName();
		ExtentTestManager.startTest(className, "OpenCart Classes");
	}
	
	@AfterClass
	public void afterClass()
	{
		driver.close();
	}
	
	@AfterSuite
	public void ConClose()
	{
		System.out.println("After Suite");
		driver.quit();
		
	}
}
