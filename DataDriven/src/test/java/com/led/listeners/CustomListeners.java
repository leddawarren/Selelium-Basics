package com.led.listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;


public class CustomListeners implements ITestListener {

	public void onTestFailure(ITestResult result) {  
		// TODO Auto-generated method stub  
//		System.out.println("Failure of test cases and its details are : "+result.getName());
		Reporter.log("Failed: TC Name - " + result.getName());
	}  

	public void onTestSkipped(ITestResult result) {  
		// TODO Auto-generated method stub  
//		System.out.println("Skip of test cases and its details are : "+result.getName());
		Reporter.log("Skipped: TC Name - " + result.getName());
	}  
	
	public void onTestSuccess(ITestResult result) {  
		// TODO Auto-generated method stub  
//		System.out.println("Success of test cases and its details are : "+result.getName());
		Reporter.log("Passed: TC Name - " + result.getName());
		}  

	/*
	 * public void onStart(ITestContext context) { // TODO Auto-generated method
	 * stub } public void onFinish(ITestContext context) { // TODO Auto-generated
	 * method stub }
	 */

}
