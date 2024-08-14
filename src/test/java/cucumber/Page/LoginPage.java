package cucumber.Page;

import cucumber.util.PropertiesLoader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class LoginPage {
    private final String FIELD_EMAIL = "sign_in_text_input_email";
    private final String FIELD_PASSWORD = "sign_in_text_input_password";
    private final String BTN_SIGN_IN = "sign_in_button_sign_in";
    private final String HOME_PAGE = "https://qonek-uat.web.app/chat";
    private final String WARN = "warn";

    private WebDriver driver;
    private WebDriverWait wait;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(this.driver, Duration.ofSeconds(300));
    }

    public void inputEmail(String email) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(FIELD_EMAIL)));
        WebElement element = driver.findElement(By.id(FIELD_EMAIL));

        element.sendKeys(email);
    }

    public void inputPassword(String password) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(FIELD_PASSWORD)));
        WebElement element = driver.findElement(By.id(FIELD_PASSWORD));

        element.sendKeys(password);
    }

    public void clickSignIn() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(BTN_SIGN_IN)));
        WebElement element = driver.findElement(By.id(BTN_SIGN_IN));

        element.click();
    }

    public void validateInHomePage() {
        wait.until(ExpectedConditions.urlToBe(HOME_PAGE));

        String actualUrl = driver.getCurrentUrl();
        assert actualUrl.equals(HOME_PAGE);
    }

    public void validateLoginErrorMessage(String text) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className(WARN)));
        WebElement element = driver.findElement(By.className(WARN));

        assert element.getText().equals(text) : "actual: " + element.getText() + " expected: " + text;
    }
}
