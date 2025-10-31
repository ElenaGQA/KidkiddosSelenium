package Pages;

import Consts.Consts;
import Locators.MainPageLocators;

public class MainPage extends BasePage {

    public void navigateToBasePage() {
        webDriver.get(Consts.MAIN_URL);
    }

    public boolean isLogoVisible() {
        return elementExistsByXpath(MainPageLocators.MAIN_PAGE_LOGO_IMAGE);
    }

    public ContactUsPage navigateToContactUsPage() {
        clickElementByXpath(MainPageLocators.CONTACT_US_BUTTON);
        return new ContactUsPage();
    }

    public LoginPage navigateToLoginPage(){
        clickElementByXpath(MainPageLocators.LOG_IN_BUTTON);
        return new LoginPage();
    }

    public void clickBooksByLanguage(){
        clickElementByXpath(MainPageLocators.BOOKS_BY_LANGUAGE_BUTTON);
    }

    public void clickEnglishOnly() {
        clickElementByXpath(MainPageLocators.ENGLISH_ONLY_BUTTON);
    }

}
