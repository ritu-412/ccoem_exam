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

public class SubcategoryPage extends AbstractMethods{


	WebDriver driver;

	public SubcategoryPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath="//div[@id='action-bar-btn3']")
	WebElement add_subcatbtn;

	@FindBy(id="categories2")
	WebElement cat_dropdown;
	
	@FindBy(id="subcategoriesField")
	WebElement subcat_name;

	@FindBy(xpath="//button[@type='submit']")
	WebElement submitbtn;

	@FindBy(xpath="(//button[contains(@class,'btn-edit-in-table')])[2]")
	WebElement edit_subcatbtn;

	@FindBy(xpath="//div[@id='title']")
	WebElement edit_subcattitle;


	@FindBy(xpath="//ul[@class='list-unstyled']/li[1]")
	WebElement myprofile;

	@FindBy(xpath="//div[@role='alert']//div")
	WebElement profile_successmsg;

	//ul[@class='list-unstyled']/li[1]

	By edit_success = By.xpath("//div[@role='alert']//div");



	public void clickAddsubcatbtn() throws InterruptedException {
		Thread.sleep(1000);
		add_subcatbtn.click();
	
	}
	
	public String addSubcat(String subcategory) throws InterruptedException {

		Select dropdown = new Select(cat_dropdown);
		dropdown.selectByVisibleText("Automation Testing");
		
		subcat_name.sendKeys(subcategory);
		submitbtn.click();
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
	
	
	public String getEditsubcatTitle() throws InterruptedException {
		Thread.sleep(1000);
		edit_subcatbtn.click();
		String edit_title = edit_subcattitle.getText();
		return edit_title;

	}



}
