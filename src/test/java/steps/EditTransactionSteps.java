package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import pages.EditTransactionPage;
import org.openqa.selenium.WebDriver;
import static org.junit.Assert.assertTrue;

public class EditTransactionSteps {

    WebDriver driver = CucumberHooks.getDriver(); // Mengasumsikan WebDriver di-setup di Hooks.java
    EditTransactionPage editTransactionPage = new EditTransactionPage(driver);

    @And("I enter entry date {string}")
    public void iEnterEntryDate(String entryDate) {
        editTransactionPage.enterEntryDate(entryDate);
    }

    @And("I enter sold {string}")
    public void iEnterSold(String sold) {
        editTransactionPage.enterSold(sold);
    }
}
