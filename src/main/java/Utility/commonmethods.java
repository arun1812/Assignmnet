package Utility;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import base.Testbase;

public class commonmethods extends Testbase{

	static ExtentReports extent;
	public static ExtentReports ExtentReport()
	{
		 String reportpath= System.getProperty("user.dir")+ "\\reports\\index.html";
		ExtentSparkReporter reporter= new ExtentSparkReporter(reportpath);
		reporter.config().setDocumentTitle("Ecart Test Result");
		reporter.config().setReportName("Ecart Web Application Results");
		
		extent = new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester", "Arun Dubey");
		return extent;
		
	}
	
	public String ScreenshotForFailureTest(String testCaseName) throws IOException
	{
		TakesScreenshot ts=(TakesScreenshot)driver;
		File source=ts.getScreenshotAs(OutputType.FILE);
		String destinationfilepath=System.getProperty("user.dir")+"\\reports\\FailureTestScreenShot\\"+testCaseName+".png";
		FileUtils.copyFile(source, new File(destinationfilepath));
		return destinationfilepath;
	}
}
