package com.led.testcases;

import java.security.PublicKey;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.led.base.TestBase;

public class AddCustomerTest extends TestBase{


	@Test (dataProvider="getData")
	private static void addCustomer(String firstname, String lastname, String postcode) {
		Assert.assertTrue(clickElement(By.xpath(OR.getProperty("btnAddCustomer"))));
		
	}
  
	@DataProvider 
	public Object [] [] getData() { 
		return null;

	}
}
