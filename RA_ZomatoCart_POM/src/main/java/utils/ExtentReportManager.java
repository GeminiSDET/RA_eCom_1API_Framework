package utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportManager {

	private static ExtentReports extent;
    private static ExtentTest test;

    public static void init() {
       
        String reportPath = System.getProperty("user.dir") + "/target/extent-report.html";
        
        ExtentSparkReporter sparkReporter = new ExtentSparkReporter(reportPath);

        sparkReporter.config().setReportName("Zomato Offer API Test Report");
        sparkReporter.config().setDocumentTitle("Zomato API Test Results");

        extent = new ExtentReports();
        extent.attachReporter(sparkReporter);
    }

    public static ExtentTest startTest(String testName) 
    {
        test = extent.createTest(testName);
        return test;
    }

    public static void endTest() 
    {
        extent.flush();
    }
}
