package com.blazeTest.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BlazePage {
	private final WebDriver driver;

	public BlazePage(WebDriver driver) {
		this.driver=driver;
	}

	private final By singUp = By.id("signin2");
	private final By userName = By.id("sign-username");
	private final By password = By.id("sign-password");
	private final By singUpBtn = By.xpath("//*[@onclick='register()']");

	public WebElement waitForElement(By locator) {
		new WebDriverWait(driver, 20).ignoring(StaleElementReferenceException.class).until(ExpectedConditions.elementToBeClickable(locator));
		return driver.findElement(locator);
	}

	public void clickSignUpLink() {
		driver.findElement(singUp).click();		
	}
	public void enterUserName(String username) {
		waitForElement(userName);
		driver.findElement(userName).sendKeys(username);		
	}
	public void enterPassword(String pwd) {
		driver.findElement(password).sendKeys(pwd);		
	}
	public void clickSignBtn() {
		driver.findElement(singUpBtn).click();	
	}
}
