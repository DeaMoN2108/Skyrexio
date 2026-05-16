package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import static pages.BasePage.DATA_TEST_PATTERN;

public class NavigationPanel {
    private final WebDriver driver;
    private final By cartLink = By.cssSelector(DATA_TEST_PATTERN.formatted("shopping-cart-link"));
    private final By cartBadge = By.cssSelector(DATA_TEST_PATTERN.formatted("shopping-cart-badge"));

    public NavigationPanel(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Нажимаю на иконку корзины")
    public void goToCart() {
        driver.findElement(cartLink).click();
    }

    @Step("Получаю количество товаров на иконке корзины")
    public String getCounterValue() {
        return driver.findElement(cartBadge).getText();
    }

    @Step("Получаю цвет бейджа на иконке корзины")
    public String getCounterColor() {
        return driver.findElement(cartBadge).getCssValue("background-color");
    }
}
