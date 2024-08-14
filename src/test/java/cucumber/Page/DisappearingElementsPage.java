package cucumber.Page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import java.util.List;

public class DisappearingElementsPage {
    private WebDriver driver;

    public DisappearingElementsPage(WebDriver driver) {
        this.driver = driver;
    }

    public List<WebElement> getElements() {
        return driver.findElements(By.cssSelector("ul li"));
    }
}
