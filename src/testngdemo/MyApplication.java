package testngdemo;

import org.testng.Assert;
import org.testng.annotations.Test;

public class MyApplication {
	
	@Test
	public void startApp()
	{
		Assert.assertEquals(10, 12);
		System.out.println("Starting app");
	}

	@Test(dependsOnMethods = "startApp")
	public void loginApp()
	{
		System.out.println("Login to app");
	}
	
	@Test(dependsOnMethods = "{loginApp,startApp}")
	public void logoutApp()
	{
		System.out.println("Logout app");
	}
	
}
