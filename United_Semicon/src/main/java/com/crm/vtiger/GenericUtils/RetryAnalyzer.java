package com.crm.vtiger.GenericUtils;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzer implements IRetryAnalyzer{
	int count=0;
	int reTryCount=4;
	public boolean retry(ITestResult result) {
		if (count<reTryCount) {
			count++;
			return true;
		}
		return false;
	}

}
