package ccoem_admin1.stepDefinitions;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

import ccoem_admin1.pageobjects.AssignExamPage;
import ccoem_admin1.pageobjects.CategoryPage;
import ccoem_admin1.pageobjects.DashboardPage;
import ccoem_admin1.pageobjects.EditProfilePage;
import ccoem_admin1.pageobjects.ExamsPage;
import ccoem_admin1.pageobjects.LandingPage;
import ccoem_admin1.pageobjects.LoginPage;
import ccoem_admin1.pageobjects.QuestionsPage;
import ccoem_admin1.pageobjects.ResultsPage;
import ccoem_admin1.pageobjects.SubcategoryPage;
import ccoem_admin1.pageobjects.UserPage;
import ccoem_admin1.testcomponents.BaseTest;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;



public class StepDefinitionimpl extends BaseTest {
	public LandingPage landingpage;
	public LoginPage lognpage;
	public DashboardPage dashboardpage;
	public EditProfilePage editprofilepage;
	public CategoryPage categorypage;
	public SubcategoryPage subcategorypage;
	public QuestionsPage questionspage;
	public ExamsPage examspage;
	public AssignExamPage assignexampage;
	public UserPage userpage;
	public ResultsPage resultspage;
	private String categoryName;
	private String description;


	@Given("I landed on OEM Exam portal Page")
	public void I_landed_on_Exam_Page() throws IOException, InterruptedException
	{
		if (driver == null) {
			setUp();  // ✅ Calls BaseTest's setup method
		}
		landingpage = new LandingPage(driver);
		landingpage.clickToLogin();

	}


	@Given("^Logged in with email (.+) and password (.+)$")
	public void logged_in_username_and_password(String email, String password) throws InterruptedException
	{

		lognpage = new LoginPage(driver);


		dashboardpage = lognpage.login(email,password);
	}


	@When("I redirect to the category menu")
	public void i_redirect_product_to_cart() throws InterruptedException
	{  

		categorypage = dashboardpage.catMenuRedirect();
	}

	@And("Click on category Add button")
	public void click_on_category_add_btn() throws InterruptedException
	{

		categorypage.clickAddcatButton();	
	}


	
	
	@And("^Fill the category name (.+) and description (.+) and submit the form$")
	public void fill_catname_description(String categoryName, String description) throws InterruptedException {
	    this.categoryName = categoryName;  // Store values in instance variables
	    this.description = description;

	    categorypage = new CategoryPage(driver);
	    categorypage.addCategory();  // Call addCategory() without parameters
	}



	@Then("Verify Category success message")
	public void verify_category_success() throws InterruptedException {
		String actualMsg = categorypage.getSuccessMessage(); // Fetch success message from UI
		String expectedSuccessMsg = "Category has been Created Successfully";
		Assert.assertEquals(actualMsg, expectedSuccessMsg, "Category success message does not match");
	}


}



