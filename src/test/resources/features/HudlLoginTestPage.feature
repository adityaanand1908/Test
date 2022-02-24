@HudlLoginTest
Feature: Test the authorization to Hudl web applications

@HudlValidLoginTestAT001
Scenario: Validation of authorized user access to Hudl web applications
Given Start chrome browser and launch hudl web application
And Click on Login button after entering valid username and password to validate the displayed project name on the hudl homepage
Then Logout the loggedin user