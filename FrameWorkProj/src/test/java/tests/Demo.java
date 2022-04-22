package tests;
import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Demo {

	public static void main(String[] args) {
		Logger log = LogManager.getLogger(Demo.class.getName());
		log.debug("Demo test execution started");
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		log.debug("ChromeBrowser launched");
		driver.manage().window().maximize();
		log.debug("Browser got maximized");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://surendrareddy1248.github.io/WebElementsTesting/");
		log.debug("navigated to ATW webElements page");
		driver.findElement(By.linkText("onlytestingblog")).click();
		log.debug("Clicked on OnlyTestingBlog link and navigated to OnlyTestingBlog page");
		driver.navigate().back();
		log.debug("Navigated back to ATW");
		driver.navigate().forward();
		log.debug("Navigating forward to only testing blog");
		
		if(driver.getTitle().equals("Only Testing: TextBoxABC")) {
			log.info("Success -- the title of the page displayed is correct");
			
		}
		else {
			log.error("Failed: Wrong title got displayed");
		}
		driver.quit();
		log.debug("ChromeBrowser got closed & Test Execution ended");
		
	}

}
