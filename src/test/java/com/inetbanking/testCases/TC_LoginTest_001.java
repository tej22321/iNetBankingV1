package com.inetbanking.testCases;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.inetbanking.pageObjects.BaseClass;
import com.inetbanking.pageObjects.LoginPage;
import com.inetbanking.utilities.XLUtils;

public class TC_LoginTest_001 extends BaseClass{
	
	LoginPage lp = new LoginPage(driver);
	
	@Test(dataProvider = "logindataprovider")
	public void loginTest(String username,String password) {
		
		lp.setUsername(username);
		lp.serPassword(password);
		lp.clickLoginBtn();
		
		if(isAlertPresent()==true) {
			
			
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
			
			takeScreenShot(driver, "loginTest");
			try {
			Assert.assertTrue(false);
			}catch (AssertionError e) {
				// TODO: handle exception
				
				log.warn("loginTest failed");
					
			}
			
			
			
		}
		else {

			Assert.assertTrue(true);
			log.info("loginTest passed");
			lp.clickLogOutBtn();
			driver.switchTo().alert().accept();
			
			
		}
	
	
	}
	



	@DataProvider(name ="logindataprovider")
	public Object[][] getDataFromDataProvider() {
		// TODO Auto-generated constructor stub
		
		XLUtils dataFromExcel = new XLUtils();
		
 return dataFromExcel.readExcel("Guru99Login");
		
		
	}

}
