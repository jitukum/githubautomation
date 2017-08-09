/**
 * This test is used to verify 
 * 1. User cannot login if invalid credentails are provided
 * 2. User can login if correct credentials are provided
 * @author Jitendra Kumar
 * @date 09/08/2017
 */
package com.github.ui.tests;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.github.base.TestBase;
import com.github.pages.HomePage;
import com.github.pages.LoginPage;

public class Login extends TestBase{
	
	private LoginPage loginPage;
	private HomePage homePage;
	private String userName;
	private String password;
	
	@BeforeClass
	@Parameters({"browserType","url","userName","password"})
	public void initialize(
						@Optional("chrome") String browserType,
						@Optional("https://github.com") String url,
						@Optional("jitukum") String userName,
						@Optional("July@2017") String password){
		this.userName = userName;
		this.password = password;
		driver = getDriver(browserType);
		driver.get(url);
		driver.manage().window().maximize();
		homePage = new HomePage(driver);
		loginPage = new LoginPage(driver);
	}
	
	/**
	 * This test is used to verify that user cannot log in using
	 * Wrong credentials
	 */
	@Test
	public void verifyUnsuccessfulLogin(){
		homePage.clickOnSignIn();
		if(!loginPage.verifyLoginOperation("abcd", "123")){
			Reporter.log("Not able to log in.",true);
		}
		else{
			Assert.fail("Logged in successfully");
		}
	}
	
	/**
	 * This test is used to verify if user is able to log in
	 * Using correct credentials
	 */
	@Test(dependsOnMethods = "verifyUnsuccessfulLogin")
	public void verifySuccessfulLogin(){
		if(loginPage.verifyLoginOperation(userName, password)){
			Reporter.log("Successfully logged in.",true);
		}
		else{
			Assert.fail("Unable to log in.");
		}
	}
	
	@AfterClass
	public void closeBrowser(){
		driver.quit();
	}
}
