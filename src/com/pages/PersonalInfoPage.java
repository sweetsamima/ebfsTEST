package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;


public class PersonalInfoPage {
	WebDriver driver;
	
	public PersonalInfoPage(WebDriver a){
		driver = a;
	}
	
	By Mr = By.id("id_gender1");
	By Mrs = By.id("id_gender1");
	By Fname = By.id("customer_firstname");
	By Lname = By.id("customer_lastname");
	By Email = By.id("email");
	By Password = By.id("passwd");
	By Date = By.id("days");
	By Month = By.id("months");
	By Year = By.id("years");
	By Newsletter = By.id("newsletter");
	By Offer = By.id("optin");
	By SubmitAcc = By.id("submitAccount");
	
	public String AddInfo(String gender,String fname,String lname,String email,String password,String date,String month,String year,String news,String offer){
		if(gender.equalsIgnoreCase("Mr")){
			driver.findElement(Mr).click();
		}else{
			driver.findElement(Mrs).click();
		}
		driver.findElement(Fname).sendKeys(fname);
		driver.findElement(Lname).sendKeys(lname);
		String oldemail = driver.findElement(Email).getAttribute("value");
		Assert.assertEquals(oldemail, email);
		driver.findElement(Password).sendKeys(password);
		
		driver.findElement(Date).click();
		Select dropdown = new Select(driver.findElement(Date));
		dropdown.selectByValue(date);
		
		driver.findElement(Month).click();
		Select dropdown1 = new Select(driver.findElement(Month));
		dropdown1.selectByValue(month);
		
		driver.findElement(Year).click();
		Select dropdown2 = new Select(driver.findElement(Year));
		dropdown2.selectByValue(year);
		
		if(news.equalsIgnoreCase("Y")){
			driver.findElement(Newsletter).click();
		}
		
		if(offer.equalsIgnoreCase("Y")){
			driver.findElement(Offer).click();
		}
		
		driver.findElement(SubmitAcc).click();
		return fname+" "+lname;
		
		
	}
	

}
