package com.wipro.mavenpro.AssignmentNew1;

//Created by: Rajkumar
//Last Edited:22/2/2018

import static org.testng.Assert.assertTrue;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Hashtable;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.LogStatus;
import PageObjects.AccountRegister;
import PageObjects.OpencartHome;
import PageObjects.WishList;
import utils.DataProviders;
import utils.ExtentTestManager;
import utils.FunctionLibrary;

public class  TC01_RegistrationandAddtoCart extends InitiateDriver {
	
	@Test(dataProvider="CreateAccount",dataProviderClass=DataProviders.class)
	public void RegistrationandAddtoCart(Hashtable<String,String> hashdata) throws IOException
	{
		driver.manage().timeouts().implicitlyWait(40,TimeUnit.SECONDS);
		
		//Setting Description in ExtentReport
		ExtentTestManager.getTest().setDescription("OpenCart Registration and adding to WishList test");
		
		//Click Create account link on Home page
		OpencartHome.CreateAccount(driver).click();
		
		//adding one line
		String num;
		String num2;
		//new line 2
		//new line3
		
		
		//Fill data in Create Account page
		AccountRegister.FirstName(driver).sendKeys(hashdata.get("FirstName"));
		AccountRegister.LastName(driver).sendKeys(hashdata.get("LastName"));
		//AccountRegister.Email(driver).sendKeys(hashdata.get("Email")+FunctionLibrary.UEmailId()+"@email.com");
		AccountRegister.Email(driver).sendKeys(System.nanoTime()+"@email.com");
		AccountRegister.Telephone(driver).sendKeys(hashdata.get("Telephone"));
		AccountRegister.Company(driver).sendKeys(hashdata.get("Company"));
		AccountRegister.Address1(driver).sendKeys(hashdata.get("Address1"));
		AccountRegister.City(driver).sendKeys(hashdata.get("City"));
		AccountRegister.Postcode(driver).sendKeys(hashdata.get("Postcode"));
		Select sctry = new Select(AccountRegister.Country(driver));
		sctry.selectByVisibleText(hashdata.get("Country"));
		Select sregn = new Select(AccountRegister.RegionState(driver));
		sregn.selectByVisibleText(hashdata.get("RegionState"));
		AccountRegister.Password(driver).sendKeys(hashdata.get("Password"));
		AccountRegister.PasswordConfirm(driver).sendKeys(hashdata.get("Password"));
		AccountRegister.Agree(driver).click();
		AccountRegister.Continue(driver).click();
		
		//Assertions: Get and verify Successful message
		
		String LoginVal = OpencartHome.HeaderContentMsg(driver).getText();
		assertTrue(LoginVal.contains("Your Account Has Been Created!"));
		ExtentTestManager.getTest().log(LogStatus.PASS, "Message displayed is   "+LoginVal);
		
		//Adding Item to wish List
		
		OpencartHome.Home(driver).click();
		OpencartHome.SamsungTab(driver).click();
		OpencartHome.WishList(driver).click();
		
		//Assertions: Verify success message displayed after adding to Wishlist
		
		String WishLstSuccess = OpencartHome.WishlistMsg(driver).getText();
		Assert.assertTrue(WishLstSuccess.contains("Success"));
		ExtentTestManager.getTest().log(LogStatus.PASS, "Wish list message displayed is   "+WishLstSuccess);
		
		//close success ribbon and navigate to Wishlist page
		
		OpencartHome.CloseRibbon(driver).click();
		OpencartHome.HomeWishList(driver).click();
		
		//Click on different currency and print currency to flat file
		
		WishList.Pound(driver).click();
		String Poundamt = WishList.Price(driver).getText();
		FileWriter fw = new FileWriter("D:\\data.txt");
		BufferedWriter bw = new BufferedWriter(fw);
		bw.write(Poundamt);
		bw.newLine();
		
		WishList.Euro(driver).click();
		String Euroamt = WishList.Price(driver).getText();
		bw.write(Euroamt);
		bw.newLine();
		
		WishList.Dollar(driver).click();
		String Dollaramt = WishList.Price(driver).getText();
		bw.write(Dollaramt);
		bw.newLine();
		
		//Click on add to carticon and removeicon and click continue
		WishList.AddToCart(driver).click();
		WishList.RemoveIcon(driver).click();
		WishList.Continue(driver).click();
		
		//Click on logout and verify Logout message
		OpencartHome.Logout(driver).click();
		String Logoutmsg = OpencartHome.HeaderContentMsg(driver).getText();
		Assert.assertTrue(Logoutmsg.contains("Account Logout"));
		ExtentTestManager.getTest().log(LogStatus.PASS, "Wish list message displayed is   "+Logoutmsg);
		
		bw.close();	
			
	}

}
