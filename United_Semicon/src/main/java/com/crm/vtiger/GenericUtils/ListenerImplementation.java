package com.crm.vtiger.GenericUtils;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListenerImplementation implements ITestListener{
	
	public void onTestFailure(ITestResult result) {  
		 String methodName = result.getMethod().getMethodName();
		 String currentDate = new Date().toString().replace(":", "_").replace(" ", "_");
		 EventFiringWebDriver efwd=new EventFiringWebDriver(BaseClass.sdriver);
		 File source = efwd.getScreenshotAs(OutputType.FILE);
		 File dest = new File("./screenshot/"+methodName+currentDate+".png");
		 try {
			FileUtils.copyFile(source, dest);
		} catch (IOException e) {			
			e.printStackTrace();
		}
	} 
}
