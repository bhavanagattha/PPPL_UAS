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
        WebDriverWait wait = new WebDriverWait(CucumberHooks.getDriver(), Duration.ofSeconds(5));
        wait.until(ExpectedConditions.alertIsPresent());
        // Pindah fokus ke alert dan klik OK
        Alert alert = CucumberHooks.getDriver().switchTo().alert();
        alert.accept();
    }
}
