package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import user.User;

public class CheckoutOnePage extends BasePage {

    private final By continueBtn = By.id("continue");
    private final By cancelBtn = By.id("cancel");
    private final By firstNameField = By.id("first-name");
    private final By lastNameField = By.id("last-name");
    private final By postalCodeField = By.id("postal-code");

    public CheckoutOnePage(WebDriver driver) {
        super(driver);
    }

    @Step("Заполняю данные о покупателе")
    public void infoBuyer(User user) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(continueBtn));
        inFirstNameField(user.getFirst_name());
        inLastNameField(user.getLast_name());
        inPostalCodeField(String.valueOf(user.getPostal_code()));
    }

    @Step("Кнопка Cancel видна")
    public boolean isCancelBtnDisplayed() {
        return driver.findElement(cancelBtn).isDisplayed();
    }

    @Step("Кнопка Cancel активна")
    public boolean isCancelBtnEnabled() {
        return driver.findElement(cancelBtn).isEnabled();
    }

    @Step("Получаю название кнопки Cancel")
    public String getCancelBtnName() {
        return driver.findElement(cancelBtn).getText();
    }

    @Step("Кнопка Continue видна")
    public boolean isContinueBtnDisplayed() {
        return driver.findElement(continueBtn).isDisplayed();
    }

    @Step("Кнопка Continue активна")
    public boolean isContinueBtnEnabled() {
        return driver.findElement(continueBtn).isEnabled();
    }

    @Step("Получаю название кнопки Continue")
    public String getContinueBtnName() {
        return driver.findElement(continueBtn).getAttribute("value");
    }

    @Step("Заполняю поле ввода First name")
    public void inFirstNameField(String first_name) {
        driver.findElement(firstNameField).sendKeys(first_name);
    }

    @Step("Заполняю поле ввода Last name")
    public void inLastNameField(String last_name) {
        driver.findElement(lastNameField).sendKeys(last_name);
    }

    @Step("Заполняю поле вода Zip/Postal code")
    public void inPostalCodeField(String postal_code) {
        driver.findElement(postalCodeField).sendKeys(postal_code);
    }

    @Step("Нажимаю кнопку Continue")
    public void goOverviewPage() {
        driver.findElement(continueBtn).click();
    }
}
