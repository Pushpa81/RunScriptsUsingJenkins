package RunScriptUsingJenkins;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TakeScreenShot {
	WebDriver driver;

	@BeforeTest
	public void openBrowser() {
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("https://prideview-core.traclabs.com");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

	}

	@Test

	public void InvalidTest() throws IOException {
		String pageTitle = driver.getTitle();
		driver.findElement(By.name("username")).sendKeys("test");
		driver.findElement(By.name("password")).sendKeys("test1");
		driver.findElement(By.xpath(".//*[@id='LoginForm']/div[3]/div/div/span[2]/button")).click();

		if (pageTitle.equals("PrideView Dashboard")) {
			System.out.println("Login successful");
			getScreenShot();
		}

		else if (pageTitle.equals("PrideView Login")) {
			System.out.println("Invalid Login");
			getScreenShot();

		}
	}
	// public void InvalidTest() throws IOException {
	// try {
	// driver.findElement(By.name("username")).sendKeys("test");
	// driver.findElement(By.name("Password")).sendKeys("test1");
	// driver.findElement(By.xpath(".//*[@id='LoginForm']/div[3]/div/div/span[2]/button")).click();
	// }
	//
	// catch (Exception e) {
	// System.out.println("Control now is in Catch Block");
	// getScreenShot();
	// }
	//
	// }

	public void getScreenShot() throws IOException {
		File ss = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(ss,
				new File("C:\\Users\\TRACLabs\\Documents\\AutomationRegression\\JenkinsDemo\\screen3.jpg"));
	}

	@AfterTest
	public void closeBrowser() {
		driver.quit();
	}
}
