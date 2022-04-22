Feature: Application Login

Scenario: Login with valid credentials

Given open any browser
And navigate to login page
When User enters username as "phaniatw2@gmail.com" and password as "atw@123" in to the fields
And User clicks on Login button
Then verify user is able to Successfully login
