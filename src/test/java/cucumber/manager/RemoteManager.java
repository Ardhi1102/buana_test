package cucumber.manager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class RemoteManager implements BrowserManager {
    @Override
    public WebDriver getDriver() throws MalformedURLException {
        URL hubUrl = new URL("http://selenium-hub:4444/wd/hub");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        options.addArguments("--window-size=1920,1080");
        return new RemoteWebDriver(hubUrl, options);
    }
}
