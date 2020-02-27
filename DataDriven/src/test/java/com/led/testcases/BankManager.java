package com.led.testcases;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.led.base.TestBase;

public class BankManager extends TestBase{
	@BeforeClass
	private void BeforeClass() {
		log.info("BankManager Before Class");
	}
	
	@AfterClass
	private void AfterClass() {
		log.info("BankManager After Class");
//		ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
//	    driver.switchTo().window(tabs2.get(1));
//	    driver.close();
//	    driver.switchTo().window(tabs2.get(0));
//		SwtichToParentWindow();
	}
		
	@Test
	public void LogInAsBankManager() {

		Assert.assertTrue(clickElement(By.xpath(OR.getProperty("imgBanking"))));
		
		String winHandleBefore = getAndSwitchToWindow();
		
		Assert.assertTrue(clickElement(By.xpath(OR.getProperty("btnMngrLogin"))));
//		Assert.assertTrue(clickElement(By.xpath(OR.getProperty("btnAddCustomer"))));
		
	}



}
