package ccoem_user.pageobjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import ccoem_user.Abstractmethods.AbstractMethods;

public class TestPage extends AbstractMethods{


	WebDriver driver;

	public TestPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}


	@FindBy(xpath="(//div/button[contains(@class,'educate-btn')])[1]")
	WebElement take_testbtn;

	@FindBy(xpath="//input[@type='checkbox']")
	WebElement agree_checkbox;


	@FindBy(xpath="//button[@type='submit' and contains(text(),'Start test')]")
	WebElement start_test;

	@FindBy(xpath="//button[@type='submit' and contains(@class,'educate-btn')]")
	WebElement final_start_test;

	@FindBy(xpath="//h5")
	WebElement questionheader;

	@FindBy(xpath="//p[@class='question-text']")
	WebElement ques_txt;

	@FindBy(xpath="//span[@class='mx-3' and text()='No']")
	WebElement ans1_txt;

	@FindBy(xpath="//span[@class='mx-3' and text()='driver.manage.window.maximize()']")
	WebElement ans2_txt;


	@FindBy(xpath="//button[@class=' btn savebtn']")
	WebElement saveAndNextButton;

	@FindBy(xpath="//button[@type='button' and @class='  btn subtn ']")
	WebElement submit_btn;

	@FindBy(xpath="//div/button[@class='modal-button ok-button']")
	WebElement ok_btn;



	@FindBy(xpath="//div/button[@class='modal-button cancel-button']")
	WebElement cancel_btn;



	public void startQuiz() throws InterruptedException {
		Thread.sleep(1000);
		take_testbtn.click();
		//System.out.println("Clicked 'Take Test'");

		agree_checkbox.click();
		//System.out.println("Checked 'Agree Checkbox'");

		start_test.click();
		//System.out.println("Clicked 'Start Test'");

		final_start_test.click();
		//System.out.println("Clicked 'Final Start Test'");
	}


	public String getQuestionText() throws InterruptedException {
		Thread.sleep(1000);
		return ques_txt.getText().trim();
	}

	// Method to check and select the correct answer based on the question
	public boolean answerQuestion() throws InterruptedException {
		String question = getQuestionText();

		if (question.contains("Does Playwright require a Webdriver dependency?")) {
			ans1_txt.click();
			//System.out.println("Answered: Does Playwright require a Webdriver dependency?");
			return true; // Answer was selected
		} else if (question.contains("How to maximize an window")) {
			ans2_txt.click();
			//System.out.println("Answered: How to maximize a window");
			return true; // Answer was selected
		}
		return false; // No answer was selected
	}

	// Method to submit the first question
	public void saveAndNext() throws InterruptedException {
		Thread.sleep(2000);
        if (answerQuestion()) { // Ensure an answer was selected before proceeding
            if (saveAndNextButton.isDisplayed()) {
                saveAndNextButton.click();
               // System.out.println("Clicked 'Save and Next'");
            }
        } else {
            System.out.println("No answer selected, skipping 'Save and Next'");
        }
    }
	// Method to submit the second question
	 public void submit() throws InterruptedException {
		 Thread.sleep(2000);
	        if (answerQuestion()) { // Ensure an answer was selected before proceeding
	            if (submit_btn.isDisplayed()) {
	                submit_btn.click();
	               // System.out.println("Clicked 'Submit'");
	                ok_btn.click();
	            }
	        } else {
	            System.out.println("No answer selected, skipping 'Submit'");
	        }
	        
	        
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
