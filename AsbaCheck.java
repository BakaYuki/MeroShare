package Meroshare;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class AsbaCheck extends BaseSetup {
	
//	@Test
	public static void AllotmentCheck() throws InterruptedException {
		System.out.println("Allotment Check");
		
		//MYASBA Click
		driver.findElement(By.cssSelector("a[href='#/asba']")).click();
		
		// Application Report Click
		driver.findElement(By.xpath("//main[@id='main']//li[3]//a[1]")).click();
		Thread.sleep(2000);
		
		// Clicking on Report
		driver.findElement(By.xpath("(//button[@type='button'])[6]")).click();
//		
		Thread.sleep(5000);
        WebElement label = driver.findElement(By.xpath("(//div[@class='input-group'])[7]"));
        String labelText = label.getText();

        // Print the text
        System.out.println("Label Text: " + labelText);



		
		// Getting the status
//		List<WebElement> labels = driver.findElements(By.xpath("//div[contains(@class, 'input-group')]/label"));
//		WebElement statusLabel = labels.get(6);
//		String StatusText = "";
//		StatusText =  statusLabel.getText();
//		System.out.println("Status: " + StatusText);
//		String text = "";
//		for (WebElement label : labels) {
//		    text = label.getText();
//		    System.out.println("Status: " + text);
//		}
		
	}
	@Test
	public static void AllotCheckLoop() throws InterruptedException{
		for (int i =6; i<=35;i++) {
			//MYASBA Click
			driver.findElement(By.cssSelector("a[href='#/asba']")).click();
			
			// Application Report Click
			driver.findElement(By.xpath("//main[@id='main']//li[3]//a[1]")).click();
			Thread.sleep(2000);
			
			driver.findElement(By.xpath("(//button[@type='button'])["+i+"]")).click();
			Thread.sleep(5000);
			
			WebElement label = driver.findElement(By.xpath("(//div[@class='input-group'])[7]"));
	        String labelText = label.getText();

	        // Print the text
	        System.out.println("Label Text: " + labelText);
			
			
			//Navigate Back
			driver.navigate().back();

		}
        
	}

}
