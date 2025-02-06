package ccoem_admin1.Abstractmethods;

import java.time.Duration;
import java.util.List;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import ccoem_admin1.pageobjects.AssignExamPage;
import ccoem_admin1.pageobjects.CategoryPage;
import ccoem_admin1.pageobjects.DashboardPage;
import ccoem_admin1.pageobjects.ExamsPage;
import ccoem_admin1.pageobjects.LandingPage;
import ccoem_admin1.pageobjects.LoginPage;
import ccoem_admin1.pageobjects.QuestionsPage;
import ccoem_admin1.pageobjects.ResultsPage;
import ccoem_admin1.pageobjects.SubcategoryPage;
import ccoem_admin1.pageobjects.UserPage;


public class AbstractMethods {

	WebDriver driver;
	public LandingPage landingpage;
	public LoginPage lognpage;
	public DashboardPage dashboardpage;
	public CategoryPage categorypage;
	public SubcategoryPage subcategorypage;
	public QuestionsPage questionspage;
	public ExamsPage examspage;
	public AssignExamPage assignexampage;
	public UserPage userpage;
	public ResultsPage resultspage;

	public AbstractMethods(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);

	}
	
	@FindBy(xpath="(//button[@class='btn btn-custom'])[3]")
	WebElement cartheader;
	
	@FindBy(xpath="(//button[@class='btn btn-custom'])[2]")
	WebElement orderheader;
	
	
	@FindBy(xpath="//button[@id='proceed-button']")
	public WebElement send_anyway_btn ;

	public void waitvisibilityOfAllElementsLocatedBy(By ele) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(ele));

	}
	
	public void waitvisibilityOfAllElementLocatedBy(By ele) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
		wait.until(ExpectedConditions.visibilityOfElementLocated(ele));

	}
	
	public void waitementtobeclickable(WebDriver m_driver,WebElement ele) {
       
		WebDriverWait wait = new WebDriverWait(m_driver, Duration.ofSeconds(50));
		wait.until(ExpectedConditions.visibilityOf(ele));

	}


	public void waitinvisiblityofelement(WebElement ele ) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2000));
		wait.until(ExpectedConditions.invisibilityOf(ele));

	}
	
	public static String generateRandomEmail() {
        // Generate a random 5-digit numeric string
        String randomNumeric = RandomStringUtils.randomNumeric(5);
        // Combine it with a base email format
        String email = "test44" + randomNumeric + "@xyz.com";
        return email;
    }
	
	
	

	




}
