package ccoem_admin1.pageobjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import ccoem_admin1.Abstractmethods.AbstractMethods;

public class CategoryPage extends AbstractMethods{


	WebDriver driver;

	public CategoryPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(id="action-bar-btn1")
	WebElement add_cat;

	@FindBy(xpath="//input[@name='catName']")
	WebElement catname;


	@FindBy(xpath="//input[@name='catDescription']")
	WebElement catdescription;

	@FindBy(xpath="//button[@type='submit']")
	WebElement submit_btn;


	@FindBy(xpath="//ul[@class='list-unstyled']/li[1]")
	WebElement myprofile;

	@FindBy(xpath="//div[@role='alert']//div")
	WebElement profile_successmsg;


	@FindBy(xpath="//div[div[text()='Automation Testing']]/following-sibling::div//button[contains(@class,'btn-edit-in-table')]")
	WebElement edit_btn;

	@FindBy(xpath="//div[@id='title']")
	WebElement edit_cattitle;


	@FindBy(xpath="//input[@name='catName']")
	WebElement edt_catname;

	@FindBy(xpath="//input[@name='catDescription']")
	WebElement edt_catdesc;

	@FindBy(xpath="//button[@type='submit']")
	WebElement edit_submitbtn;


	@FindBy(css = "div#row-0 div[data-column-id='1']")
	WebElement firstRowCategory;
	
	@FindBy(xpath="(//ul[@id='sidebar-list-icons']/div/li/a)[2]")
	WebElement subcat_url;


	By edit_success = By.xpath("//div[@role='alert']//div");




	public void clickAddcatButton() throws InterruptedException {
		Thread.sleep(2000);
		add_cat.click();
	}


	public String addCategory() throws InterruptedException {

		catname.sendKeys("Automation Testing");
		catdescription.sendKeys("test test test description");
		submit_btn.click();
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


	public String getEditcatTitle() throws InterruptedException {
		Thread.sleep(1000);
		edit_btn.click();
		String edit_title = edit_cattitle.getText();
		return edit_title;

	}

	public void clickEditCat(String catdesc) throws InterruptedException {
		Thread.sleep(1000);
		
		edt_catdesc.sendKeys(Keys.CONTROL + "a");
		edt_catdesc.sendKeys(Keys.BACK_SPACE);
		edt_catdesc.sendKeys(catdesc);
		edit_submitbtn.click();

	}

	public String checkFirstRow() throws InterruptedException {
		String firstrow = firstRowCategory.getText();
		return firstrow;

	}
	
	public SubcategoryPage subcatMenuRedirect() {
		subcat_url.click();
		return new SubcategoryPage(driver);

	}














}
