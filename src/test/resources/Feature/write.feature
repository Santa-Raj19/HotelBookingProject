Feature: Validate the Adactin hotel booking application
Scenario Outline: Validate of Adactin login page using valid userName and valid Password and check hotel booking fields
Given User is on Adactin login page
When User enters the Valid and Valid 
And User clicks on the login button and validate hotel booking fields
Then Validate the cancellation and logout messages

