package com.sample.jenkinstest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.Test;

public class Sample {
	WebDriver driver = null;
	@Test
	public void f() {
		String value = System.getProperty("propertyName");
		
		if(value.equalsIgnoreCase("firefox")){
			driver = new FirefoxDriver();
		}
		else if(value.equalsIgnoreCase("chrome")){
			driver = new ChromeDriver();
		}
		else if(value.equalsIgnoreCase("ie")){
			driver = new InternetExplorerDriver();
		}
		
		driver.get("http://www.google.com");
		try{
			Thread.sleep(3000);
		}
		catch(Exception e){
			e.printStackTrace();
		}
		driver.close();
		driver.quit();
	}
}
