package run_browserstack;

import browserstactConfiguration.SetUp_BS_Config;
import ccoem_admin1.testcomponents.BaseTest;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class Demo_Title_Test extends BaseTest{



    @Test
    public  void getPageTitle(){
        System.out.println("Page Title : " + driver.getTitle());
    }
    
    
    @Test
    public  void testdemo(){
        System.out.println("test demo");
    }
}
