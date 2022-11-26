package stepDefinition;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import wrapper.Wrapper;

public class LoginWithWrapper extends Wrapper {

	public LoginWithWrapper() throws FileNotFoundException, IOException {
		File fileObj = new File("./src/main/resources/properties/locator.properties");
		FileInputStream fis = new FileInputStream(fileObj);
		prop.load(fis);

		configProp.load(new FileInputStream(new File("./src/main/resources/properties/config.properties")));
	}

	@Given("Launch the url and Navigate to login Page")
	public void launchUrl() {
		browserLaunch(configProp.getProperty("browserToLaunch"), configProp.getProperty("TestURL"));
		// movetoSpecificElementByAction(locateElement("xpath",
		// "(//span[@class='title'])[32]"));
		movetoSpecificElementByAction(locateElement("xpath", prop.getProperty("HomePage.MyAccount.xpath")));

		// click(locateElement("xpath", "(//span[@class='title'])[33]"));
		click(locateElement("xpath", prop.getProperty("HomePage.login.xpath")));

	}

	@Then("Enter valid Username as {string}")
	public void enterUserName(String value) {
		// typeValue(locateElement("id", "input-email"), value);
		typeValue(locateElement("id", prop.getProperty("loginPage.email.id")), value);
	}

	@Then("Enter Password as {string}")
	public void enterPassword(String passCode) {
//		typeValue(locateElement("id", "input-password"), passCode);
		typeValue(locateElement("id", prop.getProperty("loginPage.passWord.id")), passCode);
	}

	@And("Select login button")
	public void selectLogin() {
		// click(locateElement("xpath", "//input[@class='btn btn-primary']"));
		click(locateElement("xpath", prop.getProperty("loginPage.login.xpath")));

	}

}
