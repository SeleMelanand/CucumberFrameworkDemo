package automationLearningOct2022;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class EmailAssertOceaAcademy{
	@Parameters({ "url" })
	@Test(groups={"smokeTest"})
	public void validateEmail(String url) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		RemoteWebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get(url);
			driver.findElement(By.xpath("//a[text()='Contact Us']")).click();
			Thread.sleep(2000);
			String runTimeValue = driver.findElement(By.xpath("(//div[@class='contactUs']//p)[2]")).getText();
			System.out.println(runTimeValue);
			Assert.assertEquals("infooceanacademy@oceanacademy.in", runTimeValue);
	}

}
