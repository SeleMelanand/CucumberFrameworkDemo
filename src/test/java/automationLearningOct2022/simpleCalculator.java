package automationLearningOct2022;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class simpleCalculator {

	@Test
	public void addNumbers() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		RemoteWebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		driver.get("https://testsheepnz.github.io/BasicCalculator.html");
		
		WebElement build = driver.findElement(By.id("selectBuild"));
		Select buildOption = new Select(build);
		buildOption.selectByVisibleText("1");

		
		driver.findElement(By.id("number1Field")).sendKeys("10");
		driver.findElement(By.id("number2Field")).sendKeys("12");
		
		WebElement operationType = driver.findElement(By.id("selectOperationDropdown"));
		Select operation = new Select(operationType);
		operation.selectByVisibleText("Add");
		
		driver.findElement (By.id("calculateButton")).click();
		
		Thread.sleep(5000);
		WebElement ansElement= driver.findElement(By.id("numberAnswerField"));
				
		Actions act = new Actions(driver);
		act.doubleClick(ansElement).perform();
		act.keyDown(Keys.CONTROL);
		act.sendKeys("c");
		act.keyUp(Keys.CONTROL);
		act.build().perform();
		
		
		
		String abcd = ansElement.getAttribute("type");
		System.out.println(abcd);
		String actualCalculatedValue = driver.findElement(By.id("numberAnswerField")).getText();
		System.out.println("calculated Value :: "+ actualCalculatedValue);
		
	
	}
		
	}
