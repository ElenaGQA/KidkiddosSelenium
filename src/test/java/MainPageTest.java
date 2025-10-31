import Pages.ContactUsPage;
import Pages.MainPage;
import Utils.UseCaseBase;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class MainPageTest extends UseCaseBase {

    private static MainPage mainPage;

    private static LogManager logManager;
    private static final Logger logger = LogManager.getLogger(MainPageTest.class);

    @BeforeAll
    public static void classSetup() {
        mainPage = new MainPage();
    }

    @BeforeEach
    public void beforeTest() {
        mainPage.navigateToBasePage();
    }

    @Test
    public void mainPageLoadTest() throws IOException {
        logger.info("main page loaded");
        mainPage.takeScreenshots("MainPageTest"); // throws IOException
        assertTrue(mainPage.isLogoVisible());
    }

    @Test
    public void openContactUsPage(){
        ContactUsPage contactUsPage = mainPage.navigateToContactUsPage();
        assertTrue(contactUsPage.isPageHeaderVisible());
    }


}
