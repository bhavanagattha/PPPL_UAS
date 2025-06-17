Feature: Dashboard Navigation
  As a logged-in user, I want to navigate to different modules from the dashboard
  So that I can manage transactions, expenses, and employees

  Scenario: TC-101 Navigate to Transactions page
    Given I am logged in and on the dashboard page
    When I click the Transactions button
    Then I should be redirected to the transactions page

  Scenario: TC-102 Navigate to Expense List page
    Given I am logged in and on the dashboard page
    When I click the Expense List button
    Then I should be redirected to the expense list page

  Scenario: TC-103 Navigate to Employee Management page
    Given I am logged in as an owner and on the dashboard page
    When I click the Employee Management button
    Then I should be redirected to the employee management page