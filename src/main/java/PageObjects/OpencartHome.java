package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class OpencartHome {
	
private static WebElement element =null;
	
	public static WebElement CreateAccount(WebDriver driver)
	{
		element = driver.findElement(By.linkText("create an account"));
		return element;
	}
	
	public static WebElement HeaderContentMsg(WebDriver driver)
	{
		element = driver.findElement(By.xpath("//div[@id='content']/h1"));
		return element;
	}

	public static WebElement Home(WebDriver driver)
	{
		element = driver.findElement(By.linkText("Home"));
		return element;
	}
	
	public static WebElement SamsungTab(WebDriver driver)
	{
		element = driver.findElement(By.linkText("Samsung Galaxy Tab 10.1"));
		return element;
	}
	
	public static WebElement WishList(WebDriver driver)
	{
		element = driver.findElement(By.linkText("Add to Wish List"));
		return element;
	}
	
	public static WebElement WishlistMsg(WebDriver driver)
	{
		element = driver.findElement(By.xpath("//div[@id='container']/div[3]/div"));
		return element;
	}
	
	public static WebElement CloseRibbon(WebDriver driver)
	{
		element = driver.findElement(By.xpath("//img[@class='close']"));
		return element;
	}
	
	public static WebElement HomeWishList(WebDriver driver)
	{
		element = driver.findElement(By.linkText("Wish List (1)"));
		return element;
	}
	
	public static WebElement Logout(WebDriver driver)
	{
		element = driver.findElement(By.linkText("Logout"));
		return element;
	}
	
}
