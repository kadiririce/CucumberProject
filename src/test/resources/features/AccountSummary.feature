Feature: Accont Summary
@wip
  Scenario: Page title and Account types
    Given the user is logged in
    Then the Page title should be "Zero - Account Summary"
    Then Account summar page should have following account types
      | Cash Accounts       |
      | Investment Accounts |
      | Credit Accounts     |
      | Loan Accounts      |
    Then Credit Account table must have following columns
      | Account     |
      | Credit Card |
      | Balance     |
