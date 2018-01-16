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
	
	//NewRole Button
	@FindBy(how=How.ID, using="btnRoles")
	private WebElement newRole;
		
	//Click on New Role
	public void clickNewRole() {
		this.newRole.click();
		
	}
}
