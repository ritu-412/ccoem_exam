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

import ccoem_user.pageobjects.LandingPage;
import ccoem_user.pageobjects.LoginPage;
import ccoem_user.testcomponents.BaseTest;
import io.github.bonigarcia.wdm.WebDriverManager;
import run_browserstack.New_Base_Config1;

public class LandingPageTest extends BaseTest {



	@Test
	public void checkAdminLoginbtn() throws InterruptedException {
		landingpage = new LandingPage(driver);
		boolean isDisplayed = landingpage.admnLoginbtnisdisplayed();
		System.out.println("Login button displayed: " + isDisplayed);
		Assert.assertTrue(isDisplayed, "Login button displayed assertion");
		LoginPage lognpage = landingpage.clickToLogin();

	}



	


}
