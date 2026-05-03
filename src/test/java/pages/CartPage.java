package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage extends BasePage {

    private final By cartLink = By.cssSelector("[data-test='shopping-cart-link']");
    private final By pageCart = By.xpath("//*[text()='Your Cart']");

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public void goToCart() {
        driver.findElement(cartLink).click();
    }

    public boolean pageCartDisplayed() {
        return driver.findElement(pageCart).isDisplayed();
    }
}
