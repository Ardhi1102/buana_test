package cucumber.StepDefinition;

import cucumber.util.CreateDriver;
import cucumber.util.PropertiesLoader;
import io.cucumber.java.Scenario;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Properties;

public class Hooks {

    public WebDriver driver;
    public Scenario scenario;

    @Before
    public void openBrowser(Scenario scenario) throws IOException {
        this.scenario = scenario;
        Properties conf = PropertiesLoader.loadProperties();
        String instance = conf.getProperty("instance");

        CreateDriver.getInstance().setDriver(instance);
        driver = CreateDriver.getInstance().getDriver();
        driver.manage().window().maximize();
//        driver.manage().deleteAllCookies();
    }

    @After
    public void tearDown(Scenario scenario){
//        if(scenario.isFailed()) {
//            try {
//                scenario.write("Current Page URL is " + driver.getCurrentUrl());
//                byte[] screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
//                scenario.embed(screenshot, "image/png");
//            } catch (WebDriverException somePlatformsDontSupportScreenshots) {
//                System.err.println(somePlatformsDontSupportScreenshots.getMessage());
//            }
//        }
        driver.quit();
    }

//    @AfterStep
//    public void screenshot(Scenario scenario){
////        scenario.write("Current Page URL is " + driver.getCurrentUrl());
////        byte[] screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
////        scenario.embed(screenshot, "image/png");
//    }
}
