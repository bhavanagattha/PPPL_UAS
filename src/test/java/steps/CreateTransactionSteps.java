package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.jupiter.api.Assertions;
import pages.CreateTransactionPage;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;
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

    @Then("I should see validation message {string}")
    public void iShouldSeeValidationMessage(String expectedMessage) {
    LoginPage loginPage = new LoginPage(CucumberHooks.getDriver());

    String actualMessage = loginPage.getErrorMessage();
    Assertions.assertTrue(actualMessage.contains(expectedMessage),
            "Expected error message to contain: '" + expectedMessage + "' but got: '" + actualMessage + "'");
    }
}
