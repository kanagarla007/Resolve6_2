
package Resolve6;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Search {
	
	static WebDriver obj = null;
	@BeforeTest
	
	public static void BT()
	{
		//WebDriverManager.chromedriver().setup();
		System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromedriver_win32\\chromedriver.exe");
		//obj = new ChromeDriver();
		obj = new ChromeDriver(new ChromeDriverService.Builder().usingPort(9090).build()); 
		obj.get("https://www.selenium.dev/downloads/");
	}
	@AfterTest
	public static void teardown()
	{
		obj.close();
	}
	
	
	
	@Test (priority=1)
	public static void test()
	{
		obj.findElement(By.id("gsc-i-id1")).sendKeys("Test");
		obj.findElement(By.id("gsc-i-id1")).sendKeys(Keys.ENTER);
		String expresult="Programmable Search Engine";
		String actresult=obj.getTitle();
		obj.manage().timeouts().implicitlyWait(3,TimeUnit.SECONDS);
		Assert.assertEquals(expresult, actresult);
		
	}
	@Test (priority=0)
	public static void pl()
	{
		obj.findElement(By.className("releases-button")).click();
		obj.findElement(By.className("close-x")).click();
		
	}

	
	
	
}
