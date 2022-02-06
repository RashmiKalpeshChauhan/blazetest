package com.blazeTest.tests;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.blazeTest.base.DriverInstance;
import com.blazeTest.pages.BlazeLoginPage;
import com.blazeTest.pages.BlazePage;
import com.blazeTest.pages.CartPage;
import com.blazeTest.pages.ProductPage;



public class BlazeTests extends DriverInstance {
	
	SimpleDateFormat date=null;
	String timeStamp=null;
	String password="Test@123";
	Long datetime;
	
	@Test(priority=1)
	public void SignUp() throws InterruptedException {		
		BlazePage blazePage=new BlazePage(driver);
		blazePage.clickSignUpLink();
		datetime = System.currentTimeMillis();
	    date = new SimpleDateFormat("yyyyMMddHHmmss");
	    timeStamp = date.format(new Date());
	    blazePage.enterUserName(timeStamp);
		blazePage.enterPassword(password);
		blazePage.clickSignBtn();
		acceptAlert(driver);
	}

	@Test(priority=2)
	public void login() {		
		BlazeLoginPage loginPage=new BlazeLoginPage(driver);
		loginPage.clickLoginLink();
		loginPage.enterLoginId("20220201205355");
		loginPage.enterPassword("Test@123");
		loginPage.clickLoginBtn();	
		Assert.assertTrue(loginPage.getNameOfLoginUser().contains("20220201205355"));
	}
	
	@Test(priority=3,dependsOnMethods= {"login"})
	public void addProduct() throws InterruptedException {
		ProductPage productPage=new ProductPage(driver);
		productPage.selectProduct("Samsung galaxy s6");
		productPage.clickAddToCart();
		acceptAlert(driver);
	}
	
	@Test(priority=4,dependsOnMethods= {"addProduct"})
	public void placeOrder() {
		CartPage cartPage=new CartPage(driver);
		cartPage.clickCartMenu();
		cartPage.clickPlaceOrder();
		cartPage.enterName("Rashmi");
		cartPage.enterCountry("India");
		cartPage.enterCity("Test");
		cartPage.enterCreditCard("4111111111111111");
		cartPage.enterMonth("12");
		cartPage.enterYear("2025");
		cartPage.clickPurchaseBtn();
		Assert.assertTrue(cartPage.getSuccessfulMsg().contains("Thank you for your purchase!"));		
	}
}
