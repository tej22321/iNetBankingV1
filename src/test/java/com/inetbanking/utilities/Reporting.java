package com.inetbanking.utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Reporting extends TestListenerAdapter{
	
	public ExtentHtmlReporter htmlReport;
	public ExtentReports reports;
	public ExtentTest logger;
	
	

	public Reporting() {
		// TODO Auto-generated constructor stub
	}
	
	  
	  public void onStart(ITestContext testContext) {
		  
		  htmlReport = new ExtentHtmlReporter("./test-output/extent-report.html");
		  htmlReport.loadXMLConfig("./extent-config.xml");
		  
		  reports = new ExtentReports();
		   
		   reports.attachReporter(htmlReport);
		   reports.setSystemInfo("Host Name", "localhost");
		   reports.setSystemInfo("Environment", "QA");
		   reports.setSystemInfo("user", "Teja");
		   
		   htmlReport.config().setDocumentTitle("InetBanking Test Report");
		   htmlReport.config().setReportName("Functional Test Report");
		   htmlReport.config().setTheme(Theme.DARK);
		   
		    
		  
	  }

	  public void onTestSuccess(ITestResult tr) {
		    logger = reports.createTest(tr.getName());
		    logger.log(Status.PASS, MarkupHelper.createLabel(tr.getName(), ExtentColor.GREEN));
		    
		    
		  }
	  
	  
	  public void onTestFailure(ITestResult tr) {
            logger =  reports.createTest(tr.getName());
            logger.log(Status.FAIL, MarkupHelper.createLabel(tr.getName(),ExtentColor.RED));
            
			
			  SimpleDateFormat sdf = new SimpleDateFormat("DDMMYYYYHHMM"); 
			  Date d = new Date();
			  String formatDate = sdf.format(d);
			  
			  String screeenShotPath =  System.getProperty("user.dir")+"/Screenshots/"+tr.getName()+"_"+formatDate+".png";
			  
			  
			  File f = new File(screeenShotPath);
			  
			  if(f.exists()) { 
				  try {
				  
			  logger.fail("Screenshot is below"+logger.addScreenCaptureFromPath(screeenShotPath)); 
			  } catch (IOException e) { 
				  // TODO Auto-generated catch block 
			  e.printStackTrace(); } }
			 
		  }
	  
	  public void onTestSkipped(ITestResult tr) {
       logger = reports.createTest(tr.getName()); 
       logger.log(Status.SKIP, MarkupHelper.createLabel(tr.getName(), ExtentColor.ORANGE));
       
	  }
	  public void onFinish(ITestContext testContext) {
		  reports.flush();
	  }

	  
	 
}

