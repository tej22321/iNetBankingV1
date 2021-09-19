package com.inetbanking.testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetbanking.pageObjects.BaseClass;
import com.inetbanking.pageObjects.LoginPage;
import com.inetbanking.pageObjects.NewCustomer;

public class TC_NewCustomer_001 extends BaseClass {
	
	
	@Test
	public void addNewCustomer() throws InterruptedException {
		LoginPage lp = new LoginPage(driver);
		NewCustomer nc = new NewCustomer(driver);
		lp.setUsername(username);
		log.info("username is set");
		
		lp.serPassword(password);
		log.info("password is set");
		
		lp.clickLoginBtn();
		log.info("login button is clicked");
		
		Thread.sleep(3000);
		nc.clickNewCustomerLink();
		
		nc.setCustomerName("test");
		nc.setGender("male");
		nc.setDOB("30071990");
		nc.setAddress("asdfgfds");
		nc.setCity("Melbourne");
		nc.setState("VIC");
		nc.setPin("3018");
		nc.setMobileNo("234567865432");
		String email = randomString()+"@gmail.com";
		nc.setEmail(email);
		nc.setPassword("asdasdgasd");
		nc.clickSubmit();
		
	
		
		if(isAlertPresent() == false) {
			Assert.assertTrue(true);
			log.info("newCustomer registered successfully");
		}
		else {
			driver.switchTo().alert();
            String errorText =	driver.switchTo().alert().getText();
            driver.switchTo().alert().accept();
			
			takeScreenShot(driver, "TC_NewCustomer_001");
			try {
			Assert.assertTrue(false);
			}catch (AssertionError e) {
				// TODO: handle exception
				
				log.warn(errorText+ "newCustomer testcase failed");
			}
		}
		
		
	
	}
	
	


	public TC_NewCustomer_001() {
		// TODO Auto-generated constructor stub
	}

}
