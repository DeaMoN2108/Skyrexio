package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.*;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.util.*;

public class CartPage extends BasePage {

    private final By pageCart = By.xpath("//*[text()='Your Cart']");
    private final By productName = By.cssSelector(".inventory_item_name");
    private final By productPrice = By.cssSelector(".inventory_item_price");
    private final By continueShopBtn = By.id("continue-shopping");
    private final By checkoutBtn = By.id("checkout");

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public boolean pageCartDisplayed() {
        return driver.findElement(pageCart).isDisplayed();
    }

    @Step("Получение названий товаров, добавленных в корзину")
    public ArrayList<String> getProductsName() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(continueShopBtn));
        List<WebElement> allProducts = driver.findElements(productName);
        ArrayList<String> names = new ArrayList<>();
        for (WebElement product : allProducts) {
            names.add(product.getText());
        }
        return names;
    }

    @Step("Получение цены товара, добавленного в корзину")
    public double getProductPrice() {
        List<WebElement> allPrices = driver.findElements(productPrice);
        double counter = 0.0;
        for (WebElement priceElement : allPrices) {
            String priceText = priceElement.getText();
            priceText = priceText.replace("$", "").trim();
            double price = Double.parseDouble(priceText);
            counter += price;
        }
        return counter;
    }

    @Step("Нажимаю кнопку Checkout")
    public void goCheckPage() {
        driver.findElement(checkoutBtn).click();
    }
}
