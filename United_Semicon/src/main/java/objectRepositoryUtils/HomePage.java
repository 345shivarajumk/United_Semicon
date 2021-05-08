package objectRepositoryUtils;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.vtiger.GenericUtils.WebDriverUtility;


public class HomePage extends WebDriverUtility {
	
	WebDriver driver;
	
	@FindBy(linkText ="Organizations")
	private WebElement orgbtn;
	
	@FindBy(xpath ="(//td[contains(@onmouseover,'fnDropDownUser(this,')])[1]")
	private WebElement imgIcon;	
	
	@FindBy(linkText ="Sign Out")
	private WebElement logoutLink;

	public HomePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	public WebElement getOrgbtn() {
		return orgbtn;
	}
	
	public WebElement getImgIcon() {
		return imgIcon;
	}
	
	public void logout() throws Throwable {	
		Thread.sleep(5000);		
		mouseOver(driver, imgIcon);			
		logoutLink.click();
	}	
	
	public OrganizationRecordPage getOrg() {
		orgbtn.click();
		return new OrganizationRecordPage(driver);
	}
}
