package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LogInPage {
	

	WebDriver driver;
	public LogInPage(WebDriver a){
		driver = a;
	}

	 By PageTitle = By.xpath(".//*[@id='center_column']/h1");
	 By UserName = By.id("email");
	 By Password = By.id("passwd");
	 By Submit = By.id("SubmitLogin");
	 By NewUsername = By.id("email_create");
	 By CreateNew = By.id("SubmitCreate");
	 
	 public String UserName(String Username){
		 driver.findElement(NewUsername).sendKeys(Username);
		 driver.findElement(CreateNew).click();
		 return Username;
	 }
	 
	
	 

  public String PageTtl(){
	 return driver.findElement(PageTitle).getText(); 
  }
  
  public void SucessSignIn(String username, String password){
	  driver.findElement(UserName).sendKeys(username);
  	  driver.findElement(Password).sendKeys(password);
  	  driver.findElement(Submit).click();
  }
 
  
  
}