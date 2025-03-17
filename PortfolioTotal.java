package Meroshare;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class PortfolioTotal extends BaseSetup {
	
	@Test
	public static void Portfoliototal() throws InterruptedException {
		// Click on MyPortfolio
				driver.findElement(By.xpath("(//span[contains(text(),'My Portfolio')])[1]")).click();
				
				System.out.println("My Portfolio Clicked");
//				String total = driver.findElement(By.cssSelector("body > app-dashboard:nth-child(2) > div:nth-child(3) > main:nth-child(3) > div:nth-child(1) > app-my-portfolio:nth-child(2) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > table:nth-child(1) > tbody:nth-child(3) > tr:nth-child(1) > td:nth-child(4)")).getText();
				String find = driver.findElement(By.xpath("//td[contains(text(),'Rs.')][2]")).getText();
				
				//		String total = driver.findElement(By.xpath("//body[1]/app-dashboard[1]/div[1]/main[1]/div[1]/app-my-portfolio[1]/div[1]/div[2]/div[1]/div[1]/table[1]/tbody[2]/tr[1]/td[4]")).getText();
				System.out.println("Total Valuation: "+find);
				
				Thread.sleep(10000);
				driver.close();
	}
}
