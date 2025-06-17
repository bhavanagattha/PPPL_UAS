package steps;

import io.cucumber.java.en.*;
import org.junit.jupiter.api.Assertions;
import pages.EmployeeManagementPage;

/**
 * Step definitions untuk manajemen pegawai.
 */
public class EmployeeManagementSteps {
    private EmployeeManagementPage employeeManagementPage;

    public EmployeeManagementSteps() {
        employeeManagementPage = new EmployeeManagementPage(CucumberHooks.getDriver());
    }

    @Given("I am on the employee management page")
    public void i_am_on_the_employee_management_page() {
        CucumberHooks.getDriver().get("https://padwebkeuangan-production.up.railway.app/pegawai");
        Assertions.assertTrue(employeeManagementPage.isUserTableDisplayed());
    }

    @When("I click the Add Employee button")
    public void i_click_the_add_employee_button() {
        employeeManagementPage.clickAddButton();
        Assertions.assertTrue(employeeManagementPage.isAddEmployeePageDisplayed());
    }

    @When("I enter name {string}")
    public void i_enter_name(String name) {
        employeeManagementPage.enterName(name);
    }

    @When("I enter email {string}")
    public void i_enter_email(String email) {
        employeeManagementPage.enterEmail(email);
    }

    @When("I enter password {string}")
    public void i_enter_password(String password) {
        employeeManagementPage.enterPassword(password);
    }

    @When("I enter password confirmation {string}")
    public void i_enter_password_confirmation(String password) {
        employeeManagementPage.enterPasswordConfirmation(password);
    }

    @When("I click the Save button")
    public void i_click_the_save_button() {
        employeeManagementPage.clickSaveButton();
    }

    @When("I click the Edit button for the first employee")
    public void i_click_the_edit_button_for_the_first_employee() {
        employeeManagementPage.clickEditButton(0);
        Assertions.assertTrue(employeeManagementPage.isEditEmployeePageDisplayed());
    }

    @When("I click the Delete button for the first employee")
    public void i_click_the_delete_button_for_the_first_employee() {
        employeeManagementPage.clickDeleteButton(0);
    }

    @When("I click the Confirm Delete button")
    public void i_click_the_confirm_delete_button() {
        employeeManagementPage.clickConfirmDeleteButton();
    }

    @When("I enter search query {string}")
    public void i_enter_search_query(String query) {
        employeeManagementPage.enterSearchQuery(query);
    }

    @Then("I should be redirected to the employee management page")
    public void i_should_be_redirected_to_the_employee_management_page() {
        Assertions.assertTrue(employeeManagementPage.isUserTableDisplayed());
        Assertions.assertEquals("https://padwebkeuangan-production.up.railway.app/pegawai", CucumberHooks.getDriver().getCurrentUrl());
    }

    @Then("I should see the employee table updated")
    public void i_should_see_the_employee_table_updated() {
        Assertions.assertTrue(employeeManagementPage.isUserTableDisplayed());
    }
}