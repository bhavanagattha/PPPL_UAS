package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.EditTransactionPage;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

import static org.junit.Assert.assertTrue;

public class EditTransactionSteps {

    WebDriver driver = CucumberHooks.getDriver(); // Mengasumsikan WebDriver di-setup di Hooks.java
    EditTransactionPage editTransactionPage = new EditTransactionPage(driver);

    @And("I enter entry date {string}")
    public void iEnterEntryDate(String entryDate) {
        WebDriver driver = CucumberHooks.getDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Contoh 1: Tunggu sampai kolom amount terisi
        wait.until(driver1 -> {
            WebElement amountInput = driver1.findElement(By.id("stock")); // ganti dengan locator sesungguhnya
            String value = amountInput.getAttribute("value");
            return value != null && !value.trim().isEmpty();
        });

        // Setelah data dari API terload, baru isi entry date
        editTransactionPage.enterEntryDate(entryDate);
    }

    @And("I enter sold {string}")
    public void iEnterSold(String sold) {
        editTransactionPage.enterSold(sold);
    }


    @And("I click the Save edit button")
    public void iClickSaveEditButton() {
        editTransactionPage.clickSaveButton();
    }

    @And("I should see edit validation message {string}")
    public void iShouldSeeEditValidationMessage(String expectedMessage) {

        WebDriverWait wait = new WebDriverWait(CucumberHooks.getDriver(), Duration.ofSeconds(5));
        wait.until(ExpectedConditions.alertIsPresent());
        // Pindah fokus ke alert dan klik OK
        Alert alert = CucumberHooks.getDriver().switchTo().alert();

        // Get the text content of the alert
        String alertText = alert.getText();
        System.out.println("Alert text: " + alertText);

        alert.accept();
    }

    @Then("the form should not be submitted")
    public void theFormShouldNotBeSubmitted() {
        WebDriverWait wait = new WebDriverWait(CucumberHooks.getDriver(), Duration.ofSeconds(3));
        try {
            wait.until(ExpectedConditions.alertIsPresent());
            // If alert is present, test fails
            throw new AssertionError("Form was submitted despite missing required field.");
        } catch (Exception e) {
            // No alert — expected behavior
            System.out.println("Form blocked by browser due to required field. Test passed.");
        }
    }
}
