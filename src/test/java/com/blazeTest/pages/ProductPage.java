package com.blazeTest.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductPage {
	private WebDriver driver;
	private final By addToCartButton= By.xpath("//*[contains(@onclick,'addToCart')]");
	
	public WebElement waitForElement(By locator) {
		new WebDriverWait(driver, 20).ignoring(StaleElementReferenceException.class).until(ExpectedConditions.elementToBeClickable(locator));
		return driver.findElement(locator);
	}
	public ProductPage(WebDriver driver) {
		this.driver=driver;
	}


	public void selectProduct(String productName) {
		driver.findElement(By.xpath("//a[contains(text(),'"+productName+"')]")).click();
	}
	public void clickAddToCart() {
		waitForElement(addToCartButton);
		driver.findElement(addToCartButton).click();
	}
}
