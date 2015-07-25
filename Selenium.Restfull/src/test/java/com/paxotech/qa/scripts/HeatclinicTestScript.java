package com.paxotech.qa.scripts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HeatclinicTestScript {

	protected WebDriver driver = null;
	
	@BeforeMethod
	public void setUp(){
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		driver.navigate().to("http://www.inmarkit.com");
		
	}
	
	@Test
	public void test(){
		
		
		
	}
	
	
	@AfterMethod
	public void tearDown(){
		driver.close();
		driver.quit();
	}

}
