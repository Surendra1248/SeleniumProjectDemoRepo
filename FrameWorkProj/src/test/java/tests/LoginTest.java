package tests;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.LandingPage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import resources.Base;

public class LoginTest extends Base {
	public WebDriver driver;
	Logger log;
	@BeforeMethod
	public void openApplication() throws IOException {
	 log = LogManager.getLogger(LoginTest.class.getName());
		driver = initializeDriver();
		log.debug("Browser got launched");
		driver.get(prop.getProperty("Url"));
		log.debug("Navigated to application URL");
	}
	@Test(dataProvider = "getLoginData")
	public void login(String email,String pwd,String expected) {
		
		LandingPage landing= new LandingPage(driver);
		landing.myAccountDropDown().click();
		log.debug("Clicked on MyAccount DropDown");
		landing.loginOption().click();
		log.debug("Clicked on login Option");
		LoginPage loginPage = new LoginPage(driver);
		loginPage.emailaddress().sendKeys(email);
		log.debug("Entered email address");
		loginPage.passwordfield().sendKeys(pwd);
		log.debug("Entered password");
		loginPage.loginButton().click();
		log.debug("Clicked on login button");
		MyAccountPage accountPage= new MyAccountPage(driver);
		String actual=null;
		try {
		if(accountPage.editAccountInfo().isDisplayed()) {
			log.debug("User got logged in");
			actual="successfull";
			
		}
		
		}catch (Exception e) {
			log.debug("User not able to login");
			actual="Failure";
		}
		Assert.assertEquals(actual, expected);
		log.info("Login Test got passed");
	}
	@AfterMethod
	public void tearDown() {
		driver.close();
		log.debug("Browser got closed");
	}
	@DataProvider
	public Object[][] getLoginData() {
		Object[][] data= {{"phaniatw2@gmail.com","atw@123","successfull"},
				          {"Sample@test.com","test@123","Failure"}};
		return data;
	}

}
