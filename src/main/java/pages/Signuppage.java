package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utilities.Driverhelper;
import utilities.Eventhelper;

public class Signuppage {

	WebDriver driver = Driverhelper.getDriver();

	By firstNameTextbox = By.id("firstname");
	By lastNameTextbox = By.id("lastname");
	By emailTextbox = By.id("email_address");
	By passwordTextbox = By.id("password");
	By confirmpasswordTextbox = By.id("password-confirmation");

	public void AddPersonalInformation(String firstname, String lastname) {
		Eventhelper.sendkeys(driver, firstNameTextbox, firstname);
		Eventhelper.sendkeys(driver, lastNameTextbox, lastname);
	}

	public void AddSigninInformation(String email, String password) {
		Eventhelper.sendkeys(driver, emailTextbox, email);
		Eventhelper.sendkeys(driver, passwordTextbox, password);
		Eventhelper.sendkeys(driver, confirmpasswordTextbox, password);
	}

	public boolean waitTillSignuppageLoaded() {
		Eventhelper.findElement(driver, firstNameTextbox);
		return Eventhelper.isElementDisplayed(driver, firstNameTextbox);
	}
	
}
