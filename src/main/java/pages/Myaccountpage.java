package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utilities.Driverhelper;
import utilities.Eventhelper;

public class Myaccountpage {

	WebDriver driver = Driverhelper.getDriver();

	By accountDetailsLabel = By.xpath("//div[@class='box-content']//p");

	public boolean WaitTillSuccessMessage(String message) {
		return Eventhelper.isElementDisplayed(driver, By.xpath("//div[text()='" + message + "']"));
	}

	public String[] getAccountDetails() {
		String accountDetails = Eventhelper.getText(driver, accountDetailsLabel);

		return accountDetails.split("\n");
	}

}
