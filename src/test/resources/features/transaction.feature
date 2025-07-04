Feature: Transaction Management
  As a logged-in user, I want to manage transactions in the PAD Web Keuangan application
  So that I can add, edit, and delete transaction records

  Scenario: TC-201 Add a new transaction
    Given I am on the transactions page
    When I click the Add Transaction button
    And I enter date "2025-06-17"
    And I enter amount "500000"
    And I enter description "Penjualan produk"
    And I click the Save button
    Then I should be redirected to the transactions page

  Scenario: TC-202 Edit an existing transaction
    Given I am on the transactions page
    When I click the Edit button for the first transaction
    And I enter date "2025-06-18"
    And I enter amount "750000"
    And I enter description "Penjualan produk updated"
    And I click the Save button
    Then I should be redirected to the transactions page

  Scenario: TC-203 Delete a transaction
    Given I am on the transactions page
    When I click the Delete button for the first transaction
    And I click the Confirm Delete button
    Then I should see the transaction table updated