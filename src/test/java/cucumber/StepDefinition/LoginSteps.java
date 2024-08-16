package cucumber.StepDefinition;

import cucumber.util.CreateDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertFalse;

public class LoginSteps {

    private WebDriver driver;

    public LoginSteps(){
        driver = CreateDriver.getInstance().getDriver();
    }

    @Given("User open basic authentication page")
    public void userOpenBasicAuthenticationPage() {
        driver.get("http://admin:admin@the-internet.herokuapp.com/basic_auth/");
        driver.get("http://the-internet.herokuapp.com/basic_auth");
    }

    @Then("Verify user success login")
    public void verifyUserSuccessLogin() {
        String pageMessage = driver.findElement(By.cssSelector("p")).getText();
        String expectedMessage = "Congratulations! You must have the proper credentials.";
        assertEquals(pageMessage, expectedMessage);
    }

    @Then("Verify user failed to login")
    public void verifyUserFailedToLogin() {
        driver.get("http://the-internet.herokuapp.com/basic_auth");
    }

    @Given("User open basic authentication page with incorrect credential")
    public void userOpenBasicAuthenticationPageWithIncorrectCredential() {
        driver.get("http://lalala123:lalala123@the-internet.herokuapp.com/basic_auth/");
    }

    @Given("User open basic authentication page with empty username")
    public void userOpenBasicAuthenticationPageWithEmptyUsername() {
        driver.get("http://:admin@the-internet.herokuapp.com/basic_auth/");
    }

    @Given("User open basic authentication page with empty password")
    public void userOpenBasicAuthenticationPageWithEmptyPassword() {
        driver.get("http://admin:@the-internet.herokuapp.com/basic_auth/");
    }

    @Given("User open basic authentication page with empty username and password")
    public void userOpenBasicAuthenticationPageWithEmptyUsernameAndPassword() {
        driver.get("http://admin:@the-internet.herokuapp.com/basic_auth/");
    }
}
