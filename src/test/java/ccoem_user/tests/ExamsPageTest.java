package ccoem_user.tests;

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


import ccoem_user.pageobjects.DashboardPage;
import ccoem_user.pageobjects.ExamsPage;
import ccoem_user.pageobjects.LandingPage;
import ccoem_user.pageobjects.LoginPage;
import ccoem_user.pageobjects.TestPage;
import ccoem_user.testcomponents.BaseTest;
import io.github.bonigarcia.wdm.WebDriverManager;
import run_browserstack.New_Base_Config1;

public class ExamsPageTest extends BaseTest {



	@Test(priority = 1)
	public void addQuestionTest() throws InterruptedException {
		String email = properties.getProperty("login_email");
		String password = properties.getProperty("login_pass");
		lognpage = new LoginPage(driver);
		dashboardpage = new DashboardPage(driver);
		testpage = new TestPage(driver);
		dashboardpage = lognpage.login(email,password);
		testpage = dashboardpage.testMenuRedirect();
		//testpage.submitExamTest();
		testpage.startQuiz();
		testpage.saveAndNext();
		// Wait for the next question to load
		Thread.sleep(2000);
		// Answer and submit the second question
		testpage.submit();
		String actualsuccessmsg = testpage.getSuccessMessage(); //returns actual success msg
		String expectedsuccessmsg="Exam submitted Successfully";
		//categorypage.addCat();
		Assert.assertEquals(actualsuccessmsg, expectedsuccessmsg, "Success message does not match");

	}


}
