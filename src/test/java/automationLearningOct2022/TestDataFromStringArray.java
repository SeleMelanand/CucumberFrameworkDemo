package automationLearningOct2022;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestDataFromStringArray extends WrapperClass {


	@DataProvider(name = "ocean")
	public Object[][] getTestdata() {
		
		String[][] employee = new String[1][2];
		
		employee[0][0] = "registeredemail001@gemail.com";
		employee[0][1] = "1";
	
		return employee;
	}

	
	@Test(dataProvider = "ocean")
	public void enterDataUsingString(String regEmail, String passCode) throws InterruptedException {
		
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
