package AmazonTestPackage;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class SamsungProgram {
	@Test
	public void testGalaxyDevice() throws InterruptedException {
		 // Launch Edge browser
		 WebDriver driver = new EdgeDriver();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		try {
			 // Clear cookies to start fresh
			driver.manage().deleteAllCookies();
			// Open Amazon homepage
		driver.get("https://www.amazon.com/");
		Thread.sleep(5000);// Static wait to ensure page loads
		 // Maximize browser window
		driver.manage().window().maximize();
		  // Open location selection popup
driver.findElement(By.xpath("//span[@id='nav-global-location-data-modal-action']")).click();
// Enter Pin code in the location box
		WebElement pincodeBox =wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='GLUXZipUpdateInput']"))) ;
		pincodeBox.clear();
		pincodeBox.sendKeys("98811");
		// Apply the Pin code
		driver.findElement(By.xpath("//input[@aria-labelledby='GLUXZipUpdate-announce']")).click();
		 // Confirm the location change
		WebElement confirmLocation = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='a-popover-footer']//input[@id='GLUXConfirmClose']"))
				);
		
		confirmLocation.click();
		Thread.sleep(2000);
		 // Search for Galaxy phones in the search bar
		WebElement searchBox= driver.findElement(By.name("field-keywords"));
		searchBox.sendKeys("Galaxy");
		searchBox.submit();
		// Select a specific Galaxy model from search results
		WebElement galaxySelect= wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(text(),'Galaxy S25 Ultra, 512GB Smartphone, Unlocked Andro')]")));
		galaxySelect.click();
		 // Fetch the price (whole part + fraction)
		String whole= driver.findElement(By.cssSelector("div[id='newAccordionRow_0'] div[role='button'] span[class='a-price-whole']")).getText();
		String fraction = driver.findElement(By.cssSelector("div[id='newAccordionRow_0'] div[role='button'] span[class='a-price-fraction']")).getText();
		String price= "$" + whole + "." + fraction; 
		 // Print price in console
		System.out.println("Price of Galaxy" + price);
		// Click "Add to Cart" button
		driver.findElement(By.xpath("//div[@id='a-accordion-auto-0']//input[@id='add-to-cart-button']")).click();
		 // Handle warranty/protection popup → choose "No Protection"
		WebElement noProtection = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@aria-labelledby='attachSiNoCoverage-announce']")));
		noProtection.click();
		}
		finally {
			// Keep browser open for observation before closing
			Thread.sleep(20000);
			  // Close browser
			driver.quit();
		}
	}

}
