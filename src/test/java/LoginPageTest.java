import Pages.LoginPage;
import Pages.MainPage;
import Utils.UseCaseBase;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

public class LoginPageTest extends UseCaseBase {

    private static MainPage mainPage;
    private static LoginPage loginPage;

    private static final Logger logger = LogManager.getLogger(LoginPageTest.class);

    @BeforeAll
    public static void classSetup() {
        mainPage = new MainPage();
        loginPage = new LoginPage();
    }

    @BeforeEach
    public void beforeTest() {
        mainPage.navigateToBasePage();
        loginPage = mainPage.navigateToLoginPage();
    }

    @Test
    public void loginPageHeaderIsVisible() {
        assertTrue(loginPage.isPageHeaderVisible());
    }

    @ParameterizedTest
    @CsvSource({
            "'', ''",
            "invalid@Useremail.com, invalidPassword"
    })
    public void verifyErrorMessageEmptyOrInvalidUsernameAndPassword(String email, String password) {
        logger.info("Testing login with email: '{}' and password: '{}'", email, password);

        loginPage.populateEmailInput(email);
        loginPage.populatePasswordInput(password);
        loginPage.clickSignInButton();

        assertTrue(loginPage.isErrorMessageVisible(), "Error message should be displayed.");
        assertEquals("Incorrect email or password.", loginPage.getErrorMessageText());
        // CAPTCHA on the website, test is not able to verify the message
    }
}