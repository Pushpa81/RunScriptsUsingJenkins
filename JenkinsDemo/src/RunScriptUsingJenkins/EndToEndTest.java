package RunScriptUsingJenkins;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class EndToEndTest {
	WebDriver driver;
	
	@BeforeTest
	@Parameters("browser")
	public void openMultipleBrs(String browser) throws IOException {
		if (browser.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		} else if (browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver",
					"C:\\Users\\TRACLabs\\Documents\\Downloads\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		driver.manage().window().maximize();
		driver.get("https://prideview-core.traclabs.com");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

	}
	
	@Test(priority=0)
	public void VerifyTitle(){
		String actualTitle = driver.getTitle();
		String expectedTitle = "PrideView Login";
		Assert.assertEquals(expectedTitle, actualTitle);
		System.out.println(driver.getTitle());
		
	}

	@Test(priority=1)
	public void LoginTest() throws IOException {
		String pageTitle = "";
		
//		String actualTitle = "";
//		String expectedTitle = "PrideView Dashboard";
		
		driver.findElement(By.name("username")).sendKeys("test");
		driver.findElement(By.name("password")).sendKeys("test");
		driver.findElement(By.xpath(".//*[@id='LoginForm']/div[3]/div/div/span[2]/button")).click();
		
//		actualTitle = driver.getTitle();
//		Assert.assertEquals(expectedTitle, actualTitle);
//		System.out.println("Login in Suceesfull");
		
		pageTitle = driver.getTitle();
		if (pageTitle.equals("PrideView Dashboard")) {
			System.out.println("Login successful");
//			getScreenShot();
		}

		else if (pageTitle.equals("PrideView Login")) {
			System.out.println("Login not successfull");
//			getScreenShot();

	}
	}
	
	@Test(priority=2)
	public void LogoutTest() throws IOException{
		String pageTitle = "";
		
		driver.findElement(By.cssSelector("div.user-label")).click();
		driver.findElement(By.linkText("Logout")).click();	
		pageTitle = driver.getTitle();
		if (pageTitle.equals("PrideView Login")) {
			System.out.println("successfully Logout");
//			getScreenShot();
		}

		else if (pageTitle.equals("User test")) {
			System.out.println("Logout not successfull");
//			getScreenShot();

	}
		
		
		
	}

//	public void getScreenShot() throws IOException {
//		File ss = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
//		FileUtils.copyFile(ss,
//				new File("C:\\Users\\TRACLabs\\Documents\\AutomationRegression\\JenkinsDemo\\screen5.jpg"));
//	}

//	@AfterTest
//	public void closeBrowser() {
//		driver.quit();
//	}


}
