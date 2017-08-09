/**
 * This class contains the objects of login Page and its functionalities
 * 
 * @author Jitendra Kumar
 * @date 09/08/2017
 * @version 1.0
 */
package com.github.pages;

import java.util.NoSuchElementException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	protected WebDriver driver;
	
	@FindBy(id = "login_field")
	private WebElement userName;
	
	@FindBy(id = "password")
	private WebElement password;
	
	@FindBy(name = "commit")
	private WebElement signInButton;
	
	@FindBy(id = "js-flash-container")
	private WebElement errorMessage;
	
	/**
	 * Constructor of the Page class
	 * @param driver
	 */
	public LoginPage(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	/**
	 * This method is used to perform the login operation
	 * @param userName
	 * @param password
	 * @return
	 */
	public boolean verifyLoginOperation(String userName, String password){
		if(userName != null){
			this.userName.clear();
			this.userName.sendKeys(userName);
		}
		if(password != null){
			this.password.sendKeys(password);
		}
		this.signInButton.click();
		if(verifyElementPresent(errorMessage)){
			return false;
		}
		else{
			return true;
		}
	}
	
	/**
	 * This method is used to verify if an element is present or not
	 * @param element
	 * @return boolean
	 */
	private boolean verifyElementPresent(WebElement element) {
		boolean displayed = false;
		try {
			if (element.isDisplayed()) {
				if(element.getText().trim().equals("")){
					displayed = false;
				}
				else{
					displayed = true;
				}
			}
		} catch (NoSuchElementException e) {
			displayed = false;
		}
		return displayed;
	}
	

}
