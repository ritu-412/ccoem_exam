package run_browserstack;

import browserstactConfiguration.SetUp_BS_Config;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.io.File;
import java.io.FileInputStream;
import java.net.URL;
import java.time.Duration;
import java.util.HashMap;
import java.util.Properties;

public class New_Base_Config1 extends SetUp_BS_Config{

    public FileInputStream fis;
    public Properties properties;
    public static  WebDriver driver;


    public New_Base_Config1(){
        try{
            properties = new Properties();
            fis = new FileInputStream(new File("src/main/java/ccoem_admin1/resources/GlobalData.properties"));
            properties.load(fis);
        }  
        catch (Exception e){
            e.getMessage();
            e.printStackTrace();
        }
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

       // driver.quit();
    }
}
