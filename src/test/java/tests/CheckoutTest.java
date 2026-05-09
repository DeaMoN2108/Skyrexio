package tests;

import io.qameta.allure.*;
import org.testng.annotations.Test;
import static enums.TitleNaming.CHECKOUT;
import static org.testng.Assert.*;
import static user.UserFactory.withAdminPermission;

@Epic("Проверка страниц Checkout")
@Owner("Dmitriy Yaroshchuk test@test.ru")
public class CheckoutTest extends BaseTest {
    final String goodsName = "Sauce Labs Backpack";

    @Story("Проверка перехода к оформлению заказа, отображения элементов")
    @Severity(SeverityLevel.BLOCKER)
    @TmsLink("Skyrexio")
    @Issue("test")
    @Test(description = "Проверка оформления заказа")
    public void checkGoToOrder() {
        loginPage
                .open()
                .login(withAdminPermission());
        productsPage.addToCart(goodsName);
        productsPage.navigationPanel.goToCart();
        cartPage.goCheckPage();
        soft.assertEquals(productsPage.getTitle(), CHECKOUT.getDisplayName(), "Incorrect checkout page name");
        soft.assertTrue(checkoutOnePage.isCancelBtnDisplayed(), "The cancel button did not appear");
        soft.assertTrue(checkoutOnePage.isCancelBtnEnabled(), "The cancel button is not active");
        soft.assertEquals(checkoutOnePage.getCancelBtnName(), "Cancel", "Incorrect cancel button name");
        soft.assertTrue(checkoutOnePage.isContinueBtnDisplayed(), "The continue button did not appear");
        soft.assertTrue(checkoutOnePage.isContinueBtnEnabled(), "The continue button is not active");
        soft.assertEquals(checkoutOnePage.getContinueBtnName(), "Continue", "Incorrect continue button name");
        soft.assertAll();
    }

    @Story("Заказ успешно оформлен")
    @Severity(SeverityLevel.BLOCKER)
    @TmsLink("Skyrexio")
    @Issue("test")
    @Test(description = "Проверка оформления заказа")
    public void checkMakeAnOrder() {
        loginPage
                .open()
                .login(withAdminPermission());
        productsPage.addToCart(goodsName);
        productsPage.navigationPanel.goToCart();
        cartPage.goCheckPage();
        checkoutOnePage.infoBuyer(withAdminPermission());
        checkoutOnePage.goOverviewPage();
        soft.assertTrue(checkoutOnePage.isCancelBtnDisplayed(), "The cancel button did not appear");
        soft.assertTrue(checkoutOnePage.isCancelBtnEnabled(), "The cancel button is not active");
        soft.assertEquals(checkoutOnePage.getCancelBtnName(), "Cancel", "Incorrect cancel button name");
        soft.assertTrue(checkoutTwoPage.isFinishBtnDisplayed(), "The finish button did not appear");
        soft.assertTrue(checkoutTwoPage.isFinishBtnEnabled(), "The finish button is not active");
        soft.assertEquals(checkoutTwoPage.getFinishBtnName(), "Finish", "Incorrect finish button name");
        soft.assertAll();
        assertEquals(checkoutTwoPage.getTotalPrice(), Math.round((cartPage.getProductPrice() + cartPage.getProductPrice() * 0.08) * 100.0) / 100.0);
        checkoutTwoPage.goFinishPage();
        assertEquals(checkoutTwoPage.getFinishMessage(), "Thank you for your order!", "The success message is not correct.");
    }
}
