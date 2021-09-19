package com.inetbanking.utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.inetbanking.pageObjects.BaseClass;

public class TestListener extends BaseClass implements ITestListener {

	public TestListener() {
		// TODO Auto-generated constructor stub
		
	}

	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("on start in listener");
		
	}

	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
	log.info(result.getName()+"got passed");
	
	}

	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		log.info(result.getName() + "got failed");
		
		
	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

}
