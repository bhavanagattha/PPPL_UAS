package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import pages.CreateTransactionPage;
import org.openqa.selenium.WebDriver;
import steps.CucumberHooks;

import static org.junit.Assert.assertTrue;

public class CreateTransactionSteps {

    WebDriver driver = CucumberHooks.getDriver(); // asumsi Hooks.java sudah setup WebDriver
    CreateTransactionPage createTransactionPage = new CreateTransactionPage(driver);

    @And("I enter store {string}")
    public void iEnterStore(String store) {
        createTransactionPage.enterStore(store);
    }

    @And("I enter product {string}")
    public void iEnterProduct(String product) {
        createTransactionPage.enterProduct(product);
    }

    @And("I enter exit date {string}")
    public void iEnterExitDate(String date) {
        createTransactionPage.enterExitDate(date);
    }

    @And("I enter price {string}")
    public void iEnterPrice(String price) {
        createTransactionPage.enterPrice(price);
    }

    @And("I enter stock {string}")
    public void iEnterStock(String stock) {
        createTransactionPage.enterStock(stock);
    }

    @And("I click the Save button")
    public void iClickSaveButton() {
        createTransactionPage.clickSaveButton();
    }

    @Then("I should be redirected to the transactions page")
    public void iShouldBeRedirectedToTransactionsPage() {
        // kamu bisa menyesuaikan dengan URL atau elemen unik di halaman transaksi
        String currentUrl = driver.getCurrentUrl();
        assertTrue(currentUrl.contains("/transactions")); // contoh validasi redirect
    }
}
