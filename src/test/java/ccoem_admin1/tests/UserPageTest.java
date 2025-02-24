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

import ccoem_admin1.models.User;
import ccoem_admin1.pageobjects.CategoryPage;
import ccoem_admin1.pageobjects.DashboardPage;
import ccoem_admin1.pageobjects.LandingPage;
import ccoem_admin1.pageobjects.LoginPage;
import ccoem_admin1.pageobjects.UserPage;
import ccoem_admin1.testcomponents.BaseTest;
import ccoem_admin1.utils.JsonReader;
import io.github.bonigarcia.wdm.WebDriverManager;


public class UserPageTest extends BaseTest {

	@Test
	public void AddUserProfile() throws InterruptedException {
	    
	    List<User> users = JsonReader.getUsers("src/test/java/ccoem_admin1/testdata/UserData.json");

	    if (users == null || users.isEmpty()) {
	        throw new RuntimeException("No users found in JSON file.");
	    }

	    
	    String email = properties.getProperty("login_email");
	    String password = properties.getProperty("login_pass");

	    landingpage = new LandingPage(driver);
	    lognpage = new LoginPage(driver);
	    dashboardpage = new DashboardPage(driver);
	    categorypage = new CategoryPage(driver);
	    userpage = new UserPage(driver);

	    landingpage.clickToLogin();
	    dashboardpage = lognpage.login(email, password);
	    userpage = dashboardpage.userMenuRedirect();

	    // Iterate through all users in the JSON
	    for (User testUser : users) {
	        userpage.VerifyUserAdd(
	            testUser.getFname(),
	            testUser.getLname(),
	            testUser.getEmail(),
	            testUser.getPhone(),
	            testUser.getPassword(),
	            testUser.getRole()
	        );

	        String actualmsg = userpage.getSuccessMessage();
	        String expectedmsg = "User created Successfully";
	        Assert.assertEquals(actualmsg, expectedmsg, "Add User success message does not match");

	        Thread.sleep(2000); // Adding delay to allow processing before the next user is added
	    }
	}

}
