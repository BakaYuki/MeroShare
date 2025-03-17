package Meroshare;

import java.time.Duration;
import static Meroshare.logindetails.*;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseSetup 
{
	public static String url="https://meroshare.cdsc.com.np";
	public static ChromeDriver driver;
	public static String crno = crn;
	public static String pinno = pin;
	
	@BeforeSuite
	public static void DriverSetup() throws InterruptedException 
	{
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();	
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().window().maximize();
		Thread.sleep(2000);

		driver.findElement(By.xpath("//span[@class='select2-selection__placeholder']")).click(); //sendKeys("19000")
		driver.findElement(By.cssSelector(".select2-search__field")).sendKeys("11000",Keys.ENTER);
		
		//login username and password
		driver.findElement(By.id("username")).sendKeys(username);
		driver.findElement(By.id("password")).sendKeys(password);
		//click on login button
		driver.findElement(By.cssSelector("button[type='submit']")).click();
		

		

	}
	
	
}