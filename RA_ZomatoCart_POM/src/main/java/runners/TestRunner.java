package runners;

import org.junit.runner.RunWith;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/test/resources/features", 
		glue = "steps",
		plugin = {"pretty", "html:target/cucumber-reports"})
public class TestRunner {
	@BeforeClass
    public void beforeClass() {
        // Initialize the Extent report or any setup steps before tests
        System.out.println("Initializing Test Execution...");
        utils.ExtentReportManager.init(); // Initialize Extent report
    }

    @AfterClass
    public void afterClass() {
        // End the Extent report after all tests have completed
        System.out.println("Test Execution Completed.");
        utils.ExtentReportManager.endTest();  // Generate the Extent report
    }

    @Test
    public void runCucumberTests() {
        // This method is not strictly necessary, but it can be used to define custom TestNG test execution
        System.out.println("Running Cucumber Tests...");
    }
}

