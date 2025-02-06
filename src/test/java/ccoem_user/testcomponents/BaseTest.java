package ccoem_user.testcomponents;

import browserstactConfiguration.SetUp_BS_Config;
import ccoem_user.pageobjects.DashboardPage;
import ccoem_user.pageobjects.EditProfilePage;
import ccoem_user.pageobjects.ExamsPage;
import ccoem_user.pageobjects.LandingPage;
import ccoem_user.pageobjects.LoginPage;
import ccoem_user.pageobjects.TestPage;


import org.apache.commons.io.FileUtils;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.time.Duration;
import java.util.HashMap;
import java.util.Properties;

public class BaseTest extends SetUp_BS_Config{

    public FileInputStream fis;
    public static Properties properties;
    public static  WebDriver driver;
	public LandingPage landingpage;
	public LoginPage lognpage;
	public DashboardPage dashboardpage;
	public EditProfilePage editprofilepage;
	public TestPage testpage;
	public ExamsPage examspage;

	
	
	
    public BaseTest(){
        try{
            properties = new Properties();
            fis = new FileInputStream(new File("src/main/java/ccoem_user/resources/GlobalData.properties"));
            properties.load(fis);
        }  
        catch (Exception e){
            e.getMessage();
            e.printStackTrace();
        }
    }
    
    
    public String getScreenshot(String testCaseName,WebDriver driver) throws IOException
	{
		TakesScreenshot ts = (TakesScreenshot)driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File file = new File(System.getProperty("user.dir") + "//reports//" + testCaseName + ".png");
		FileUtils.copyFile(source, file);
		return System.getProperty("user.dir") + "//reports//" + testCaseName + ".png";
		
		
	}

    @BeforeTest
    public void setUp(){
        String platformName = properties.getProperty("platform_name");
        System.out.println(platformName);
        String browserName = properties.getProperty("browser");
       switch (platformName.toLowerCase()){
           case "browserstack":
               switch (browserName.toLowerCase()) {
                   case "chrome":
                       run_Bs_Config();
                       driver.get(properties.getProperty("url"));
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
    }
  

    @AfterTest
    public void closeBrowser(){

        //driver.quit();
    }
}
