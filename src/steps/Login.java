package steps;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Login {
	WebDriver driver = new FirefoxDriver();
	
	@Given("^User is on Home Page$")
	public void user_is_on_Home_Page() {
	    // Write code here that turns the phrase above into concrete actions
		driver.get("http://ebfs.bruteforcesolution.net/ebfs/index.php");
	    
	}

	@When("^User Navigate to LogIn Page$")
	public void user_Navigate_to_LogIn_Page() {
	    // Write code here that turns the phrase above into concrete actions
	    ;
	}

	@When("^User enters UserName and Password$")
	public void user_enters_UserName_and_Password() {
	    // Write code here that turns the phrase above into concrete actions
	    ;
	}

	@Then("^Message displayed Login Successfully$")
	public void message_displayed_Login_Successfully() {
	    // Write code here that turns the phrase above into concrete actions
	    ;
	}

	@When("^User LogOut from the Application$")
	public void user_LogOut_from_the_Application() {
	    // Write code here that turns the phrase above into concrete actions
	    ;
	}

	@Then("^Message displayed LogOut Successfully$")
	public void message_displayed_LogOut_Successfully() {
	    // Write code here that turns the phrase above into concrete actions
	    ;
	}

}
