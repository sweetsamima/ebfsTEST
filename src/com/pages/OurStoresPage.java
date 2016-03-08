package com.pages;

import org.openqa.selenium.WebDriver;

public class OurStoresPage {
	WebDriver driver;
	public OurStoresPage(WebDriver a){
		driver = a;
	}
	
	public String PageTitle(){
		return driver.getTitle();
	}

}
