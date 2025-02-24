package cucumber;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
//cucumber->  TestNG, junit

@CucumberOptions(features="src/test/java/cucumber",glue="ccoem_admin1.stepDefinitions",
monochrome=true, plugin= { "pretty", "html:target/cucumber_categoryTest.html"})



public class TestNGTestRunner extends AbstractTestNGCucumberTests{

	
}
