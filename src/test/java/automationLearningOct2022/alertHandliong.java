package automationLearningOct2022;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class alertHandliong {
	@Test
	public void method1() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		RemoteWebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		driver.get("https://letcode.in/alert");
		
		driver.findElement(By.id("modern123")).click();
		Thread.sleep(3000);
		
		driver.switchTo().alert().accept();
		
		
		driver.findElement(By.id("accept")).click();
		
		Thread.sleep(3000);
		//alert handling
		driver.switchTo().alert().accept();
		
		driver.findElement(By.id("confirm")).click();
		Thread.sleep(3000);
		driver.switchTo().alert().dismiss();
		
		/*
		 * driver.findElement(By.id("prompt")).click(); Thread.sleep(5000);
		 * 
		 * driver.switchTo().alert().sendKeys("welcome to Ocean academy");
		 */
		
		

	}
}
