package com.crm.vtiger.Test;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.crm.vtiger.GenericUtils.BaseClass;

import objectRepositoryUtils.CreateNewOrganizationPage;
import objectRepositoryUtils.HomePage;

public class CreateOrganization extends BaseClass {

	@Test(groups="smoke_test")
	public void createOrganizationWithAssignedToInMarkatingGroup() throws Throwable {	
				
		HomePage hp = new HomePage(driver);
hp.getOrg().getCrtOrg().getOrgNameTF().sendKeys("TestYantra"+ju.getRandomData());	
hp.getOrg().getCrtOrg().getmemberof().click();
hp.switchToWindow(driver, "specific_account");
driver.findElement(By.xpath("//tr[@class='lvtColDataHover']//td[1]")).click();
CreateNewOrganizationPage cn = new CreateNewOrganizationPage(driver);
cn.clickOnSaveBTN();
	}
}
