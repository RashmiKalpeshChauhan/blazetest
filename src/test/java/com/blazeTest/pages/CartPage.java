package com.blazeTest.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CartPage {
	WebDriver driver;
	public CartPage(WebDriver driver) {
		this.driver=driver;
	}
	private final By cartMenu= By.id("cartur");
	private final By placeOrder=By.xpath("//*[contains(@class,'btn-success')]");
	private final By name=By.id("name");
	private final By country=By.id("country");
	private final By city=By.id("city");
	private final By creditCard=By.id("card");
	private final By month=By.id("month");
	private final By year=By.id("year");
	private final By purchaseBtn=By.xpath("//*[@onclick='purchaseOrder()']");
	private final By successfulMsg=By.xpath("//*[contains(@class,'sweet-alert')]/h2");

	  public WebElement waitForElement(By locator) {
		  new WebDriverWait(driver, 20).ignoring(StaleElementReferenceException.class).until(ExpectedConditions.elementToBeClickable(locator));
          return driver.findElement(locator);
	    }
	public void clickCartMenu() {
		waitForElement(cartMenu);
		driver.findElement(cartMenu).click();
	}
	public void clickPlaceOrder() {
		driver.findElement(placeOrder).click();
	}
	public void enterName(String pname) {
		waitForElement(name);
		driver.findElement(name).sendKeys(pname);
		
	}
	public void enterCountry(String pcountry) {
		driver.findElement(country).sendKeys(pcountry);
	}
	public void enterCity(String pcity) {
		driver.findElement(city).sendKeys(pcity);
	}
	public void enterCreditCard(String pcard) {
		driver.findElement(creditCard).sendKeys(pcard);
	}
	public void enterMonth(String pmonth) {
		driver.findElement(month).sendKeys(pmonth);
	}
	public void enterYear(String pyear) {
		driver.findElement(year).sendKeys(pyear);
	}
	public void clickPurchaseBtn() {
		driver.findElement(purchaseBtn).click();
	}
	public String getSuccessfulMsg() {
		return driver.findElement(successfulMsg).getText();
	}
}
