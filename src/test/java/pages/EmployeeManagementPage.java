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
 * Page Object Model untuk halaman manajemen pegawai.
 */
public class EmployeeManagementPage {
    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(id = "user-body")
    private WebElement userTable;

    @FindBy(xpath = "//a[@href='/pegawai/tambah']")
    private WebElement addButton;

    @FindBy(id = "search")
    private WebElement searchField;

    @FindBy(id = "name")
    private WebElement nameField;

    @FindBy(id = "email")
    private WebElement emailField;

    @FindBy(id = "password")
    private WebElement passwordField;

    @FindBy(id = "password_confirmation")
    private WebElement passwordConfirmationField;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement saveButton;

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

    public EmployeeManagementPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    public void clickAddButton() {
        wait.until(ExpectedConditions.elementToBeClickable(addButton)).click();
    }

    public void enterSearchQuery(String query) {
        wait.until(ExpectedConditions.visibilityOf(searchField)).clear();
        searchField.sendKeys(query);
        searchField.submit();
    }

    public void enterName(String name) {
        wait.until(ExpectedConditions.visibilityOf(nameField)).clear();
        nameField.sendKeys(name);
    }

    public void enterEmail(String email) {
        emailField.clear();
        emailField.sendKeys(email);
    }

    public void enterPassword(String password) {
        passwordField.clear();
        passwordField.sendKeys(password);
    }

    public void enterPasswordConfirmation(String password) {
        passwordConfirmationField.clear();
        passwordConfirmationField.sendKeys(password);
    }

    public void clickSaveButton() {
        wait.until(ExpectedConditions.elementToBeClickable(saveButton)).click();
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

    public boolean isUserTableDisplayed() {
        return wait.until(ExpectedConditions.visibilityOf(userTable)).isDisplayed();
    }

    public boolean isAddEmployeePageDisplayed() {
        return wait.until(ExpectedConditions.visibilityOf(nameField)).isDisplayed();
    }

    public boolean isEditEmployeePageDisplayed() {
        return wait.until(ExpectedConditions.visibilityOf(nameField)).isDisplayed();
    }
}