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

public class DashboardPageTest extends BaseTest {

	DashboardPage dashboardpage;

	@Test
	public void editProfile() throws InterruptedException {
	
		
		System.out.println("test dashboard");
		//landingpage = new LandingPage(driver);
		//
		//dashboardpage = new DashboardPage(driver);
		//landingpage.clickToLogin();
		//lognpage.login();
		//String fname = "Soumyajit1";
		//String lname = "Biswas1";
		
		
		//dashboardpage.clickSaveButton();
	
		
		//String expectedMessage = "User updated Successfully";
       // String actualMessage = dashboardpage.getSuccessMessage();
       // Assert.assertEquals(actualMessage, expectedMessage, "Profile update success message does not match!");

	}


	@Test
	public void redirectPage() throws InterruptedException {
		//String url = "Categories";
		//dashboardpage.catMenuRedirect(); 
	
	}
	


}
