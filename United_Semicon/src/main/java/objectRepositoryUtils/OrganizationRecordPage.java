package objectRepositoryUtils;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationRecordPage {
	
	WebDriver driver;
	
	@FindBy(xpath ="//img[@alt='Create Organization...']")
	private WebElement crtOrgBtn;
	
	public OrganizationRecordPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}


	public WebElement getCrtOrgBtn() {
		return crtOrgBtn;
	}
	
	public CreateNewOrganizationPage getCrtOrg() {
		crtOrgBtn.click();
		return new CreateNewOrganizationPage(driver);
	}
	
}
