package cucumber.util;

import cucumber.manager.BrowserManager;
import cucumber.manager.ChromeManager;
import cucumber.manager.FirefoxManager;
import cucumber.manager.RemoteManager;

public class DriverManager {

    public static BrowserManager getBrowserManager(String browser) {
        switch (browser) {
            case "firefox":
                return new FirefoxManager();
            case "chrome":
                return new ChromeManager();
            case "remote":
                return new RemoteManager();
            default:
                throw new RuntimeException("Unsupported webdriver: " + browser);
        }
    }
}
