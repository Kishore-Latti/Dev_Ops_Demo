Feature: Login action with data
I Will use data in examples
	
Scenario Outline: Successful Login
	Given User is on Home Page
	When User tries to LogIn
	And User enters "<username>" and "<password>"
	Then Message displayed Login Successfully
Examples:
	| username     | password |
	| Kishan_03592 | Test@123 |
	| Kishan_0359 | Test@123 |
	