package com.pages;

import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import com.pages.Utility;

import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class SmokeTest {
	WebDriver driver;
	ExtentReports report;
	ExtentTest logger;
	HomePage home;
	LogInPage log;
	MyAccountPage account;
	OrderHistoryPage order;
	SearchResultPage search;
	PersonalInfoPage info;
	ProductCatagoryPage catagory;
	OurStoresPage stores;


		
  @Test(enabled=true)
  public void logoPresent() {
	 logger = report.startTest("1.1- Logo should be visible to all users.");
	  home = new HomePage(driver);
	  logger.log(LogStatus.INFO,"Navigated to HomePage");
	  home.logoIcon();
	  logger.log(LogStatus.PASS,"Logo is visible");
  }
  

  @Test(enabled=true)
  public void NavTest(){
	  logger = report.startTest("1.2- Nav Count to all users.");
	  home = new HomePage(driver);
	  logger.log(LogStatus.INFO,"Navigated to HomePage");
	  Assert.assertEquals(4, home.navC());
	  logger.log(LogStatus.PASS, "There are "+home.navC()+" navs");  
  }

  @Test(enabled=true)
  public void navigation(){
	  logger = report.startTest("1.2- Four navigation options present");
	  home = new HomePage(driver);
	  logger.log(LogStatus.INFO,"Navigated to HomePage");
	  home.navCount();
	  logger.log(LogStatus.PASS, "There are 4 navs present to users");
  }
  
  @Test(priority=0,enabled=true)
  public void SignIn(){
	  logger = report.startTest("1.3- User should be able to Login from Home Page");
	  home = new HomePage(driver);
	  logger.log(LogStatus.INFO,"Navigate to HomePage");
	  home.signInButton();
	  logger.log(LogStatus.INFO,"Navigating to LogInPage" );
	  log = new LogInPage(driver);
	  Assert.assertEquals(log.PageTtl(), "AUTHENTICATION");
	  logger.log(LogStatus.INFO,"Navigated to LogInPage verified" );
	  log.SucessSignIn("saju@gmail.com", "sajuuddin");
	  logger.log(LogStatus.INFO,"User loggin IN" );
	  account = new MyAccountPage(driver);
	  logger.log(LogStatus.INFO,"Navigated to MyAccountPage");
	  Assert.assertEquals(account.SignOutButton(), "Sign out");
	  account.SignOutClick();
	  logger.log(LogStatus.PASS,"User is able to login from Homepage");
  }
  
  @Test(enabled=true)
  public void FeaturedProductDisplay(){
	  logger = report.startTest("1.4- Featured Products should be visible to Users");
	  home = new HomePage(driver);
	  logger.log(LogStatus.INFO,"Navigated to HomePage");
	  home.FeaturedProduct();
	  logger.log(LogStatus.PASS,"FeaturedProduct is visible");
  }
  
  @Test(enabled=true)
  public void EmptyCartVisibility(){
	logger = report.startTest("1.5- Checkout Cart should be visible to users with Empty");  
    home = new HomePage(driver);
    logger.log(LogStatus.INFO, "Navigated to HomePage");
    home.EmptyCart();
    logger.log(LogStatus.PASS,"Checkout Cart is visible to users with Empty");
  }

  @Test(priority=2,enabled=true)
  public void ProductDetails(){
	  logger = report.startTest("1.6- User should be able to view the product details layer");
	  home = new HomePage(driver);
	  logger.log(LogStatus.INFO, "Navigated to Home Page");
	  String abc = home.MouseOverFeaturedProduct();
	  Assert.assertEquals(abc, "Add to my wishlist");
	  logger.log(LogStatus.INFO,"Verifying with text from product details pop up: "+abc);
	  logger.log(LogStatus.PASS, "Product Details layer is visible");
  }

  @Test(priority=1)
  public void WishListClick(){
	  logger = report.startTest("1.7- User should be able to add the product to wishlist");
	  home = new HomePage(driver);
	  logger.log(LogStatus.INFO, "Navigated to Home Page");
	  String abc = home.MouseOverFeaturedProduct();
	  Assert.assertEquals(abc, "Add to my wishlist");
	  logger.log(LogStatus.INFO,"Verifying with text from product details pop up: "+abc);
	  String d = home.ClickWishList();
	  Assert.assertEquals(d, "You must be logged in to manage your wishlist.");
	  logger.log(LogStatus.PASS, "Product is added to wishlist");
  }
  @Test
  public void AccountProductDetails(){
	  logger = report.startTest("1.8- User should be able to view details order from My Account section.");
	  home = new HomePage(driver);
	  logger.log(LogStatus.INFO, "Navigated to home page");
	  home.signInButton();
	  logger.log(LogStatus.INFO,"Navigating to LogInPage" );
	  log = new LogInPage(driver);
	  Assert.assertEquals(log.PageTtl(), "AUTHENTICATION");
	  logger.log(LogStatus.INFO,"Navigated to LogInPage verified" );
	  log.SucessSignIn("saju@gmail.com", "sajuuddin");
	  logger.log(LogStatus.INFO,"User logged in" );
	  account = new MyAccountPage(driver);
	  logger.log(LogStatus.INFO,"Navigated to MyAccountPage");
	  account.orderHistory();
	  order = new OrderHistoryPage(driver);
	  Assert.assertEquals(order.PageTitle(),"ORDER HISTORY");
	  logger.log(LogStatus.INFO, "Navigated to Order History Page");
	  Assert.assertEquals(order.NoProductMsg(), "You have not placed any orders.");
	  account.SignOutClick();
	  logger.log(LogStatus.PASS,"User can view Order history from account section");
	
  }
  
  @Test
  public void ContactUs(){
	  logger = report.startTest("1.9 - Contact us link is present to all users");
	  home = new HomePage(driver);
	  logger.log(LogStatus.INFO, "Navigated to HomePage");
	  
	  Assert.assertEquals(home.contactUs(), "Contact us");
	  logger.log(LogStatus.PASS, "Contact us link is present");
	 
	  
  }
  
  @Test
  public void PopularProducts(){
	  logger = report.startTest("1.1.1- User should be able to filter result using popular or best seller link");
	  home = new HomePage(driver);
	  logger.log(LogStatus.INFO,"Navigated to homepage");
	  int pop = home.popularPro();
	  logger.log(LogStatus.INFO, pop+" Popular Product is displayed");
	  int best = home.bestSellerPro();
	  logger.log(LogStatus.PASS, best+" Best Seller Product is displayed");
  }
  @Test
  public void SubscribeSucess(){
	  logger = report.startTest("1.1.2- User should be able to subscribe/unsubscribe for Upcoming newsletter.");
	  home = new HomePage(driver);
	  logger.log(LogStatus.INFO,"Navigated to Home Page");
	  //Change me before you run over me
	  String msg = home.subscribe("sajcio@gmail.com");
	  Assert.assertEquals(msg, "Newsletter : You have successfully subscribed to this newsletter.");
	  logger.log(LogStatus.PASS,"User have subscribed "+msg);
  }
  
  @Test
  public void Search(){
	  logger = report.startTest("1.1.3- User should be able to search for specific products by keyword.");
	  home = new HomePage(driver);
	  logger.log(LogStatus.INFO,"Navigated to Home Page");
	  String Searchtext = home.SearchNow("Dress");
	  logger.log(LogStatus.INFO,"Searching for whats in your mind... "+Searchtext);
	  search = new SearchResultPage(driver);
	  String title = search.PageTitle();
	  Assert.assertEquals(title, "Search");
	  logger.log(LogStatus.INFO,"Navigated to Search Result Page and verified Page Title: "+title);
	  String text = search.SearchTextVerify();
	  Assert.assertEquals(text, Searchtext.toUpperCase());
	  logger.log(LogStatus.PASS, "User is able to search from Home Page with keyword: "+text);
  }
  
  @Test
  public void TwitterLink(){
	  logger = report.startTest("1.1.4- User should be presented to follow us on twitter link.");
      home = new HomePage(driver);
      logger.log(LogStatus.INFO,"Navigated to HomrPage");
      home.Twiter();
      logger.log(LogStatus.PASS,"Twitter Link is Presented to user");
  }
  
  
  @Test
  public void NewAccount(){
	  logger = report.startTest("1.1.5- User should be able to register by clicking Login link");
	  home = new HomePage(driver);
	  logger.log(LogStatus.INFO, "Navigated to Home Page");
	  home.signInButton();
	  log = new LogInPage(driver);
	  Assert.assertEquals(log.PageTtl(), "AUTHENTICATION");
	  logger.log(LogStatus.INFO, "Navigated to User Registration Page");
	  ////////////////NOW WHAT?////////////////////////////////////////
	  String user = log.UserName("koly@konia.com");
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  info = new PersonalInfoPage(driver);
	  String name = info.AddInfo("Mrs", "Koly", "Selname", user, "password", "12", "5", "1985", "Y", "N");
	  logger.log(LogStatus.INFO, "Submitting User Information");
	  account = new MyAccountPage(driver);
	  String suc = account.SuccessMessage();
	  Assert.assertEquals(suc, "Your account has been created.");
	  logger.log(LogStatus.INFO, "Navigated to My Account Page");
	  String fuc = account.RetUser();
	  Assert.assertEquals(fuc, name);
	  account.SignOutClick();
	  logger.log(LogStatus.PASS, "User can register from Home Page like "+fuc);
  }
  
  @Test
  public void ProCatNav(){
	  logger = report.startTest("2.1- User should be able to navigate to product category page by clicking Dresses");
	  home = new HomePage(driver);
	  logger.log(LogStatus.INFO,"Navigated to HomePage");
	  home.dressesClick();
	  logger.log(LogStatus.INFO,"Navigating to product catagoty page");
	  catagory = new ProductCatagoryPage(driver);
	  Assert.assertEquals(catagory.PageTtl(), "DRESSES ");
	  logger.log(LogStatus.PASS, "Navigated to the Product Catagory Page");
  }
  
  @Test
  public void SubCatLinkS(){
	  logger = report.startTest("2.2- Sub-Categories link should be presented to the User.");
	  home = new HomePage(driver);
	  logger.log(LogStatus.INFO,"Navigated to HomePage");
	  home.dressesClick();
	  logger.log(LogStatus.INFO,"Navigating to product catagoty page");
	  catagory = new ProductCatagoryPage(driver);
	  Assert.assertEquals(catagory.PageTtl(), "DRESSES ");
	  logger.log(LogStatus.INFO, "Navigated to the Product Catagory Page");
	  int count= catagory.SubCatLinks();
	  
	  logger.log(LogStatus.PASS,count+" SubCatagory Links are presented to user which are: "+catagory.getSubCat());
  }
  
  @Test
  public void Sorting(){
	  logger = report.startTest("2.3- Sort Functionality is available for User to sort the products.");
	  driver.get("http://ebfs.bruteforcesolution.net/ebfs/index.php?id_category=8&controller=category");
	  catagory = new ProductCatagoryPage(driver);
	  Assert.assertEquals(catagory.PageTtl(), "DRESSES ");
	  logger.log(LogStatus.INFO, "Navigated to the Product Catagory Page");
	  String r = catagory.SortPriceLow();
	  logger.log(LogStatus.PASS,"Sorting is presented to users "+r);
	  
  }
  
  @Test
  public void GridVsList(){
	  logger = report.startTest("2.4- User can change the view of the product list by clicking Grid or List.");
	  driver.get("http://ebfs.bruteforcesolution.net/ebfs/index.php?id_category=8&controller=category");
	  catagory = new ProductCatagoryPage(driver);
	  Assert.assertEquals(catagory.PageTtl(), "DRESSES ");
	  logger.log(LogStatus.INFO, "Navigated to the Product Catagory Page");
	  Assert.assertEquals(catagory.GridView(), "Add to Wishlist");
	  logger.log(LogStatus.INFO, "Grid view is working fine");
	  Assert.assertEquals(catagory.ListView(), "Add to Wishlist");
	  logger.log(LogStatus.INFO, "List view is working fine");
	  logger.log(LogStatus.PASS,"User can switch between Grid and List view ");
	  
  }
  
  @Test
  public void ProductCounting(){
	  logger = report.startTest("2.5- Number of products showing should display on the page.");
	  driver.get("http://ebfs.bruteforcesolution.net/ebfs/index.php?id_category=8&controller=category");
	  catagory = new ProductCatagoryPage(driver);
	  Assert.assertEquals(catagory.PageTtl(), "DRESSES ");
	  logger.log(LogStatus.INFO, "Navigated to the Product Catagory Page");
	  String itemsFound = catagory.ProductCount();
	  logger.log(LogStatus.INFO, itemsFound);
	  logger.log(LogStatus.PASS, "Number of products showing is displayed on the page");
	  
  }
  
  @Test
  public void LeftSorting(){
	  logger = report.startTest("2.6- User should be able to filter products from left navigation.");
	  driver.get("http://ebfs.bruteforcesolution.net/ebfs/index.php?id_category=8&controller=category");
	  catagory = new ProductCatagoryPage(driver);
	  Assert.assertEquals(catagory.PageTtl(), "DRESSES ");
	  logger.log(LogStatus.INFO, "Navigated to the Product Catagory Page");
	  catagory.GridView();
	  String produc = catagory.ProductFilter();
	  Assert.assertEquals(produc, "Printed Summer Dress");
	  logger.log(LogStatus.INFO, produc);
	  logger.log(LogStatus.PASS, "Left Navigation Sorting Filter is working");
	  
  }

  @Test
  public void PriceSlide(){
	  logger = report.startTest("2.7- User should be able to filter products by price slider.");
	  driver.get("http://ebfs.bruteforcesolution.net/ebfs/index.php?id_category=8&controller=category");
	  catagory = new ProductCatagoryPage(driver);
	  Assert.assertEquals(catagory.PageTtl(), "DRESSES ");
	  logger.log(LogStatus.INFO, "Navigated to the Product Catagory Page");
	  catagory.SliderTest();
	  logger.log(LogStatus.PASS, "Slider works");
  }
  
  @Test
  public void StoreLocations(){
	  
	  logger = report.startTest("2.8- User should be able to find the store location by clicking Discover Our Stores");
	  driver.get("http://ebfs.bruteforcesolution.net/ebfs/index.php?id_category=8&controller=category");
	  catagory = new ProductCatagoryPage(driver);
	  Assert.assertEquals(catagory.PageTtl(), "DRESSES ");
	  logger.log(LogStatus.INFO, "Navigated to the Product Catagory Page");
	  catagory.StoreLocatorClick();
	  logger.log(LogStatus.INFO, "Discover our Stores Clicked");
	  stores = new OurStoresPage(driver);
	  Assert.assertEquals(stores.PageTitle(), "Stores - eBFS - the power of choice");
	  logger.log(LogStatus.PASS, "User is navigated to Our Stores Page after clicking on Discover our store link "+stores.PageTitle());
  }
	  
  @Test
  public void AddMoreText(){
	  
	  logger = report.startTest("2.9- Add to Cart or More Button should be visible when user mouse over to product.");
	  driver.get("http://ebfs.bruteforcesolution.net/ebfs/index.php?id_category=8&controller=category");
	  catagory = new ProductCatagoryPage(driver);
	  Assert.assertEquals(catagory.PageTtl(), "DRESSES ");
	  logger.log(LogStatus.INFO, "Navigated to the Product Catagory Page");
	  Assert.assertEquals(catagory.MoreCartBtn(), "Add to cart More");
	  logger.log(LogStatus.PASS, "Add to Cart and More Buttons are visible ");
	  
  }
  @BeforeMethod
  public void beforeMethod() {
	  
	  driver.get("http://ebfs.bruteforcesolution.net/ebfs/index.php");
	  driver.manage().window().maximize();   
	  
  }
 
  

  @AfterMethod
  public void tearDown(ITestResult result) throws Throwable{
	 if(result.getStatus()==ITestResult.FAILURE){
		
		 String image = logger.addScreenCapture(Utility.captureScreenshot(driver,result.getName()));
		 logger.log(LogStatus.FAIL,"Featured Product visibility",image);
		
	  }
	  report.endTest(logger);
	  report.flush();
	  
  }

  @BeforeTest
  public void OpenBrowser() {
	  driver = new FirefoxDriver();
	  report = new ExtentReports("C:\\Users\\Samima\\workspace\\FuntionalTesting\\Xreport\\report.html");
  }

  @AfterTest
  public void afterTest() {
	  
	 driver.get("C:\\Users\\Samima\\workspace\\FuntionalTesting\\Xreport\\report.html");
  // driver.close();
  }

}
