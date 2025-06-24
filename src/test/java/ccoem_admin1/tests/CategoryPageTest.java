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

public class CategoryPageTest extends BaseTest {

	String newcatname = "Automation Testing";

	@Test(priority = 1)
	public void VerifyaddCatgoryTest() throws InterruptedException {
		String email = properties.getProperty("login_email");
		String password = properties.getProperty("login_pass");
		//String email  = "biswas1.soumyajit@gmail.com";
		//String password  = "Test@1234";
		landingpage = new LandingPage(driver);
		lognpage = new LoginPage(driver);
		dashboardpage = new DashboardPage(driver);
		categorypage = new CategoryPage(driver);
		landingpage.clickToLogin();
		dashboardpage = lognpage.login(email,password);
		categorypage = dashboardpage.catMenuRedirect();
		categorypage.clickAddcatButton();
		String actualsuccessmsg = categorypage.addCategory(); //returns actual success msg
		String expectedsuccessmsg="Category Created Successfully!";
		//categorypage.addCat();
		Assert.assertEquals(actualsuccessmsg, expectedsuccessmsg, "Category success message does not match");
	
	} 


	@Test(priority = 3)
	public void editCatTitleTest() throws InterruptedException {

		String actualtitle= categorypage.getEditcatTitle();
		String Expectedtitle = "Edit Category";
		Assert.assertEquals(actualtitle, Expectedtitle, "The edit category title does not match");

	}


	@Test(priority = 4)
	public void editCatTest() throws InterruptedException {
		String newcatdesc = "Software Testing test description";
		categorypage.clickEditCat(newcatdesc);
		Thread.sleep(2000);
		subcategorypage = categorypage.subcatMenuRedirect();
		

	}

	@Test(priority = 2)
	public void verifyCatFirstrow() throws InterruptedException {
		String actualrow = categorypage.checkFirstRow();
		String expectedrow = newcatname;
		Assert.assertEquals(actualrow, expectedrow, "The category is not listed in the first row");

	}
	
	
	@Test(priority = 5)
	public void AddsubCatTest() throws InterruptedException {
        String subcat1 = "Selenium";
        String subcat2 = "PlayWright";
		subcategorypage = categorypage.subcatMenuRedirect();
		subcategorypage.clickAddsubcatbtn();
		String actualsuccessmsg1 = subcategorypage.addSubcat(subcat1);
		Thread.sleep(2000);
		subcategorypage.clickAddsubcatbtn();
		String actualsuccessmsg2 = subcategorypage.addSubcat(subcat2);
		String expectedsuccessmsg="Subcategory created successfully";
		//categorypage.addCat();
		Assert.assertEquals(actualsuccessmsg2, expectedsuccessmsg, "SubCategory success message does not match");
	
		

	}
	
	
	@Test(priority = 6)
	public void editSubCatTitleTest() throws InterruptedException {

		String actualtitle= subcategorypage.getEditsubcatTitle();
		String Expectedtitle = "Edit Sub Category";
		Assert.assertEquals(actualtitle, Expectedtitle, "The edit category title does not match");

	}


}
