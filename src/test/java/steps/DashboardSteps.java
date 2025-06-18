package steps;

import io.cucumber.java.en.*;
import org.junit.jupiter.api.Assertions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.DashboardPage;
import pages.LoginPage;

/**
 * Step definitions for dashboard navigation and logout actions.
 */
public class DashboardSteps {
    private static final Logger logger = LoggerFactory.getLogger(DashboardSteps.class);
    private DashboardPage dashboardPage;
    private LoginPage loginPage;

    public DashboardSteps() {
        logger.info("Initializing DashboardSteps");
        dashboardPage = new DashboardPage(CucumberHooks.getDriver());
        loginPage = new LoginPage(CucumberHooks.getDriver());
    }

    @When("I click the Transactions button")
    public void i_click_the_transactions_button() {
        logger.info("Clicking Transactions button");
        dashboardPage.clickTransactionButton();
    }

    @When("I click the Dashboard button")
    public void i_click_the_dashboard_button() {
        logger.info("Clicking Dashboard button");
        dashboardPage.clickDashboardButton();
    }

    @When("I click the Logout button")
    public void i_click_the_logout_button() {
        logger.info("Clicking Logout button");
        dashboardPage.clickLogoutButton();
    }

    @When("I click the Confirm Logout button")
    public void i_click_the_confirm_logout_button() {
        logger.info("Clicking Confirm Logout button");
        dashboardPage.clickConfirmLogoutButton();
    }

    @Then("I should be redirected to the dashboard page")
    public void i_should_be_redirected_to_the_dashboard_page() {
        logger.info("Verifying dashboard redirect. Current URL: {}", CucumberHooks.getDriver().getCurrentUrl());
        String currentUrl = CucumberHooks.getDriver().getCurrentUrl();
        if (!currentUrl.equals("https://padwebkeuangan-production.up.railway.app/dashboard")) {
            logger.error("Unexpected URL: {}. Page source: {}", currentUrl, dashboardPage.getPageSource());
            Assertions.fail("Not redirected to dashboard page. Actual URL: " + currentUrl);
        }
        Assertions.assertTrue(dashboardPage.isIncomeTableDisplayed(), "Dashboard indicator not displayed");
    }

    @Then("I should be redirected to the login page")
    public void i_should_be_redirected_to_the_login_page() {
        logger.info("Verifying login page redirect. Current URL: {}", CucumberHooks.getDriver().getCurrentUrl());
        String currentUrl = CucumberHooks.getDriver().getCurrentUrl();
        Assertions.assertEquals("https://padwebkeuangan-production.up.railway.app/", currentUrl,
                "Not redirected to login page. Actual URL: " + currentUrl);
    }
}