package trueDevStaging;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginPageTest {

	WebDriver driver;
	
	@BeforeMethod
	public void Setup()
	{
		System.setProperty("webdriver.chrome.driver", "C:/Users/Arasu/Downloads/chromedriver_win32/chromedriver.exe");
		driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("https://dev.truerev.com/");
	}
	
	@Test
	public void LoginTest()
	{
		driver.findElement(By.xpath("//input[@placeholder='Email']")).sendKeys("mthrsn2@gmail.com");
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("Qwerty1234");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		String ActualTitle=driver.getTitle();
		System.out.println(ActualTitle);
		driver.findElement(By.xpath("//i[@class='fas fa-sign-out-alt fa-2x']")).click();
		System.out.println("Successfully Loggedout");
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
	
}
