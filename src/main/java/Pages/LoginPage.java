package Pages;

import Locators.LoginPageLocators;

public class LoginPage extends BasePage {

    public boolean isPageHeaderVisible() {
        return elementExistsByXpath(LoginPageLocators.LOG_IN_LOGO);
    }

    public void populateEmailInput(String email){
        sendTextToElementByXpath(LoginPageLocators.LOG_IN_EMAIL_INPUT, email);
    }

    public void populatePasswordInput(String password){
        sendTextToElementByXpath(LoginPageLocators.LOG_IN_PASSWORD_INPUT, password);
    }

    public void clickSignInButton(){
        clickElementByXpath(LoginPageLocators.LOG_IN_SIGN_IN_BUTTON);
    }

    public boolean isErrorMessageVisible() {
        return elementExistsByXpath(LoginPageLocators.LOG_IN_ERROR_MESSAGE);
    }

    public String getErrorMessageText() {
        return findElementByXpath(LoginPageLocators.LOG_IN_ERROR_MESSAGE).getText();
    }

}
