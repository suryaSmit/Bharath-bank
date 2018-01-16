package in.srsssprojects.admin;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class RolePage {
	
	
	WebDriver driver;

	public RolePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	//Home Button
	
	@FindBy(how=How.XPATH, using="//a[contains(@href,'adminflow.aspx')]")
	private WebElement home;
	
	//Change Password
	@FindBy(how=How.XPATH, using="//a[contains(@href,'change_password1234.aspx')]")
	private WebElement chpass;
	//Logout Button
	@FindBy(how=How.XPATH, using="//a[contains(@href,'home.aspx')]")
	private WebElement logout;
	
	//NewRole Button
	@FindBy(how=How.ID, using="btnRoles")
	private WebElement newRole;
	
	
	//Branches Button
	@FindBy(how=How.XPATH, using="//a[contains(@href,'admin_banker_master.aspx')]")
	private WebElement branches;
	
	
	//Roles Button
	@FindBy(how=How.XPATH, using="//a[conatains(@href,'Admin_Roles_details.aspx)]")
	private WebElement roles;
	
	
	//Users Button
	@FindBy(how=How.XPATH, using="//a[contains(@href,'userdetails.aspx')]")
	private WebElement users;
	
	
	
	//Employee Button
	@FindBy(how=How.XPATH, using="//a[contains(@href,'Admin_Emp_details.aspx')]")
	private WebElement emp;
	
	//Click Home Button
	public void clickHomeButton() {
		this.home.click();
	}
	
	//Click on Change Password Button
	public void clickChangePassword() {
		this.chpass.click();
		
	}
	
	//Click on Logout
	public void clickLogout() {
		this.logout.click();
		
	}
	
	//Click on New Role
	public void clickNewRole() {
		this.newRole.click();
		
	}
	
	//Click on Branches
	public void clickBranches() {
		this.branches.click();
		
	}
	
	//Click on Roles
	public void clickRoles() {
		this.roles.click();
		
	}
	
	//Click on Users
	
	public void clickUsers() {
		this.users.click();
		
	}
	//Click on Employee
	public void clickEmployee() {
		this.emp.click();
		
	}
}
