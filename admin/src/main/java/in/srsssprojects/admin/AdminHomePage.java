package in.srsssprojects.admin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AdminHomePage {
	WebDriver driver;

	public AdminHomePage(WebDriver driver) {
		this.driver = driver;
	}

	// home button
	public WebElement homeButton() {
		return driver.findElement(By.xpath("//a[@href='adminflow.aspx']"));
	}

	// change password button
	public WebElement changePasswordButton() {
		return driver.findElement(By.xpath("//a[@href='change_password1234.aspx']"));
	}

	// logout button
	public WebElement logoutButton() {
		return driver.findElement(By.xpath("//a[@href='home.aspx']"));
	}

	// branches
	public WebElement branches() {
		return driver.findElement(By.xpath("//a[@href='admin_banker_master.aspx']"));
	}

	// employees
	public WebElement employees() {
		return driver.findElement(By.xpath("//a[@href='Admin_Emp_details.aspx']"));
	}

	// roles
	public WebElement roles() {
		return driver.findElement(By.xpath("//a[@href='Admin_Roles_details.aspx']"));
	}

	// users
	public WebElement users() {
		return driver.findElement(By.xpath("//a[@href='userdetails.aspx']"));
	}

	public void clickHomeButton() {
		homeButton().click();
	}

	public void clickChangePasswordButton() {
		changePasswordButton().click();
	}

	public void clickLogoutButton() {
		logoutButton().click();
	}

	public void clickbranchesButton() {
		branches().click();
	}

	public void clickUsersButton() {
		users().click();
	}

	public void clickRolesButton() {
		roles().click();
	}

	public void clickEmployeeButton() {
		employees().click();
	}
}
