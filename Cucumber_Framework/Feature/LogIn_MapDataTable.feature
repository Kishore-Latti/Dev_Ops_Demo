Feature: Login action with Data Table

	
Scenario: Successful Login with single data 
	Given User is on Home Page
	When User tries to LogIn
	And User enters Creds to LogIn
	| Username   | Password |
	| Kishan_0359 | Test@123 |
	Then Message displayed Login Successfully
	
Scenario: Successful Login with multiple data 
	Given User is on Home Page
	When User tries to LogIn
	And User enters Credis to LogIn
	| Username   | Password |
	| Kishan_0359 | Test@123 |
	| Kishan_03592 | Test@123 |
	Then Message displayed Login Successfully
