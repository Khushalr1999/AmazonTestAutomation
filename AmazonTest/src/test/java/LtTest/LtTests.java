package LtTest;

import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Driver;
import java.time.Duration;
import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LtTests {
	@Test
	 public void testAppleDevice() throws InterruptedException {
	
		ChromeOptions browserOptions = new ChromeOptions();
		browserOptions.setPlatformName("Windows 10");
		browserOptions.setBrowserVersion("dev");
		HashMap<String, Object> ltOptions = new HashMap<String, Object>();
		ltOptions.put("username", "rathorekhushal99");
		ltOptions.put("accessKey", "LT_iqH2I8P8vXacjCBKyBO2s0VHnDba04GE7EYqJxkewMu4Zs3");
		ltOptions.put("video", true);
		ltOptions.put("build", "AmazonBuild");
		ltOptions.put("project", "Amazon");
		ltOptions.put("w3c", true);
		ltOptions.put("plugin", "java-java");
		browserOptions.setCapability("LT:Options", ltOptions);
		try {
			WebDriver driver= new RemoteWebDriver(new URL("https://hub.lambdatest.com/wd/hub"), browserOptions);
			 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
			driver.get("https://www.amazon.com");
			driver.findElement(By.xpath("//span[@id='nav-global-location-data-modal-action']")).click();
			
			WebElement pincodeBox =wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='GLUXZipUpdateInput']"))) ;
			pincodeBox.clear();
			pincodeBox.sendKeys("98811");
			driver.findElement(By.xpath("//input[@aria-labelledby='GLUXZipUpdate-announce']")).click();
			WebElement confirmLocation = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='a-popover-footer']//input[@id='GLUXConfirmClose']"))
					);
			confirmLocation.click();
			Thread.sleep(2000);
			WebElement searchBoxs= wait.until(
					ExpectedConditions.visibilityOfElementLocated(By.name("field-keywords")));
			searchBoxs.sendKeys("iPhone");
			searchBoxs.submit();
			WebElement iphoneSelect= wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//h2[@aria-label='Apple iPhone 14, 128GB, Midnight - Unlocked (Renewed)']")));
			iphoneSelect.click();
			String whole= driver.findElement(By.cssSelector("div[id='newAccordionRow_0'] div[role='button'] span[class='a-price-whole']")).getText();
			String fraction = driver.findElement(By.cssSelector("div[id='newAccordionRow_0'] div[role='button'] span[class='a-price-fraction']")).getText();
			String price= "$" + whole + "." + fraction; 
			System.out.println("Price of Iphone" + price);
			driver.findElement(By.xpath("//div[@id='a-accordion-auto-0']//input[@id='add-to-cart-button']")).click();
			WebElement noProtection = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@aria-labelledby='attachSiNoCoverage-announce']")));
			noProtection.click();
			Assert.assertTrue(driver.getTitle().contains("Automation"));
			Thread.sleep(20000);
			driver.quit();
			
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
