package Meroshare;

import java.util.List;

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

		
	}
	@Test
	public static void AllotCheckLoop() throws InterruptedException{
		int alloted = 0;
		int verified = 0;
		int notalloted = 0;
		
		
		
		//MYASBA Click
		driver.findElement(By.cssSelector("a[href='#/asba']")).click();
		
		// Application Report Click
		driver.findElement(By.xpath("//main[@id='main']//li[3]//a[1]")).click();
		Thread.sleep(2000);
		
        // Find all elements with the class 'company-list'
        List<WebElement> companyList = driver.findElements(By.className("company-list"));

        // Get the total number of companies
        int totalCompanies = companyList.size();
        totalCompanies = 6 + totalCompanies;
        System.out.println("Total number of companies: " + totalCompanies);
		
		for (int i =6; i<totalCompanies;i++) {
			//MYASBA Click
			driver.findElement(By.cssSelector("a[href='#/asba']")).click();
			
			// Application Report Click
			driver.findElement(By.xpath("//main[@id='main']//li[3]//a[1]")).click();
			Thread.sleep(1000);
			
			driver.findElement(By.xpath("(//button[@type='button'])["+i+"]")).click();
			Thread.sleep(3000);
			
			WebElement label = driver.findElement(By.xpath("(//div[@class='input-group'])[7]"));
	        String statusText = label.getText();
	        if (statusText.equals("Verified")) {
	        	verified +=1;
	        	
	        }
	        else if(statusText.equals("Alloted")) {
	        	alloted +=1;
	        }
	        else {
	        	notalloted +=1;
	        }
	        // Print the text
//	        System.out.println("Label Text: " + statusText);
			
			
			//Navigate Back
			driver.navigate().back();

		}
		System.out.println("Alloted: " + alloted);
		System.out.println("Not Alloted: " + notalloted);
		System.out.println("Verified: " + verified);
        Thread.sleep(5000);
		driver.close();
	}

}
