Feature: Login
  As a user, I want to log in to the PAD Web Keuangan application
  So that I can access the dashboard and manage financial data

  Scenario: TC-001 Successful login with valid credentials
    Given I am on the login page
    When I enter email on login "owner@example.com"
    And I enter password on login "password123"
    And I click the login button
    Then I should be redirected to the dashboard page