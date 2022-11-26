package automationLearningOct2022;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class UpdateLambdaTestAcc {

	@Test
	public void acclogin() throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		RemoteWebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		driver.get("https://ecommerce-playground.lambdatest.io/index.php?route=account/login");

		Actions act = new Actions(driver);
		act.moveToElement(driver.findElement(By.xpath("(//span[@class='title'])[32]"))).build().perform();

		driver.findElement(By.xpath("(//span[@class='title'])[33]")).click();
		driver.findElement(By.id("input-email")).sendKeys("sampletest001@gmail.com");
		driver.findElement(By.id("input-password")).sendKeys("Qwerty@0000");
		driver.findElement(By.xpath("//input[@class='btn btn-primary']")).click();
	}

}
