package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import steps.CucumberHooks;

import java.time.Duration;

/**
 * Page Object Model untuk halaman dashboard.
 */
public class DashboardPage {
    private static final Logger logger = LoggerFactory.getLogger(DashboardPage.class);
    private WebDriver driver;
    private WebDriverWait wait;

    // Updated locator (adjust based on actual HTML)
    @FindBy(css = "table.data-table") // Example: Use CSS selector for dashboard table
    private WebElement incomeTable;

    @FindBy(xpath = "//a[@href='/transaksi']")
    private WebElement transactionButton;

    @FindBy(xpath = "//a[@href='/barang']")
    private WebElement expenseListButton;

    @FindBy(xpath = "//a[@href='/pegawai']")
    private WebElement employeeManagementButton;

    @FindBy(xpath = "//a[@href='/dashboard']")
    private WebElement dashboardButton;

    @FindBy(xpath = "//button[contains(text(), 'Logout')]")
    private WebElement logoutButton;

    @FindBy(xpath = "//button[contains(text(), 'Logout')]")
    private WebElement confirmLogoutButton;

    @FindBy(xpath = "//button[contains(text(), 'Batal')]")
    private WebElement cancelLogoutButton;

    public DashboardPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20)); // Increased timeout
        PageFactory.initElements(driver, this);
    }

    public void clickTransactionButton() {
        logger.info("Clicking Transactions button");
        wait.until(ExpectedConditions.elementToBeClickable(transactionButton)).click();
    }

    public void clickDashboardButton() {
        logger.info("Clicking Dashboard button");
        wait.until(ExpectedConditions.elementToBeClickable(dashboardButton)).click();
    }

    public void clickLogoutButton() {
        logger.info("Clicking Logout button");
        wait.until(ExpectedConditions.elementToBeClickable(logoutButton)).click();
    }

    public void clickConfirmLogoutButton() {
        logger.info("Clicking Confirm Logout button");
        wait.until(ExpectedConditions.elementToBeClickable(confirmLogoutButton)).click();
    }

    public boolean isIncomeTableDisplayed() {
        try {
            logger.info("Checking if income table is displayed");
            return wait.until(ExpectedConditions.visibilityOf(incomeTable)).isDisplayed();
        } catch (Exception e) {
            logger.error("Income table not found: {}", e.getMessage());
            return false;
        }
    }


}