package ccoem_admin1.pageobjects;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import ccoem_admin1.Abstractmethods.AbstractMethods;

public class LoginPage extends AbstractMethods{


	WebDriver driver;
	public Properties properties;

	public LoginPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath="//input[@name='email']")
	WebElement email;


	@FindBy(xpath="//input[@name='password']")
	WebElement pass;

	@FindBy(xpath="//button[@type='submit' and contains(@class, 'educate-btn')]")
	WebElement submitbtn;
	
	@FindBy(css="[class*='flyInOut']")
	WebElement loginerrormsg;
	
	@FindBy(xpath="//div[@class='account-cart-wrapper']/a[@data-target-element='#header-account']")
	WebElement account_menu;
	
	@FindBy(xpath="//div[@id='header-account']/div/ul/li/a[@title='My Account']")
	WebElement account_submenu;
	
	
	public DashboardPage login(String uemail, String password) throws InterruptedException {
		
	
		email.sendKeys(uemail);
		pass.sendKeys(password);
		submitbtn.click();
		return new DashboardPage(driver);
		

	}
	
	
	
	
	public String getErrorMsg() {
		
		String errormsg = loginerrormsg.getText();
		return errormsg;
		
	}
/********************************Registration Pageobjects @return ****************************************/	
	

	
	
	
	
	

	


}
