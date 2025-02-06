package ccoem_admin1.pageobjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import ccoem_admin1.Abstractmethods.AbstractMethods;

public class QuestionsPage extends AbstractMethods{


	WebDriver driver;

	public QuestionsPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(id="action-bar-btn2")
	WebElement add_questionbtn;

	@FindBy(xpath="//button[@type='submit' and contains(text(),'Add Manually')]")
	WebElement manual_form;
	
	@FindBy(xpath="(//ul[@id='sidebar-list-icons']/div/li/a)[4]")
	WebElement exam_url;

	
	@FindBy(id="categories")
	WebElement cat_dropdown;
	
	@FindBy(id="subCategories")
	WebElement subcat_dropdown;
	
	@FindBy(id="questionField")
	WebElement qstntxt;
	
	@FindBy(id="answerA")
	WebElement txtans_a;
	
	@FindBy(id="answerB")
	WebElement txtans_b;
	
	@FindBy(id="answerC")
	WebElement txtans_c;
	
	@FindBy(id="answerD")
	WebElement txtans_d;
	
	@FindBy(id="optionA")
	WebElement optn_a;
	
	@FindBy(id="optionB")
	WebElement optn_b;
	
	@FindBy(id="optionC")
	WebElement optn_c;
	
	@FindBy(id="optionD")
	WebElement optn_d;
	
	@FindBy(id="difficultylevel")
	WebElement difficulty_level;
	
	//div[@id='close-modal']
	
	@FindBy(xpath="//div[@id='close-modal']")
	WebElement close_modal;
	
	

	@FindBy(xpath="//button[@type='submit' and contains(text(),'Submit')]")
	WebElement qstn_submitbtn;


	public void clickAddquesBtn() throws InterruptedException {
		int i = 1;
		while(i<3) {
		add_questionbtn.click();
		Thread.sleep(1000);
		manual_form.click();
		Select cd = new Select(cat_dropdown);
		cd.selectByVisibleText("Automation Testing");
		Thread.sleep(2000);
		if(i==1) {
		Select sd = new Select(subcat_dropdown);
		sd.selectByVisibleText("Selenium");
		qstntxt.sendKeys("How to maximize an window");
		txtans_a.sendKeys("driver.manage.window.max()");
		txtans_b.sendKeys("driver.manage.max.window()");
		txtans_c.sendKeys("driver.manage.maximum.window()");
		txtans_d.sendKeys("driver.manage.window.maximize()");
		optn_d.click();
		Select dl = new Select(difficulty_level);
		dl.selectByValue("easy");
		qstn_submitbtn.click();
		}
		if(i==2) {
			Select sd = new Select(subcat_dropdown);
			sd.selectByVisibleText("PlayWright");
			qstntxt.sendKeys("Does Playwright require a Webdriver dependency?");
			txtans_a.sendKeys("Yes");
			txtans_b.sendKeys("No");
			txtans_c.sendKeys("May be");
			txtans_d.sendKeys("Depends on requirements");
			optn_b.click();
			Select dl = new Select(difficulty_level);
			dl.selectByValue("easy");
			qstn_submitbtn.click();
			}
		
		close_modal.click();
		i++;
		}
		
	}

	public ExamsPage examMenuRedirect() {
		exam_url.click();
		return new ExamsPage(driver);

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
