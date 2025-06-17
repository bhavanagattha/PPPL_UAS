package steps;

import io.cucumber.java.en.*;
import org.junit.jupiter.api.Assertions;
import pages.ExpenseListPage;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Step definitions untuk manajemen daftar pengeluaran.
 */
public class ExpenseListSteps {
    private ExpenseListPage expenseListPage;

    public ExpenseListSteps() {
        expenseListPage = new ExpenseListPage(CucumberHooks.getDriver());
    }

    @Given("I am on the expense list page")
    public void i_am_on_the_expense_list_page() {
        CucumberHooks.getDriver().get("https://padwebkeuangan-production.up.railway.app/barang");
        Assertions.assertTrue(expenseListPage.isExpenseTableDisplayed());
    }

    @When("I click the Add Expense button")
    public void i_click_the_add_expense_button() {
        expenseListPage.clickAddButton();
        Assertions.assertTrue(expenseListPage.isAddExpensePageDisplayed());
    }

    @When("I click the Download button")
    public void i_click_the_download_button() {
        expenseListPage.clickDownloadButton();
        Assertions.assertTrue(expenseListPage.isDownloadPageDisplayed());
    }

    @When("I enter date {string}")
    public void i_enter_date(String date) {
        expenseListPage.enterDate(date);
    }

    @When("I enter amount {string}")
    public void i_enter_amount(String amount) {
        expenseListPage.enterAmount(amount);
    }

    @When("I enter description {string}")
    public void i_enter_description(String description) {
        expenseListPage.enterDescription(description);
    }

    @When("I enter start date {string}")
    public void i_enter_start_date(String startDate) {
        expenseListPage.enterStartDate(startDate);
    }

    @When("I enter end date {string}")
    public void i_enter_end_date(String endDate) {
        expenseListPage.enterEndDate(endDate);
    }

    @When("I click the Save button")
    public void i_click_the_save_button() {
        expenseListPage.clickSaveButton();
    }

    @When("I click the Confirm Download button")
    public void i_click_the_confirm_download_button() {
        expenseListPage.clickConfirmDownloadButton();
    }

    @When("I click the Edit button for the first expense")
    public void i_click_the_edit_button_for_the_first_expense() {
        expenseListPage.clickEditButton(0);
        Assertions.assertTrue(expenseListPage.isEditExpensePageDisplayed());
    }

    @When("I click the Delete button for the first expense")
    public void i_click_the_delete_button_for_the_first_expense() {
        expenseListPage.clickDeleteButton(0);
    }

    @When("I click the Confirm Delete button")
    public void i_click_the_confirm_delete_button() {
        expenseListPage.clickConfirmDeleteButton();
    }

    @Then("I should be redirected to the expense list page")
    public void i_should_be_redirected_to_the_expense_list_page() {
        Assertions.assertTrue(expenseListPage.isExpenseTableDisplayed());
        Assertions.assertEquals("https://padwebkeuangan-production.up.railway.app/barang", CucumberHooks.getDriver().getCurrentUrl());
    }

    @Then("I should see the expense table updated")
    public void i_should_see_the_expense_table_updated() {
        Assertions.assertTrue(expenseListPage.isExpenseTableDisplayed());
    }

    @Then("I should download a PDF file")
    public void i_should_download_a_pdf_file() {
        String downloadDir = System.getProperty("user.home") + "/Downloads";
        Path filePath = Paths.get(downloadDir, "pengeluaran_periode_2025-06-01_-_2025-06-17.pdf");
        Assertions.assertTrue(Files.exists(filePath), "PDF file was not downloaded");
    }
}