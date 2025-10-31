package Pages;

import Locators.CollectionsPageLocators;


public class CollectionsPage extends BasePage {

    public boolean verifyEnglishOnlyPageVisible() {
        return elementExistsByXpath(CollectionsPageLocators.ENGLISH_ONLY_PAGE_LOGO);
    }

    public void clickClosePopupBanner() {
        clickElementByXpath(CollectionsPageLocators.COLLECTIONS_POPUP_BANNER);
    }

    public void selectBook(String xpath) {
        clickElementByXpath(xpath);
    }


}
