
  Feature: Sign-Up and Sign In Flow

	Background:
		Given I navigate to landingpage
    Then I should see landingpage load succesfully

  Scenario: User can successfully sign up
    When I click on "Create an Account" link
    Then I should see Create Account screen load succesfully
    When I fill in customer personal information
    And I fill in customer sign-in information
    And I click on button "Create an Account"
    Then I should see the success message "Thank you for registering with Main Website Store."
    And I validate the registration details on the home page
    And I logout from site
    
  Scenario: User can successfully sign In
    When I click on "Sign In" link
    And I login with created user
    Then I should see homepage load succesfully
    And I logout from site