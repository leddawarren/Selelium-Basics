package com.led.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.GeckoDriverInfo;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.led.utilities.ExcelReader;

public class TestBase {

	public static WebDriver driver;
	public static Properties config = new Properties();
	public static Properties OR = new Properties();
	public static FileInputStream fis;
	public static Logger log = Logger.getLogger("TEST");
	public static String ExcelDataPath = System.getProperty("user.dir") + "\\src\\test\\Resources\\excel\\TestData.xlsx"; 
	public static String SheetName;
	public static ExcelReader excel = new ExcelReader(ExcelDataPath);
	

	@BeforeSuite
	public void SetUp() {
		log.info("@BeforeSuite");
		log.info("SetUp: Execution Started.=====================================================================================");
		if (driver == null) {
			//			Properties config = new Properties();
			//			Properties OR = new Properties();
			try {
				fis = new FileInputStream(System.getProperty("user.dir") + "\\src\\test\\Resources\\Properties\\config.properties");
			} catch (FileNotFoundException e) {
				log.error("Config.properties not found");
				e.printStackTrace();
			}
			try {
				config.load(fis);
			} catch (IOException e) {
				e.printStackTrace();
			}

			try {
				fis = new FileInputStream(System.getProperty("user.dir") + "\\src\\test\\Resources\\Properties\\OR.properties");
			} catch (FileNotFoundException e) {
				log.error("OR.properties not found");
				e.printStackTrace();
			}
			try {
				OR.load(fis);
			} catch (IOException e) {
				e.printStackTrace();
			}

			if (config.getProperty("browser").equals("chrome")) {
				log.info("Executed in Chrome");
				System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\src\\test\\resources\\executables\\chromedriver.exe");
				driver = new ChromeDriver();

			} else if (config.getProperty("browser").equals("firefox")) {
				log.info("Executed in Firefox");
				//				System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "\\src\\test\\resources\\executables\\geckodriver.exe");
				driver = new FirefoxDriver();
			} else if (config.getProperty("browser").equals("ie")) {
				log.info("Executed in IE");
				System.setProperty("webdriver.ie.driver", System.getProperty("user.dir") + "\\src\\test\\resources\\executables\\IEDriverServer.exe");
				driver = new InternetExplorerDriver();

			}	

			driver.get(config.getProperty("url"));
			log.info("Navigated to " + config.getProperty("url"));
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Integer.parseInt(config.getProperty("implcitWait")),TimeUnit.SECONDS);
		}
	}

	@AfterSuite
	public void TearDown() {
		log.info("AfterSuite");
		if (driver!=null) {
//			driver.quit(); 
			log.info("TearDown: Execution Completed.=====================================================================================");
			
		}
		javax.swing.JOptionPane.showMessageDialog(null,"Test Completed.");
	}
	
	public void SwtichToParentWindow() {
		
		ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
//	    driver.switchTo().window(tabs.get(1));
//	    driver.close();
//	    driver.switchTo().window(tabs.get(0));
	 log.info("Tabs size: " + tabs.size());
      for (int counter = tabs.size()-1; counter > 0; counter--) { 		      
          System.out.println(tabs.get(counter));
          log.info("Current Tab: " + counter);
          driver.switchTo().window(tabs.get(counter));
          driver.close();
          driver.switchTo().window(tabs.get(counter-1));
          log.info("Switch to Tab: " + (counter-1));
      }  
	}

	public String getAndSwitchToWindow() {
		String winBefore = driver.getWindowHandle();

		for(String winHandle : driver.getWindowHandles()){
			driver.switchTo().window(winHandle);
		}
		return winBefore;
	}

	public void switchToWindow(String windowID) {
		driver.switchTo().window(windowID);
	}
	
	public  void switchToNewWindow(WebDriver driver)
	{
	    String mainWindow = driver.getWindowHandle();
	    Set<String> openedWindows = driver.getWindowHandles();
	    if(openedWindows.size() > 1)
	    {
	        for(String newWindow : openedWindows)
	        {
	            driver.switchTo().window(newWindow);
	        }
	        driver.close();
	        log.info("Closing the current Opened Window - Invoice");
	        driver.switchTo().window(mainWindow);
	    }
	}


	public static boolean clickElement(By by) {

		if (isElementPresent(by)) {
			driver.findElement(by).click();
			log.info("Object was clicked: \"" + by + "\"");
			return true;
		} else {
			log.info("Object was not clicked: \"" + by + "\"");
			return false;
		}

	}

	public static boolean isElementPresent (By by) {

		try {

			driver.findElement(by);
			log.info("Element exists: \"" + by + "\"");
			return true;

		} catch (NoSuchElementException e) {
			log.warn("Element does not exists: \"" + by + "\"");
			return false;
		}


	}


}
