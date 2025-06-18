package steps;

import io.cucumber.java.en.*;
import org.junit.jupiter.api.Assertions;
import pages.TransactionPage;

/**
 * Step definitions untuk manajemen transaksi.
 */
public class TransactionSteps {
    private TransactionPage transactionPage;

    public TransactionSteps() {
        transactionPage = new TransactionPage(CucumberHooks.getDriver());
    }

    @Given("I am on the transactions page")
    public void i_am_on_the_transactions_page() {
        CucumberHooks.getDriver().get("https://padwebkeuangan-production.up.railway.app/transaksi");
        Assertions.assertTrue(transactionPage.isTransactionTableDisplayed());
    }

    @When("I click the Add Transaction button")
    public void i_click_the_add_transaction_button() {
        transactionPage.clickAddButton();
        Assertions.assertTrue(transactionPage.isAddTransactionPageDisplayed());
    }

    @When("I enter date on transaction {string}")
    public void i_enter_date_on_transaction(String date) {
        transactionPage.enterDate(date);
    }

    @When("I enter amount on transaction {string}")
    public void i_enter_amount_on_transaction(String amount) {
        transactionPage.enterAmount(amount);
    }

    @When("I enter description on transaction {string}")
    public void i_enter_description_on_transaction(String description) {
        transactionPage.enterDescription(description);
    }

    @When("I click the Save button on transaction")
    public void i_click_the_save_button_on_transaction() {
        transactionPage.clickSaveButton();
    }

    @When("I click the Edit button for the first transaction")
    public void i_click_the_edit_button_for_the_first_transaction() {
        transactionPage.clickEditButton(0);
        Assertions.assertTrue(transactionPage.isEditTransactionPageDisplayed());
    }

    @When("I click the Delete button for the first transaction")
    public void i_click_the_delete_button_for_the_first_transaction() {
        transactionPage.clickDeleteButton(0);
    }

    @When("I click the Confirm Delete button")
    public void i_click_the_confirm_delete_button() {
        transactionPage.clickConfirmDeleteButton();
    }

    @Then("I should be redirected to the transactions page from the transactions page")
    public void i_should_be_redirected_to_the_transactions_page_from_the_transactions_page() {
        Assertions.assertTrue(transactionPage.isTransactionTableDisplayed());
        Assertions.assertEquals("https://padwebkeuangan-production.up.railway.app/transaksi", CucumberHooks.getDriver().getCurrentUrl());
    }

    @Then("I should see the transaction table updated")
    public void i_should_see_the_transaction_table_updated() {
        Assertions.assertTrue(transactionPage.isTransactionTableDisplayed());
    }
}