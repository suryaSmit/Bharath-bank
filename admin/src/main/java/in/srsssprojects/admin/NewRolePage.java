package in.srsssprojects.admin;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class NewRolePage {

	
	WebDriver driver;

	public NewRolePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	//Role Name
	@FindBy(how = How.ID, using="txtRname")
	private WebElement RoleName;
	//Role Description
	@FindBy(how = How.ID, using="txtRDesc")
	private WebElement RoleDesc;
	//Role Type
	@FindBy(how = How.ID, using="lstRtypeN")
	private WebElement RoleType;
	
	//Fill Role Name
	public void fillRoleName(String RoleName) {
		this.RoleName.sendKeys(RoleName);
		
	}
	//Fill Role Description
	public void fillRoleDesc(String RoleDesc) {
		this.fillRoleDesc(RoleDesc);
		
	}
	//Select Role Type
	public void selectRoleType(String RoleType) {
		
		new Select(this.RoleType).selectByVisibleText(RoleType);
	}
	
	
	
	
}
