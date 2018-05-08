Feature: Login action with Data Table

	
Scenario: Successful Login
	Given User is on Home Page
	When User tries to LogIn
	And User enters Cred to LogIn
	| Kishan_0359 | Test@123 |
	Then Message displayed Login Successfully
	Then I close the browser
