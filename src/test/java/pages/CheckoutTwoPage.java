package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CheckoutTwoPage extends BasePage {

    private final By productTotalPrice = By.cssSelector(".summary_total_label");
    private final By completeHeader = By.cssSelector(".complete-header");
    private final By backHomeBtn = By.id("back-to-products");
    private final By finishBtn = By.id("finish");

    public CheckoutTwoPage(WebDriver driver) {
        super(driver);
    }

    @Step("Кнопка Finish видна")
    public boolean isFinishBtnDisplayed() {
        return driver.findElement(finishBtn).isDisplayed();
    }

    @Step("Кнопка Finish активна")
    public boolean isFinishBtnEnabled() {
        return driver.findElement(finishBtn).isEnabled();
    }

    @Step("Получаю название кнопки Finish")
    public String getFinishBtnName() {
        return driver.findElement(finishBtn).getText();
    }

    @Step("Получение итоговой цены товаров в корзине")
    public double getTotalPrice() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(productTotalPrice));
        String totalPriceElement = driver.findElement(productTotalPrice).getText();
        totalPriceElement = totalPriceElement.replace("$", "").replace("Total:", "").trim();
        return Double.parseDouble(totalPriceElement);
    }

    @Step("Нажимаю кнопку Finish")
    public void goFinishPage() {
        driver.findElement(finishBtn).click();
    }

    @Step("Получаю текст сообщения об успешном оформлении заказа")
    public String getFinishMessage() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(backHomeBtn));
        return driver.findElement(completeHeader).getText();
    }
}
