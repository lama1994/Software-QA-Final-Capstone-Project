import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class CreateNewOrderTS_3 {
	public WebDriver driver;
	
	/**
	 * Set up browser
	 */
	@BeforeSuite
	public void setUp() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","//Users//lama//Desktop//Selenium//chromedriver");
		driver = new ChromeDriver();

		driver.navigate().to("https://www.al-dawaa.com/english/");
		driver.manage().window().maximize();
		Thread.sleep(2000);
	}
	
	/**
	 * Sign in to the website
	 */
	@BeforeTest
	public void singIn() throws InterruptedException {
		WebElement singIn = driver.findElement(By.xpath("/html/body/div[2]/header/div[2]/div/ul/li[2]/a"));
		singIn.click();
		Thread.sleep(7000);
		
		WebElement username = driver.findElement(By.xpath("//input[@id='email']"));
		username.sendKeys("lama.1431@hotmail.com");
		Thread.sleep(2000);
		
		WebElement password = driver.findElement(By.xpath("//input[@id='pass']"));
		password.sendKeys("lm@987654");
		Thread.sleep(2000);
		
		WebElement logIn = driver.findElement(By.id("send2"));
		logIn.click();
		Thread.sleep(7000);
	}
	
	@Test(priority = 1, groups = {"Create New Order" }, 
			testName = "Test if the user add items in cart",
			description = "Verify if the user can add any items in carts successfully")
	public void TC_07() throws InterruptedException {
		
		WebElement Medicine = driver.findElement(By.xpath("//*[@id=\"store.menu\"]/section[2]/nav/ul/li[6]/a"));
		Medicine.click();
		Thread.sleep(4000);
		
		
		WebElement product = driver.findElement(By.xpath("//*[@id=\"amasty-shopby-product-list\"]/div[4]/ol/li[1]/div/div[2]/strong/a"));
		product.click();
		Thread.sleep(4000);
		
		WebElement addToCart = driver.findElement(By.xpath("//*[@id=\"product-addtocart-button\"]"));
		addToCart.click();
		Thread.sleep(4000);
	}
	
	
	@Test(priority = 2, groups = {"Create New Order" }, 
			testName = "Test if the user can add item in favorites list to buy it later",
			description = "Verify if the user can add item in favorites list to buy it later")
	public void TC_09() throws InterruptedException {

		WebElement Medicine = driver.findElement(By.xpath("//*[@id=\"store.menu\"]/section[2]/nav/ul/li[6]/a"));
		Medicine.click();
		Thread.sleep(7000);
		
		
		WebElement product = driver.findElement(By.xpath("//*[@id=\"amasty-shopby-product-list\"]/div[4]/ol/li[3]/div/div[2]/strong/a"));
		product.click();
		Thread.sleep(7000);
		
		WebElement heartIcon = driver.findElement(By.cssSelector("#maincontent > div.algolia-instant-results-wrapper > div.columns.algolia-instant-replaced-content > div.column.main > div.product-info-main > div.product-social-links > div > a.action.towishlist"));
		heartIcon.click();
		Thread.sleep(7000);
	}
	
	/**
	 * log out from website
	 */
	@AfterTest
	public void singOut() throws InterruptedException {
		WebElement singOut = driver.findElement(By.xpath("/html/body/div[2]/header/div[2]/div/ul/li[2]/a"));
		singOut.click();
		Thread.sleep(4000);
	}

	
	@AfterSuite
	public void closeBrowser() throws InterruptedException {
		driver.close();
		// Close the browser
		driver.close();

		// Quit the browser
		driver.quit();
	}
	
}
