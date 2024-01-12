package testngdemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class MyApplication2 {
	
	WebDriver driver;
	
	@BeforeClass
	public void startBrowser()
	{
		driver = new ChromeDriver();
		System.out.println("Browser Started");
	}
	
	@Test
	public void startApp() throws InterruptedException
	{
		
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		String currentURL = driver.getCurrentUrl();
		Assert.assertTrue(currentURL.contains("auth/login"));
		Thread.sleep(3000);
		System.out.println("Application Loaded");
	}

	@Test(dependsOnMethods = "startApp")
	public void loginApp() throws InterruptedException
	{
		driver.findElement(By.xpath("//*[@name='username']")).sendKeys("Admin");
		driver.findElement(By.xpath("//*[@name='password']")).sendKeys("admin123");
		driver.findElement(By.xpath("//*[@type='submit']")).click();
		Thread.sleep(2000);
		boolean status = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/aside/nav/div[2]/ul/li[8]/a/span")).isDisplayed();
		Assert.assertTrue(status);
		System.out.println("Application Login");
	}
	
	@Test(dependsOnMethods = "loginApp")
	public void logoutApp() throws InterruptedException
	{
		driver.findElement(By.xpath("//*[@class='oxd-userdropdown-tab']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[text() = 'Logout']")).click();
		Thread.sleep(3000);
		Assert.assertTrue(driver.findElement(By.xpath("//*[@name='username']")).isDisplayed());
		Thread.sleep(4000);
		System.out.println("Application Logout");
		
	}
	
	@AfterClass
	public void closeApp()
	{
		driver.quit();
		System.out.println("Browser Closed");
	}
}
