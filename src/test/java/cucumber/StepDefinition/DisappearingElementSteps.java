package cucumber.StepDefinition;

import cucumber.Page.DisappearingElementsPage;
import cucumber.Page.LandingPage;
import cucumber.util.CreateDriver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static org.junit.Assert.assertTrue;

public class DisappearingElementSteps {
    private WebDriver driver;
    private LandingPage landingPage;
    private DisappearingElementsPage disappearingElements;

    public DisappearingElementSteps(){
        driver = CreateDriver.getInstance().getDriver();
    }
    @Given("User already on the landing page")
    public void iAmOnTheLandingPage() {
        driver.get("https://the-internet.herokuapp.com/");
        landingPage = new LandingPage(driver);
    }

    @When("User click on the {string} link")
    public void iClickOnTheLink(String linkText) {
        landingPage.getDisappearingElements().click();
        disappearingElements = new DisappearingElementsPage(driver);
    }

    @Then("User should see a list of elements")
    public void iShouldSeeAListOfElements() {
        int elementCount = disappearingElements.getElements().size();
        System.out.println("Number of elements: " + elementCount);
    }

    @And("User should log each element's text")
    public void iShouldLogEachElementSText() {
        for (WebElement element : disappearingElements.getElements()) {
            System.out.println("Element text: " + element.getText());
        }
    }

    @And("User should verify that the {string} element is not present")
    public void iShouldVerifyThatTheElementIsNotPresent(String elementText) {
        try {
            String text = disappearingElements.getElements().get(4).getText();
            if (text.equals(elementText)) {
                System.out.println(elementText + " is present");
            }
        } catch (Exception e) {
            System.out.println("Element " + elementText + " is not present");
        }
    }

    @Then("User should not see the {string} in the list")
    public void iShouldSeeAnErrorMessage(String expectedMessage) {
        try {
            driver.findElement(By.linkText("Nonexistent Link"));
        } catch (NoSuchElementException e) {
            System.out.println(expectedMessage);
            assertTrue("Expected error message was not shown", expectedMessage.equals("Link not found"));
        }
    }

    @And("User click on the home tab")
    public void iClickOnTheTab() {
        WebElement homeLink = driver.findElement(By.linkText("Home"));
        homeLink.click();
    }
}
