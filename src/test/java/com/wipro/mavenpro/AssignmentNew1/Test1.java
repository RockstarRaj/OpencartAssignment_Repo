package com.wipro.mavenpro.AssignmentNew1;
import org.testng.Assert;
import org.testng.annotations.Test;


public class Test1 extends InitiateDriver{

	@Test
	public void Login()
	{
	//ExtentTestManager.startTest("Test1", "First class");	
	Assert.assertEquals("king", "king"); 
	System.out.println("Successful login");
	}

}
