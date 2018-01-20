package utility;

import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.Parameters;

import com.relevantcodes.extentreports.LogStatus;

public class TestListener extends Listener implements ITestListener, ISuiteListener{

	@Override
	public void onTestStart(ITestResult result) {
		startTest(result.getName());
		Object[] paramters = result.getParameters();
		String para="";
		for(int i =0; i< paramters.length; i++) {
			para +=" "+paramters[i].toString();
		}
//		System.out.println(para);
		test.log(LogStatus.INFO, para);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		test.log(LogStatus.PASS, result.getName()+" passed");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		test.log(LogStatus.FAIL, result.getName()+" failed");
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		test.log(LogStatus.SKIP, result.getName()+" skipped");
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
		startReport(".//reports/report.html");
	}

	@Override
	public void onFinish(ISuite suite) {
		report.flush();
	}

}
