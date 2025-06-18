package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CreateTransactionPage {
    WebDriver driver;

    public CreateTransactionPage(WebDriver driver) {
        this.driver = driver;
    }

    By storeField = By.id("store_name");
    By productField = By.id("product_name");
    By exitDateField = By.id("exit_date");
    By priceField = By.id("price");
    By stockField = By.id("stock");
    By saveButton = By.xpath("//button[@type='submit' and contains(text(),'Simpan')]");

    public void enterStore(String store) {
        driver.findElement(storeField).clear();
        driver.findElement(storeField).sendKeys(store);
    }

    public void enterProduct(String product) {
        driver.findElement(productField).clear();
        driver.findElement(productField).sendKeys(product);
    }

    public void enterExitDate(String date) {
        WebElement dateInput = driver.findElement(exitDateField);
        dateInput.click();
        dateInput.clear(); // optional, tergantung browser
        dateInput.sendKeys(date); // Format harus yyyy-MM-dd
    }


    public void enterPrice(String price) {
        driver.findElement(priceField).clear();
        driver.findElement(priceField).sendKeys(price);
    }

    public void enterStock(String stock) {
        driver.findElement(stockField).clear();
        driver.findElement(stockField).sendKeys(stock);
    }

    public void clickSaveButton() {
        driver.findElement(saveButton).click();
    }
}
