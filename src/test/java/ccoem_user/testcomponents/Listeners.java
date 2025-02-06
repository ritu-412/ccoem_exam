package ccoem_user.testcomponents;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import ccoem_user.resources.ExtentReporterNG;



public class Listeners extends BaseTest implements ITestListener {

	ExtentTest test;
	ExtentReports extent;
	ThreadLocal<ExtentTest> extentTest = new ThreadLocal<>();

	//ExtentReports extent = ExtentReporterNG.getReportObject();
	//ExtentReports categoryReport = ExtentReporterNG.getReportObject("CategoryTestReports.html");
	//ExtentReports examReport = ExtentReporterNG.getReportObject("ExamTestReports.html");
	//ExtentReports assignUserExamReport = ExtentReporterNG.getReportObject("AssignUserExam.html");
	//ThreadLocal<ExtentTest> extentTest = new ThreadLocal<ExtentTest>();
	//Threadlocal gives the unique thread id, so that during parallel execution no concurrency issues occures
	//ThreadLocal<ExtentTest> extentTest = new ThreadLocal<>();

	/*	@Override
	public void onTestStart(ITestResult result) {
	    String className = result.getTestClass().getName(); // Get the fully qualified class name

	    if (className.contains("AssignExam")) {
	        test = assignUserExamReport.createTest(result.getMethod().getMethodName());
	    } else if (className.contains("Category")) {
	        test = categoryReport.createTest(result.getMethod().getMethodName());
	    } else if (className.contains("Exam")) {
	        test = examReport.createTest(result.getMethod().getMethodName());
	    } else {
	        test = categoryReport.createTest(result.getMethod().getMethodName()); // Default Report
	    }

	    extentTest.set(test);
	} */

	@Override
	public void onTestStart(ITestResult result) {
		// Get the test class name dynamically
		String className = result.getTestClass().getRealClass().getSimpleName();
		String reportFileName = className + ".html"; // Example: "CategoryPageTest.html"

		// Initialize report only once per test class
		if (extent == null) {
			extent = ExtentReporterNG.getReportObject(reportFileName);
		}

		ExtentTest test = extent.createTest(result.getMethod().getMethodName()); // Create a test entry for each method
		extentTest.set(test); // Store test instance for thread safety
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		extentTest.get().log(Status.PASS, "Test Passed");

	}

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		extentTest.get().fail(result.getThrowable());//

		try {
			driver = (WebDriver) result.getTestClass().getRealClass().getField("driver")
					.get(result.getInstance());

		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}



		String filePath = null;
		try {

			filePath = getScreenshot(result.getMethod().getMethodName(),driver);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		extentTest.get().addScreenCaptureFromPath(filePath, result.getMethod().getMethodName());


		//Screenshot, Attach to report


	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		extentTest.get().log(Status.SKIP, "Test Skipped");

	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub

	}

	/*@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		  categoryReport.flush();
	      examReport.flush();
	      assignUserExamReport.flush();

	}*/

	@Override
	public void onFinish(ITestContext context) {
		if (extent != null) {
			extent.flush(); // Flush the dynamically created report
		}
	}




}
