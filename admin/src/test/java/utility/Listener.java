package utility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverEventListener;
import org.testng.Reporter;

public class Listener implements WebDriverEventListener{

	@Override
	public void beforeAlertAccept(WebDriver driver) {
		Reporter.log("alert came: "+driver.switchTo().alert().getText());
	}

	@Override
	public void afterAlertAccept(WebDriver driver) {
		Reporter.log("alert accepted");
	}

	@Override
	public void afterAlertDismiss(WebDriver driver) {
		Reporter.log("alert dissmissed");
	}

	@Override
	public void beforeAlertDismiss(WebDriver driver) {
		Reporter.log("alert came: "+driver.switchTo().alert().getText());
	}

	@Override
	public void beforeNavigateTo(String url, WebDriver driver) {
		
	}

	@Override
	public void afterNavigateTo(String url, WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void beforeNavigateBack(WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void afterNavigateBack(WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void beforeNavigateForward(WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void afterNavigateForward(WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void beforeNavigateRefresh(WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void afterNavigateRefresh(WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void beforeFindBy(By by, WebElement element, WebDriver driver) {
		Reporter.log("locating element using "+by);
	}

	@Override
	public void afterFindBy(By by, WebElement element, WebDriver driver) {
		Reporter.log("element located");
	}

	@Override
	public void beforeClickOn(WebElement element, WebDriver driver) {
		Reporter.log("clicking on element");
	}

	@Override
	public void afterClickOn(WebElement element, WebDriver driver) {
		Reporter.log("elemnt clicked");
	}

	@Override
	public void beforeChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {
		Reporter.log("changing element value "+keysToSend.toString());
	}

	@Override
	public void afterChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {
		Reporter.log("element value changed to "+keysToSend.toString());
	}

	@Override
	public void beforeScript(String script, WebDriver driver) {
		
	}

	@Override
	public void afterScript(String script, WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onException(Throwable throwable, WebDriver driver) {
		Reporter.log(throwable.getMessage());
		
	}

}
