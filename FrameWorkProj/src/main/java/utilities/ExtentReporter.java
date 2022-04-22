package utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporter {
	static ExtentReports extentReport;
	public static ExtentReports getExtentReport() {
		String extentReportPath=System.getProperty("user.dir")+"\\reports\\extentReport.html";
		
		ExtentSparkReporter reporter= new ExtentSparkReporter(extentReportPath);
		reporter.config().setReportName("FrameWorkTest");
		reporter.config().setDocumentTitle("TestResults");
		
		extentReport = new ExtentReports();
		extentReport.attachReporter(reporter);
		extentReport.setSystemInfo("operating System", "Windows10");
		extentReport.setSystemInfo("Tested By", "Phani");
		
		return extentReport;
	}
}
