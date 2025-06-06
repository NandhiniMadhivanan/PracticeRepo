Feature: Login Functionality

Scenario Outline: Login demoaut application with valid username and password
  Given The user launch the browser
  When Pass the demouat URL
  And User enters the '<username>' and '<password>'
  And click the login button
  Then Homepage is displayed
  Then Quit the browser

  Examples:
  |username|password|
  |nandhini|nandhini|
  |nandhini|nan     |
  |nan     |nandhini|
  |karthik |karthik |
@mytag
Scenario Outline: Verify accessing the Flights link from the home page
  Given The user launch the browser
  When Pass the demouat URL
  And User enters the '<username>' and '<password>'
  And click the login button
  Then Homepage is displayed
  And click on the Flights Link
  Then Quit the browser

  Examples:
  |username|password|
  |nandhini|nandhini|


