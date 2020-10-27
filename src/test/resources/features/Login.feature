Feature: Login to the Application

  Scenario:Login with valid credentials
    Given user is on the login page
    When user logs in with following valid credentials
      | username | username |
      | password | password |
    Then the Account summary page should be displayed

  Scenario: Login with invalid credentials
    Given user is on the login page
    When user logs in with invalid credentials
    Then error message "Login and/or password are wrong." is displayed


    Scenario: Login with Blank credentials
      Given user is on the login page
      When user clicks Sign in without enter username and password
      Then error message "Login and/or password are wrong." is displayed


