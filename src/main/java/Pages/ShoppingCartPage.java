package Pages;

import Locators.ShoppingCartPageLocators;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ShoppingCartPage extends BasePage{

    public boolean verifyShoppingCartPageVisible() {
        return elementExistsByXpath(ShoppingCartPageLocators.SHOPPING_CART_TITLE);
    }

    public void selectBookQuantity(String num){
        sendTextToElementByXpath(ShoppingCartPageLocators.SHOPPING_CART_QUANTITY, "6");
    }

    public void clickUpdateButton(){
        clickElementByXpath(ShoppingCartPageLocators.UPDATE_BUTTON);
    }

    public boolean verifyCartTotalPrice() {
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(10));
        WebElement unitPriceElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(ShoppingCartPageLocators.UNIT_PRICE)));
        WebElement quantityElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(ShoppingCartPageLocators.QUANTITY_INPUT)));
        WebElement totalPriceElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(ShoppingCartPageLocators.TOTAL_PRICE)));

        String unitPriceText = unitPriceElement.getText().replace("$", "").replace("CAD", "").trim();
        String totalPriceText = totalPriceElement.getText().replace("$", "").replace("CAD", "").trim();
        String quantityText = quantityElement.getAttribute("value").trim();

        double unitPrice = Double.parseDouble(unitPriceText);
        double totalPrice = Double.parseDouble(totalPriceText);
        int quantity = Integer.parseInt(quantityText);

        double expectedTotal = unitPrice * quantity;

        expectedTotal = Math.round(expectedTotal * 100.0) / 100.0;
        totalPrice = Math.round(totalPrice * 100.0) / 100.0;

        return expectedTotal == totalPrice;
    }

}
