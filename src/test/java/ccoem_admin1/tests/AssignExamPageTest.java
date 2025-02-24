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

import ccoem_admin1.pageobjects.AssignExamPage;
import ccoem_admin1.pageobjects.CategoryPage;
import ccoem_admin1.pageobjects.DashboardPage;
import ccoem_admin1.pageobjects.ExamsPage;
import ccoem_admin1.pageobjects.LandingPage;
import ccoem_admin1.pageobjects.LoginPage;
import ccoem_admin1.pageobjects.QuestionsPage;
import ccoem_admin1.testcomponents.BaseTest;
import io.github.bonigarcia.wdm.WebDriverManager;
import run_browserstack.New_Base_Config1;

public class AssignExamPageTest extends BaseTest {



	@Test
	public void assignexamUserTest() throws InterruptedException {
		String email = properties.getProperty("login_email");
		String password = properties.getProperty("login_pass");
		//String email  = "biswas1.soumyajit@gmail.com";
		//String password  = "Test@1234";
		landingpage = new LandingPage(driver);
		lognpage = new LoginPage(driver);
		dashboardpage = new DashboardPage(driver);
		categorypage = new CategoryPage(driver);
		questionspage = new QuestionsPage(driver);
		examspage = new ExamsPage(driver);
	    assignexampage=new AssignExamPage(driver);
		landingpage.clickToLogin();
		dashboardpage = lognpage.login(email,password);
		assignexampage = examspage.assignuserMenuRedirect();
		assignexampage.addassignUserExam();
		String actualmsg = assignexampage.getSuccessMessage();
		String exptedmsg = "Exam assigned successfully";
		Assert.assertEquals(actualmsg, exptedmsg, "Success message does not match");
		Thread.sleep(2000);
		//assignexampage.changeStatus();
	}



	


}
