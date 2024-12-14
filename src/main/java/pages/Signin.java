package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utilities.Driverhelper;
import utilities.Eventhelper;

public class Signin {

	By emailTextfield = By.id("email");
	By passwordTextfield = By.id("pass");
	By SignInbtn = By.xpath("//button[contains(@class,'primary')]/span");

	WebDriver driver = Driverhelper.getDriver();

	CommonOperations commonoperations = new CommonOperations();

	public void doLogin(String email, String password) {
		Eventhelper.sendkeys(driver, emailTextfield, email);
		Eventhelper.sendkeys(driver, passwordTextfield, password);
		Eventhelper.click(driver, SignInbtn);
	}

}
