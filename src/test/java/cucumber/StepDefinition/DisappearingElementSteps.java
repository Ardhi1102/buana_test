package cucumber.StepDefinition;

import cucumber.Page.DisappearingElementsPage;
import cucumber.Page.LandingPage;
import cucumber.util.CreateDriver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DisappearingElementSteps {
    private WebDriver driver;
    private LandingPage landingPage;
    private DisappearingElementsPage disappearingElements;

    public DisappearingElementSteps(){
        driver = CreateDriver.getInstance().getDriver();
    }
    @Given("I am on the landing page")
    public void iAmOnTheLandingPage() {
        driver.get("https://the-internet.herokuapp.com/");
        landingPage = new LandingPage(driver);
    }

    @When("I click on the {string} link")
    public void iClickOnTheLink(String linkText) {
        landingPage.getDisappearingElements().click();
        disappearingElements = new DisappearingElementsPage(driver);
    }

    @Then("I should see a list of elements")
    public void iShouldSeeAListOfElements() {
        int elementCount = disappearingElements.getElements().size();
        System.out.println("Number of elements: " + elementCount);
    }

    @And("I should log each element's text")
    public void iShouldLogEachElementSText() {
        for (WebElement element : disappearingElements.getElements()) {
            System.out.println("Element text: " + element.getText());
        }
    }

    @And("I should verify that the {string} element is not present")
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
}
