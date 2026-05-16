package tests;

import io.qameta.allure.*;
import org.testng.annotations.Test;
import java.util.List;
import static enums.TitleNaming.PRODUCTS;
import static org.testng.Assert.*;
import static user.UserFactory.withAdminPermission;

@Epic("Проверка страницы Product")
@Owner("Dmitriy Yaroshchuk test@test.ru")
public class ProductsTest extends BaseTest {
    List<String> goodsList =
            List.of("Sauce Labs Bolt T-Shirt",
                    "Sauce Labs Backpack",
                    "Test.allTheThings() T-Shirt (Red)");

    @Feature("Добавление товаров")
    @Story("Проверка добавление нескольких товаров на странице")
    @Severity(SeverityLevel.CRITICAL)
    @TmsLink("Skyrexio")
    @Issue("test")
    @Test(description = "Проверка добавление нескольких товаров на странице")
    public void checkGoodsAdded() {
        loginPage
                .open()
                .login(withAdminPermission());
        assertTrue(productsPage.isTitleDisplayed());
        assertEquals(productsPage.getTitle(), PRODUCTS.getDisplayName(), "Incorrect checkout page name");
        assertEquals(productsPage.getGoodsQuantity(), 6);
        for (String goods : goodsList) {
            productsPage.addToCart(goods);
        }
        assertEquals(productsPage.navigationPanel.getCounterValue(), "3");
        assertEquals(productsPage.navigationPanel.getCounterColor(), "rgba(226, 35, 26, 1)");
        productsPage.navigationPanel.goToCart();
        assertTrue(cartPage.pageCartDisplayed());
    }
}
