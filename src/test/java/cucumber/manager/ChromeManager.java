package cucumber.manager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class ChromeManager implements BrowserManager {
    @Override
    public WebDriver getDriver() {
        ChromeOptions options = new ChromeOptions();
         System.setProperty("webdriver.chrome.driver", "C:/Users/User/Downloads/chromedriver-win64/chromedriver-win64/chromedriver.exe");
//        options.addArguments("--headless=new"); // Ensure Chrome runs in headless mode
        options.addArguments("--window-size=1920,1080");
        options.addArguments("--force-device-scale-factor=0.55");
        options.addArguments("--high-dpi-support=0.55");
        options.addArguments("--allow-insecure-localhost");
        options.addArguments("--no-sandbox"); // Required for running Chrome in Docker
        options.addArguments("--disable-dev-shm-usage"); // Overcome limited resource problems
        options.addArguments("--disable-gpu"); // Disable GPU hardware acceleration
        options.addArguments("--disable-software-rasterizer"); // Disable software rasterizer
        options.addArguments("--incognito"); // Run Chrome in incognito mode


//        Map<String, Object> prefs = new HashMap<>();
//        prefs.put("profile.default_content_settings.popups", 0);
//        String path = System.getProperty("user.dir") + File.separator + "src" + File.separator + "test" + File.separator + "resources";
//        prefs.put("download.default_directory", path);
//        options.setExperimentalOption("prefs", prefs);

         Map<String, Object> prefs = new HashMap<>();
         prefs.put("download.default_directory", System.getProperty("user.dir") + "/src/test/resources"); // Updated to use forward slash for Linux
         options.setExperimentalOption("prefs", prefs);

        return new ChromeDriver(options);
    }
}