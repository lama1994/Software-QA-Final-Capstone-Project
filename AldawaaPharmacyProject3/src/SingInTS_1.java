import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class SingInTS_1 {
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
	 * Test sign in to the website
	 * by valid data
	 */
	@Test(priority = 1, groups = {"Sing in" }, 
			testName = "Test if the user can Sign in by valid data",
			description = "Verify if a user will be able to sing in to website with a valid username and valid password")
	public void TC_01() throws InterruptedException {
		
		// click on sign in to go to sing in page
		WebElement singIn = driver.findElement(By.xpath("/html/body/div[2]/header/div[2]/div/ul/li[2]/a"));
		singIn.click();
		Thread.sleep(4000);
		
		// email
		WebElement email = driver.findElement(By.xpath("//input[@id='email']"));
		email.sendKeys("lama.1431@hotmail.com");
		Thread.sleep(2000);
		
		//password
		WebElement password = driver.findElement(By.xpath("//input[@id='pass']"));
		password.sendKeys("lm@987654");
		Thread.sleep(2000);
		
		//Click on log in button
		WebElement logIn = driver.findElement(By.id("send2"));
		logIn.click();
		Thread.sleep(4000);
		
		
		WebElement singOut = driver.findElement(By.xpath("/html/body/div[2]/header/div[2]/div/ul/li[2]/a"));
		singOut.click();
		Thread.sleep(4000);
	}
	
	/**
	 * Test sign in to the website
	 * by invalid data
	 */	
	@Test(priority = 3, groups = {"Sing in" }, 
			testName = "Test if the user cannot Sign in by invalid data",
			description = "Verify if a user cannot sing in to website with a valid username and an invalid password")
	public void TC_02() throws InterruptedException {	
		
		// click on sign in to go to sing in page
		WebElement singIn = driver.findElement(By.xpath("/html/body/div[2]/header/div[2]/div/ul/li[2]/a"));
		singIn.click();
		Thread.sleep(4000);
		
		// email
		WebElement email = driver.findElement(By.xpath("//input[@id='email']"));
		email.sendKeys("lama.1431@hotmail.com");
		Thread.sleep(2000);
		
		//password
		WebElement password = driver.findElement(By.xpath("//input[@id='pass']"));
		password.sendKeys("123459876");
		Thread.sleep(2000);
		
		//Click on log in button
		WebElement logIn = driver.findElement(By.id("send2"));
		logIn.click();
		Thread.sleep(2000);
		
		//error message for invalid data for sing in
		WebElement error = driver.findElement(By.xpath("//div[@data-bind='html: message.text']"));
		boolean d = error.isDisplayed();
		System.out.println("error message "+d);
		String e=error.getText();
		System.out.println("error message "+e);
		
		Assert.assertEquals(e, "The account sign-in was incorrect or your account is disabled temporarily. Please wait and try again later.");
	}
	
	/**
	 * Test confirming the error message when leave Password field blank
	 */
	@Test(priority = 2, groups = {"Sing in" }, 
			testName = "Test confirming the error message when leave Password field blank",
			description = "Verify confirming the error message when leave Password field blank")
	public void TC_03() throws InterruptedException {
		
		WebElement singIn = driver.findElement(By.xpath("/html/body/div[2]/header/div[2]/div/ul/li[2]/a"));
		singIn.click();
		Thread.sleep(4000);
		
		//email
		WebElement email = driver.findElement(By.xpath("//input[@id='email']"));
		email.sendKeys("lama.1431@hotmail.com");
		Thread.sleep(2000);
		
		WebElement logIn = driver.findElement(By.id("send2"));
		logIn.click();
		Thread.sleep(2000);
		
		WebElement error = driver.findElement(By.cssSelector("#pass-error"));
		boolean d = error.isDisplayed();
		System.out.println("error message "+d);
		String e=error.getText();
		System.out.println("error message "+e);
		
		Assert.assertEquals(e, "This is a required field.");
	}
	
	@AfterSuite
	public void closeBrowser() throws InterruptedException {
		// Close the browser
		driver.close();
		
		// Quit the browser
		driver.quit();
	}
	
}
