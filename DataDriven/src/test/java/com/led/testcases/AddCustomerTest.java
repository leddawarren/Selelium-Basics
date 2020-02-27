package com.led.testcases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.led.base.TestBase;
import com.led.utilities.TestUtil;

public class AddCustomerTest extends TestBase{

	@BeforeClass
	private void BeforeClass2() {
		log.info("AddCustomerTest Before Class");
	}
	
	@AfterClass
	private void AfterClass2() {
		log.info("AddCustomerTest After Class");
		driver.quit();
	}
	@Test (dataProviderClass=TestUtil.class,dataProvider="dp",invocationCount = 2)
	private static void addCustomer(String firstname, String lastname, String postcode) {
		Assert.assertTrue(clickElement(By.xpath(OR.getProperty("btnAddCustomer"))));
		log.info(firstname);
		log.info(lastname);
		log.info(postcode);
		
	}
  
}
