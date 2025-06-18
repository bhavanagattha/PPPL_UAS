Feature: Transaction Management Flow - Negative Cases

  Scenario: TC-601 Login with invalid credentials
    Given I am on the login page
    When I enter email "wrong@admin.com"
    And I enter password "wrongpass"
    And I click the login button
    Then I should see error message "Login failed"

  Scenario: TC-602 Create transaction with empty fields
    Given I am logged in as owner
    When I click the Add Transaction button
    And I enter store "Toko AJI"
    And I enter product "produk A"
    And I enter price "500000"
    And I enter stock "100"
    And I click the Save button
#    And I navigate to the transaction page
#    And I navigate to the add transaction page
#    When I click the Save button
    Then I should see validation message "Field harus diisi"

  Scenario: TC-603 Create transaction with negative price
    Given I am logged in as owner
    And I navigate to the add transaction page
    And I enter price "-1000"
    When I click the Save button
    Then I should see validation message "Harga tidak valid"