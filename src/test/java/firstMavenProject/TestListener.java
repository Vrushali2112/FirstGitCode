package firstMavenProject;

import java.io.File;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class TestListener implements ITestListener{  // implements is a interface and ITestListener is listen all the test cases.
	
	ExtentReports reports;
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		test=reports.startTest(result.getMethod().getMethodName());
		
	}
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		
		System.out.println("*******************Test Case is passed***************************");
		test.log(LogStatus.PASS, "Test case is success");
		reports.endTest(test);
	}
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("************************Test Case is failed************************");
		test.log(LogStatus.FAIL, result.getThrowable());
		reports.endTest(test);
	}
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}
	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		
	}
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
		reports = new ExtentReports("C:\\Users\\q\\eclipse-workspace\\com.Insta\\reports"+"\\ExtentReportResults.html");
		reports.loadConfig(new File("C:\\Users\\q\\eclipse-workspace\\com.Insta\\config -report.xml"));
	}
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		reports.flush();
		
		
	}
	ExtentTest test;

}
