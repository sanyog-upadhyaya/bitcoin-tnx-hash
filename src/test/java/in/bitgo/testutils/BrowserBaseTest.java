package in.bitgo.testutils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import io.github.bonigarcia.wdm.WebDriverManager;


public class BrowserBaseTest {
	
	public WebDriver driver;
	public Properties urlProperty;
	public static String bitgoUrl;
	
	@BeforeClass
	public void baseSetup() throws IOException {
		

		WebDriverManager.chromedriver().setup();
	    driver = new ChromeDriver();
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(6));
		urlProperty = new Properties();
		FileInputStream dataFile = new FileInputStream(
				System.getProperty("user.dir") + "//src//main//java//in//bitgo//resources//url.properties");
		urlProperty.load(dataFile);
		bitgoUrl = System.getProperty("bitgoUrl") != null ? System.getProperty("bitgoUrl")
				: urlProperty.getProperty("bitgoUrl");
		
		driver.get(bitgoUrl);
		
		
	}
	
	@AfterClass()
	public void closeSetup() {
		

		driver.quit();
		
	}
	

}
