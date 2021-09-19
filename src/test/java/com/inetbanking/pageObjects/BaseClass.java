package com.inetbanking.pageObjects;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.inetbanking.utilities.ReadConfig;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	ReadConfig rc = new ReadConfig();
	
	public  String  baseUrl = rc.getUrl();
	public  String username = rc.getUsername();
	public  String password = rc.getPassword();
	public  String browser = rc.getBrowser();
	public  WebDriver driver;
	public  Logger log;
	
	
	
	@BeforeClass
	public void setUp() {
		
	
		 log = Logger.getLogger("inetbanking");
		 PropertyConfigurator.configure("log4j.properties");
		 
		if(browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		if(browser.equalsIgnoreCase("mozilla")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		
		}
		driver.get(baseUrl);
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
	}
	
	@AfterClass
	public void tearDown() {
		driver.close();
	}
	
	
	  public void takeScreenShot(WebDriver driver, String  tname) { 
		  TakesScreenshot scrshot = (TakesScreenshot)driver; 
		  File srcFile = scrshot.getScreenshotAs(OutputType.FILE);
	  
	  SimpleDateFormat sdf = new SimpleDateFormat("DDMMYYYYHHMMSS"); 
	  Date d = new Date(); 
	  String formatDate = sdf.format(d); 
	  File destFile = new  File(System.getProperty("user.dir")+"/Screenshots/"+tname+"_"+formatDate+".png");
	  System.out.println(System.getProperty("user.dir")+"/Screenshots/"+tname+"_"+formatDate+".png");
	  
	  try { 
		  FileUtils.copyFile(srcFile, destFile);
		  } catch (IOException e) { 
		  // TODO Auto-generated catch block 
		  e.printStackTrace(); 
		  } 
	  }
	 
	  

		public Boolean isAlertPresent() {
			
			try {
			driver.switchTo().alert();
			return true;
			}
			catch (NoAlertPresentException e) {
				// TODO: handle exception
				return false;
				
			}
		}
		public String randomString() {
			String generatedString = RandomStringUtils.randomAlphabetic(8);
			return generatedString;
		}
	public BaseClass() {
		// TODO Auto-generated constructor stub
		 rc = new ReadConfig();
		

		
		
		
		
	}

}
