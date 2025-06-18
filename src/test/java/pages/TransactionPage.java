package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

/**
 * Page Object Model untuk halaman transaksi.
 */
public class TransactionPage {
    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(id = "consignment-body")
    private WebElement transactionTable;

    @FindBy(xpath = "//a[@href='https://frontend-alganis-production.up.railway.app/transaksi/tambah']")
    private WebElement addButton;

    @FindBy(id = "date")
    private WebElement dateField;

    @FindBy(id = "amount")
    private WebElement amountField;

    @FindBy(id = "description")
    private WebElement descriptionField;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement saveButton;

    @FindBy(xpath = "//*[@id=\"consignment-body\"]/tr[1]/td[11]/a[1]")
    private WebElement editButton;

    @FindBy(xpath = "//button[.//span[text()='Hapus']]")
    private List<WebElement> deleteButtons;

    @FindBy(xpath = "//button[text()='Hapus']")
    private WebElement confirmDeleteButton;

    @FindBy(xpath = "//button[text()='Batal']")
    private WebElement cancelDeleteButton;

    @FindBy(id = "per_page")
    private WebElement perPageDropdown;

    public TransactionPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    public void clickAddTransactionButton() {
        wait.until(ExpectedConditions.elementToBeClickable(addButton)).click();
    }

    public void clickEditButton() {
        wait.until(ExpectedConditions.visibilityOfAllElements(editButton));
        editButton.click();
    }

    public void clickDeleteButton(int index) {
        wait.until(ExpectedConditions.visibilityOfAllElements(deleteButtons));
        deleteButtons.get(index).click();
    }

    public void clickConfirmDeleteButton() {
        wait.until(ExpectedConditions.elementToBeClickable(confirmDeleteButton)).click();
    }

    public void clickCancelDeleteButton() {
        wait.until(ExpectedConditions.elementToBeClickable(cancelDeleteButton)).click();
    }

    public void selectItemsPerPage(String value) {
        wait.until(ExpectedConditions.elementToBeClickable(perPageDropdown)).click();
        perPageDropdown.findElement(org.openqa.selenium.By.xpath(String.format("//option[@value='%s']", value))).click();
    }

    public boolean isTransactionTableDisplayed() {
        return wait.until(ExpectedConditions.visibilityOf(transactionTable)).isDisplayed();
    }

    public boolean isAddTransactionPageDisplayed() {
        return wait.until(ExpectedConditions.visibilityOf(dateField)).isDisplayed();
    }

    public boolean isEditTransactionPageDisplayed() {
        return wait.until(ExpectedConditions.visibilityOf(dateField)).isDisplayed();
    }
}