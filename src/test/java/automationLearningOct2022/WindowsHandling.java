package automationLearningOct2022;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WindowsHandling {
	
	@Test
	public void windowHandle() {
		WebDriverManager.chromedriver().setup();
		RemoteWebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		driver.get("https://www.naukri.com/");	
		
		driver.findElement(By.xpath("//a[@title='Analytics']")).click();
		
		String baseWindow = driver.getWindowHandle();
		System.out.println(baseWindow);
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		Set<String> windowNames = driver.getWindowHandles();
		
		for (String name : windowNames) {
			System.out.println(name);
		}
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		for (String name : windowNames) {
			
			if(!name.equalsIgnoreCase(baseWindow)) {
				driver.switchTo().window(name);
			}
		}
		
		
		
		
		
		String value = driver.findElement(By.xpath("//div[@class='sortAndH1Cont']//h1")).getText();
		System.out.println(value);
		
		
		
	}

	@Test
	public void windowHandle1() {
		WebDriverManager.chromedriver().setup();
		RemoteWebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		driver.get("https://www.goibibo.com");	
		driver.findElement(By.xpath("(//ul[@class='happy-nav']//a)[6]")).click();
		
	}
}
