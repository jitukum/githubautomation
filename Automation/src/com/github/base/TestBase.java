/**
 * This class contains features which will be used in every other test class
 * @author Jitendra Kumar
 * @date 09/08/2017
 */
package com.github.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestBase {
	
	public static WebDriver driver = null;
	
	/**
	 * Gets the path of the chrome driver
	 * @return String path
	 */
	private String getChromeDriverPath(){
		return System.getProperty("user.dir") + "/src/com/github/resources/drivers/chromedriver.exe";
	}
	
	/**
	 * gets the path of the firefox driver
	 * @return String path
	 */
	private String getFirefoxPath(){
		return System.getProperty("user.dir") + "/src/com/github/resources/drivers/geckodriver_x64.exe";
	}
	
	/**
	 * Constructor of the Base class
	 * @param browserType
	 * @return driver
	 */
	public WebDriver getDriver(String browserType){
		this.openBrowser(browserType);
		return driver;
	}
	
	/**
	 * This method opens the browser based on the browser type
	 * @param browserType
	 */
	private void openBrowser(String browserType){
		if(browserType.equalsIgnoreCase("chrome")){
			System.setProperty("webdriver.chrome.driver", getChromeDriverPath());
			driver = new ChromeDriver();
		}
		else if(browserType.equalsIgnoreCase("firefox")){
			System.setProperty("webdriver.gecko.driver", getFirefoxPath());
			driver = new FirefoxDriver();
		}
		else{
			/**
			 * Codes for Other browser
			 */
		}
	}
}
