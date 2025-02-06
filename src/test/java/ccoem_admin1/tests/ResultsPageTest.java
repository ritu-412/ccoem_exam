package ccoem_admin1.tests;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;

import ccoem_admin1.pageobjects.CategoryPage;
import ccoem_admin1.pageobjects.DashboardPage;
import ccoem_admin1.pageobjects.LandingPage;
import ccoem_admin1.pageobjects.LoginPage;
import ccoem_admin1.pageobjects.ResultsPage;
import ccoem_admin1.testcomponents.BaseTest;
import ccoem_admin1.testcomponents.Listeners;
import io.github.bonigarcia.wdm.WebDriverManager;
import run_browserstack.New_Base_Config1;

public class ResultsPageTest extends BaseTest {

	@Test
	public void getResultinfo() throws InterruptedException {
		String email = properties.getProperty("login_email");
		String password = properties.getProperty("login_pass");
		//String email  = "biswas1.soumyajit@gmail.com";
		//String password  = "Test@1234";
		String exam = "Exam on test Automation";
		landingpage = new LandingPage(driver);
		lognpage = new LoginPage(driver);
		dashboardpage = new DashboardPage(driver);
		categorypage = new CategoryPage(driver);
		resultspage  = new ResultsPage(driver);
		landingpage.clickToLogin();
		dashboardpage = lognpage.login(email,password);
		resultspage = dashboardpage.resultMenuRedirect();
		resultspage.clickResultList(exam);
		Thread.sleep(2000);
		String resultDetails = resultspage.viewResultDetails();
		ThreadLocal<ExtentTest> extentTest = Listeners.getExtentTest();
		
		if (extentTest.get() != null) {
			extentTest.get().info("<pre>" + resultDetails + "</pre>");
			
		} else {
			System.out.println("❌ ExtentTest instance is NULL in getResultInfo!");
		}
		
		
	}

}
