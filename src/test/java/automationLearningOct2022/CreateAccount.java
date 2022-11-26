package automationLearningOct2022;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateAccount {

	@Test
	public void createAcc() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		RemoteWebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		driver.get("http://automationpractice.com/index.php");
		boolean value = driver.findElement(By.className("login")).isDisplayed();
		SoftAssert assertObj = new SoftAssert();

		assertObj.assertEquals(value, false);

		Assert.assertEquals(value, true);

		driver.findElement(By.className("login")).click();

		boolean data = driver.findElement(By.id("email_create")).isDisplayed();
		assertObj.assertEquals(data, false);
		driver.findElement(By.id("email_create")).sendKeys("qwe23434");
		driver.findElement(By.id("SubmitCreate")).click();
		Thread.sleep(5000);
		String errorValue = driver.findElement(By.id("create_account_error")).getText();
		System.out.println(errorValue);

		Assert.assertEquals(errorValue, "Invalid email address.");

		assertObj.assertAll();
		/*
		 * WebElement days = driver.findElement(By.id("days")); Select daySelection =
		 * new Select(days); daySelection.selectByValue("12");
		 * 
		 * WebElement months = driver.findElement(By.id("months")); Select
		 * monthSelection = new Select(months); monthSelection.selectByValue("10");
		 */

	}

}
