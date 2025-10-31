
import Locators.CollectionsPageLocators;
import Pages.CollectionsPage;
import Pages.MainPage;
import Pages.ProductPage;
import Pages.ShoppingCartPage;
import Utils.UseCaseBase;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ShoppingCartPageTest extends UseCaseBase {

    private static MainPage mainPage;
    private static ShoppingCartPage shoppingCartPage;
    private static CollectionsPage collectionsPage;
    private static ProductPage productPage;

    private static final Logger logger = LogManager.getLogger(ShoppingCartPageTest.class);

    @BeforeAll
    public static void classSetup() {
        mainPage = new MainPage();
        collectionsPage = new CollectionsPage();
        shoppingCartPage = new ShoppingCartPage();
        productPage = new ProductPage();
    }

    @BeforeEach
    public void beforeTest() {
        mainPage.navigateToBasePage();
    }

    @Test
    public void addBooksToCartChangeQuantityVerifyPrice() {
        mainPage.clickBooksByLanguage();
        mainPage.clickEnglishOnly();
        collectionsPage.clickClosePopupBanner();
        assertTrue(collectionsPage.verifyEnglishOnlyPageVisible());
        collectionsPage.selectBook(CollectionsPageLocators.I_LOVE_TO_BRUSH_MY_TEETH_BOOK);
        assertTrue(productPage.isProductTitleVisible("I Love to Brush My Teeth"));
        productPage.selectHardcoverBook();
        productPage.selectProductQuantity("5");
        productPage.clickAddToCartButton();
        assertTrue(shoppingCartPage.verifyShoppingCartPageVisible());
        shoppingCartPage.selectBookQuantity("6");
        shoppingCartPage.clickUpdateButton();
        assertTrue(shoppingCartPage.verifyCartTotalPrice());
    }
}