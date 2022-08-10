package com.novaproduction.hellonerd.selenium;

import org.openqa.selenium.WebDriver;
import com.novaproduction.hellonerd.selenium.drivers.MyChromeDriver;
import com.novaproduction.hellonerd.selenium.drivers.MyEdgeDriver;
import com.novaproduction.hellonerd.selenium.drivers.MyFirefoxDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * there are 3 browsertypes:
 * <li>BROWSER_CHROME</li>
 * <li>BROWSER_FIREFOX</li>
 * <li>BROWSER_EDGE</li>
 * 
 * The default browsertype is BROWSER_CHROME.
 *
 */
public class DetectingDriver {
	
	private static final String BROWSER_CHROME = "BROWSER_CHROME";
	private static final String BROWSER_FIREFOX = "BROWSER_FIREFOX";
	private static final String BROWSER_EDGE = "BROWSER_EDGE";
	private static String browserType;
	
	public static WebDriver getDriver() throws Exception {
		WebDriver wDriver = null;
    	WebDriver _driver = null;
		if(browserType == null || browserType==BROWSER_CHROME) {
			/* BROWSER_CHROME */
			WebDriverManager.chromedriver().setup();
			wDriver = MyChromeDriver.getConfiguredDriver(_driver);
			
		} else if(browserType==BROWSER_FIREFOX) {
			/* BROWSER_FIREFOX */
			WebDriverManager.firefoxdriver().setup();
			wDriver = MyFirefoxDriver.getConfiguredDriver(_driver);
			
		} else if(browserType==BROWSER_EDGE) {
			/* BROWSER_EDGE */
			WebDriverManager.edgedriver().setup();
			wDriver = MyEdgeDriver.getConfiguredDriver(_driver);
			
		} else {
			// log not known browser.
			return null;
		}
		return wDriver;
    }
}
