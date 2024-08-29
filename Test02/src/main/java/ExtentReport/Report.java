package ExtentReport;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Report 
{
	protected ExtentReports extentreport;
	ExtentSparkReporter sparkreporter;
	protected ExtentTest extenttest;
	
	
	public void startreport() throws ClassNotFoundException, IOException 
	{
		
		extentreport = new ExtentReports();
	sparkreporter = new ExtentSparkReporter("./Report/report.html");
	extentreport.attachReporter(sparkreporter);
	
	sparkreporter.config().setDocumentTitle("Simple Automation Report");
	sparkreporter.config().setReportName("Test Report");
	sparkreporter.config().setTheme(Theme.STANDARD);
	sparkreporter.config().setTimeStampFormat("EEEE, MMMM dd, yyyy, hh:mm a '('zzz')'");
	
//	ExtentTest test1 =  extent.createTest("Test 1");
//	test1.pass("This test is passed");
//	
//	ExtentTest test2 =  extent.createTest("Test 2");
//	test2.log(Status.FAIL, "This is failed");
//	
//	extent.createTest("Test 3").skip("This test is passed");
//	
//	extent.createTest("Test 4")
//	.log(Status.INFO,"info")
//	.log(Status.PASS, "Pass")
//	.log(Status.FAIL,"Fail")
//	.log(Status.WARNING,"Warening")
//	.log(Status.SKIP, "Skip"); 
//	
	

	
	
	extentreport.flush();
//	Desktop.getDesktop().browse(new File("Report/report.html").toURI());
	
	}
}