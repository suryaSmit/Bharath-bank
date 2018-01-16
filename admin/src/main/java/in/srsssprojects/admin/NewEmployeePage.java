package in.srsssprojects.admin;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class NewEmployeePage {
	
	
	WebDriver driver;
	
	public NewEmployeePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	//Employer Name
	@FindBy(how=How.ID, using="txtUname")
	private WebElement empName;
	
	
	//Login Password
	
	@FindBy(how=How.ID, using="txtLpwd")
	private WebElement pass;
	
	//Role
	@FindBy(how=How.ID, using="lst_Roles")
	private WebElement role;
	
	
	//Branch
	
	@FindBy(how=How.ID, using="lst_Branch")
	private WebElement branch;
	
	
	//Submit Button
	
	@FindBy(how=How.ID, using="BtnSubmit")
	private WebElement submit;
	
	
	//Reset Button
	
	@FindBy(how=How.ID, using="btnreset")
	private WebElement reset;
	
	//Cancel Button
	@FindBy(how=How.ID, using="btnCancel")
	private WebElement cancel;
	
	//Fill Employer Name
	
	public void fillEmpName(String name) {
		this.empName.sendKeys(name);
	}
	
	
	// Fill Login Password
	
	public void fillPassword(String pass) {
		this.pass.sendKeys(pass);
		
	}
	
	
	//Select Role      		new Select(this.RoleType).selectByVisibleText(RoleType);

	
	public void selectRole(String role) {
		new Select(this.role).selectByVisibleText(role);
	}
	
	// Select Branch
	
	public void selectBranch(String branch) {
		new Select(this.branch).selectByVisibleText(branch);
	}
	
	//Click on Submit Button
	public void clickSubmit() {
		this.submit.click();
	}
	
	
	//Click on Reset Button
	
	public void clickReset() {
		this.reset.click();
	}
	//Click on Cancel Button
	public void clickCancel() {
		this.cancel.click();
	}
	

}
