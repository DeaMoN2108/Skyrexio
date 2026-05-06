package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {
    private final By userField = By.cssSelector("[id='user-name']");
    private final By passwordField = By.cssSelector("[id='password']");
    private final By submitButton = By.cssSelector("[data-test='login-button']");
    private final By errorMessage = By.xpath("//*[@data-test='error']");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void open() {
        driver.get(BASE_URL);
    }

    public void login(String login, String password) {
        inLoginField(login);
        inPassField(password);
        driver.findElement(submitButton).click();
    }

    public void inLoginField(String login) {
        driver.findElement(userField).sendKeys(login);
    }

    public void inPassField(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }

    public boolean isErrorMsgDisplayed() {
        return driver.findElement(errorMessage).isDisplayed();
    }

    public String getErrorMsg() {
        return driver.findElement(errorMessage).getText();
    }
}
