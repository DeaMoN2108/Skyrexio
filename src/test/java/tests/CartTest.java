package tests;

import io.qameta.allure.*;
import org.testng.annotations.Test;
import static enums.TitleNaming.CART;
import static org.testng.Assert.*;
import static user.UserFactory.withAdminPermission;

@Epic("Проверка страницы Your cart")
@Owner("Dmitriy Yaroshchuk test@test.ru")
public class CartTest extends BaseTest {
    final String goodsName = "Test.allTheThings() T-Shirt (Red)";

    @Story("Добавление товара в корзину")
    @Severity(SeverityLevel.BLOCKER)
    @TmsLink("Skyrexio")
    @Issue("test")
    @Test(description = "Проверка добавленного товара в корзину")
    public void checkGoodsInCart() {
        loginPage
                .open()
                .login(withAdminPermission());
        productsPage.addToCart(goodsName);
        productsPage.navigationPanel.goToCart();
        assertEquals(productsPage.getTitle(), CART.getDisplayName(), "Incorrect checkout page name");
        assertFalse(cartPage.getProductsName().isEmpty());
        assertEquals(cartPage.getProductsName().size(), 1);
        assertTrue(cartPage.getProductsName().contains(goodsName));
        cartPage.goCheckPage();
    }
}
