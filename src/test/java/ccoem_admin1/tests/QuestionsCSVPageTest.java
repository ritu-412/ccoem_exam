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
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import ccoem_admin1.pageobjects.CategoryPage;
import ccoem_admin1.pageobjects.DashboardPage;
import ccoem_admin1.pageobjects.ExamsPage;
import ccoem_admin1.pageobjects.LandingPage;
import ccoem_admin1.pageobjects.LoginPage;
import ccoem_admin1.pageobjects.QuestionsPage;
import ccoem_admin1.testcomponents.BaseTest;
import io.github.bonigarcia.wdm.WebDriverManager;
import run_browserstack.New_Base_Config1;

public class QuestionsCSVPageTest extends BaseTest {


	@Test
	public void Verifyquestions() throws InterruptedException {
	
		String email = properties.getProperty("login_email");
		String password = properties.getProperty("login_pass");
		landingpage = new LandingPage(driver);
		lognpage = new LoginPage(driver);
		dashboardpage = new DashboardPage(driver);
		categorypage = new CategoryPage(driver);
		questionspage = new QuestionsPage(driver);
		examspage = new ExamsPage(driver);
		landingpage.clickToLogin();
		dashboardpage = lognpage.login(email,password);
		questionspage = dashboardpage.questionMenuRedirect();
        questionspage.csvAddquesBtn();
	}
	
	
	

}
