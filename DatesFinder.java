package Meroshare;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class DatesFinder extends BaseSetup{
	@Test
	public static void dematexpiryfinder() throws InterruptedException{
		// My Profile Click
		driver.findElement(By.xpath("//div[@class='profile-image']//img")).click();
		WebElement expiryDateElement = driver.findElement(By.xpath("//span[text()='Demat Expiry Date']/following-sibling::span[@class='account-info__date']"));

//		WebElement expiryDateElement = driver.findElement(By.xpath("//span[text()='Meroshare Expiry Date']/following-sibling::span[@class='account-info__date']"));

		// Get the dynamic text
		String expiryDate = expiryDateElement.getText();
		System.out.println("Demat Expiry Date: "+ expiryDate); 
	}
	@Test
	public static void meroshareexpiryfinder() throws InterruptedException{
		// My Profile Click
		driver.findElement(By.xpath("//div[@class='profile-image']//img")).click();
		
		WebElement expiryDateElement = driver.findElement(By.xpath("//span[text()='Meroshare Expiry Date']/following-sibling::span[@class='account-info__date']"));

		// Get the dynamic text
		String expiryDate = expiryDateElement.getText();
		System.out.println("MeroShare Expiry Date: "+ expiryDate); 
	}
	@Test
	public static void accountinfofinder() throws InterruptedException{
		// My Profile Click
		driver.findElement(By.xpath("//div[@class='profile-image']//img")).click();
		
		WebElement accountCreated = driver.findElement(By.xpath("//span[text()='Account Created Date']/following-sibling::span[@class='account-info__date']"));
		WebElement accountRenewed = driver.findElement(By.xpath("//span[text()='Account Renewed Date']/following-sibling::span[@class='account-info__date']"));
		WebElement passwordexpiry = driver.findElement(By.xpath("//span[text()='Password Expiry Date']/following-sibling::span[@class='account-info__date']"));
		
		// Get the dynamic text
		String accountCreatedDate = accountCreated.getText();
		String accountRenewedDate = accountRenewed.getText();
		String passwordexpiryDate = passwordexpiry.getText();
		System.out.println("Account Created Date: "+ accountCreatedDate); 
		System.out.println("Account Renewed Date: "+ accountRenewedDate); 
		System.out.println("Password Expiry Date: "+ passwordexpiryDate); 
	}
}
