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

import ccoem_admin1.pageobjects.CategoryPage;
import ccoem_admin1.pageobjects.DashboardPage;
import ccoem_admin1.pageobjects.LandingPage;
import ccoem_admin1.pageobjects.LoginPage;
import ccoem_admin1.pageobjects.SubcategoryPage;
import ccoem_admin1.testcomponents.BaseTest;
import io.github.bonigarcia.wdm.WebDriverManager;
import run_browserstack.New_Base_Config1;

public class SubcategoryPageTest extends BaseTest {



	@Test(priority=1)
	public void verifyaddSubcatTest() throws InterruptedException {
		String url = "subcategories";
		landingpage = new LandingPage(driver);
		lognpage = new LoginPage(driver);
		dashboardpage = new DashboardPage(driver);
		categorypage = new CategoryPage(driver);
		subcategorypage = new SubcategoryPage(driver);
		landingpage.clickToLogin();
		//lognpage.login();
		//dashboardpage.leftMenuRedirect(url);
		subcategorypage.clickAddsubcatbtn();
		//String actualsuccessmsg =subcategorypage.addSubcat();
		String expectedsuccessmsg="Subcategory created successfully";
		//categorypage.addCat();
		//Assert.assertEquals(actualsuccessmsg, expectedsuccessmsg, "SubCategory success message does not match");
	
	}
	
	
/*	@Test
	public void editSubCatTitleTest() throws InterruptedException {

		String actualtitle= subcategorypage.getEditsubcatTitle();
		String Expectedtitle = "Edit Sub Category";
		Assert.assertEquals(actualtitle, Expectedtitle, "The edit category title does not match");

	} */

   
	@Test(priority=2)
	public void redirectQuestionnaire() throws InterruptedException {
		String url = "Questionnaires";
		//dashboardpage.leftMenuRedirect(url);

	}

	


}
