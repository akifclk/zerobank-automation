@login
Feature: Login Functionality

  Scenario: Authorized user should be able to login
    When login with "username" and "password"
    Then "Account Summary" page should be displayed

  Scenario Outline: Unauthorized user should not be able to login
    When login with "<username>" and "<password>"
    Then Error message "Login and/or password are wrong." should be displayed

    Examples:
      | username | password |
      |          |          |
      | abc      | abc      |
