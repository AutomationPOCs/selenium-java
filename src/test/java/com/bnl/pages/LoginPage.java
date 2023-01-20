package com.bnl.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import com.bnl.common.BaseTest;
import com.bnl.common.ConfigBase;

public class LoginPage extends BaseTest {
	public LoginPage() {
		PageFactory.initElements(BaseTest.driver, this);
	}
	
	SoftAssert softassert = new SoftAssert();
	
	
	String expectedUrl = "";
	String frgtPass;
	
	WebElement loginEmail;
	WebElement loginPswd;
	WebElement loginBtn;
	WebElement emailValidation;
	WebElement wrongEmail;
	WebElement wrongPassword;
	WebElement notRegisterUserValidateMsg;
	WebElement forgotPswdLink;
	WebElement forgotPswdPageUrl;
	WebElement forgotPasswordPageTitle;
	WebElement forgottenEmailAdd;
	WebElement recoverPswdBtn;
	WebElement sigUpLink;
	WebElement registerButton;
	WebElement loginLink;

	public void navigate_ToLoginUrl() {
		driver.navigate().to(ConfigBase.initialiseProperty(ConfigBase.ConfigProperty, "Staging_URL") + "/login");
	}

	public void verify_LoginPageUrl() {
		String loginCurrentUrl = driver.getCurrentUrl();
		Assert.assertEquals(loginCurrentUrl, expectedUrl);
	}

	public void verify_FormTitle(String str) {
		String actualText = driver.findElement(By.cssSelector("h2[class*=\"Form-title\"]")).getText();
		System.out.println("actualText:" + actualText);
		Assert.assertEquals(str, actualText);
	}

	public void verify_LoginFormButton() {
		boolean button = driver.findElement(By.id("login-submit-btn")).isDisplayed();
		Assert.assertTrue(button);
	}

	public void verify_ForgetPassword(String forgetlink) {
		String frgtPass = driver.findElement(By.xpath("//a[text()='FORGOT PASSWORD?']")).getText();
		System.out.println("frgtPass : " + frgtPass);
		Assert.assertEquals(frgtPass, forgetlink);
	}

	public void verify_SignUpLink(String singupLink) {
		sigUpLink = driver.findElement(By.xpath("//a[text()='SIGN UP']"));
		String sigUpLinkText = sigUpLink.getText();
		System.out.println("signUpLink : " + sigUpLinkText);
		Assert.assertEquals(sigUpLinkText, singupLink);
	}

	public void click_SignUpButton() throws InterruptedException {
		Thread.sleep(10);
		driver.findElement(By.cssSelector("div[class='bottom-link'] span  a")).click();
//		sigUpLink.click();
	}

	public void verify_SignUpPage() throws InterruptedException {
		Thread.sleep(10);
		String expectedSignUpUrl = "";
		String signUpCurrentUrl = driver.getCurrentUrl();
		Assert.assertEquals(signUpCurrentUrl, expectedSignUpUrl);
	}
	public void verifyLoginLink(String login) {
		loginLink = driver.findElement(By.xpath("//a[text()='LOGIN?']"));
		String loginLinkText = loginLink.getText();
		System.out.println("loginLinkText : " + loginLinkText);
		Assert.assertEquals(loginLinkText, login);

	}

	public void click_ONLoginLink() {
		loginLink.click();
	}

	public void click_OnLoginButton() {
		WebElement loginButton = driver.findElement(By.id("login-submit-btn"));
		loginButton.click();
	}

	public void verify_ValidationOnLoginPage() {
		Boolean Email = driver.findElement(By.id("mat-error-9")).isDisplayed();
		Boolean Password = driver.findElement(By.id("mat-error-10")).isDisplayed();
		Assert.assertTrue(Email);
		Assert.assertTrue(Password);
	}

	public void type_EmailAddress() {
		WebElement EmailField = driver.findElement(By.id("login-emailid"));
		EmailField.clear();
		EmailField.sendKeys("test123@mailinator.com");
	}

	public void type_password() {
		WebElement PasswordField = driver.findElement(By.id("login-password"));
		PasswordField.clear();
		PasswordField.sendKeys("password");
	}

	public void empty_EmailAddress() {
		WebElement EmailField = driver.findElement(By.id("login-emailid"));
		EmailField.clear();
	}

	public void empty_Password() {
		WebElement PasswordField = driver.findElement(By.id("login-password"));
		PasswordField.clear();
	}

	public void verify_ValidationOnAllEmptyField() {
		WebElement EmailField = driver.findElement(By.xpath("//div//mat-error[contains(text(),'Email is required')]"));
		String EmailFieldValidation = EmailField.getText();
		WebElement PasswordField = driver.findElement(By.xpath("//div//mat-error[contains(text(),' Password is required ')]"));
		String PasswordFieldValidation = PasswordField.getText();
		softassert.assertEquals(EmailFieldValidation, "Email is required");
		Assert.assertEquals(PasswordFieldValidation, "Password is required");
		softassert.assertAll();
	}

	public void verify_ValidationForEmptyEmail() {
		WebElement EmailField = driver.findElement(By.xpath("//div//mat-error[contains(text(),'Email is required')]"));
		String EmailFieldValidation = EmailField.getText();
		Assert.assertEquals("Email is valid", EmailFieldValidation);
	}

	public void verify_ValidationForEmptyPassword() {
		WebElement PasswordField = driver.findElement(By.xpath("//div//mat-error[contains(text(),' Password is required ')]"));
		String PasswordFieldValidation = PasswordField.getText();
		System.out.println(PasswordFieldValidation);
		Assert.assertEquals("Password is required", PasswordFieldValidation);
	}

	public void type_InvalidEmail() {
		WebElement InvalidEmailAddress = driver.findElement(By.id("login-emailid"));
		InvalidEmailAddress.sendKeys("test");
	}

	public void verify_ValidationForInvalidEmail() {
		WebElement InvalidEmailAddress = driver.findElement(By.xpath("//div//mat-error[contains(text(),'Email is invalid')]"));
		String InvalidEmailAddressValidation = InvalidEmailAddress.getText();
		Assert.assertEquals(InvalidEmailAddressValidation, "Email is invalid");
	}
	
}