package ccoem_admin1.pageobjects;

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

import ccoem_admin1.Abstractmethods.AbstractMethods;

public class DashboardPage extends AbstractMethods{


	WebDriver driver;
	

	public DashboardPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
		//test comment for git eclipse

	}




	@FindBy(xpath="//div[@class='profile']")
	WebElement profile_menu;


	@FindBy(xpath="//ul[@class='list-unstyled']/li[1]")
	WebElement myprofile;



	@FindBy(xpath="//ul[@id='sidebar-list-icons']/div/li/a")
	List<WebElement> leftmenus;


	@FindBy(xpath="(//ul[@id='sidebar-list-icons']/div/li/a)[1]")
	WebElement cat_url;

	@FindBy(xpath="(//ul[@id='sidebar-list-icons']/div/li/a)[2]")
	WebElement subcat_url;

	@FindBy(xpath="(//ul[@id='sidebar-list-icons']/div/li/a)[3]")
	WebElement questionnaire_url;

	@FindBy(xpath="(//ul[@id='sidebar-list-icons']/div/li/a)[4]")
	WebElement exam_url;

	@FindBy(xpath="(//ul[@id='sidebar-list-icons']/div/li/a)[5]")
	WebElement assign_exam_url;

	@FindBy(xpath="(//ul[@id='sidebar-list-icons']/div/li/a)[6]")
	WebElement user_url;

	@FindBy(xpath="(//ul[@id='sidebar-list-icons']/div/li/a)[7]")
	WebElement result_url;

	By edit_success = By.xpath("//div[@role='alert']//div");






	public EditProfilePage enterEditDetails() throws InterruptedException {
		
		Thread.sleep(3000);
		profile_menu.click();
		myprofile.click();
		return new EditProfilePage(driver);
	}

	
	public CategoryPage catMenuRedirect() {
		cat_url.click();
		return new CategoryPage(driver);

	}


  public QuestionsPage questionMenuRedirect() {
	  questionnaire_url.click();
	  return new QuestionsPage(driver);

	} 
  
  public ResultsPage resultMenuRedirect() {
	  result_url.click();
	  return new ResultsPage(driver);

	} 

	public UserPage userMenuRedirect() {
		
		user_url.click();
		return new UserPage(driver);
		
	}










}
