package ccoem_admin1.resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporterNG {
	
	public static ExtentReports getReportObject(String reportFileName)
	{
		/****ExtentSparkReporter responsible for all the configuration for the html file*******/
		String path =System.getProperty("user.dir")+"//reports//"+ reportFileName; // creates a html file where all the report will be visible
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		reporter.config().setReportName("CC OEM Exam Portal Test Results");
		reporter.config().setDocumentTitle("Test Results");
		
		ExtentReports extent =new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester", "Rituparna Majumder");
		return extent;
		
		
		
	}
	
	
	
	
}
