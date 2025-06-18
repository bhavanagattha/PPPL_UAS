package steps;

import io.cucumber.java.en.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.LoginPage;

/**
 * Step definitions for login-related actions.
 */
public class LoginSteps {
    private static final Logger logger = LoggerFactory.getLogger(LoginSteps.class);
    private LoginPage loginPage;

    public LoginSteps() {
        logger.info("Initializing LoginSteps");
        loginPage = new LoginPage(CucumberHooks.getDriver());
    }

    @Given("I am on the login page")
    public void i_am_on_the_login_page() {
        logger.info("Navigating to login page");
        loginPage.open();
    }

    @When("I enter email {string}")
    public void i_enter_email(String email) {
        logger.info("Entering email: {}", email);
        loginPage.enterEmail(email);
    }

    @When("I enter password {string}")
    public void i_enter_password(String password) {
        logger.info("Entering password");
        loginPage.enterPassword(password);
    }

    @When("I click the login button")
    public void i_click_the_login_button() {
        logger.info("Clicking login button");
        loginPage.clickLoginButton();
    }
}