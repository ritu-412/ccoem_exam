package ccoem_admin1.pageobjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import ccoem_admin1.Abstractmethods.AbstractMethods;

public class UserPage extends AbstractMethods{

	WebDriver driver;

	public UserPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}



	@FindBy(xpath="//div[@id='action-bar-btn']")
	WebElement add_user;

	@FindBy(xpath="//input[@name='first_name']")
	WebElement user_fname;

	@FindBy(xpath="//input[@name='last_name']")
	WebElement user_lname;

	@FindBy(xpath="//input[@name='email_id']")
	WebElement user_email;


	@FindBy(xpath="//input[@name='phone_number']")
	WebElement user_phno;

	@FindBy(xpath="//input[@name='password']")
	WebElement user_pass;


	@FindBy(xpath="//select[@name='user_role']")
	WebElement user_role;


	@FindBy(xpath="//button[@type='submit']")
	WebElement user_submitbtn;


	@FindBy(xpath="//div[@role='alert']//div")
	WebElement profile_successmsg;


	By edit_success = By.xpath("//div[@role='alert']//div");



	public void VerifyUserAdd(String fname,String lname,String email, String ph,String pass,String role) throws InterruptedException {
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

	    // Refresh page to ensure fresh state
	    System.out.println("Refreshing page before adding user...");
	    driver.navigate().refresh();
	    Thread.sleep(3000);  

	    // Click Add User button
	    System.out.println("Clicking Add User button...");
	    wait.until(ExpectedConditions.elementToBeClickable(add_user)).click();

	    // Fill user details
	    System.out.println("Entering user details...");
	    wait.until(ExpectedConditions.visibilityOf(user_fname)).sendKeys(fname);
	    wait.until(ExpectedConditions.visibilityOf(user_lname)).sendKeys(lname);
	    wait.until(ExpectedConditions.visibilityOf(user_email)).sendKeys(email);
	    wait.until(ExpectedConditions.visibilityOf(user_phno)).sendKeys(ph);
	    wait.until(ExpectedConditions.visibilityOf(user_pass)).sendKeys(pass);

	    // Select role
	    System.out.println("Selecting role...");
	    Select srole = new Select(wait.until(ExpectedConditions.elementToBeClickable(user_role)));
	    srole.selectByValue(role);

	    // Click Submit
	    System.out.println("Submitting user...");
	    wait.until(ExpectedConditions.elementToBeClickable(user_submitbtn)).click();


	}


	public String getSuccessMessage() throws InterruptedException {



		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));

		// Use explicit wait to wait for the visibility of the element
		WebElement toastMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.cssSelector("div.Toastify__toast-body > div:last-child") 
				));


		System.out.println("Toast message displayed: " + toastMessage.getText());
		return  toastMessage.getText();
	}












}
