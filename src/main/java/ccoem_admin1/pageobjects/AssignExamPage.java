package ccoem_admin1.pageobjects;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import ccoem_admin1.Abstractmethods.AbstractMethods;

public class AssignExamPage extends AbstractMethods{


	WebDriver driver;

	public AssignExamPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(id="action-bar-btn1")
	WebElement add_assign_exam;

	@FindBy(xpath="//ul/li[text()='Assign to registered users']")
	WebElement assign_reguser;

	@FindBy(xpath="//ul/li[text()='Assign to unregistered users']")
	WebElement assign_unreguser;


	@FindBy(xpath="//select[@name='examName']")
	WebElement exam_dropdown;

	@FindBy(xpath="//input[@type='date' and @name='startTime']")
	WebElement starttime_picker;

	@FindBy(xpath="//input[@type='date' and @name='endTime']")
	WebElement endtime_picker;

	@FindBy(xpath="//div[@class='css-hlgwow']")
	WebElement select_user;



	@FindBy(xpath="//div[@class='css-1jqq78o-placeholder']")
	WebElement select_user_txt;


	//div[contains(@id,'-option-')]
	@FindBy(xpath="//div[contains(@id,'-option-')]")
	List <WebElement> user_options;

	@FindBy(xpath="//div[contains(@id,'-option-')][1]")
	WebElement user_option;

	@FindBy(css="#react-select-2-listbox")
	List <WebElement> user_results;



	@FindBy(xpath="//div[@class='css-19bb58m']")
	WebElement user_2ndoption;

	@FindBy(xpath="//button[@type='submit']")
	WebElement submit_btn;
	
	@FindBy(xpath="//form[@class='modalForm']")
	WebElement form;

    
	//div[div[text()='Jagriti Sethia']]/following-sibling::div//input[@id='statusSwitch']
	
	@FindBy(xpath="//div[div[text()='test demo']]/following-sibling::div//input[@id='statusSwitch']")
	WebElement status_btn;
	

	By edit_success = By.xpath("//div[@role='alert']//div");



	public void addassignUserExam() throws InterruptedException {

		add_assign_exam.click();
		assign_reguser.click();
		Thread.sleep(2000);
		Select el = new Select(exam_dropdown);
		el.selectByVisibleText("Exam on test Automation");
		String currentDate = new SimpleDateFormat("dd/MM/yyyy").format(new Date());
		
		//starttime_picker.click();
		starttime_picker.sendKeys(currentDate);
		//endtime_picker.click();
		endtime_picker.sendKeys(currentDate);
		Thread.sleep(4000);
		//selectUsersUsingActions(Arrays.asList("Jagriti Sethia", "demo1 test1"));
		selectUsersUsingActions(Arrays.asList("Admin Arka Chandra", "test25 demo25"));
		//select_user.click();
		/*Actions a = new Actions(driver);
		a.sendKeys(select_user_txt,"jagriti").build().perform();
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#react-select-2-listbox")));
	    user_option.click();
		 */
		//user_options.stream().filter(option -> Arrays.asList("Jagriti Sethia").contains(option.getText().trim())).forEach(WebElement::click);
		Thread.sleep(1000);
		submit_btn.click();


	}

	public void selectUsersUsingActions(List<String> namesToSelect) throws InterruptedException {
		Thread.sleep(1000);
	    select_user.click();

	    for (String name : namesToSelect) {
	        WebElement option = user_options.stream()
	                .filter(opt -> opt.getText().trim().equals(name)) // Find matching option
	                .findFirst()
	                .orElse(null);

	        if (option != null) {
	        	Thread.sleep(300);
	            // Scroll to the element to bring it into view
	            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", option);
	            Thread.sleep(500); // optional wait for scroll to settle

	            // Now click the element using JavaScript or Actions
	            // Option 1: JavaScript click (more reliable)
	            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", option);

	            // Option 2: Actions click (if needed)
	            // new Actions(driver).moveToElement(option).click().perform();

	            Thread.sleep(500); // optional wait after click
	            user_2ndoption.click(); // reopen dropdown for next selection
	        }
	    }

	    form.click();	
	}
	
	
	public String getSuccessMessage() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
		Boolean old_toastMessage = wait.until(ExpectedConditions.invisibilityOfElementLocated(
				By.cssSelector("div.Toastify__toast-body > div:last-child") 
				));
		if(old_toastMessage) {
			WebElement toastMessage1 = wait.until(ExpectedConditions.visibilityOfElementLocated(
					By.cssSelector("div.Toastify__toast-body > div:last-child") 
					));
			System.out.println("Toast message displayed: " + toastMessage1.getText());
			return toastMessage1.getText();
			}
		return "No toast message found";
	}
	
	/* public void changeStatus() {
		status_btn.click();
		
	} */












}
