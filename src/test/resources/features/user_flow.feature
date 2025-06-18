Feature: End-to-End User Flow for Transaction Management
  As an owner, I want to log in, navigate to the transaction module, create and edit a transaction, and log out
  So that I can manage financial transactions and securely exit the application

  Scenario: TC-501 Complete user flow for transaction management with owner account
#    login
    Given I am on the login page
    When I enter email "alganis@admin.com"
    And I enter password "admin12345"
    And I click the login button
    Then I should be redirected to the dashboard page
#    incorrect email/password

#    transaction
    When I click the Transactions button
    Then I should be redirected to the transactions page
    When I click the Add Transaction button
    And I enter store "Toko AJI"
    And I enter product "produk A"
    And I enter exit date "2025-01-01"
    And I enter price "500000"
    And I enter stock "100"
    And I click the Save button
    Then I should be redirected to the transactions page
#    null value

#    edit transaction
    When I click the Edit button for the first transaction
    And I enter entry date "2025-01-02"
    And I enter sold "100"
    And I click the Save button
    Then I should be redirected to the transactions page
#    sold  101 (boundary, negative)

    When I click the Logout button
    And I click the Confirm Logout button
    Then I should be redirected to the login page
