package Pages;

import Locators.ContactUsPageLocators;

public class ContactUsPage extends BasePage {

    public boolean isPageHeaderVisible() {
        return elementExistsByXpath(ContactUsPageLocators.CONTACT_US_HEADER);
    }
}
