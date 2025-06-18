package steps;

import io.cucumber.java.en.*;
import org.junit.jupiter.api.Assertions;
import pages.DashboardPage;
import pages.LoginPage;

/**
 * Step definitions untuk fitur login.
 */
public class LoginSteps {
    private LoginPage loginPage;
    private DashboardPage dashboardPage;

    public LoginSteps() {
        loginPage = new LoginPage(CucumberHooks.getDriver());
        dashboardPage = new DashboardPage(CucumberHooks.getDriver());
    }

    @Given("I am on the login page")
    public void i_am_on_the_login_page() {
        loginPage.open();
    }

    @When("I enter email on login {string}")
    public void i_enter_email_on_login(String email) {
        loginPage.enterEmail(email);
    }

    @When("I enter password on login {string}")
    public void i_enter_password_on_login(String password) {
        loginPage.enterPassword(password);
    }

    @When("I click the login button")
    public void i_click_the_login_button() {
        loginPage.clickLoginButton();
    }

    @Then("I should be redirected to the dashboard page")
    public void i_should_be_redirected_to_the_dashboard_page() {
        Assertions.assertTrue(dashboardPage.isIncomeTableDisplayed());
        Assertions.assertEquals("https://padwebkeuangan-production.up.railway.app/dashboard", CucumberHooks.getDriver().getCurrentUrl());
    }
}