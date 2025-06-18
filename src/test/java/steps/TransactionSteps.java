package steps;

import io.cucumber.java.en.*;
import org.junit.jupiter.api.Assertions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.TransactionPage;

/**
 * Step definitions for transaction management actions.
 */
public class TransactionSteps {
    private static final Logger logger = LoggerFactory.getLogger(TransactionSteps.class);
    private TransactionPage transactionPage;

    public TransactionSteps() {
        logger.info("Initializing TransactionSteps");
        transactionPage = new TransactionPage(CucumberHooks.getDriver());
    }

    @When("I click the Add Transaction button")
    public void i_click_the_add_transaction_button() {
        logger.info("Clicking Add Transaction button");
        transactionPage.clickAddTransactionButton();
    }

    @When("I enter date {string}")
    public void i_enter_date(String date) {
        logger.info("Entering date: {}", date);
        transactionPage.enterDate(date);
    }

    @When("I enter amount {string}")
    public void i_enter_amount(String amount) {
        logger.info("Entering amount: {}", amount);
        transactionPage.enterAmount(amount);
    }

    @When("I enter description {string}")
    public void i_enter_description(String description) {
        logger.info("Entering description: {}", description);
        transactionPage.enterDescription(description);
    }

    @When("I click the Save button")
    public void i_click_the_save_button() {
        logger.info("Clicking Save button");
        transactionPage.clickSaveButton();
    }

    @When("I click the Edit button for the first transaction")
    public void i_click_the_edit_button_for_the_first_transaction() {
        logger.info("Clicking Edit button for first transaction");
        transactionPage.clickEditButton(1);
    }

    @Then("I should be redirected to the transactions page")
    public void i_should_be_redirected_to_the_transactions_page() {
        logger.info("Verifying transactions page redirect. Current URL: {}", CucumberHooks.getDriver().getCurrentUrl());
        String currentUrl = CucumberHooks.getDriver().getCurrentUrl();
        Assertions.assertEquals("https://frontend-alganis-production.up.railway.app//transaksi", currentUrl,
                "Not redirected to transactions page. Actual URL: " + currentUrl);
        Assertions.assertTrue(transactionPage.isTransactionTableDisplayed(), "Transaction table not displayed");
    }
}