package Meroshare;

import java.time.Duration;
import static Meroshare.manylogindetails.*;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class manyacc_applyshare {
	public static String url="https://meroshare.cdsc.com.np";
	public static ChromeDriver driver;
	@Test
	public static void applyshare() throws InterruptedException{
		int numofacc = username.length; // To find number of accounts in array
		// Base Setup for Chrome driver
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();	
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().window().maximize();
		Thread.sleep(2000);
		// Loop for multiple accounts
		for (int a=0;a<numofacc;a++) {
			manyBaseSetup(a);
			
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
						
						// CRN Adding
						Thread.sleep(3000);
						driver.findElement(By.id("crnNumber")).sendKeys(crn[a]);
						
						// Clicking disclaimer
						driver.findElement(By.id("disclaimer")).click();
						
						// Clicking Proceed
						driver.findElement(By.xpath("//*[text()='Proceed']")).click();
						
						driver.findElement(By.id("transactionPIN")).sendKeys(pin[a]);
						
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
			//Click LogOut
			driver.findElement(By.cssSelector(".msi.msi-logout.header-menu__icon")).click();
		}
		
		Thread.sleep(10000);
		driver.close();	
	}

	public static void manyBaseSetup(int a) throws InterruptedException
	{
	
		driver.findElement(By.xpath("//span[@class='select2-selection__placeholder']")).click(); //sendKeys("19000")
		driver.findElement(By.cssSelector(".select2-search__field")).sendKeys(bank[a],Keys.ENTER);
		
		//login username and password
		driver.findElement(By.id("username")).sendKeys(username[a]);
		driver.findElement(By.id("password")).sendKeys(password[a]);
		//click on login button
		driver.findElement(By.cssSelector("button[type='submit']")).click();
		
	}
}
