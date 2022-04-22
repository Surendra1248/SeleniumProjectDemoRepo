package stepDefinitions;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.LandingPage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import resources.Base;

public class Login extends Base {
	WebDriver driver;
	LoginPage login;
    @Given("^open any browser$")
    public void open_any_browser() throws IOException  {
      driver= initializeDriver();
    }
    

    @And("^navigate to login page$")
    public void navigate_to_login_page() throws Throwable {
       driver.get(prop.getProperty("Url"));
       LandingPage lp= new LandingPage(driver);
       lp.myAccountDropDown().click();
       lp.loginOption().click();
    }

    @When("^User enters username as \"([^\"]*)\" and password as \"([^\"]*)\" in to the fields$")
    public void user_enters_username_as_something_and_password_as_something_in_to_the_fields(String email, String pwd) throws Throwable {
       login = new LoginPage(driver);
        login.emailaddress().sendKeys(email);
        login.passwordfield().sendKeys(pwd);
    }

  

    @And("^User clicks on Login button$")
    public void user_clicks_on_login_button() {
        login.loginButton().click();
    }
    @Then("^verify user is able to Successfully login$")
    public void verify_user_is_able_to_successfully_login() {
       MyAccountPage mp = new MyAccountPage(driver);
       Assert.assertTrue(mp.editAccountInfo().isDisplayed());
    }
    
    @After
    public void closure() {
    	driver.quit();
    }

}
