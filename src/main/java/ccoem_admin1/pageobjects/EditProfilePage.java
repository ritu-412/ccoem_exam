package ccoem_admin1.pageobjects;

import java.time.Duration;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import ccoem_admin1.Abstractmethods.AbstractMethods;

public class EditProfilePage extends AbstractMethods{


	WebDriver driver;
	public Properties properties;

	public EditProfilePage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath="//input[@name='fname']")
	WebElement edit_fname;

	@FindBy(xpath="//input[@name='lname']")
	WebElement edit_lname;


	@FindBy(xpath="//button[@type='submit']")
	WebElement edit_submitbtn;

	@FindBy(xpath="//div[@class='profile']")
	WebElement profile_menu;


	@FindBy(xpath="//ul[@class='list-unstyled']/li[1]")
	WebElement myprofile;

	@FindBy(xpath="//div[@role='alert']//div")
	WebElement profile_successmsg;

	@FindBy(xpath="//a/img[@alt='Logo']")
	WebElement logo_url;

	

	By edit_success = By.xpath("//div[@role='alert']//div");

	
	
	public void enterEditDetails(String fname, String lname) throws InterruptedException {
		
		Thread.sleep(3000);
		profile_menu.click();
		myprofile.click();
		edit_fname.sendKeys(Keys.CONTROL + "a");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].value = '';", edit_fname);
		edit_fname.sendKeys(fname);
		edit_lname.sendKeys(Keys.CONTROL + "a");
		JavascriptExecutor js1 = (JavascriptExecutor) driver;
		js1.executeScript("arguments[0].value = '';", edit_lname);
		edit_lname.sendKeys(lname);
	}

	public void clickSaveButton() {
		edit_submitbtn.click();
	}
	
	public void redirectToDashboard() {
		logo_url.click();
	}

	public String getSuccessMessage() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));
		// Use explicit wait to wait for the visibility of the element
		WebElement toastMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.Toastify__toast-body > div:last-child")));
		System.out.println("Toast message displayed: " + toastMessage.getText());
		return  toastMessage.getText();
	}




/********************************Registration Pageobjects @return ****************************************/	
	

	
	
	
	
	

	


}
