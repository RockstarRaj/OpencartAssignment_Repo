package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AccountRegister {
	
	//creating Objects for create account page
	
	private static WebElement element =null;
	
	public static WebElement FirstName(WebDriver driver)
	{
		element = driver.findElement(By.name("firstname"));
		return element;
	}
	
	public static WebElement LastName(WebDriver driver)
	{
		element = driver.findElement(By.name("lastname"));
		return element;
	}
	
	public static WebElement Email(WebDriver driver)
	{
		element = driver.findElement(By.name("email"));
		return element;
	}
	
	public static WebElement Telephone(WebDriver driver)
	{
		element = driver.findElement(By.name("telephone"));
		return element;
	}
	
	public static WebElement Company(WebDriver driver)
	{
		element = driver.findElement(By.name("company"));
		return element;
	}
	
	public static WebElement Address1(WebDriver driver)
	{
		element = driver.findElement(By.name("address_1"));
		return element;
	}
	
	public static WebElement City(WebDriver driver)
	{
		element = driver.findElement(By.name("city"));
		return element;
	}
	
	public static WebElement Postcode(WebDriver driver)
	{
		element = driver.findElement(By.name("postcode"));
		return element;
	}
	
	public static WebElement Country(WebDriver driver)
	{
		element = driver.findElement(By.name("country_id"));
		return element;
	}
	
	public static WebElement RegionState(WebDriver driver)
	{
		element = driver.findElement(By.name("zone_id"));
		return element;
	}
	
	public static WebElement Password(WebDriver driver)
	{
		element = driver.findElement(By.name("password"));
		return element;
	}
	
	public static WebElement PasswordConfirm(WebDriver driver)
	{
		element = driver.findElement(By.name("confirm"));
		return element;
	}

	public static WebElement Agree(WebDriver driver)
	{
		element = driver.findElement(By.name("agree"));
		return element;
	}

	public static WebElement Continue(WebDriver driver)
	{
		element = driver.findElement(By.xpath("//input[@value='Continue']"));
		return element;
	}
	
	
}
