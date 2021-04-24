package Firstmavenproject.testNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AutomationAssignment2 {
	WebDriver driver;

	@BeforeMethod
	public void before() {
		WebDriverManager.edgedriver().setup();
		driver = new EdgeDriver();
		driver.get("http://automationpractice.com/index.php");
		// driver.get("http://automationpractice.com/index.php?controller=authentication&back=my-account#account-creation");
		driver.manage().window().maximize();
	}

	@Test
	public void createAccount() {
		// Clicking on sign in button and navigating to create account page
		WebElement signIn = driver.findElement(By.cssSelector("a[class='login']"));
		signIn.click();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// Finding email input box
		WebElement emailInput = driver.findElement(By.id("email_create"));
		// Inputing email id in email input box
		emailInput.sendKeys("joycetesting0@gmail.com");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// Finding create account button and clicking on it
		WebElement createAccount = driver.findElement(By.id("SubmitCreate"));
		createAccount.click();
	}

	@Test
	public void selectGender() {
		driver.get("http://automationpractice.com/index.php?controller=authentication&back=my-account#account-creation");
				

		// Clicking on radio button to select gender
		WebElement radioButtonGender1 = driver.findElement(By.cssSelector("label[for='id_gender1'][class='top']"));
		radioButtonGender1.click();

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Test
	public void firstName() {
		driver.get("http://automationpractice.com/index.php?controller=authentication&back=my-account#account-creation");
		//WebElement firstName=driver.findElement(By.cssSelector("input[id='customer_firstname'][name='customer_firstname']"));
		WebElement firstName=driver.findElement(By.id("customer_firstname"));
		firstName.sendKeys("Joyce");
	}

	@AfterMethod
	public void after() {
		// driver.quit();
	}
}
