package RunScriptUsingJenkins;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ArrayListOfCheckBoxWebElement {
	
	WebDriver driver;

	@BeforeTest

	public void openBrs() {
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("https://prideview-core.traclabs.com");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.name("username")).sendKeys("test");
		driver.findElement(By.name("password")).sendKeys("test");
		driver.findElement(By.xpath(".//*[@id='LoginForm']/div[3]/div/div/span[2]/button")).click();

	}

	@Test(priority = 0)

	 public void runProcedure() {
	 driver.findElement(By.xpath("html/body/div[1]/ul/li[1]/a")).click();
	// driver.findElement(By.linkText("Available")).click();
	// available tab
	 driver.findElement(By.cssSelector("button[role='button']")).click();
//	 Reset button
	 driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	 driver.findElement(By.xpath(".//*[@id='AvailableProcedures']/div/div/div/div[3]/div[2]/div/div")).click();
	// testing directory
	 driver.findElement(By.xpath(".//*[@id='AvailableProcedures']/div/div/div/div[3]/div[2]/ul/li[9]/div/div/div"))
	 .click();
	// jenkins test folder
	 driver.findElement(By
	 .xpath(".//*[@id='AvailableProcedures']/div/div/div/div[3]/div[2]/ul/li[9]/div/ul/li[17]/div/div/div[1]"))
	 .click();
	// oneofeach procedure
	 driver.findElement(By
	 .xpath(".//*[@id='AvailableProcedures']/div/div/div/div[3]/div[2]/ul/li[9]/div/ul/li[17]/div/div/div[1]/span[3]"))
	 .click();
	// run icon
	 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	 driver.switchTo().frame("procedureFrame");
	 
//	 JavascriptExecutor js = (JavascriptExecutor)driver;
//	 js.executeScript ("document.getElementBycssSelector(div.checkbox).focus()");
	 
//	 driver.findElement(By.cssSelector("div[data-countable='true']")).click();
//	 driver.findElement(By.cssSelector("div.checkbox")).click();
//	 driver.findElement(By.cssSelector("div.checkbox")).click();
 
	List<WebElement> chBox = driver.findElements(By.className("checkbox"));
	 
		 System.out.println(chBox);
	}
	 
//	 driver.findElement(By.cssSelector("div.instruction")).click();
//	 driver.findElement(By.id("checkbox-548c4fed-d721-4ce1-a235-a08c0a403441")).click();
//	 driver.findElement(By.id("checkbox-548c4fed-d721-4ce1-a235-a08c0a403441")).click();
//	 driver.findElement(By.cssSelector("div.userFocus0")).is();
//	 driver.findElement(By.cssSelector("div#checkbox-3a334303-5f11-4b0b-8fac-171e99fab355")).click();
//	 driver.findElement(By.cssSelector("div#3a334303-5f11-4b0b-8fac-171e99fab355")).click();
//	 System.out.println(driver.findElement(By.id("checkbox-3a334303-5f11-4b0b-8fac-171e99fab355")).isSelected());
	
	 

	// @AfterTest
	// public void closeBrs() {
	// driver.quit();
	// }
	}



