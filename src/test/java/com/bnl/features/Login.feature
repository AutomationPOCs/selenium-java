Feature: Login Scenerio 
Background: 
	Given Navigate to login page 
	And Verify the login page 
	And Maximize the page 
	
@web
Scenario: Login successfully with valid credentials 
	When User fill the email_address on login page
	And User fill the password on login page
	And Verify the "Log in" title is displayed 
	And Verify Login button is displayed 
	And Verify "FORGOT PASSWORD?" link is displayed 
	And Verify the "SIGN UP" link is displayed 
	And User click on Login button
