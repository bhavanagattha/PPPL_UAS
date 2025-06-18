package steps;

import io.cucumber.java.en.*;
import org.junit.jupiter.api.Assertions;
import pages.DashboardPage;
import pages.EmployeeManagementPage;
import pages.ExpenseListPage;
import pages.TransactionPage;

/**
 * Step definitions untuk navigasi dashboard.
 */
public class DashboardSteps {
    private DashboardPage dashboardPage;
    private TransactionPage transactionPage;
    private ExpenseListPage expenseListPage;
    private EmployeeManagementPage employeeManagementPage;

    public DashboardSteps() {
        dashboardPage = new DashboardPage(CucumberHooks.getDriver());
        transactionPage = new TransactionPage(CucumberHooks.getDriver());
        expenseListPage = new ExpenseListPage(CucumberHooks.getDriver());
        employeeManagementPage = new EmployeeManagementPage(CucumberHooks.getDriver());
    }

    @Given("I am logged in and on the dashboard page")
    public void i_am_logged_in_and_on_the_dashboard_page() {
        CucumberHooks.getDriver().get("https://padwebkeuangan-production.up.railway.app/dashboard");
        Assertions.assertTrue(dashboardPage.isIncomeTableDisplayed());
    }

    @Given("I am logged in as an owner and on the dashboard page")
    public void i_am_logged_in_as_an_owner_and_on_the_dashboard_page() {
        i_am_logged_in_and_on_the_dashboard_page();
        Assertions.assertTrue(dashboardPage.isEmployeeManagementButtonDisplayed(), "User is not an owner");
    }

    @When("I click the Transactions button on dahsboard")
    public void i_click_the_transactions_button_on_dashboard() {
        dashboardPage.clickTransactionButton();
    }

    @When("I click the Expense List button on dashboard")
    public void i_click_the_expense_list_button_on_dashboard() {
        dashboardPage.clickExpenseListButton();
    }

    @When("I click the Employee Management button on dashboard")
    public void i_click_the_employee_management_button_on_dashboard() {
        dashboardPage.clickEmployeeManagementButton();
    }

    @Then("I should be redirected to the transactions page from dashboard")
    public void i_should_be_redirected_to_the_transactions_page_from_dashboard() {
        Assertions.assertTrue(transactionPage.isTransactionTableDisplayed());
        Assertions.assertEquals("https://padwebkeuangan-production.up.railway.app/transaksi", CucumberHooks.getDriver().getCurrentUrl());
    }

    @Then("I should be redirected to the expense list page from dashboard")
    public void i_should_be_redirected_to_the_expense_list_page_from_dashboard() {
        Assertions.assertTrue(expenseListPage.isExpenseTableDisplayed());
        Assertions.assertEquals("https://padwebkeuangan-production.up.railway.app/barang", CucumberHooks.getDriver().getCurrentUrl());
    }

    @Then("I should be redirected to the employee management page from dashboard")
    public void i_should_be_redirected_to_the_employee_management_page_from_dashboard() {
        Assertions.assertTrue(employeeManagementPage.isUserTableDisplayed());
        Assertions.assertEquals("https://padwebkeuangan-production.up.railway.app/pegawai", CucumberHooks.getDriver().getCurrentUrl());
    }

}