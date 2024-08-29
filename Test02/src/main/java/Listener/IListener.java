package Listener;

import org.testng.IAnnotationTransformer;
import org.testng.IRetryAnalyzer;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import utils.Basic;

public class IListener extends Basic implements ITestListener , IAnnotationTransformer,IRetryAnalyzer
{
	public void onStart(ITestContext context) {

		System.out.println("onStart method started: "+context.getName());

		}

		public void onFinish(ITestContext context) {

		System.out.println("onFinish method started: "+ context.getName());

		}

		public void onTestStart(ITestResult result) {

		Reporter.log( "New Test Started: " +result.getName());

		}

		public void onTestSuccess(ITestResult result) {

		System.out.println("onTestSuccess Method " +result.getName());

		}

		public void onTestFailure(ITestResult result) {

		System.out.println("Test is failed");
		
		try
		{
			screenshot(result.getName());
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		

		}

		public void onTestSkipped(ITestResult result) {

		System.out.println("onTestSkipped Method" +result.getName());

		}

		public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

		System.out.println("onTestFailedButWithinSuccessPercentage" +result.getName());

		}
		
		

		@Override
		public boolean retry(ITestResult result) {
			int falsenum = 0;
			int limit = 4;
			
			if(falsenum<limit)
			{
				falsenum++;
				return true;
			}
			
			
			return false;
		}

}
