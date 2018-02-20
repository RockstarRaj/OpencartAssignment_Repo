package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WishList {
	
	private static WebElement element =null;
	
	public static WebElement Pound(WebDriver driver)
	{
		element = driver.findElement(By.linkText("£"));
		return element;
	}
	
	public static WebElement Euro(WebDriver driver)
	{
		element = driver.findElement(By.xpath("//div[@id='currency']/a[1]"));
		return element;
	}
	
	public static WebElement Dollar(WebDriver driver)
	{
		element = driver.findElement(By.xpath("//div[@id='currency']/a[3]"));
		return element;
	}
	

	public static WebElement Price(WebDriver driver)
	{
		element = driver.findElement(By.xpath("//td[@class='price']/div"));
		return element;
	}

	public static WebElement AddToCart(WebDriver driver)
	{
		element = driver.findElement(By.xpath("//img[@title='Add to Cart']"));
		return element;
	}

	public static WebElement RemoveIcon(WebDriver driver)
	{
		element = driver.findElement(By.xpath("//img[@title='Remove']"));
		return element;
	}
	
	public static WebElement Continue(WebDriver driver)
	{
		element = driver.findElement(By.linkText("Continue"));
		return element;
	}
	
	
}
