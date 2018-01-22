package utility;

import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.imageio.ImageIO;

import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.Parameters;

import com.relevantcodes.extentreports.LogStatus;

import in.srsssprojects.admin.TestExecution;

public class TestListener extends Listener implements ITestListener, ISuiteListener {

	public String getSystemTime() {
		Date d = new Date();
		DateFormat df = new SimpleDateFormat("HH_mm_ss dd_MMM_yy");
		return df.format(d);
	}
	
	@Override
	public void onTestStart(ITestResult result) {
		startTest(result.getName());
		Object[] paramters = result.getParameters();
		String para = "";
		for (int i = 0; i < paramters.length; i++) {
			para += " " + paramters[i].toString();
		}
		// System.out.println(para);
		test.log(LogStatus.INFO, para);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		test.log(LogStatus.PASS, result.getName() + " passed");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		String filename = ".//screenshots/"+result.getName()+getSystemTime()+".png";
		try {
			Robot r = new Robot();
			BufferedImage bi = r.createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
			ImageIO.write(bi, "png", new File(filename));
			File f = new File(filename);
			test.log(LogStatus.INFO, test.addScreenCapture(f.getAbsolutePath()));
			
			
		} catch (Exception e) {

		}
		test.log(LogStatus.FAIL, filename+ result.getName() + " failed");
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		test.log(LogStatus.SKIP, result.getName() + " skipped");
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onStart(ISuite suite) {
		// enter file path as .//reports\\report.html -- windows
		startReport(".//reports/report.html");
	}

	@Override
	public void onFinish(ISuite suite) {
		report.flush();
	}

}
