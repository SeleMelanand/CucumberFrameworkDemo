package automationLearningOct2022;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class UseDataFromExcel extends WrapperClass {

	public String testDataExcelPath = "./testdata/sampleTestdata.xlsx";

	@DataProvider(name = "nametobecalled")
	public Object[][] sendData() throws IOException {


		return ReadDataFromExcel.excelRead(testDataExcelPath);
	}

	@Test(dataProvider = "nametobecalled")
	public void printTestdata(String regEmail, String passCode)
			throws InterruptedException, IOException {
		System.out.println(regEmail);
		System.out.println(passCode);
		driver.get("https://www.tournamentsoftware.com/");
		Thread.sleep(2000);

		driver.findElement(By.xpath("(//button[@type='submit'])[1]")).click();
		driver.findElement(By.xpath("//span[text()='Log In']")).click();
		Thread.sleep(3000);

		driver.findElement(By.id("Login")).sendKeys(regEmail);
		driver.findElement(By.id("Password")).sendKeys(passCode);

		Thread.sleep(3000);
		System.out.println("Data entered successfully");

	}

}
