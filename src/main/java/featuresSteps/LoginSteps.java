package featuresSteps;

import java.io.IOException;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.cucumber.listener.Reporter;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.bytebuddy.utility.RandomString;
import utilityFunctions.InitializeDriver;
import utilityFunctions.ScreenShotCapture;

public final class LoginSteps {
	WebDriver driver;
	@Given("^I have application url and i am on login page$")
	public void i_have_application_url_and_i_am_on_login_page() {
		   InitializeDriver id=new InitializeDriver();
			  driver= id.getDriver();
			  driver.get("https://the-internet.herokuapp.com/login");
	    
	}

	@When("^I enter username \"([^\"]*)\"$")
	public void i_enter_username(String username) {
		driver.findElement(By.id("username")).sendKeys(username);
	}

	@When("^I Enter password \"([^\"]*)\"$")
	public void i_Enter_password(String password)  {
		driver.findElement(By.id("password")).sendKeys(password);
	}

	@When("^I click on login button$")
	public void i_click_on_login_button() {
		driver.findElement(By.className("radius")).click();
	}

	@Then("^Secure Area page is displayed$")
	public void inventory_page_is_displayed() throws IOException {		
		boolean isDisplayed=driver.findElement(By.id("flash")).isDisplayed();
		   Assert.assertTrue(isDisplayed);
		   String screenshotpath= ScreenShotCapture.takeScreenShot("Secure Area page");
			 Reporter.addScreenCaptureFromPath(screenshotpath);
		   driver.close();
	  
	}
	
	@Then("^Error Message \"([^\"]*)\" is displayed in login page$")
	public void error_Message_is_displayed_in_login_page(String expectedErrorMessage) throws IOException{
	    String actualErrorMessage=driver.findElement(By.xpath("//div[@class='flash error']")).getText();
	    System.out.println(actualErrorMessage);
	    boolean isContain=actualErrorMessage.contains(expectedErrorMessage);
	    Assert.assertTrue(isContain);
	   
		   String screenshotpath= ScreenShotCapture.takeScreenShot("ErrorMessage_"+RandomString.make(2));
				 Reporter.addScreenCaptureFromPath(screenshotpath);
		driver.close();
	}


}
