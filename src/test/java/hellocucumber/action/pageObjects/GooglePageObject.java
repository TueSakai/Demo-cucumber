package hellocucumber.action.pageObjects;

import hellocucumber.action.commons.BasePage;
import hellocucumber.interfaces.Xpath;
import org.openqa.selenium.WebDriver;

public class GooglePageObject extends BasePage implements Xpath {
    private final WebDriver driver;

    public GooglePageObject(WebDriver driver) {
        this.driver = driver;
    }
    public void inputSearchTextBox(String value){
        waitForElementVisible(driver, search_text_box);
        sendKeyToElement(driver, search_text_box, value);
    }
    public void clickOnSearchButton(){
        waitForElementVisible(driver, search_button);
        clickToElement(driver, search_button);
    }
    public boolean checkSearchResult(String result){
        try {
            waitForElementVisible(driver, equal, result);
            return isElementDisplay(driver, equal, result);
        }
        catch (Exception e){
            return false;
        }
    }
}
