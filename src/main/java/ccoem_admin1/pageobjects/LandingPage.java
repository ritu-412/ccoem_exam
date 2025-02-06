package ccoem_admin1.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import ccoem_admin1.Abstractmethods.AbstractMethods;

public class LandingPage extends AbstractMethods{


	WebDriver driver;
	public LoginPage lognpage ;
	

	public LandingPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath="//div[@class='main-menu__block']//div[@class=' main-menu__right ']")
	WebElement adminloginbtn;

	
	public boolean admnLoginbtnisdisplayed() throws InterruptedException {
	    Thread.sleep(2000);
	    //adminloginbtn.click();
		return adminloginbtn.isDisplayed();
	}
	
	
	public LoginPage clickToLogin() {
		adminloginbtn.click();
		return new LoginPage(driver);
		
	}
	
	

	
	
	
	
	

	


}
