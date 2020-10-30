Feature: Account Summary Page functionality

  Background:
    Given the user is logged in

  Scenario: Account Summary page
    Given "Account Summary" page should be displayed
    Then "Account Summary" page should have title "Zero - Account Summary"
    And Account Summary page should have following account types : "Cash Accounts, Investment Accounts, Credit Accounts, Loan Accounts"
    And Credit Accounts table must have columns "Account, Credit Card, Balance"
