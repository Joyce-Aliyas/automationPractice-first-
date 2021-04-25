package Firstmavenproject.testNG;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class OrangeHrm {
	WebDriver driver;

	@BeforeMethod
	public void before() {
		WebDriverManager.edgedriver().setup();
		driver = new EdgeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/");
		//driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();

	}

	@Test(priority = 1)

	public void forgotPassword() {
		WebElement forgotPasswordLink = driver.findElement(By.linkText("Forgot your password?"));
		assertEquals(forgotPasswordLink.isEnabled(), true);
		forgotPasswordLink.click();
		// System.out.println(driver.getWindowHandle());
		// Assert.assertEquals(driver.getWindowHandle(),
		// "6A1BC127D77D8D8F4DEBAE7A826DCB7D");
	}

	@Test
	public void validUserNameAndInvalidPaswd() {
		WebElement userNameInput = driver.findElement(By.id("txtUsername"));
		userNameInput.sendKeys("Admin");
		WebElement passwordInput = driver.findElement(By.id("txtPassword"));
		passwordInput.sendKeys("123");
		WebElement loginButton = driver.findElement(By.id("btnLogin"));
		loginButton.click();
		WebElement inavlidMessage = driver.findElement(By.id("spanMessage"));
		inavlidMessage.getText();
		Assert.assertEquals(inavlidMessage.getText(), "Invalid credentials");
	}

	@Test
	public void emptyUsrNameAndPswd() {
		WebElement userNameInput = driver.findElement(By.id("txtUsername"));
		userNameInput.sendKeys("");
		WebElement passwordInput = driver.findElement(By.id("txtPassword"));
		passwordInput.sendKeys("");
		WebElement loginButton = driver.findElement(By.id("btnLogin"));
		loginButton.click();
		WebElement inavlidMessage = driver.findElement(By.id("spanMessage"));
		inavlidMessage.getText();
		Assert.assertEquals(inavlidMessage.getText(), "Username cannot be empty");
	}

	@Test
	public void invalidUsrNameAndPswd() {
		WebElement userNameInput = driver.findElement(By.id("txtUsername"));
		userNameInput.sendKeys("abcd");
		WebElement passwordInput = driver.findElement(By.id("txtPassword"));
		passwordInput.sendKeys("3456");
		WebElement loginButton = driver.findElement(By.id("btnLogin"));
		loginButton.click();
		WebElement inavlidMessage = driver.findElement(By.id("spanMessage"));
		inavlidMessage.getText();
		Assert.assertEquals(inavlidMessage.getText(), "Invalid credentials");
		WebElement userNameInput2 = driver.findElement(By.id("txtUsername"));
		userNameInput2.sendKeys("abcnd");
		WebElement passwordInput2 = driver.findElement(By.id("txtPassword"));
		passwordInput2.sendKeys("34656");
		WebElement loginButton2 = driver.findElement(By.id("btnLogin"));
		loginButton2.click();
		WebElement inavlidMessage2 = driver.findElement(By.id("spanMessage"));
		Assert.assertEquals(inavlidMessage2.getText(), "Invalid credentials");

	}

	@Test
	public void validUsrNameAndPswd() {
		WebElement userNameInput = driver.findElement(By.id("txtUsername"));
		userNameInput.sendKeys("Admin");
		WebElement passwordInput = driver.findElement(By.id("txtPassword"));
		passwordInput.sendKeys("admin123");
		WebElement loginButton = driver.findElement(By.id("btnLogin"));
		loginButton.click();
		Assert.assertEquals(driver.getCurrentUrl(), "https://opensource-demo.orangehrmlive.com/index.php/dashboard");

	}

	@AfterMethod
	public void after() {
		driver.quit();
	}
}
