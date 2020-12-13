package Listener;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;


	
public class MyTestListener implements ITestListener {
	
	public void onTestFailure(ITestResult result) {
		System.out.println("Test Failed : "+result.getName());
		System.out.println(result.getName());
		//System.out.println(result.getTestContext().getAttribute(name));
		System.out.println(result.getStatus());
		System.out.println(result.getThrowable().getMessage());
	}
	
	public void onTestSuccess(ITestResult result) {
		System.out.println("Test Passed : "+result.getName());
	}

	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		
	}
}
	
	