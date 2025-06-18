package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class EditTransactionPage {
    WebDriver driver;

    public EditTransactionPage(WebDriver driver) {
        this.driver = driver;
    }

    By entryDateField = By.id("entry_date");
    By soldField = By.id("sold");
    By saveButton = By.xpath("//button[@type='submit' and contains(text(),'Simpan')]");

    public void enterEntryDate(String entryDate) {
        driver.findElement(entryDateField).clear();
        driver.findElement(entryDateField).sendKeys(entryDate);
    }

    public void enterSold(String sold) {
        driver.findElement(soldField).clear();
        driver.findElement(soldField).sendKeys(sold);
    }

    public void clickSaveButton() {
        driver.findElement(saveButton).click();
    }
}
