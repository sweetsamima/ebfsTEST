package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class MyAccountPage {
	WebDriver driver;
	public MyAccountPage(WebDriver a){
		driver = a;	
	}
	
	By signOut = By.className("logout");
	By accProDetails = By.className("cart_block_list");
	By OrderHistory = By.xpath(".//*[@id='center_column']/div/div[1]/ul/li[2]/a/span");
	By proQantity = By.id("summary_products_quantity");
	By UserName = By.className("account");
	By successMsg = By.xpath(".//*[@id='center_column']/p[1]");

	public String RetUser(){
		return driver.findElement(UserName).getText();
	}
	
	public String SuccessMessage(){
		return driver.findElement(successMsg).getText();
	}
	
	public void ProductQntt(){
		driver.findElement(proQantity).getText();
	}
	
	public void orderHistory(){
		driver.findElement(OrderHistory).click();
	}
	
	public void AccProDtails(){
		driver.findElement(accProDetails);
	}
	

	public String SignOutButton(){
		return driver.findElement(signOut).getText();
	}
	
	public void SignOutClick(){
		driver.findElement(signOut).click();
	}
	
}
