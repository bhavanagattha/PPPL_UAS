Feature: Expense List Management
  As a logged-in user, I want to manage expenses in the PAD Web Keuangan application
  So that I can add, edit, delete, and download expense records

  Scenario: TC-301 Add a new expense
    Given I am on the expense list page
    When I click the Add Expense button
    And I enter date "2025-06-17"
    And I enter amount "100000"
    And I enter description "Pembelian bahan baku"
    And I click the Save button
    Then I should be redirected to the expense list page

  Scenario: TC-302 Edit an existing expense
    Given I am on the expense list page
    When I click the Edit button for the first expense
    And I enter date "2025-06-18"
    And I enter amount "150000"
    And I enter description "Pembelian bahan baku updated"
    And I click the Save button
    Then I should be redirected to the expense list page

  Scenario: TC-303 Delete an expense
    Given I am on the expense list page
    When I click the Delete button for the first expense
    And I click the Confirm Delete button
    Then I should see the expense table updated

  Scenario: TC-304 Download expense report
    Given I am on the expense list page
    When I click the Download button
    And I enter start date "2025-06-01"
    And I enter end date "2025-06-17"
    And I click the Confirm Download button
    Then I should download a PDF file