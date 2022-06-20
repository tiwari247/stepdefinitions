package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features="src/test/java/features",
		glue="stepdefinitions",
		tags="@Customer",
		plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}
		)
public class TestRunner extends AbstractTestNGCucumberTests {

}
