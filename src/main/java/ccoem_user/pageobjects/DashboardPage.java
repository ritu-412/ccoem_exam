package ccoem_user.pageobjects;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import ccoem_user.Abstractmethods.AbstractMethods;

public class DashboardPage extends AbstractMethods{


	WebDriver driver;
	

	public DashboardPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}




	@FindBy(xpath="//div[@class='dropin']")
	WebElement profile_menu;


	@FindBy(xpath="//div[@class='dropdown-content']/span[@class='dropdown-item'][1]")
	WebElement myprofile;

	@FindBy(xpath="(//ul[@class='navbar-nav w-100']/li/a)[2]")
	WebElement test_url;

	@FindBy(xpath="(//ul[@class='navbar-nav w-100']/li/a)[3]")
	WebElement exam_url;
	
	By edit_success = By.xpath("//div[@role='alert']//div");






	public EditProfilePage enterEditDetails() throws InterruptedException {
		
		Thread.sleep(3000);
		profile_menu.click();
		myprofile.click();
		return new EditProfilePage(driver);
	}

	
	public TestPage testMenuRedirect() {
		test_url.click();
		return new TestPage(driver);

	}


 /* public QuestionsPage questionMenuRedirect() {
	  questionnaire_url.click();
	  return new QuestionsPage(driver);

	} */

	/*	public void leftMenuRedirect(String str) {
		if(str.equalsIgnoreCase("Categories")) {
			cat_url.click();

		} else if(str.equalsIgnoreCase("Subcategories")) {
			subcat_url.click();

		}else if(str.equalsIgnoreCase("Questionnaires")) {
			questionnaire_url.click();

		}else if(str.equalsIgnoreCase("Exam")) {
			exam_url.click();

		}else if(str.equalsIgnoreCase("Assignee")) {
			assign_exam_url.click();

		}else if(str.equalsIgnoreCase("User")) {
			user_url.click();

		}else if(str.equalsIgnoreCase("Results")) {
			result_url.click();

		}

	} */










}
