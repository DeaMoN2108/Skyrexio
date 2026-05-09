package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import user.User;

public class LoginPage extends BasePage {
    private final By userField = By.cssSelector("[id='user-name']");
    private final By passwordField = By.cssSelector("[id='password']");
    private final By submitButton = By.cssSelector(DATA_TEST_PATTERN.formatted("login-button"));
    private final By errorMessage = By.cssSelector(DATA_TEST_PATTERN.formatted("error"));

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @Step("Открываю страницу https://www.saucedemo.com/")
    public LoginPage open() {
        driver.get(BASE_URL);

        return this;
    }

    @Step("Авторизация пользователя: {user}")
    public LoginPage login(User user) {
        inLoginField(user.getLogin());
        inPassField(user.getPassword());
        driver.findElement(submitButton).click();

        return this;
    }

    @Step("Зполняю поле ввода Username")
    public void inLoginField(String login) {
        driver.findElement(userField).sendKeys(login);

    }

    @Step("Заполняю поле ввода Password")
    public void inPassField(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }

    @Step("Получаю цвет кнопки Login")
    public String getColorLoginBtn() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(submitButton));
        return driver.findElement(submitButton).getCssValue("background-color");
    }

    @Step("Проверяю, что сообщение об ошибке появилось")
    public boolean isErrorMsgDisplayed() {
        return driver.findElement(errorMessage).isDisplayed();
    }

    @Step("Получаю текст сообщения ошибки")
    public String getErrorMsg() {
        return driver.findElement(errorMessage).getText();
    }
}
