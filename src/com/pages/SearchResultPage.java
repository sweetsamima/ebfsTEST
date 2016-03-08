package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchResultPage {
	WebDriver driver;
	
	public SearchResultPage(WebDriver a){
		driver = a;
	}
	
	By pageTitle = By.className("navigation_page");
	By searchText = By.className("lighter");
	
	
	public String PageTitle(){
		return driver.findElement(pageTitle).getText();
	}
	
	public String SearchTextVerify(){
		String text = driver.findElement(searchText).getText();
		String verify = (text.substring(1, text.length()-1));
		return verify;
	}

}
