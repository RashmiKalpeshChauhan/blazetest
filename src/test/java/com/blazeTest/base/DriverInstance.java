package com.blazeTest.base;

import java.io.File;

import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class DriverInstance {
	public WebDriver driver;
	public DriverInstance() {
		driver=null;
	}
	@BeforeClass
	public void intiateDriver() {
		driver=this.getChromeDriver();		
		driver.get("https://www.demoblaze.com/#carouselExampleIndicators");
		
	}
	
	private WebDriver getChromeDriver() {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--ignore-certificate-errors");
		ChromeDriverService service=new ChromeDriverService.Builder().usingDriverExecutable(new File("src/test/resources/driver/chromedriver.exe"))
				.usingAnyFreePort()
				.build();
		 ChromeDriver driver=new ChromeDriver(service);	
		    
		return driver;
	}
	public void acceptAlert(WebDriver driver) throws InterruptedException
	{
	   int i=0;
	   while(i++<5)
	   {
	        try
	        {
	            Alert alert = driver.switchTo().alert();
	            alert.accept();
	            break;
	        }
	        catch(NoAlertPresentException e)
	        {
	          Thread.sleep(1000);
	          continue;
	        }
	   }
	}
	
	@AfterClass
	public void afterTest() {
		driver.quit();
	}
}
