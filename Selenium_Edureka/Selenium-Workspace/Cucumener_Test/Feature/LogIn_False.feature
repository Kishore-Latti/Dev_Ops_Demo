Feature: Login Action False and True
  I want to use this template for my feature file

Scenario: Successful Registration
  Given User is on Home Page
	When User enters details
	Then Message displayed Login Successfully


  Scenario: Successful Login
  When User tries to LogIn
  When User enters Credentials to LogIn
  When User LogOut from the Application
  Then Message displayed LogOut Successfully
	
  Scenario: Successful Logout
  When User LogOut from the Application
	Then Message displayed LogOut Successfully