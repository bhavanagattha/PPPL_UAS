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
 * Page Object Model untuk halaman daftar pengeluaran.
 */
public class ExpenseListPage {
    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(id = "expense-body")
    private WebElement expenseTable;

    @FindBy(xpath = "//a[@href='/barang/tambah']")
    private WebElement addButton;

    @FindBy(xpath = "//a[@href='/barang/unduh']")
    private WebElement downloadButton;

    @FindBy(id = "date")
    private WebElement dateField;

    @FindBy(id = "amount")
    private WebElement amountField;

    @FindBy(id = "description")
    private WebElement descriptionField;

    @FindBy(id = "start_date")
    private WebElement startDateField;

    @FindBy(id = "end_date")
    private WebElement endDateField;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement saveButton;

    @FindBy(xpath = "//button[@type='submit' and contains(text(), 'Konfirmasi')]")
    private WebElement confirmDownloadButton;

    @FindBy(xpath = "//a[.//span[text()='Edit']]")
    private List<WebElement> editButtons;

    @FindBy(xpath = "//button[.//span[text()='Hapus']]")
    private List<WebElement> deleteButtons;

    @FindBy(xpath = "//button[text()='Hapus']")
    private WebElement confirmDeleteButton;

    @FindBy(xpath = "//button[text()='Batal']")
    private WebElement cancelDeleteButton;

    @FindBy(id = "per_page")
    private WebElement perPageDropdown;

    public ExpenseListPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    public void clickAddButton() {
        wait.until(ExpectedConditions.elementToBeClickable(addButton)).click();
    }

    public void clickDownloadButton() {
        wait.until(ExpectedConditions.elementToBeClickable(downloadButton)).click();
    }

    public void enterDate(String date) {
        wait.until(ExpectedConditions.visibilityOf(dateField)).clear();
        dateField.sendKeys(date);
    }

    public void enterAmount(String amount) {
        amountField.clear();
        amountField.sendKeys(amount);
    }

    public void enterDescription(String description) {
        descriptionField.clear();
        descriptionField.sendKeys(description);
    }

    public void enterStartDate(String startDate) {
        wait.until(ExpectedConditions.visibilityOf(startDateField)).clear();
        startDateField.sendKeys(startDate);
    }

    public void enterEndDate(String endDate) {
        endDateField.clear();
        endDateField.sendKeys(endDate);
    }

    public void clickSaveButton() {
        wait.until(ExpectedConditions.elementToBeClickable(saveButton)).click();
    }

    public void clickConfirmDownloadButton() {
        wait.until(ExpectedConditions.elementToBeClickable(confirmDownloadButton)).click();
    }

    public void clickEditButton(int index) {
        wait.until(ExpectedConditions.visibilityOfAllElements(editButtons));
        editButtons.get(index).click();
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

    public boolean isExpenseTableDisplayed() {
        return wait.until(ExpectedConditions.visibilityOf(expenseTable)).isDisplayed();
    }

    public boolean isAddExpensePageDisplayed() {
        return wait.until(ExpectedConditions.visibilityOf(dateField)).isDisplayed();
    }

    public boolean isEditExpensePageDisplayed() {
        return wait.until(ExpectedConditions.visibilityOf(dateField)).isDisplayed();
    }

    public boolean isDownloadPageDisplayed() {
        return wait.until(ExpectedConditions.visibilityOf(startDateField)).isDisplayed();
    }
}