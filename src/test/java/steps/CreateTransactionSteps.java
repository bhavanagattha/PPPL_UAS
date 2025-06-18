package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.Alert;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.CreateTransactionPage;
import org.openqa.selenium.WebDriver;
import steps.CucumberHooks;

import java.time.Duration;

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

    @And("I click the Save create button")
    public void iClickSaveCreateButton() {
        createTransactionPage.clickSaveButton();
        WebDriverWait wait = new WebDriverWait(CucumberHooks.getDriver(), Duration.ofSeconds(5));
        try {
            wait.until(ExpectedConditions.alertIsPresent());

            // Pindah fokus ke alert dan klik OK
            Alert alert = CucumberHooks.getDriver().switchTo().alert();

            alert.accept(); // atau alert.dismiss() jika perlu cancel
        } catch (TimeoutException e) {
            Assertions.fail("Expected alert after saving, but none appeared.");
        }
    }

}
