package cucumber.util;

import org.openqa.selenium.WebDriver;

import java.net.MalformedURLException;


public class CreateDriver {

    private static CreateDriver INSTANCE;

    private ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    private CreateDriver() {

    }

    public static synchronized CreateDriver getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new CreateDriver();
        }
        return INSTANCE;
    }

    public void setDriver(String browser) throws MalformedURLException {
        driver.set(DriverManager.getBrowserManager(browser).getDriver());
    }

    public WebDriver getDriver() {
        return driver.get();
    }
}
