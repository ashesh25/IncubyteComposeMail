Feature: Compose Mail

Scenario: Login to Gmail
	Given Gmail Url
	When User enters username and Password
	And hit the login button
	Then Load the home page

Scenario: Compoe mail
	Given user in home page
	When user clicked on compose mail
	And Entered To and Subject
	And Clicked on Send button
	Then Mail sent Successfully	
