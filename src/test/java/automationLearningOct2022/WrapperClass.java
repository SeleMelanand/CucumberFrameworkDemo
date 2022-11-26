package automationLearningOct2022;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WrapperClass {

	public RemoteWebDriver driver;

	@BeforeMethod
	public void browserOpening() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}

	// @AfterMethod
	public void browserClose() {
		driver.close();
	}

	public String captureScreenshot(){		
		// Taking screenshot
		File source = driver.getScreenshotAs(OutputType.FILE);
		File destination = new File("./snaps/snap" + System.currentTimeMillis() + ".jpg");
		String dest = destination.getAbsolutePath();
		try {
			FileUtils.copyFile(source, destination);
		} catch (IOException e) {
			System.out.println("Exception occured :: "+e);
		}

		return dest;
	}

}
