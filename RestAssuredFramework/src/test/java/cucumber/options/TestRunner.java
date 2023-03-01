package cucumber.options;

import org.junit.runner.RunWith;

import io.cucumber.junit.*;
@RunWith(Cucumber.class)
@CucumberOptions(features = "D:\\User\\vchavare\\eclipse-workspace\\RestAssuredFramework\\src\\test\\java\\Features\\placeValidations.feature",
                  plugin = "json: target/jsonReports/cucumber-report.json",glue = {"StepDefinitions"})

public class TestRunner {
	
	
	
	

}
