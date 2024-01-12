package testngdemo;

import org.testng.Assert;
import org.testng.annotations.Test;

public class FirstTestNGScript {
	
	@Test(priority=1, description = "this test case is for login functionality")
	public void loginApplication() 
	{
	
		
		System.out.println("Login Applications");
		Assert.assertEquals(10, 12);
		
	} 
	@Test(priority=2, description = "this test case will add items in cart")
	public void selectItems() 
	{
	
		
		System.out.println("Item Selected");
		
	} 
	@Test(priority=3, description = "this test case will verify checkout")
	public void checkOut() 
	{
	
		
		System.out.println("Checkout Completed");
		
	} 


}
