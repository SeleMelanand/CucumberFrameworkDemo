package automationLearningOct2022;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.model.Media;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class lambdatestlogin extends WrapperClass {

	@Test
	public void method1() {

		ExtentReports extent = new ExtentReports();

		// ExtentSparkReporter spark123 = new ExtentSparkReporter("./reports/TestReport.html");

		ExtentSparkReporter spark = new ExtentSparkReporter(
				"./reports/TestReport" + System.currentTimeMillis() + ".html");

		extent.attachReporter(spark);

		spark.config().setTheme(Theme.STANDARD);
		spark.config().setDocumentTitle("Automation report");

		ExtentTest test = extent.createTest("Lambda Register Page");
		test.assignAuthor("Anand");
		test.assignCategory("RegrssionTesting");

		boolean testResult = true;

		driver.get("https://ecommerce-playground.lambdatest.io/");
		WebElement myAccount = driver.findElement(By.xpath("(//span[contains(text(),' My account')])[2]"));

		Actions action = new Actions(driver);
		action.moveToElement(myAccount).perform();

		WebElement register = driver.findElement(By.xpath("//span[contains(text(),' Register')]"));
		action.moveToElement(register).click().build().perform();

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions
				.visibilityOfAllElements(driver.findElements(By.xpath("//aside[@id='column-right']//a"))));

		try {
			driver.findElement(By.xpath("//h1235[text()='Register Account']")).isDisplayed();
		} catch (Exception e) {
			testResult = false;
			System.out.println("Exception occured :: ");
		}


		Media snap = MediaEntityBuilder.createScreenCaptureFromPath(captureScreenshot()).build();

		if (testResult == true) {
			test.log(Status.PASS, "train count displayed correctly", snap);
		} else {
			test.log(Status.FAIL, "train count displayed correctly", snap);

		}

		extent.flush();

	}
}
