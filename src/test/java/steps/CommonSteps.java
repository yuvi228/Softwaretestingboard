package steps;

import dev.failsafe.internal.util.Assert;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.CommonOperations;

public class CommonSteps {

	CommonOperations commonoperations = new CommonOperations();

	@Given("I navigate to landingpage")
	public void i_navigate_to_homepage() {
		commonoperations.getUrl("https://magento.softwaretestingboard.com/");
	}

	@Then("I should see landingpage load succesfully")
	public void i_should_see_landingpage_load_succesfully() {
		Assert.isTrue(commonoperations.WaitTillHomePageload(), "Landing page not loaded  succesfully.");
	}

	@When("I click on button {string}")
	public void i_click_on_button(String buttonName) {
		commonoperations.clickOnButton(buttonName);
	}

	@When("I click on {string} link")
	public void i_click_on_link(String link) {
		commonoperations.clickOnLink(link);
	}

	@Then("I should see homepage load succesfully")
	public void i_should_see_homepage_load_succesfully() {
		Assert.isTrue(commonoperations.waitTillHomepageLoaded(), "Homepage screen not load succesfully");
	}
	
	@Then("I logout from site")
	public void i_logout_from_site() {
		commonoperations.doLogout();
	}

}
