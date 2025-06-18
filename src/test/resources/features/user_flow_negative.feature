Feature: Transaction Management Flow - Negative Cases

  Scenario: TC-601 Login with invalid credentials
    Given I am on the login page
    When I enter email "wrong@admin.com"
    And I enter password "wrongpass"
    And I click the login button
    Then I should see error message "Login failed"

  Scenario: TC-602 Create transaction with empty fields
    Given I am logged in as owner
    When I click the Transactions button
    And I click the Add Transaction button
    And I enter store "Toko AJI"
    And I enter product "produk A"
    And I enter price "500000"
    And I enter stock "100"
    And I click the Save create button
    Then I should see validation message "The exit date field is required."

  Scenario: TC-603 Edit transaction with invalid entry date
    Given I am logged in as owner
    When I click the Transactions button
    When I click the Edit button for the first transaction
    And I enter price "-1000"
    When I click the Save button
    Then I should see validation message "Harga tidak valid"