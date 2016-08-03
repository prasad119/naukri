package com.naukri.lib;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.naukri.util.Global;

import jxl.Sheet;
import jxl.Workbook;

public class GeneralFunc {
	public boolean sStatus = true;
	public static WebDriver driver = new FirefoxDriver();

	public static WebElement element = null;
	int temp;
	public static boolean openBrowser(String sUrl){
		try{
			driver.navigate().to(sUrl);
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
			return true;
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return false;
	}	
	public static boolean waitForElementVisible(String locator, int iTimeOut){
		try{
			WebElement element = driver.findElement(By.xpath(locator));
			WebDriverWait wait = new WebDriverWait(driver, iTimeOut);
			wait.until(ExpectedConditions.visibilityOf(element));
			return true;
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return false;
	}
	
	public static boolean clickElement(String locator){
		try{
			driver.findElement(By.xpath(locator)).click();
			return true;
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return false;
	}

	public static boolean inputText(String locator,String text){
		try{
//			driver.findElement(By.xpath(locator)).clear();
			driver.findElement(By.xpath(locator)).sendKeys(text);
			new Actions(driver).sendKeys(Keys.TAB);
			return true;
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return false;
	}
	
	public static boolean selectElement(String elementToSelect, String visibleText){
		try{
			element = driver.findElement(By.xpath(elementToSelect));
			Select selectElement = new Select(element);
			selectElement.selectByVisibleText(visibleText);
			return true;
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return false;
	}

	
	public static String readTestData(String key){
		try{
			Map<String, String> details = new HashMap<String, String>();
			Workbook objWb = Workbook.getWorkbook(new File(Global.sExcelPath));
			Sheet sShobj = objWb.getSheet(Global.sSheetName);
			int noOfSheets = objWb.getSheets().length;
			for(int i=0;i<sShobj.getColumns();i++){
				String headerValues = sShobj.getCell(i, 0).getContents();
				String rowValue = sShobj.getCell(i, 1).getContents();
				details.put(headerValues, rowValue);
			}
			return details.get(key);
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}
	
	public static String getElementAttribute(String locator, String value){
		try{
			String valueFromApp;
			valueFromApp = driver.findElement(By.xpath(locator)).getAttribute(value);
			return valueFromApp;
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}
	
	public static boolean mouseOver(String locator){
		try{
			WebElement element = driver.findElement(By.xpath(locator));
			Actions action = new Actions(driver);
			action.moveToElement(element).build().perform();			
			return true;
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return false;
	}
	public static String getText(String locator){
		try{
			String text = driver.findElement(By.xpath(locator)).getText();
			return text;
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}
	public static void clearField(String locator){
		try{
			String selectAll = Keys.chord(Keys.CONTROL, "a");
			driver.findElement(By.xpath(locator)).sendKeys(selectAll);
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	public static void closeBrowser(){
		try{
			driver.close();
			driver.quit();
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
}
