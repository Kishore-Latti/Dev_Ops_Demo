Feature: Automated End to End Tests 
	Description: Purpose of this Tests is to Test end to end Integration 

Scenario: 
	Given user is on Home Page 
	When he search for "dress" 
	And choose to buy the first item 
	And moves to checkout from mini cart 
	And enter personal details on checkout page 
	And select same delivery address 
	And select payment method as "Cash" payment 
	And place the order 