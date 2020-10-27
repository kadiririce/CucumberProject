Feature: Account Activity


  Scenario: Page title
    Given the user is logged in
    When user go to Account Activity page
    Then the Page title should be "Zero - Account Activity"
    And Account	drop	down	should	have	"Savings"	selected
    Then Account drop down should have the following options
      | Savings     |
      | Checking    |
      | Loan        |
      | Credit Card |
      | Brokerage   |
    Then Transactions table should have following column names
      | Date        |
      | Description |
      | Deposit     |
      | Withdrawal  |

