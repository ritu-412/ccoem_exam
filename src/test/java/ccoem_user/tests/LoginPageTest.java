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
import ccoem_user.pageobjects.LandingPage;
import ccoem_user.pageobjects.LoginPage;
import ccoem_user.testcomponents.BaseTest;
import io.github.bonigarcia.wdm.WebDriverManager;
import run_browserstack.New_Base_Config1;

public class LoginPageTest extends BaseTest {




	@Test(priority = 1)
	/***********Verifying login testcases*****************************************/
	public void loginTest() throws InterruptedException {
		String email = properties.getProperty("login_email");
		String password = properties.getProperty("login_pass");
		//landingpage = new LandingPage(driver);
		lognpage = new LoginPage(driver);

		//landingpage.clickToLogin();
		dashboardpage = lognpage.login(email,password);
		Assert.assertNotNull(dashboardpage, "Login failed, DashboardPage not loaded!");

	}

	@Test(priority = 2, dependsOnMethods = "loginTest")
	public void editProfileTest() throws InterruptedException {
		String fname = "test";
		String lname = "demo";
		editprofilepage = dashboardpage.enterEditDetails();
		editprofilepage.enterEditDetails(fname,lname);
		editprofilepage.clickSaveButton();
		String expectedMessage = "User updated Successfully";
		String actualMessage = editprofilepage.getSuccessMessage();
		Assert.assertEquals(actualMessage, expectedMessage, "Profile update success message does not match!");
		editprofilepage.redirectToDashboard();
	
	}






}
