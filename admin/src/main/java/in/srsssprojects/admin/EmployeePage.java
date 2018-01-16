package in.srsssprojects.admin;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class EmployeePage {
	WebDriver driver;
	
	public EmployeePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	//new employee button
	@FindBy(how=How.ID, using="BtnNew")
	private WebElement newEmployee;
	
	//click new employee button
	public void clickNewEmployee() {
		this.newEmployee.click();
	}
}
