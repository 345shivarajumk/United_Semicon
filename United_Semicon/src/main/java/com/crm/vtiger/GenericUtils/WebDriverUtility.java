package com.crm.vtiger.GenericUtils;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.io.Files;


public class WebDriverUtility {

/*
 * this class contains webdriver specific generic methods

	/*
	 * this method wait for 20sec for pages loading
	 * @Parameter driver
	 */
	public void waitUtilPageLoad(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	/*
	 * this method wait for the element to be visible
	 * @param driver
	 * @param element 
	 */
	public void waitForElementVisibility(WebDriver driver, WebElement element) {
		WebDriverWait wait=new WebDriverWait(driver, 50);
		wait.until(ExpectedConditions.visibilityOf(element));		
	}
	/*
	 * this method is custom wait of peticular element
	 * @param webelement 
	 * @throws InterruptedException
	 */
	public void waitAndClick(WebElement element) throws InterruptedException {
		int count=0;
		while(count<40) {
			try {
				element.click();
				break;
			}
			catch(Exception e) {
				//Thread.sleep(5000);
				count++;
			}
		}
	}
	/*
	 * this method is for drop down select option by visible text
	 * @param element
	 * @param option
	 */
	public void selectOption(WebElement element, String option) {
		Select select=new Select(element);
		select.selectByVisibleText(option);
	}
	/*
	 * this method is for drop down select option by index
	 * @param element
	 * @param option
	 */
	public void selectOption(WebElement element, int index) {
		Select select=new Select(element);
		select.selectByIndex(index);
	}
	/*
	 * this method is for mouse over action
	 * @param driver
	 * @param webelement
	 */
	public void mouseOver(WebDriver driver,WebElement element) throws InterruptedException {
		Actions action=new Actions(driver);		
		action.moveToElement(element).perform();
	}
	/*
	 * this method is for right click action
	 * @param driver
	 * @param element
	 */
	public void rightClick(WebDriver driver,WebElement element) {
		Actions action=new Actions(driver);
		action.contextClick(element).perform();
	}
	/*
	 * this method is for right click action
	 * @param driver
	 * @param string
	 */
	public void switchToWindow(WebDriver driver,String partialWindowUrl) {
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> it = windows.iterator();
		while(it.hasNext()) {
			 String winId = it.next();
			 String title = driver.switchTo().window(winId).getCurrentUrl();
			 if(title.contains(partialWindowUrl)) {
				 break;
			 }
		}
	}
	/*
	 * Accept alert
	 * @param driver
	 */
	public void acceptAlert(WebDriver driver) {
		driver.switchTo().alert().accept();
	}
	/*
	 * Dismiss alert
	 * @param driver
	 */
	public void cancleAlert(WebDriver driver) {
		driver.switchTo().alert().dismiss();
	}
	/*
	 * method is for 
	 */
	
	public void scrollToWebElement(WebDriver driver,WebElement element) {
		JavascriptExecutor js=(JavascriptExecutor) driver;
		int y = element.getLocation().getY();
		js.executeScript("window.scrollBy(0,"+y+")", element);
	}
	public void switchFrame(WebDriver driver, int index) {
		driver.switchTo().frame(index);
	}
	public void switchFrame(WebDriver driver, WebElement element) {
		driver.switchTo().frame(element);
	}
	public void switchFrame(WebDriver driver, String idOrName) {
		driver.switchTo().frame(idOrName);
	}
	
	public void takeScreenShot(WebDriver driver, String screenShotName) throws IOException {
		TakesScreenshot ts=(TakesScreenshot) driver;
		File src=ts.getScreenshotAs(OutputType.FILE);
		File dest=new File("./screenshot/"+screenShotName+".PNG");
		Files.copy(src, dest);
		
	}
	public void pressEnterKey(KeyEvent key) throws AWTException {
		Robot rc=new Robot();
		rc.keyPress(KeyEvent.VK_ENTER);
		rc.keyRelease(KeyEvent.VK_ENTER);
	}
	
}
