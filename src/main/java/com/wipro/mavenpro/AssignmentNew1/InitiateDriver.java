package com.wipro.mavenpro.AssignmentNew1;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.relevantcodes.extentreports.ExtentReports;

import utils.ExtentTestManager;

public class InitiateDriver {

	public WebDriver driver;
	public ExtentReports extent;

	public WebDriver getDriver() {
        return driver;
    }

	@BeforeSuite
	//@Parameters( "mybrowser" )
	public void DriverIntiate() throws MalformedURLException
	{
		System.setProperty("webdriver.chrome.driver","D:/Automation/chromedriver.exe");
		driver = new ChromeDriver();
		/*if(mybrowser.equals("chrome"))
		{
			DesiredCapabilities cap = DesiredCapabilities.chrome();
			driver = new RemoteWebDriver(new URL("http://10.159.34.92:4444/wd/hub"),cap);
		}
		else if(mybrowser.equals("iexplorer"))
		{
			DesiredCapabilities cap = DesiredCapabilities.internetExplorer();	
			driver = new RemoteWebDriver(new URL("http://10.159.34.92:4444/wd/hub"),cap);
		}*/
 		
		driver.get("http://10.207.182.108:81/opencart/");
		driver.manage().window().maximize();
		ExtentTestManager.startTest("Suite1","Opencart Suite execution");
	}
	
	@BeforeClass
	public void beforeClass() 
	{
		String className = null;
		className = this.getClass().getName();
		ExtentTestManager.startTest(className, "OpenCart Classes");
	}
	
	@AfterSuite
	public void ConClose()
	{
		System.out.println("After Suite");
		driver.quit();
		
	}
}
