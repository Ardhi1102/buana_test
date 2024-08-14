package cucumber.manager;

import org.openqa.selenium.WebDriver;

import java.net.MalformedURLException;

public interface BrowserManager {
    WebDriver getDriver() throws MalformedURLException;
}
