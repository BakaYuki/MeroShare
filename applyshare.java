package Meroshare;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class applyshare extends BaseSetup {
	
	@Test
	public static void applyshare() throws InterruptedException{
		driver.findElement(By.cssSelector("a[href='#/asba']")).click();
		Thread.sleep(2000);
		
		int i = 4;
		while(true) {
			try {
				driver.findElement(By.xpath("(//button[@type='button'])["+i+"]")).click();
				Thread.sleep(2000);
				
				WebElement priceLabel = driver.findElement(By.xpath("//label[contains(text(), 'Price per Share')]"));
		        
		        // Using Relative Locator to find the value below the label
		        WebElement priceValue = driver.findElement(RelativeLocator.with(By.tagName("span")).below(priceLabel));
		        
		        // Get the text value
		        String priceText = priceValue.getText();
		        System.out.println("Price per Share: " + priceText);
				
		        // Check if the price is 100 -> Perform Buy action code
		        if( priceText.equals("100")) {
		        	System.out.println("Applying for 10 shares");
		        	
		        	// For Bank Selection
		        	WebElement bankOption = driver.findElement(By.xpath("//select[@id='selectBank']"));
		        	
		        	//Select Object
		        	Select select = new Select(bankOption);
		        	
		        	// Getting the first option as there is always one option only
		        	WebElement firstOption = select.getOptions().get(1);
		        	String optionText = firstOption.getText();
		        	
		        	select.selectByVisibleText(optionText);
		        	
		        	System.out.println("Selected Bank: " + optionText);
		        	
		            // Same for the Select Account Number
		        	Thread.sleep(3000);
		        	WebElement accountNumber = driver.findElement(By.xpath("//select[@id='accountNumber']"));
		        	System.out.println("Account Number: " + accountNumber);
		        	//Select Object
		        	Select selectacc = new Select(accountNumber);
		        	
		        	// Getting the first option as there is always one option only
		        	WebElement accOption = selectacc.getOptions().get(1);
		        	String accOptionText = accOption.getText();
		        	
		        	selectacc.selectByVisibleText(accOptionText);
		        	
		        	System.out.println("Selected AccountNumber: " + accOptionText);
		        	
		        	// Apply Kitta
		        	driver.findElement(By.id("appliedKitta")).sendKeys("10");
		        	
		        	// CRN Ading
		        	Thread.sleep(3000);
		        	driver.findElement(By.id("crnNumber")).sendKeys(crno);
		        	
		        	// Clicking disclaimer
		        	driver.findElement(By.id("disclaimer")).click();
		        	
		        	// Clicking Proceed
		        	driver.findElement(By.xpath("//*[text()='Proceed']")).click();
		        	
//		        	driver.findElement(By.xpath("//*[contains(text(), 'Proceed')]")).click();
		        	
		        	driver.findElement(By.id("transactionPIN")).sendKeys(pinno);
		        	
		        	Thread.sleep(10000);
		        	// Final Submit
		        	driver.findElement(By.xpath("//button[span[text()='Apply ']]")).click();
		        			        	
		        }
								
				driver.navigate().back();
				i++;
				Thread.sleep(2000);
			} catch (Exception e) {
				break;
			}
		}
		
		Thread.sleep(10000);
		driver.close();
	}
}
