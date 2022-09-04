# Software QA Final Capstone Project
Software QA Final Capstone Project for Track 3 - SDA - Software QA Bootcamp
# Introduction
I decide to use in the Software QA Final Capstone Project Al-dawaa website for testing using Selenium and TestNG framework.
# Codes And Screenshot
## Code Details
### In the project we created 2 classes depending on the function of our website which are:
- Sing In: SingInTS_1
- Create new order: CreateNewOrderTS_3
## SingInTS_1 class
It for Sing In function and it contain 3 Test cases:
Test case TC_01:
```
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
```
Test case TC_02:
```
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
		
		AssertJUnit.assertEquals(e, "The account sign-in was incorrect or your account is disabled temporarily. Please wait and try again later.");
	}
```
Test case TC_03:
```
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
		
		AssertJUnit.assertEquals(e, "This is a required field.");
	}
```
** The code run will be in document I submit it ** 
<img width="1363" alt="Screen Shot 1444-02-08 at 8 22 41 AM" src="https://user-images.githubusercontent.com/37514953/188302598-08024cd5-3ca2-4d3e-a454-653026d9b36d.png">

## CreateNewOrderTS_3 class
It for Create New Order function and it contain 2 Test cases:
Test case TC_07:
```
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
```
Test case TC_09:
```
public void TC_09() throws InterruptedException {

		WebElement Medicine = driver.findElement(By.xpath("//*[@id=\"store.menu\"]/section[2]/nav/ul/li[6]/a"));
		Medicine.click();
		Thread.sleep(7000);
		
		
		WebElement product = driver.findElement(By.cssSelector("#amasty-shopby-product-list > div.products.wrapper.grid.products-grid.amscroll-page > ol > li:nth-child(5) > div > div.product.details.product-item-details > strong > a"));
		product.click();
		Thread.sleep(7000);
		
		WebElement heartIcon = driver.findElement(By.cssSelector("#maincontent > div.algolia-instant-results-wrapper > div.columns.algolia-instant-replaced-content > div.column.main > div.product-info-main > div.product-social-links > div > a.action.towishlist"));
		heartIcon.click();
		Thread.sleep(7000);
	}
```
** The code run will be in document I submit it ** 
<img width="1367" alt="Screen Shot 1444-02-08 at 8 28 11 AM" src="https://user-images.githubusercontent.com/37514953/188302681-28d4ccb5-5894-4f1c-a61c-b0fd4f7abbb4.png">

## XML file 
To run the 2 classes as parallel using 2 threads.
```
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE suite SYSTEM "https://testng.org/testng-1.0.dtd">
<suite name="Suite"  parallel="classes">
  <test thread-count="2" name="Test">
    <classes>
      <class name="testCase.SingInTS_1"/>
      <class name="testCase.CreateNewOrderTS_3"/>
    </classes>
  </test> <!-- Test -->
</suite> <!-- Suite -->
```

** The code run will be in document I submit it ** 


