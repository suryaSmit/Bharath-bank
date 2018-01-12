package in.srsssprojects.admin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BankHomePage {

	// username
	public WebElement username(WebDriver driver) {
		return driver.findElement(By.id("txtuId"));
	}

	// password
	public WebElement passord(WebDriver driver) {
		return driver.findElement(By.id("txtPword"));
	}

	// login button
	public WebElement loginButton(WebDriver driver) {
		return driver.findElement(By.id("login"));
	}

	// fill user name
	public void fillUserName(WebDriver driver, String uname) {
		username(driver).sendKeys(uname);
	}

	// fill password
	public void fillPassword(WebDriver driver, String password) {
		passord(driver).sendKeys(password);
	}

	// click on login button
	public void clickLoginButton(WebDriver driver) {
		loginButton(driver).click();
	}

}
