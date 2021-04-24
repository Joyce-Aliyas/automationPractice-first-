package Firstmavenproject.testNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

public class DemoQA {

	WebDriver driver;

	@BeforeMethod
	public void berfore() {
		WebDriverManager.edgedriver().setup();
		driver = new EdgeDriver();
		driver.get("https://demoqa.com/");
		driver.manage().window().maximize();
	}

	@Test
	public void elementOnHomePage() {
		WebElement element = driver.findElement(By.cssSelector("div[class='avatar mx-auto white']"));
		element.click();
	}

	@Test
	public void checkBox() {
		WebElement checkBox = driver.findElement(By.cssSelector("svg[class='rct-icon rct-icon-check']"));
		checkBox.click();
	}

	@AfterMethod
	public void after() {
		driver.close();
	}

}
