package Firstmavenproject.testNG;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ById;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ContactUsForm {
	WebDriver driver;

	@BeforeMethod
	public void before() {
		WebDriverManager.edgedriver().setup();
		driver = new EdgeDriver();
		driver.get("http://automationpractice.com/index.php");
		driver.manage().window().maximize();
	}

	@Test
	public void contactUs() {
		WebElement contactUs = driver.findElement(By.cssSelector("a[title='Contact Us']"));
		contactUs.click();
		WebElement subjectInput = driver.findElement(By.id("uniform-id_contact"));
		subjectInput.click();
		Select selectSubject = new Select(driver.findElement(By.id("id_contact")));
		selectSubject.selectByValue("1");
		WebElement emailAddress = driver.findElement(By.id("email"));
		emailAddress.sendKeys("joycetesting0@gmail.com");
		WebElement orderReference = driver.findElement(By.id("id_order"));
		orderReference.sendKeys("123");
		WebElement attachFile = driver.findElement(By.id("fileUpload"));
		attachFile.sendKeys("C:\\Users\\Administrator\\Documents\\New TestPageUploadAutomationPractice.docx");
		WebElement messageBox = driver.findElement(By.cssSelector("textarea[name='message']"));
		messageBox.sendKeys("Hello");
		WebElement sendButton = driver.findElement(By.id("submitMessage"));
		sendButton.click();
		WebElement successMessage = driver.findElement(By.cssSelector("p[class='alert alert-success']"));
		String sendMessage = successMessage.getText();
		Assert.assertEquals(sendMessage, "Your message has been successfully sent to our team.");
	}

	@AfterMethod
	public void after() {
		driver.quit();
	}
}
