package ccoem_admin1.testcomponents;

import browserstactConfiguration.SetUp_BS_Config;
import ccoem_admin1.models.User;
import ccoem_admin1.pageobjects.AssignExamPage;
import ccoem_admin1.pageobjects.CategoryPage;
import ccoem_admin1.pageobjects.DashboardPage;
import ccoem_admin1.pageobjects.EditProfilePage;
import ccoem_admin1.pageobjects.ExamsPage;
import ccoem_admin1.pageobjects.LandingPage;
import ccoem_admin1.pageobjects.LoginPage;
import ccoem_admin1.pageobjects.QuestionsPage;
import ccoem_admin1.pageobjects.ResultsPage;
import ccoem_admin1.pageobjects.SubcategoryPage;
import ccoem_admin1.pageobjects.UserPage;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

public class BaseTest extends SetUp_BS_Config{

    public FileInputStream fis;
    public static Properties properties;
    public static WebDriver driver;
	public LandingPage landingpage;
	public LoginPage lognpage;
	public DashboardPage dashboardpage;
	public EditProfilePage editprofilepage;
	public CategoryPage categorypage;
	public SubcategoryPage subcategorypage;
	public QuestionsPage questionspage;
	public ExamsPage examspage;
	public AssignExamPage assignexampage;
	public UserPage userpage;
	public ResultsPage resultspage;
	
	
	
    public BaseTest(){
        try{
        	// System.out.println("BaseTest constructor called");
            properties = new Properties();
            fis = new FileInputStream(new File("src/main/java/ccoem_admin1/resources/GlobalData.properties"));
            properties.load(fis);
            //System.out.println("Properties loaded successfully");
        }  
        catch (Exception e){
            e.getMessage();
            e.printStackTrace();
        }
    }
    
 /*************************Utilities*******************************************************/   
    public String getScreenshot(String testCaseName,WebDriver driver) throws IOException
	{
		TakesScreenshot ts = (TakesScreenshot)driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File file = new File(System.getProperty("user.dir") + "//reports//" + testCaseName + ".png");
		FileUtils.copyFile(source, file);
		return System.getProperty("user.dir") + "//reports//" + testCaseName + ".png";
		
		
	}
    
 
 
    /*************************Utilities*******************************************************/   
    
    
    @BeforeTest
    public void setUp() throws InterruptedException{
    	//System.out.println("Driver instance at start of setUp(): " + driver);
        String platformName = properties.getProperty("platform_name");
        System.out.println("Platform: " + platformName);
        String browserName = properties.getProperty("browser");
        
        switch (platformName.toLowerCase()) {
            case "browserstack":
                switch (browserName.toLowerCase()) {
                    case "chrome":
                        run_Bs_Config();
                        
                        driver = BaseTest.driver;
                        if (driver == null) {  // ✅ Ensure driver is initialized
                            throw new RuntimeException("BrowserStack driver is still null after initialization.");
                        }
                        Thread.sleep(3000);
                       // System.out.println("Properties object: " + properties);
                      //  System.out.println("URL from properties: " + properties.getProperty("url"));
                        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
                        driver.manage().window().maximize();
                        driver.get(properties.getProperty("url"));
                        break;
                    default:
                        throw new RuntimeException("BrowserStack configuration not properly done, Please configure first...");
                }
                break;
                
            case "local":
                switch (browserName.toLowerCase()) {
                    case "chrome":
                        driver = new ChromeDriver();
                        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
                        driver.manage().window().maximize();
                        driver.get(properties.getProperty("url"));
                        break;
                    default:
                        throw new RuntimeException("Local configuration not properly done, Please configure first...");
                }
                break;
                
            default:
                throw new RuntimeException("Driver not invoked for local or BrowserStack.");
        }
    }

   /* public void setUp(){
        String platformName = properties.getProperty("platform_name");
        System.out.println(platformName);
        String browserName = properties.getProperty("browser");
       switch (platformName.toLowerCase()){
           case "browserstack":
               switch (browserName.toLowerCase()) {
                   case "chrome":
                       run_Bs_Config();
                       driver.get(properties.getProperty("https://lab.stagingit.net/oem_admin"));
                       break;
                   default:
                       throw new RuntimeException("Browserstack Configure not properly done, Please configure first...");
               }
               break;
           case "local":
               switch (browserName.toLowerCase()){
                   case "chrome":
                       driver = new ChromeDriver();
                       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
                       driver.manage().window().maximize();
                       driver.get(properties.getProperty("url"));
                       break;
                   default:
                       throw new RuntimeException("Local Configure not properly done, Please configure first...");
               }
               break;
           default:
               throw new RuntimeException("driver not invoke for local or browserstack");
       }
    } */
  

    @AfterTest
    public void closeBrowser(){

      // driver.quit();
    }
}
