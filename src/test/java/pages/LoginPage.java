package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    WebDriver driver;
    private final By userField = By.cssSelector("[id='user-name']");
    private final By passwordField = By.cssSelector("[id='password']");
    private final By submitButton = By.cssSelector("[data-test='login-button']");
    private final By errorMessage = By.xpath("//*[@data-test='error']");
    private final By errorMessageLog = By.xpath("//*[@data-test='error']");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void open() {
        driver.get("https://www.saucedemo.com/");
    }

    public void login(String login, String password) {
        driver.findElement(userField).sendKeys(login);
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(submitButton).click();
    }

    public boolean isErrorMsgDisplayed() {
        return driver.findElement(errorMessage).isDisplayed();
    }

    public String errorMsgLogin() {
        return driver.findElement(errorMessageLog).getText();
    }
}
