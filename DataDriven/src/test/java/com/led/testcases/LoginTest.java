package com.led.testcases;

import java.util.Properties;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.led.base.TestBase;

public class LoginTest extends TestBase {
	
	@BeforeClass
	private void BeforeClass1() {
		log.info("LoginTest Before Class");
//		getAndSwitchToWindow();
		
	}
	@AfterClass
	private void AfterClass1() {
		log.info("LoginTest After Class");
//		driver.close();
	}
	
	@Test(enabled = false)
	public void Test1() throws InterruptedException {
		int intA = 1;
		System.out.println("Test1");
		// driver.findElement(By.xpath(OR.getProperty("menuResources"))).click();

		// String winHandleBefore = driver.getWindowHandle();
		//
		// driver.findElement(By.xpath(OR.getProperty("menuResources"))).click();
		// Thread.sleep(1000);
		// driver.findElement(By.xpath(OR.getProperty("liPractice2"))).click();
		// driver.findElement(By.xpath(OR.getProperty("imgBanking"))).click();
		//
		// for(String winHandle : driver.getWindowHandles()){
		// driver.switchTo().window(winHandle);
		// }
		//
		// driver.findElement(By.xpath(OR.getProperty("btnCustomerLogin"))).click();
		//
		// WebElement userDropDown =
		// driver.findElement(By.xpath(OR.getProperty("userSelect")));
		// Select dropdown = new Select(userDropDown);
		// dropdown.selectByVisibleText("Harry Potter");
		//
		// driver.findElement(By.xpath(OR.getProperty("btnLogin1"))).click();
		// driver.findElement(By.xpath(OR.getProperty("btnTransactions"))).click();
		// driver.findElement(By.xpath(OR.getProperty("linkDateTime"))).click();

		// driver.findElement(By.xpath(OR.getProperty("btnMebmerLogin"))).click();
		// Thread.sleep(5000);
		//// System.out.println("Test Completed");
		//

		//
		// driver.findElement(By.xpath(OR.getProperty("inputUserName"))).sendKeys(config.getProperty("userName"));
		// driver.findElement(By.xpath(OR.getProperty("inputPassord"))).sendKeys(config.getProperty("password"));
		// driver.findElement(By.xpath(OR.getProperty("btnLogin"))).click();

	}

	@Test(enabled = false)

	public void Banking() throws InterruptedException {

		Assert.assertFalse(isElementPresent(By.xpath(OR.getProperty("btnMebmerLogin"))));
		Assert.assertTrue(clickElement(By.xpath(OR.getProperty("imgBanking"))));
		
//		driver.findElement(By.xpath(OR.getProperty("imgBanking"))).click();
		String winHandleBefore = getAndSwitchToWindow();
		
		Assert.assertTrue(isElementPresent(By.xpath(OR.getProperty("btnCustomerLogin"))));
		driver.findElement(By.xpath(OR.getProperty("btnCustomerLogin"))).click();
		
		switchToWindow(winHandleBefore);
		
		Assert.assertTrue(isElementPresent(By.xpath(OR.getProperty("imgWebTables"))));
		driver.findElement(By.xpath(OR.getProperty("imgWebTables"))).click();
		getAndSwitchToWindow();
		driver.findElement(By.xpath(OR.getProperty("btnAddUser"))).click();
		
		driver.findElement(By.xpath(OR.getProperty("inpFirstName"))).sendKeys("Warren Ledda");
		
		Select drpDown = new Select(driver.findElement(By.xpath(OR.getProperty("selRole"))));
		
		drpDown.selectByVisibleText("Customer");
		driver.findElement(By.xpath(OR.getProperty("btnSave"))).click();
		log.info("Test");
		
			
	}

	@Test(enabled = false)

	public void WebTables() throws InterruptedException {

		Assert.assertTrue(clickElement(By.xpath(OR.getProperty("imgWebTables"))));
		
		
//		LoginTest aCall = new LoginTest();
//		//
//		// aCall.Test1();
//		// NavigationsloginAsMember
//		// driver.findElement(By.xpath(OR.getProperty("menuResources"))).click();
//		// driver.findElement(By.xpath(OR.getProperty("liPractice2"))).click();
//		driver.findElement(By.xpath(OR.getProperty("imgWebTables"))).click();
		
		

	}
}
