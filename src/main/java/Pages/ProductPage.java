package Pages;

import Locators.ProductPageLocators;

public class ProductPage extends BasePage{

    public boolean isProductTitleVisible(String expectedTitle) {
        return isTextVisibleByXpath(ProductPageLocators.PRODUCT_TITLE, expectedTitle);
    }

    public void selectHardcoverBook(){
        clickElementByXpath(ProductPageLocators.PRODUCT_PAGE_FORMAT_SELECTOR);
        clickElementByXpath(ProductPageLocators.PRODUCT_PAGE_HARDCOVER);
    }

    public void selectProductQuantity(String num) {
        sendTextToElementByXpath(ProductPageLocators.PRODUCT_PAGE_QUANTITY, num);
    }

    public void clickAddToCartButton(){
        clickElementByXpath(ProductPageLocators.PRODUCT_PAGE_ADD_TO_CART_BUTTON);
    }
}
