package in.srsssprojects.admin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;

public class BankHomePage {

	// username
	public WebElement username(WebDriver driver) {
//		Reporter.log("locating element ");
		return driver.findElement(By.id("txtuId"));
		
	}

	// password
	public WebElement passord(WebDriver driver) {
//		Reporter.log("locating element");
		return driver.findElement(By.id("txtPword"));
	}

	// login button
	public WebElement loginButton(WebDriver driver) {
//		Reporter.log("locating element");
		return driver.findElement(By.id("login"));
	}

	// fill user name
	public void fillUserName(WebDriver driver, String uname) {
//		Reporter.log("element located");
//		Reporter.log("sending"+uname);
		username(driver).sendKeys(uname);
//		Reporter.log("value sent");
		
	}

	// fill password
	public void fillPassword(WebDriver driver, String password) {
//		Reporter.log("element located");
//		Reporter.log("sending"+password);
		passord(driver).sendKeys(password);
//		Reporter.log("value sent");
	}

	// click on login button
	public void clickLoginButton(WebDriver driver) {
//		Reporter.log("element located");
//		Reporter.log("cliking on element");
		loginButton(driver).click();
//		Reporter.log("element clicked");
	}

}
