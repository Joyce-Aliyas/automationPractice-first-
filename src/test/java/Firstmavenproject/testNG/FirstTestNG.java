package Firstmavenproject.testNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FirstTestNG {
	WebDriver driver;

	@BeforeMethod
	public void before() {
		WebDriverManager.edgedriver().setup();
		driver = new EdgeDriver();
		driver.get("https://www.bing.com/");
	}

	@Test
	public void getEdgeTitle() {
		System.out.println("Page title is: "+driver.getTitle());
		WebElement inputSearch=driver.findElement(By.cssSelector("input[class='sb_form_q']"));
		inputSearch.sendKeys("Toyota");
	} 

	@AfterMethod
	public void after() {
		//driver.quit();

	}

}
