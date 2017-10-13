package RunScriptUsingJenkins;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Demo1 {
	private WebDriver driver;
//	this is a test comment to see changes

	@Test
	@Parameters("browser")
	public void cbtesting(String browser) {
		if (browser.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		} else if (browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver",
					"C:\\Users\\TRACLabs\\Documents\\Downloads\\chromedriver.exe");
			driver = new ChromeDriver();
		} /*
			 * else if (browser.equalsIgnoreCase("ie")) {
			 * System.setProperty("webdriver.ie.driver",
			 * "C:\\Users\\TRACLabs\\Downloads\\IEDriverServer_x64_2.53.1\\IEDriverServer.exe"
			 * ); driver = new InternetExplorerDriver(); }
			 */
//		added a comment to see changes reflected in central repo
		
		String baseUrl = "https://prideview-core.traclabs.com";
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		driver.get(baseUrl);
		driver.findElement(By.name("username")).sendKeys("test");
		driver.findElement(By.name("password")).sendKeys("test");
		driver.findElement(By.xpath(".//*[@id='LoginForm']/div[3]/div/div/span[2]/button")).click();
		String actualTitle = driver.getTitle();
		String expectedTitle = "PrideView Dashboard";
		System.out.println(driver.getTitle());

	}

}
