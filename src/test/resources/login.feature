Feature: Verify adactinhotel details 
Scenario: Verify adactinhotel with valid credentials.
	Given user is on adactinhotel webpage.
	When user should enter username and password.
	And user should click the login button.
	Then user should verify the success message.

