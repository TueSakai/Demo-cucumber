package hellocucumber;

import hellocucumber.action.commons.BaseTest;
import hellocucumber.action.pageObjects.GooglePageObject;
import io.cucumber.java.en.*;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;


public class StepDefinitions extends BaseTest {

    private WebDriver driver;
    private GooglePageObject googlePage;
    @Parameters({"browser", "url"})
    @Given("Get browser {string} with {string}")
    public void getBrowser(String browserName, String url) {
        driver = getBrowserDriver(browserName,url);
        googlePage = new GooglePageObject(driver);
    }
    @When("Input keyword: {string}")
    public void inputKeyword(String keyword){
        googlePage.inputSearchTextBox(keyword);
    }
    @When("Then click on search button")
    public void searchKeywork(){
        googlePage.clickOnSearchButton();
    }
    @Then("Verify search result: {string} display")
    public void checkResult(String result){
        verifyTrue(googlePage.checkSearchResult(result));
    }

    @Then("Close test case")
    public void afterTest(){
        driver.quit();
    }

}
