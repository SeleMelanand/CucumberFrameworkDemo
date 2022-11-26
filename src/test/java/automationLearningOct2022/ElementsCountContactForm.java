package automationLearningOct2022;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ElementsCountContactForm {

	@Parameters({ "url" })
	@Test(groups = { "smokeTest" })
	public void elementsCount(String url) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		RemoteWebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get(url);
		driver.findElement(By.xpath("//a[text()='Contact Us']")).click();
		Thread.sleep(2000);
		List<WebElement> eleLis = driver.findElements(By.xpath("//h3[text()='Contact Form']/..//input"));
		System.out.println(eleLis.size());
	}

}
