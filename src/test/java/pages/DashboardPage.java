package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

/**
 * Page Object Model untuk halaman dashboard.
 */
public class DashboardPage {
    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(id = "income-body")
    private WebElement incomeTable;

    @FindBy(xpath = "//a[@href='/transaksi']")
    private WebElement transactionButton;

    @FindBy(xpath = "//a[@href='/barang']")
    private WebElement expenseListButton;

    @FindBy(xpath = "//a[@href='/pegawai']")
    private WebElement employeeManagementButton;

    @FindBy(xpath = "//button[contains(text(), 'Logout')]")
    private WebElement logoutButton;

    @FindBy(xpath = "//button[contains(text(), 'Logout')]")
    private WebElement confirmLogoutButton;

    @FindBy(xpath = "//button[contains(text(), 'Batal')]")
    private WebElement cancelLogoutButton;

    public DashboardPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    public void clickTransactionButton() {
        wait.until(ExpectedConditions.elementToBeClickable(transactionButton)).click();
    }

    public void clickExpenseListButton() {
        wait.until(ExpectedConditions.elementToBeClickable(expenseListButton)).click();
    }

    public void clickEmployeeManagementButton() {
        wait.until(ExpectedConditions.elementToBeClickable(employeeManagementButton)).click();
    }

    public void clickLogoutButton() {
        wait.until(ExpectedConditions.elementToBeClickable(logoutButton)).click();
    }

    public void clickConfirmLogoutButton() {
        wait.until(ExpectedConditions.elementToBeClickable(confirmLogoutButton)).click();
    }

    public void clickCancelLogoutButton() {
        wait.until(ExpectedConditions.elementToBeClickable(cancelLogoutButton)).click();
    }

    public boolean isIncomeTableDisplayed() {
        return wait.until(ExpectedConditions.visibilityOf(incomeTable)).isDisplayed();
    }

    public boolean isEmployeeManagementButtonDisplayed() {
        try {
            return wait.until(ExpectedConditions.visibilityOf(employeeManagementButton)).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
}