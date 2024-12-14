package steps;

import com.github.javafaker.Faker;

import data.Signupdata;
import dev.failsafe.internal.util.Assert;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.Myaccountpage;
import pages.Signin;
import pages.Signuppage;

public class Singupsteps {

	Signuppage signup = new Signuppage();
	Myaccountpage accoutpage = new Myaccountpage();
	Faker fakeData = new Faker();
	Signin signin = new Signin();

	@Then("I should see Create Account screen load succesfully")
	public void i_should_see_create_account_screen_load_succesfully() {
		Assert.isTrue(signup.waitTillSignuppageLoaded(), "Create Account screen not load succesfully");
	}

	@When("I fill in customer personal information")
	public void i_fill_in_customer_personal_information() {
		String firstName = fakeData.name().firstName();
		Signupdata.getInstance().setFirstName(firstName);
		String lastName = fakeData.name().lastName();
		Signupdata.getInstance().setLastName(lastName);

		signup.AddPersonalInformation(Signupdata.getInstance().getFirstName(), Signupdata.getInstance().getLastName());
	}

	@When("I fill in customer sign-in information")
	public void i_fill_in_customer_sign_in_information() {
		String email = fakeData.internet().emailAddress();
		Signupdata.getInstance().setEmail(email);
		Signupdata.getInstance().setPassword("Testing@123");

		signup.AddSigninInformation(Signupdata.getInstance().getEmail(), Signupdata.getInstance().getPassword());
	}

	@Then("I should see the success message {string}")
	public void i_should_see_the_success_message(String message) {
		accoutpage.WaitTillSuccessMessage(message);
	}

	@Then("I validate the registration details on the home page")
	public void i_validate_the_registration_details_on_the_home_page() {
		String[] accountDetails = accoutpage.getAccountDetails();
		String name = Signupdata.getInstance().getFirstName() + " " + Signupdata.getInstance().getLastName();

		Assert.isTrue(accountDetails[0].equals(name), "First Name or Last Name not matching");
		Assert.isTrue(accountDetails[1].equals(Signupdata.getInstance().getEmail()), "Email not matching");
	}

	@When("I login with created user")
	public void i_login_with_created_user() {
		signin.doLogin(Signupdata.getInstance().getEmail(), Signupdata.getInstance().getPassword());
	}

}
