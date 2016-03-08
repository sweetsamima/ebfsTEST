package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OrderHistoryPage {
	WebDriver driver;
	
	public OrderHistoryPage(WebDriver a){
		driver = a;
	}
	
	By pageTitle = By.xpath(".//*[@id='center_column']/h1");
	By noProductMsg = By.xpath(".//*[@id='block-history']/p");
	
	
	
	public String PageTitle(){
		return driver.findElement(pageTitle).getText();
	}
	
	public String NoProductMsg(){
		return driver.findElement(noProductMsg).getText();
	}

}
