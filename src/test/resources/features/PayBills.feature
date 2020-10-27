
Feature: Pay Bills
  Background:
    Given the user is logged in
    Given user go to Pay Bills


  Scenario: verifying page title
    Then user go to Account Activity page
    And the Page title should be "Zero - Pay Bills"

  Scenario: successfully pay operation
    When user completes a successfully Pay operation
    Then "The payment was successfully submitted." message should be displayed

  Scenario: unsuccessfully pay operation
    When user tries to make a payment without entering the amount or date
    Then "Please fill out this field message!" message should be displayed.

    Scenario: Amount field should not accept alphabetical character
      When user enters some alphabetical character on Amount field
      Then Amount field should be empty

    Scenario: Amount field should not accept special character
      When user enters some special character on Amount field
      Then Amount field should be empty
  @wip
    Scenario:  Date field should not accept alphabetical chatacter
      When user enters some alphabetical chatacter on Date field
      Then Date field should be empty


