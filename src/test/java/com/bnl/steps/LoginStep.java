package com.bnl.steps;
import com.bnl.pages.LoginPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
public class LoginStep {
	LoginPage loginpage = new LoginPage();
	
	@Given("Navigate to login page")
	public void navigateToLoginUrl() {
		loginpage.navigate_ToLoginUrl();
	}
	
	@And("Verify the login page")
	public void verifyLoginPageUrl() {
		loginpage.verify_LoginPageUrl();
	}

	@When("User fill the email_address on login page")
	public void typeEmailAddress() {
		loginpage.type_EmailAddress();
	}
	
	@And("User fill the password on login page")
	public void typepassword() {
		loginpage.type_password();
	}
	
	@And("User click on Login button")
	public void clickOnLoginButton() {
		loginpage.click_OnLoginButton();
	}
	
	@When("User left email_address field empty")
	public void emptyEmailAddress() {
		loginpage.empty_EmailAddress();
	}
	
	@And("User left password field empty")
	public void emptyPassword() {
		loginpage.empty_Password();
	}
	
	@And("Verify the validation message for all empty field")
	public void verifyValidationOnAllEmptyField() {
		loginpage.verify_ValidationOnAllEmptyField();
	}
	
	@And("Verify the validation message for empty email field")
	public void verifyValidationForEmptyEmail() {
		loginpage.verify_ValidationForEmptyEmail();
	}
	
	@And("Verify the validation message for empty password field")
	public void verifyValidationForEmptyPassword() {
		loginpage.verify_ValidationForEmptyPassword();
	}
	@When("User fill the email_address with invalid input on login page")
	public void typeInvalidEmail() {
		loginpage.type_InvalidEmail();
	}
	
	@And("Verify the validation message for invalid email field")
	public void verifyValidationForInvalidEmail() {
		loginpage.verify_ValidationForInvalidEmail();
	}

	@And("Verify the {string} title is displayed")
	public void verifyFormTitle(String str) {
		loginpage.verify_FormTitle(str);
	}
	@And("Verify Login button is displayed")
	public void verifyLoginFormButton() {
		loginpage.verify_LoginFormButton();
	}
	@And("Verify {string} link is displayed")
	public void verfyForgetPassword(String forgetlink) {
		loginpage.verify_ForgetPassword(forgetlink);
	}
	@And("Verify the {string} link is displayed")
	public void verifySignUpLink(String singupLink) {
		loginpage.verify_SignUpLink(singupLink);
	}
	@And("User click on SignUp link")
	public void clickSignUpButton() throws InterruptedException {
		loginpage.click_SignUpButton();
		Thread.sleep(20);
	}
	
	@And("Navigate to SignUp page and verify page")
	public void verifySignUpPage() throws InterruptedException {
		loginpage.verify_SignUpPage();
	}
	@And("User clicks on Login link on signUp page")
	public void clickOnLoginLink() {
		loginpage.click_ONLoginLink();
	}
	
	@And("Verify all the validation of input fields on Login page")
	public void verifyValidationOnLoginPage() {
		loginpage.verify_ValidationOnLoginPage();
	}
}