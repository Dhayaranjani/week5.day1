package week5.day1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;
/*Assignment:1 (Leaftaps Application)
=======================
1. Create BaseClass with preCondition() and postCodition() with @BeforeMethod and @AfterMethod
2. Move the common code from all the 5 testcases into preCondition() and postCondition()
3. Extend all the 5 test cases with BaseClass and execute sequentially and parallely using testng.xml*/

public class MyBaseClass {
	
	public ChromeDriver driver;
	
	@BeforeMethod
	public void preCondition() {
		//setup chromedriver
		WebDriverManager.chromedriver().setup();
		//Create an object for the Chromedriver
		driver = new ChromeDriver();
		//1. Launch the URL
		driver.get("http://leaftaps.com/opentaps/control/main");
		//maximize the browser window
		driver.manage().window().maximize();
		//Identify WebElement
		//2. Enter UserName and Password Using Id Locator
		WebElement eleUserName = driver.findElement(By.id("username"));
		eleUserName.sendKeys("DemoSalesManager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		//3. Click on Login Button using Class Locator 
		driver.findElement(By.className("decorativeSubmit")).click();
	}
	
	@AfterMethod
	public void postCondition() {
		driver.close();
	}
	
}
