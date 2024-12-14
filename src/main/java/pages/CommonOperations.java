package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utilities.Driverhelper;
import utilities.Eventhelper;

public class CommonOperations {

	WebDriver driver = Driverhelper.getDriver();

	By CreateAnAccountLink = By.xpath("//a[text()='Create an Account']");
	By homepageTitlelabel = By.xpath("//h1[@class='page-title']");
	By AccountDropdown = By.xpath("//div[@class='panel header']//button[@class='action switch']");

	public void clickOnButton(String buttonName) {
		Eventhelper.click(driver, By.xpath("//button[@title='" + buttonName + "']"));
	}

	public void clickOnLink(String link) {
		Eventhelper.click(driver, By.xpath("//a[contains(text(),'" + link + "')]"));
	}

	public void getUrl(String url) {
		Eventhelper.get(driver, url);
	}

	public boolean WaitTillHomePageload() {
		Eventhelper.findElement(driver, CreateAnAccountLink);
		return Eventhelper.isElementDisplayed(driver, CreateAnAccountLink);
	}
	

	public boolean waitTillHomepageLoaded() {
		return Eventhelper.isElementDisplayed(driver, homepageTitlelabel);
	}
	
	public void doLogout() {
		Eventhelper.click(driver,AccountDropdown );
		clickOnLink("Sign Out");
	}
}
