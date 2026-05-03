package tests;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class ProductsTest extends Basetest {
    @Test
    public void checkLogin() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        assertTrue(productsPage.pageTitleDisplayed());
        productsPage.addToCart();
        assertEquals(productsPage.checkCounterValue(), "1");
        assertEquals(productsPage.checkCounterColor(), "rgba(226, 35, 26, 1)");
        cartPage.goToCart();
        assertTrue(cartPage.pageCartDisplayed());
    }
}
