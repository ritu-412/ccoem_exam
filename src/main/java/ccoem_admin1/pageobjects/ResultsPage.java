package ccoem_admin1.pageobjects;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import ccoem_admin1.Abstractmethods.AbstractMethods;

public class ResultsPage extends AbstractMethods{


	WebDriver driver;

	public ResultsPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	//div[@role='row']//div[@role='cell'][1]/div[@data-tag='allowRowEvents']

	@FindBy(xpath="	//div[@role='row']//div[@role='cell'][1]/div[@data-tag='allowRowEvents']")
	List <WebElement> resultName_Cells;

	@FindBy(xpath="//button[@class='get-result-btn']")
	List <WebElement> resultView_btn;


	@FindBy(xpath="(//div[contains(@class,'rdt_TableBody')])[2]//div[contains(@id,'row-0')]//div[@id='cell-5-undefined']//span")
	WebElement viewbtn;

	@FindBy(xpath="//div[@class='modal-body']/h2")
	WebElement resultUser_name;


	@FindBy(xpath="//div[@class='modal-body']//p")
	List <WebElement> resultUser_details;
	
	@FindBy(xpath="//div[@class='modal-close-button z-1']")
	WebElement close_modal;

	


	public void clickResultList(String examName) {

		for (int i = 0;i< resultName_Cells.size();i++) {

			if(resultName_Cells.get(i).getText().trim().equalsIgnoreCase(examName)) {
				resultView_btn.get(i).click();
				System.out.println("Clicked button for: " + examName);
				break;
			}

		}

	}
	
	
	public String viewResultDetails() throws InterruptedException {
        Thread.sleep(1000);
		viewbtn.click();
		Thread.sleep(2000);
		String username = resultUser_name.getText();
		StringBuilder logDetails = new StringBuilder();
		logDetails.append("User Name: ").append(username).append("\n");
		System.out.println(username);
		 String resultDetails = resultUser_details.stream()
                 .map(WebElement::getText)
                 .distinct() // Remove duplicates
                 .collect(Collectors.joining("\n"));

		    // Print details to console
		    System.out.println("Result Details: \n" + resultDetails);

		    // Return the captured details so it can be logged in Extent Reports
		    return "Username: " + username + "\n" + resultDetails;
	}
	
	public void closemodal() {
		
		close_modal.click();
		
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
