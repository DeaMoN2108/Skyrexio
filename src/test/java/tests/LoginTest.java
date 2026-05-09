package tests;

import io.qameta.allure.*;
import org.testng.annotations.*;
import user.User;
import static enums.TitleNaming.PRODUCTS;
import static org.testng.Assert.*;
import static user.UserFactory.*;

@Epic("Проверка страницы Login")
@Owner("Dmitriy Yaroshchuk test@test.ru")
public class LoginTest extends BaseTest {
    @Feature("Проверка авторизации")
    @Story("С корректными данными")
    @Severity(SeverityLevel.BLOCKER)
    @TmsLink("Skyrexio")
    @Issue("test")
    @Test(description = "Проверка авторизации")
    public void checkLogin() {
        loginPage.open();
        assertEquals(loginPage.getColorLoginBtn(), "rgba(61, 220, 145, 1)");
        loginPage.login(withAdminPermission());
        assertEquals(productsPage.getTitle(), PRODUCTS.getDisplayName());
    }

    @Feature("Проверка авторизации")
    @Story("С не корреткными данными")
    @Severity(SeverityLevel.CRITICAL)
    @TmsLink("Skyrexio")
    @Issue("test")
    @Test(description = "Проверка некорректной авторизации", dataProvider = "incorrectData")
    public void checkIncorrectLogin(User user, String errorMessage) {
        loginPage
                .open()
                .login(user);
        assertTrue(loginPage.isErrorMsgDisplayed(), "The error message fails to appear");
        assertEquals(loginPage.getErrorMsg(), errorMessage);
    }

    @DataProvider(name = "incorrectData")
    public Object[][] loginData() {
        return new Object[][]{
                {withLockedPermission(), "Epic sadface: Sorry, this user has been locked out."},
                {withEmptyLogPermission(), "Epic sadface: Username is required"},
                {withEmptyPassPermission(), "Epic sadface: Password is required"},
                {withIncorrectPermission(), "Epic sadface: Username and password do not match any user in this service"}
        };
    }
}
