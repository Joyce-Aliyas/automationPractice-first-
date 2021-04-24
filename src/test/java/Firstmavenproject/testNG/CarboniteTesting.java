package Firstmavenproject.testNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CarboniteTesting {
	private static final String priority = null;
	WebDriver driver;

	@BeforeMethod
	public void before() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://demoqa.com/");
		driver.manage().window().maximize();
	}

	@Test(priority = 1)
	public void titleOfPage() {
		System.out.println("Page title is: " + driver.getTitle());
		Assert.assertEquals(driver.getTitle(), "ToolsQA");

	}

	@Test(priority = 2)
	public void elementOnHomePage() {

		WebElement element = driver.findElement(By.cssSelector("div[class='avatar mx-auto white']"));
		element.click();
	}
	@Test(priority=3)
	public void clickTextBox() {
		
		WebElement element = driver.findElement(By.cssSelector("div[class='avatar mx-auto white']"));
		element.click();
		
		WebElement textBox = driver.findElement(By.cssSelector("span[class='text']"));
		textBox.click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// Assert.assertEquals(textBox.click(), false);

	}
	
	public void inputTextBox() {
		
	}

	@AfterMethod
	public void after() {
		driver.quit();

	}

}
