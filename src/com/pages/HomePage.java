package com.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;



public class HomePage {
	
	WebDriver driver;
	Actions act;
		
	public HomePage(WebDriver a){
		driver=a;
	}

	
	By logo = By.xpath(".//*[@id='header_logo']/a/img");
	By nav = By.xpath(".//*[@id='block_top_menu']/ul/li/a");
	By dresses = By.xpath(".//*[@id='block_top_menu']/ul/li[2]/a");
	By women = By.xpath(".//*[@id='block_top_menu']/ul/li[1]/a");
	By tshirt = By.xpath(".//*[@id='block_top_menu']/ul/li[3]/a");
    By bruteforce = By.xpath(".//*[@id='block_top_menu']/ul/li[4]/a");
    By signIn = By.className("login");
    By testText = By.xpath(".//*[@id='cmsinfo_block']/div[2]/ul/li[3]");
    By featuredProduct = By.xpath(".//*[@id='homefeatured']/li[1]/div/div[1]/div/a[1]/img");
    By emptyCart = By.className("ajax_cart_no_product");
    By product = By.xpath(".//*[@id='homefeatured']/li[1]/div/div[1]/div");
    By quickView = By.xpath(".//*[@id='homefeatured']/li[1]/div/div[1]/div/a[2]");
    By wishList = By.id("wishlist_button");
    By loginMsg = By.xpath(".//*[@id='product']/div[2]/div/div/div/div/p");
    By contactlink = By.xpath(".//*[@id='contact-link']/a");
    By popularLink = By.className("homefeatured");
    By bestSellerLink = By.className("blockbestsellers");
    By popularFeaturedPro = By.xpath(".//*[@id='homefeatured']/li");
    By bestSellerFeaturedPro = By.xpath(".//*[@id='blockbestsellers']/li");
    By subscribelink = By.xpath(".//*[@id='newsletter-input']");
    By suscSubmit = By.xpath(".//*[@name='submitNewsletter']");
    By suscMsg = By.xpath(".//*[@id='columns']/p");
    By searchBox = By.id("search_query_top");
    By searchBtn = By.xpath(".//*[@name='submit_search']");
    By twitter = By.xpath(".//*[@class='twitter']/a");
    
    
    public void dressesClick(){
       driver.findElement(dresses).click();    	
    }
    
    
    public void Twiter(){
    	driver.findElement(twitter).isDisplayed();
    }
    
    public String SearchNow(String searchtext){
    	driver.findElement(searchBox).sendKeys(searchtext);
    	driver.findElement(searchBtn).click();
    	return searchtext;
    }
    
    public String  subscribe(String arg0){
    	driver.findElement(subscribelink).sendKeys(arg0);
    	driver.findElement(suscSubmit).click();
    	//Newsletter : This email address is already registered.
    	//Newsletter : You have successfully subscribed to this newsletter.
    	return driver.findElement(suscMsg).getText();
    }
    
    public int popularPro(){
        driver.findElement(popularLink).click();
        driver.findElement(popularFeaturedPro).isDisplayed();
        return driver.findElements(popularFeaturedPro).size();
    }
    
    public int bestSellerPro(){
    	driver.findElement(bestSellerLink).click();
    	driver.findElement(bestSellerFeaturedPro).isDisplayed();
    	return driver.findElements(bestSellerFeaturedPro).size();
    	
    }
    
    public String contactUs(){
    	return driver.findElement(contactlink).getText();
    }
    
	
	public void logoIcon(){
		driver.findElement(logo).isDisplayed();
	}
	
	public int navC(){
		return driver.findElements(nav).size();
	}
	
	public void navCount(){
		driver.findElement(dresses).isDisplayed();
		driver.findElement(women).isDisplayed();
		driver.findElement(tshirt).isDisplayed();
		driver.findElement(bruteforce).isDisplayed();		
	}
	public void signInButton(){
		driver.findElement(signIn).click();
		
	}
	public void FeaturedProduct(){
		driver.findElement(featuredProduct).isDisplayed();
	}
	
	public String EmptyCart(){
		return driver.findElement(emptyCart).getText();
	}
	
	
	public String MouseOverFeaturedProduct(){
		act = new Actions(driver);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		act.moveToElement(driver.findElement(product)).moveToElement(driver.findElement(quickView)).click().build().perform();
		driver.switchTo().frame(driver.findElement(By.className("fancybox-iframe")));
		return driver.findElement(wishList).getText();
				
	}
	
	public String ClickWishList(){
		driver.findElement(wishList).click();
		return driver.findElement(loginMsg).getText();
	}

		
	}


