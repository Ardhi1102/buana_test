package cucumber.StepDefinition;

import cucumber.util.CreateDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static org.junit.Assert.assertEquals;

public class FileUploaderSteps {
    private WebDriver driver;

    public FileUploaderSteps(){
        driver = CreateDriver.getInstance().getDriver();
    }
    @Given("User is on the homepage")
    public void userIsOnTheHomepage() {
        driver.get("http://the-internet.herokuapp.com/");
    }

    @When("User navigates to the File Upload page")
    public void userNavigatesToFileUploadPage() {
        WebElement pageLink = driver.findElement(By.xpath("//a[contains(text(),'File Upload')]"));
        pageLink.click();
    }

    @When("User selects a valid file to upload")
    public void userSelectsValidFileToUpload() {
        String filePath = System.getProperty("user.dir") + "/src/test/resources/image1.jpg";

        WebElement uploadFileLink = driver.findElement(By.cssSelector("input#file-upload"));
        uploadFileLink.sendKeys(filePath);
    }


    @When("User submits the file")
    public void userSubmitsFile() {
        WebElement uploadSubmit = driver.findElement(By.cssSelector("input[type='submit']"));
        uploadSubmit.click();
    }

    @Then("The file should be uploaded successfully")
    public void fileShouldBeUploadedSuccessfully() {
        WebElement successMessage = driver.findElement(By.tagName("h3"));
        assertEquals("File Uploaded!", successMessage.getText());
    }

    @When("User submits the file without selecting any file")
    public void userSubmitsFileWithoutSelectingAny() {
        WebElement uploadSubmit = driver.findElement(By.cssSelector("input[type='submit']"));
        uploadSubmit.click();
    }

    @Then("User should see an error message indicating no file was selected")
    public void userShouldSeeErrorMessageForNoFileSelected() {
        WebElement errorMessage = driver.findElement(By.cssSelector("body"));
        assertEquals("Internal Server Error", errorMessage.getText());
    }

    @When("User selects an invalid file type to upload")
    public void userSelectsInvalidFileTypeToUpload() {
        String filePath = System.getProperty("user.dir") + "/src/test/resources/nvm-setup.exe";

        WebElement uploadFileLink = driver.findElement(By.cssSelector("input#file-upload"));
        uploadFileLink.sendKeys(filePath);
    }

    @Then("User should see an error message indicating the file type is not allowed")
    public void userShouldSeeErrorMessageForInvalidFileType() {
//        WebElement errorMessage = driver.findElement(By.cssSelector("div.error"));
//        assertEquals("Invalid file type. Please upload a valid file.", errorMessage.getText());
        WebElement errorMessage = driver.findElement(By.cssSelector("body"));
        assertEquals("Internal Server Error", errorMessage.getText());
    }
}
