package browserstactConfiguration;

import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import java.net.URL;
import java.util.HashMap;
import ccoem_admin1.testcomponents.BaseTest;

public class SetUp_BS_Config {

    public MutableCapabilities capabilities;
    public HashMap<String, Object> bstackOptions;
    private String bs_userName = "tofiqueraza_qduR2f";
    private String bs_assessKey = "s6kJK5qXVVXMZsi1qJ4p";
    URL url;

    public void run_Bs_Config() {
        capabilities = new MutableCapabilities();
        bstackOptions = new HashMap<>();
        capabilities.setCapability("browserName", "Chrome");
        bstackOptions.put("os", "Windows");
        bstackOptions.put("osVersion", "10");
        bstackOptions.put("browserVersion", "latest");
        bstackOptions.put("buildName", "CCOEM New build");
        bstackOptions.put("consoleLogs", "info");
        capabilities.setCapability("bstack:options", bstackOptions);

        try {
            url = new URL("https://" + bs_userName + ":" + bs_assessKey + "@hub-cloud.browserstack.com/wd/hub/");
            BaseTest.driver = new RemoteWebDriver(url, capabilities);  // ✅ Assign driver to BaseTest
            System.out.println("BrowserStack driver initialized successfully.");
            System.out.println("After assigning driver: " + BaseTest.driver);
        } catch (Exception e) {
            throw new RuntimeException("Error initializing BrowserStack WebDriver: " + e.getMessage());
        }
    }
}


/*public class SetUp_BS_Config {

    public MutableCapabilities capabilities;
    public HashMap<String, Object> bstackOptions;
    private String bs_userName = "tofiqueraza_qduR2f";
    private String bs_assessKey = "s6kJK5qXVVXMZsi1qJ4p";
    URL url;

    public void run_Bs_Config(){

        capabilities = new MutableCapabilities();
        bstackOptions = new HashMap<String, Object>();
        capabilities.setCapability("browserName", "Chrome");
        bstackOptions.put("os", "Windows");
        bstackOptions.put("osVersion", "10");
        bstackOptions.put("browserVersion", "latest");
        bstackOptions.put("buildName", "CCOEM New build");
        //bstackOptions.put("userName", "ashishkumar_O2jzEm");
        //bstackOptions.put("accessKey", "X3XwWwzAqZpH65KywGAb");
        bstackOptions.put("consoleLogs", "info");
        capabilities.setCapability("bstack:options", bstackOptions);
        try {
            url = new URL("https://" + bs_userName + ":" + bs_assessKey + "@hub-cloud.browserstack.com/wd/hub/");
            BaseTest.driver = new RemoteWebDriver(url,capabilities);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }
} */
