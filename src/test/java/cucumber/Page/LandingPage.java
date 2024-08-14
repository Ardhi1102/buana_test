package cucumber.Page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;

public class LandingPage {
    private WebDriver driver;

    public LandingPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getDisappearingElements() {
        return driver.findElement(By.linkText("Disappearing Elements"));
    }
}
