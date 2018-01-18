package in.srsssprojects.admin;

//import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class NewBranchPage {

	WebDriver driver;

	public NewBranchPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	// Branch name

	@FindBy(how = How.ID, using = "txtbName")
	private WebElement branchName;

	// Address1
	@FindBy(how = How.ID, using = "txtAdd1")
	private WebElement address1;

	// Address2
	@FindBy(how = How.ID, using = "Txtadd2")
	private WebElement address2;

	// Address3
	@FindBy(how = How.ID, using = "txtadd3")
	private WebElement address3;

	// Area txtArea
	@FindBy(how = How.ID, using = "txtArea")
	private WebElement area;

	// Zip txtZip
	@FindBy(how = How.ID, using = "txtZip")
	private WebElement zip;

	// Country lst_cityI
	@FindBy(how = How.ID, using = "lst_counrtyU")
	private WebElement country;

	// State lst_stateI
	@FindBy(how = How.ID, using = "lst_stateI")
	private WebElement state;

	// City lst_cityI
	@FindBy(how = How.ID, using = "lst_cityI")
	private WebElement city;

	// btn_insert Submit
	@FindBy(how = How.ID, using = "btn_insert")
	private WebElement submit;

	// Reset Btn_Reset
	@FindBy(how = How.ID, using = "Btn_Reset")
	private WebElement reset;

	// Cancel Btn_cancel
	@FindBy(how = How.ID, using = "Btn_cancel")
	private WebElement cancel;

	// select country
	public void selectCountry(String country) {
		new Select(this.country).selectByVisibleText(country);
	}

	//return country selected option
	public String getSelectedOptionValue() {
		return new Select(this.country).getFirstSelectedOption().getText();
	}
	// select state
	public void selectState(String state) {
		new Select(this.state).selectByVisibleText(state);
	}

	// select city
	public void selectCity(String city) {
		new Select(this.city).selectByVisibleText(city);

	}

	// fill branchname
	public void fillbranchName(String bname) {
		this.branchName.sendKeys(bname);
	}

	// address1
	public void filladdress1(String aname1) {
		this.address1.sendKeys(aname1);
	}

	// address2
	public void filladdress2(String aname2) {
		this.address2.sendKeys(aname2);
	}

	// address3
	public void filladdress3(String aname3) {
		this.address3.sendKeys(aname3);
	}
	// area

	public void fillarea(String area) {
		this.area.sendKeys(area);
	}

	public void fillzip(String zip) {
		this.zip.sendKeys(zip);

	}

	public void clickSubmit() {
		this.submit.click();
	}

	public void clickReset() {
		this.reset.click();

	}

	public void clickCancel() {
		this.cancel.click();
	}
}

/*
 * New Branch Button Click public void clickNewBranch(WebDriver driver) {
 * newBranch(driver).click(); }
 * 
 * // txtbName public WebElement branchName(WebDriver driver) { return
 * driver.findElement(By.id("txtbName")); }
 * 
 * 
 * public void fillbranchName(WebDriver driver) {
 * branchName(driver).sendKeys("Bharat");
 * 
 * } public WebElement address1(WebDriver driver) { return
 * driver.findElement(By.id("txtAdd1")); }
 * 
 * 
 * public void fillAddress1(WebDriver driver) {
 * address1(driver).sendKeys("Bharat"); } public WebElement address2(WebDriver
 * driver) { return driver.findElement(By.id("Txtadd2")); }
 * 
 * 
 * public void filladdress2(WebDriver driver) {
 * address2(driver).sendKeys("Bharat"); }
 * 
 * 
 * 
 * 
 * } }
 */