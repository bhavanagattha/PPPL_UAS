Feature: Employee Management
  As an owner, I want to manage employees in the PAD Web Keuangan application
  So that I can add, edit, delete, and search employee records

  Scenario: TC-401 Add a new employee
    Given I am on the employee management page
    When I click the Add Employee button
    And I enter name "John Doe"
    And I enter email "john.doe@example.com"
    And I enter password "password123"
    And I enter password confirmation "password123"
    And I click the Save button
    Then I should be redirected to the employee management page

  Scenario: TC-402 Edit an existing employee
    Given I am on the employee management page
    When I click the Edit button for the first employee
    And I enter name "John Doe Updated"
    And I enter email "john.doe.updated@example.com"
    And I enter password "newpassword123"
    And I click the Save button
    Then I should be redirected to the employee management page

  Scenario: TC-403 Delete an employee
    Given I am on the employee management page
    When I click the Delete button for the first employee
    And I click the Confirm Delete button
    Then I should see the employee table updated

  Scenario: TC-404 Search for an employee
    Given I am on the employee management page
    When I enter search query "John Doe"
    Then I should see the employee table updated