package com.pages;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class ProductCatagoryPage {
	WebDriver driver;
	public ProductCatagoryPage(WebDriver a){
		driver = a;
	}
	
	By title = By.xpath(".//*[@id='center_column']/h1/span[1]");
	By subCatLinks = By.xpath(".//*[@id='subcategories']/ul/li/h5/a");
	By sort = By.id("selectProductSort");
	By pro = By.xpath(".//*[@id='center_column']/ul/li[1]/div");
	By small = By.xpath(".//*[@id='center_column']/ul/li[1]/div/div[1]/div/div[2]/span[1]");
	By grid = By.xpath(".//*[@id='grid']/a");
	By list = By.xpath(".//*[@id='list']/a");
	By wishlistGrid = By.xpath(".//*[@id='center_column']/ul/li[1]/div/div[3]/div[1]/a");
	By wishlistList = By.xpath(".//*[@id='center_column']/ul/li[1]/div/div/div[3]/div/div[3]/div[1]/a");
	By proCount = By.xpath(".//*[@id='center_column']/div[3]/div[2]/div[2]");
	By catSummer = By.id("layered_category_11");
	By sizeSmall = By.id("layered_id_attribute_group_1");
	By colorYellow = By.id("layered_id_attribute_group_16");
	By compPoly = By.id("layered_id_feature_1");
	By styleGirly = By.id("layered_id_feature_13");
	By propShort = By.id("layered_id_feature_19");
	By avaiInstock = By.id("layered_quantity_1");
	By manuFashion = By.id("layered_manufacturer_1");
	By condNew = By.id("layered_condition_new");
	By prodName = By.xpath(".//*[@id='center_column']/ul/li/div/div[2]/h5/a");
	
	By enbCat = By.xpath(".//*[@id='enabled_filters']/ul/li[1]");
	By enbSize = By.xpath(".//*[@id='enabled_filters']/ul/li[5]");
	By enbColor = By.xpath(".//*[@id='enabled_filters']/ul/li[6]");
	By enbComp = By.xpath(".//*[@id='enabled_filters']/ul/li[7]");
	By enbStyle = By.xpath(".//*[@id='enabled_filters']/ul/li[8]");
	By enbProp = By.xpath(".//*[@id='enabled_filters']/ul/li[9]");
	By enbAvai = By.xpath(".//*[@id='enabled_filters']/ul/li[3]");
	By enbManu = By.xpath(".//*[@id='enabled_filters']/ul/li[2]");
	By enbCond = By.xpath(".//*[@id='enabled_filters']/ul/li[4]");
	By priceLow = By.xpath(".//*[@id='layered_price_slider']/a[1]");
	By priceHigh = By.xpath(".//*[@id='layered_price_slider']/a[2]");
	By priceSlider = By.xpath(".//*[@id='layered_price_slider']");
	By range = By.xpath(".//*[@id='layered_price_range']");
	By storeLoc = By.xpath(".//*[@id='stores_block_left']/div/div/a/span");
	By addToCart = By.xpath(".//*[@id='center_column']/ul/li[1]/div/div[2]/div[2]/a[1]/span");
	By moreBtn = By.xpath(".//*[@id='center_column']/ul/li[1]/div/div[2]/div[2]/a[2]/span");
	By stock = By.xpath(".//*[@id='center_column']/ul/li/div/div[2]/span/span");
	
	
	public String MoreCartBtn(){
		Actions act = new Actions(driver);
		act.moveToElement(driver.findElement(pro)).build().perform();
		driver.findElement(addToCart).isDisplayed();
		String rtnString = driver.findElement(addToCart).getText();
		driver.findElement(moreBtn).isDisplayed();
		String rtnAnother = driver.findElement(moreBtn).getText();
		return rtnString+" "+rtnAnother;
	}
	

	
	public void StoreLocatorClick(){
		driver.findElement(storeLoc).click();
	}
	
	public void SliderTest(){
		String r = driver.findElement(range).getText();
		System.out.println(r);
		Actions action = new Actions(driver);
		action.clickAndHold(driver.findElement(priceLow)).moveByOffset(10, 0).release().build();
		String row = driver.findElement(range).getText();
		System.out.println(row);
	}
	
	public String ProductFilter(){
		driver.findElement(catSummer).click();
		driver.findElement(sizeSmall).click();
		driver.findElement(colorYellow).click();
		driver.findElement(compPoly).click();
		driver.findElement(styleGirly).click();
		driver.findElement(propShort).click();
		driver.findElement(avaiInstock).click();
		driver.findElement(manuFashion).click();
		driver.findElement(condNew).click();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		String cat = driver.findElement(enbCat).getText();
		Assert.assertEquals(cat, "Categories: Summer Dresses");
		String size = driver.findElement(enbSize).getText();
		Assert.assertEquals(size, "Size: S");
		String color = driver.findElement(enbColor).getText();
		Assert.assertEquals(color, "Color: Yellow");
		String comp = driver.findElement(enbComp).getText();
		Assert.assertEquals(comp, "Compositions: Polyester");
		String style = driver.findElement(enbStyle).getText();
		Assert.assertEquals(style, "Styles: Girly");
		String prop = driver.findElement(enbProp).getText();
		Assert.assertEquals(prop, "Properties: Short Dress");
		String avai = driver.findElement(enbAvai).getText();
		Assert.assertEquals(avai, "Availability: In stock");
		String manu = driver.findElement(enbManu).getText();
		Assert.assertEquals(manu, "Manufacturer: Fashion Manufacturer");
		String cond = driver.findElement(enbCond).getText();
		Assert.assertEquals(cond, "Condition: New");
		return driver.findElement(prodName).getText();
	}
	
	public String ProductCount(){
		return driver.findElement(proCount).getText();
	}
	public String GridView(){
		driver.findElement(grid).click();
		Actions act = new Actions(driver);
		act.moveToElement(driver.findElement(pro)).build().perform();
		return driver.findElement(wishlistGrid).getText();
	}
	
	public String ListView(){
		driver.findElement(list).click();
		return driver.findElement(wishlistList).getText();
	}
	
	public String SortPriceLow(){
		driver.findElement(grid).click();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.findElement(sort).isDisplayed();
		driver.findElement(sort).click();
		Select dropdown = new Select(driver.findElement(sort));
		dropdown.selectByVisibleText("Price: Lowest first");
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		Actions act = new Actions(driver);
		act.moveToElement(driver.findElement(pro)).build().perform();
		return driver.findElement(small).getText();
		
	}
	
	public int SubCatLinks(){
		driver.findElement(subCatLinks).isDisplayed();
		return driver.findElements(subCatLinks).size();
	}
	
	public StringBuilder getSubCat(){		
		String list = null;
		//Using String Builder to concatenate list of Links
		StringBuilder c = new StringBuilder();
		//Using List for looping through List of WebElements
		List<WebElement> elements = driver.findElements(subCatLinks);
		int i= 1;
		for(WebElement element:elements) {
			
		    list = element.getText();
		    //Concatenating values
		    c.append(" "+i+". "+list); 
		    i++;
		}
		return c;
		
	    }
		
	
	
	
	public String PageTtl(){
		return driver.findElement(title).getText();
	}

	
}
