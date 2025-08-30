package AmazonTestPackage;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
//Test method for searching and adding an iPhone on Amazon
public class AppleProgram {
	@Test
	 public void testAppleDevice() throws InterruptedException {
		// Launch Microsoft Edge browser
		 WebDriver driver = new EdgeDriver();
		 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		try {
			// Clear all cookies before starting the test
		driver.manage().deleteAllCookies();
		 // Navigate to Amazon home page
		driver.get("https://www.amazon.com");
		Thread.sleep(5000);// static wait
		// Maximize browser window
		driver.manage().window().maximize();
		// Open location popup
		driver.findElement(By.xpath("//span[@id='nav-global-location-data-modal-action']")).click();
		  // Enter pincode into location box
		WebElement pincodeBox =wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='GLUXZipUpdateInput']"))) ;
		pincodeBox.clear();
		pincodeBox.sendKeys("98811");
		 // Click apply pincode button
		driver.findElement(By.xpath("//input[@aria-labelledby='GLUXZipUpdate-announce']")).click();
		   // Confirm location popup
		WebElement confirmLocation = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='a-popover-footer']//input[@id='GLUXConfirmClose']"))
				);
		confirmLocation.click();
		Thread.sleep(2000);
		 // Locate the search box and search for "iPhone"
		WebElement searchBoxs= wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.name("field-keywords")));
		searchBoxs.sendKeys("iPhone");
		searchBoxs.submit();
		// Select a specific iPhone from search results
		WebElement iphoneSelect= wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//h2[@aria-label='Apple iPhone 14, 128GB, Midnight - Unlocked (Renewed)']")));
		iphoneSelect.click();
		 // Retrieve the price of the iPhone (whole + fraction)
		String whole= driver.findElement(By.cssSelector("div[id='newAccordionRow_0'] div[role='button'] span[class='a-price-whole']")).getText();
		String fraction = driver.findElement(By.cssSelector("div[id='newAccordionRow_0'] div[role='button'] span[class='a-price-fraction']")).getText();
		String price= "$" + whole + "." + fraction; 
		 // Print the price in console
		System.out.println("Price of Iphone" + price);
		 // Click "Add to Cart"
		driver.findElement(By.xpath("//div[@id='a-accordion-auto-0']//input[@id='add-to-cart-button']")).click();
		 // If Amazon shows protection plan popup, select "No Protection"
		WebElement noProtection = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@aria-labelledby='attachSiNoCoverage-announce']")));
		noProtection.click();
		}finally {
			 // Close browser at the end of the test
			Thread.sleep(20000);
			driver.quit();
		}
	}

}
