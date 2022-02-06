package com.blazeTest.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BlazeLoginPage {
	private WebDriver driver;
	public BlazeLoginPage(WebDriver driver) {
		this.driver=driver;
	}
	
		private final By login = By.id("login2");
		private final By loginUserName = By.id("loginusername");
		private final By loginPassword = By.id("loginpassword");
		private final By loginBtn=By.xpath("//*[@onclick='logIn()']");
		private final By nameOfUser=By.id("nameofuser");
		
		public WebElement waitForElement(By locator) {
			new WebDriverWait(driver, 20).ignoring(StaleElementReferenceException.class).until(ExpectedConditions.elementToBeClickable(locator));
			return driver.findElement(locator);
		}
		public void clickLoginLink() {
			driver.findElement(login).click();	
		}
		public void enterLoginId(String loginId) {
			waitForElement(loginUserName);
			driver.findElement(loginUserName).sendKeys(loginId);		
		}
		public void enterPassword(String pwd) {
			driver.findElement(loginPassword).sendKeys(pwd);		
		}
		public void clickLoginBtn() {
			driver.findElement(loginBtn).click();		
		}
		public String getNameOfLoginUser() {
			waitForElement(nameOfUser);
			return driver.findElement(nameOfUser).getText();
		}
}
