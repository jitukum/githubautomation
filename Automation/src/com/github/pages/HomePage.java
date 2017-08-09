package com.github.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	private WebDriver driver;
	
	@FindBy(xpath = "//*[contains(text(),'Sign in')]")
	private WebElement signInLink;
	
	/**
	 * Constructor of the page class
	 * @param driver
	 */
	public HomePage(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(this.driver, this);
	}
	
	/**
	 * Clicks on Sign In Link
	 */
	public void clickOnSignIn(){
		this.signInLink.click();
	}

}
