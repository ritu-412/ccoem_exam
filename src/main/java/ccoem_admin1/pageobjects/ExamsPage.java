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
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import ccoem_admin1.Abstractmethods.AbstractMethods;

public class ExamsPage extends AbstractMethods{


	WebDriver driver;

	public ExamsPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(id="action-bar-btn")
	WebElement add_exambtn;

	@FindBy(xpath="//input[@name='examtitle']")
	WebElement examtitle;
	
	@FindBy(xpath="//select[@name='categories']")
	WebElement cat_dropdown;

	@FindBy(xpath="//div[@class='css-hlgwow']")
	WebElement subcatfld;
	
	@FindBy(xpath="//div[contains(@id,'-option-')]")
	List <WebElement> subcats;
	
	
	
	@FindBy(xpath="//input[contains(@id,'react-select-')]")
	WebElement multislect_subcat;
	

	@FindBy(xpath="//select[@name='complexity']")
	WebElement complexity_dropdown;


	@FindBy(xpath="//input[@name='questioncount']")
	WebElement question_count;
	
	
	@FindBy(xpath="(//ul[@id='sidebar-list-icons']/div/li/a)[5]")
	WebElement assign_exam_url;

	//ul[@class='list-unstyled']/li[1]
	
	@FindBy(xpath="//input[@name='examduration']")
	WebElement exam_duration;
	
	@FindBy(xpath="//button[@type='submit']")
	WebElement submit_qs;
	
	
	
	@FindBy(xpath="//div[@id='close-modal']")
	WebElement close_popup;
	
	
	
	@FindBy(xpath="//div[div[text()='Exam on test Automation']]/following-sibling::div//input[@id='statusSwitch']")
	WebElement status_btn;
	
	
	
	//@FindBy(xpath="//span[contains(@class,'sc-dEkLRj hrIAxQ')]")
	//WebElement row_count;
	
	
	@FindBy(xpath="//div[contains(@class,'rdt_TableBody')]/div[contains(@class,'rdt_TableRow')]")
    List<WebElement> row_count;
	
	//button[@id='pagination-next-page']
	
	@FindBy(xpath="//button[@id='pagination-next-page']")
	WebElement paginate_nxtpg;
	
	

	By edit_success = By.xpath("//div[@role='alert']//div");



	public String examAdd() throws InterruptedException {
		Thread.sleep(1000);
		String desiredsubcat = "Selenium";
		String desiredsubcat1 = "PlayWright";
		add_exambtn.click();	
		examtitle.sendKeys("Exam on test Automation");
		Select catd = new Select(cat_dropdown);
		catd.selectByVisibleText("Automation Testing");
		Thread.sleep(2000);
		subcatfld.click();
		Thread.sleep(1000);
		subcats.stream().filter(option -> option.getText().equals(desiredsubcat)).findFirst().ifPresent(WebElement::click);
		Thread.sleep(1000);
		multislect_subcat.click();
		subcats.stream().filter(option -> option.getText().equals(desiredsubcat1)).findFirst().ifPresent(WebElement::click);
		Select compd = new Select(complexity_dropdown);
		compd.selectByValue("easy");
		question_count.sendKeys("2");
		exam_duration.sendKeys("60");
		submit_qs.click();
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
		close_popup.click();
		return "No toast message found";
		
		
		
	}
	
	public void changeStatus() throws InterruptedException {
		
		//String rowsc = row_count.getText();	
		//String totalRecordstr = rowsc.split(" ")[2];
		//int totalRecords = Integer.parseInt(totalRecordstr);
		
		int totalRecords = row_count.size();
	    System.out.println(totalRecords);
	    if(totalRecords>10) {
	    	paginate_nxtpg.click();	
	    }
	    status_btn.click();
		
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
	
	
	
	public AssignExamPage assignuserMenuRedirect() {
		assign_exam_url.click();
		return new AssignExamPage(driver);

	}


	
	












}
