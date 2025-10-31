package Locators;

public class ShoppingCartPageLocators {
    public static final String SHOPPING_CART_TITLE = "//div[@class='section-header text-center']";
    public static final String SHOPPING_CART_QUANTITY = "//input[@class='cart__qty-input']";
    public static final String UPDATE_BUTTON = "//input[@name='update' and contains(@class,'cart__update') and contains(@class,'cart__update--large')]";
    public static final String UNIT_PRICE = "(//span[@class='cbb-price-digits'])[1]";
    public static final String QUANTITY_INPUT = "//input[contains(@class,'cart__qty-input')]";
    public static final String TOTAL_PRICE = "(//span[@class='cbb-price-digits'])[last()]";


}
