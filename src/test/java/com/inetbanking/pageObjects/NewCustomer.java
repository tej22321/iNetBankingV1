package com.inetbanking.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class NewCustomer{
	
	@FindBy(how = How.XPATH, using = "//a[contains(text(),'New Customer')]")
	WebElement newCustomerlink;
	
	@FindBy(how = How.XPATH,  using="//input[@name = 'name']")
	WebElement customerName;
	
	@FindBy(how = How.XPATH, using="//input[@name= 'rad1']")
	WebElement gender;
	
	@FindBy(how = How.XPATH, using="//input[@name= 'dob']")
	WebElement dob;
	
	@FindBy(how = How.XPATH, using="//textarea[@name= 'addr']")
	WebElement address;
	
	@FindBy(how = How.XPATH, using="//input[@name= 'city']")
	WebElement city;
	
	@FindBy(how = How.XPATH, using = "//input[@name= 'state']")
	WebElement state;
	
	@FindBy(how =How.XPATH, using = "//input[@name= 'pinno']")
	WebElement pin;
	
	@FindBy(how =How.XPATH, using = "//input[@name= 'telephoneno']")
	WebElement mobileNo;
	
	@FindBy(how =How.XPATH, using = "//input[@name= 'emailid']")
	WebElement emailId;
	
	
	@FindBy(how = How.XPATH, using = "//input[@name= 'password']")
	WebElement  password;
	
	@FindBy(how = How.XPATH, using = "//input[@value= 'Submit']")
	WebElement submit;
	
	public void setCustomerName(String cName) {
		customerName.sendKeys(cName);
	}
	
	public void setGender(String gen) {
		gender.click();
		
	}
	
	public void setDOB(String ddmmyyyy) {
		dob.sendKeys(ddmmyyyy);
	}
	
	public void setAddress(String cAddress) {
		address.sendKeys(cAddress);
	}
	
	public void setCity(String city) {
		this.city.sendKeys(city);
	}
	
	public void setState(String state) {
		this.state.sendKeys(state);
	}
	
	public void  setPin(String pin) {
		this.pin.sendKeys(pin);
	}
	
	public void setMobileNo(String mobileNo) {
		this.mobileNo.sendKeys(mobileNo);
	}
	
	public void setEmail(String emailId) {
		this.emailId.sendKeys(emailId);
	}
	
	public void setPassword(String password) {
		this.password.sendKeys(password);
	}
	
	public void clickSubmit() {
		submit.click();
	}
	
	public void clickNewCustomerLink() {
		newCustomerlink.click();
	}

	public NewCustomer(WebDriver driver) {
		// TODO Auto-generated constructor stub
		PageFactory.initElements(driver, this);
	}

}
